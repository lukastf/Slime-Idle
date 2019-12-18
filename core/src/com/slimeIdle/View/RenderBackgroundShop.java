package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;

public class RenderBackgroundShop {

    Menu menu;
    Shop shop;
    Render render;
    RenderMessages renderMessages;
    RenderItems renderItems;
    Item item;
    Slime slime;
    Buttons btns;
    Coin coin;

    public RenderBackgroundShop(
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

            slime.drawBackground(slime.getBackgroundEquipped(item.getItemId()));

            render.titleScreen(AllTextStringsLanguages.backgroundsShop.get(item.getItemMenuPosition()).get("name"));
            render.subTitleScreen(AllTextStringsLanguages.backgroundsShop.get(item.getItemMenuPosition()).get("price"));

            //slime.drawSlime("green");

            slime.drawSlime(slime.getSlimeColorEquipped(slime.getSlimeColorEquippedId(), slime.getEquippedItemState()));
            renderItems.renderItemsEquipped(0);
            slime.drawFace();

            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

                btns.drawButtonPrevBtn();

                if (item.getItemId() != 0 && shop.itemsShopBought(item.getItemId(), item.getCollection())) {

                    if (slime.getBackgroundEquippedId() == item.getItemId()
                            && slime.getCollectionBackgroundEquipped().contains(item.getCollection())) {

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

            render.titleScreen(AllTextStringsLanguages.backgrounds);
            render.subTitleScreen(AllTextStringsLanguages.coins.get(0) + coin.getCoins());

            for (int i = 0; i < 5; i++) {

                btns.drawMenuBtn(i);
            }

            if (menu.getMenuCurrentPage() == 1) {

                for(int i = 0; i < 4; i++){

                    render.itemMenuBtnsDoubleText(
                            AllTextStringsLanguages.backgroundsShop.get(i).get("name"),
                            AllTextStringsLanguages.backgroundsShop.get(i).get("price"), false, i);
                }
            }

            render.pages(menu.getMenuCurrentPage() + "/1");
        }
    }

}
