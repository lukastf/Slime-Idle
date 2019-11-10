package com.slimeIdle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.slimeIdle.Controller.CommonLogin;
import com.slimeIdle.Controller.FacebookLogin;
import com.slimeIdle.Controller.InputListener;
import com.slimeIdle.Controller.Loader;
import com.slimeIdle.Controller.PurchaseObserver;
import com.slimeIdle.Controller.TouchScreen;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Cart;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.PurchaseManager;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;
import com.slimeIdle.Model.Window;
import com.slimeIdle.View.AllTextStrings;
import com.slimeIdle.View.Render;
import com.slimeIdle.View.RenderCart;
import com.slimeIdle.View.RenderCoin;
import com.slimeIdle.View.RenderItems;
import com.slimeIdle.View.RenderLoginScreen;
import com.slimeIdle.View.RenderMessages;
import com.slimeIdle.View.RenderTopLevel;

public class Slime extends ApplicationAdapter {

	Font font = new Font();
	Account account = new Account();
	com.slimeIdle.Model.Slime slime = new com.slimeIdle.Model.Slime();
	Coin coin = new Coin();
	Shop shop = new Shop();
	TopLevel topLevel = new TopLevel();
	Menu menu = new Menu();
	Item item = new Item();
	Encryption encryption = new Encryption();
	Buttons btns = new Buttons();
	PurchaseManager purchaseManager = new PurchaseManager();
	Window window = new Window();
	Cart cart = new Cart();
	RenderItems renderItems = new RenderItems(slime,topLevel,shop);

    SocketSlime socketSlime = new SocketSlime(account, slime,coin,shop, topLevel,menu,item, encryption);
    FacebookLogin fbLogin = new FacebookLogin(account, socketSlime, encryption);
    CommonLogin cmLogin = new CommonLogin(account, socketSlime, encryption);
    InputListener listener = new InputListener(account,item,encryption);
    TouchScreen touchScreen = new TouchScreen(menu,account, btns, socketSlime, fbLogin, listener, item, slime, shop, purchaseManager, topLevel, coin, encryption);

	// renders
	Render render = new Render(btns, account, font, slime, coin);
	Loader loader = new Loader(btns, render, account,window,slime,cart,coin,topLevel,menu,shop,font);
	RenderMessages renderMessages = new RenderMessages(window, font, btns);
	RenderCart renderCart = new RenderCart(menu, shop, render, renderMessages, item, slime, btns, coin);
	RenderCoin renderCoin = new RenderCoin(btns, render, renderMessages, coin);
	RenderTopLevel renderTopLevel = new RenderTopLevel(menu,render, topLevel, btns, slime, shop,renderItems);
	RenderLoginScreen renderLoginScreen = new RenderLoginScreen(account,render, renderMessages, btns);

	
	@Override
	public void create () {

		//Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		purchaseManager.purchaseManager.install(new PurchaseObserver(socketSlime), purchaseManager.pmc, true);

		account.addCreateAccountStrings();

		/* create preferences to store autologin options */
		account.setPrefs(Gdx.app.getPreferences("gdx-facebook-app-data.txt"));
		account.permissionsRead();

		Static.w = Gdx.graphics.getWidth();
		Static.h = Gdx.graphics.getHeight();
		Static.camera = new OrthographicCamera(Static.w, Static.h);
		Static.camera.position.set(Static.w/2, Static.h/2, 0);
		Static.camera.update();

		Static.batch = new SpriteBatch();

		loader.getTextures();
		loader.getButtons();
		loader.getSprites();
        loader.loadFonts();
		loader.getFonts();
		loader.getControllers();

		touchScreen.touchScreen();

		fbLogin.configFacebook();
	}

	@Override
	public void pause () {
		if(account.isLogin()){
			account.loginPause = true;
		}
	}

	@Override
	public void resume () {
		if(account.loginPause){
			account.setLogin(true);
		}
	}

	@Override
	public void render () {

	    //System.out.println("oi");

		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Static.batch.begin();

		account.getPrefs().putBoolean("autosignin", true);
		account.getPrefs().flush();

		fbLogin.getAutoLogin();
		cmLogin.getAutoLogin();

		if(account.isLogin() || account.loginPause == true) {
            if(account.getNickname().isEmpty() || account.isSetNicknameSuccess() || account.isSetNicknameError()) {
                //vd.batch.draw(vd.background_menu, 1, 1);
                btns.closeWindowBtn.draw(Static.batch);

                if(!account.isSetNicknameSuccess() && !account.isSetNicknameError()) {

                	render.titleScreen(AllTextStrings.yourNickname);

					btns.itemMenuBtns.get(1).draw(Static.batch);
					render.itemMenuBtnsSimpleText(account.createAccountStrings.get(1), 1);

					btns.itemMenuBtns.get(2).draw(Static.batch);
					render.itemMenuBtnsSimpleText(AllTextStrings.ok, 2);

				}

				if(account.isSetNicknameError()){
                	renderMessages.messageError(AllTextStrings.errorNickname[0], AllTextStrings.errorNickname[1]);
				}

				if(account.isSetNicknameSuccess()){
                	renderMessages.messageSuccess(AllTextStrings.successNickname[0], AllTextStrings.successNickname[1]);
				}

            } else {

                if (account.isConectado()) {

                    //vd.renderItemsShopSprites();

                    if (menu.isMenu()) {
                        //vd.batch.draw(vd.background_menu, 1, 1);
                        if (!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {
                            btns.closeWindowBtn.draw(Static.batch);
                        }
                        if (menu.isMenu_cart()) {
                            renderCart.render();
                        }
                        if (menu.isMenu_coin()) {
                            renderCoin.render();
                        }
                        if (menu.isMenu_topLevel()) {
                            renderTopLevel.render();
                        }
                    } else {

						render.nicknameLevelAndTimer();

                        //slime
                        slime.slimeSpr.draw(Static.batch);

                        if (slime.getItemEquippedId() != 0 && shop.itemsShopSprites.size() != 0) {
                            renderItems.renderItemsEquipped(true);
                        }

                        btns.closeWindowBtn.draw(Static.batch);

                        btns.cartBtn.draw(Static.batch);
                        btns.coinBtn.draw(Static.batch);
                        btns.topLevelBtn.draw(Static.batch);

                        if(coin.freeCoin){
							render.addFreeCoin();
						}

                    }

                } else {
                    window.reconnectWindowSpr.draw(Static.batch);
                }
            }
		} else {

			if (account.isLoginScreen()) {
				renderLoginScreen.render();
			} else {

				//title game
				render.titleGame(AllTextStrings.titleGame);

				//slime
				slime.slimeSpr.draw(Static.batch);

				// buttons
				btns.itemMenuBtns.get(4).draw(Static.batch);
				render.itemMenuBtnsSimpleText(AllTextStrings.login, 4);

				btns.loginButtonBtn.draw(Static.batch);
			}
		}

		Static.batch.end();
	}
	
	@Override
	public void dispose () {
		btns.dispose();
		window.dispose();
		cart.dispose();
		coin.dispose();
		topLevel.dispose();
		Static.dispose();
		slime.dispose();
		font.dispose();
		purchaseManager.dispose();

	}
}
