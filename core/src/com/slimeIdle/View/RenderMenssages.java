package com.slimeIdle.View;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.Window;

public class RenderMenssages {

    Window window;
    Font font;
    Buttons btns;

    public RenderMenssages(Window window, Font font, Buttons btns){
        this.window = window;
        this.font = font;
        this.btns = btns;
    }

    public void messageSuccess(String msg1, String msg2){
        window.windowSpr.draw(Static.batch);
        font.fontSuccess.draw(Static.batch, msg1,
                (float) (Static.camera.position.x/2),
                (float)(Static.camera.position.y + Static.camera.position.y/10));
        font.fontSuccess.draw(Static.batch, msg2,
                (float) (Static.camera.position.x/2),
                (float)(Static.camera.position.y - Static.camera.position.y/45));
        btns.itemMenuBtns.get(4).draw(Static.batch);
        font.fontTopLevel.draw(Static.batch, "Ok",
                (float)(Static.camera.position.x/1.1),
                (float)(Static.camera.position.y - Static.camera.position.y/2.10));
    }

    public void messageError(String msg1, String msg2){
        window.windowSpr.draw(Static.batch);
        font.fontError.draw(Static.batch, msg1,
                (float) (Static.camera.position.x/2),
                (float)(Static.camera.position.y + Static.camera.position.y/10));
        font.fontError.draw(Static.batch, msg2,
                (float) (Static.camera.position.x/2),
                (float)(Static.camera.position.y - Static.camera.position.y/45));
        btns.itemMenuBtns.get(4).draw(Static.batch);
        font.fontTopLevel.draw(Static.batch, "Ok",
                (float)(Static.camera.position.x/1.1),
                (float)(Static.camera.position.y - Static.camera.position.y/2.10));
    }
}
