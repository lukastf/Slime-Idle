package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Slime {

    private int level = 0;
    private String lastTimeTouch = "time...";

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String getLastTimeTouch() {
        return lastTimeTouch;
    }
    public void setLastTimeTouch(String lastTimeTouch) {
        this.lastTimeTouch = lastTimeTouch;
    }

    // Textures
    public Texture slime;

    // Sprites
    public Sprite slimeSpr;

    private int itemEquippedId = 0;

    public int getItemEquippedId() {
        return itemEquippedId;
    }
    public void setItemEquippedId(int itemEquippedId) {
        itemEquippedId = itemEquippedId;
    }

    public void dispose(){
        slime.dispose();
    }
}
