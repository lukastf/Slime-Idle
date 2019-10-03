package com.slimeIdle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class TouchScreen {

    VariablesDeclaration vd;
    SocketSlime socketSlime;
    FacebookLogin fbLogin;
    InputListener listener;

    public TouchScreen(VariablesDeclaration vdRecebido, SocketSlime socketSlimeRecebido, FacebookLogin fbLoginRecebido, InputListener listenerRecebido){
        vd = vdRecebido;
        socketSlime = socketSlimeRecebido;
        fbLogin = fbLoginRecebido;
        listener = listenerRecebido;
    }

    public void touchScreen() {
        // touch screen
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.BACK){

                    //cart
                    if(vd.isMenu_cart()){
                        if(vd.isMenu_item_selecionado()){
                            vd.setMenu_item_selecionado(false);
                        } else {
                            vd.setMenu_cart(false);
                            vd.setMenu(false);
                        }
                    }

                    // top level
                    if(vd.isMenu_topLevel()){
                        if(vd.isMenu_topLevel_PlayerSelecionado()){
                            vd.setMenu_topLevel_PlayerSelecionado(false);
                        } else {
                            vd.setMenu_topLevel(false);
                            vd.setMenu(false);
                        }
                    }

                    //coin
                    if(vd.isMenu_coin()){
                        vd.setMenu_coin(false);
                        vd.setMenu(false);
                    }

                    vd.setMenu_item_BuySuccess(false);
                    vd.setMenu_item_BuyError_ready(false);
                    vd.setMenu_item_BuyError_money(false);
                    vd.setCurrentPage(1);
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if(vd.isLogin() || vd.loginPause == true) {
                    if(vd.getNickname().isEmpty() || vd.isSetNicknameSuccess() || vd.isSetNicknameError()) {

                        if(!vd.isSetNicknameSuccess() && !vd.isSetNicknameError()) {
                            if (vd.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((vd.h / 2.3) * 2)))) {
                                fbLogin.getlogout();
                                vd.logout();
                            }

                            if (vd.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((vd.h / 8) * 2))) {
                                vd.setItemSelecionado(1);
                                Gdx.input.getTextInput(listener, "Nickname", "", "Insert your Nickname");
                            }

                            if (vd.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)) {
                                socketSlime.setNickname();
                            }
                        }
                        if(vd.isSetNicknameSuccess() || vd.isSetNicknameError()) {
                            if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){
                                vd.setSetNicknameSuccess(false);
                                vd.setSetNicknameError(false);
                            }
                        }


                    } else {
                        if (vd.isMenu()) {
                            if (!vd.isMenu_item_BuySuccess() && !vd.isMenu_item_BuyError_ready() && !vd.isMenu_item_BuyError_money()) {
                                if (vd.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((vd.h / 2.3) * 2)))) {
                                    vd.setMenu(false);
                                    vd.setMenu_cart(false);
                                    vd.setMenu_coin(false);
                                    vd.setMenu_topLevel(false);
                                    vd.setMenu_topLevel_PlayerSelecionado(false);
                                    vd.setMenu_item_selecionado(false);
                                    vd.setMenu_item_BuySuccess(false);
                                    vd.setMenu_item_BuyError_ready(false);
                                    vd.setMenu_item_BuyError_money(false);
                                    vd.setCurrentPage(1);
                                    return true;
                                }
                            }
                            if (vd.isMenu_cart()) {
                                TouchScreenCart touchScreenCart = new TouchScreenCart(vd, socketSlime, screenX, screenY);
                                touchScreenCart.touch();
                            }
                            if (vd.isMenu_coin()) {
                                TouchScreenCoin touchScreenCoin = new TouchScreenCoin(vd, socketSlime, screenX, screenY);
                                touchScreenCoin.touch();
                            }
                            if (vd.isMenu_topLevel()) {
                                TouchScreenTopLevel touchScreenTopLevel = new TouchScreenTopLevel(vd, screenX, screenY);
                                touchScreenTopLevel.touch();
                            }

                        } else {

                            if (vd.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((vd.h / 2.3) * 2)))) {
                                fbLogin.getlogout();
                                vd.logout();
                                return true;
                            }

                            if (vd.cartBtn.getBoundingRectangle().contains(screenX, screenY - ((vd.h / 3) * 2))) {
                                vd.setMenu(true);
                                vd.setMenu_cart(true);
                                return true;
                            }

                            if (vd.coinBtn.getBoundingRectangle().contains(screenX, screenY - ((vd.h / 3) * 2))) {
                                vd.setMenu(true);
                                vd.setMenu_coin(true);
                                return true;
                            }

                            if (vd.topLevelBtn.getBoundingRectangle().contains(screenX, screenY - ((vd.h / 3) * 2))) {
                                vd.setMenu(true);
                                vd.setMenu_topLevel(true);
                                socketSlime.topLevel();
                                return true;
                            }
                            if(vd.getLastTimeTouch().contains("READY!")){
                                vd.freeCoin = true;
                            }

                            socketSlime.screenPressed();
                        }
                    }
                } else {

                    if (vd.isLoginScreen()) {
                        TouchScreenLoginScreen touchScreenLoginScreen = new TouchScreenLoginScreen(vd, socketSlime, screenX, screenY, listener);
                        touchScreenLoginScreen.touch();
                    } else {

                        if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){
                            vd.setLoginScreen(true);
                        }

                        if (vd.loginButtonBtn.getBoundingRectangle().contains(screenX, screenY - ((float)(vd.h / 2.5) * 2))) {
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
