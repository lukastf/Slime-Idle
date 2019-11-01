package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.socket.client.Socket;

public class Shop {

    public ArrayList<Texture> itemsShopTextures = new ArrayList<Texture>();
    public ArrayList<Sprite> itemsShopSprites = new ArrayList<Sprite>();
    public ArrayList<String> itemsShopNames = new ArrayList<String>();
    public ArrayList<String> itemsShopPrices = new ArrayList<String>();
    public ArrayList<Boolean> itemsShopBought = new ArrayList<Boolean>();

    public void renderItemsShopSprites(){

        for (int i=0; i<25; i++) {
            itemsShopSprites.add(i, new Sprite());
        }
    }

    public void buyItem (Account acc, Item item, Socket socket) {

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

    public void buySuccessful (Slime slime, Coin coin, Menu menu, Object... args) {
        JSONObject data = (JSONObject) args[0];
        try {
            slime.setLastTimeTouch(data.getString("lastTimeTouch"));
            coin.setCoins(data.getInt("coins"));
            menu.setMenu_item_BuySuccess(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void buyErrorReady (Menu menu) {
        menu.setMenu_item_BuyError_ready(true);
    }

    public void buyErrorMoney (Menu menu) {
        menu.setMenu_item_BuyError_money(true);
    }
}
