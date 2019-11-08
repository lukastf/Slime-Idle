package com.slimeIdle.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Static;

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


    public void titleGame(String str){
        font.fontDefault.get("title").draw(Static.batch, str,
                (float) (Static.camera.position.x / 1.8),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.5));
    }

    public void titleScreen(String str){
        font.fontDefault.get("font").draw(Static.batch, str,
                (float) (Static.camera.position.x / 3.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.1));
    }

    public void subTitleScreen(String str) {
        font.fontDefault.get("playerSelecionadoLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x/3.5),
                (float)(Static.camera.position.y + Static.camera.position.y/1.3));
    }

    public void nicknameLevelAndTimer() {
        // nickname
        font.fontDefault.get("font").draw(Static.batch, acc.getNickname(),
                (float) (Static.camera.position.x / 4.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.1));
        // level
        font.fontDefault.get("font").draw(Static.batch, "Lv: " + slime.getLevel(),
                (float) (Static.camera.position.x / 4.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.3));
        // timer
        font.fontDefault.get("font").draw(Static.batch, slime.getLastTimeTouch(),
                (float) (Static.camera.position.x / 4.5),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.6));
    }

    public void topPlayerName(String str) {
        font.fontDefault.get("font").draw(Static.batch, str,
                (float) (Static.camera.position.x/10),
                (float)(Static.camera.position.y + Static.camera.position.y/1.1));
    }

    public void pages(String str){
        font.fontDefault.get("font").draw(Static.batch, str,
                (float) (Static.camera.position.x/1.2),
                (float)(Static.camera.position.y - Static.camera.position.y/1.34));
        btn.prevBtn.draw(Static.batch);
        btn.nextBtn.draw(Static.batch);
    }

    public void itemMenuBtnsSimpleText0(String str) {

        double space = spaceByLetter(str);

        font.fontDefault.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));

        font.fontJapan.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));



        font.fontKorea.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));



        /*
        font.fontChina.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));


        font.fontTopLevelARABIA.draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 1.9));*/
    }

    public void itemMenuBtnsSimpleText1(String str) {

        //str.contains()

        double space = spaceByLetter(str);

        font.fontDefault.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));



        font.fontJapan.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));




        font.fontKorea.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));



        /*
        font.fontChina.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));



        font.fontTopLevelARABIA.draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 3.6));*/
    }

    public void itemMenuBtnsSimpleText2(String str) {

        double space = spaceByLetter(str);

        font.fontDefault.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y + Static.camera.position.y / 40));
    }

    public void itemMenuBtnsSimpleText3(String str) {

        double space = spaceByLetter(str);

        font.fontDefault.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 4.6));
    }

    public void itemMenuBtnsSimpleText4(String str) {

        double space = spaceByLetter(str);

        font.fontDefault.get("topLevel").draw(Static.batch, str,
                (float) (Static.camera.position.x / space),
                (float) (Static.camera.position.y - Static.camera.position.y / 2.10));
    }

    public void itemMenuBtnsDoubleText0(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        font.fontDefault.get("topLevel").draw(Static.batch,
                str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/1.8));
        font.fontDefault.get("topLevelNumber").draw(Static.batch,
                str2,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/2.05));
    }

    public void itemMenuBtnsDoubleText1(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        font.fontDefault.get("topLevel").draw(Static.batch,
                str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/3.3));
        font.fontDefault.get("topLevelNumber").draw(Static.batch,
                str2,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/4.3));
    }

    public void itemMenuBtnsDoubleText2(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        font.fontDefault.get("topLevel").draw(Static.batch,
                str1,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y + Static.camera.position.y/20));
        font.fontDefault.get("topLevelNumber").draw(Static.batch,
                str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/45));
    }

    public void itemMenuBtnsDoubleText3(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        font.fontDefault.get("topLevel").draw(Static.batch,
                str1,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/5.2));
        font.fontDefault.get("topLevelNumber").draw(Static.batch,
                str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/3.7));
    }

    public void itemMenuBtnsDoubleText4(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        font.fontDefault.get("topLevel").draw(Static.batch,
                str1,
                (float)(Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/2.25));
        font.fontDefault.get("topLevelNumber").draw(Static.batch,
                str2,
                (float) (Static.camera.position.x/spaceIcon),
                (float)(Static.camera.position.y - Static.camera.position.y/1.94));
    }

    public void addFreeCoin(){
        float x = Gdx.graphics.getDeltaTime()*5.2f;
        coin.freeCoinPosition = coin.freeCoinPosition - x;
        font.fontDefault.get("font").draw(Static.batch, "+1 Coin!",
                (float) (Static.camera.position.x),
                (float)(Static.camera.position.y + Static.camera.position.y/coin.freeCoinPosition));
        if(coin.freeCoinPosition <= 0.01){
            coin.freeCoin = false;
            coin.freeCoinPosition = 5;
        }

    }

}
