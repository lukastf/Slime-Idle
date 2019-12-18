package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.PurchaseManager;
import com.slimeIdle.Model.SocketSlime;

public class TouchScreenCoinShop {

    Buttons btn;
    Menu menu;
    SocketSlime socketSlime;
    PurchaseManager purchaseManager;
    //private float screenX;
    //private float screenY;

    public TouchScreenCoinShop(Buttons btn, Menu menu, SocketSlime socketSlime, PurchaseManager purchaseManager/*, float screenX, float screenY*/){
        this.btn = btn;
        this.menu = menu;
        this.socketSlime = socketSlime;
        this.purchaseManager = purchaseManager;
        //this.screenX = screenX;
        //this.screenY = screenY;
    }

    public void keyBack () {
        if(menu.isMenu_coin()){
            menu.setMenu_coin(false);
            menu.setMenu(false);
        }
    }

    public boolean touch(){

        if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            purchaseManager.purchaseManager.purchase("1");
        }
        if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            purchaseManager.purchaseManager.purchase("2");
        }

        if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            purchaseManager.purchaseManager.purchase("3");
        }

        if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            purchaseManager.purchaseManager.purchase("4");
        }

        if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {
            purchaseManager.purchaseManager.purchase("5");
        }

        return false;
    }
}
