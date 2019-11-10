package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Static;

public class RenderCoin {

    Buttons btns;
    Render render;
    RenderMessages renderMessages;
    Coin coin;

    public RenderCoin(Buttons btns, Render render, RenderMessages renderMessages, Coin coin){
        this.btns = btns;
        this.render = render;
        this.renderMessages = renderMessages;
        this.coin = coin;
    }

    public void render(){
        render.titleScreen(AllTextStrings.buyCoins);
        render.subTitleScreen(AllTextStrings.coins[0] + coin.getCoins());

        /*btns.itemMenuBtns.get(0).draw(Static.batch);
        btns.itemMenuBtns.get(1).draw(Static.batch);
        btns.itemMenuBtns.get(2).draw(Static.batch);
        btns.itemMenuBtns.get(3).draw(Static.batch);
        btns.itemMenuBtns.get(4).draw(Static.batch);*/

        for (int i = 0; i < 5; i++) {
            btns.itemMenuBtns.get(i).draw(Static.batch);
            render.itemMenuBtnsSimpleText(AllTextStrings.coinPrices[i]+AllTextStrings.coins[1],i);
        }

        /*
        render.itemMenuBtnsSimpleText0("50 coins");
        render.itemMenuBtnsSimpleText1("120 coins");
        render.itemMenuBtnsSimpleText2("700 coins");
        render.itemMenuBtnsSimpleText3("8000 coins");
        render.itemMenuBtnsSimpleText4("17000 coins");*/
    }
}
