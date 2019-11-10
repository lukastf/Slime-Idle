package com.slimeIdle.Controller;

import com.badlogic.gdx.Input;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Item;

import java.awt.Paint;

public class InputListener  implements Input.TextInputListener {

    Account acc;
    Item item;
    Encryption encryption;

    private String s;
    private String pass;

    public InputListener(Account account, Item item, Encryption encryption){
        this.acc = account;
        this.item = item;
        this.encryption = encryption;
    }

    @Override
    public void input(String text) {

        /*
        Typeface typeface;
        //initialize the custom font here

        //enter the character to test
        String charToTest="\u0978";
        Paint paint=new Paint();
        paint.setTypeface(typeface);
        boolean hasGlyph=paint.hasGlyph(charToTest);
         */

        //login
        // nickname
        if(item.getItemSelecionado() == -1){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            acc.setNickname(s);
        }

        // password
        if(item.getItemSelecionado() == -2){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }
            acc.passwordsHidden.set(0, pass);

            s = encryption.encrypt(s);
            acc.setPassword(s);
            acc.pass = encryption.encryptIn2(encryption.decrypt(s));
        }

        // create account
        // name
        if(item.getItemSelecionado() == 0){

            s = text;
            s = s.substring(0, Math.min(s.length(), 40));

            acc.createAccountStrings.set(0, s);
        }

        // nickname
        if(item.getItemSelecionado() == 1){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            acc.createAccountStrings.set(1, s);
        }

        // password
        if(item.getItemSelecionado() == 2){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            acc.createAccountStrings.set(2, s);
            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }

            acc.passwordsHidden.set(1, pass);

            s = encryption.encrypt(s);
            acc.setPassword(s);
            acc.pass = encryption.encryptIn2(encryption.decrypt(s));
        }

        // password again
        if(item.getItemSelecionado() == 3){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            acc.createAccountStrings.set(3, s);
            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }

            acc.passwordsHidden.set(2, pass);
        }
    }

    @Override
    public void canceled() {

    }
}
