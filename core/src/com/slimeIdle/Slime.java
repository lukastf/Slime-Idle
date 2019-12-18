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
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Flags;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.PurchaseManager;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;
import com.slimeIdle.Model.Window;
import com.slimeIdle.View.AllTextStringsLanguages;
import com.slimeIdle.View.Render;
import com.slimeIdle.View.RenderItems;
import com.slimeIdle.View.RenderMenu;
import com.slimeIdle.View.RenderMessages;
import com.slimeIdle.View.RenderSlime;

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
	Flags flags = new Flags();
	RenderItems renderItems = new RenderItems(slime,topLevel,shop,item);

    SocketSlime socketSlime = new SocketSlime(account, slime,coin,shop, topLevel,menu,item, encryption);
    FacebookLogin fbLogin = new FacebookLogin(account, socketSlime, encryption);
    CommonLogin cmLogin = new CommonLogin(account, socketSlime, encryption);
    InputListener listener = new InputListener(account,item,encryption);

	Render render = new Render(btns, account, font, slime, coin);
	Loader loader = new Loader(btns, render, account,window,slime,coin,topLevel,menu,shop,font,flags);
	TouchScreen touchScreen = new TouchScreen(menu,account, btns, socketSlime, fbLogin, listener, item, slime, shop,
			purchaseManager, topLevel, coin, encryption,loader);

	RenderMessages renderMessages = new RenderMessages(window, font, btns, render);
	RenderMenu renderMenu = new RenderMenu(account,btns,render,renderMessages,menu,shop,renderItems,item,slime,coin,topLevel,flags);
	RenderSlime renderSlime = new RenderSlime(slime,render,renderItems,btns,coin);

	/*
	RenderCartShop renderCartShop = new RenderCartShop(menu, shop, render, renderMessages, renderItems, item, slime, btns, coin);
	RenderCoinShop renderCoinShop = new RenderCoinShop(btns, render, renderMessages, coin);
	RenderTopLevel renderTopLevel = new RenderTopLevel(menu,render, topLevel, btns, slime, shop,renderItems);
	RenderLoginScreen renderLoginScreen = new RenderLoginScreen(account,render, renderMessages, btns);

	RenderBackgroundShop renderBackgroundShop = new RenderBackgroundShop(menu,shop,render,renderMessages,renderItems,item,slime,btns,coin);
	RenderSlimeColorShop renderSlimeColorShop = new RenderSlimeColorShop(menu,shop,render,renderMessages,renderItems,item,slime,btns,coin);
	*/

	
	@Override
	public void create () {

		AllTextStringsLanguages.getAllTexts();

		Gdx.input.setCatchBackKey(true);
		purchaseManager.purchaseManager.install(new PurchaseObserver(socketSlime), purchaseManager.pmc, true);

		//account.addCreateAccountStrings();
		account.setPrefs(Gdx.app.getPreferences("gdx-facebook-app-data.txt"));
		account.permissionsRead();

		Static.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Static.cam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		Static.cam.update();

		Static.batch = new SpriteBatch();

		loader.loader();


		touchScreen.touchScreen();

		fbLogin.configFacebook();

		//fbLogin.getlogout();
		//account.logout();
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

		//loader.loadFonts();
		//loader.getFonts();

		Static.batch.begin();

		//loading screen
		//if (!loader.manager.update()) {

		   // window.drawReconnectWindow();
		    //Static.batch.end();
		   // return;
        //}

		//System.out.println("goku " + account.isConectado());

		Static.cam.unproject(btns.touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		account.getPrefs().putBoolean("autosignin", true);
		account.getPrefs().flush();

		fbLogin.getAutoLogin();
		cmLogin.getAutoLogin();

		//if(loader.flanderson()) return;

		if(account.isLogin() || account.loginPause == true) {

			if (account.isConectado()) {
				if(renderMenu.checkNickname()) return;
				if(renderMenu.menu()) return;
				if(renderSlime.mainGame()) return;
			}

			btns.drawCloseWindowBtn();
			window.drawReconnectWindow();
			Static.batch.end();
            return;
		}

		if(renderMenu.menu()) return;
		if(renderMenu.loginScreen()) return;
		if(renderSlime.loginScreen()) return;
	}
	
	@Override
	public void dispose () {
		btns.dispose();
		window.dispose();
		//coin.dispose();
		Static.dispose();
		slime.dispose();
		font.dispose();
		menu.dispose();
		purchaseManager.dispose();
		shop.dispose();

	}
}
