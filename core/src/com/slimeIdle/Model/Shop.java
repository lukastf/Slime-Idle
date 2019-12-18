package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.socket.client.Socket;

public class Shop {

    public Texture noItemsTexture;
    public Texture holidayItemsTexture;
    public Texture commonItemsTexture;

    public ArrayList<TextureRegion> itemsShopTextures = new ArrayList<TextureRegion>();
    public ArrayList<TextureRegion> backgroundsShopTextures = new ArrayList<TextureRegion>();
    public ArrayList<TextureRegion> slimeColorsShopTextures = new ArrayList<TextureRegion>();

    public ArrayList<Integer> noItems = new ArrayList<Integer>();
    public ArrayList<Integer> holidayItems = new ArrayList<Integer>();
    public ArrayList<Integer> commonItems = new ArrayList<Integer>();
    public ArrayList<Integer> backgrounds = new ArrayList<Integer>();
    public ArrayList<Integer> slimeColors = new ArrayList<Integer>();

    /*
    public void initializer () {

        for (int i = 0; i < 33; i++) {
            //itemsShopNames.add("");
            //itemsShopPrices.add("");
        }
    }*/

    public void dispose () {
        noItemsTexture.dispose();
        holidayItemsTexture.dispose();
        commonItemsTexture.dispose();
    }


    public boolean itemsShopBought(int itemId, String collection){

        if (collection.contains("noItems")) {
            if(noItems.contains(itemId)) {
                return true;
            }
        }

        if (collection.contains("holidayItems")) {
            if(holidayItems.contains(itemId)) {
                return true;
            }
        }

        if (collection.contains("commonItems")) {
            if(commonItems.contains(itemId)) {
                return true;
            }
        }

        if (collection.contains("backgrounds")) {
            if(backgrounds.contains(itemId)) {
                return true;
            }
        }

        if (collection.contains("slimeColors")) {
            if(slimeColors.contains(itemId)) {
                return true;
            }
        }

        return false;
    }

    public void drawItemShopIcon(int texture, int menuPosition, ArrayList<ArrayMap<String,Float>> buttonMenuProps) {
        Static.batch.draw(
                itemsShopTextures.get(texture),
                buttonMenuProps.get(menuPosition).get("x"),
                buttonMenuProps.get(menuPosition).get("y") + ( Static.cam.viewportHeight * 0.010f),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.1f);
    }

    public void drawBackgroundShop(int texture, int menuPosition, ArrayList<ArrayMap<String,Float>> buttonMenuProps) {
        Static.batch.draw(
                itemsShopTextures.get(texture),
                buttonMenuProps.get(menuPosition).get("x"),
                buttonMenuProps.get(menuPosition).get("y"),
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.1f);
    }

    public void drawSlimeColorShopIcon(int texture, int menuPosition, ArrayList<ArrayMap<String,Float>> buttonMenuProps) {
        Static.batch.draw(
                slimeColorsShopTextures.get(texture),
                buttonMenuProps.get(menuPosition).get("x") + 10f,
                buttonMenuProps.get(menuPosition).get("y") + 15f,
                Static.cam.viewportWidth * 0.1f,
                Static.cam.viewportHeight * 0.08f);
    }

    public void buyItem (Account acc, Item item, Socket socket) {

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("fbId1", acc.id[0]);
            enviar.put("fbId2", acc.id[1]);
            enviar.put("itemId", item.getItemId());
            enviar.put("collection", item.getCollection());

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
