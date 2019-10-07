package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.PurchaseManager;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.Static;

public class TouchScreenCoin {

    Buttons btn;
    SocketSlime socketSlime;
    PurchaseManager purchaseManager;
    private float screenX;
    private float screenY;

    public TouchScreenCoin(Buttons btn, SocketSlime socketSlime, PurchaseManager purchaseManager, float screenX, float screenY){
        this.btn = btn;
        this.socketSlime = socketSlime;
        this.purchaseManager = purchaseManager;
        this.screenX = screenX;
        this.screenY = screenY;
    }

    public boolean touch(){

        if(btn.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((Static.h/4) * 2))){
            purchaseManager.purchaseManager.purchase("1");
        }
        if(btn.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((Static.h/8) * 2))){
            purchaseManager.purchaseManager.purchase("2");
        }

        if(btn.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)){
            purchaseManager.purchaseManager.purchase("3");
        }

        if(btn.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((Static.h/8) * 2))){
            purchaseManager.purchaseManager.purchase("4");
        }

        if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){
            purchaseManager.purchaseManager.purchase("5");
        }

        return true;
    }
}
