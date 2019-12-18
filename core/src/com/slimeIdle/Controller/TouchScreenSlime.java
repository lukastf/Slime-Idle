package com.slimeIdle.Controller;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.SocketSlime;

public class TouchScreenSlime {

    Buttons btn;
    FacebookLogin fbLogin;
    Account acc;
    Menu menu;
    SocketSlime socketSlime;
    Slime slime;
    Coin coin;

    public TouchScreenSlime(Buttons btn, FacebookLogin fbLogin, Account acc, Menu menu,
                            SocketSlime socketSlime, Slime slime, Coin coin) {

        this.btn = btn;
        this.fbLogin = fbLogin;
        this.acc = acc;
        this.menu = menu;
        this.socketSlime = socketSlime;
        this.slime = slime;
        this.coin = coin;
    }

    public boolean buttonsCollision () {

        if (btn.buttonCloseCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_logout(true);
            return true;
        }

        if (btn.buttonLanguageCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_language(true);
            return true;
        }

        if (btn.buttonBackgroundCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_background(true);
            return true;
        }

        if (btn.buttonSlimeColorCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_slime_color(true);
            return true;
        }

        if (btn.buttonCartCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_cart(true);
            return true;
        }

        if (btn.buttonCoinCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_coin(true);
            return true;
        }

        if (btn.buttonTopLevelCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu(true);
            menu.setMenu_topLevel(true);
            socketSlime.topLevel();
            return true;
        }

        //if(slime.getLastTimeTouch().contains("READY!")){
           // coin.freeCoin = true;
        //}



        for (int i = 0; i < slime.touchScreenSecondsController.size(); i++) {
            //render.touchScreenSeconds(i);
            if(i == 0) {
                if(!slime.touchScreenSecondsController.get(i)) {
                    slime.touchScreenSecondsController.set(i, true);
                }
            } else {
                if(!slime.touchScreenSecondsController.get(i)
                        && slime.touchScreenSecondsTouchPointController.get(i -1)) {
                    slime.touchScreenSecondsController.set(i, true);
                }
            }
        }

        /*
        if(!slime.touchScreenSecondsController.get(1) && slime.touchScreenSecondsTouchPointController.get(0)) {
            slime.touchScreenSecondsController.set(1, true);
        }

        if(!slime.touchScreenSecondsController.get(2) && slime.touchScreenSecondsTouchPointController.get(1)) {
            slime.touchScreenSecondsController.set(2, true);
        }

        if(!slime.touchScreenSecondsController.get(3) && slime.touchScreenSecondsTouchPointController.get(2)) {
            slime.touchScreenSecondsController.set(3, true);
        }

        if(!slime.touchScreenSecondsController.get(4) && slime.touchScreenSecondsTouchPointController.get(3)) {
            slime.touchScreenSecondsController.set(4, true);
        }*/



        socketSlime.screenPressed();

        return false;
    }

    public void buttonsCollisionLogin () {

        if (btn.buttonLoginFaceCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            fbLogin.getlogin();
            //return true;
        }

        if (btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            acc.setLoginScreen(true);
            //return true;
        }

        slime.stateSleep = true;
    }
}
