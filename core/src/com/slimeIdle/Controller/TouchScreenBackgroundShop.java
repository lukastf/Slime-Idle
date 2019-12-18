package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.SocketSlime;

public class TouchScreenBackgroundShop {

    Slime slime;
    Menu menu;
    Buttons btn;
    Item item;
    Shop shop;
    SocketSlime socketSlime;
    //TouchScreenMenu touchScreenMenu;
    //private float screenX;
    //private float screenY;

    public TouchScreenBackgroundShop(
            Slime slime,
            Menu menu,
            Buttons btn,
            Item item,
            Shop shop,
            SocketSlime socketSlime
            //TouchScreenMenu touchScreenMenu
            /*float screenX,
            float screenY*/) {

        this.slime = slime;
        this.menu = menu;
        this.btn = btn;
        this.item = item;
        this.shop = shop;
        this.socketSlime = socketSlime;
        //this.touchScreenMenu = touchScreenMenu;
        //this.screenX = screenX;
        //this.screenY = screenY;
    }

    public void keyBack () {

        if(menu.isMenu_background()){

            if(menu.isMenu_item_selecionado()){

                menu.setMenu_item_selecionado(false);
            } else {

                menu.setMenu_background(false);
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

                    if(slime.getBackgroundEquippedId() == item.getItemId()
                            && slime.getCollectionBackgroundEquipped().contains(item.getCollection())){

                        if (btn.buttonUnequipCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                            slime.setCollectionBackgroundEquipped("");
                            socketSlime.unequipItem();
                        }

                    } else {

                        if (btn.buttonEquipCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                            slime.setCollectionBackgroundEquipped(item.getCollection());
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
                item.setCollection("backgrounds");
                item.setItemMenuPosition(0);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(2);
                item.setCollection("backgrounds");
                item.setItemMenuPosition(1);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(3);
                item.setCollection("backgrounds");
                item.setItemMenuPosition(2);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(4);
                item.setCollection("backgrounds");
                item.setItemMenuPosition(3);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //return true;

                //menu.setMenu_item_selecionado(true);

                //item.setItemId(2);
                //item.setCollection("commonItems");
                //item.setItemMenuPosition(4);
            }
        }

        return false;
    }

}
