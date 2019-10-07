package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.Static;

public class TouchScreenLoginScreen {
    Account acc;
    Buttons btn;
    SocketSlime socketSlime;
    private float screenX;
    private float screenY;
    InputListener listener;
    Item item;
    Encryption encryption;

    public TouchScreenLoginScreen(
            Account acc,
            Buttons btn,
            SocketSlime socketSlime,
            float screenX,
            float screenY,
            InputListener listener,
            Item item,
            Encryption encryption){

        this.acc = acc;
        this.btn = btn;
        this.socketSlime = socketSlime;
        this.screenX = screenX;
        this.screenY = screenY;
        this.listener = listener;
        this.item = item;
        this.encryption = encryption;
    }

    public boolean touch(){

        if(!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()
                && !acc.isLoginSuccess() && !acc.isLoginError()){
            if (btn.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((Static.h / 2.3) * 2)))) {
                acc.setLoginScreen(false);
                acc.setCreateAccount(false);
                return true;
            }
        }
        if(acc.isCreateAccount()){

            if(!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()) {

                if (btn.backBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5) * 2)))) {
                    acc.setCreateAccount(false);
                }


                if (btn.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((Static.h / 4) * 2))) {
                    item.setItemSelecionado(0);
                    Gdx.input.getTextInput(listener, "Name", "", "Insert your Name");
                }

                if (btn.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((Static.h / 8) * 2))) {
                    item.setItemSelecionado(1);
                    Gdx.input.getTextInput(listener, "Nickname", "", "Insert your Nickname");
                }

                if (btn.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)) {
                    item.setItemSelecionado(2);
                    Gdx.input.getTextInput(listener, "Password", "", "Insert your Password");
                }

                if (btn.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((Static.h / 8) * 2))) {
                    item.setItemSelecionado(3);
                    Gdx.input.getTextInput(listener, "re-enter Password", "", "Insert your Password again");
                }

                if (btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h / 4) * 2))) {

                    if (acc.createAccountStrings.get(2).matches(acc.createAccountStrings.get(3))) {
                        socketSlime.createAccount();
                    } else {
                        acc.setCreateAccountErrorPass(true);
                    }

                }

                return true;

            }
            if(acc.isCreateAccountSuccess() || acc.isCreateAccountError() || acc.isCreateAccountErrorPass()) {
                if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){
                    acc.setCreateAccountSuccess(false);
                    acc.setCreateAccountError(false);
                    acc.setCreateAccountErrorPass(false);
                }
            }

        } else {

            if(!acc.isLoginSuccess() && !acc.isLoginError()) {
                if (btn.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((Static.h / 8) * 2))) {
                    item.setItemSelecionado(-1);
                    Gdx.input.getTextInput(listener, "Nickname", "", "Insert your Nickname");
                }

                if (btn.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)) {
                    item.setItemSelecionado(-2);
                    Gdx.input.getTextInput(listener, "Password", "", "Insert your Password");
                }

                if (btn.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((Static.h / 8) * 2))) {
                    acc.pass = encryption.encryptIn2(encryption.decrypt(acc.getPassword()));
                    socketSlime.loginAccount();
                }

                if (btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h / 4) * 2))) {
                    acc.setCreateAccount(true);
                }

                return true;

            }
            if(acc.isLoginSuccess() || acc.isLoginError()) {
                if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){

                    if(acc.isLoginSuccess() && !acc.isLoginError()) {
                        socketSlime.connectSocket();
                        socketSlime.configSocketEvents();
                        acc.setLoginSuccess(false);
                        acc.setLogin(true);
                    }

                    acc.setLoginError(false);
                }
            }
        }

        return true;
    }
}
