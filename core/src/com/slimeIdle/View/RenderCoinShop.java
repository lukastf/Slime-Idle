package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Static;

public class RenderCoinShop {

    Buttons btns;
    Render render;
    Coin coin;

    public RenderCoinShop(Buttons btns, Render render, Coin coin){
        this.btns = btns;
        this.render = render;
        this.coin = coin;
    }

    public void render(){
        render.titleScreen(AllTextStringsLanguages.buyCoins);
        render.subTitleScreen(AllTextStringsLanguages.coins.get(0) + coin.getCoins());

        for (int i = 0; i < 5; i++) {

            btns.drawMenuBtn(i);
            render.itemMenuBtnsSimpleText(AllTextStringsLanguages.coinPrices.get(i)+ AllTextStringsLanguages.coins.get(1),false,i);
        }
    }
}
