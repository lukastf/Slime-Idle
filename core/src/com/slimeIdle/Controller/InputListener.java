package com.slimeIdle.Controller;

import com.badlogic.gdx.Input;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.Item;

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

        //login
        // nickname
        if(item.getItemId() == -1){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            acc.loginStrings.set(0,s);
            acc.setNickname(s);
        }

        // password
        if(item.getItemId() == -2){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }
            acc.loginStrings.set(1, pass);

            s = encryption.encrypt(s);
            acc.setPassword(s);
            acc.pass = encryption.encryptIn2(encryption.decrypt(s));
        }

        // create account
        // name
        //if(item.getItemId() == 0){

        //    s = text;
        //    s = s.substring(0, Math.min(s.length(), 40));

        //    acc.createAccountStrings.set(0, s);
        //}

        // nickname
        if(item.getItemId() == 1){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            acc.createAccountStrings.set(0, s);
        }

        // password
        if(item.getItemId() == 2){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            // pass hidden
            acc.createAccountStrings.set(3, s);
            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }

            acc.createAccountStrings.set(1, pass);

            s = encryption.encrypt(s);
            acc.setPassword(s);
            System.out.println(encryption.decrypt(s));
            acc.pass = encryption.encryptIn2(encryption.decrypt(s));
        }

        // password again
        if(item.getItemId() == 3){

            s = text;
            s = s.substring(0, Math.min(s.length(), 16));

            //pass hidden again
            acc.createAccountStrings.set(4, s);
            pass = "";

            for(int i=0; i < s.length(); i++) {
                pass = pass + "*";
            }

            acc.createAccountStrings.set(2, pass);
        }
    }

    @Override
    public void canceled() {

    }
}
