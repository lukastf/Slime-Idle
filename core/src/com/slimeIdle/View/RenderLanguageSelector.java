package com.slimeIdle.View;

import com.badlogic.gdx.utils.ArrayMap;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Flags;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;

import java.util.ArrayList;

public class RenderLanguageSelector {

    Menu menu;
    //Shop shop;
    Render render;
    RenderMessages renderMessages;
    //RenderItems renderItems;
    //Item item;
    //Slime slime;
    Buttons btns;
    Flags flags;
    //Coin coin;

    public RenderLanguageSelector(
            Menu menu,
            //Shop shop,
            Render render,
            RenderMessages renderMessages,
            RenderItems renderItems,
            Item item,
            Slime slime,
            Buttons btns,
            Flags flags
            //Coin coin
    ){

        this.menu = menu;
        //this.shop = shop;
        this.render = render;
        this.renderMessages = renderMessages;
        //this.renderItems = renderItems;
        //this.item = item;
        //this.slime = slime;
        this.btns = btns;
        this.flags = flags;
        //this.coin = coin;
    }

    public void render(){


        //if(menu.isMenu_item_selecionado()) {
        /*
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
                            && slime.getCollectionSlimeColorEquipped() == item.getCollection()) {

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
            */
        //} else {

            render.titleScreen(AllTextStringsLanguages.languages);
            render.subTitleScreen(AllTextStringsLanguages.language);

            for (int i = 0; i < 5; i++) {

                btns.drawMenuBtn(i);
            }

            if (menu.getMenuCurrentPage() == 1) {

                for(int i = 0; i < 5; i++){

                    flags.drawFlagIcon(i,i, btns.buttonMenuProps);
                    render.itemMenuBtnsSimpleText(
                            AllTextStringsLanguages.languagesStrings.get(i),
                            true, i);
                }
            }
            if (menu.getMenuCurrentPage() == 2) {

                for(int i = 5; i < 7; i++){

                    flags.drawFlagIcon( i,i-5, btns.buttonMenuProps);
                    render.itemMenuBtnsSimpleText(
                            AllTextStringsLanguages.languagesStrings.get(i),
                            true, i-5);
                }
            }
            render.pages(menu.getMenuCurrentPage() + "/2");
        //}
    }

}
