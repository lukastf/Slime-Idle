package com.slimeIdle.Model;

import com.badlogic.gdx.Gdx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class SocketSlime {

    Account acc;
    Slime slime;
    Coin coin;
    Shop shop;
    TopLevel topLevel;
    Menu menu;
    Item item;
    Encryption encryption;


    public SocketSlime(
            Account account,
            Slime slime,
            Coin coin,
            Shop shop,
            TopLevel topLevel,
            Menu menu, Item item,
            Encryption encryption){

        this.acc = account;
        this.slime = slime;
        this.coin = coin;
        this.shop = shop;
        this.topLevel = topLevel;
        this.menu = menu;
        this.item = item;
        this.encryption = encryption;
    }

    private Socket socket;
    {
        try {
            //socket = IO.socket("http://192.168.15.35:8091");
            //socket = IO.socket("https://slimeidle.com");
            socket = IO.socket("http://157.230.83.239:8091");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connectSocket() {
        socket.connect();
    }

    public void disconnectSocket() { socket.disconnect(); }

    public void configSocketEvents(){

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.connect(socket);
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.disconnect(slime, coin);
            }
        }).on(Socket.EVENT_PING, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.pingado(socket);
            }
        }).on("output", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                slime.output(acc, coin, shop,args);
            }
        }).on("topLevelRes", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                topLevel.topLevelRes(args);
            }
        }).on("buySuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                shop.buySuccessful(slime, coin, menu, args);
            }
        }).on("buyErrorReady", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                shop.buyErrorReady(menu);
            }
        }).on("buyErrorMoney", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                shop.buyErrorMoney(menu);
            }
        }).on("equipSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                slime.equipSuccessful(args);
            }
        }).on("equipErrorBought", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
            }
        }).on("unequipSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                slime.unequipSuccessful(args);
            }
        }).on("setNicknameSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setNicknameSuccessful(args);
            }
        }).on("setNicknameError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setNicknameError(args);
            }
        });
    }

    public void buyItem(){
        shop.buyItem(acc, item, socket);
    }

    public void equipItem(){
        slime.equipItem(acc, item, socket);
    }

    public void unequipItem() {
        slime.unequipItem(acc, item, socket);
    }

    public void screenPressed() {
        slime.screenPressed(acc, socket);
    }

    public void topLevel() {
        topLevel.topLevel(socket);
    }

    public void createAccount() {
        acc.createAccount(socket);
    }

    public void loginAccount() {
        acc.loginAccount(encryption, socket);
    }

    public void setNickname() {
        acc.setNickname(socket);
    }

    public void buyCoins(String transactionId){
        coin.buyCoins(acc, transactionId, socket);
    }
}
