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

                JSONObject enviar = new JSONObject();
                try {
                    enviar.put("name", acc.getNome());
                    if(acc.getFbId() != ""){
                        enviar.put("fbId1", acc.id[0]);
                        enviar.put("fbId2", acc.id[1]);
                    }

                    if(acc.getPassword() != "" && acc.getNickname() != "" && acc.getNickname() != ">Insert Nickname<"){
                        enviar.put("nickname", acc.getNickname());
                        enviar.put("password1", acc.pass[0]);
                        enviar.put("password2", acc.pass[1]);
                    }

                    socket.emit("checkAccount", enviar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                acc.setConectado(true);

            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setFbId("");
                acc.setLogin(false);
                acc.setConectado(false);

                slime.setLevel(0);
                slime.setLastTimeTouch("time...");
                coin.setCoins(0);

            }
        }).on(Socket.EVENT_PING, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject enviar = new JSONObject();
                try {
                    enviar.put("name", acc.getNome());
                    enviar.put("fbId1", acc.id[0]);
                    enviar.put("fbId2", acc.id[1]);

                    socket.emit("pingado", enviar);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).on("output", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    acc.setNome(data.getString("name"));
                    acc.setFbId(data.getString("fbId"));
                    acc.setNickname(data.getString("nickname"));
                    acc.setPassword(data.getString("password"));

                    slime.setLevel(data.getInt("level"));
                    slime.setLastTimeTouch(data.getString("lastTimeTouch"));
                    slime.setItemEquippedId(data.getInt("itemEquipped"));

                    coin.setCoins(data.getInt("coins"));

                    // holiday itens
                    for(int i = 0; i < 4 ; i++){
                        shop.itemsShopBought.set(i+2, data.getJSONObject("itens").getJSONArray("holiday").getJSONObject(i).getBoolean("bought"));
                        shop.itemsShopNames.set(i+2,data.getJSONObject("itens").getJSONArray("holiday").getJSONObject(i).getString("name"));
                        shop.itemsShopPrices.set(i+2,"price: "+data.getJSONObject("itens").getJSONArray("holiday").getJSONObject(i).getString("price")+ " coins");
                    }

                    //common itens
                    for(int i = 0; i < 19; i++){
                        shop.itemsShopBought.set(i+6, data.getJSONObject("itens").getJSONArray("common").getJSONObject(i).getBoolean("bought"));
                        shop.itemsShopNames.set(i+6,data.getJSONObject("itens").getJSONArray("common").getJSONObject(i).getString("name"));
                        shop.itemsShopPrices.set(i+6,"price: "+data.getJSONObject("itens").getJSONArray("common").getJSONObject(i).getString("price") + " coins");
                    }

                    //Gdx.app.log("output", "ok");
                } catch (JSONException e) {
                    Gdx.app.log("output", "Error");
                }
            }
        }).on("topLevelRes", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONArray data = (JSONArray) args[0];

                try{

                    for (int i = 0; i < 21; i++) {
                        topLevel.topPlayers.set(i, "#" + (i+1)+ "  " + data.getJSONObject(i).getString("nickname"));
                        topLevel.topPlayersLevel.set(i, "Lv: " + data.getJSONObject(i).getString("level"));
                        topLevel.topPlayersItemEquippedId.set(i, data.getJSONObject(i).getInt("itemEquipped"));
                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).on("buySuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    slime.setLastTimeTouch(data.getString("lastTimeTouch"));
                    coin.setCoins(data.getInt("coins"));
                    menu.setMenu_item_BuySuccess(true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).on("buyErrorReady", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                menu.setMenu_item_BuyError_ready(true);
            }
        }).on("buyErrorMoney", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                menu.setMenu_item_BuyError_money(true);
            }
        }).on("equipSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    slime.setItemEquippedId(data.getInt("itemEquipped"));
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).on("equipErrorBought", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
            }
        }).on("unequipSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    slime.setItemEquippedId(data.getInt("itemEquipped"));
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).on("setNicknameSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    acc.setNickname(data.getString("nickname"));
                } catch (JSONException e){
                    e.printStackTrace();
                }
                acc.setSetNicknameSuccess(true);
                acc.createAccountStrings.set(1,"> Nickname <");
            }
        }).on("setNicknameError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setSetNicknameError(true);
            }
        });
    }

    public void buyItem(){
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);
            enviar.put("itemId", item.getItemSelecionado());

            socket.emit("buyItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void equipItem(){
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);
            enviar.put("itemId", item.getItemSelecionado());

            socket.emit("equipItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void unequipItem() {
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);
            enviar.put("itemId", item.getItemSelecionado());

            socket.emit("unequipItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void screenPressed() {

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);

            socket.emit("screenPressed", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void topLevel() {
        socket.emit("topLevel");
    }

    public void createAccount() {

        socket.connect();

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", acc.createAccountStrings.get(0));
            enviar.put("nickname", acc.createAccountStrings.get(1));
            enviar.put("password1", acc.pass[0]);
            enviar.put("password2", acc.pass[1]);

            socket.emit("createAccount", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.on("createAccountSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setCreateAccountSuccess(true);
                socket.disconnect();

                acc.createAccountStrings.set(0, "> Name <");
                acc.createAccountStrings.set(1, "> Nickname <");
                acc.createAccountStrings.set(2, "> Password <");
                acc.createAccountStrings.set(3, "> Password Again <");

                acc.passwordsHidden.set(0, "> Insert Password <");
                acc.passwordsHidden.set(1, "> Password <");
                acc.passwordsHidden.set(2, "> Password Again <");

                acc.setPassword("");
                acc.pass = null;

            }
        });

        socket.on("createAccountError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setCreateAccountError(true);
                socket.disconnect();

                acc.setNickname(">Insert Nickname<");
                acc.passwordsHidden.set(0, "> Insert Password <");
                acc.setPassword("");
                acc.pass = null;
            }
        });
    }

    public void loginAccount() {
        socket.connect();

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("nickname", acc.getNickname());
            enviar.put("password1", acc.pass[0]);
            enviar.put("password2", acc.pass[1]);

            socket.emit("login", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.on("loginSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setLoginSuccess(true);

                JSONObject data = (JSONObject) args[0];
                try {
                    acc.setNome(data.getString("name"));
                    acc.setFbId(data.getString("fbId"));
                    acc.id = encryption.encryptIn2(encryption.decrypt(data.getString("fbId")));
                    acc.setNickname(data.getString("nickname"));
                    acc.setPassword(data.getString("password"));
                    acc.pass = encryption.encryptIn2(encryption.decrypt(data.getString("password")));

                    acc.getPrefs().putString("name", acc.getNome());
                    acc.getPrefs().putString("fbId", acc.getFbId());
                    acc.getPrefs().putString("nickname", acc.getNickname());
                    acc.getPrefs().putString("password", acc.getPassword());
                    acc.getPrefs().flush();

                } catch (JSONException e){
                    e.printStackTrace();
                }

                socket.disconnect();
            }
        });

        socket.on("loginError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                acc.setLoginError(true);
                socket.disconnect();
            }
        });
    }

    public void setNickname() {
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", acc.getNome());
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);
            enviar.put("nickname", acc.createAccountStrings.get(1));

            socket.emit("setNickname", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void buyCoins(String transactionId){
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);
            enviar.put("buyId", transactionId);

            socket.emit("buyCoins", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
