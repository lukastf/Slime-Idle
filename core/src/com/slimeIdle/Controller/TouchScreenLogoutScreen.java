package com.slimeIdle.Controller;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;

public class TouchScreenLogoutScreen {

    Buttons btn;
    Menu menu;
    FacebookLogin fbLogin;
    Account acc;

    public TouchScreenLogoutScreen(Buttons btn, Menu menu, FacebookLogin fbLogin, Account acc){
        this.btn = btn;
        this.menu = menu;
        this.fbLogin = fbLogin;
        this.acc = acc;
    }

    public void keyBack () {
        if(menu.isMenu_logout()){
            menu.setMenu_logout(false);
            menu.setMenu(false);
        }
    }

    public boolean touch(){

        if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            fbLogin.getlogout();
            acc.logout();

            menu.setMenu_logout(false);
            menu.setMenu(false);
            acc.setLoginScreen(false);
            acc.setCreateAccount(false);
        }

        if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            menu.setMenu_logout(false);
            menu.setMenu(false);
        }

        return false;
    }

}
