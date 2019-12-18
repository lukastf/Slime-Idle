package com.slimeIdle.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {

    private int itemId = 0;
    private String collection = "";
    private int itemMenuPosition = 0;
    //private int backgroundId = 0;
    //private int slimeColorId = 0;

    public int getItemId () {
        return itemId;
    }
    public void setItemId (int itemSelecionado) {
        this.itemId = itemSelecionado;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public int getItemMenuPosition() {
        return itemMenuPosition;
    }

    public void setItemMenuPosition(int itemMenuPosition) {
        this.itemMenuPosition = itemMenuPosition;
    }

    /*
    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public int getSlimeColorId() {
        return slimeColorId;
    }

    public void setSlimeColorId(int slimeColorId) {
        this.slimeColorId = slimeColorId;
    }*/
}
