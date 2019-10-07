package com.slimeIdle.Controller;

import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;

public class TouchScreenTopLevel {

    Buttons btn;
    Menu menu;
    TopLevel topLevel;
    private float screenX;
    private float screenY;

    public TouchScreenTopLevel(Buttons btn, Menu menu, TopLevel topLevel, float screenXRecebido, float screenYRecebido){

        this.btn = btn;
        this.menu = menu;
        this.topLevel = topLevel;
        screenX = screenXRecebido;
        screenY = screenYRecebido;
    }

    public boolean touch(){

        if(menu.isMenu_topLevel_PlayerSelecionado()) {
            if(btn.backBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h/2.5)*2)))){
                menu.setMenu_topLevel_PlayerSelecionado(false);
            }
            return true;
        }

        if(btn.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((Static.h/4) * 2))){

            menu.setMenu_topLevel_PlayerSelecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                topLevel.setPlayerTopSelecionado(0);
            }
            if(menu.getMenuCurrentPage() == 2) {
                topLevel.setPlayerTopSelecionado(5);
            }
            if(menu.getMenuCurrentPage() == 3) {
                topLevel.setPlayerTopSelecionado(10);
            }
            if(menu.getMenuCurrentPage() == 4) {
                topLevel.setPlayerTopSelecionado(15);
            }
        }
        if(btn.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((Static.h/8) * 2))){

            menu.setMenu_topLevel_PlayerSelecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                topLevel.setPlayerTopSelecionado(1);
            }
            if(menu.getMenuCurrentPage() == 2) {
                topLevel.setPlayerTopSelecionado(6);
            }
            if(menu.getMenuCurrentPage() == 3) {
                topLevel.setPlayerTopSelecionado(11);
            }
            if(menu.getMenuCurrentPage() == 4) {
                topLevel.setPlayerTopSelecionado(16);
            }
        }
        if(btn.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)){

            menu.setMenu_topLevel_PlayerSelecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                topLevel.setPlayerTopSelecionado(2);
            }
            if(menu.getMenuCurrentPage() == 2) {
                topLevel.setPlayerTopSelecionado(7);
            }
            if(menu.getMenuCurrentPage() == 3) {
                topLevel.setPlayerTopSelecionado(12);
            }
            if(menu.getMenuCurrentPage() == 4) {
                topLevel.setPlayerTopSelecionado(17);
            }
        }
        if(btn.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((Static.h/8) * 2))){

            menu.setMenu_topLevel_PlayerSelecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                topLevel.setPlayerTopSelecionado(3);
            }
            if(menu.getMenuCurrentPage() == 2) {
                topLevel.setPlayerTopSelecionado(8);
            }
            if(menu.getMenuCurrentPage() == 3) {
                topLevel.setPlayerTopSelecionado(13);
            }
            if(menu.getMenuCurrentPage() == 4) {
                topLevel.setPlayerTopSelecionado(18);
            }
        }
        if(btn.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((Static.h/4) * 2))){

            menu.setMenu_topLevel_PlayerSelecionado(true);

            if(menu.getMenuCurrentPage() == 1) {
                topLevel.setPlayerTopSelecionado(4);
            }
            if(menu.getMenuCurrentPage() == 2) {
                topLevel.setPlayerTopSelecionado(9);
            }
            if(menu.getMenuCurrentPage() == 3) {
                topLevel.setPlayerTopSelecionado(14);
            }
            if(menu.getMenuCurrentPage() == 4) {
                topLevel.setPlayerTopSelecionado(19);
            }
        }

        if(btn.prevBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((Static.h / 2.5)*2)))){
            if(menu.getMenuCurrentPage() == 1) {
                return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() - 1);
        }

        if(btn.nextBtn.getBoundingRectangle().contains(screenX,(float) (screenY - ((Static.h / 2.5)*2)))){
            if(menu.getMenuCurrentPage() == 4) {
                return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() + 1);
        }

        return true;
    }

}
