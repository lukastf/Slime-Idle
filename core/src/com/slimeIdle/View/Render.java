package com.slimeIdle.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;

import java.util.ArrayList;

public class Render {

    Buttons btns;
    Account acc;
    Font font;
    Slime slime;
    Coin coin;

    ArrayList<Float> touchPointX = new ArrayList<Float>();
    ArrayList<Float> touchPointY = new ArrayList<Float>();

    public void initializer () {

        for (int i = 0; i < slime.touchScreenSecondsQty; i++){

            touchPointX.add(i, 0f);
            touchPointY.add(i, 0f);
        }
    }

    public Render(
            Buttons btns,
            Account acc,
            Font font,
            com.slimeIdle.Model.Slime slime,
            Coin coin){

        this.btns = btns;
        this.acc = acc;
        this.font = font;
        this.slime = slime;
        this.coin = coin;
    }

    private float spaceByLetter (String str) {

        float space = 2.6f;

        for(int i=0; i < str.length(); i++) {

            /*
            if(str.length() < 6) {
                space = space + 0.1f;
            } else if (str.length() < 17) {
                space = space + 0.1f;
            } else {
                space = space + 0.01f;
            }*/

            space = space - 0.08f;
        }

        return space;

    }

    private float spaceByIcon (boolean leftIcon) {

        float spaceIcon;

        if(leftIcon){
            spaceIcon = 1.80f;
        } else {
            spaceIcon = 1.20f;
        }

        return spaceIcon;

    }

    private String clearNullGlyphs(String s, int languageCode) {

        String finalWord = "";

        //foreach
        for (char ch: s.toCharArray()) {

            switch (languageCode) {

                case 0:
                    //default
                    if (!font.glypsLatin.contains(Character.toString(ch)) ) {
                        ch = ' ';
                    }
                    break;

                case 1:
                    //russia
                    if (!font.glyphsRussia.contains(Character.toString(ch))) {
                        ch = ' ';
                    }
                    break;

                case 2:
                    //japan
                    if (!font.glypsJapan.contains(Character.toString(ch))) {
                        ch = ' ';
                    }
                    break;

                case 3:
                    //korea
                    if(!font.glypsKorea.contains(Character.toString(ch))){
                        ch = ' ';
                    }
                    break;

                case 4:
                    //china
                    if(!font.glypsChina.contains(Character.toString(ch))){
                        ch = ' ';
                    }
                    break;
            }

            finalWord += ch;
        }

        return finalWord;
    }

    public void drawTextNumbers (String key, String text, float x, float y, Color color) {

        font.fontDefaultCache.get(key).clear();
        font.fontDefaultCache.get(key).setColor(color);
        String textDefault =  this.clearNullGlyphs(text,0);
        font.fontDefaultCache.get(key).addText(textDefault,x,y);

        font.fontDefaultCache.get(key).draw(Static.batch);
    }

    public void drawTextAllLanguages(String key, String text, float x, float y, Color color) {

        //font.fontDefaultCache.put(key,font.fontDefaultCache.get(key).getFont().newFontCache());

        if(!font.fontDefaultCache.isEmpty()) {

            font.fontDefaultCache.get(key).clear();
            font.fontDefaultCache.get(key).setColor(color);
            String textDefault =  this.clearNullGlyphs(text,0);
            font.fontDefaultCache.get(key).addText(textDefault,x,y);

            font.fontDefaultCache.get(key).draw(Static.batch);
        }


        if(!font.fontRussiaCache.isEmpty()) {

            font.fontRussiaCache.get(key).clear();
            font.fontRussiaCache.get(key).setColor(color);
            String textRussia = this.clearNullGlyphs(text, 1);
            font.fontRussiaCache.get(key).addText(textRussia, x, y);

            font.fontRussiaCache.get(key).draw(Static.batch);
        }

        if(!font.fontJapanCache.isEmpty()) {

            font.fontJapanCache.get(key).clear();
            font.fontJapanCache.get(key).setColor(color);
            String textJapan = this.clearNullGlyphs(text, 2);
            font.fontJapanCache.get(key).addText(textJapan, x, y);

            font.fontJapanCache.get(key).draw(Static.batch);
        }

        if (!font.fontKoreaCache.isEmpty()) {

            font.fontKoreaCache.get(key).clear();
            font.fontKoreaCache.get(key).setColor(color);
            String textKorea =  this.clearNullGlyphs(text,3);
            font.fontKoreaCache.get(key).addText(textKorea,x,y);

            font.fontKoreaCache.get(key).draw(Static.batch);
        }

        if (!font.fontChinaCache.isEmpty()) {

            font.fontChinaCache.get(key).clear();
            font.fontChinaCache.get(key).setColor(color);
            String textChina = this.clearNullGlyphs(text, 4);
            font.fontChinaCache.get(key).addText(textChina, x, y);

            font.fontChinaCache.get(key).draw(Static.batch);
        }
    }


    public void titleGame(String str){

        float space = 0;

        for(int i=0; i < str.length(); i++) {

            space = space + 0.02f;
        }

        //System.out.println("merdlher " + space);

        this.drawTextAllLanguages("font", str,Static.cam.viewportWidth * (0.5f-space),Static.cam.viewportHeight * 0.8f,Color.GREEN);

        //Map<String, BitmapFontCache> fontCacheBoolean = AllTextStringsLanguages.selectLanguage(font);
        //BitmapFontCache fontTitle = fontCacheBoolean.get("font").getFont().newFontCache();
        //fontTitle.setColor(Color.GREEN);
        //fontTitle.addText(str,Static.cam.viewportWidth * 0.25f,Static.cam.viewportHeight * 0.8f);
        //fontTitle.draw(Static.batch);
    }

    public void titleScreen(String str){

        this.drawTextAllLanguages("font", str,
                Static.cam.viewportWidth * 0.1f, Static.cam.viewportHeight * 0.95f, Color.WHITE);

        //Map<String, BitmapFontCache> fontCacheBoolean = AllTextStringsLanguages.selectLanguage(font);
        //fontCacheBoolean.get("font").clear();
        //fontCacheBoolean.get("font").addText(str, Static.cam.viewportWidth * 0.1f, Static.cam.viewportHeight * 0.95f);
        //fontCacheBoolean.get("font").draw(Static.batch);
    }

    public void subTitleScreen(String str) {

        this.drawTextAllLanguages("font", str,
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.9f, Color.WHITE);
    }

    public void nicknameLevelAndTimer() {

        // nickname
        this.drawTextAllLanguages("font", acc.getNickname(),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.97f, Color.WHITE);

        //Map<String, BitmapFontCache> fontCacheBoolean = AllTextStringsLanguages.selectLanguage(font);
        //fontCacheBoolean.get("font").clear();
        //fontCacheBoolean = font.fontDefaultCache;

        // level
        //fontCacheBoolean.get("font").addText(AllTextStringsLanguages.lv + slime.getLevel(), Static.cam.viewportWidth * 0.1f,Static.cam.viewportHeight * 0.3f);
        this.drawTextAllLanguages("font", AllTextStringsLanguages.lv + slime.getLevel(),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.92f, Color.WHITE);
        // timer
        //fontCacheBoolean.get("font").addText( slime.getLastTimeTouch(),Static.cam.viewportWidth * 0.1f,Static.cam.viewportHeight * 0.5f);
        this.drawTextAllLanguages("font", slime.getLastTimeTouch(),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.87f, Color.WHITE);
        //fontCacheBoolean.get("font").draw(Static.batch);
    }

    public void topPlayerName(String str) {

        this.drawTextAllLanguages("font", str,
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.95f, Color.WHITE);
    }

    public void pages(String str){

        this.drawTextAllLanguages("font", str, Static.cam.viewportWidth * 0.42f, Static.cam.viewportHeight * 0.09f, Color.WHITE);

        //Map<String, BitmapFontCache> fontCacheBoolean = AllTextStringsLanguages.selectLanguage(font);

        //fontCacheBoolean.get("font").clear();

        //fontCacheBoolean.get("font").addText(str,
                //Static.cam.viewportWidth * 0.42f,
                //Static.cam.viewportHeight * 0.09f);

        //fontCacheBoolean.get("font").draw(Static.batch);

        btns.drawButtonPrevBtn();
        btns.drawButtonNextBtn();
    }

    public void itemMenuBtnsSimpleText(String str, boolean leftIcon, int position) {

        float space = 0;

        if (leftIcon) {
            space = spaceByIcon(leftIcon);
        } else {
            space = spaceByLetter(str);
        }

        switch (position) {
            case 0:
                this.drawTextAllLanguages("topLevel",
                        str,
                        btns.buttonMenuProps.get(0).get("x") * space,
                        btns.buttonMenuProps.get(0).get("y") * 1.06f, Color.BLACK);
                break;
            case 1:
                this.drawTextAllLanguages("topLevel",
                        str,
                        btns.buttonMenuProps.get(1).get("x") * space,
                        btns.buttonMenuProps.get(1).get("y") * 1.08f, Color.BLACK);
                break;
            case 2:
                this.drawTextAllLanguages("topLevel",
                        str,
                        btns.buttonMenuProps.get(2).get("x") * space,
                        btns.buttonMenuProps.get(2).get("y") * 1.1f, Color.BLACK);
                break;
            case 3:
                this.drawTextAllLanguages("topLevel",
                        str,
                        btns.buttonMenuProps.get(3).get("x") * space,
                        btns.buttonMenuProps.get(3).get("y") * 1.15f, Color.BLACK);
                break;
            case 4:
                this.drawTextAllLanguages("topLevel",
                        str,
                        btns.buttonMenuProps.get(4).get("x") * space,
                        btns.buttonMenuProps.get(4).get("y") * 1.3f, Color.BLACK);
                break;
        }
    }

    public void itemMenuBtnsDoubleText(String str1, String str2, boolean leftIcon, int position){

        float spaceIcon = spaceByIcon(leftIcon);

        switch (position){

            case 0:
                this.drawTextAllLanguages("topLevel",
                        str1,
                        btns.buttonMenuProps.get(0).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(0).get("y") * 1.08f, Color.BLACK);
                this.drawTextAllLanguages("topLevelNumber",
                        str2,
                        btns.buttonMenuProps.get(0).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(0).get("y") * 1.04f, Color.BLACK);
                break;

            case 1:
                this.drawTextAllLanguages("topLevel",
                        str1,
                        btns.buttonMenuProps.get(1).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(1).get("y") * 1.10f, Color.BLACK);
                this.drawTextAllLanguages("topLevelNumber",
                        str2,
                        btns.buttonMenuProps.get(1).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(1).get("y") * 1.05f, Color.BLACK);
                break;

            case 2:
                this.drawTextAllLanguages("topLevel",
                        str1,
                        btns.buttonMenuProps.get(2).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(2).get("y") * 1.13f, Color.BLACK);
                this.drawTextAllLanguages("topLevelNumber",
                        str2,
                        btns.buttonMenuProps.get(2).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(2).get("y") * 1.07f, Color.BLACK);
                break;

            case 3:
                this.drawTextAllLanguages("topLevel",
                        str1,
                        btns.buttonMenuProps.get(3).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(3).get("y") * 1.19f, Color.BLACK);
                this.drawTextAllLanguages("topLevelNumber",
                        str2,
                        btns.buttonMenuProps.get(3).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(3).get("y") * 1.10f, Color.BLACK);
                break;

            case 4:
                this.drawTextAllLanguages("topLevel",
                        str1,
                        btns.buttonMenuProps.get(4).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(4).get("y") * 1.40f, Color.BLACK);
                this.drawTextAllLanguages("topLevelNumber",
                        str2,
                        btns.buttonMenuProps.get(4).get("x") * spaceIcon,
                        btns.buttonMenuProps.get(4).get("y") * 1.20f, Color.BLACK);
                break;
        }

    }

    public void addFreeCoin(){

        float x = Gdx.graphics.getDeltaTime()*0.150f;
        coin.freeCoinPosition = coin.freeCoinPosition + x;
        drawTextAllLanguages("font",
                AllTextStringsLanguages.oneCoin,
                Static.cam.viewportWidth * 0.5f,
                Static.cam.viewportHeight * (0.5f + coin.freeCoinPosition), Color.YELLOW);
        if(coin.freeCoinPosition > 1f){
            coin.freeCoin = false;
            coin.freeCoinPosition = 0f;
        }

    }

    public void touchScreenSeconds (int position) {

        if(!slime.touchScreenSecondsTouchPointController.get(position)) {
            touchPointX.set(position, btns.touchPoint.x);
            touchPointY.set(position, btns.touchPoint.y);
        }

        slime.touchScreenSecondsTouchPointController.set(position, true);
        float x = Gdx.graphics.getDeltaTime()*500.650f;
        slime.touchScreenSeconds.set(position, slime.touchScreenSeconds.get(position) + x);

        drawTextNumbers("font",
                /*AllTextStringsLanguages.oneCoin*/
                slime.getTouchPower() + "",
                touchPointX.get(position) /*- (Static.cam.viewportWidth * 0.2f)*/,
                touchPointY.get(position) + slime.touchScreenSeconds.get(position), slime.getSlimeColorEquipped());
        if(slime.touchScreenSeconds.get(position) > 1000f){
            slime.touchScreenSecondsController.set(position, false);
            slime.touchScreenSecondsTouchPointController.set(position, false);
            slime.touchScreenSeconds.set(position, 0f);
        }
    }
}
