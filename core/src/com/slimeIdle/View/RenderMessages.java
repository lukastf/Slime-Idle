package com.slimeIdle.View;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.Window;

import java.util.Map;

public class RenderMessages {

    Window window;
    Font font;
    Buttons btns;
    Render render;

    public RenderMessages(Window window, Font font, Buttons btns, Render render){
        this.window = window;
        this.font = font;
        this.btns = btns;
        this.render = render;
    }


    public void messageSuccess(String msg1, String msg2){

        window.drawWindow();

        render.drawTextAllLanguages("font", msg1, Static.cam.viewportWidth * 0.25f,Static.cam.viewportHeight * 0.35f, Color.GREEN);
        render.drawTextAllLanguages("font", msg2, Static.cam.viewportWidth * 0.25f,Static.cam.viewportHeight * 0.30f, Color.GREEN);

        btns.drawMenuBtn(4);

        render.itemMenuBtnsSimpleText(AllTextStringsLanguages.ok, false,4);
    }

    public void messageError(String msg1, String msg2){

        window.drawWindow();

        render.drawTextAllLanguages("font", msg1, Static.cam.viewportWidth * 0.25f,Static.cam.viewportHeight * 0.35f, Color.RED);
        render.drawTextAllLanguages("font", msg2, Static.cam.viewportWidth * 0.25f,Static.cam.viewportHeight * 0.30f, Color.RED);

        btns.drawMenuBtn(4);

        render.itemMenuBtnsSimpleText(AllTextStringsLanguages.ok, false,4);
    }
}
