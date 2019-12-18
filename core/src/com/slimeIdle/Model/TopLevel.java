package com.slimeIdle.Model;

import com.slimeIdle.View.AllTextStringsLanguages;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import io.socket.client.Socket;

public class TopLevel {

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
    public ArrayList<String> topPlayersItemEquippedCollection = new ArrayList<String>();
    public ArrayList<Integer> topPlayersBackgroundEquippedId = new ArrayList<Integer>();
    public ArrayList<Integer> topPlayersSlimeColorEquippedId = new ArrayList<Integer>();

    public void initializer() {
        for (int i = 0; i < 21; i++){

            topPlayers.add(i + " Player " + i);
            topPlayersLevel.add(i + " 42 ");
            topPlayersItemEquippedId.add(i, 0);
            topPlayersItemEquippedCollection.add(i, "");
            topPlayersBackgroundEquippedId.add(i, 0);
            topPlayersSlimeColorEquippedId.add(i, 0);
        }
    }

    public boolean getEquippedItemState () {
        if (topPlayersItemEquippedId.get(playerTopSelecionado) == 0) {
            return false;
        }

        return true;
    }

    public void topLevel(Socket socket) {
        socket.emit("topLevel");
    }

    public  void topLevelRes (Object... args) {

        JSONArray data = (JSONArray) args[0];

        try{

            for (int i = 0; i < 21; i++) {
                topPlayers.set(i, "#" + (i+1)+ "  " + data.getJSONObject(i).getString("nickname"));
                topPlayersLevel.set(i, AllTextStringsLanguages.lv + " " +  data.getJSONObject(i).getString("level"));
                topPlayersItemEquippedId.set(i, data.getJSONObject(i).getInt("itemEquipped"));
                topPlayersItemEquippedCollection.set(i, data.getJSONObject(i).getString("itemEquippedCollection"));
                topPlayersBackgroundEquippedId.set(i, data.getJSONObject(i).getInt("backgroundEquipped"));
                topPlayersSlimeColorEquippedId.set(i, data.getJSONObject(i).getInt("slimeColorEquipped"));
            }

        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
