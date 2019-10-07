package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Static;

public class RenderCoin {

    Buttons btns;
    Render render;
    RenderMenssages renderMenssages;
    Coin coin;

    public RenderCoin(Buttons btns, Render render, RenderMenssages renderMenssages, Coin coin){
        this.btns = btns;
        this.render = render;
        this.renderMenssages = renderMenssages;
        this.coin = coin;
    }

    public void render(){
        render.titleScreen("Buy Coins");
        render.subTitleScreen("Coins: " + coin.getCoins());

        btns.itemMenuBtns.get(0).draw(Static.batch);
        btns.itemMenuBtns.get(1).draw(Static.batch);
        btns.itemMenuBtns.get(2).draw(Static.batch);
        btns.itemMenuBtns.get(3).draw(Static.batch);
        btns.itemMenuBtns.get(4).draw(Static.batch);

        render.itemMenuBtnsSimpleText0("50 coins");
        render.itemMenuBtnsSimpleText1("120 coins");
        render.itemMenuBtnsSimpleText2("700 coins");
        render.itemMenuBtnsSimpleText3("8000 coins");
        render.itemMenuBtnsSimpleText4("17000 coins");
    }
}
