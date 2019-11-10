package com.slimeIdle.View;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.Window;

public class RenderMessages {

    Window window;
    Font font;
    Buttons btns;

    public RenderMessages(Window window, Font font, Buttons btns){
        this.window = window;
        this.font = font;
        this.btns = btns;
    }

    public void messageSuccess(String msg1, String msg2){

        window.windowSpr.draw(Static.batch);

        BitmapFontCache fontSuccess = font.fontDefaultCache.get("message").getFont().newFontCache();

        fontSuccess.setColor(Color.GREEN);

        fontSuccess.addText(msg1,(float) (Static.camera.position.x/2), (float)(Static.camera.position.y + Static.camera.position.y/10));

        fontSuccess.addText(msg2, (float) (Static.camera.position.x/2), (float)(Static.camera.position.y - Static.camera.position.y/45));

        fontSuccess.draw(Static.batch);

        /*
        fontSuccess.getFont().draw(Static.batch, msg1,
                (float) (Static.camera.position.x/2),
                (float)(Static.camera.position.y + Static.camera.position.y/10));
        fontSuccess.getFont().draw(Static.batch, msg2,
                (float) (Static.camera.position.x/2),
                (float)(Static.camera.position.y - Static.camera.position.y/45));*/
        btns.itemMenuBtns.get(4).draw(Static.batch);

        font.fontDefaultCache.get("topLevel").clear();

        font.fontDefaultCache.get("topLevel").addText(AllTextStrings.ok, (float)(Static.camera.position.x/1.1), (float)(Static.camera.position.y - Static.camera.position.y/2.10));

        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        /*font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, "Ok",
                (float)(Static.camera.position.x/1.1),
                (float)(Static.camera.position.y - Static.camera.position.y/2.10));*/
    }

    public void messageError(String msg1, String msg2){

        window.windowSpr.draw(Static.batch);

        BitmapFontCache fontError = font.fontDefaultCache.get("message").getFont().newFontCache();

        fontError.setColor(Color.RED);

        fontError.addText(msg1, (float) (Static.camera.position.x/2), (float)(Static.camera.position.y + Static.camera.position.y/10));

        fontError.addText(msg2, (float) (Static.camera.position.x/2), (float)(Static.camera.position.y - Static.camera.position.y/45));

        fontError.draw(Static.batch);
        //fontError.getFont().draw(Static.batch, msg2);
        btns.itemMenuBtns.get(4).draw(Static.batch);

        font.fontDefaultCache.get("topLevel").clear();

        font.fontDefaultCache.get("topLevel").addText(AllTextStrings.ok, (float)(Static.camera.position.x/1.1), (float)(Static.camera.position.y - Static.camera.position.y/2.10));

        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        /*font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, "Ok",
                (float)(Static.camera.position.x/1.1),
                (float)(Static.camera.position.y - Static.camera.position.y/2.10));*/
    }
}
