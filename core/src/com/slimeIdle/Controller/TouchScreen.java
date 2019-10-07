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
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;
import com.slimeIdle.Slime;

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
            Encryption encryption){

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
    }

    public void touchScreen() {
        // touch screen
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.BACK){

                    //cart
                    if(menu.isMenu_cart()){
                        if(menu.isMenu_item_selecionado()){
                            menu.setMenu_item_selecionado(false);
                        } else {
                            menu.setMenu_cart(false);
                            menu.setMenu(false);
                        }
                    }

                    // top level
                    if(menu.isMenu_topLevel()){
                        if(menu.isMenu_topLevel_PlayerSelecionado()){
                            menu.setMenu_topLevel_PlayerSelecionado(false);
                        } else {
                            menu.setMenu_topLevel(false);
                            menu.setMenu(false);
                        }
                    }

                    //coin
                    if(menu.isMenu_coin()){
                        menu.setMenu_coin(false);
                        menu.setMenu(false);
                    }

                    menu.setMenu_item_BuySuccess(false);
                    menu.setMenu_item_BuyError_ready(false);
                    menu.setMenu_item_BuyError_money(false);
                    menu.setMenuCurrentPage(1);
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(acc.isLogin() || acc.loginPause == true) {
                    if(acc.getNickname().isEmpty() || acc.isSetNicknameSuccess() || acc.isSetNicknameError()) {

                        if(!acc.isSetNicknameSuccess() && !acc.isSetNicknameError()) {
                            if (btn.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((Static.h / 2.3) * 2)))) {
                                fbLogin.getlogout();
                                acc.logout();
                            }

                            if (btn.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((Static.h / 8) * 2))) {
                                item.setItemSelecionado(1);
                                Gdx.input.getTextInput(listener, "Nickname", "", "Insert your Nickname");
                            }

                            if (btn.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)) {
                                socketSlime.setNickname();
                            }
                        }
                        if(acc.isSetNicknameSuccess() || acc.isSetNicknameError()) {
                            if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){
                                acc.setSetNicknameSuccess(false);
                                acc.setSetNicknameError(false);
                            }
                        }


                    } else {
                        if (menu.isMenu()) {
                            if (!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {
                                if (btn.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((Static.h / 2.3) * 2)))) {
                                    menu.setMenu(false);
                                    menu.setMenu_cart(false);
                                    menu.setMenu_coin(false);
                                    menu.setMenu_topLevel(false);
                                    menu.setMenu_topLevel_PlayerSelecionado(false);
                                    menu.setMenu_item_selecionado(false);
                                    menu.setMenu_item_BuySuccess(false);
                                    menu.setMenu_item_BuyError_ready(false);
                                    menu.setMenu_item_BuyError_money(false);
                                    menu.setMenuCurrentPage(1);
                                    return true;
                                }
                            }
                            if (menu.isMenu_cart()) {
                                TouchScreenCart touchScreenCart = new TouchScreenCart(slime, menu, btn, item, shop, socketSlime, screenX, screenY);
                                touchScreenCart.touch();
                            }
                            if (menu.isMenu_coin()) {
                                TouchScreenCoin touchScreenCoin = new TouchScreenCoin(btn, socketSlime, purchaseManager, screenX, screenY);
                                touchScreenCoin.touch();
                            }
                            if (menu.isMenu_topLevel()) {
                                TouchScreenTopLevel touchScreenTopLevel = new TouchScreenTopLevel(btn, menu, topLevel,screenX, screenY);
                                touchScreenTopLevel.touch();
                            }

                        } else {

                            if (btn.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((Static.h / 2.3) * 2)))) {
                                fbLogin.getlogout();
                                acc.logout();
                                return true;
                            }

                            if (btn.cartBtn.getBoundingRectangle().contains(screenX, screenY - ((Static.h / 3) * 2))) {
                                menu.setMenu(true);
                                menu.setMenu_cart(true);
                                return true;
                            }

                            if (btn.coinBtn.getBoundingRectangle().contains(screenX, screenY - ((Static.h / 3) * 2))) {
                                menu.setMenu(true);
                                menu.setMenu_coin(true);
                                return true;
                            }

                            if (btn.topLevelBtn.getBoundingRectangle().contains(screenX, screenY - ((Static.h / 3) * 2))) {
                                menu.setMenu(true);
                                menu.setMenu_topLevel(true);
                                socketSlime.topLevel();
                                return true;
                            }
                            if(slime.getLastTimeTouch().contains("READY!")){
                                coin.freeCoin = true;
                            }

                            socketSlime.screenPressed();
                        }
                    }
                } else {

                    if (acc.isLoginScreen()) {
                        TouchScreenLoginScreen touchScreenLoginScreen = new TouchScreenLoginScreen(acc, btn, socketSlime, screenX, screenY, listener, item, encryption);
                        touchScreenLoginScreen.touch();
                    } else {

                        if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){
                            acc.setLoginScreen(true);
                        }

                        if (btn.loginButtonBtn.getBoundingRectangle().contains(screenX, screenY - ((float)(Static.h / 2.5) * 2))) {
                            fbLogin.getlogin();
                            return true;
                        }
                    }

                }

                return true;
            }
        });
    }
}
