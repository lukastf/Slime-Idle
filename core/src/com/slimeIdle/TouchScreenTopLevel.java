package com.slimeIdle;

public class TouchScreenTopLevel {

    VariablesDeclaration vd;
    private float screenX;
    private float screenY;

    public TouchScreenTopLevel(VariablesDeclaration vdRecebido, float screenXRecebido, float screenYRecebido){
        vd = vdRecebido;
        screenX = screenXRecebido;
        screenY = screenYRecebido;
    }

    public boolean touch(){

        if(vd.isMenu_topLevel_PlayerSelecionado()) {
            if(vd.backBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h/2.5)*2)))){
                vd.setMenu_topLevel_PlayerSelecionado(false);
            }
            return true;
        }

        if(vd.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((vd.h/4) * 2))){

            vd.setMenu_topLevel_PlayerSelecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setPlayerTopSelecionado(0);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setPlayerTopSelecionado(5);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setPlayerTopSelecionado(10);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setPlayerTopSelecionado(15);
            }
        }
        if(vd.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((vd.h/8) * 2))){

            vd.setMenu_topLevel_PlayerSelecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setPlayerTopSelecionado(1);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setPlayerTopSelecionado(6);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setPlayerTopSelecionado(11);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setPlayerTopSelecionado(16);
            }
        }
        if(vd.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)){

            vd.setMenu_topLevel_PlayerSelecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setPlayerTopSelecionado(2);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setPlayerTopSelecionado(7);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setPlayerTopSelecionado(12);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setPlayerTopSelecionado(17);
            }
        }
        if(vd.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((vd.h/8) * 2))){

            vd.setMenu_topLevel_PlayerSelecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setPlayerTopSelecionado(3);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setPlayerTopSelecionado(8);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setPlayerTopSelecionado(13);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setPlayerTopSelecionado(18);
            }
        }
        if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){

            vd.setMenu_topLevel_PlayerSelecionado(true);

            if(vd.getCurrentPage() == 1) {
                vd.setPlayerTopSelecionado(4);
            }
            if(vd.getCurrentPage() == 2) {
                vd.setPlayerTopSelecionado(9);
            }
            if(vd.getCurrentPage() == 3) {
                vd.setPlayerTopSelecionado(14);
            }
            if(vd.getCurrentPage() == 4) {
                vd.setPlayerTopSelecionado(19);
            }
        }

        if(vd.prevBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5)*2)))){
            if(vd.getCurrentPage() == 1) {
                return true;
            }
            vd.setCurrentPage(vd.getCurrentPage() - 1);
        }

        if(vd.nextBtn.getBoundingRectangle().contains(screenX,(float) (screenY - ((vd.h / 2.5)*2)))){
            if(vd.getCurrentPage() == 4) {
                return true;
            }
            vd.setCurrentPage(vd.getCurrentPage() + 1);
        }

        return true;
    }

}
