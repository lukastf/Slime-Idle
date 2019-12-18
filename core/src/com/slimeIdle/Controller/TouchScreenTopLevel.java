package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.TopLevel;

public class TouchScreenTopLevel {

    Buttons btn;
    Menu menu;
    TopLevel topLevel;
    //TouchScreenMenu touchScreenMenu;
    //private float screenX;
    //private float screenY;

    public TouchScreenTopLevel(Buttons btn, Menu menu, TopLevel topLevel/*, TouchScreenMenu touchScreenMenu*//*, float screenXRecebido, float screenYRecebido*/){

        this.btn = btn;
        this.menu = menu;
        this.topLevel = topLevel;
        //this.touchScreenMenu = touchScreenMenu;
        //screenX = screenXRecebido;
        //screenY = screenYRecebido;
    }

    public void keyBack () {
        if(menu.isMenu_topLevel()){
            if(menu.isMenu_topLevel_PlayerSelecionado()){
                menu.setMenu_topLevel_PlayerSelecionado(false);
            } else {
                menu.setMenu_topLevel(false);
                menu.setMenu(false);
            }
        }
    }

    public boolean touch(){

        if(menu.isMenu_topLevel_PlayerSelecionado()) {
            if(btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                menu.setMenu_topLevel_PlayerSelecionado(false);
                return true;
            }
            return true;
        }

        if(menu.getMenuCurrentPage() == 1) {
            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(0);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(1);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(2);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(3);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(4);
            }
        }

        if(menu.getMenuCurrentPage() == 2) {
            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(5);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(6);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(7);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(8);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(9);
            }
        }

        if(menu.getMenuCurrentPage() == 3) {
            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(10);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(11);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(12);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(13);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(14);
            }
        }

        if(menu.getMenuCurrentPage() == 4) {
            if(btn.buttonMenuCollision.get(0).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(15);
            }
            if(btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(16);
            }
            if(btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(17);
            }
            if(btn.buttonMenuCollision.get(3).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(18);
            }
            if(btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu_topLevel_PlayerSelecionado(true);
                topLevel.setPlayerTopSelecionado(19);
            }
        }

        return false;
    }

}
