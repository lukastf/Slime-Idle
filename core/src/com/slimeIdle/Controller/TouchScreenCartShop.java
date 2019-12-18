package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Model.Slime;

public class TouchScreenCartShop {

    Slime slime;
    Menu menu;
    Buttons btn;
    Item item;
    Shop shop;
    SocketSlime socketSlime;
    //TouchScreenMenu touchScreenMenu;
    //private float screenX;
    //private float screenY;

    public TouchScreenCartShop(
            Slime slime,
            Menu menu,
            Buttons btn,
            Item item,
            Shop shop,
            SocketSlime socketSlime
            //TouchScreenMenu touchScreenMenu
            /*,
            float screenX,
            float screenY*/){

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

        if(menu.isMenu_cart()){

            if(menu.isMenu_item_selecionado()){

                menu.setMenu_item_selecionado(false);
            } else {
                menu.setMenu_cart(false);
                menu.setMenu(false);
            }
        }
    }

    public boolean touch(){

        //TouchScreenMenu touchScreenMenu = new TouchScreenMenu(btn,menu);

        if(menu.isMenu_item_selecionado()) {

            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

                if (btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    menu.setMenu_item_selecionado(false);
                    return true;
                }

                if (item.getItemId() != 0
                        && shop.itemsShopBought(item.getItemId(), item.getCollection())) {
                    /*if ( (slime.getItemEquippedId() * -1) + 1 == item.getItemId() ||
                            slime.getItemEquippedId() + 5 == item.getItemId()) {*/
                    if(slime.getItemEquippedId() == item.getItemId()
                            && slime.getCollectionItemEquipped().contains(item.getCollection())){
                        if (btn.buttonUnequipCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                            slime.setCollectionItemEquipped("");
                            socketSlime.unequipItem();
                        }
                    } else {
                        if (btn.buttonEquipCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                            slime.setCollectionItemEquipped(item.getCollection());
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
                item.setCollection("noItems");
                item.setItemMenuPosition(0);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(2);
                item.setCollection("noItems");
                item.setItemMenuPosition(1);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(3);
                item.setCollection("noItems");
                item.setItemMenuPosition(2);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(1);
                item.setCollection("commonItems");
                item.setItemMenuPosition(3);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(2);
                item.setCollection("commonItems");
                item.setItemMenuPosition(4);
            }
        }
        if(menu.getMenuCurrentPage() == 2) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(3);
                item.setCollection("commonItems");
                item.setItemMenuPosition(5);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(4);
                item.setCollection("commonItems");
                item.setItemMenuPosition(6);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(5);
                item.setCollection("commonItems");
                item.setItemMenuPosition(7);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(6);
                item.setCollection("commonItems");
                item.setItemMenuPosition(8);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(7);
                item.setCollection("commonItems");
                item.setItemMenuPosition(9);
            }
        }
        if(menu.getMenuCurrentPage() == 3) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(8);
                item.setCollection("commonItems");
                item.setItemMenuPosition(10);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(9);
                item.setCollection("commonItems");
                item.setItemMenuPosition(11);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(10);
                item.setCollection("commonItems");
                item.setItemMenuPosition(12);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(11);
                item.setCollection("commonItems");
                item.setItemMenuPosition(13);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(12);
                item.setCollection("commonItems");
                item.setItemMenuPosition(14);
            }
        }
        if(menu.getMenuCurrentPage() == 4) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(13);
                item.setCollection("commonItems");
                item.setItemMenuPosition(15);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(14);
                item.setCollection("commonItems");
                item.setItemMenuPosition(16);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(15);
                item.setCollection("commonItems");
                item.setItemMenuPosition(17);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(16);
                item.setCollection("commonItems");
                item.setItemMenuPosition(18);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(17);
                item.setCollection("commonItems");
                item.setItemMenuPosition(19);
            }

        }
        if(menu.getMenuCurrentPage() == 5) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(18);
                item.setCollection("commonItems");
                item.setItemMenuPosition(20);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                item.setItemId(19);
                item.setCollection("commonItems");
                item.setItemMenuPosition(21);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_item_selecionado(true);

                //return true;
                item.setItemId(1);
                item.setCollection("holidayItems");
                item.setItemMenuPosition(22);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //menu.setMenu_item_selecionado(true);
                //return true;
                //item.setItemId(21);
                //item.setCollection("commonItems");
                //item.setItemMenuPosition(23);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //return true;
                //menu.setMenu_item_selecionado(true);

                //item.setItemId(22);
                //item.setCollection("commonItems");
                //item.setItemMenuPosition(24);
            }

        }

        return false;
    }
}
