package com.slimeIdle;

public class RenderCoin {

    VariablesDeclaration vd;
    Render render;
    RenderMenssages renderMenssages;

    public RenderCoin(VariablesDeclaration vdRecebido, Render renderRecebido, RenderMenssages renderMenssagesRecebido){
        vd = vdRecebido;
        render = renderRecebido;
        renderMenssages = renderMenssagesRecebido;
    }

    public void render(){
        render.titleScreen("Buy Coins");
        render.subTitleScreen("Coins: " + vd.getCoins());

        vd.itemMenuBtns.get(0).draw(vd.batch);
        vd.itemMenuBtns.get(1).draw(vd.batch);
        vd.itemMenuBtns.get(2).draw(vd.batch);
        vd.itemMenuBtns.get(3).draw(vd.batch);
        vd.itemMenuBtns.get(4).draw(vd.batch);

        /*
        vd.coinSpr0.draw(vd.batch);
        vd.coinSpr1.draw(vd.batch);
        vd.coinSpr2.draw(vd.batch);
        vd.coinSpr3.draw(vd.batch);
        vd.coinSpr4.draw(vd.batch);
        */

        render.itemMenuBtnsSimpleText0("50 coins");
        render.itemMenuBtnsSimpleText1("120 coins");
        render.itemMenuBtnsSimpleText2("700 coins");
        render.itemMenuBtnsSimpleText3("8000 coins");
        render.itemMenuBtnsSimpleText4("17000 coins");
    }
}
