package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
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

    AssetManager manager = new AssetManager();
    FileHandleResolver resolver = new InternalFileHandleResolver();

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

    private void font(String GLYPHS, AssetManager manager, String fileName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(35 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        manager.load(fileName+".ttf", BitmapFont.class, parameter);
    }

    private void fontError (String GLYPHS, AssetManager manager, String fileName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(25 * Gdx.graphics.getDensity());
        parameter.fontParameters.color = Color.RED;
        parameter.fontParameters.characters= GLYPHS;
        manager.load(fileName+"error.ttf", BitmapFont.class, parameter);
    }

    private void fontSuccess (String GLYPHS, AssetManager manager, String fileName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(25 * Gdx.graphics.getDensity());
        parameter.fontParameters.color = Color.GREEN;
        parameter.fontParameters.characters= GLYPHS;
        manager.load(fileName+"success.ttf", BitmapFont.class, parameter);
    }

    private void fontTitle (String GLYPHS, AssetManager manager, String fileName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(40 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(40 * Gdx.graphics.getDensity());
        parameter.fontParameters.color = Color.GREEN;
        parameter.fontParameters.characters= GLYPHS;
        manager.load(fileName+"title.ttf", BitmapFont.class, parameter);
    }

    private void fontTopLevel (String GLYPHS, AssetManager manager, String fileName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.color = Color.BLACK;
        parameter.fontParameters.size = (int)(20 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        manager.load(fileName+"topLevel.ttf", BitmapFont.class, parameter);
    }

    private void fontTopLevelNumber (String GLYPHS, AssetManager manager, String fileName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.color = Color.BLACK;
        parameter.fontParameters.size = (int)(15 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        manager.load(fileName+"topLevelNumber.ttf", BitmapFont.class, parameter);
    }

    private void fontPlayerSelecionadoLevel (String GLYPHS, AssetManager manager, String fileName) {

        //FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.color = Color.WHITE;
        parameter.fontParameters.size = (int)(30 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        //return generator.generateFont(parameter);
        manager.load(fileName+"playerSelecionadoLevel.ttf", BitmapFont.class, parameter);
        //manager.finishLoading();
        //return manager.get(fileName, BitmapFont.class);
    }

    public void loadFonts() {

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        String fontDEFAULT = "fonts/default/fontDEFAULT";
        String fontJAPAN = "fonts/japan/fontJAPAN";
        String fontKOREA = "fonts/korea/fontKOREA";
        String fontCHINA = "fonts/china/fontCHINA";
        String fontARABIA = "fonts/arabic/fontARABIA";

        /*
        String fontDEFAULT = "fonts/default/fontDEFAULT";
        String fontJAPAN = "fonts/default/fontDEFAULT";
        String fontKOREA = "fonts/default/fontDEFAULT";
        String fontCHINA = "fonts/default/fontDEFAULT";
        String fontARABIA = "fonts/default/fontDEFAULT";*/

        /*
        for (int i=0; i<=Integer.MAX_VALUE; i++) {
            if (Character.isDefined(i)) {
                //System.out.println(Integer.toHexString(i)+": "+ new String(Character.toChars(i)));
                //Integer.toString(i);
                font.glyps += new String(Character.toChars(i));
            }
        }
         */

        //System.out.println("braddock: "+font.glyps);

        this.font(font.glyps, manager, fontDEFAULT);
        this.fontError(font.glyps, manager, fontDEFAULT);
        this.fontSuccess(font.glyps, manager, fontDEFAULT);
        this.fontTitle(font.glyps, manager, fontDEFAULT);
        this.fontTopLevel(font.glyps, manager, fontDEFAULT);
        this.fontTopLevelNumber(font.glyps, manager, fontDEFAULT);
        this.fontPlayerSelecionadoLevel(font.glyps, manager, fontDEFAULT);

        /*
        this.font(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        this.fontError(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        this.fontSuccess(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        this.fontTitle(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        this.fontTopLevel(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        this.fontTopLevelNumber(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        this.fontPlayerSelecionadoLevel(font.DEFAULT_GLYPHS, manager, fontDEFAULT);

         */



        this.font(font.glypsJapan, manager, fontJAPAN);
        this.fontError(font.glypsJapan, manager, fontJAPAN);
        this.fontSuccess(font.glypsJapan, manager, fontJAPAN);
        this.fontTitle(font.glypsJapan, manager, fontJAPAN);
        this.fontTopLevel(font.glypsJapan, manager, fontJAPAN);
        this.fontTopLevelNumber(font.glypsJapan, manager, fontJAPAN);
        this.fontPlayerSelecionadoLevel(font.glypsJapan, manager, fontJAPAN);



        this.font(font.glypsKorea, manager, fontKOREA);
        this.fontError(font.glypsKorea, manager, fontKOREA);
        this.fontSuccess(font.glypsKorea, manager, fontKOREA);
        this.fontTitle(font.glypsKorea, manager, fontKOREA);
        this.fontTopLevel(font.glypsKorea, manager, fontKOREA);
        this.fontTopLevelNumber(font.glypsKorea, manager, fontKOREA);
        this.fontPlayerSelecionadoLevel(font.glypsKorea, manager, fontKOREA);

        this.font(font.glypsChina, manager, fontCHINA);
        this.fontError(font.glypsChina, manager, fontCHINA);
        this.fontSuccess(font.glypsChina, manager, fontCHINA);
        this.fontTitle(font.glypsChina, manager, fontCHINA);
        this.fontTopLevel(font.glypsChina, manager, fontCHINA);
        this.fontTopLevelNumber(font.glypsChina, manager, fontCHINA);
        this.fontPlayerSelecionadoLevel(font.glypsChina, manager, fontCHINA);

        /*
        this.font(font.glypsArabia, manager, fontARABIA);
        this.fontError(font.glypsArabia, manager, fontARABIA);
        this.fontSuccess(font.glypsArabia, manager, fontARABIA);
        this.fontTitle(font.glypsArabia, manager, fontARABIA);
        this.fontTopLevel(font.glypsArabia, manager, fontARABIA);
        this.fontTopLevelNumber(font.glypsArabia, manager, fontARABIA);
        this.fontPlayerSelecionadoLevel(font.glypsArabia, manager, fontARABIA);*/



    }

    public void getFonts(){

        manager.finishLoading();

        font.fontDEFAULT = manager.get("fonts/default/fontDEFAULT.ttf", BitmapFont.class);
        font.fontErrorDEFAULT = manager.get("fonts/default/fontDEFAULTerror.ttf", BitmapFont.class);
        font.fontSuccessDEFAULT = manager.get("fonts/default/fontDEFAULTsuccess.ttf", BitmapFont.class);
        font.fontTitleDEFAULT = manager.get("fonts/default/fontDEFAULTtitle.ttf", BitmapFont.class);
        font.fontTopLevelDEFAULT = manager.get("fonts/default/fontDEFAULTtopLevel.ttf", BitmapFont.class);
        font.fontTopLevelNumberDEFAULT = manager.get("fonts/default/fontDEFAULTtopLevelNumber.ttf", BitmapFont.class);
        font.fontPlayerSelecionadoLevelDEFAULT = manager.get("fonts/default/fontDEFAULTplayerSelecionadoLevel.ttf", BitmapFont.class);

        font.fontJAPAN = manager.get("fonts/japan/fontJAPAN.ttf", BitmapFont.class);
        font.fontErrorJAPAN = manager.get("fonts/japan/fontJAPANerror.ttf", BitmapFont.class);
        font.fontSuccessJAPAN = manager.get("fonts/japan/fontJAPANsuccess.ttf", BitmapFont.class);
        font.fontTitleJAPAN = manager.get("fonts/japan/fontJAPANtitle.ttf", BitmapFont.class);
        font.fontTopLevelJAPAN = manager.get("fonts/japan/fontJAPANtopLevel.ttf", BitmapFont.class);
        font.fontTopLevelNumberJAPAN = manager.get("fonts/japan/fontJAPANtopLevelNumber.ttf", BitmapFont.class);
        font.fontPlayerSelecionadoLevelJAPAN = manager.get("fonts/japan/fontJAPANplayerSelecionadoLevel.ttf", BitmapFont.class);

        font.fontKOREA = manager.get("fonts/korea/fontKOREA.ttf", BitmapFont.class);
        font.fontErrorKOREA = manager.get("fonts/korea/fontKOREAerror.ttf", BitmapFont.class);
        font.fontSuccessKOREA = manager.get("fonts/korea/fontKOREAsuccess.ttf", BitmapFont.class);
        font.fontTitleKOREA = manager.get("fonts/korea/fontKOREAtitle.ttf", BitmapFont.class);
        font.fontTopLevelKOREA = manager.get("fonts/korea/fontKOREAtopLevel.ttf", BitmapFont.class);
        font.fontTopLevelNumberKOREA = manager.get("fonts/korea/fontKOREAtopLevelNumber.ttf", BitmapFont.class);
        font.fontPlayerSelecionadoLevelKOREA = manager.get("fonts/korea/fontKOREAplayerSelecionadoLevel.ttf", BitmapFont.class);

        font.fontCHINA = manager.get("fonts/china/fontCHINA.ttf", BitmapFont.class);
        font.fontErrorCHINA = manager.get("fonts/china/fontCHINAerror.ttf", BitmapFont.class);
        font.fontSuccessCHINA = manager.get("fonts/china/fontCHINAsuccess.ttf", BitmapFont.class);
        font.fontTitleCHINA = manager.get("fonts/china/fontCHINAtitle.ttf", BitmapFont.class);
        font.fontTopLevelCHINA = manager.get("fonts/china/fontCHINAtopLevel.ttf", BitmapFont.class);
        font.fontTopLevelNumberCHINA = manager.get("fonts/china/fontCHINAtopLevelNumber.ttf", BitmapFont.class);
        font.fontPlayerSelecionadoLevelCHINA = manager.get("fonts/china/fontCHINAplayerSelecionadoLevel.ttf", BitmapFont.class);

        font.glyps = "";
        font.glypsJapan = "";
        font.glypsKorea = "";
        font.glypsChina = "";

        /*
        font.fontARABIA = manager.get("fonts/arabic/fontARABIA.ttf", BitmapFont.class);
        font.fontErrorARABIA = manager.get("fonts/arabic/fontARABIAerror.ttf", BitmapFont.class);
        font.fontSuccessARABIA = manager.get("fonts/arabic/fontARABIAsuccess.ttf", BitmapFont.class);
        font.fontTitleARABIA = manager.get("fonts/arabic/fontARABIAtitle.ttf", BitmapFont.class);
        font.fontTopLevelARABIA = manager.get("fonts/arabic/fontARABIAtopLevel.ttf", BitmapFont.class);
        font.fontTopLevelNumberARABIA = manager.get("fonts/arabic/fontARABIAtopLevelNumber.ttf", BitmapFont.class);
        font.fontPlayerSelecionadoLevelARABIA = manager.get("fonts/arabic/fontARABIAplayerSelecionadoLevel.ttf", BitmapFont.class);*/

        System.out.println("Tudo Carregado");
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
