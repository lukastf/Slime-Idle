package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.TopLevel;

public class RenderTopLevel {

    Menu menu;
    Render render;
    TopLevel topLevel;
    Buttons btns;
    Slime slime;
    Shop shop;
    RenderItems item;

    public RenderTopLevel(

            Menu menu,
            Render render,
            TopLevel topLevel,
            Buttons btns,
            Slime slime,
            Shop shop,
            RenderItems item){

        this.menu = menu;
        this.render = render;
        this.topLevel = topLevel;
        this.btns = btns;
        this.slime = slime;
        this.shop = shop;
        this.item = item;
    }

    public void render(){
        if(menu.isMenu_topLevel_PlayerSelecionado()) {

            slime.drawBackground(slime.getBackgroundEquipped(topLevel.topPlayersBackgroundEquippedId.get(topLevel.getPlayerTopSelecionado())));

            render.topPlayerName(topLevel.topPlayers.get(topLevel.getPlayerTopSelecionado()));
            render.subTitleScreen(topLevel.topPlayersLevel.get(topLevel.getPlayerTopSelecionado()));

            //btns.backBtn.draw(Static.batch);
            //Static.batch.draw(btns.buttonPrev, btns.buttonPrevProps.get("x"), btns.buttonPrevProps.get("y"));
            btns.drawButtonPrevBtn();

            //slime.slimeSpr.draw(Static.batch);
            /*Static.batch.draw(
                    slime.slimes.get("green"),
                    slime.slimePosition.get("x"),
                    slime.slimePosition.get("y"));*/
            //slime.drawSlime("green");
            slime.drawSlime(
                    slime.getSlimeColorEquipped(
                            topLevel.topPlayersSlimeColorEquippedId.get(topLevel.getPlayerTopSelecionado()),
                            topLevel.getEquippedItemState()));
            slime.drawFace();

            //if(topLevel.topPlayersItemEquippedId.get(topLevel.getPlayerTopSelecionado()) != 0 /*&& shop.itemsShopSprites.size() != 0*/){
                item.renderItemsEquipped(1);
            //}

        } else {

            render.titleScreen(AllTextStringsLanguages.topLevel);

            //Static.batch.draw(btns.btnMenu,btns.btnMenuX.get(0),btns.btnMenuY.get(0));
            //Static.batch.draw(btns.btnMenu,btns.btnMenuX.get(1),btns.btnMenuY.get(1));
            //Static.batch.draw(btns.btnMenu,btns.btnMenuX.get(2),btns.btnMenuY.get(2));

            for (int i = 0; i < 5; i++) {
                //Static.batch.draw(btns.btnMenu,btns.buttonMenuProps.get(i).get("x"),btns.buttonMenuProps.get(i).get("y"));
                btns.drawMenuBtn(i);
            }

            /*
            btns.itemMenuBtns.get(0).draw(Static.batch);
            btns.itemMenuBtns.get(1).draw(Static.batch);
            btns.itemMenuBtns.get(2).draw(Static.batch);
            btns.itemMenuBtns.get(3).draw(Static.batch);
            btns.itemMenuBtns.get(4).draw(Static.batch);*/

            if (menu.getMenuCurrentPage() == 1) {

                for (int i = 0; i < 5; i++) {
                    render.itemMenuBtnsDoubleText(topLevel.topPlayers.get(i), topLevel.topPlayersLevel.get(i), false, i);
                }
            }
            if (menu.getMenuCurrentPage() == 2) {

                for (int i = 5; i < 10; i++) {
                    render.itemMenuBtnsDoubleText(topLevel.topPlayers.get(i), topLevel.topPlayersLevel.get(i), false, i-5);
                }
            }
            if (menu.getMenuCurrentPage() == 3) {

                for (int i = 10; i < 15; i++) {
                    render.itemMenuBtnsDoubleText(topLevel.topPlayers.get(i), topLevel.topPlayersLevel.get(i), false, i-10);
                }
            }
            if (menu.getMenuCurrentPage() == 4) {

                for (int i = 15; i < 20; i++) {
                    render.itemMenuBtnsDoubleText(topLevel.topPlayers.get(i), topLevel.topPlayersLevel.get(i), false, i-15);
                }
            }

            render.pages(menu.getMenuCurrentPage() + "/4");
        }
    }
}
