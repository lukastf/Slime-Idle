package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;
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

            render.topPlayerName(topLevel.topPlayers.get(topLevel.getPlayerTopSelecionado()));
            render.subTitleScreen(topLevel.topPlayersLevel.get(topLevel.getPlayerTopSelecionado()));

            btns.backBtn.draw(Static.batch);

            slime.slimeSpr.draw(Static.batch);

            if(topLevel.topPlayersItemEquippedId.get(topLevel.getPlayerTopSelecionado()) != 0 && shop.itemsShopSprites.size() != 0){
                item.renderItemsEquipped(false);
            }

        } else {

            render.titleScreen("Top Level");

            btns.itemMenuBtns.get(0).draw(Static.batch);
            btns.itemMenuBtns.get(1).draw(Static.batch);
            btns.itemMenuBtns.get(2).draw(Static.batch);
            btns.itemMenuBtns.get(3).draw(Static.batch);
            btns.itemMenuBtns.get(4).draw(Static.batch);

            if (menu.getMenuCurrentPage() == 1) {

                render.itemMenuBtnsDoubleText0(topLevel.topPlayers.get(0), topLevel.topPlayersLevel.get(0), false);
                render.itemMenuBtnsDoubleText1(topLevel.topPlayers.get(1), topLevel.topPlayersLevel.get(1), false);
                render.itemMenuBtnsDoubleText2(topLevel.topPlayers.get(2), topLevel.topPlayersLevel.get(2), false);
                render.itemMenuBtnsDoubleText3(topLevel.topPlayers.get(3), topLevel.topPlayersLevel.get(3), false);
                render.itemMenuBtnsDoubleText4(topLevel.topPlayers.get(4), topLevel.topPlayersLevel.get(4), false);

            }
            if (menu.getMenuCurrentPage() == 2) {

                render.itemMenuBtnsDoubleText0(topLevel.topPlayers.get(5), topLevel.topPlayersLevel.get(5), false);
                render.itemMenuBtnsDoubleText1(topLevel.topPlayers.get(6), topLevel.topPlayersLevel.get(6), false);
                render.itemMenuBtnsDoubleText2(topLevel.topPlayers.get(7), topLevel.topPlayersLevel.get(7), false);
                render.itemMenuBtnsDoubleText3(topLevel.topPlayers.get(8), topLevel.topPlayersLevel.get(8), false);
                render.itemMenuBtnsDoubleText4(topLevel.topPlayers.get(9), topLevel.topPlayersLevel.get(9), false);

            }
            if (menu.getMenuCurrentPage() == 3) {

                render.itemMenuBtnsDoubleText0(topLevel.topPlayers.get(10), topLevel.topPlayersLevel.get(10), false);
                render.itemMenuBtnsDoubleText1(topLevel.topPlayers.get(11), topLevel.topPlayersLevel.get(11), false);
                render.itemMenuBtnsDoubleText2(topLevel.topPlayers.get(12), topLevel.topPlayersLevel.get(12), false);
                render.itemMenuBtnsDoubleText3(topLevel.topPlayers.get(13), topLevel.topPlayersLevel.get(13), false);
                render.itemMenuBtnsDoubleText4(topLevel.topPlayers.get(14), topLevel.topPlayersLevel.get(14), false);

            }
            if (menu.getMenuCurrentPage() == 4) {

                render.itemMenuBtnsDoubleText0(topLevel.topPlayers.get(15), topLevel.topPlayersLevel.get(15), false);
                render.itemMenuBtnsDoubleText1(topLevel.topPlayers.get(16), topLevel.topPlayersLevel.get(16), false);
                render.itemMenuBtnsDoubleText2(topLevel.topPlayers.get(17), topLevel.topPlayersLevel.get(17), false);
                render.itemMenuBtnsDoubleText3(topLevel.topPlayers.get(18), topLevel.topPlayersLevel.get(18), false);
                render.itemMenuBtnsDoubleText4(topLevel.topPlayers.get(19), topLevel.topPlayersLevel.get(19), false);

            }

            render.pages(menu.getMenuCurrentPage() + "/4");
        }
    }
}
