package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;

public class Coin {

    private int coins = 0;

    // Textures
    public Texture coin;

    public float freeCoinPosition = 5;
    public boolean freeCoin = false;

    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void dispose() {
        coin.dispose();
    }

    public void buyCoins(Account acc, String transactionId, Socket socket){
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
