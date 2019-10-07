package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Cart;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.TopLevel;
import com.slimeIdle.Model.Window;
import com.slimeIdle.View.Render;

public class Loader {

    Buttons btn;
    Render render;
    Account acc;
    Window window;
    Slime slime;
    Cart cart;
    Coin coin;
    TopLevel topLevel;
    Menu menu;
    Shop shop;
    Font font;


    public Loader(
            Buttons btn,
            Render render,
            Account acc,
            Window window,
            Slime slime,
            Cart cart,
            Coin coin,
            TopLevel topLevel,
            Menu menu,
            Shop shop,
            Font font){

        this.btn = btn;
        this.render = render;
        this.acc = acc;
        this.window = window;
        this.slime = slime;
        this.cart = cart;
        this.coin = coin;
        this.topLevel = topLevel;
        this.menu = menu;
        this.shop = shop;
        this.font = font;
    }

    private void loadTextures(){

        //login face
        btn.loginButton = new Texture("login_button.png");

        //principal
        slime.slime = new Texture("slime.png");
        window.reconnectWindow = new Texture("window.png");
        cart.cart = new Texture("cart.png");
        coin.coin = new Texture("coin.png");
        topLevel.topLevel = new Texture("topLevel.png");
        window.window = new Texture("window2.png");

        //menu
        menu.background_menu = new Texture("background_menu.png");
        window.closeWindow = new Texture("fechar_janela.png");
        menu.itemMenu = new Texture("item_menu.png");
        btn.buttonPrev = new Texture("prev.png");
        btn.buttonNext = new Texture("next.png");
        btn.buttonBuy = new Texture("buy.png");
        btn.buttonEquip = new Texture("equip.png");
        btn.buttonUnequip = new Texture("unequip.png");

        //loja cart
        shop.itemsShopTextures.add(0, new Texture("shop/time.png"));
        shop.itemsShopTextures.add(1, new Texture("shop/pencil.png"));

        shop.itemsShopTextures.add(2, new Texture("shop/santa_claus_hat.png"));
        shop.itemsShopTextures.add(3, new Texture("shop/habbit_ears.png"));
        shop.itemsShopTextures.add(4, new Texture("shop/witch_hat.png"));

        shop.itemsShopTextures.add(5, new Texture("shop/black_habbit_ears.png"));
        shop.itemsShopTextures.add(6, new Texture("shop/viking_helmet.png"));
        shop.itemsShopTextures.add(7, new Texture("shop/party_hat.png"));
        shop.itemsShopTextures.add(8, new Texture("shop/wizard_hat.png"));
        shop.itemsShopTextures.add(9, new Texture("shop/anime_hat.png"));

        shop.itemsShopTextures.add(10, new Texture("shop/cat_ears.png"));
        shop.itemsShopTextures.add(11, new Texture("shop/winged_helmet.png"));
        shop.itemsShopTextures.add(12, new Texture("shop/black_cat_ears.png"));
        shop.itemsShopTextures.add(13, new Texture("shop/cowboy_hat_1.png"));
        shop.itemsShopTextures.add(14, new Texture("shop/cowboy_hat_2.png"));

        shop.itemsShopTextures.add(15, new Texture("shop/hair_1.png"));
        shop.itemsShopTextures.add(16, new Texture("shop/hair_2.png"));
        shop.itemsShopTextures.add(17, new Texture("shop/hair_3.png"));
        shop.itemsShopTextures.add(18, new Texture("shop/hair_4.png"));
        shop.itemsShopTextures.add(19, new Texture("shop/hair_5.png"));

        shop.itemsShopTextures.add(20, new Texture("shop/propeller_hat.png"));
        shop.itemsShopTextures.add(21, new Texture("shop/robin_hat.png"));
        shop.itemsShopTextures.add(22, new Texture("shop/crown.png"));
        shop.itemsShopTextures.add(23, new Texture("shop/cake_hat.png"));
        shop.itemsShopTextures.add(24, new Texture("shop/unicorn_hat.png"));
    }

    public void getTextures(){
        loadTextures();
    }

    private void loadButtons() {

        btn.loginButtonBtn = render.sprite(btn.loginButtonBtn, btn.loginButton, "loginFace");
        btn.cartBtn = render.sprite(btn.cartBtn, cart.cart, "cart");
        btn.coinBtn = render.sprite(btn.coinBtn, coin.coin, "coin");
        btn.topLevelBtn = render.sprite(btn.topLevelBtn, topLevel.topLevel, "topLevel");
        btn.closeWindowBtn = render.sprite(btn.closeWindowBtn, window.closeWindow, "closeWindow");

        btn.itemMenuBtns.add(new Sprite());
        btn.itemMenuBtns.add(new Sprite());
        btn.itemMenuBtns.add(new Sprite());
        btn.itemMenuBtns.add(new Sprite());
        btn.itemMenuBtns.add(new Sprite());

        btn.itemMenuBtns.set(0,render.sprite(btn.itemMenuBtns.get(0), menu.itemMenu, "itemMenuBtn0"));
        btn.itemMenuBtns.set(1,render.sprite(btn.itemMenuBtns.get(1), menu.itemMenu, "itemMenuBtn1"));
        btn.itemMenuBtns.set(2,render.sprite(btn.itemMenuBtns.get(2), menu.itemMenu, "itemMenuBtn2"));
        btn.itemMenuBtns.set(3,render.sprite(btn.itemMenuBtns.get(3), menu.itemMenu, "itemMenuBtn3"));
        btn.itemMenuBtns.set(4,render.sprite(btn.itemMenuBtns.get(4), menu.itemMenu, "itemMenuBtn4"));

        btn.prevBtn = render.sprite(btn.prevBtn, btn.buttonPrev, "leftDown");
        btn.nextBtn = render.sprite(btn.nextBtn, btn.buttonNext, "rightDown");

        btn.backBtn = render.sprite(btn.backBtn, btn.buttonPrev, "leftDown");
        btn.buyBtn = render.sprite(btn.buyBtn, btn.buttonBuy, "rightDown");
        btn.equipBtn = render.sprite(btn.equipBtn, btn.buttonEquip, "rightDown");
        btn.unequipBtn = render.sprite(btn.unequipBtn, btn.buttonUnequip, "rightDown");
    }

    public void getButtons(){
        loadButtons();
    }

    private void loadSprites() {

        slime.slimeSpr = render.sprite(slime.slimeSpr, slime.slime, "center");
        window.reconnectWindowSpr = render.sprite(window.reconnectWindowSpr, window.reconnectWindow, "center");
        window.windowSpr = render.sprite(window.windowSpr, window.window, "center");

        int positionIcon = 0;

        for (int i=0; i<25; i++){

            shop.itemsShopSprites.add(i, new Sprite());
            shop.itemsShopSprites.set(i, render.sprite(shop.itemsShopSprites.get(i), shop.itemsShopTextures.get(i), "iconMenu"+positionIcon));
            if(positionIcon == 4){
                positionIcon = 0;
            } else {
                positionIcon = positionIcon + 1;
            }
        }
    }

    public void getSprites(){
        loadSprites();
    }

    private void loadFonts() {

        font.generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.size = (int)(35 * Gdx.graphics.getDensity());
        font.font = font.generator.generateFont(parameter);

        // messages
        parameter.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.size = (int)(25 * Gdx.graphics.getDensity());
        parameter.color = Color.RED;
        font.fontError = font.generator.generateFont(parameter);
        parameter.color = Color.GREEN;
        font.fontSuccess = font.generator.generateFont(parameter);

        // title
        parameter.borderWidth = (int)(40 * Gdx.graphics.getDensity() * 0.03);
        parameter.size = (int)(40 * Gdx.graphics.getDensity());
        font.fontTitle = font.generator.generateFont(parameter);

        //menu
        parameter.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        parameter.color = Color.BLACK;
        parameter.size = (int)(20 * Gdx.graphics.getDensity());
        font.fontTopLevel = font.generator.generateFont(parameter);

        parameter.size = (int)(15 * Gdx.graphics.getDensity());
        font.fontTopLevelNumber = font.generator.generateFont(parameter);

        // level dentro
        parameter.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.color = Color.WHITE;
        parameter.size = (int)(30 * Gdx.graphics.getDensity());
        font.fontPlayerSelecionadoLevel = font.generator.generateFont(parameter);

    }

    public void getFonts(){
        loadFonts();
    }


    private void loadControllers() {

        // player top level controller
        for (int i = 0; i < 21; i++){
            topLevel.topPlayers.add((i+1) + " Player " + (i+1));
            topLevel.topPlayersLevel.add((i+1) + " 42 ");
            topLevel.topPlayersItemEquippedId.add((i+1));
        }

        // shop controller
        for (int i = 0; i < 25; i++) {
            shop.itemsShopBought.add(false);
            shop.itemsShopNames.add("");
            shop.itemsShopPrices.add("");
        }
    }

    public void getControllers() { loadControllers(); }
}
