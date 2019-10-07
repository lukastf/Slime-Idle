package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;

public class RenderCart {

    Menu menu;
    Shop shop;
    Render render;
    RenderMenssages renderMenssages;
    Item item;
    Slime slime;
    Buttons btns;
    Coin coin;

    public RenderCart(
            Menu menu,
            Shop shop,
            Render renderRecebido,
            RenderMenssages renderMenssagesRecebido,
            Item item,
            Slime slime,
            Buttons btns,
            Coin coin
            ){

        this.menu = menu;
        this.shop = shop;
        this.render = renderRecebido;
        this.renderMenssages = renderMenssagesRecebido;
        this.item = item;
        this.slime = slime;
        this.btns = btns;
        this.coin = coin;
    }

    public void render(){
        if(menu.isMenu_item_selecionado()) {

            render.titleScreen(shop.itemsShopNames.get(item.getItemSelecionado()));
            render.subTitleScreen(shop.itemsShopPrices.get(item.getItemSelecionado()));

            slime.slimeSpr.draw(Static.batch);

            if(item.getItemSelecionado() == 0 || item.getItemSelecionado() == 1) {
                Static.batch.draw(shop.itemsShopSprites.get(item.getItemSelecionado()),
                        (Static.camera.position.x - (Static.w/3)),
                        (Static.camera.position.y));
            } else {
                Static.tw = slime.slimeSpr.getWidth();
                Static.th = slime.slimeSpr.getHeight();
                Static.batch.draw(shop.itemsShopSprites.get(item.getItemSelecionado()),
                        (Static.camera.position.x - (Static.tw/2)),
                        (Static.camera.position.y - (Static.th/2) + (Static.h/5)),
                        Static.tw, Static.th);
            }

            if(!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

                btns.backBtn.draw(Static.batch);

                if (item.getItemSelecionado() != 0 && shop.itemsShopBought.get(item.getItemSelecionado())) {
                    if ((slime.getItemEquippedId() * -1) + 1 == item.getItemSelecionado() ||
                            slime.getItemEquippedId() + 5 == item.getItemSelecionado()) {
                        btns.unequipBtn.draw(Static.batch);
                    } else {
                        btns.equipBtn.draw(Static.batch);
                    }
                } else {
                    btns.buyBtn.draw(Static.batch);
                }
            }
            if(menu.isMenu_item_BuySuccess()){
                renderMenssages.messageSuccess("Successfully", "Bought");
            }
            if(menu.isMenu_item_BuyError_ready()){
                renderMenssages.messageError("Your slime is", "already Read!");
            }
            if(menu.isMenu_item_BuyError_money()) {
                renderMenssages.messageError("You don't", "have coins");
            }


        } else {

            render.titleScreen("Shop");
            render.subTitleScreen("Coins: " + coin.getCoins());

            btns.itemMenuBtns.get(0).draw(Static.batch);
            btns.itemMenuBtns.get(1).draw(Static.batch);
            btns.itemMenuBtns.get(2).draw(Static.batch);
            btns.itemMenuBtns.get(3).draw(Static.batch);
            btns.itemMenuBtns.get(4).draw(Static.batch);

            if (menu.getMenuCurrentPage() == 1) {

                //time reset
                //vd.timeSpr.draw(vd.batch);
                shop.itemsShopSprites.get(0).draw(Static.batch);
                shop.itemsShopNames.set(0,"Time Reset");
                shop.itemsShopPrices.set(0,"price: 10 coins");
                render.itemMenuBtnsDoubleText0(shop.itemsShopNames.get(0), shop.itemsShopPrices.get(0),true);

                //change nickname
                //vd.pencilSpr.draw(vd.batch);
                shop.itemsShopSprites.get(1).draw(Static.batch);
                shop.itemsShopNames.set(1,"Change Nick");
                shop.itemsShopPrices.set(1,"price: 10 coins");
                render.itemMenuBtnsDoubleText1(shop.itemsShopNames.get(1), shop.itemsShopPrices.get(1),true);

                for(int i = 2; i < 5; i++){
                    shop.itemsShopSprites.get(i).draw(Static.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                   // vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 2){
                        render.itemMenuBtnsDoubleText2(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 3){
                        render.itemMenuBtnsDoubleText3(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 4){
                        render.itemMenuBtnsDoubleText4(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                }
            }
            if (menu.getMenuCurrentPage() == 2) {

                for(int i = 5; i < 10; i++){
                    shop.itemsShopSprites.get(i).draw(Static.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 5){
                        render.itemMenuBtnsDoubleText0(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 6){
                        render.itemMenuBtnsDoubleText1(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 7){
                        render.itemMenuBtnsDoubleText2(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 8){
                        render.itemMenuBtnsDoubleText3(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 9){
                        render.itemMenuBtnsDoubleText4(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                }
            }
            if (menu.getMenuCurrentPage() == 3) {
                for(int i = 10; i < 15; i++){
                    shop.itemsShopSprites.get(i).draw(Static.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 10){
                        render.itemMenuBtnsDoubleText0(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 11){
                        render.itemMenuBtnsDoubleText1(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 12){
                        render.itemMenuBtnsDoubleText2(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 13){
                        render.itemMenuBtnsDoubleText3(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 14){
                        render.itemMenuBtnsDoubleText4(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                }
            }
            if (menu.getMenuCurrentPage() == 4) {
                for(int i = 15; i < 20; i++){
                    shop.itemsShopSprites.get(i).draw(Static.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 15){
                        render.itemMenuBtnsDoubleText0(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 16){
                        render.itemMenuBtnsDoubleText1(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 17){
                        render.itemMenuBtnsDoubleText2(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 18){
                        render.itemMenuBtnsDoubleText3(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 19){
                        render.itemMenuBtnsDoubleText4(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                }
            }

            if (menu.getMenuCurrentPage() == 5) {

                for(int i = 20; i < 25; i++){
                    shop.itemsShopSprites.get(i).draw(Static.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 20){
                        render.itemMenuBtnsDoubleText0(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 21){
                        render.itemMenuBtnsDoubleText1(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 22){
                        render.itemMenuBtnsDoubleText2(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 23){
                        render.itemMenuBtnsDoubleText3(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                    if(i == 24){
                        render.itemMenuBtnsDoubleText4(shop.itemsShopNames.get(i), shop.itemsShopPrices.get(i), true);
                    }
                }
            }

            Static.tw = btns.prevBtn.getWidth();
            Static.th = btns.prevBtn.getHeight();

            render.pages(menu.getMenuCurrentPage() + "/5");
        }
    }
}
