package com.slimeIdle.Controller;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.View.AllTextStringsLanguages;

public class TouchScreenLanguage {

    Slime slime;
    Menu menu;
    Buttons btn;
    Item item;
    Shop shop;
    SocketSlime socketSlime;
    Loader loader;
    Account acc;

    public TouchScreenLanguage(
            Slime slime,
            Menu menu,
            Buttons btn,
            Item item,
            Shop shop,
            SocketSlime socketSlime,
            Loader loader,
            Account acc) {

        this.slime = slime;
        this.menu = menu;
        this.btn = btn;
        this.item = item;
        this.shop = shop;
        this.socketSlime = socketSlime;
        this.loader = loader;
        this.acc = acc;
    }

    public void keyBack() {

        if(menu.isMenu_language()){

            menu.setMenu_language(false);
            menu.setMenu(false);

        }
    }

    public boolean touch(){

        /*if(menu.isMenu_item_selecionado()) {

            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

                if (btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    menu.setMenu_item_selecionado(false);
                }

                if (item.getItemId() != 0 && shop.itemsShopBought(item.getItemId(), item.getCollection())) {

                    if(slime.getBackgroundEquippedId() == item.getItemId()
                            && slime.getCollectionBackgroundEquipped() == item.getCollection()){

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
        }*/



        if(menu.getMenuCurrentPage() == 1) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //menu.setMenu_item_selecionado(true);

                //item.setItemId(1);
                //item.setCollection("backgrounds");
                //item.setItemMenuPosition(0);
                AllTextStringsLanguages.language = AllTextStringsLanguages.english;
                AllTextStringsLanguages.getAllTexts();
                acc.setCreateAccountStrings();
                //loader.getFonts(0);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //menu.setMenu_item_selecionado(true);

                //item.setItemId(2);
                //item.setCollection("backgrounds");
                //item.setItemMenuPosition(1);

                AllTextStringsLanguages.language = AllTextStringsLanguages.spanish;
                AllTextStringsLanguages.getAllTexts();
                acc.setCreateAccountStrings();
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //menu.setMenu_item_selecionado(true);

                //item.setItemId(3);
                //item.setCollection("backgrounds");
                //item.setItemMenuPosition(2);
                AllTextStringsLanguages.language = AllTextStringsLanguages.portuguese;
                AllTextStringsLanguages.getAllTexts();
                acc.setCreateAccountStrings();
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                //menu.setMenu_item_selecionado(true);

                //item.setItemId(4);
                //item.setCollection("backgrounds");
                //item.setItemMenuPosition(3);
                AllTextStringsLanguages.language = AllTextStringsLanguages.russian;
                AllTextStringsLanguages.getAllTexts();
                loader.getFonts(1);
                acc.setCreateAccountStrings();
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                AllTextStringsLanguages.language = AllTextStringsLanguages.japanese;
                AllTextStringsLanguages.getAllTexts();
                loader.getFonts(2);
                acc.setCreateAccountStrings();
                //return true;

                //menu.setMenu_item_selecionado(true);

                //item.setItemId(2);
                //item.setCollection("commonItems");
                //item.setItemMenuPosition(4);
            }
        }

        if(menu.getMenuCurrentPage() == 2) {

            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                AllTextStringsLanguages.language = AllTextStringsLanguages.korean;
                AllTextStringsLanguages.getAllTexts();
                loader.getFonts(3);
                acc.setCreateAccountStrings();
            }

            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                AllTextStringsLanguages.language = AllTextStringsLanguages.chinese;
                AllTextStringsLanguages.getAllTexts();
                loader.getFonts(4);
                acc.setCreateAccountStrings();
            }

            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

            }

            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

            }

            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

            }

        }
        /*
        if(btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            if(menu.getMenuCurrentPage() == 1) {
                //return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() - 1);
        }

        if(btn.buttonNextCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            if(menu.getMenuCurrentPage() == 1) {
                //return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() + 1);
        }*/
        return false;
    }
}
