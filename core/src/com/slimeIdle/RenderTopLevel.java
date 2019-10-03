package com.slimeIdle;

public class RenderTopLevel {

    VariablesDeclaration vd;
    Render render;

    public RenderTopLevel(VariablesDeclaration vdRecebido, Render renderRecebido){
        vd = vdRecebido;
        render = renderRecebido;
    }

    public void render(){
        if(vd.isMenu_topLevel_PlayerSelecionado()) {

            render.topPlayerName(vd.topPlayers.get(vd.getPlayerTopSelecionado()));
            render.subTitleScreen(vd.topPlayersLevel.get(vd.getPlayerTopSelecionado()));

            vd.backBtn.draw(vd.batch);

            vd.slimeSpr.draw(vd.batch);

            if(vd.topPlayersItemEquippedId.get(vd.getPlayerTopSelecionado()) != 0 && vd.itemsShopSprites.size() != 0){
                vd.renderItemsEquipped(false);
            }

        } else {

            render.titleScreen("Top Level");

            vd.itemMenuBtns.get(0).draw(vd.batch);
            vd.itemMenuBtns.get(1).draw(vd.batch);
            vd.itemMenuBtns.get(2).draw(vd.batch);
            vd.itemMenuBtns.get(3).draw(vd.batch);
            vd.itemMenuBtns.get(4).draw(vd.batch);

            if (vd.getCurrentPage() == 1) {

                render.itemMenuBtnsDoubleText0(vd.topPlayers.get(0), vd.topPlayersLevel.get(0), false);
                render.itemMenuBtnsDoubleText1(vd.topPlayers.get(1), vd.topPlayersLevel.get(1), false);
                render.itemMenuBtnsDoubleText2(vd.topPlayers.get(2), vd.topPlayersLevel.get(2), false);
                render.itemMenuBtnsDoubleText3(vd.topPlayers.get(3), vd.topPlayersLevel.get(3), false);
                render.itemMenuBtnsDoubleText4(vd.topPlayers.get(4), vd.topPlayersLevel.get(4), false);

            }
            if (vd.getCurrentPage() == 2) {

                render.itemMenuBtnsDoubleText0(vd.topPlayers.get(5), vd.topPlayersLevel.get(5), false);
                render.itemMenuBtnsDoubleText1(vd.topPlayers.get(6), vd.topPlayersLevel.get(6), false);
                render.itemMenuBtnsDoubleText2(vd.topPlayers.get(7), vd.topPlayersLevel.get(7), false);
                render.itemMenuBtnsDoubleText3(vd.topPlayers.get(8), vd.topPlayersLevel.get(8), false);
                render.itemMenuBtnsDoubleText4(vd.topPlayers.get(9), vd.topPlayersLevel.get(9), false);

            }
            if (vd.getCurrentPage() == 3) {

                render.itemMenuBtnsDoubleText0(vd.topPlayers.get(10), vd.topPlayersLevel.get(10), false);
                render.itemMenuBtnsDoubleText1(vd.topPlayers.get(11), vd.topPlayersLevel.get(11), false);
                render.itemMenuBtnsDoubleText2(vd.topPlayers.get(12), vd.topPlayersLevel.get(12), false);
                render.itemMenuBtnsDoubleText3(vd.topPlayers.get(13), vd.topPlayersLevel.get(13), false);
                render.itemMenuBtnsDoubleText4(vd.topPlayers.get(14), vd.topPlayersLevel.get(14), false);

            }
            if (vd.getCurrentPage() == 4) {

                render.itemMenuBtnsDoubleText0(vd.topPlayers.get(15), vd.topPlayersLevel.get(15), false);
                render.itemMenuBtnsDoubleText1(vd.topPlayers.get(16), vd.topPlayersLevel.get(16), false);
                render.itemMenuBtnsDoubleText2(vd.topPlayers.get(17), vd.topPlayersLevel.get(17), false);
                render.itemMenuBtnsDoubleText3(vd.topPlayers.get(18), vd.topPlayersLevel.get(18), false);
                render.itemMenuBtnsDoubleText4(vd.topPlayers.get(19), vd.topPlayersLevel.get(19), false);

            }

            render.pages(vd.getCurrentPage() + "/4");
        }
    }
}
