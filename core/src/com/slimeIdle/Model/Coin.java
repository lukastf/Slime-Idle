package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Coin {

    private int coins = 0;

    // Textures
    public Texture coin;

    public float freeCoinPosition = 5;
    public boolean freeCoin = false;

    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void dispose() {
        coin.dispose();
    }
}
