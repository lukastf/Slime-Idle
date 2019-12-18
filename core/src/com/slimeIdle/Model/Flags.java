package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;

import java.util.ArrayList;

public class Flags {

    public Texture flagsTexture;

    //public TextureRegion englishFlag, spanishFlag, brazilianFrag, russianFlag, japaneseFlag, koreanFlag, chineseFlag;

    public ArrayList<TextureRegion> flags = new ArrayList<TextureRegion>();

    public void drawFlagIcon(int texture, int menuPosition, ArrayList<ArrayMap<String,Float>> buttonMenuProps) {
        Static.batch.draw(
                flags.get(texture),
                buttonMenuProps.get(menuPosition).get("x") - ( Static.cam.viewportHeight * 0.050f),
                buttonMenuProps.get(menuPosition).get("y"),
                Static.cam.viewportWidth * 0.2f,
                Static.cam.viewportHeight * 0.08f);
    }

}
