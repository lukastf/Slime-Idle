package com.slimeIdle;

public class TouchScreenCart {

    VariablesDeclaration vd;
    SocketSlime socketSlime;
    private float screenX;
    private float screenY;

    public TouchScreenCart(VariablesDeclaration vdRecebido, SocketSlime socketSlimeRecebido, float screenXRecebido, float screenYRecebido){
        vd = vdRecebido;
        socketSlime = socketSlimeRecebido;
        screenX = screenXRecebido;
        screenY = screenYRecebido;
    }

    public boolean touch(){
        if(vd.isMenu_item_selecionado()) {
            if(!vd.isMenu_item_BuySuccess() && !vd.isMenu_item_BuyError_ready() && !vd.isMenu_item_BuyError_money()) {
                if (vd.backBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5) * 2)))) {
                    vd.setMenu_item_selecionado(false);
                }

                if (vd.getItemSelecionado() != 0 && vd.itemsShopBought.get(vd.getItemSelecionado())) {
                    if ( (vd.getItemEquippedId() * -1) + 1 == vd.getItemSelecionado() ||
                            vd.getItemEquippedId() + 5 == vd.getItemSelecionado()) {
                        if (vd.unequipBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5) * 2)))) {
                            socketSlime.unequipItem();
                        }
                    } else {
                        if (vd.equipBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5) * 2)))) {
                            socketSlime.equipItem();
                        }
                    }
                } else {
                    if (vd.buyBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5) * 2)))) {
                        socketSlime.buyItem();
                    }
                }
            }

            if(vd.isMenu_item_BuySuccess() || vd.isMenu_item_BuyError_ready() || vd.isMenu_item_BuyError_money()) {
                if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){
                    vd.setMenu_item_BuySuccess(false);
                    vd.setMenu_item_BuyError_ready(false);
                    vd.setMenu_item_BuyError_money(false);
                }
            }
            return true;
        }

        if(vd.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((vd.h/4) * 2))){

            vd.setMenu_item_selecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setItemSelecionado(0);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setItemSelecionado(5);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setItemSelecionado(10);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setItemSelecionado(15);
            }
            if(vd.getCurrentPage() == 5) {
                vd.setItemSelecionado(20);
            }
        }
        if(vd.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((vd.h/8) * 2))){

            vd.setMenu_item_selecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setItemSelecionado(1);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setItemSelecionado(6);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setItemSelecionado(11);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setItemSelecionado(16);
            }
            if(vd.getCurrentPage() == 5) {
                vd.setItemSelecionado(21);
            }
        }

        if(vd.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)){
            vd.setMenu_item_selecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setItemSelecionado(2);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setItemSelecionado(7);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setItemSelecionado(12);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setItemSelecionado(17);
            }
            if(vd.getCurrentPage() == 5) {
                vd.setItemSelecionado(22);
            }
        }

        if(vd.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((vd.h/8) * 2))){

            vd.setMenu_item_selecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setItemSelecionado(3);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setItemSelecionado(8);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setItemSelecionado(13);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setItemSelecionado(18);
            }
            if(vd.getCurrentPage() == 5) {
                vd.setItemSelecionado(23);
            }
        }

        if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){

            vd.setMenu_item_selecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setItemSelecionado(4);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setItemSelecionado(9);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setItemSelecionado(14);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setItemSelecionado(19);
            }
            if(vd.getCurrentPage() == 5) {
                vd.setItemSelecionado(24);
            }
        }

        if(vd.prevBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5)*2)))){
            if(vd.getCurrentPage() == 1) {
                return true;
            }
            vd.setCurrentPage(vd.getCurrentPage() - 1);
        }

        if(vd.nextBtn.getBoundingRectangle().contains(screenX,(float) (screenY - ((vd.h / 2.5)*2)))){
            if(vd.getCurrentPage() == 5) {
                return true;
            }
            vd.setCurrentPage(vd.getCurrentPage() + 1);
        }
        return true;
    }
}
