package com.slimeIdle.View;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;

public class RenderItems {

    Slime slime;
    TopLevel topLevel;
    Shop shop;
    Item item;

    public RenderItems(Slime slime, TopLevel topLevel, Shop shop, Item item) {
        this.slime = slime;
        this.topLevel = topLevel;
        this.shop = shop;
        this.item = item;
    }

    public void renderItemsEquipped(int type){

        int X = 0;
        boolean showItem = true;

        switch(type) {

            case 0:
                // this player
                if (slime.getCollectionItemEquipped().contains("commonItem")) {
                    X = slime.getItemEquippedId() + 2;
                }
                if (slime.getCollectionItemEquipped().contains("holidayItem")) {
                    X = slime.getItemEquippedId() + 21;
                }
                if (slime.getItemEquippedId() == 0) {
                    showItem = false;
                }
                break;
            case 1:
                // top level
                if (topLevel.topPlayersItemEquippedCollection.get(topLevel.getPlayerTopSelecionado()).contains("commonItem")) {
                    X = topLevel.topPlayersItemEquippedId.get(topLevel.getPlayerTopSelecionado()) + 2;
                }
                if (topLevel.topPlayersItemEquippedCollection.get(topLevel.getPlayerTopSelecionado()).contains("holidayItem")) {
                    X = topLevel.topPlayersItemEquippedId.get(topLevel.getPlayerTopSelecionado()) + 21;
                }
                if(topLevel.topPlayersItemEquippedId.get(topLevel.getPlayerTopSelecionado()) == 0) {
                    showItem = false;
                }
                break;
            case 2:
                //shop
                if (item.getCollection().contains("commonItem")) {
                    X = item.getItemId() + 2;
                }
                if (item.getCollection().contains("holidayItem")) {
                    X = item.getItemId() + 21;
                }

                break;
        }

        if (showItem) {

            Static.batch.draw(shop.itemsShopTextures.get(X),
                    slime.slimePosition.get("x") * 0.63f,
                    slime.slimePosition.get("y") * 1.43f,
                    slime.slimePosition.get("width") * 1.28f,
                    slime.slimePosition.get("height") * 1.2f);
        }
    }
}
