package com.slimeIdle;

import com.badlogic.gdx.Gdx;

public class TouchScreenLoginScreen {
    VariablesDeclaration vd;
    SocketSlime socketSlime;
    private float screenX;
    private float screenY;
    InputListener listener;

    public TouchScreenLoginScreen(VariablesDeclaration vdRecebido, SocketSlime socketSlimeRecebido, float screenXRecebido, float screenYRecebido, InputListener listenerRecebido){
        vd = vdRecebido;
        socketSlime = socketSlimeRecebido;
        screenX = screenXRecebido;
        screenY = screenYRecebido;
        listener = listenerRecebido;
    }

    public boolean touch(){

        if(!vd.isCreateAccountSuccess() && !vd.isCreateAccountError() && !vd.isCreateAccountErrorPass()
                && !vd.isLoginSuccess() && !vd.isLoginError()){
            if (vd.closeWindowBtn.getBoundingRectangle().contains(screenX, (float) (screenY + ((vd.h / 2.3) * 2)))) {
                vd.setLoginScreen(false);
                vd.setCreateAccount(false);
                return true;
            }
        }
        if(vd.isCreateAccount()){

            if(!vd.isCreateAccountSuccess() && !vd.isCreateAccountError() && !vd.isCreateAccountErrorPass()) {

                if (vd.backBtn.getBoundingRectangle().contains(screenX, (float) (screenY - ((vd.h / 2.5) * 2)))) {
                    vd.setCreateAccount(false);
                }


                if (vd.itemMenuBtns.get(0).getBoundingRectangle().contains(screenX, screenY + ((vd.h / 4) * 2))) {
                    vd.setItemSelecionado(0);
                    Gdx.input.getTextInput(listener, "Name", "", "Insert your Name");
                }

                if (vd.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((vd.h / 8) * 2))) {
                    vd.setItemSelecionado(1);
                    Gdx.input.getTextInput(listener, "Nickname", "", "Insert your Nickname");
                }

                if (vd.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)) {
                    vd.setItemSelecionado(2);
                    Gdx.input.getTextInput(listener, "Password", "", "Insert your Password");
                }

                if (vd.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((vd.h / 8) * 2))) {
                    vd.setItemSelecionado(3);
                    Gdx.input.getTextInput(listener, "re-enter Password", "", "Insert your Password again");
                }

                if (vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h / 4) * 2))) {

                    if (vd.createAccountStrings.get(2).matches(vd.createAccountStrings.get(3))) {
                        socketSlime.createAccount();
                    } else {
                        vd.setCreateAccountErrorPass(true);
                    }

                }

                return true;

            }
            if(vd.isCreateAccountSuccess() || vd.isCreateAccountError() || vd.isCreateAccountErrorPass()) {
                if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){
                    vd.setCreateAccountSuccess(false);
                    vd.setCreateAccountError(false);
                    vd.setCreateAccountErrorPass(false);
                }
            }

        } else {

            if(!vd.isLoginSuccess() && !vd.isLoginError()) {
                if (vd.itemMenuBtns.get(1).getBoundingRectangle().contains(screenX, screenY + ((vd.h / 8) * 2))) {
                    vd.setItemSelecionado(-1);
                    Gdx.input.getTextInput(listener, "Nickname", "", "Insert your Nickname");
                }

                if (vd.itemMenuBtns.get(2).getBoundingRectangle().contains(screenX, screenY)) {
                    vd.setItemSelecionado(-2);
                    Gdx.input.getTextInput(listener, "Password", "", "Insert your Password");
                }

                if (vd.itemMenuBtns.get(3).getBoundingRectangle().contains(screenX, screenY - ((vd.h / 8) * 2))) {
                    vd.pass = vd.encryptIn2(vd.decrypt(vd.getPassword()));
                    socketSlime.loginAccount();
                }

                if (vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h / 4) * 2))) {
                    vd.setCreateAccount(true);
                }

                return true;

            }
            if(vd.isLoginSuccess() || vd.isLoginError()) {
                if(vd.itemMenuBtns.get(4).getBoundingRectangle().contains(screenX, screenY - ((vd.h/4) * 2))){

                    if(vd.isLoginSuccess() && !vd.isLoginError()) {
                        socketSlime.connectSocket();
                        socketSlime.configSocketEvents();
                        vd.setLoginSuccess(false);
                        vd.setLogin(true);
                    }

                    vd.setLoginError(false);
                }
            }
        }

        return true;
    }
}
