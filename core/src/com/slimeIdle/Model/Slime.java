package com.slimeIdle.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;

public class Slime {

    private int level = 0;
    private String lastTimeTouch = "time...";

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String getLastTimeTouch() {
        return lastTimeTouch;
    }
    public void setLastTimeTouch(String lastTimeTouch) {
        this.lastTimeTouch = lastTimeTouch;
    }

    // Textures
    public Texture slime;

    // Sprites
    public Sprite slimeSpr;

    private int itemEquippedId = 0;

    public int getItemEquippedId() {
        return itemEquippedId;
    }
    public void setItemEquippedId(int itemEquippedId) {
        this.itemEquippedId = itemEquippedId;
    }

    public void dispose(){
        slime.dispose();
    }

    public void screenPressed(Account acc, Socket socket) {

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);

            socket.emit("screenPressed", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void output(Account acc, Coin coin, Shop shop, Object... args) {
        JSONObject data = (JSONObject) args[0];
        try {
            acc.setNome(data.getString("name"));
            acc.setFbId(data.getString("fbId"));
            acc.setNickname(data.getString("nickname"));
            acc.setPassword(data.getString("password"));

            setLevel(data.getInt("level"));
            setLastTimeTouch(data.getString("lastTimeTouch"));
            setItemEquippedId(data.getInt("itemEquipped"));

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

    public void equipItem (Account acc, Item item, Socket socket) {
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

    public void unequipItem (Account acc, Item item, Socket socket) {
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

    public void equipSuccessful(Object... args) {
        JSONObject data = (JSONObject) args[0];
        try {
            setItemEquippedId(data.getInt("itemEquipped"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void unequipSuccessful(Object... args) {
        JSONObject data = (JSONObject) args[0];
        try {
            setItemEquippedId(data.getInt("itemEquipped"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
