package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Shop;

public class ItemsTextures {

    Loader loader;
    Shop shop;

    public ItemsTextures(Loader loader, Shop shop) {
        this.loader = loader;
        this.shop = shop;
    }

    public void loadItemsTextures () {

        shop.noItemsTexture = new Texture("shop/textures/no_items.png");

        for (int i = 0; i < 4; i++) {

            //shop.itemsShopTextures.add(i, new TextureRegion(shop.noItemsTexture, 0,0,128,128));

            shop.itemsShopTextures.add(i, loader.posicaoTextureStandard(shop.noItemsTexture, i,0));
        }

        shop.holidayItemsTexture = new Texture("shop/textures/holiday_items.png");

        for (int i = 0; i < 5; i++) {
            shop.itemsShopTextures.add(i, loader.posicaoTextureStandard(shop.holidayItemsTexture, i,0));
        }

        shop.commonItemsTexture = new Texture("shop/textures/common_items.png");

        for (int i = 0; i < 8; i++) {
            shop.itemsShopTextures.add(i, loader.posicaoTextureStandard(shop.commonItemsTexture, i,0));
        }

        for (int i = 0; i < 8; i++) {
            shop.itemsShopTextures.add(i, loader.posicaoTextureStandard(shop.commonItemsTexture, i,1));
        }

        for (int i = 0; i < 3; i++) {
            shop.itemsShopTextures.add(i, loader.posicaoTextureStandard(shop.commonItemsTexture, i,2));
        }


        //loja cart



        /*

        i = 0;

        shop.itemsShopTextures.add(i, new TextureRegion(shop.noItemsTexture, 0,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.noItemsTexture, 128,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.noItemsTexture, 256,0,128,128));

        //shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 0,0,128,128));
        //shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 128,0,128,128));
        //shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 256,0,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 0,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 128,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 256,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 384,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 512,0,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 640,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 768,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 896,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 0,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 128,128,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 256,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 384,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 512,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 640,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 768,128,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 896,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 0,256,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 128,256,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 256,256,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 0,0,128,128));*/
    }
}
