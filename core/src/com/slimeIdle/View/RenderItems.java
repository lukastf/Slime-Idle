package com.slimeIdle.View;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;

public class RenderItems {

    Slime slime;
    TopLevel topLevel;
    Shop shop;

    public RenderItems(Slime slime, TopLevel topLevel, Shop shop) {
        this.slime = slime;
        this.topLevel = topLevel;
        this.shop = shop;
    }

    public void renderItemsEquipped(boolean currentPlayer){

        Static.tw = slime.slimeSpr.getWidth();
        Static.th = slime.slimeSpr.getHeight();

        int X = 0;
        int Y = 0;

        if(currentPlayer) {

            Y = slime.getItemEquippedId();

            switch (Y){
                case -1:
                    X = 2;
                    break;

                case -2:
                    X = 3;
                    break;
                case -3:
                    X = 4;
                    break;
                case -4:
                    X = 5;
                    break;
                case 1:
                    X = 6;
                    break;
                case 2:
                    X = 7;
                    break;
                case 3:
                    X = 8;
                    break;
                case 4:
                    X = 9;
                    break;
                case 5:
                    X = 10;
                    break;
                case 6:
                    X = 11;
                    break;
                case 7:
                    X = 12;
                    break;
                case 8:
                    X = 13;
                    break;
                case 9:
                    X = 14;
                    break;
                case 10:
                    X = 15;
                    break;
                case 11:
                    X = 16;
                    break;
                case 12:
                    X = 17;
                    break;
                case 13:
                    X = 18;
                    break;
                case 14:
                    X = 19;
                    break;
                case 15:
                    X = 20;
                    break;
                case 16:
                    X = 21;
                    break;
                case 17:
                    X = 22;
                    break;
                case 18:
                    X = 23;
                    break;
                case 19:
                    X = 24;
                    break;
                default:
                    X = 0;
            }

        } else {

            Y =  topLevel.getPlayerTopSelecionado();

            switch (topLevel.topPlayersItemEquippedId.get(Y)){
                case -1:
                    X = 2;
                    break;

                case -2:
                    X = 3;
                    break;
                case -3:
                    X = 4;
                    break;
                case -4:
                    X = 5;
                    break;
                case 1:
                    X = 6;
                    break;
                case 2:
                    X = 7;
                    break;
                case 3:
                    X = 8;
                    break;
                case 4:
                    X = 9;
                    break;
                case 5:
                    X = 10;
                    break;
                case 6:
                    X = 11;
                    break;
                case 7:
                    X = 12;
                    break;
                case 8:
                    X = 13;
                    break;
                case 9:
                    X = 14;
                    break;
                case 10:
                    X = 15;
                    break;
                case 11:
                    X = 16;
                    break;
                case 12:
                    X = 17;
                    break;
                case 13:
                    X = 18;
                    break;
                case 14:
                    X = 19;
                    break;
                case 15:
                    X = 20;
                    break;
                case 16:
                    X = 21;
                    break;
                case 17:
                    X = 22;
                    break;
                case 18:
                    X = 23;
                    break;
                case 19:
                    X = 24;
                    break;
                default:
                    X = 0;
            }

        }

        Static.batch.draw(shop.itemsShopSprites.get(X),
                (Static.camera.position.x - (Static.tw/2)),
                (Static.camera.position.y - (Static.th/2) + (Static.h/5)),
                Static.tw, Static.th);
    }
}
