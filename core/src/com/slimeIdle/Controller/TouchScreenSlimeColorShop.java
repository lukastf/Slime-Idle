package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.SocketSlime;

public class TouchScreenSlimeColorShop {

    Slime slime;
    Menu menu;
    Buttons btn;
    Item item;
    Shop shop;
    SocketSlime socketSlime;

    public TouchScreenSlimeColorShop(
            Slime slime,
            Menu menu,
            Buttons btn,
            Item item,
            Shop shop,
            SocketSlime socketSlime) {

        this.slime = slime;
        this.menu = menu;
        this.btn = btn;
        this.item = item;
        this.shop = shop;
        this.socketSlime = socketSlime;
    }

    public void keyBack () {

        if(menu.isMenu_slime_color()){

            if(menu.isMenu_item_selecionado()){

                menu.setMenu_item_selecionado(false);
            } else {

                menu.setMenu_slime_color(false);
                menu.setMenu(false);
            }
        }
    }

    public boolean touch(){

        if(menu.isMenu_item_selecionado()) {

            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

                if (btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    menu.setMenu_item_selecionado(false);
                    return true;
                }

                if (item.getItemId() != 0 && shop.itemsShopBought(item.getItemId(), item.getCollection())) {

                    if(slime.getSlimeColorEquippedId() == item.getItemId()
                            && slime.getCollectionSlimeColorEquipped().contains( item.getCollection())){

                        if (btn.buttonUnequipCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                            slime.setCollectionSlimeColorEquipped("");
                            socketSlime.unequipItem();
                        }

                    } else {

                        if (btn.buttonEquipCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                            slime.setCollectionSlimeColorEquipped(item.getCollection());
                            socketSlime.equipItem();
                        }
                    }
                } else {
                    if (btn.buttonBuyCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                        socketSlime.buyItem();
                    }
                }
            }

            if(menu.isMenu_item_BuySuccess() || menu.isMenu_item_BuyError_ready() || menu.isMenu_item_BuyError_money()) {
                if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    menu.setMenu_item_BuySuccess(false);
                    menu.setMenu_item_BuyError_ready(false);
                    menu.setMenu_item_BuyError_money(false);
                }
            }
            return true;
        }



        if(menu.getMenuCurrentPage() == 1) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(1);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(0);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(2);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(1);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(3);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(2);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(4);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(3);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(5);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(4);

            }
        }

        if(menu.getMenuCurrentPage() == 2) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(6);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(0);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(7);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(1);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(8);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(2);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(9);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(3);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(10);
                item.setCollection("slimeColors");
                item.setItemMenuPosition(4);

            }
        }

        return false;
    }

}
