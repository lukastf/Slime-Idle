package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;

public class RenderSlimeColorShop {

    Menu menu;
    Shop shop;
    Render render;
    RenderMessages renderMessages;
    RenderItems renderItems;
    Item item;
    Slime slime;
    Buttons btns;
    Coin coin;

    public RenderSlimeColorShop(
            Menu menu,
            Shop shop,
            Render render,
            RenderMessages renderMessages,
            RenderItems renderItems,
            Item item,
            Slime slime,
            Buttons btns,
            Coin coin
    ){

        this.menu = menu;
        this.shop = shop;
        this.render = render;
        this.renderMessages = renderMessages;
        this.renderItems = renderItems;
        this.item = item;
        this.slime = slime;
        this.btns = btns;
        this.coin = coin;
    }

    public void render(){


        if(menu.isMenu_item_selecionado()) {

            slime.drawBackground(slime.getBackgroundEquipped(slime.getBackgroundEquippedId()));

            render.titleScreen(AllTextStringsLanguages.slimeColorsShop.get(item.getItemMenuPosition()).get("name"));
            render.subTitleScreen(AllTextStringsLanguages.slimeColorsShop.get(item.getItemMenuPosition()).get("price"));

            //slime.drawSlime(slime.getSlimeColorEquipped(slime.getSlimeColorEquippedId(), slime.getEquippedItemState()));
            slime.drawSlime(slime.getSlimeColorEquipped(item.getItemId(), slime.getEquippedItemState()));
            renderItems.renderItemsEquipped(0);
            slime.drawFace();

            //if(item.getCollection() == "noItems") {

                //Static.batch.draw(shop.itemsShopTextures.get(item.getItemId() - 1), Static.cam.viewportWidth * 0.65f,Static.cam.viewportHeight * 0.5f);
            //} else {

              //  renderItems.renderItemsEquipped(2);
            //}

            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

                btns.drawButtonPrevBtn();

                if (item.getItemId() != 0 && shop.itemsShopBought(item.getItemId(), item.getCollection())) {

                    if (slime.getSlimeColorEquippedId() == item.getItemId()
                            && slime.getCollectionSlimeColorEquipped().contains(item.getCollection())) {

                        btns.drawUnequipBtn();
                    } else {

                        btns.drawEquipBtn();
                    }
                } else {

                    btns.drawBuyBtn();
                }
            }
            if(menu.isMenu_item_BuySuccess()){
                renderMessages.messageSuccess(AllTextStringsLanguages.successBuy.get(0), AllTextStringsLanguages.successBuy.get(1));
            }
            if(menu.isMenu_item_BuyError_ready()){
                renderMessages.messageError(AllTextStringsLanguages.errorSlimeReady.get(0), AllTextStringsLanguages.errorSlimeReady.get(1));
            }
            if(menu.isMenu_item_BuyError_money()) {
                renderMessages.messageError(AllTextStringsLanguages.errorBuy.get(0), AllTextStringsLanguages.errorBuy.get(1));
            }


        } else {

            render.titleScreen(AllTextStringsLanguages.slimeColors);
            render.subTitleScreen(AllTextStringsLanguages.coins.get(0) + coin.getCoins());

            for (int i = 0; i < 5; i++) {

                btns.drawMenuBtn(i);
            }

            if (menu.getMenuCurrentPage() == 1) {

                for(int i = 0; i < 5; i++){

                    shop.drawSlimeColorShopIcon(i, i, btns.buttonMenuProps);
                    render.itemMenuBtnsDoubleText(
                            AllTextStringsLanguages.slimeColorsShop.get(i).get("name"),
                            AllTextStringsLanguages.slimeColorsShop.get(i).get("price"),
                            true, i);
                }
            }
            if (menu.getMenuCurrentPage() == 2) {

                for(int i = 5; i < 10; i++){

                    shop.drawSlimeColorShopIcon( i,i-5, btns.buttonMenuProps);
                    render.itemMenuBtnsDoubleText(
                            AllTextStringsLanguages.slimeColorsShop.get(i).get("name"),
                            AllTextStringsLanguages.slimeColorsShop.get(i).get("price"),
                            true, i-5);
                }
            }
            /*
            if (menu.getMenuCurrentPage() == 3) {

                for(int i = 10; i < 15; i++){

                    shop.drawItemShopIcon(i,i-10,btns.buttonMenuProps);
                    render.itemMenuBtnsDoubleText(
                            AllTextStringsLanguages.itemsShop.get(i).get("name"),
                            AllTextStringsLanguages.itemsShop.get(i).get("price"),
                            true, i-10);
                }
            }
            if (menu.getMenuCurrentPage() == 4) {

                for(int i = 15; i < 20; i++){

                    shop.drawItemShopIcon(i,i-15, btns.buttonMenuProps);
                    render.itemMenuBtnsDoubleText(
                            AllTextStringsLanguages.itemsShop.get(i).get("name"),
                            AllTextStringsLanguages.itemsShop.get(i).get("price"),
                            true, i-15);
                }
            }

            if (menu.getMenuCurrentPage() == 5) {

                for(int i = 20; i < 22; i++){

                    shop.drawItemShopIcon(i,i-20, btns.buttonMenuProps);
                    render.itemMenuBtnsDoubleText(
                            AllTextStringsLanguages.itemsShop.get(i).get("name"),
                            AllTextStringsLanguages.itemsShop.get(i).get("price"),
                            true, i-20);
                }
            }
             */
            render.pages(menu.getMenuCurrentPage() + "/2");
        }
    }
}
