package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Buttons {

    // textures
    public Texture buttonPrev;
    public Texture buttonNext;

    public Texture buttonBuy;
    public Texture buttonEquip;
    public Texture buttonUnequip;
    public Texture loginButton;

    public Sprite closeWindowBtn;
    public Sprite prevBtn;
    public Sprite nextBtn;
    public Sprite backBtn;
    public Sprite buyBtn;
    public Sprite equipBtn;
    public Sprite unequipBtn;
    public Sprite loginButtonBtn;
    public Sprite coinBtn;
    public Sprite cartBtn;
    public Sprite topLevelBtn;

    public ArrayList<Sprite> itemMenuBtns = new ArrayList();

    public void dispose() {
        buttonPrev.dispose();
        buttonNext.dispose();
        buttonBuy.dispose();
        buttonEquip.dispose();
        buttonUnequip.dispose();
        loginButton.dispose();
    }
}
