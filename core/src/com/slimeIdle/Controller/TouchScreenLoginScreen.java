package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.View.AllTextStringsLanguages;

public class TouchScreenLoginScreen {
    Account acc;
    Buttons btn;
    SocketSlime socketSlime;
    //private float screenX;
    //private float screenY;
    InputListener listener;
    Item item;
    Encryption encryption;

    public TouchScreenLoginScreen(
            Account acc,
            Buttons btn,
            SocketSlime socketSlime,
            //float screenX,
            //float screenY,
            InputListener listener,
            Item item,
            Encryption encryption){

        this.acc = acc;
        this.btn = btn;
        this.socketSlime = socketSlime;
        //this.screenX = screenX;
        //this.screenY = screenY;
        this.listener = listener;
        this.item = item;
        this.encryption = encryption;
    }

    public void keyBack () {
        if(acc.isLoginScreen()){
            if(acc.isCreateAccount()){
                acc.setCreateAccount(false);
            } else {
                acc.setLoginScreen(false);
                //menu.setMenu(false);
            }
        }
    }

    public boolean touch(){

        if (acc.isLoginScreen()) {

            if (!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()
                    && !acc.isLoginSuccess() && !acc.isLoginError()) {
                if (btn.buttonCloseCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    acc.setLoginScreen(false);
                    acc.setCreateAccount(false);
                    return true;
                }
            }
            if (acc.isCreateAccount()) {

                if (!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()) {

                    if (btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        acc.setCreateAccount(false);
                    }


                    //if (btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    //    item.setItemId(0);
                    //Gdx.input.getTextInput(listener, AllTextStringsLanguages.name, "", AllTextStringsLanguages.insertYourName);
                    //}

                    if (btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        item.setItemId(1);
                        Gdx.input.getTextInput(listener, AllTextStringsLanguages.nickname, "", AllTextStringsLanguages.insertYourNickname);
                    }

                    if (btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        item.setItemId(2);
                        Gdx.input.getTextInput(listener, AllTextStringsLanguages.password, "", AllTextStringsLanguages.insertYourPassword);
                    }

                    if (btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        item.setItemId(3);
                        Gdx.input.getTextInput(listener, AllTextStringsLanguages.passwordAgain, "", AllTextStringsLanguages.insertYourPasswordAgain);
                    }

                    if (btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                        if (acc.createAccountStrings.get(3).matches(acc.createAccountStrings.get(4))) {
                            socketSlime.createAccount();
                        } else {
                            acc.setCreateAccountErrorPass(true);
                        }

                    }

                    return true;

                }
                if (acc.isCreateAccountSuccess() || acc.isCreateAccountError() || acc.isCreateAccountErrorPass()) {
                    if (btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        acc.setCreateAccountSuccess(false);
                        acc.setCreateAccountError(false);
                        acc.setCreateAccountErrorPass(false);
                    }
                }

            } else {

                if (!acc.isLoginSuccess() && !acc.isLoginError()) {
                    if (btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        item.setItemId(-1);
                        Gdx.input.getTextInput(listener, AllTextStringsLanguages.nickname, "", AllTextStringsLanguages.insertYourNickname);
                    }

                    if (btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        item.setItemId(-2);
                        Gdx.input.getTextInput(listener, AllTextStringsLanguages.password, "", AllTextStringsLanguages.insertYourPassword);
                    }

                    if (btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        acc.pass = encryption.encryptIn2(encryption.decrypt(acc.getPassword()));
                        socketSlime.loginAccount();
                    }

                    if (btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        acc.setCreateAccount(true);
                    }

                    return true;

                }
                if (acc.isLoginSuccess() || acc.isLoginError()) {

                    if (btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                        if (acc.isLoginSuccess() && !acc.isLoginError()) {
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

        return false;
    }
}
