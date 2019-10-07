package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Shop {

    public ArrayList<Texture> itemsShopTextures = new ArrayList<Texture>();
    public ArrayList<Sprite> itemsShopSprites = new ArrayList<Sprite>();
    public ArrayList<String> itemsShopNames = new ArrayList<String>();
    public ArrayList<String> itemsShopPrices = new ArrayList<String>();
    public ArrayList<Boolean> itemsShopBought = new ArrayList<Boolean>();

    public void renderItemsShopSprites(){

        for (int i=0; i<25; i++) {
            itemsShopSprites.add(i, new Sprite());
        }
    }
}
