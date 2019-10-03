package com.slimeIdle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Loader {

    VariablesDeclaration vd;
    Render render;

    public Loader(VariablesDeclaration vdRecebido, Render renderRecebido){
        vd = vdRecebido;
        render = renderRecebido;
    }

    private void loadTextures(){

        //login face
        vd.loginButton = new Texture("login_button.png");

        //principal
        vd.slime = new Texture("slime.png");
        vd.reconnectWindow = new Texture("window.png");
        vd.cart = new Texture("cart.png");
        vd.coin = new Texture("coin.png");
        vd.topLevel = new Texture("topLevel.png");
        vd.window = new Texture("window2.png");

        //menu
        vd.background_menu = new Texture("background_menu.png");
        vd.closeWindow = new Texture("fechar_janela.png");
        vd.itemMenu = new Texture("item_menu.png");
        vd.buttonPrev = new Texture("prev.png");
        vd.buttonNext = new Texture("next.png");
        vd.buttonBuy = new Texture("buy.png");
        vd.buttonEquip = new Texture("equip.png");
        vd.buttonUnequip = new Texture("unequip.png");

        //loja cart
        vd.itemsShopTextures.add(0, new Texture("shop/time.png"));
        vd.itemsShopTextures.add(1, new Texture("shop/pencil.png"));

        vd.itemsShopTextures.add(2, new Texture("shop/santa_claus_hat.png"));
        vd.itemsShopTextures.add(3, new Texture("shop/habbit_ears.png"));
        vd.itemsShopTextures.add(4, new Texture("shop/witch_hat.png"));

        vd.itemsShopTextures.add(5, new Texture("shop/black_habbit_ears.png"));
        vd.itemsShopTextures.add(6, new Texture("shop/viking_helmet.png"));
        vd.itemsShopTextures.add(7, new Texture("shop/party_hat.png"));
        vd.itemsShopTextures.add(8, new Texture("shop/wizard_hat.png"));
        vd.itemsShopTextures.add(9, new Texture("shop/anime_hat.png"));

        vd.itemsShopTextures.add(10, new Texture("shop/cat_ears.png"));
        vd.itemsShopTextures.add(11, new Texture("shop/winged_helmet.png"));
        vd.itemsShopTextures.add(12, new Texture("shop/black_cat_ears.png"));
        vd.itemsShopTextures.add(13, new Texture("shop/cowboy_hat_1.png"));
        vd.itemsShopTextures.add(14, new Texture("shop/cowboy_hat_2.png"));

        vd.itemsShopTextures.add(15, new Texture("shop/hair_1.png"));
        vd.itemsShopTextures.add(16, new Texture("shop/hair_2.png"));
        vd.itemsShopTextures.add(17, new Texture("shop/hair_3.png"));
        vd.itemsShopTextures.add(18, new Texture("shop/hair_4.png"));
        vd.itemsShopTextures.add(19, new Texture("shop/hair_5.png"));

        vd.itemsShopTextures.add(20, new Texture("shop/propeller_hat.png"));
        vd.itemsShopTextures.add(21, new Texture("shop/robin_hat.png"));
        vd.itemsShopTextures.add(22, new Texture("shop/crown.png"));
        vd.itemsShopTextures.add(23, new Texture("shop/cake_hat.png"));
        vd.itemsShopTextures.add(24, new Texture("shop/unicorn_hat.png"));
    }

    public void getTextures(){
        loadTextures();
    }

    private void loadButtons() {

        vd.loginButtonBtn = render.sprite(vd.loginButtonBtn, vd.loginButton, "loginFace");
        vd.cartBtn = render.sprite(vd.cartBtn, vd.cart, "cart");
        vd.coinBtn = render.sprite(vd.coinBtn, vd.coin, "coin");
        vd.topLevelBtn = render.sprite(vd.topLevelBtn, vd.topLevel, "topLevel");
        vd.closeWindowBtn = render.sprite(vd.closeWindowBtn, vd.closeWindow, "closeWindow");

        vd.itemMenuBtns.add(new Sprite());
        vd.itemMenuBtns.add(new Sprite());
        vd.itemMenuBtns.add(new Sprite());
        vd.itemMenuBtns.add(new Sprite());
        vd.itemMenuBtns.add(new Sprite());

        vd.itemMenuBtns.set(0,render.sprite(vd.itemMenuBtns.get(0), vd.itemMenu, "itemMenuBtn0"));
        vd.itemMenuBtns.set(1,render.sprite(vd.itemMenuBtns.get(1), vd.itemMenu, "itemMenuBtn1"));
        vd.itemMenuBtns.set(2,render.sprite(vd.itemMenuBtns.get(2), vd.itemMenu, "itemMenuBtn2"));
        vd.itemMenuBtns.set(3,render.sprite(vd.itemMenuBtns.get(3), vd.itemMenu, "itemMenuBtn3"));
        vd.itemMenuBtns.set(4,render.sprite(vd.itemMenuBtns.get(4), vd.itemMenu, "itemMenuBtn4"));

        vd.prevBtn = render.sprite(vd.prevBtn, vd.buttonPrev, "leftDown");
        vd.nextBtn = render.sprite(vd.nextBtn, vd.buttonNext, "rightDown");

        vd.backBtn = render.sprite(vd.backBtn, vd.buttonPrev, "leftDown");
        vd.buyBtn = render.sprite(vd.buyBtn, vd.buttonBuy, "rightDown");
        vd.equipBtn = render.sprite(vd.equipBtn, vd.buttonEquip, "rightDown");
        vd.unequipBtn = render.sprite(vd.unequipBtn, vd.buttonUnequip, "rightDown");
    }

    public void getButtons(){
        loadButtons();
    }

    private void loadSprites() {

        vd.slimeSpr = render.sprite(vd.slimeSpr, vd.slime, "center");
        vd.reconnectWindowSpr = render.sprite(vd.reconnectWindowSpr, vd.reconnectWindow, "center");
        vd.windowSpr = render.sprite(vd.windowSpr, vd.window, "center");

        int positionIcon = 0;

        for (int i=0; i<25; i++){

            vd.itemsShopSprites.add(i, new Sprite());
            vd.itemsShopSprites.set(i, render.sprite(vd.itemsShopSprites.get(i), vd.itemsShopTextures.get(i), "iconMenu"+positionIcon));
            if(positionIcon == 4){
                positionIcon = 0;
            } else {
                positionIcon = positionIcon + 1;
            }
        }

        //vd.itemsShopSprites.add(0, render.sprite(vd.itemsShopSprites.get(0), vd.itemsShopTextures.get(0), "iconMenu0"));


        /*
        vd.timeSpr = render.sprite(vd.timeSpr, vd.time, "iconMenu0");
        vd.pencilSpr = render.sprite(vd.pencilSpr, vd.pencil, "iconMenu1");

        vd.stClausHatSpr = render.sprite(vd.stClausHatSpr, vd.stClausHat, "iconMenu1");
        vd.habbitEarsSpr = render.sprite(vd.habbitEarsSpr, vd.habbitEars, "iconMenu1");

        vd.vkHelmetSpr = render.sprite(vd.vkHelmetSpr, vd.vkHelmet, "iconMenu2");
        vd.partyHatSpr = render.sprite(vd.partyHatSpr, vd.partyHat, "iconMenu3");
        vd.wizardHatSpr = render.sprite(vd.wizardHatSpr, vd.wizardHat, "iconMenu4");

        vd.coinSpr0 = render.sprite(vd.coinSpr0, vd.coin, "iconMenu0");
        vd.coinSpr1 = render.sprite(vd.coinSpr1, vd.coin, "iconMenu1");
        vd.coinSpr2 = render.sprite(vd.coinSpr2, vd.coin, "iconMenu2");
        vd.coinSpr3 = render.sprite(vd.coinSpr3, vd.coin, "iconMenu3");
        vd.coinSpr4 = render.sprite(vd.coinSpr4, vd.coin, "iconMenu4");*/
    }

    public void getSprites(){
        loadSprites();
    }

    private void loadFonts() {

        vd.generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.size = (int)(35 * Gdx.graphics.getDensity());
        vd.font = vd.generator.generateFont(parameter);

        // messages
        parameter.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.size = (int)(25 * Gdx.graphics.getDensity());
        parameter.color = Color.RED;
        vd.fontError = vd.generator.generateFont(parameter);
        parameter.color = Color.GREEN;
        vd.fontSuccess = vd.generator.generateFont(parameter);

        // title
        parameter.borderWidth = (int)(40 * Gdx.graphics.getDensity() * 0.03);
        parameter.size = (int)(40 * Gdx.graphics.getDensity());
        vd.fontTitle = vd.generator.generateFont(parameter);

        //menu
        parameter.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        parameter.color = Color.BLACK;
        parameter.size = (int)(20 * Gdx.graphics.getDensity());
        vd.fontTopLevel = vd.generator.generateFont(parameter);

        parameter.size = (int)(15 * Gdx.graphics.getDensity());
        vd.fontTopLevelNumber = vd.generator.generateFont(parameter);

        // level dentro
        parameter.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.color = Color.WHITE;
        parameter.size = (int)(30 * Gdx.graphics.getDensity());
        vd.fontPlayerSelecionadoLevel = vd.generator.generateFont(parameter);

    }

    public void getFonts(){
        loadFonts();
    }


    private void loadControllers() {

        // player top level controller
        for (int i = 0; i < 21; i++){
            vd.topPlayers.add((i+1) + " Player " + (i+1));
            vd.topPlayersLevel.add((i+1) + " 42 ");
            vd.topPlayersItemEquippedId.add((i+1));
        }

        // shop controller
        for (int i = 0; i < 25; i++) {
            vd.itemsShopBought.add(false);
            vd.itemsShopNames.add("");
            vd.itemsShopPrices.add("");
        }
    }

    public void getControllers() { loadControllers(); }
}
