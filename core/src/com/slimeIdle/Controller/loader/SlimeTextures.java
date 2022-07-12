package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Animate;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;

public class SlimeTextures {

    Loader loader;
    Slime slime;
    Shop shop;

    public SlimeTextures(Loader loader, Slime slime, Shop shop){
        this.loader = loader;
        this.slime = slime;
        this.shop = shop;
    }

    public void loadSlimeTextures() {

        slime.slimesTexture = new Texture("textures/slimes.png");

        //ArrayMap<String ,TextureRegion> slime = new ArrayMap<String, TextureRegion>();

        // first line
        //loader.posicaoTextureStandard(slime.slimesTexture,0,0);

        slime.slimes.put("default", loader.posicaoTextureStandard(slime.slimesTexture,0,0));
        slime.slimes.put("defaultEquipped", loader.posicaoTextureStandard(slime.slimesTexture,1,0));

        slime.slimes.put("green", loader.posicaoTextureStandard(slime.slimesTexture,0,2));
        int i = 0;
        shop.slimeColorsShopTextures.add(i, slime.slimes.get("green"));
        slime.slimes.put("greenEquipped", loader.posicaoTextureStandard(slime.slimesTexture,1,2));

        //slime.slimes.put("default", new TextureRegion(slime.slimesTexture, 0,0,128,128));
        //slime.slimes.put("defaultEquipped", new TextureRegion(slime.slimesTexture,128,0,128,128));

        //slime.slimes.put("green", new TextureRegion(slime.slimesTexture, 0,256,128,128));
        //shop.slimeColorsShopTextures.add(0, slime.slimes.get("green"));
        //slime.slimes.put("greenEquipped", new TextureRegion(slime.slimesTexture,128,256,128,128));

        slime.slimes.put("blue", loader.posicaoTextureStandard(slime.slimesTexture,2,0));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("blue"));
        slime.slimes.put("blueEquipped", loader.posicaoTextureStandard(slime.slimesTexture,3,0));

        //slime.slimes.put("blue", new TextureRegion(slime.slimesTexture,256,0,128,128));
        //shop.slimeColorsShopTextures.add(1, slime.slimes.get("blue"));
        //slime.slimes.put("blueEquipped", new TextureRegion(slime.slimesTexture,384,0,128,128));

        slime.slimes.put("yellow", loader.posicaoTextureStandard(slime.slimesTexture,4,0));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("yellow"));
        slime.slimes.put("yellowEquipped", loader.posicaoTextureStandard(slime.slimesTexture,5,0));

        //slime.slimes.put("yellow", new TextureRegion(slime.slimesTexture,512,0,128,128));
        //shop.slimeColorsShopTextures.add(2, slime.slimes.get("yellow"));
        //slime.slimes.put("yellowEquipped", new TextureRegion(slime.slimesTexture,640,0,128,128));

        slime.slimes.put("red", loader.posicaoTextureStandard(slime.slimesTexture,6,0));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("red"));
        slime.slimes.put("redEquipped", loader.posicaoTextureStandard(slime.slimesTexture,7,0));

        //slime.slimes.put("red", new TextureRegion(slime.slimesTexture,768,0,128,128));
        //shop.slimeColorsShopTextures.add(3, slime.slimes.get("red"));
        //slime.slimes.put("redEquipped", new TextureRegion(slime.slimesTexture,896,0,128,128));
        //second line

        slime.slimes.put("pink", loader.posicaoTextureStandard(slime.slimesTexture,0,1));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("pink"));
        slime.slimes.put("pinkEquipped", loader.posicaoTextureStandard(slime.slimesTexture,1,1));

        //slime.slimes.put("pink", new TextureRegion(slime.slimesTexture,0,128,128,128));
        //shop.slimeColorsShopTextures.add(4, slime.slimes.get("pink"));
        //slime.slimes.put("pinkEquipped", new TextureRegion(slime.slimesTexture,128,128,128,128));

        slime.slimes.put("purple", loader.posicaoTextureStandard(slime.slimesTexture,2,1));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("purple"));
        slime.slimes.put("purpleEquipped", loader.posicaoTextureStandard(slime.slimesTexture,3,1));

        //slime.slimes.put("purple", new TextureRegion(slime.slimesTexture,256,128,128,128));
        //shop.slimeColorsShopTextures.add(5, slime.slimes.get("purple"));
        //slime.slimes.put("purpleEquipped", new TextureRegion(slime.slimesTexture,384,128,128,128));

        slime.slimes.put("lightBlue", loader.posicaoTextureStandard(slime.slimesTexture,4,1));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("lightBlue"));
        slime.slimes.put("lightBlueEquipped", loader.posicaoTextureStandard(slime.slimesTexture,5,1));

        //slime.slimes.put("lightBlue", new TextureRegion(slime.slimesTexture,512,128,128,128));
        //shop.slimeColorsShopTextures.add(6, slime.slimes.get("lightBlue"));
        //slime.slimes.put("lightBlueEquipped", new TextureRegion(slime.slimesTexture,640,128,128,128));

        slime.slimes.put("orange", loader.posicaoTextureStandard(slime.slimesTexture,6,1));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("orange"));
        slime.slimes.put("orangeEquipped", loader.posicaoTextureStandard(slime.slimesTexture,7,1));

        //slime.slimes.put("orange", new TextureRegion(slime.slimesTexture,768,128,128,128));
        //shop.slimeColorsShopTextures.add(7, slime.slimes.get("orange"));
        //slime.slimes.put("orangeEquipped", new TextureRegion(slime.slimesTexture,896,128,128,128));

        slime.slimes.put("black", loader.posicaoTextureStandard(slime.slimesTexture,2,2));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("black"));
        slime.slimes.put("blackEquipped", loader.posicaoTextureStandard(slime.slimesTexture,3,2));

        //slime.slimes.put("black", new TextureRegion(slime.slimesTexture,256,256,128,128));
        //shop.slimeColorsShopTextures.add(8, slime.slimes.get("black"));
        //slime.slimes.put("blackEquipped", new TextureRegion(slime.slimesTexture,384,256,128,128));

        slime.slimes.put("white", loader.posicaoTextureStandard(slime.slimesTexture,4,2));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("white"));
        slime.slimes.put("whiteEquipped", loader.posicaoTextureStandard(slime.slimesTexture,5,2));

        //slime.slimes.put("white", new TextureRegion(slime.slimesTexture,512,256,128,128));
        //shop.slimeColorsShopTextures.add(9, slime.slimes.get("white"));
        //slime.slimes.put("whiteEquipped", new TextureRegion(slime.slimesTexture,640,256,128,128));

        slime.slimes.put("blue2", loader.posicaoTextureStandard(slime.slimesTexture,6,2));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("blue2"));
        slime.slimes.put("blue2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,7,2));

        slime.slimes.put("yellow2", loader.posicaoTextureStandard(slime.slimesTexture,0,3));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("yellow2"));
        slime.slimes.put("yellow2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,1,3));

        slime.slimes.put("yellow3", loader.posicaoTextureStandard(slime.slimesTexture,2,3));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("yellow3"));
        slime.slimes.put("yellow3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,3,3));

        slime.slimes.put("red2", loader.posicaoTextureStandard(slime.slimesTexture,4,3));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("red2"));
        slime.slimes.put("red2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,5,3));

        slime.slimes.put("red3", loader.posicaoTextureStandard(slime.slimesTexture,6,3));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("red3"));
        slime.slimes.put("red3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,7,3));

        slime.slimes.put("purple2", loader.posicaoTextureStandard(slime.slimesTexture,0,4));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("purple2"));
        slime.slimes.put("purple2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,1,4));

        slime.slimes.put("purple3", loader.posicaoTextureStandard(slime.slimesTexture,2,4));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("purple3"));
        slime.slimes.put("purple3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,3,4));

        slime.slimes.put("blue3", loader.posicaoTextureStandard(slime.slimesTexture,4,4));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("blue3"));
        slime.slimes.put("blue3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,5,4));

        slime.slimes.put("purple4", loader.posicaoTextureStandard(slime.slimesTexture,6,4));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("purple4"));
        slime.slimes.put("purple4Equipped", loader.posicaoTextureStandard(slime.slimesTexture,7,4));

        slime.slimes.put("orange2", loader.posicaoTextureStandard(slime.slimesTexture,0,5));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("orange2"));
        slime.slimes.put("orange2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,1,5));

        slime.slimes.put("orange3", loader.posicaoTextureStandard(slime.slimesTexture,2,5));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("orange3"));
        slime.slimes.put("orange3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,3,5));

        slime.slimes.put("gray", loader.posicaoTextureStandard(slime.slimesTexture,4,5));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("gray"));
        slime.slimes.put("grayEquipped", loader.posicaoTextureStandard(slime.slimesTexture,5,5));

        slime.slimes.put("gray2", loader.posicaoTextureStandard(slime.slimesTexture,6,5));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("gray2"));
        slime.slimes.put("gray2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,7,5));

        slime.slimes.put("green2", loader.posicaoTextureStandard(slime.slimesTexture,0,6));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("green2"));
        slime.slimes.put("green2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,1,6));

        slime.slimes.put("green3", loader.posicaoTextureStandard(slime.slimesTexture,2,6));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("green3"));
        slime.slimes.put("green3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,3,6));

        slime.slimes.put("brown", loader.posicaoTextureStandard(slime.slimesTexture,4,6));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("brown"));
        slime.slimes.put("brownEquipped", loader.posicaoTextureStandard(slime.slimesTexture,5,6));

        slime.slimes.put("brown2", loader.posicaoTextureStandard(slime.slimesTexture,6,6));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("brown2"));
        slime.slimes.put("brown2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,7,6));

        slime.slimes.put("brown3", loader.posicaoTextureStandard(slime.slimesTexture,0,7));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("brown3"));
        slime.slimes.put("brown3Equipped", loader.posicaoTextureStandard(slime.slimesTexture,1,7));

        slime.slimes.put("green4", loader.posicaoTextureStandard(slime.slimesTexture,2,7));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("green4"));
        slime.slimes.put("green4Equipped", loader.posicaoTextureStandard(slime.slimesTexture,3,7));

        slime.slimes.put("blue4", loader.posicaoTextureStandard(slime.slimesTexture,4,7));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("blue4"));
        slime.slimes.put("blue4Equipped", loader.posicaoTextureStandard(slime.slimesTexture,5,7));

        slime.slimes.put("pink2", loader.posicaoTextureStandard(slime.slimesTexture,6,7));
        shop.slimeColorsShopTextures.add(++i, slime.slimes.get("pink2"));
        slime.slimes.put("pink2Equipped", loader.posicaoTextureStandard(slime.slimesTexture,7,7));
    }
}
