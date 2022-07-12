package com.slimeIdle.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;
import com.slimeIdle.View.AllTextStringsLanguages;

import org.json.JSONException;
import org.json.JSONObject;

//import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;
import java.util.Random;

import io.socket.client.Socket;

public class Slime {

    private int level = 0;
    private String lastTimeTouch = "time...";
    private int touchPower = 0;

    public ArrayList<Float> touchScreenSeconds = new ArrayList<Float>();

    public ArrayList<Boolean> touchScreenSecondsController = new ArrayList<Boolean>();
    public ArrayList<Boolean> touchScreenSecondsTouchPointController = new ArrayList<Boolean>();

    public int touchScreenSecondsQty = 50;

    public void initalizer() {

        for (int i = 0; i < touchScreenSecondsQty; i++) {

            touchScreenSeconds.add(i, 0f);
            touchScreenSecondsController.add(i,false);
            touchScreenSecondsTouchPointController.add(i,false);
        }
    }

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
    public Texture slimesTexture;
    public Texture slimeFacesTexture;
    public Texture sleep;
    public Texture slimeBackgroundsTexture;

    public ArrayMap<String ,TextureRegion> slimes = new ArrayMap<String, TextureRegion>();
    public ArrayMap<String, TextureRegion> slimeFaces = new ArrayMap<String, TextureRegion>();
    public ArrayMap<String, TextureRegion> slimeBackgrounds = new ArrayMap<String, TextureRegion>();

    public ArrayMap<String, Float> slimePosition = new ArrayMap<String, Float>();

    //animations
    public Animation<TextureRegion> sleepAnimation;
    float stateTime = 0;
    public boolean stateSleep = true;

    // Sprites
    //public Sprite slimeSpr;

    private int itemEquippedId = 0;
    private String collectionItemEquipped = "";

    private int backgroundEquippedId = 0;
    private String collectionBackgroundEquipped = "";

    private int slimeColorEquippedId = 0;
    private String collectionSlimeColorEquipped = "";

    public String getSlimeColorEquipped(int slimeColorEquippedId, boolean isEquipped) {

        String slimeColorEquipped = "default";
        String equipped = "";


        if (isEquipped) {
            equipped = "Equipped";
        }

        switch (slimeColorEquippedId) {
            case 0:
                slimeColorEquipped = "default" + equipped;
                break;
            case 1:
                slimeColorEquipped = "green" + equipped;
                break;
            case 2:
                slimeColorEquipped = "blue" + equipped;
                break;
            case 3:
                slimeColorEquipped = "yellow" + equipped;
                break;
            case 4:
                slimeColorEquipped = "red" + equipped;
                break;
            case 5:
                slimeColorEquipped = "pink" + equipped;
                break;
            case 6:
                slimeColorEquipped = "purple" + equipped;
                break;
            case 7:
                slimeColorEquipped = "lightBlue" + equipped;
                break;
            case 8:
                slimeColorEquipped = "orange" + equipped;
                break;
            case 9:
                slimeColorEquipped = "black" + equipped;
                break;
            case 10:
                slimeColorEquipped = "white" + equipped;
                break;
        }

        return slimeColorEquipped;
    }

    public Color getSlimeColorEquipped() {

        Color color = Color.GREEN;

        switch (getSlimeColorEquippedId()) {
            case 0:
                color =  Color.GREEN;
                break;
            case 1:
                color =  Color.GREEN;
                break;
            case 2:
                color =  Color.BLUE;
                break;
            case 3:
                color = Color.YELLOW;
                break;
            case 4:
                color = Color.RED;
                break;
            case 5:
                color = Color.PINK;
                break;
            case 6:
                color = Color.PURPLE;
                break;
            case 7:
                color = Color.BLUE;
                break;
            case 8:
                color = Color.ORANGE;
                break;
            case 9:
                color = Color.BLACK;
                break;
            case 10:
                color = Color.WHITE;
                break;
        }

        return color;
    }

    public boolean getEquippedItemState () {
        if (itemEquippedId == 0) {
            return false;
        }

        return true;
    }

    public String getBackgroundEquipped(int itemId) {

        String background = "";

        switch (itemId) {

            case 1:
                background = "field";
                break;
            case 2:
                background = "wood";
                break;
            case 3:
                background = "city";
                break;
            case 4:
                background = "vulcan";
                break;
        }

        return background;
    }

    public int getItemEquippedId() {
        return itemEquippedId;
    }
    public void setItemEquippedId(int itemEquippedId) {
        this.itemEquippedId = itemEquippedId;
    }

    public String getCollectionItemEquipped() {
        return collectionItemEquipped;
    }
    public void setCollectionItemEquipped(String collectionItemEquipped) {
        this.collectionItemEquipped = collectionItemEquipped;
    }

    public int getBackgroundEquippedId () {
        return backgroundEquippedId;
    }
    public void setBackgroundEquippedId (int backgroundEquippedId) {
        this.backgroundEquippedId = backgroundEquippedId;
    }

    public String getCollectionBackgroundEquipped () {
        return collectionBackgroundEquipped;
    }
    public void setCollectionBackgroundEquipped (String collectionBackgroundEquipped) {
        this.collectionBackgroundEquipped = collectionBackgroundEquipped;
    }

    public int getSlimeColorEquippedId() {
        return slimeColorEquippedId;
    }
    public void setSlimeColorEquippedId(int slimeColorId) {
        this.slimeColorEquippedId = slimeColorId;
    }

    public String getCollectionSlimeColorEquipped() {
        return collectionSlimeColorEquipped;
    }
    public void setCollectionSlimeColorEquipped(String collectionSlimeColorEquipped) {
        this.collectionSlimeColorEquipped = collectionSlimeColorEquipped;
    }

    public void dispose(){
        slimesTexture.dispose();
    }

    public void drawSlime(String slimeColor) {

        Static.batch.draw(
                slimes.get(slimeColor),
                slimePosition.get("x"),
                slimePosition.get("y"),
                slimePosition.get("width"),
                slimePosition.get("height"));
    }

    public void sleepAnimation() {

        if (stateTime == 100) stateTime = 0;
        stateTime += Gdx.graphics.getDeltaTime();

        Static.batch.draw(
                sleepAnimation.getKeyFrame(stateTime, true),
                slimePosition.get("x") * 1.1f,
                slimePosition.get("y"),
                slimePosition.get("width") * 0.7f,
                slimePosition.get("height") * 0.7f);
    }

    public void drawFace() {

        Static.batch.draw(
                slimeFaces.get("default"),
                slimePosition.get("x") * 1.3f,
                slimePosition.get("y"),
                slimePosition.get("width") * 0.6f,
                slimePosition.get("height") * 0.6f);
    }

    public void drawBackground(String bg) {

        if (bg != "") {

            Static.batch.draw(
                    slimeBackgrounds.get(bg),
                    Static.cam.viewportWidth * 0.0f,
                    Static.cam.viewportHeight * 0.0f,
                    Static.cam.viewportWidth,
                    Static.cam.viewportHeight);
        }
    }

    public String generatedColor = randomSlimeColor();
    public String generatedBackground = randomSlimeBackground();

    public String randomSlimeColor() {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        //int randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
        Random rand = new Random();
        //rand.nextInt();
        int randomNum = rand.nextInt(8);
        String color = "";

        switch (randomNum) {
            case 0:
                color = "default";
                break;
            case 1:
                color = "green";
                break;
            case 2:
                color = "blue";
                break;
            case 3:
                color = "yellow";
                break;
            case 4:
                color = "red";
                break;
            case 5:
                color = "pink";
                break;
            case 6:
                color = "purple";
                break;
            case 7:
                color = "lightBlue";
                break;
            case 8:
                color = "orange";
                break;
            case 9:
                color = "black";
                break;
            case 10:
                color = "white";
                break;
        }

        return color;
    }

    public String randomSlimeBackground() {

        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        String bgName = "";

        switch (randomNum) {
            case 0:
                bgName = "field";
                break;
            case 1:
                bgName = "wood";
                break;
            case 2:
                bgName = "city";
                break;
            case 3:
                bgName = "vulcan";
                break;
        }

        return bgName;
    }

    public void screenPressed(Account acc, Socket socket) {

        JSONObject enviar = new JSONObject();
        try {
            //enviar.put("fbId1", acc.id[0]);
            //enviar.put("fbId2", acc.id[1]);
            enviar.put("_id", acc.getId());
            socket.emit("screenPressed", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void output(Account acc, Coin coin, Shop shop, Object... args) {
        JSONObject data = (JSONObject) args[0];
        try {
            //acc.setNome(data.getString("name"));
            acc.setFbId(data.getString("fbId"));
            acc.setNickname(data.getString("nickname"));
            acc.setPassword(data.getString("password"));

            if (getLevel() != data.getInt("level") && getLevel()!= 0) {
                coin.freeCoin = true;
            }

            setLevel(data.getInt("level"));

            setLastTimeTouch(data.getString("lastTimeTouch"));
            if(getLastTimeTouch().contains("READY!")){
                stateSleep = true;
                //coin.freeCoin = true;
            } else {
                stateSleep = false;
            }

            setTouchPower(data.getInt("touchPower"));

            setItemEquippedId(data.getInt("itemEquipped"));
            setCollectionItemEquipped(data.getString("itemEquippedCollection"));
            setSlimeColorEquippedId(data.getInt("slimeColorEquipped"));
            setBackgroundEquippedId(data.getInt("backgroundEquipped"));

            coin.setCoins(data.getInt("coins"));

            for (int i=0; i < data.getJSONArray("noItemsPrices").length(); i++){

                int temp = data.getJSONArray("noItemsPrices").getInt(i);
                // touch power
                if(i == 2) {
                    temp = temp + touchPower;
                }

                AllTextStringsLanguages.itemsShop.get(i).setValue(0,
                        AllTextStringsLanguages.price + temp + AllTextStringsLanguages.coins.get(1));
            }

            for (int i=0; i < data.getJSONArray("holidayItemsPrices").length(); i++){

                int temp = data.getJSONArray("holidayItemsPrices").getInt(i);
                AllTextStringsLanguages.itemsShop.get(i+22).setValue(0,
                        AllTextStringsLanguages.price + temp + AllTextStringsLanguages.coins.get(1));
            }

            for (int i=0; i < data.getJSONArray("commonItemsPrices").length(); i++){

                int temp = data.getJSONArray("commonItemsPrices").getInt(i);
                AllTextStringsLanguages.itemsShop.get(i+3).setValue(0,
                        AllTextStringsLanguages.price + temp + AllTextStringsLanguages.coins.get(1));
            }

            for (int i=0; i < data.getJSONArray("backgroundsPrices").length(); i++){

                int temp = data.getJSONArray("backgroundsPrices").getInt(i);
                AllTextStringsLanguages.backgroundsShop.get(i).setValue(0,
                        AllTextStringsLanguages.price + temp + AllTextStringsLanguages.coins.get(1));
            }

            for (int i=0; i < data.getJSONArray("slimeColorsPrices").length(); i++){

                int temp = data.getJSONArray("slimeColorsPrices").getInt(i);
                AllTextStringsLanguages.slimeColorsShop.get(i).setValue(0,
                        AllTextStringsLanguages.price + temp + AllTextStringsLanguages.coins.get(1));
            }

            //holiday
            for (int i=0; i < data.getJSONObject("items").getJSONArray("holiday").length(); i++){

                int temp = data.getJSONObject("items").getJSONArray("holiday").getInt(i);
                shop.holidayItems.add(temp);
            }

            //common
            for (int i=0; i < data.getJSONObject("items").getJSONArray("common").length(); i++){

                int temp = data.getJSONObject("items").getJSONArray("common").getInt(i);
                shop.commonItems.add(temp);
            }

            //backgrounds
            for (int i=0; i < data.getJSONArray("backgrounds").length(); i++){

                int temp = data.getJSONArray("backgrounds").getInt(i);
                shop.backgrounds.add(temp);
            }

            //colors
            for (int i=0; i < data.getJSONArray("slimeColors").length(); i++){

                int temp = data.getJSONArray("slimeColors").getInt(i);
                shop.slimeColors.add(temp);
            }
        } catch (JSONException e) {
            Gdx.app.log("output", "Error kkk" + e);
        }
    }

    public void equipItem (Account acc, Item item, Socket socket) {
        JSONObject enviar = new JSONObject();
        try {
            //enviar.put("fbId1", acc.id[0]);
            //enviar.put("fbId2", acc.id[1]);
            enviar.put("_id", acc.getId());
            enviar.put("itemId", item.getItemId());
            enviar.put("collection", item.getCollection());

            socket.emit("equipItem", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void unequipItem (Account acc, Item item, Socket socket) {
        JSONObject enviar = new JSONObject();
        try {
            //enviar.put("fbId1", acc.id[0]);
            //enviar.put("fbId2", acc.id[1]);
            enviar.put("_id", acc.getId());
            enviar.put("itemId", item.getItemId());
            enviar.put("collection", item.getCollection());

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


    public int getTouchPower() {
        return touchPower;
    }

    public void setTouchPower(int touchPower) {
        this.touchPower = touchPower;
    }
}
