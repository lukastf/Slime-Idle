package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Slime;

public class FacesTextures {

    Slime slime;
    Loader loader;

    public FacesTextures(Loader loader, Slime slime) {

        this.loader = loader;
        this.slime = slime;

    }

    public void loadFacesTextures () {


        slime.slimeFacesTexture = new Texture("textures/faces.png");

        slime.slimeFaces.put("default", loader.posicaoTextureStandard(slime.slimeFacesTexture,0,0));
        //slime.slimeFaces.put("default", new TextureRegion(slime.slimeFacesTexture, 0,0,128,128));

        int slimeNameIndex = 1;

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                slime.slimeFaces.put("face" + slimeNameIndex, loader.posicaoTextureStandard(slime.slimeFacesTexture, j,i));
                slimeNameIndex++;
            }
        }

        //slime.slimeFaces.put("face1", loader.posicaoTextureStandard(slime.slimeFacesTexture,0,0));
        //slime.slimeFaces.put("face1", loader.posicaoTextureStandard(slime.slimeFacesTexture,1,0));
        //slime.slimeFaces.put("face2", loader.posicaoTextureStandard(slime.slimeFacesTexture,2,0));
        //slime.slimeFaces.put("face3", loader.posicaoTextureStandard(slime.slimeFacesTexture,3,0));
        //slime.slimeFaces.put("face4", loader.posicaoTextureStandard(slime.slimeFacesTexture,4,0));
        //slime.slimeFaces.put("face5", loader.posicaoTextureStandard(slime.slimeFacesTexture,5,0));
        //slime.slimeFaces.put("face6", loader.posicaoTextureStandard(slime.slimeFacesTexture,6,0));
        //slime.slimeFaces.put("face7", loader.posicaoTextureStandard(slime.slimeFacesTexture,7,0));
    }
}
