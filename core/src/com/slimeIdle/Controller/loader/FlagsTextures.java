package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Flags;

public class FlagsTextures {

    Loader loader;
    Flags flags;

    public FlagsTextures (Loader loader, Flags flags) {

        this.loader = loader;
        this.flags = flags;
    }

    public void loadFlagsTextures () {

        //btn.buttons = new Texture("textures/buttons.png");
        flags.flagsTexture = new Texture("textures/flags.png");

        // primeira linha
        for (int i = 0; i < 8; i++) {

            flags.flags.add(i, loader.posicaoTextureStandard(flags.flagsTexture, i,0));
        }

        // segunda linha
        for (int i = 0; i < 2; i++) {

            flags.flags.add(i, loader.posicaoTextureStandard(flags.flagsTexture, i,1));
        }
    }
}
