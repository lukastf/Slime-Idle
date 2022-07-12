package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Slime;

public class BackgroundsTextures {

    Loader loader;
    Slime slime;

    public BackgroundsTextures(Loader loader, Slime slime) {
        this.loader = loader;
        this.slime = slime;
    }

    public void loadBackgroundsTextures() {

        slime.slimeBackgroundsTexture = new Texture("textures/bgs.png");

        //flags.flags.add(i, loader.posicaoTextureStandard(flags.flagsTexture, i,0));

        slime.slimeBackgrounds.put("field", loader.posicaoTextureCustom(slime.slimeBackgroundsTexture, 0,0, 4, 4));
        //slime.slimeBackgrounds.put("field", new TextureRegion(slime.slimeBackgroundsTexture,0,0,512,512));
        slime.slimeBackgrounds.put("wood", loader.posicaoTextureCustom(slime.slimeBackgroundsTexture, 4,0, 4, 4));
        //slime.slimeBackgrounds.put("wood", new TextureRegion(slime.slimeBackgroundsTexture,512,0,512,512));
        slime.slimeBackgrounds.put("city", loader.posicaoTextureCustom(slime.slimeBackgroundsTexture, 0,4, 4, 4));
        //slime.slimeBackgrounds.put("city", new TextureRegion(slime.slimeBackgroundsTexture,0,512,512,512));
        slime.slimeBackgrounds.put("vulcan", loader.posicaoTextureCustom(slime.slimeBackgroundsTexture, 4,4, 4, 4));
        //slime.slimeBackgrounds.put("vulcan", new TextureRegion(slime.slimeBackgroundsTexture,512,512,512,512));
    }
}
