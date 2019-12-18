package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.PurchaseManager;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.TopLevel;

public class TouchScreen {

    Menu menu;
    Account acc;
    Buttons btn;
    SocketSlime socketSlime;
    FacebookLogin fbLogin;
    InputListener listener;
    Item item;
    com.slimeIdle.Model.Slime slime;
    Shop shop;
    PurchaseManager purchaseManager;
    TopLevel topLevel;
    Coin coin;
    Encryption encryption;
    Loader loader;

    TouchScreenSlime touchScreenSlime;
    TouchScreenMenu touchScreenMenu;
    TouchScreenLanguage touchScreenLanguage;
    TouchScreenBackgroundShop touchScreenBackgroundShop;
    TouchScreenSlimeColorShop touchScreenSlimeColorShop;
    TouchScreenCartShop touchScreenCartShop;
    TouchScreenCoinShop touchScreenCoinShop;
    TouchScreenTopLevel touchScreenTopLevel;
    TouchScreenLoginScreen touchScreenLoginScreen;
    TouchScreenLogoutScreen touchScreenLogoutScreen;


    public TouchScreen(
            Menu menu,
            Account acc,
            Buttons btn,
            SocketSlime socketSlime,
            FacebookLogin fbLogin,
            InputListener listener,
            Item item,
            com.slimeIdle.Model.Slime slime,
            Shop shop,
            PurchaseManager purchaseManager,
            TopLevel topLevel,
            Coin coin,
            Encryption encryption,
            Loader loader){

        this.menu = menu;
        this.acc = acc;
        this.btn = btn;
        this.socketSlime = socketSlime;
        this.fbLogin = fbLogin;
        this.listener = listener;
        this.item = item;
        this.slime = slime;
        this.shop = shop;
        this.purchaseManager = purchaseManager;
        this.topLevel = topLevel;
        this.coin = coin;
        this.encryption = encryption;
        this.loader = loader;
    }



    public void touchScreen() {

        touchScreenSlime = new TouchScreenSlime(btn,fbLogin,acc,menu,socketSlime,slime,coin);
        touchScreenMenu = new TouchScreenMenu(acc,btn,fbLogin,menu,item,socketSlime,listener);
        touchScreenBackgroundShop = new TouchScreenBackgroundShop(slime, menu, btn, item, shop, socketSlime);
        touchScreenSlimeColorShop = new TouchScreenSlimeColorShop(slime, menu, btn, item, shop, socketSlime);
        touchScreenCartShop = new TouchScreenCartShop(slime, menu, btn, item, shop, socketSlime);
        touchScreenCoinShop = new TouchScreenCoinShop(btn, menu,socketSlime,purchaseManager);
        touchScreenTopLevel = new TouchScreenTopLevel(btn, menu, topLevel);
        touchScreenLoginScreen = new TouchScreenLoginScreen(acc, btn, socketSlime, listener, item, encryption);
        touchScreenLanguage = new TouchScreenLanguage(slime, menu, btn, item, shop, socketSlime,loader,acc);
        touchScreenLogoutScreen = new TouchScreenLogoutScreen(btn,menu,fbLogin,acc);

        // touch screen
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean keyDown(int keycode) {

                if(keycode == Input.Keys.BACK){

                    touchScreenLogoutScreen.keyBack();
                    touchScreenLanguage.keyBack();
                    touchScreenLoginScreen.keyBack();
                    touchScreenCartShop.keyBack();
                    touchScreenTopLevel.keyBack();
                    touchScreenCoinShop.keyBack();
                    touchScreenMenu.keyBack();
                    touchScreenBackgroundShop.keyBack();
                    touchScreenSlimeColorShop.keyBack();
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                if(acc.isLogin() || acc.loginPause == true) {

                    if (touchScreenMenu.checkNickname()) return true;
                    if (touchScreenMenu.menu(
                            touchScreenBackgroundShop,touchScreenSlimeColorShop,
                            touchScreenCartShop,touchScreenCoinShop,touchScreenTopLevel,
                            touchScreenLanguage, touchScreenLogoutScreen)) return true;
                    if(touchScreenSlime.buttonsCollision()) return true;
                    return true;
                }

                if (touchScreenMenu.menu(
                        touchScreenBackgroundShop,touchScreenSlimeColorShop,
                        touchScreenCartShop,touchScreenCoinShop,touchScreenTopLevel,
                        touchScreenLanguage, touchScreenLogoutScreen)) return true;



                /*
                if (btn.buttonCloseCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    menu.setMenu(false);
                    touchScreenMenu.closeButton();
                    return true;
                }*/

                if(touchScreenLoginScreen.touch()) return true;

                if (btn.buttonLanguageCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    menu.setMenu(true);
                    menu.setMenu_language(true);
                    return true;
                }

                touchScreenSlime.buttonsCollisionLogin();

                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                if(acc.isLogin() || acc.loginPause == true) {
                    return true;
                }

                if (!acc.isLoginScreen()) {
                    slime.stateSleep = false;
                }

                return true;
            }
        });
    }
}
