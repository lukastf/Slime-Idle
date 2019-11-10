package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.utils.Array;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.BitmapFontWriter;
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

import java.io.File;
import java.util.Map;

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

    private PixmapPacker font(String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(35 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+".ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private PixmapPacker fontMessage (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(25 * Gdx.graphics.getDensity());
        //parameter.fontParameters.color = Color.RED;
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"message.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private PixmapPacker fontTopLevel (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.color = Color.BLACK;
        parameter.fontParameters.size = (int)(20 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"topLevel.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private PixmapPacker fontTopLevelNumber (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.color = Color.BLACK;
        parameter.fontParameters.size = (int)(15 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"topLevelNumber.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    /*
    private PixmapPacker fontPlayerSelecionadoLevel (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        //FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(35 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.color = Color.WHITE;
        parameter.fontParameters.size = (int)(30 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        //return generator.generateFont(parameter);
        manager.load(fileName+newFontName+"playerSelecionadoLevel.ttf", BitmapFont.class, parameter);
        //manager.finishLoading();
        //return manager.get(fileName, BitmapFont.class);

        return parameter.fontParameters.packer;
    }*/

    private BitmapFont getBitmapFont(FileHandle fileFnt, String pathPng) {

        FileHandle filePng = Gdx.files.local(pathPng+".png");
        BitmapFont.BitmapFontData fontData = new BitmapFont.BitmapFontData(fileFnt, false);
        Array <TextureRegion> textureRegion = new Array <TextureRegion>();

        font.fontCache = true;

        if(filePng.exists()) {

            //FileHandle file = Gdx.files.local("fonts/generated/DEFAULT/font.png");
            textureRegion.add(new TextureRegion(new Texture(filePng)));

        } else /*if (Gdx.files.local("fonts/generated/DEFAULT/font_0.png").exists())*/ {

            int i = 0;

            //while (Gdx.files.local("fonts/generated/DEFAULT/font_"+i+".png").exists()) {
            while (Gdx.files.local(pathPng+"_"+i+".png").exists()) {

                FileHandle file = Gdx.files.local(pathPng+"_"+i+".png");
                textureRegion.add(new TextureRegion(new Texture(file)));
                i++;
            }

        }

        return new BitmapFont(fontData, textureRegion, false);
    }

    private void getOrGenerateFont (String FONT, String fontPath, String fontName, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers, String glyps, int fontType) {

        FileHandle fileFnt = Gdx.files.local("fonts/generated/"+fontPath+"/"+fontName+".fnt");

        if(fileFnt.exists()) {
            System.out.println("oi");
            fontMap.put(fontName, this.getBitmapFont(fileFnt,"fonts/generated/"+fontPath+"/"+fontName));
        } else {
            System.out.println("xau");
            PixmapPacker pix = null;
            switch (fontType){
                case 0:
                    pix = this.font(glyps, manager, FONT, fontPath);
                    break;
                case 1:
                    //pix = this.fontError(glyps, manager, FONT, fontPath);
                    pix = this.fontMessage(glyps, manager, FONT, fontPath);
                    break;
                case 2:
                    //pix = this.fontSuccess(glyps, manager, FONT, fontPath);
                    break;
                case 3:
                    //pix = this.fontTitle(glyps, manager, FONT, fontPath);
                    break;
                case 4:
                    pix = this.fontTopLevel(glyps, manager, FONT, fontPath);
                    break;
                case 5:
                    pix = this.fontTopLevelNumber(glyps, manager, FONT, fontPath);
                    break;
                case 6:
                    //pix = this.fontPlayerSelecionadoLevel(glyps, manager, FONT, fontPath);
                    break;
            }
            pixPackers.put(fontName, pix);
        }
    }

    private void getOrGenerateAllFonts (String fontPath, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers, String glyps) {

        String FONT = "fonts/font";

        this.getOrGenerateFont(FONT, fontPath, "font", fontMap, pixPackers, glyps, 0);
        this.getOrGenerateFont(FONT, fontPath, "message", fontMap, pixPackers, glyps, 1);
        //this.getOrGenerateFont(FONT, fontPath, "error", fontMap, pixPackers, glyps, 1);
        //this.getOrGenerateFont(FONT, fontPath, "success", fontMap, pixPackers, glyps, 2);
        //this.getOrGenerateFont(FONT, fontPath, "title", fontMap, pixPackers, glyps, 3);
        this.getOrGenerateFont(FONT, fontPath, "topLevel", fontMap, pixPackers, glyps, 4);
        this.getOrGenerateFont(FONT, fontPath, "topLevelNumber", fontMap, pixPackers, glyps, 5);
        //this.getOrGenerateFont(FONT, fontPath, "playerSelecionadoLevel", fontMap, pixPackers, glyps, 6);
    }

    public void loadFonts() {

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        this.getOrGenerateAllFonts("DEFAULT",font.fontDefault,font.pixPackersDefault,font.glyps);
        this.getOrGenerateAllFonts("JAPAN",font.fontJapan,font.pixPackersJapan,font.glypsJapan);
        this.getOrGenerateAllFonts("KOREA",font.fontKorea,font.pixPackersKorea,font.glypsKorea);
    }

    private void writeAllFonts(String fontPath, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers) {

        fontMap.put("font", manager.get("fonts/font"+fontPath+".ttf", BitmapFont.class));
        fontMap.put("message", manager.get("fonts/font"+fontPath+"message.ttf", BitmapFont.class));
        //fontMap.put("error", manager.get("fonts/font"+fontPath+"error.ttf", BitmapFont.class));
        //fontMap.put("success", manager.get("fonts/font"+fontPath+"success.ttf", BitmapFont.class));
        //fontMap.put("title", manager.get("fonts/font"+fontPath+"title.ttf", BitmapFont.class));
        fontMap.put("topLevel", manager.get("fonts/font"+fontPath+"topLevel.ttf", BitmapFont.class));
        fontMap.put("topLevelNumber", manager.get("fonts/font"+fontPath+"topLevelNumber.ttf", BitmapFont.class));
        //fontMap.put("playerSelecionadoLevel", manager.get("fonts/font"+fontPath+"playerSelecionadoLevel.ttf", BitmapFont.class));

        BitmapFontWriter.FontInfo info = new BitmapFontWriter.FontInfo();
        info.padding = new BitmapFontWriter.Padding(1, 1, 1, 1);
        BitmapFontWriter.writeFont(fontMap.get("font").getData(), new String[]{"fonts/generated/"+fontPath+"/font.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/font.fnt"), info, font.pageWidth, font.pageHeight);
        BitmapFontWriter.writeFont(fontMap.get("message").getData(), new String[]{"fonts/generated/"+fontPath+"/message.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/message.fnt"), info, font.pageWidth, font.pageHeight);
        //BitmapFontWriter.writePixmaps(param.packer.getPages(), Gdx.files.absolute("imageDir"), name);
        //BitmapFontWriter.writeFont(fontMap.get("error").getData(), new String[]{"fonts/generated/"+fontPath+"/error.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/error.fnt"), info, font.pageWidth, font.pageHeight);
        //BitmapFontWriter.writeFont(fontMap.get("success").getData(), new String[]{"fonts/generated/"+fontPath+"/success.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/success.fnt"), info, font.pageWidth, font.pageHeight);
        //BitmapFontWriter.writeFont(fontMap.get("title").getData(), new String[]{"fonts/generated/"+fontPath+"/title.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/title.fnt"), info, font.pageWidth, font.pageHeight);
        BitmapFontWriter.writeFont(fontMap.get("topLevel").getData(), new String[]{"fonts/generated/"+fontPath+"/topLevel.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/topLevel.fnt"), info, font.pageWidth, font.pageHeight);
        BitmapFontWriter.writeFont(fontMap.get("topLevelNumber").getData(), new String[]{"fonts/generated/"+fontPath+"/topLevelNumber.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/topLevelNumber.fnt"), info, font.pageWidth, font.pageHeight);
        //BitmapFontWriter.writeFont(fontMap.get("playerSelecionadoLevel").getData(), new String[]{"fonts/generated/"+fontPath+"/playerSelecionadoLevel.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/playerSelecionadoLevel.fnt"), info, font.pageWidth, font.pageHeight);

        BitmapFontWriter.writePixmaps(pixPackers.get("font").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "font");
        BitmapFontWriter.writePixmaps(pixPackers.get("message").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "message");
        //BitmapFontWriter.writePixmaps(pixPackers.get("error").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "error");
        //BitmapFontWriter.writePixmaps(pixPackers.get("success").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "success");
        //BitmapFontWriter.writePixmaps(pixPackers.get("title").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "title");
        BitmapFontWriter.writePixmaps(pixPackers.get("topLevel").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "topLevel");
        BitmapFontWriter.writePixmaps(pixPackers.get("topLevelNumber").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "topLevelNumber");
        //BitmapFontWriter.writePixmaps(pixPackers.get("playerSelecionadoLevel").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "playerSelecionadoLevel");
    }

    private void cacheAllFonts(Map<String, BitmapFontCache> fontCache, Map<String, BitmapFont> fontMap) {

        fontCache.put("font", fontMap.get("font").newFontCache());
        fontCache.put("message", fontMap.get("message").newFontCache());
        //fontCache.put("error", fontMap.get("message").newFontCache());
        //fontCache.put("success", fontMap.get("message").newFontCache());
        //fontCache.put("error", fontMap.get("error").newFontCache());
        //fontCache.put("success", fontMap.get("success").newFontCache());
        //fontCache.put("title", fontMap.get("font").newFontCache());
        fontCache.put("topLevel", fontMap.get("topLevel").newFontCache());
        fontCache.put("topLevelNumber", fontMap.get("topLevelNumber").newFontCache());
        //fontCache.put("playerSelecionadoLevel", fontMap.get("playerSelecionadoLevel").newFontCache());
    }

    public void getFonts(){

        if (font.fontCache == false) {

            manager.finishLoading();

            this.writeAllFonts("DEFAULT",font.fontDefault,font.pixPackersDefault);
            this.writeAllFonts("JAPAN",font.fontJapan,font.pixPackersJapan);
            this.writeAllFonts("KOREA",font.fontKorea,font.pixPackersKorea);

            System.out.println("chumm lee");
        }

        this.cacheAllFonts(font.fontDefaultCache,font.fontDefault);
        this.cacheAllFonts(font.fontJapanCache,font.fontJapan);
        this.cacheAllFonts(font.fontKoreaCache,font.fontKorea);

        //font.fontDefaultCache.get("").setColor(Color.GREEN);

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
