package com.slimeIdle;

import com.badlogic.gdx.Gdx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class SocketSlime {

    VariablesDeclaration vd;

    public SocketSlime(VariablesDeclaration vdRecebido){
        vd = vdRecebido;
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
                    enviar.put("name", vd.getNome());
                    if(vd.getFbId() != ""){
                        enviar.put("fbId1", vd.id[0]);
                        enviar.put("fbId2", vd.id[1]);
                    }

                    if(vd.getPassword() != "" && vd.getNickname() != "" && vd.getNickname() != ">Insert Nickname<"){
                        enviar.put("nickname", vd.getNickname());
                        enviar.put("password1", vd.pass[0]);
                        enviar.put("password2", vd.pass[1]);
                    }

                    socket.emit("checkAccount", enviar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                vd.setConectado(true);

            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setLogin(false);
                vd.setConectado(false);
                vd.setLevel(0);
                vd.setLastTimeTouch("time...");
                vd.setCoins(0);
                vd.setFbId("");
            }
        }).on(Socket.EVENT_PING, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject enviar = new JSONObject();
                try {
                    enviar.put("name", vd.getNome());
                    enviar.put("fbId1", vd.id[0]);
                    enviar.put("fbId2", vd.id[1]);

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
                    vd.setNome(data.getString("name"));
                    vd.setFbId(data.getString("fbId"));
                    //vd.id = vd.encryptIn2(vd.decrypt(data.getString("fbId")));
                    vd.setNickname(data.getString("nickname"));
                    vd.setPassword(data.getString("password"));
                    //vd.pass = vd.encryptIn2(vd.decrypt(data.getString("password")));
                    vd.setLevel(data.getInt("level"));
                    vd.setLastTimeTouch(data.getString("lastTimeTouch"));
                    vd.setCoins(data.getInt("coins"));
                    vd.setItemEquippedId(data.getInt("itemEquipped"));

                    // holiday itens
                    for(int i = 0; i < 4 ; i++){
                        vd.itemsShopBought.set(i+2, data.getJSONObject("itens").getJSONArray("holiday").getJSONObject(i).getBoolean("bought"));
                        vd.itemsShopNames.set(i+2,data.getJSONObject("itens").getJSONArray("holiday").getJSONObject(i).getString("name"));
                        vd.itemsShopPrices.set(i+2,"price: "+data.getJSONObject("itens").getJSONArray("holiday").getJSONObject(i).getString("price")+ " coins");
                    }

                    //common itens
                    for(int i = 0; i < 19; i++){
                        vd.itemsShopBought.set(i+6, data.getJSONObject("itens").getJSONArray("common").getJSONObject(i).getBoolean("bought"));
                        vd.itemsShopNames.set(i+6,data.getJSONObject("itens").getJSONArray("common").getJSONObject(i).getString("name"));
                        vd.itemsShopPrices.set(i+6,"price: "+data.getJSONObject("itens").getJSONArray("common").getJSONObject(i).getString("price") + " coins");
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
                        vd.topPlayers.set(i, "#" + (i+1)+ "  " + data.getJSONObject(i).getString("nickname"));
                        vd.topPlayersLevel.set(i, "Lv: " + data.getJSONObject(i).getString("level"));
                        vd.topPlayersItemEquippedId.set(i, data.getJSONObject(i).getInt("itemEquipped"));
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
                    vd.setLastTimeTouch(data.getString("lastTimeTouch"));
                    vd.setCoins(data.getInt("coins"));
                    vd.setMenu_item_BuySuccess(true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).on("buyErrorReady", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setMenu_item_BuyError_ready(true);
            }
        }).on("buyErrorMoney", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setMenu_item_BuyError_money(true);
            }
        }).on("equipSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    vd.setItemEquippedId(data.getInt("itemEquipped"));
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
                    vd.setItemEquippedId(data.getInt("itemEquipped"));
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).on("setNicknameSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                try {
                    vd.setNickname(data.getString("nickname"));
                } catch (JSONException e){
                    e.printStackTrace();
                }
                vd.setSetNicknameSuccess(true);
                vd.createAccountStrings.set(1,"> Nickname <");
            }
        }).on("setNicknameError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setSetNicknameError(true);
            }
        });
    }

    public void buyItem(){
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", vd.id[0]);
            enviar.put("fbId2", vd.id[1]);
            enviar.put("itemId", vd.getItemSelecionado());

            socket.emit("buyItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void equipItem(){
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", vd.id[0]);
            enviar.put("fbId2", vd.id[1]);
            enviar.put("itemId", vd.getItemSelecionado());

            socket.emit("equipItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void unequipItem() {
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", vd.id[0]);
            enviar.put("fbId2", vd.id[1]);
            enviar.put("itemId", vd.getItemSelecionado());

            socket.emit("unequipItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void screenPressed() {

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", vd.id[0]);
            enviar.put("fbId2", vd.id[1]);

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
            enviar.put("name", vd.createAccountStrings.get(0));
            enviar.put("nickname", vd.createAccountStrings.get(1));
            enviar.put("password1", vd.pass[0]);
            enviar.put("password2", vd.pass[1]);

            socket.emit("createAccount", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.on("createAccountSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setCreateAccountSuccess(true);
                socket.disconnect();

                vd.createAccountStrings.set(0, "> Name <");
                vd.createAccountStrings.set(1, "> Nickname <");
                vd.createAccountStrings.set(2, "> Password <");
                vd.createAccountStrings.set(3, "> Password Again <");

                vd.passwordsHidden.set(0, "> Insert Password <");
                vd.passwordsHidden.set(1, "> Password <");
                vd.passwordsHidden.set(2, "> Password Again <");

                vd.setPassword("");
                vd.pass = null;

            }
        });

        socket.on("createAccountError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setCreateAccountError(true);
                socket.disconnect();

                vd.setNickname(">Insert Nickname<");
                vd.passwordsHidden.set(0, "> Insert Password <");
                vd.setPassword("");
                vd.pass = null;
            }
        });
    }

    public void loginAccount() {
        socket.connect();

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("nickname", vd.getNickname());
            enviar.put("password1", vd.pass[0]);
            enviar.put("password2", vd.pass[1]);

            socket.emit("login", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.on("loginSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setLoginSuccess(true);

                JSONObject data = (JSONObject) args[0];
                try {
                    vd.setNome(data.getString("name"));
                    vd.setFbId(data.getString("fbId"));
                    vd.id = vd.encryptIn2(vd.decrypt(data.getString("fbId")));
                    vd.setNickname(data.getString("nickname"));
                    vd.setPassword(data.getString("password"));
                    vd.pass = vd.encryptIn2(vd.decrypt(data.getString("password")));

                    vd.getPrefs().putString("name", vd.getNome());
                    vd.getPrefs().putString("fbId", vd.getFbId());
                    vd.getPrefs().putString("nickname", vd.getNickname());
                    vd.getPrefs().putString("password", vd.getPassword());
                    vd.getPrefs().flush();

                } catch (JSONException e){
                    e.printStackTrace();
                }

                socket.disconnect();
            }
        });

        socket.on("loginError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                vd.setLoginError(true);
                socket.disconnect();
            }
        });
    }

    public void setNickname() {
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", vd.getNome());
            enviar.put("fbId1", vd.id[0]);
            enviar.put("fbId2", vd.id[1]);
            enviar.put("nickname", vd.createAccountStrings.get(1));

            socket.emit("setNickname", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void buyCoins(String transactionId){
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", vd.id[0]);
            enviar.put("fbId2", vd.id[1]);
            enviar.put("buyId", transactionId);

            socket.emit("buyCoins", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
