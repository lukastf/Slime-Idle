package com.slimeIdle;

import com.badlogic.gdx.Input;

public class InputListener  implements Input.TextInputListener {

    VariablesDeclaration vd;
    private String s;
    private String pass;

    public InputListener(VariablesDeclaration vdRecebido){
        vd = vdRecebido;
    }

    @Override
    public void input(String text) {

        //login
        // nickname
        if(vd.getItemSelecionado() == -1){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            vd.setNickname(s);
        }

        // password
        if(vd.getItemSelecionado() == -2){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }
            vd.passwordsHidden.set(0, pass);

            s = vd.encrypt(s);
            vd.setPassword(s);
            vd.pass = vd.encryptIn2(vd.decrypt(s));
        }

        // create account
        // name
        if(vd.getItemSelecionado() == 0){

            s = text;
            s = s.substring(0, Math.min(s.length(), 40));

            vd.createAccountStrings.set(0, s);
        }

        // nickname
        if(vd.getItemSelecionado() == 1){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            vd.createAccountStrings.set(1, s);
        }

        // password
        if(vd.getItemSelecionado() == 2){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            vd.createAccountStrings.set(2, s);
            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }

            vd.passwordsHidden.set(1, pass);

            s = vd.encrypt(s);
            vd.setPassword(s);
            vd.pass = vd.encryptIn2(vd.decrypt(s));
        }

        // password again
        if(vd.getItemSelecionado() == 3){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            vd.createAccountStrings.set(3, s);
            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }

            vd.passwordsHidden.set(2, pass);
        }
    }

    @Override
    public void canceled() {

    }
}
