package com.slimeIdle.View;

import com.badlogic.gdx.graphics.Color;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Static;

public class RenderLogoutScreen {

    Buttons btns;
    Render render;

    public RenderLogoutScreen(Buttons btns, Render render){
        this.btns = btns;
        this.render = render;
    }

    public void render(){

        render.titleScreen(AllTextStringsLanguages.logout);

        render.drawTextAllLanguages("font",
                AllTextStringsLanguages.logoutStrings.get(0),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.65f, Color.WHITE);

        render.drawTextAllLanguages("font",
                AllTextStringsLanguages.logoutStrings.get(1),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.6f, Color.WHITE);

        btns.drawMenuBtn(3);
        render.itemMenuBtnsSimpleText(AllTextStringsLanguages.yes,false,3);

        btns.drawMenuBtn(4);
        render.itemMenuBtnsSimpleText(AllTextStringsLanguages.no,false,4);
    }

}
