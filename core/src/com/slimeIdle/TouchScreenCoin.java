package com.slimeIdle;

public class TouchScreenCoin {

    VariablesDeclaration vd;
    SocketSlime socketSlime;
    private float screenX;
    private float screenY;

    public TouchScreenCoin(VariablesDeclaration vdRecebido, SocketSlime socketSlimeRecebido, float screenXRecebido, float screenYRecebido){
        vd = vdRecebido;
        socketSlime = socketSlimeRecebido;
        screenX = screenXRecebido;
        screenY = screenYRecebido;
    }

    public boolean touch(){

        if(vd.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((vd.h/4) * 2))){
            vd.purchaseManager.purchase("1");
        }
        if(vd.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((vd.h/8) * 2))){
            vd.purchaseManager.purchase("2");
        }

        if(vd.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)){
            vd.purchaseManager.purchase("3");
        }

        if(vd.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((vd.h/8) * 2))){
            vd.purchaseManager.purchase("4");
        }

        if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){
            vd.purchaseManager.purchase("5");
        }

        return true;
    }
}
