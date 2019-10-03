package com.slimeIdle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Slime extends ApplicationAdapter {

	VariablesDeclaration vd = new VariablesDeclaration();

    SocketSlime socketSlime = new SocketSlime(vd);
    FacebookLogin fbLogin = new FacebookLogin(vd, socketSlime);
    CommonLogin cmLogin = new CommonLogin(vd, socketSlime);
    InputListener listener = new InputListener(vd);
    TouchScreen touchScreen = new TouchScreen(vd, socketSlime, fbLogin, listener);

	// renders
	Render render = new Render(vd);
	Loader loader = new Loader(vd, render);
	RenderMenssages renderMenssages = new RenderMenssages(vd);
	RenderCart renderCart = new RenderCart(vd, render, renderMenssages);
	RenderCoin renderCoin = new RenderCoin(vd, render, renderMenssages);
	RenderTopLevel renderTopLevel = new RenderTopLevel(vd,render);
	RenderLoginScreen renderLoginScreen = new RenderLoginScreen(vd,render,renderMenssages);

	
	@Override
	public void create () {
		//Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		vd.purchaseManager.install(new PurchaseObserver(socketSlime), vd.pmc, true);

		vd.addCreateAccountStrings();

		/* create preferences to store autologin options */
		vd.setPrefs(Gdx.app.getPreferences("gdx-facebook-app-data.txt"));
		vd.permissionsRead();

		vd.w = Gdx.graphics.getWidth();
		vd.h = Gdx.graphics.getHeight();
		vd.camera = new OrthographicCamera(vd.w, vd.h);
		vd.camera.position.set(vd.w/2, vd.h/2, 0);
		vd.camera.update();

		vd.batch = new SpriteBatch();

		loader.getTextures();
		loader.getButtons();
		loader.getSprites();
		loader.getFonts();
		loader.getControllers();

		touchScreen.touchScreen();

		fbLogin.configFacebook();
	}

	@Override
	public void pause () {
		if(vd.isLogin()){
			vd.loginPause = true;
		}
	}

	@Override
	public void resume () {
		if(vd.loginPause){
			vd.setLogin(true);
		}
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		vd.batch.begin();

		vd.getPrefs().putBoolean("autosignin", true);
		vd.getPrefs().flush();

		fbLogin.getAutoLogin();
		cmLogin.getAutoLogin();

		if(vd.isLogin() || vd.loginPause == true) {
            if(vd.getNickname().isEmpty() || vd.isSetNicknameSuccess() || vd.isSetNicknameError()) {
                //vd.batch.draw(vd.background_menu, 1, 1);
                vd.closeWindowBtn.draw(vd.batch);

                if(!vd.isSetNicknameSuccess() && !vd.isSetNicknameError()) {

                	render.titleScreen("Your Nickname");

					vd.itemMenuBtns.get(1).draw(vd.batch);
					render.itemMenuBtnsSimpleText1(vd.createAccountStrings.get(1));

					vd.itemMenuBtns.get(2).draw(vd.batch);
					render.itemMenuBtnsSimpleText2("Ok");

				}

				if(vd.isSetNicknameError()){
                	renderMenssages.messageError("Error at", "choose nickname");
				}

				if(vd.isSetNicknameSuccess()){
                	renderMenssages.messageSuccess("Successfully", "nickname chosen");
				}

            } else {

                if (vd.isConectado()) {

                    //vd.renderItemsShopSprites();

                    if (vd.isMenu()) {
                        //vd.batch.draw(vd.background_menu, 1, 1);
                        if (!vd.isMenu_item_BuySuccess() && !vd.isMenu_item_BuyError_ready() && !vd.isMenu_item_BuyError_money()) {
                            vd.closeWindowBtn.draw(vd.batch);
                        }
                        if (vd.isMenu_cart()) {
                            renderCart.render();
                        }
                        if (vd.isMenu_coin()) {
                            renderCoin.render();
                        }
                        if (vd.isMenu_topLevel()) {
                            renderTopLevel.render();
                        }
                    } else {

						render.nicknameLevelAndTimer();

                        //slime
                        vd.slimeSpr.draw(vd.batch);

                        if (vd.getItemEquippedId() != 0 && vd.itemsShopSprites.size() != 0) {
                            vd.renderItemsEquipped(true);
                        }

                        vd.closeWindowBtn.draw(vd.batch);

                        vd.cartBtn.draw(vd.batch);
                        vd.coinBtn.draw(vd.batch);
                        vd.topLevelBtn.draw(vd.batch);

                        if(vd.freeCoin){
							render.addFreeCoin();
						}

                    }

                } else {
                    vd.reconnectWindowSpr.draw(vd.batch);
                }
            }
		} else {

			if (vd.isLoginScreen()) {
				renderLoginScreen.render();
			} else {

				//title game
				render.titleGame("Slime Idle");

				//slime
				vd.slimeSpr.draw(vd.batch);

				// buttons
				vd.itemMenuBtns.get(4).draw(vd.batch);
				render.itemMenuBtnsSimpleText4("Login");

				vd.loginButtonBtn.draw(vd.batch);
			}
		}

		vd.batch.end();
	}
	
	@Override
	public void dispose () {
		vd.variablesDispose();
	}
}
