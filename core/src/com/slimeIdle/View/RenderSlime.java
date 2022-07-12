package com.slimeIdle.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;

public class RenderSlime {

    Slime slime;
    Render render;
    RenderItems renderItems;
    Buttons btns;
    Coin coin;

    public RenderSlime(Slime slime, Render render, RenderItems renderItems, Buttons btns, Coin coin) {
        this.slime = slime;
        this.render = render;
        this.renderItems = renderItems;
        this.btns = btns;
        this.coin = coin;
    }

    public boolean mainGame() {

        slime.drawBackground(slime.getBackgroundEquipped(slime.getBackgroundEquippedId()));

        render.nicknameLevelAndTimer();

        //slime
        slime.drawSlime(slime.getSlimeColorEquipped(slime.getSlimeColorEquippedId(), slime.getEquippedItemState()));
        //slime.drawFace();

        if (slime.stateSleep) {
            slime.sleepAnimation();
        } else {
            slime.drawFace();
        }

        if (slime.getItemEquippedId() != 0) renderItems.renderItemsEquipped(0);


        btns.drawCloseWindowBtn();
        btns.drawLanguagesBtn();
        btns.drawCartBtn();
        btns.drawCoinBtn();
        btns.drawTopLevelBtn();
        //btns.drawBackgroundBtn();
        //btns.drawSlimeColorBtn();

        btns.drawSlimeItemsBoughtBtn();

        //System.out.println("burg " + slime.touchScreenSecondsController2);

        if(coin.freeCoin){
            render.addFreeCoin();
        }

        for (int i = 0; i < slime.touchScreenSecondsController.size(); i++) {
            //render.touchScreenSeconds(i);
            if(slime.touchScreenSecondsController.get(i)) {
                render.touchScreenSeconds(i);
            }
        }

        Static.batch.end();
        return true;
    }

    public boolean loginScreen() {

        //background
        slime.drawBackground(slime.generatedBackground);

        //title game
        render.titleGame(AllTextStringsLanguages.titleGame);

        slime.drawSlime(slime.generatedColor);

        if (slime.stateSleep) {
            slime.sleepAnimation();
        } else {
            slime.drawFace();
        }

        // buttons
        btns.drawMenuBtn(4);
        render.itemMenuBtnsSimpleText(AllTextStringsLanguages.login, false,4);
        btns.drawFaceBtn();
        btns.drawLanguagesBtn();

        Static.batch.end();
        return true;
    }
}
