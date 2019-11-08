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

    private PixmapPacker fontError (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(25 * Gdx.graphics.getDensity());
        parameter.fontParameters.color = Color.RED;
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"error.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private PixmapPacker fontSuccess (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(25 * Gdx.graphics.getDensity());
        parameter.fontParameters.color = Color.GREEN;
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"success.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private PixmapPacker fontTitle (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(40 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(40 * Gdx.graphics.getDensity());
        parameter.fontParameters.color = Color.GREEN;
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"title.ttf", BitmapFont.class, parameter);

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
    }

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
                    pix = this.fontError(glyps, manager, FONT, fontPath);
                    break;
                case 2:
                    pix = this.fontSuccess(glyps, manager, FONT, fontPath);
                    break;
                case 3:
                    pix = this.fontTitle(glyps, manager, FONT, fontPath);
                    break;
                case 4:
                    pix = this.fontTopLevel(glyps, manager, FONT, fontPath);
                    break;
                case 5:
                    pix = this.fontTopLevelNumber(glyps, manager, FONT, fontPath);
                    break;
                case 6:
                    pix = this.fontPlayerSelecionadoLevel(glyps, manager, FONT, fontPath);
                    break;
            }
            pixPackers.put(fontName, pix);
        }
    }

    private void getOrGenerateAllFonts (String fontPath, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers, String glyps) {


        String FONT = "fonts/font";

        this.getOrGenerateFont(FONT, fontPath, "font", fontMap, pixPackers, glyps, 0);
        this.getOrGenerateFont(FONT, fontPath, "error", fontMap, pixPackers, glyps, 1);
        this.getOrGenerateFont(FONT, fontPath, "success", fontMap, pixPackers, glyps, 2);
        this.getOrGenerateFont(FONT, fontPath, "title", fontMap, pixPackers, glyps, 3);
        this.getOrGenerateFont(FONT, fontPath, "topLevel", fontMap, pixPackers, glyps, 4);
        this.getOrGenerateFont(FONT, fontPath, "topLevelNumber", fontMap, pixPackers, glyps, 5);
        this.getOrGenerateFont(FONT, fontPath, "playerSelecionadoLevel", fontMap, pixPackers, glyps, 6);

        /*
        FileHandle fileFnt = Gdx.files.local("fonts/generated/"+newFontName+"/font.fnt");

        if(fileFnt.exists()) {
            fontMap.put("font", this.getBitmapFont(fileFnt,"fonts/generated/"+newFontName+"/font"));
        } else {
            pixPackers.put("font", this.font(glyps, manager, FONT, newFontName));
        }

        fileFnt = Gdx.files.local("fonts/generated/"+newFontName+"/font.fnt");

        if(fileFnt.exists()) {
            fontMap.put("font", this.getBitmapFont(fileFnt,"fonts/generated/"+newFontName+"/font"));
        } else {
            pixPackers.put("font", this.font(glyps, manager, FONT, newFontName));
        }


        if (fileFnt.exists()) {



            //font.fontDefault.put("font", new BitmapFont(fontData, textureRegion, false));
            fontMap.put("font", this.getBitmapFont(Gdx.files.local("fonts/generated/"+newFontName+"/font.fnt"),"fonts/generated/"+newFontName+"/font"));
            fontMap.put("error", new BitmapFont(Gdx.files.local("fonts/generated/"+newFontName+"/error.fnt"), Gdx.files.local("fonts/generated/DEFAULT/error.png"),false));
            fontMap.put("success", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/success.fnt"), Gdx.files.local("fonts/generated/DEFAULT/success.png"),false));
            fontMap.put("title", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/title.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/title.png"),false));
            fontMap.put("topLevel", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/topLevel.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/topLevel.png"),false));
            fontMap.put("topLevelNumber", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/topLevelNumber.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/topLevelNumber.png"),false));
            fontMap.put("playerSelecionadoLevel", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/playerSelecionadoLevel.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/playerSelecionadoLevel.png"),false));

        } else {
            //font.fontCache = false;
            pixPackers.put("font", this.font(glyps, manager, FONT, newFontName));
            pixPackers.put("error", this.fontError(glyps, manager, FONT, newFontName));
            pixPackers.put("success", this.fontSuccess(glyps, manager, FONT, newFontName));
            pixPackers.put("title", this.fontTitle(glyps, manager, FONT, newFontName));
            pixPackers.put("topLevel", this.fontTopLevel(glyps, manager, FONT, newFontName));
            pixPackers.put("topLevelNumber", this.fontTopLevelNumber(glyps, manager, FONT, newFontName));
            pixPackers.put("playerSelecionadoLevel", this.fontPlayerSelecionadoLevel(glyps, manager, FONT, newFontName));
        }*/

        //return new BitmapFont(fontData, textureRegion, false);
    }

    public void loadFonts() {

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        //String FONT = "fonts/font";

        this.getOrGenerateAllFonts("DEFAULT",font.fontDefault,font.pixPackersDefault,font.glyps);
        this.getOrGenerateAllFonts("JAPAN",font.fontJapan,font.pixPackersJapan,font.glypsJapan);
        this.getOrGenerateAllFonts("KOREA",font.fontKorea,font.pixPackersKorea,font.glypsKorea);

        /*
            String fontJAPAN = "fonts/japan/fontJAPAN";
            String fontKOREA = "fonts/korea/fontKOREA";
            String fontCHINA = "fonts/china/fontCHINA";
            String fontARABIA = "fonts/arabic/fontARABIA";

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

        //FileHandle fontSavedDefault = Gdx.files.local("fonts/generated/DEFAULT/font.fnt");
        //FileHandle fontSavedJapan = Gdx.files.local("fonts/generated/JAPAN/font.fnt");
        //FileHandle fontSavedKorea = Gdx.files.local("fonts/generated/KOREA/font.fnt");

        //System.out.println("chuck" + fontSavedDefault.exists());
        //System.out.println("norris" + fontSavedJapan.exists());

        //System.out.println("flanderson" + Gdx.files.getLocalStoragePath());

        /*
        if (fontSavedDefault.exists() && fontSavedJapan.exists() && fontSavedKorea.exists()) {

            System.out.println("chuck norris bate no rambo");
            font.fontCache = true;

            Array <TextureRegion> textureRegion = new Array <TextureRegion>();
            BitmapFont.BitmapFontData fontData = new BitmapFont.BitmapFontData(Gdx.files.local("fonts/generated/DEFAULT/font.fnt"), false);

            if(Gdx.files.local("fonts/generated/DEFAULT/font.png").exists()) {

                FileHandle file = Gdx.files.local("fonts/generated/DEFAULT/font.png");
                textureRegion.add(new TextureRegion(new Texture(file)));

            } else if (Gdx.files.local("fonts/generated/DEFAULT/font_0.png").exists()) {

                int i = 0;

                while (Gdx.files.local("fonts/generated/DEFAULT/font_"+i+".png").exists()) {

                    FileHandle file = Gdx.files.local("fonts/generated/DEFAULT/font_"+i+".png");
                    textureRegion.add(new TextureRegion(new Texture(file)));
                    i++;
                }

            }



            font.fontDefault.put("font", );
            font.fontDefault.put("error", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/error.fnt"), Gdx.files.local("fonts/generated/DEFAULT/error.png"),false));
            font.fontDefault.put("success", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/success.fnt"), Gdx.files.local("fonts/generated/DEFAULT/success.png"),false));
            font.fontDefault.put("title", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/title.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/title.png"),false));
            font.fontDefault.put("topLevel", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/topLevel.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/topLevel.png"),false));
            font.fontDefault.put("topLevelNumber", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/topLevelNumber.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/topLevelNumber.png"),false));
            font.fontDefault.put("playerSelecionadoLevel", new BitmapFont(Gdx.files.local("fonts/generated/DEFAULT/playerSelecionadoLevel.fnt"),  Gdx.files.local("fonts/generated/DEFAULT/playerSelecionadoLevel.png"),false));

            font.fontJapan.put("font", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/font.fnt"),  Gdx.files.local("fonts/generated/JAPAN/font.png"),false));
            font.fontJapan.put("error", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/error.fnt"), Gdx.files.local("fonts/generated/JAPAN/error.png"),false));
            font.fontJapan.put("success", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/success.fnt"), Gdx.files.local("fonts/generated/JAPAN/success.png"),false));
            font.fontJapan.put("title", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/title.fnt"), Gdx.files.local("fonts/generated/JAPAN/title.png"),false));
            font.fontJapan.put("topLevel", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/topLevel.fnt"), Gdx.files.local("fonts/generated/JAPAN/topLevel.png"),false));
            font.fontJapan.put("topLevelNumber", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/topLevelNumber.fnt"), Gdx.files.local("fonts/generated/JAPAN/topLevelNumber.png"),false));
            font.fontJapan.put("playerSelecionadoLevel", new BitmapFont(Gdx.files.local("fonts/generated/JAPAN/playerSelecionadoLevel.fnt"), Gdx.files.local("fonts/generated/JAPAN/playerSelecionadoLevel.png"),false));

            font.fontKorea.put("font", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/font.fnt"),  Gdx.files.local("fonts/generated/KOREA/font.png"),false));
            font.fontKorea.put("error", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/error.fnt"), Gdx.files.local("fonts/generated/KOREA/error.png"),false));
            font.fontKorea.put("success", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/success.fnt"), Gdx.files.local("fonts/generated/KOREA/success.png"),false));
            font.fontKorea.put("title", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/title.fnt"), Gdx.files.local("fonts/generated/KOREA/title.png"),false));
            font.fontKorea.put("topLevel", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/topLevel.fnt"), Gdx.files.local("fonts/generated/KOREA/topLevel.png"),false));
            font.fontKorea.put("topLevelNumber", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/topLevelNumber.fnt"), Gdx.files.local("fonts/generated/KOREA/topLevelNumber.png"),false));
            font.fontKorea.put("playerSelecionadoLevel", new BitmapFont(Gdx.files.local("fonts/generated/KOREA/playerSelecionadoLevel.fnt"), Gdx.files.local("fonts/generated/KOREA/playerSelecionadoLevel.png"),false));

        } else {

            System.out.println("bruxa do 71");
            font.fontCache = false;
            font.pixPackersDefault.put("font", this.font(font.glyps, manager, FONT, "DEFAULT"));
            font.pixPackersDefault.put("error", this.fontError(font.glyps, manager, FONT, "DEFAULT"));
            font.pixPackersDefault.put("success", this.fontSuccess(font.glyps, manager, FONT, "DEFAULT"));
            font.pixPackersDefault.put("title", this.fontTitle(font.glyps, manager, FONT, "DEFAULT"));
            font.pixPackersDefault.put("topLevel", this.fontTopLevel(font.glyps, manager, FONT, "DEFAULT"));
            font.pixPackersDefault.put("topLevelNumber", this.fontTopLevelNumber(font.glyps, manager, FONT, "DEFAULT"));
            font.pixPackersDefault.put("playerSelecionadoLevel", this.fontPlayerSelecionadoLevel(font.glyps, manager, FONT, "DEFAULT"));

            font.pixPackersJapan.put("font", this.font(font.glypsJapan, manager, FONT, "JAPAN"));
            font.pixPackersJapan.put("error", this.fontError(font.glypsJapan, manager, FONT, "JAPAN"));
            font.pixPackersJapan.put("success", this.fontSuccess(font.glypsJapan, manager, FONT, "JAPAN"));
            font.pixPackersJapan.put("title", this.fontTitle(font.glypsJapan, manager, FONT, "JAPAN"));
            font.pixPackersJapan.put("topLevel", this.fontTopLevel(font.glypsJapan, manager, FONT, "JAPAN"));
            font.pixPackersJapan.put("topLevelNumber", this.fontTopLevelNumber(font.glypsJapan, manager, FONT, "JAPAN"));
            font.pixPackersJapan.put("playerSelecionadoLevel", this.fontPlayerSelecionadoLevel(font.glypsJapan, manager, FONT, "JAPAN"));

            font.pixPackersKorea.put("font", this.font(font.glypsKorea, manager, FONT, "KOREA"));
            font.pixPackersKorea.put("error", this.fontError(font.glypsKorea, manager, FONT, "KOREA"));
            font.pixPackersKorea.put("success", this.fontSuccess(font.glypsKorea, manager, FONT, "KOREA"));
            font.pixPackersKorea.put("title", this.fontTitle(font.glypsKorea, manager, FONT, "KOREA"));
            font.pixPackersKorea.put("topLevel", this.fontTopLevel(font.glypsKorea, manager, FONT, "KOREA"));
            font.pixPackersKorea.put("topLevelNumber", this.fontTopLevelNumber(font.glypsKorea, manager, FONT, "KOREA"));
            font.pixPackersKorea.put("playerSelecionadoLevel", this.fontPlayerSelecionadoLevel(font.glypsKorea, manager, FONT, "KOREA"));
        }*/




        /*
            this.font(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
            this.fontError(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
            this.fontSuccess(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
            this.fontTitle(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
            this.fontTopLevel(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
            this.fontTopLevelNumber(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
            this.fontPlayerSelecionadoLevel(font.DEFAULT_GLYPHS, manager, fontDEFAULT);
        */



        /*
            this.font(font.glypsKorea, manager, FONT, "KOREA");
            this.fontError(font.glypsKorea, manager, FONT, "KOREA");
            this.fontSuccess(font.glypsKorea, manager, FONT, "KOREA");
            this.fontTitle(font.glypsKorea, manager, FONT, "KOREA");
            this.fontTopLevel(font.glypsKorea, manager, FONT, "KOREA");
            this.fontTopLevelNumber(font.glypsKorea, manager, FONT, "KOREA");
            this.fontPlayerSelecionadoLevel(font.glypsKorea, manager, FONT, "KOREA");

            this.font(font.glypsChina, manager, FONT, "CHINA");
            this.fontError(font.glypsChina, manager, FONT, "CHINA");
            this.fontSuccess(font.glypsChina, manager, FONT, "CHINA");
            this.fontTitle(font.glypsChina, manager, FONT, "CHINA");
            this.fontTopLevel(font.glypsChina, manager, FONT, "CHINA");
            this.fontTopLevelNumber(font.glypsChina, manager, FONT, "CHINA");
            this.fontPlayerSelecionadoLevel(font.glypsChina, manager, FONT, "CHINA");

            this.font(font.glypsArabia, manager, fontARABIA);
            this.fontError(font.glypsArabia, manager, fontARABIA);
            this.fontSuccess(font.glypsArabia, manager, fontARABIA);
            this.fontTitle(font.glypsArabia, manager, fontARABIA);
            this.fontTopLevel(font.glypsArabia, manager, fontARABIA);
            this.fontTopLevelNumber(font.glypsArabia, manager, fontARABIA);
            this.fontPlayerSelecionadoLevel(font.glypsArabia, manager, fontARABIA);
        */

    }

    public void getFonts(){

        if (font.fontCache == false) {

            manager.finishLoading();

            //SmartFontGenerator fontGen = new SmartFontGenerator();
            //fontGen.setForceGeneration(true);
            //fontGen.setGeneratedFontDir("assets/fonts/generated-fonts/");
            //FileHandle exFile = Gdx.files.local("assets/fonts/font.ttf");

        /*
            font.fontDefault.put("font", fontGen.createFont(exFile, "font", (int)(35 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glyps));
            font.fontDefault.put("error", fontGen.createFont(exFile, "error", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.RED, font.glyps));
            font.fontDefault.put("success", fontGen.createFont(exFile, "success", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glyps));
            font.fontDefault.put("title", fontGen.createFont(exFile, "title", (int)(40 * Gdx.graphics.getDensity()), (int)(40 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glyps));
            font.fontDefault.put("topLevel", fontGen.createFont(exFile, "topLevel", (int)(20 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glyps));
            font.fontDefault.put("topLevelNumber", fontGen.createFont(exFile, "topLevelNumber", (int)(15 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glyps));
            font.fontDefault.put("playerSelecionadoLevel", fontGen.createFont(exFile, "playerSelecionadoLevel", (int)(30 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glyps));



            font.fontJapan.put("font", fontGen.createFont(exFile, "fontJapan", (int)(35 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glypsJapan));
            font.fontJapan.put("error", fontGen.createFont(exFile, "errorJapan", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.RED, font.glypsJapan));
            font.fontJapan.put("success", fontGen.createFont(exFile, "successJapan", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glypsJapan));
            font.fontJapan.put("title", fontGen.createFont(exFile, "titleJapan", (int)(40 * Gdx.graphics.getDensity()), (int)(40 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glypsJapan));
            font.fontJapan.put("topLevel", fontGen.createFont(exFile, "topLevelJapan", (int)(20 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glypsJapan));
            font.fontJapan.put("topLevelNumber", fontGen.createFont(exFile, "topLevelNumberJapan", (int)(15 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glypsJapan));
            font.fontJapan.put("playerSelecionadoLevel", fontGen.createFont(exFile, "playerSelecionadoLevelJapan", (int)(30 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glypsJapan));

         */
        /*
            font.fontKorea.put("font", fontGen.createFont(exFile, "fontKorea", (int)(35 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glypsKorea));
            font.fontKorea.put("error", fontGen.createFont(exFile, "errorKorea", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.RED, font.glypsKorea));
            font.fontKorea.put("success", fontGen.createFont(exFile, "successKorea", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glypsKorea));
            font.fontKorea.put("title", fontGen.createFont(exFile, "titleKorea", (int)(40 * Gdx.graphics.getDensity()), (int)(40 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glypsKorea));
            font.fontKorea.put("topLevel", fontGen.createFont(exFile, "topLevelKorea", (int)(20 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glypsKorea));
            font.fontKorea.put("topLevelNumber", fontGen.createFont(exFile, "topLevelNumberKorea", (int)(15 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glypsKorea));
            font.fontKorea.put("playerSelecionadoLevel", fontGen.createFont(exFile, "playerSelecionadoLevelKorea", (int)(30 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glypsKorea));

            font.fontChina.put("font", fontGen.createFont(exFile, "fontChina", (int)(35 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glypsChina));
            font.fontChina.put("error", fontGen.createFont(exFile, "errorChina", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.RED, font.glypsChina));
            font.fontChina.put("success", fontGen.createFont(exFile, "successChina", (int)(25 * Gdx.graphics.getDensity()), (int)(25 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glypsChina));
            font.fontChina.put("title", fontGen.createFont(exFile, "titleChina", (int)(40 * Gdx.graphics.getDensity()), (int)(40 * Gdx.graphics.getDensity() * 0.03), Color.GREEN, font.glypsChina));
            font.fontChina.put("topLevel", fontGen.createFont(exFile, "topLevelChina", (int)(20 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glypsChina));
            font.fontChina.put("topLevelNumber", fontGen.createFont(exFile, "topLevelNumberChina", (int)(15 * Gdx.graphics.getDensity()), (int)(0 * Gdx.graphics.getDensity() * 0.03), Color.BLACK, font.glypsChina));
            font.fontChina.put("playerSelecionadoLevel", fontGen.createFont(exFile, "playerSelecionadoLevelChina", (int)(30 * Gdx.graphics.getDensity()), (int)(35 * Gdx.graphics.getDensity() * 0.03), Color.WHITE, font.glypsChina));
        */

            font.fontDefault.put("font", manager.get("fonts/fontDEFAULT.ttf", BitmapFont.class));
            font.fontDefault.put("error", manager.get("fonts/fontDEFAULTerror.ttf", BitmapFont.class));
            font.fontDefault.put("success", manager.get("fonts/fontDEFAULTsuccess.ttf", BitmapFont.class));
            font.fontDefault.put("title", manager.get("fonts/fontDEFAULTtitle.ttf", BitmapFont.class));
            font.fontDefault.put("topLevel", manager.get("fonts/fontDEFAULTtopLevel.ttf", BitmapFont.class));
            font.fontDefault.put("topLevelNumber", manager.get("fonts/fontDEFAULTtopLevelNumber.ttf", BitmapFont.class));
            font.fontDefault.put("playerSelecionadoLevel", manager.get("fonts/fontDEFAULTplayerSelecionadoLevel.ttf", BitmapFont.class));

            font.fontJapan.put("font", manager.get("fonts/fontJAPAN.ttf", BitmapFont.class));
            font.fontJapan.put("error", manager.get("fonts/fontJAPANerror.ttf", BitmapFont.class));
            font.fontJapan.put("success", manager.get("fonts/fontJAPANsuccess.ttf", BitmapFont.class));
            font.fontJapan.put("title", manager.get("fonts/fontJAPANtitle.ttf", BitmapFont.class));
            font.fontJapan.put("topLevel", manager.get("fonts/fontJAPANtopLevel.ttf", BitmapFont.class));
            font.fontJapan.put("topLevelNumber", manager.get("fonts/fontJAPANtopLevelNumber.ttf", BitmapFont.class));
            font.fontJapan.put("playerSelecionadoLevel", manager.get("fonts/fontJAPANplayerSelecionadoLevel.ttf", BitmapFont.class));

            font.fontKorea.put("font", manager.get("fonts/fontKOREA.ttf", BitmapFont.class));
            font.fontKorea.put("error", manager.get("fonts/fontKOREAerror.ttf", BitmapFont.class));
            font.fontKorea.put("success", manager.get("fonts/fontKOREAsuccess.ttf", BitmapFont.class));
            font.fontKorea.put("title", manager.get("fonts/fontKOREAtitle.ttf", BitmapFont.class));
            font.fontKorea.put("topLevel", manager.get("fonts/fontKOREAtopLevel.ttf", BitmapFont.class));
            font.fontKorea.put("topLevelNumber", manager.get("fonts/fontKOREAtopLevelNumber.ttf", BitmapFont.class));
            font.fontKorea.put("playerSelecionadoLevel", manager.get("fonts/fontKOREAplayerSelecionadoLevel.ttf", BitmapFont.class));


            BitmapFontWriter.FontInfo info = new BitmapFontWriter.FontInfo();
            info.padding = new BitmapFontWriter.Padding(1, 1, 1, 1);
            BitmapFontWriter.writeFont(font.fontDefault.get("font").getData(), new String[]{"fonts/generated/DEFAULT/font.png"}, Gdx.files.local("fonts/generated/DEFAULT/font.fnt"), info, font.pageWidth, font.pageHeight);
            //BitmapFontWriter.writePixmaps(param.packer.getPages(), Gdx.files.absolute("imageDir"), name);
            BitmapFontWriter.writeFont(font.fontDefault.get("error").getData(), new String[]{"fonts/generated/DEFAULT/error.png"}, Gdx.files.local("fonts/generated/DEFAULT/error.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontDefault.get("success").getData(), new String[]{"fonts/generated/DEFAULT/success.png"}, Gdx.files.local("fonts/generated/DEFAULT/success.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontDefault.get("title").getData(), new String[]{"fonts/generated/DEFAULT/title.png"}, Gdx.files.local("fonts/generated/DEFAULT/title.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontDefault.get("topLevel").getData(), new String[]{"fonts/generated/DEFAULT/topLevel.png"}, Gdx.files.local("fonts/generated/DEFAULT/topLevel.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontDefault.get("topLevelNumber").getData(), new String[]{"fonts/generated/DEFAULT/topLevelNumber.png"}, Gdx.files.local("fonts/generated/DEFAULT/topLevelNumber.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontDefault.get("playerSelecionadoLevel").getData(), new String[]{"fonts/generated/DEFAULT/playerSelecionadoLevel.png"}, Gdx.files.local("fonts/generated/DEFAULT/playerSelecionadoLevel.fnt"), info, font.pageWidth, font.pageHeight);

            BitmapFontWriter.writeFont(font.fontJapan.get("font").getData(), new String[]{"fonts/generated/JAPAN/font.png"}, Gdx.files.local("fonts/generated/JAPAN/font.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontJapan.get("error").getData(), new String[]{"fonts/generated/JAPAN/error.png"}, Gdx.files.local("fonts/generated/JAPAN/error.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontJapan.get("success").getData(), new String[]{"fonts/generated/JAPAN/success.png"}, Gdx.files.local("fonts/generated/JAPAN/success.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontJapan.get("title").getData(), new String[]{"fonts/generated/JAPAN/title.png"}, Gdx.files.local("fonts/generated/JAPAN/title.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontJapan.get("topLevel").getData(), new String[]{"fonts/generated/JAPAN/topLevel.png"}, Gdx.files.local("fonts/generated/JAPAN/topLevel.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontJapan.get("topLevelNumber").getData(), new String[]{"fonts/generated/JAPAN/topLevelNumber.png"}, Gdx.files.local("fonts/generated/JAPAN/topLevelNumber.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontJapan.get("playerSelecionadoLevel").getData(), new String[]{"fonts/generated/JAPAN/playerSelecionadoLevel.png"}, Gdx.files.local("fonts/generated/JAPAN/playerSelecionadoLevel.fnt"), info, font.pageWidth, font.pageHeight);

            BitmapFontWriter.writeFont(font.fontKorea.get("font").getData(), new String[]{"fonts/generated/KOREA/font.png"}, Gdx.files.local("fonts/generated/KOREA/font.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontKorea.get("error").getData(), new String[]{"fonts/generated/KOREA/error.png"}, Gdx.files.local("fonts/generated/KOREA/error.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontKorea.get("success").getData(), new String[]{"fonts/generated/KOREA/success.png"}, Gdx.files.local("fonts/generated/KOREA/success.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontKorea.get("title").getData(), new String[]{"fonts/generated/KOREA/title.png"}, Gdx.files.local("fonts/generated/KOREA/title.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontKorea.get("topLevel").getData(), new String[]{"fonts/generated/KOREA/topLevel.png"}, Gdx.files.local("fonts/generated/KOREA/topLevel.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontKorea.get("topLevelNumber").getData(), new String[]{"fonts/generated/KOREA/topLevelNumber.png"}, Gdx.files.local("fonts/generated/KOREA/topLevelNumber.fnt"), info, font.pageWidth, font.pageHeight);
            BitmapFontWriter.writeFont(font.fontKorea.get("playerSelecionadoLevel").getData(), new String[]{"fonts/generated/KOREA/playerSelecionadoLevel.png"}, Gdx.files.local("fonts/generated/KOREA/playerSelecionadoLevel.fnt"), info, font.pageWidth, font.pageHeight);

            //FreetypeFontLoader.FreeTypeFontLoaderParameter param = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            //param.fontParameters.packer = new PixmapPacker(font.pageW, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

            //System.out.println("jonny cash " + font.teste.getPages());

            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("font").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "font");
            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("error").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "error");
            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("success").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "success");
            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("title").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "title");
            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("topLevel").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "topLevel");
            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("topLevelNumber").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "topLevelNumber");
            BitmapFontWriter.writePixmaps(font.pixPackersDefault.get("playerSelecionadoLevel").getPages(), Gdx.files.local("fonts/generated/DEFAULT/"), "playerSelecionadoLevel");

            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("font").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "font");
            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("error").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "error");
            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("success").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "success");
            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("title").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "title");
            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("topLevel").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "topLevel");
            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("topLevelNumber").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "topLevelNumber");
            BitmapFontWriter.writePixmaps(font.pixPackersJapan.get("playerSelecionadoLevel").getPages(), Gdx.files.local("fonts/generated/JAPAN/"), "playerSelecionadoLevel");

            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("font").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "font");
            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("error").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "error");
            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("success").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "success");
            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("title").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "title");
            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("topLevel").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "topLevel");
            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("topLevelNumber").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "topLevelNumber");
            BitmapFontWriter.writePixmaps(font.pixPackersKorea.get("playerSelecionadoLevel").getPages(), Gdx.files.local("fonts/generated/KOREA/"), "playerSelecionadoLevel");


            System.out.println("chumm lee");
        }

        font.fontDefaultCache.put("font", font.fontDefault.get("font").newFontCache());
        font.fontDefaultCache.put("error", font.fontDefault.get("error").newFontCache());
        font.fontDefaultCache.put("success", font.fontDefault.get("success").newFontCache());
        font.fontDefaultCache.put("title", font.fontDefault.get("title").newFontCache());
        font.fontDefaultCache.put("topLevel", font.fontDefault.get("topLevel").newFontCache());
        font.fontDefaultCache.put("topLevelNumber", font.fontDefault.get("topLevelNumber").newFontCache());
        font.fontDefaultCache.put("playerSelecionadoLevel", font.fontDefault.get("playerSelecionadoLevel").newFontCache());

        font.fontJapanCache.put("font", font.fontJapan.get("font").newFontCache());
        font.fontJapanCache.put("error", font.fontJapan.get("error").newFontCache());
        font.fontJapanCache.put("success", font.fontJapan.get("success").newFontCache());
        font.fontJapanCache.put("title", font.fontJapan.get("title").newFontCache());
        font.fontJapanCache.put("topLevel", font.fontJapan.get("topLevel").newFontCache());
        font.fontJapanCache.put("topLevelNumber", font.fontJapan.get("topLevelNumber").newFontCache());
        font.fontJapanCache.put("playerSelecionadoLevel", font.fontJapan.get("playerSelecionadoLevel").newFontCache());


        /*
        font.fontKorea.put("font", manager.get("fonts/fontKOREA.ttf", BitmapFont.class));
        font.fontKorea.put("error", manager.get("fonts/fontKOREAerror.ttf", BitmapFont.class));
        font.fontKorea.put("success", manager.get("fonts/fontKOREAsuccess.ttf", BitmapFont.class));
        font.fontKorea.put("title", manager.get("fonts/fontKOREAtitle.ttf", BitmapFont.class));
        font.fontKorea.put("topLevel", manager.get("fonts/fontKOREAtopLevel.ttf", BitmapFont.class));
        font.fontKorea.put("topLevelNumber", manager.get("fonts/fontKOREAtopLevelNumber.ttf", BitmapFont.class));
        font.fontKorea.put("playerSelecionadoLevel", manager.get("fonts/fontKOREAplayerSelecionadoLevel.ttf", BitmapFont.class));
         */

        font.fontKoreaCache.put("font", font.fontKorea.get("font").newFontCache());
        font.fontKoreaCache.put("error", font.fontKorea.get("error").newFontCache());
        font.fontKoreaCache.put("success", font.fontKorea.get("success").newFontCache());
        font.fontKoreaCache.put("title", font.fontKorea.get("title").newFontCache());
        font.fontKoreaCache.put("topLevel", font.fontKorea.get("topLevel").newFontCache());
        font.fontKoreaCache.put("topLevelNumber", font.fontKorea.get("topLevelNumber").newFontCache());
        font.fontKoreaCache.put("playerSelecionadoLevel", font.fontKorea.get("playerSelecionadoLevel").newFontCache());

        /*
        font.fontChina.put("font", manager.get("fonts/fontCHINA.ttf", BitmapFont.class));
        font.fontChina.put("error", manager.get("fonts/fontCHINAerror.ttf", BitmapFont.class));
        font.fontChina.put("success", manager.get("fonts/fontCHINAsuccess.ttf", BitmapFont.class));
        font.fontChina.put("title", manager.get("fonts/fontCHINAtitle.ttf", BitmapFont.class));
        font.fontChina.put("topLevel", manager.get("fonts/fontCHINAtopLevel.ttf", BitmapFont.class));
        font.fontChina.put("topLevelNumber", manager.get("fonts/fontCHINAtopLevelNumber.ttf", BitmapFont.class));
        font.fontChina.put("playerSelecionadoLevel", manager.get("fonts/fontCHINAplayerSelecionadoLevel.ttf", BitmapFont.class));

        font.fontChinaCache.put("font", font.fontChina.get("font").newFontCache());
        font.fontChinaCache.put("error", font.fontChina.get("error").newFontCache());
        font.fontChinaCache.put("success", font.fontChina.get("success").newFontCache());
        font.fontChinaCache.put("title", font.fontChina.get("title").newFontCache());
        font.fontChinaCache.put("topLevel", font.fontChina.get("topLevel").newFontCache());
        font.fontChinaCache.put("topLevelNumber", font.fontChina.get("topLevelNumber").newFontCache());
        font.fontChinaCache.put("playerSelecionadoLevel", font.fontChina.get("playerSelecionadoLevel").newFontCache());

        BitmapFontCache oi = font.fontChinaCache.get("");*/

        /*
        font.fontDEFAULT = manager.get("fonts/fontDEFAULT.ttf", BitmapFont.class);
        font.fontErrorDEFAULT = manager.get("fonts/fontDEFAULTerror.ttf", BitmapFont.class);
        font.fontSuccessDEFAULT = manager.get("fonts/fontDEFAULTsuccess.ttf", BitmapFont.class);
        font.fontTitleDEFAULT = manager.get("fonts/fontDEFAULTtitle.ttf", BitmapFont.class);
        font.fontTopLevelDEFAULT = manager.get("fonts/fontDEFAULTtopLevel.ttf", BitmapFont.class);
        font.fontTopLevelNumberDEFAULT = manager.get("fonts/fontDEFAULTtopLevelNumber.ttf", BitmapFont.class);
        font.fontPlayerSelecionadoLevelDEFAULT = manager.get("fonts/fontDEFAULTplayerSelecionadoLevel.ttf", BitmapFont.class);

        font.fontDEFAULTcache =  font.fontDEFAULT.newFontCache();
        font.fontErrorDEFAULTcache = font.fontErrorDEFAULT.newFontCache();
        font.fontSuccessDEFAULTcache = font.fontSuccessDEFAULT.newFontCache();
        font.fontTitleDEFAULTcache = font.fontTitleDEFAULT.newFontCache();
        font.fontTopLevelDEFAULTcache = font.fontTopLevelDEFAULT.newFontCache();
        font.fontTopLevelNumberDEFAULTcache =  font.fontTopLevelNumberDEFAULT.newFontCache();
        font.fontPlayerSelecionadoLevelDEFAULTcache = font.fontPlayerSelecionadoLevelDEFAULT.newFontCache();

        /*
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
        font.fontPlayerSelecionadoLevelCHINA = manager.get("fonts/china/fontCHINAplayerSelecionadoLevel.ttf", BitmapFont.class);*/

        //font.glyps = "";
        //font.glypsJapan = "";
        //font.glypsKorea = "";
        //font.glypsChina = "";

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
