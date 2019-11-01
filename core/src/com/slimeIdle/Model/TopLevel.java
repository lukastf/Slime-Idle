package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import io.socket.client.Socket;

public class TopLevel {

    // Textures
    public Texture topLevel;

    // Sprites


    private int playerTopSelecionado = 0;

    public int getPlayerTopSelecionado() {
        return playerTopSelecionado;
    }
    public void setPlayerTopSelecionado(int playerTopSelecionado) {
        this.playerTopSelecionado = playerTopSelecionado;
    }

    public ArrayList<String> topPlayers = new ArrayList<String>();
    public ArrayList<String> topPlayersLevel = new ArrayList<String>();
    public ArrayList<Integer> topPlayersItemEquippedId = new ArrayList<Integer>();

    public void dispose () {
        topLevel.dispose();
    }

    public void topLevel(Socket socket) {
        socket.emit("topLevel");
    }

    public  void topLevelRes (Object... args) {

        JSONArray data = (JSONArray) args[0];

        try{

            for (int i = 0; i < 21; i++) {
                topPlayers.set(i, "#" + (i+1)+ "  " + data.getJSONObject(i).getString("nickname"));
                topPlayersLevel.set(i, "Lv: " + data.getJSONObject(i).getString("level"));
                topPlayersItemEquippedId.set(i, data.getJSONObject(i).getInt("itemEquipped"));
            }

        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
