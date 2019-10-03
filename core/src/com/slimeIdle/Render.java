package com.slimeIdle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Render {

    VariablesDeclaration vd;

    public Render(VariablesDeclaration vdRecebido){
        vd = vdRecebido;
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
        vd.tw = sprite.getWidth() * (vd.w/1000);
        vd.th = sprite.getHeight() * (vd.h/1800);

        float positionX = (vd.camera.position.x - (vd.tw/2));
        float positionY = (vd.camera.position.y - (vd.th/2));


        if(position.contains("center")) {
            sprite.setBounds(positionX, positionY, vd.tw, vd.th);
        }
        if (position.contains("loginFace")) {
            sprite.setBounds(positionX,positionY - (float) (vd.h/2.5), vd.tw, vd.th);
        }
        if(position.contains("cart")){
           sprite.setBounds(positionX + (vd.w/3), positionY - (vd.h/3), vd.tw, vd.th);
        }
        if(position.contains("coin")) {
            sprite.setBounds( positionX, positionY - (vd.h/3), vd.tw, vd.th);
        }
        if(position.contains("topLevel")) {
            sprite.setBounds(positionX - (vd.w/3), positionY - (vd.h/3), vd.tw, vd.th);
        }
        if(position.contains("closeWindow")) {
            sprite.setBounds(positionX + (float)(vd.w/2.5),positionY + (float) (vd.h/2.3), vd.tw, vd.th);
        }
        if(position.contains("itemMenuBtn0")){
            sprite.setBounds(positionX, positionY + (vd.h/4), vd.tw, vd.th);
        }
        if (position.contains("itemMenuBtn1")) {
            sprite.setBounds(positionX, positionY + (vd.h/8), vd.tw, vd.th);
        }
        if(position.contains("itemMenuBtn2")) {
            sprite.setBounds(positionX, positionY, vd.tw, vd.th);
        }
        if(position.contains("itemMenuBtn3")) {
            sprite.setBounds(positionX, positionY - (vd.h/8), vd.tw, vd.th);
        }
        if(position.contains("itemMenuBtn4")) {
            sprite.setBounds(positionX, positionY - (vd.h/4), vd.tw, vd.th);
        }
        if(position.contains("iconMenu0")){
            //sprite.setBounds(positionX - (vd.w/4), positionY + (vd.h/4), vd.tw, vd.th);
            sprite.setBounds(positionX - (vd.w/4), positionY * 1.57f, vd.tw, vd.th);
        }
        if(position.contains("iconMenu1")){
            //sprite.setBounds(positionX - (vd.w/4), positionY + (float)(vd.h/8), vd.tw, vd.th);
            sprite.setBounds(positionX - (vd.w/4), positionY * 1.3f, vd.tw, vd.th);
        }
        if(position.contains("iconMenu2")){
            //sprite.setBounds(positionX - (vd.w/4), positionY + (float)(vd.h/60), vd.tw, vd.th);
            sprite.setBounds(positionX - (vd.w/4), positionY * 1.03f, vd.tw, vd.th);
        }
        if(position.contains("iconMenu3")){
            //sprite.setBounds(positionX - (vd.w/4), positionY - (float)(vd.h/9.5), vd.tw, vd.th);
            sprite.setBounds(positionX - (vd.w/4), positionY * 0.76f, vd.tw, vd.th);
        }
        if(position.contains("iconMenu4")){
            //sprite.setBounds(positionX - (vd.w/4), positionY - (float)(vd.h/4.2), vd.tw, vd.th);
            sprite.setBounds(positionX - (vd.w/4), positionY * 0.49f, vd.tw, vd.th);
        }

        if(position.contains("leftDown")) {
            sprite.setBounds(positionX - (vd.w/4), (float) (positionY - (vd.h/2.5)), vd.tw, vd.th);
        }
        if(position.contains("rightDown")) {
            sprite.setBounds(positionX + (vd.w/4), (float) (positionY - (vd.h/2.5)), vd.tw, vd.th);
        }

        return sprite;
    }


    public void titleGame(String str){
        vd.fontTitle.draw(vd.batch, str,
                (float) (vd.camera.position.x / 1.8),
                (float) (vd.camera.position.y + vd.camera.position.y / 1.5));
    }

    public void titleScreen(String str){
        vd.font.draw(vd.batch, str,
                (float) (vd.camera.position.x / 3.5),
                (float) (vd.camera.position.y + vd.camera.position.y / 1.1));
    }

    public void subTitleScreen(String str) {
        vd.fontPlayerSelecionadoLevel.draw(vd.batch, str,
                (float) (vd.camera.position.x/3.5),
                (float)(vd.camera.position.y + vd.camera.position.y/1.3));
    }

    public void nicknameLevelAndTimer() {
        // nickname
        vd.font.draw(vd.batch, vd.getNickname(),
                (float) (vd.camera.position.x / 4.5),
                (float) (vd.camera.position.y + vd.camera.position.y / 1.1));
        // level
        vd.font.draw(vd.batch, "Lv: " + vd.getLevel(),
                (float) (vd.camera.position.x / 4.5),
                (float) (vd.camera.position.y + vd.camera.position.y / 1.3));
        // timer
        vd.font.draw(vd.batch, vd.getLastTimeTouch(),
                (float) (vd.camera.position.x / 4.5),
                (float) (vd.camera.position.y + vd.camera.position.y / 1.6));
    }

    public void topPlayerName(String str) {
        vd.font.draw(vd.batch, str,
                (float) (vd.camera.position.x/10),
                (float)(vd.camera.position.y + vd.camera.position.y/1.1));
    }

    public void pages(String str){
        vd.font.draw(vd.batch, str,
                (float) (vd.camera.position.x/1.2),
                (float)(vd.camera.position.y - vd.camera.position.y/1.34));
        vd.prevBtn.draw(vd.batch);
        vd.nextBtn.draw(vd.batch);
    }

    public void itemMenuBtnsSimpleText0(String str) {

        double space = spaceByLetter(str);

        vd.fontTopLevel.draw(vd.batch, str,
                (float) (vd.camera.position.x / space),
                (float) (vd.camera.position.y + vd.camera.position.y / 1.9));
    }

    public void itemMenuBtnsSimpleText1(String str) {

        double space = spaceByLetter(str);

        vd.fontTopLevel.draw(vd.batch, str,
                (float) (vd.camera.position.x / space),
                (float) (vd.camera.position.y + vd.camera.position.y / 3.6));
    }

    public void itemMenuBtnsSimpleText2(String str) {

        double space = spaceByLetter(str);

        vd.fontTopLevel.draw(vd.batch, str,
                (float) (vd.camera.position.x / space),
                (float) (vd.camera.position.y + vd.camera.position.y / 40));
    }

    public void itemMenuBtnsSimpleText3(String str) {

        double space = spaceByLetter(str);

        vd.fontTopLevel.draw(vd.batch, str,
                (float) (vd.camera.position.x / space),
                (float) (vd.camera.position.y - vd.camera.position.y / 4.6));
    }

    public void itemMenuBtnsSimpleText4(String str) {

        double space = spaceByLetter(str);

        vd.fontTopLevel.draw(vd.batch, str,
                (float) (vd.camera.position.x / space),
                (float) (vd.camera.position.y - vd.camera.position.y / 2.10));
    }

    public void itemMenuBtnsDoubleText0(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        vd.fontTopLevel.draw(vd.batch,
                str1,
                (float)(vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y + vd.camera.position.y/1.8));
        vd.fontTopLevelNumber.draw(vd.batch,
                str2,
                (float)(vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y + vd.camera.position.y/2.05));
    }

    public void itemMenuBtnsDoubleText1(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        vd.fontTopLevel.draw(vd.batch,
                str1,
                (float)(vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y + vd.camera.position.y/3.3));
        vd.fontTopLevelNumber.draw(vd.batch,
                str2,
                (float)(vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y + vd.camera.position.y/4.3));
    }

    public void itemMenuBtnsDoubleText2(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        vd.fontTopLevel.draw(vd.batch,
                str1,
                (float) (vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y + vd.camera.position.y/20));
        vd.fontTopLevelNumber.draw(vd.batch,
                str2,
                (float) (vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y - vd.camera.position.y/45));
    }

    public void itemMenuBtnsDoubleText3(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        vd.fontTopLevel.draw(vd.batch,
                str1,
                (float) (vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y - vd.camera.position.y/5.2));
        vd.fontTopLevelNumber.draw(vd.batch,
                str2,
                (float) (vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y - vd.camera.position.y/3.7));
    }

    public void itemMenuBtnsDoubleText4(String str1, String str2, boolean leftIcon){

        double spaceIcon = spaceByIcon(leftIcon);

        vd.fontTopLevel.draw(vd.batch,
                str1,
                (float)(vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y - vd.camera.position.y/2.25));
        vd.fontTopLevelNumber.draw(vd.batch,
                str2,
                (float) (vd.camera.position.x/spaceIcon),
                (float)(vd.camera.position.y - vd.camera.position.y/1.94));
    }

    public void addFreeCoin(){
        float x = Gdx.graphics.getDeltaTime()*5.2f;
        vd.freeCoinPosition = vd.freeCoinPosition - x;
        vd.font.draw(vd.batch, "+1 Coin!",
                (float) (vd.camera.position.x),
                (float)(vd.camera.position.y + vd.camera.position.y/vd.freeCoinPosition));
        if(vd.freeCoinPosition <= 0.01){
            vd.freeCoin = false;
            vd.freeCoinPosition = 5;
        }

    }

}
