package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ArrayMap;

import java.util.ArrayList;

public class Buttons {

    // textures
    public Texture buttons;
    public TextureRegion buttonLoginFace, buttonBattle, buttonPrev, buttonNext, buttonBuy, buttonEquip, buttonUnequip,
            buttonCloseWindow, buttonMenu, buttonCart, buttonCoin, buttonTopLevel, buttonSlimeColor, buttonBackground, buttonLanguage,
            buttonSlimeItemsBought;

    public ArrayMap <String, Float> buttonCloseWindowProps = new ArrayMap<String, Float>(), buttonLoginFaceProps = new ArrayMap<String, Float>(),
            buttonCartProps = new ArrayMap<String, Float>(), buttonCoinProps = new ArrayMap<String, Float>(), buttonTopLevelProps = new ArrayMap<String, Float>(),
            buttonPrevProps = new ArrayMap<String, Float>(),buttonNextProps = new ArrayMap<String, Float>(),
            buttonEquipProps = new ArrayMap<String, Float>(), buttonUnequipProps = new ArrayMap<String, Float>(),
            buttonBuyProps = new ArrayMap<String, Float>(), buttonSlimeColorProps = new ArrayMap<String, Float>(),
            buttonBackgroundProps = new ArrayMap<String, Float>(), buttonLanguageProps = new ArrayMap<String, Float>(),
            buttonSlimeItemsBoughtProps = new ArrayMap<String, Float>();

    public ArrayList<ArrayMap<String,Float>> buttonMenuProps = new ArrayList<ArrayMap<String, Float>>();

    public Vector3 touchPoint;

    public Rectangle buttonCloseCollision, buttonCartCollision, buttonCoinCollision, buttonTopLevelCollision,
            buttonLoginFaceCollision, buttonPrevCollision, buttonNextCollision, buttonUnequipCollision,
            buttonEquipCollision, buttonBuyCollision, buttonSlimeColorCollision, buttonBackgroundCollision, buttonLanguageCollision,
            buttonSlimeItemsBoughtCollision;

    public ArrayList <Rectangle> buttonMenuCollision = new ArrayList<Rectangle>();

    public void drawCloseWindowBtn () {

        Static.batch.draw(
                buttonCloseWindow,
                buttonCloseWindowProps.get("x"),
                buttonCloseWindowProps.get("y"),
                buttonCloseWindowProps.get("width"),
                buttonCloseWindowProps.get("height"));
    }

    public void drawFaceBtn () {

        Static.batch.draw(
                buttonLoginFace,
                buttonLoginFaceProps.get("x"),
                buttonLoginFaceProps.get("y"),
                buttonLoginFaceProps.get("width"),
                buttonLoginFaceProps.get("height"));
    }

    public void drawMenuBtn (int position) {

        switch (position){
            case 0:
                Static.batch.draw(
                        buttonMenu,
                        buttonMenuProps.get(0).get("x"),
                        buttonMenuProps.get(0).get("y"),
                        buttonMenuProps.get(0).get("width"),
                        buttonMenuProps.get(0).get("height"));
                break;
            case 1:
                Static.batch.draw(
                        buttonMenu,
                        buttonMenuProps.get(1).get("x"),
                        buttonMenuProps.get(1).get("y"),
                        buttonMenuProps.get(1).get("width"),
                        buttonMenuProps.get(1).get("height"));
                break;
            case 2:
                Static.batch.draw(
                        buttonMenu,
                        buttonMenuProps.get(2).get("x"),
                        buttonMenuProps.get(2).get("y"),
                        buttonMenuProps.get(2).get("width"),
                        buttonMenuProps.get(2).get("height"));
                break;
            case 3:
                Static.batch.draw(
                        buttonMenu,
                        buttonMenuProps.get(3).get("x"),
                        buttonMenuProps.get(3).get("y"),
                        buttonMenuProps.get(3).get("width"),
                        buttonMenuProps.get(3).get("height"));
                break;
            case 4:
                Static.batch.draw(
                        buttonMenu,
                        buttonMenuProps.get(4).get("x"),
                        buttonMenuProps.get(4).get("y"),
                        buttonMenuProps.get(4).get("width"),
                        buttonMenuProps.get(4).get("height"));
                break;
        }
    }

    public void drawButtonPrevBtn () {

        Static.batch.draw(
                buttonPrev,
                buttonPrevProps.get("x"),
                buttonPrevProps.get("y"),
                buttonPrevProps.get("width"),
                buttonPrevProps.get("height"));
    }

    public void drawButtonNextBtn () {

        Static.batch.draw(
                buttonNext,
                buttonNextProps.get("x"),
                buttonNextProps.get("y"),
                buttonNextProps.get("width"),
                buttonNextProps.get("height"));
    }

    public void drawCartBtn () {

        Static.batch.draw(
                buttonCart,
                buttonCartProps.get("x"),
                buttonCartProps.get("y"),
                buttonCartProps.get("width"),
                buttonCartProps.get("height"));
    }

    public void drawCoinBtn (){

        Static.batch.draw(
                buttonCoin,
                buttonCoinProps.get("x"),
                buttonCoinProps.get("y"),
                buttonCoinProps.get("width"),
                buttonCoinProps.get("height"));
    }

    public void drawTopLevelBtn () {

        Static.batch.draw(
                buttonTopLevel,
                buttonTopLevelProps.get("x"),
                buttonTopLevelProps.get("y"),
                buttonTopLevelProps.get("width"),
                buttonTopLevelProps.get("height"));
    }

    public void drawEquipBtn () {

        Static.batch.draw(
                buttonEquip,
                buttonEquipProps.get("x"),
                buttonEquipProps.get("y"),
                buttonEquipProps.get("width"),
                buttonEquipProps.get("height"));
    }

    public void drawUnequipBtn () {

        Static.batch.draw(
                buttonUnequip,
                buttonUnequipProps.get("x"),
                buttonUnequipProps.get("y"),
                buttonUnequipProps.get("width"),
                buttonUnequipProps.get("height"));
    }

    public void drawBuyBtn () {

        Static.batch.draw(
                buttonBuy,
                buttonBuyProps.get("x"),
                buttonBuyProps.get("y"),
                buttonBuyProps.get("width"),
                buttonBuyProps.get("height"));
    }

    public void drawSlimeColorBtn () {

        Static.batch.draw(
                buttonSlimeColor,
                buttonSlimeColorProps.get("x"),
                buttonSlimeColorProps.get("y"),
                buttonSlimeColorProps.get("width"),
                buttonSlimeColorProps.get("height"));
    }

    public void drawBackgroundBtn () {

        Static.batch.draw(
                buttonBackground,
                buttonBackgroundProps.get("x"),
                buttonBackgroundProps.get("y"),
                buttonBackgroundProps.get("width"),
                buttonBackgroundProps.get("height"));
    }

    public void drawLanguagesBtn () {

        Static.batch.draw(
                buttonLanguage,
                buttonLanguageProps.get("x"),
                buttonLanguageProps.get("y"),
                buttonLanguageProps.get("width"),
                buttonLanguageProps.get("height"));
    }

    public void drawSlimeItemsBoughtBtn () {

        Static.batch.draw(
                buttonSlimeItemsBought,
                buttonSlimeItemsBoughtProps.get("x"),
                buttonSlimeItemsBoughtProps.get("y"),
                buttonSlimeItemsBoughtProps.get("width"),
                buttonSlimeItemsBoughtProps.get("height"));
    }

    public void dispose() {
        buttons.dispose();
    }
}
