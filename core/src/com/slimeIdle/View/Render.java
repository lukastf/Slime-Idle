package com.slimeIdle.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Static;

import java.util.Map;

public class Render {

    Buttons btn;
    Account acc;
    Font font;
    com.slimeIdle.Model.Slime slime;
    Coin coin;

    public Render(
            Buttons btn,
            Account acc,
            Font font,
            com.slimeIdle.Model.Slime slime,
            Coin coin){

        this.btn = btn;
        this.acc = acc;
        this.font = font;
        this.slime = slime;
        this.coin = coin;
    }

    private double spaceByLetter (String str) {

        double space = 1;

        for(int i=0; i < str.length(); i++) {
            if(str.length() < 6) {
                space = space + 0.04;
            } else if (str.length() < 17) {
                space = space + 0.05;
            } else {
                space = space + 0.06;
            }
        }

        return space;

    }

    private double spaceByIcon (boolean leftIcon) {

        double spaceIcon;

        if(leftIcon){
            spaceIcon = 1.5;
        } else {
            spaceIcon = 2;
        }

        return spaceIcon;

    }


    public Sprite sprite(Sprite sprite, Texture texture, String position) {

        sprite = new Sprite(texture);
        Static.tw = sprite.getWidth() * (Static.w/1000);
        Static.th = sprite.getHeight() * (Static.h/1800);

        float positionX = (Static.camera.position.x - (Static.tw/2));
        float positionY = (Static.camera.position.y - (Static.th/2));


        if(position.contains("center")) {
            sprite.setBounds(positionX, positionY, Static.tw, Static.th);
        }
        if (position.contains("loginFace")) {
            sprite.setBounds(positionX,positionY - (float) (Static.h/2.5), Static.tw, Static.th);
        }
        if(position.contains("cart")){
           sprite.setBounds(positionX + (Static.w/3), positionY - (Static.h/3), Static.tw, Static.th);
        }
        if(position.contains("coin")) {
            sprite.setBounds( positionX, positionY - (Static.h/3), Static.tw, Static.th);
        }
        if(position.contains("topLevel")) {
            sprite.setBounds(positionX - (Static.w/3), positionY - (Static.h/3), Static.tw, Static.th);
        }
        if(position.contains("closeWindow")) {
            sprite.setBounds(positionX + (float)(Static.w/2.5),positionY + (float) (Static.h/2.3), Static.tw, Static.th);
        }
        if(position.contains("itemMenuBtn0")){

            sprite.setBounds(positionX, positionY + (Static.h/4), Static.tw, Static.th);
        }
        if (position.contains("itemMenuBtn1")) {
            sprite.setBounds(positionX, positionY + (Static.h/8), Static.tw, Static.th);
        }
        if(position.contains("itemMenuBtn2")) {
            sprite.setBounds(positionX, positionY, Static.tw, Static.th);
        }
        if(position.contains("itemMenuBtn3")) {
            sprite.setBounds(positionX, positionY - (Static.h/8), Static.tw, Static.th);
        }
        if(position.contains("itemMenuBtn4")) {
            sprite.setBounds(positionX, positionY - (Static.h/4), Static.tw, Static.th);
        }
        if(position.contains("iconMenu0")){
            sprite.setBounds(positionX - (Static.w/4), positionY * 1.57f, Static.tw, Static.th);
        }
        if(position.contains("iconMenu1")){
            sprite.setBounds(positionX - (Static.w/4), positionY * 1.3f, Static.tw, Static.th);
        }
        if(position.contains("iconMenu2")){
            sprite.setBounds(positionX - (Static.w/4), positionY * 1.03f, Static.tw, Static.th);
        }
        if(position.contains("iconMenu3")){
            sprite.setBounds(positionX - (Static.w/4), positionY * 0.76f, Static.tw, Static.th);
        }
        if(position.contains("iconMenu4")){
            sprite.setBounds(positionX - (Static.w/4), positionY * 0.49f, Static.tw, Static.th);
        }

        if(position.contains("leftDown")) {
            sprite.setBounds(positionX - (Static.w/4), (float) (positionY - (Static.h/2.5)), Static.tw, Static.th);
        }
        if(position.contains("rightDown")) {
            sprite.setBounds(positionX + (Static.w/4), (float) (positionY - (Static.h/2.5)), Static.tw, Static.th);
        }

        return sprite;
    }

    private Map<String, BitmapFontCache> selectLanguage() {

        Map<String, BitmapFontCache> fntLang = null;

        if (font.language == "default") {
            fntLang = font.fontDefaultCache;
        }
        if (font.language == "japan") {
            fntLang = font.fontJapanCache;
        }
        if (font.language == "korea") {
            fntLang = font.fontKoreaCache;
        }
        if (font.language == "china") {
            fntLang = font.fontChinaCache;
        }

        return fntLang;
    }

    private String clearNullGlyphs(String s, int languageCode) {

        String finalWord = "";

        //System.out.println("batata frita" + s);

        //char oi[] = s.toCharArray();



        //foreach
        for (char ch: s.toCharArray()) {
            //int intValue = (int)ch;

            //System.out.println("batata frita" + oi[0] + intValue);

            switch (languageCode) {

                case 0:
                    //default
                    /*if ( (intValue > 32 && intValue < 128) || (intValue > 160 && intValue < 256) ) {*/
                    if ( font.glyps.contains(Character.toString(ch)) ) {

                    } else {
                        ch = ' ';
                    }
                    break;
                case 1:
                    //japan
                    /*if ( (intValue > 12352 && intValue < 12544) || (intValue > 12687 && intValue < 12704) || (intValue > 12783 && intValue < 12800) ) {*/
                    if (font.glypsJapan.contains(Character.toString(ch))) {

                    } else {
                        ch = ' ';
                    }
                    break;
                case 2:
                    //korea
                    /*if ( (intValue > 4351 && intValue < 4608) || (intValue > 12591 && intValue < 12688) || (intValue > 109567 && intValue < 120740) ) {*/
                    if(font.glypsKorea.contains(Character.toString(ch))){

                    } else {
                        ch = ' ';
                    }


                    break;
            }

            finalWord += ch;
        }
        
        //char charAtZero = s.charAt(0);
        //System.out.println("finalWord" + finalWord);

        return finalWord;
    }

    private void drawTextAllLanguages(String key, String text, float x, float y) {

        font.fontDefaultCache.get(key).clear();
        font.fontJapanCache.get(key).clear();
        font.fontKoreaCache.get(key).clear();

        String textDefault =  this.clearNullGlyphs(text,0);
        font.fontDefaultCache.get(key).addText(textDefault,x,y);

        String textJapan =  this.clearNullGlyphs(text,1);
        font.fontJapanCache.get(key).addText(textJapan,x,y);

        String textKorea =  this.clearNullGlyphs(text,2);
        font.fontKoreaCache.get(key).addText(textKorea,x,y);
        //key =  this.clearNullGlyphs(text,3);
        //font.fontChinaCache.get(key).addText(text,x,y);

        font.fontDefaultCache.get(key).draw(Static.batch);
        font.fontJapanCache.get(key).draw(Static.batch);
        font.fontKoreaCache.get(key).draw(Static.batch);
    }


    public void titleGame(String str){

        Map<String, BitmapFontCache> fontCache = this.selectLanguage();
        BitmapFontCache fontTitle = fontCache.get("font").getFont().newFontCache();
        fontTitle.setColor(Color.GREEN);
        fontTitle.addText(str, (float) (Static.camera.position.x / 1.8), (float) (Static.camera.position.y + Static.camera.position.y / 1.5));
        fontTitle.draw(Static.batch);
    }

    public void titleScreen(String str){

        Map<String, BitmapFontCache> fontCache = this.selectLanguage();
        fontCache.get("font").clear();
        fontCache.get("font").addText(str, (float) (Static.camera.position.x / 3.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.1));
        fontCache.get("font").draw(Static.batch);
    }

    public void subTitleScreen(String str) {

        Map<String, BitmapFontCache> fontCache = this.selectLanguage();
        fontCache.get("message").clear();
        fontCache.get("message").addText(str, (float)(Static.camera.position.x/3.5),
                (float)(Static.camera.position.y + Static.camera.position.y/1.3));
        fontCache.get("message").draw(Static.batch);
    }

    public void nicknameLevelAndTimer() {

        // nickname

        this.drawTextAllLanguages("font", acc.getNickname(), (float) (Static.camera.position.x / 4.5), (float) (Static.camera.position.y + Static.camera.position.y / 1.1));

        /*fontCache.get("font").addText(acc.getNickname(),
                (float) (Static.camera.position.x / 4.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.1));*/

        Map<String, BitmapFontCache> fontCache = this.selectLanguage();
        fontCache.get("font").clear();
        fontCache = font.fontDefaultCache;

        // level
        fontCache.get("font").addText(AllTextStrings.lv + slime.getLevel(),
                (float) (Static.camera.position.x / 4.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.3));
        // timer
        fontCache.get("font").addText( slime.getLastTimeTouch(),
                (float) (Static.camera.position.x / 4.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.6));

        fontCache.get("font").draw(Static.batch);
    }

    public void topPlayerName(String str) {

        //Map<String, BitmapFontCache> fontCache = this.selectLanguage();

        //fontCache.get("font").clear();

        this.drawTextAllLanguages("font", str, (float) (Static.camera.position.x/10),
                (float)(Static.camera.position.y + Static.camera.position.y/1.1));

        /*fontCache.get("font").addText(str,
                (float) (Static.camera.position.x/10),
                (float)(Static.camera.position.y + Static.camera.position.y/1.1));*/

       // fontCache.get("font").draw(Static.batch);

        /*font.fontDefaultCache.get("font").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x/10),
                (float)(Static.camera.position.y + Static.camera.position.y/1.1));*/
    }

    public void pages(String str){

        Map<String, BitmapFontCache> fontCache = this.selectLanguage();

        fontCache.get("font").clear();

        fontCache.get("font").addText(str,
                (float) (Static.camera.position.x/1.2),
                (float)(Static.camera.position.y - Static.camera.position.y/1.34));

        fontCache.get("font").draw(Static.batch);

       /* font.fontDefaultCache.get("font").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x/1.2),
                (float)(Static.camera.position.y - Static.camera.position.y/1.34));*/

        btn.prevBtn.draw(Static.batch);
        btn.nextBtn.draw(Static.batch);
    }

    public void itemMenuBtnsSimpleText(String str, int position) {

        double space = spaceByLetter(str);

        switch (position) {
            case 0:
                this.drawTextAllLanguages("topLevel", str,(float) (Static.camera.position.x / space),
                        (float) (Static.camera.position.y + Static.camera.position.y / 1.9));
                break;
            case 1:
                this.drawTextAllLanguages("topLevel",str, (float) (Static.camera.position.x / space),
                        (float) (Static.camera.position.y + Static.camera.position.y / 3.6));
                break;
            case 2:
                this.drawTextAllLanguages("topLevel", str, (float) (Static.camera.position.x / space),
                        (float) (Static.camera.position.y + Static.camera.position.y / 40));
                break;
            case 3:
                this.drawTextAllLanguages("topLevel", str, (float) (Static.camera.position.x / space),
                        (float) (Static.camera.position.y - Static.camera.position.y / 4.6));
                break;
            case 4:
                this.drawTextAllLanguages("topLevel", str, (float) (Static.camera.position.x / space),
                        (float) (Static.camera.position.y - Static.camera.position.y / 2.10));
                break;
        }
    }

    /*public void itemMenuBtnsSimpleText0(String str) {

        double space = spaceByLetter(str);

        this.addTextAllLanguages("topLevel", str,(float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));

        /*
        Map<String, BitmapFontCache> fontCache = this.selectLanguage();

        font.fontDefaultCache.get("topLevel").clear();
        font.fontJapanCache.get("topLevel").clear();
        font.fontKoreaCache.get("topLevel").clear();

        font.fontDefaultCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));

        font.fontJapanCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));

        font.fontKoreaCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));

        font.fontDefaultCache.get("topLevel").draw(Static.batch);
        font.fontJapanCache.get("topLevel").draw(Static.batch);
        font.fontKoreaCache.get("topLevel").draw(Static.batch);


        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));

        font.fontJapanCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));



        font.fontKoreaCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));



        /*
        font.fontChina.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));


        font.fontTopLevelARABIA.draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));
    }

    public void itemMenuBtnsSimpleText1(String str) {

        //str.contains()

        double space = spaceByLetter(str);

        this.addTextAllLanguages("topLevel",str, (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));

        /*

        font.fontDefaultCache.get("topLevel").clear();
        font.fontJapanCache.get("topLevel").clear();
        font.fontKoreaCache.get("topLevel").clear();

        font.fontDefaultCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));

        font.fontJapanCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));

        font.fontKoreaCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));

        font.fontDefaultCache.get("topLevel").draw(Static.batch);
        font.fontJapanCache.get("topLevel").draw(Static.batch);
        font.fontKoreaCache.get("topLevel").draw(Static.batch);



        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));



        font.fontJapanCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));




        font.fontKoreaCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));




        font.fontChina.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));



        font.fontTopLevelARABIA.draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));
    }

    public void itemMenuBtnsSimpleText2(String str) {

        double space = spaceByLetter(str);

        this.addTextAllLanguages("topLevel", str, (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 40));

        /*

        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 40));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);



        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 40));
    }

    public void itemMenuBtnsSimpleText3(String str) {

        double space = spaceByLetter(str);

        this.addTextAllLanguages("topLevel", str, (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 4.6));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 4.6));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);


        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 4.6));
    }

    public void itemMenuBtnsSimpleText4(String str) {

        double space = spaceByLetter(str);

        this.addTextAllLanguages("topLevel", str, (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 2.10));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 2.10));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 2.10));
    }*/

    public void itemMenuBtnsDoubleText(String str1, String str2, boolean leftIcon, int position){

        double spaceIcon = spaceByIcon(leftIcon);

        switch (position){

            case 0:
                this.drawTextAllLanguages("topLevel", str1, (float)(Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y + Static.camera.position.y/1.8));
                this.drawTextAllLanguages("topLevelNumber", str2, (float)(Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y + Static.camera.position.y/2.05));
                break;

            case 1:
                this.drawTextAllLanguages("topLevel", str1, (float)(Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y + Static.camera.position.y/3.3));
                this.drawTextAllLanguages("topLevelNumber", str2, (float)(Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y + Static.camera.position.y/4.3));
                break;

            case 2:
                this.drawTextAllLanguages("topLevel", str1, (float) (Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y + Static.camera.position.y/20));
                this.drawTextAllLanguages("topLevelNumber", str2, (float) (Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y - Static.camera.position.y/45));
                break;

            case 3:
                this.drawTextAllLanguages("topLevel", str1, (float) (Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y - Static.camera.position.y/5.2));
                this.drawTextAllLanguages("topLevelNumber", str2, (float) (Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y - Static.camera.position.y/3.7));
                break;

            case 4:
                this.drawTextAllLanguages("topLevel", str1, (float)(Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y - Static.camera.position.y/2.25));
                this.drawTextAllLanguages("topLevelNumber", str2, (float) (Static.camera.position.x/spaceIcon),
                        (float)(Static.camera.position.y - Static.camera.position.y/1.94));
                break;
        }

    }

    /*
    public void itemMenuBtnsDoubleText0(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        this.addTextAllLanguages("topLevel", str1, (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/1.8));

        this.addTextAllLanguages("topLevelNumber", str2, (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/2.05));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/1.8));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        font.fontDefaultCache.get("topLevelNumber").clear();
        font.fontDefaultCache.get("topLevelNumber").addText(str2,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/2.05));
        font.fontDefaultCache.get("topLevelNumber").draw(Static.batch);


        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch,
                str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/1.8));
        font.fontDefaultCache.get("topLevelNumber").getFont().draw(Static.batch,
                str2,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/2.05));
    }

    public void itemMenuBtnsDoubleText1(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        this.addTextAllLanguages("topLevel", str1, (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/3.3));
        this.addTextAllLanguages("topLevelNumber", str2, (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/4.3));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/3.3));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        font.fontDefaultCache.get("topLevelNumber").clear();
        font.fontDefaultCache.get("topLevelNumber").addText(str2,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/4.3));
        font.fontDefaultCache.get("topLevelNumber").draw(Static.batch);


        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch,
                str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/3.3));
        font.fontDefaultCache.get("topLevelNumber").getFont().draw(Static.batch,
                str2,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/4.3));
    }

    public void itemMenuBtnsDoubleText2(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        this.addTextAllLanguages("topLevel", str1, (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/20));

        this.addTextAllLanguages("topLevelNumber", str2, (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/45));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str1,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/20));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        font.fontDefaultCache.get("topLevelNumber").clear();
        font.fontDefaultCache.get("topLevelNumber").addText(str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/45));
        font.fontDefaultCache.get("topLevelNumber").draw(Static.batch);

        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch,
                str1,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/20));
        font.fontDefaultCache.get("topLevelNumber").getFont().draw(Static.batch,
                str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/45));
    }

    public void itemMenuBtnsDoubleText3(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        this.addTextAllLanguages("topLevel", str1, (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/5.2));

        this.addTextAllLanguages("topLevelNumber", str2, (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/3.7));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str1,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/5.2));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        font.fontDefaultCache.get("topLevelNumber").clear();
        font.fontDefaultCache.get("topLevelNumber").addText(str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/3.7));
        font.fontDefaultCache.get("topLevelNumber").draw(Static.batch);


        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch,
                str1,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/5.2));
        font.fontDefaultCache.get("topLevelNumber").getFont().draw(Static.batch,
                str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/3.7));
    }

    public void itemMenuBtnsDoubleText4(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        this.addTextAllLanguages("topLevel", str1, (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/2.25));

        this.addTextAllLanguages("topLevelNumber", str2, (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/1.94));

        /*
        font.fontDefaultCache.get("topLevel").clear();
        font.fontDefaultCache.get("topLevel").addText(str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/2.25));
        font.fontDefaultCache.get("topLevel").draw(Static.batch);

        font.fontDefaultCache.get("topLevelNumber").clear();
        font.fontDefaultCache.get("topLevelNumber").addText(str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/1.94));
        font.fontDefaultCache.get("topLevelNumber").draw(Static.batch);


        font.fontDefaultCache.get("topLevel").getFont().draw(Static.batch,
                str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/2.25));
        font.fontDefaultCache.get("topLevelNumber").getFont().draw(Static.batch,
                str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/1.94));
    }*/

    public void addFreeCoin(){

        float x = Gdx.graphics.getDeltaTime()*5.2f;
        coin.freeCoinPosition = coin.freeCoinPosition - x;
        font.fontDefaultCache.get("font").clear();
        font.fontDefaultCache.get("font").addText(AllTextStrings.oneCoin,
                (float) (Static.camera.position.x),
                (float)(Static.camera.position.y + Static.camera.position.y/coin.freeCoinPosition));
        font.fontDefaultCache.get("font").draw(Static.batch);
        /*
        font.fontDefaultCache.get("font").getFont().draw(Static.batch, "+1 Coin!",
                (float) (Static.camera.position.x),
                (float)(Static.camera.position.y + Static.camera.position.y/coin.freeCoinPosition));*/
        if(coin.freeCoinPosition <= 0.01){
            coin.freeCoin = false;
            coin.freeCoinPosition = 5;
        }

    }

}
