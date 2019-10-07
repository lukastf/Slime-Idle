package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.Slime;

public class TouchScreenCart {

    Slime slime;
    Menu menu;
    Buttons btn;
    Item item;
    Shop shop;
    SocketSlime socketSlime;
    private float screenX;
    private float screenY;

    public TouchScreenCart(
            Slime slime,
            Menu menu,
            Buttons btn,
            Item item,
            Shop shop,
            SocketSlime socketSlime,
            float screenX,
            float screenY){

        this.slime = slime;
        this.menu = menu;
        this.btn = btn;
        this.item = item;
        this.shop = shop;
        this.socketSlime = socketSlime;
        this.screenX = screenX;
        this.screenY = screenY;
    }

    public boolean touch(){
        if(menu.isMenu_item_selecionado()) {
            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {
                if (btn.backBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5) * 2)))) {
                    menu.setMenu_item_selecionado(false);
                }

                if (item.getItemSelecionado() != 0 && shop.itemsShopBought.get(item.getItemSelecionado())) {
                    if ( (slime.getItemEquippedId() * -1) + 1 == item.getItemSelecionado() ||
                            slime.getItemEquippedId() + 5 == item.getItemSelecionado()) {
                        if (btn.unequipBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5) * 2)))) {
                            socketSlime.unequipItem();
                        }
                    } else {
                        if (btn.equipBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5) * 2)))) {
                            socketSlime.equipItem();
                        }
                    }
                } else {
                    if (btn.buyBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5) * 2)))) {
                        socketSlime.buyItem();
                    }
                }
            }

            if(menu.isMenu_item_BuySuccess() || menu.isMenu_item_BuyError_ready() || menu.isMenu_item_BuyError_money()) {
                if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){
                    menu.setMenu_item_BuySuccess(false);
                    menu.setMenu_item_BuyError_ready(false);
                    menu.setMenu_item_BuyError_money(false);
                }
            }
            return true;
        }

        if(btn.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((Static.h/4) * 2))){

            menu.setMenu_item_selecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                item.setItemSelecionado(0);
            }
            if(menu.getMenuCurrentPage() == 2) {
                item.setItemSelecionado(5);
            }
            if(menu.getMenuCurrentPage() == 3) {
                item.setItemSelecionado(10);
            }
            if(menu.getMenuCurrentPage() == 4) {
                item.setItemSelecionado(15);
            }
            if(menu.getMenuCurrentPage() == 5) {
                item.setItemSelecionado(20);
            }
        }
        if(btn.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((Static.h/8) * 2))){

            menu.setMenu_item_selecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                item.setItemSelecionado(1);
            }
            if(menu.getMenuCurrentPage() == 2) {
                item.setItemSelecionado(6);
            }
            if(menu.getMenuCurrentPage() == 3) {
                item.setItemSelecionado(11);
            }
            if(menu.getMenuCurrentPage() == 4) {
                item.setItemSelecionado(16);
            }
            if(menu.getMenuCurrentPage() == 5) {
                item.setItemSelecionado(21);
            }
        }

        if(btn.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)){

            menu.setMenu_item_selecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                item.setItemSelecionado(2);
            }
            if(menu.getMenuCurrentPage() == 2) {
                item.setItemSelecionado(7);
            }
            if(menu.getMenuCurrentPage() == 3) {
                item.setItemSelecionado(12);
            }
            if(menu.getMenuCurrentPage() == 4) {
                item.setItemSelecionado(17);
            }
            if(menu.getMenuCurrentPage() == 5) {
                item.setItemSelecionado(22);
            }
        }

        if(btn.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((Static.h/8) * 2))){

            menu.setMenu_item_selecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                item.setItemSelecionado(3);
            }
            if(menu.getMenuCurrentPage() == 2) {
                item.setItemSelecionado(8);
            }
            if(menu.getMenuCurrentPage() == 3) {
                item.setItemSelecionado(13);
            }
            if(menu.getMenuCurrentPage() == 4) {
                item.setItemSelecionado(18);
            }
            if(menu.getMenuCurrentPage() == 5) {
                item.setItemSelecionado(23);
            }
        }

        if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){

            menu.setMenu_item_selecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                item.setItemSelecionado(4);
            }
            if(menu.getMenuCurrentPage() == 2) {
                item.setItemSelecionado(9);
            }
            if(menu.getMenuCurrentPage() == 3) {
                item.setItemSelecionado(14);
            }
            if(menu.getMenuCurrentPage() == 4) {
                item.setItemSelecionado(19);
            }
            if(menu.getMenuCurrentPage() == 5) {
                item.setItemSelecionado(24);
            }
        }

        if(btn.prevBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5)*2)))){
            if(menu.getMenuCurrentPage() == 1) {
                return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() - 1);
        }

        if(btn.nextBtn.getBoundingRectangle().contains(screenX,(float) (screenY - ((Static.h / 2.5)*2)))){
            if(menu.getMenuCurrentPage() == 5) {
                return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() + 1);
        }
        return true;
    }
}
