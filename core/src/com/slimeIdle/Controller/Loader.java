package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Animate;
import com.slimeIdle.Model.BitmapFontWriter;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Flags;
import com.slimeIdle.Model.Font;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;
import com.slimeIdle.Model.Window;
import com.slimeIdle.View.Render;

import java.awt.TexturePaint;
import java.util.ArrayList;
import java.util.Map;

public class Loader {

    public AssetManager manager = new AssetManager();
    FileHandleResolver resolver = new InternalFileHandleResolver();

    Buttons btn;
    Render render;
    Account acc;
    Window window;
    Slime slime;
    Coin coin;
    TopLevel topLevel;
    Menu menu;
    Shop shop;
    Font font;
    Flags flags;


    public Loader(
            Buttons btn,
            Render render,
            Account acc,
            Window window,
            Slime slime,
            Coin coin,
            TopLevel topLevel,
            Menu menu,
            Shop shop,
            Font font,
            Flags flags){

        this.btn = btn;
        this.render = render;
        this.acc = acc;
        this.window = window;
        this.slime = slime;
        this.coin = coin;
        this.topLevel = topLevel;
        this.menu = menu;
        this.shop = shop;
        this.font = font;
        this.flags = flags;
    }

    private void loadSlimeTextures() {

        slime.slimesTexture = new Texture("textures/slimes.png");

        //ArrayMap<String ,TextureRegion> slime = new ArrayMap<String, TextureRegion>();

        // first line
        slime.slimes.put("default", new TextureRegion(slime.slimesTexture, 0,0,128,128));
        //shop.slimeColorsShopTextures.add(0, slime.slimes.get("green"));
        slime.slimes.put("defaultEquipped", new TextureRegion(slime.slimesTexture,128,0,128,128));

        slime.slimes.put("green", new TextureRegion(slime.slimesTexture, 0,256,128,128));
        shop.slimeColorsShopTextures.add(0, slime.slimes.get("green"));
        slime.slimes.put("greenEquipped", new TextureRegion(slime.slimesTexture,128,256,128,128));

        slime.slimes.put("blue", new TextureRegion(slime.slimesTexture,256,0,128,128));
        shop.slimeColorsShopTextures.add(1, slime.slimes.get("blue"));
        slime.slimes.put("blueEquipped", new TextureRegion(slime.slimesTexture,384,0,128,128));

        slime.slimes.put("yellow", new TextureRegion(slime.slimesTexture,512,0,128,128));
        shop.slimeColorsShopTextures.add(2, slime.slimes.get("yellow"));
        slime.slimes.put("yellowEquipped", new TextureRegion(slime.slimesTexture,640,0,128,128));

        slime.slimes.put("red", new TextureRegion(slime.slimesTexture,768,0,128,128));
        shop.slimeColorsShopTextures.add(3, slime.slimes.get("red"));
        slime.slimes.put("redEquipped", new TextureRegion(slime.slimesTexture,896,0,128,128));
        //second line
        slime.slimes.put("pink", new TextureRegion(slime.slimesTexture,0,128,128,128));
        shop.slimeColorsShopTextures.add(4, slime.slimes.get("pink"));
        slime.slimes.put("pinkEquipped", new TextureRegion(slime.slimesTexture,128,128,128,128));

        slime.slimes.put("purple", new TextureRegion(slime.slimesTexture,256,128,128,128));
        shop.slimeColorsShopTextures.add(5, slime.slimes.get("purple"));
        slime.slimes.put("purpleEquipped", new TextureRegion(slime.slimesTexture,384,128,128,128));

        slime.slimes.put("lightBlue", new TextureRegion(slime.slimesTexture,512,128,128,128));
        shop.slimeColorsShopTextures.add(6, slime.slimes.get("lightBlue"));
        slime.slimes.put("lightBlueEquipped", new TextureRegion(slime.slimesTexture,640,128,128,128));

        slime.slimes.put("orange", new TextureRegion(slime.slimesTexture,768,128,128,128));
        shop.slimeColorsShopTextures.add(7, slime.slimes.get("orange"));
        slime.slimes.put("orangeEquipped", new TextureRegion(slime.slimesTexture,896,128,128,128));

        slime.slimes.put("black", new TextureRegion(slime.slimesTexture,256,256,128,128));
        shop.slimeColorsShopTextures.add(8, slime.slimes.get("black"));
        slime.slimes.put("blackEquipped", new TextureRegion(slime.slimesTexture,384,256,128,128));

        slime.slimes.put("white", new TextureRegion(slime.slimesTexture,512,256,128,128));
        shop.slimeColorsShopTextures.add(9, slime.slimes.get("white"));
        slime.slimes.put("whiteEquipped", new TextureRegion(slime.slimesTexture,640,256,128,128));

        slime.slimeFacesTexture = new Texture("textures/faces.png");
        slime.slimeFaces.put("default", new TextureRegion(slime.slimeFacesTexture, 0,0,128,128));

        this.texturePosition(slime.slimePosition,0.25f,0.4f,0.5f,0.3f);
        slime.sleep = new Texture("textures/sleep.png");
        slime.sleepAnimation = new Animation<TextureRegion>(0.3f, Animate.framesAnimation(slime.sleep, 2, 3));

        slime.slimeBackgroundsTexture = new Texture("textures/bgs.png");
        slime.slimeBackgrounds.put("field", new TextureRegion(slime.slimeBackgroundsTexture,0,0,512,512));
        slime.slimeBackgrounds.put("wood", new TextureRegion(slime.slimeBackgroundsTexture,512,0,512,512));
        slime.slimeBackgrounds.put("city", new TextureRegion(slime.slimeBackgroundsTexture,0,512,512,512));
        slime.slimeBackgrounds.put("vulcan", new TextureRegion(slime.slimeBackgroundsTexture,512,512,512,512));

    }

    private void loadTextures(){

        loadSlimeTextures();

        btn.buttons = new Texture("textures/buttonsAndWindow.png");

        //login face
        btn.buttonLoginFace = new TextureRegion(btn.buttons,0, 256,640,128);

        //principal
        window.reconnectWindow = new TextureRegion(btn.buttons, 0,384,512,512);
        menu.background_menu = new TextureRegion(btn.buttons, 512,384,512,512);
        window.window = new TextureRegion(btn.buttons, 512,384,512,512);
        this.texturePosition(window.windowPosition,0.15f,0.1f,0.7f,0.3f);
        this.texturePosition(window.reconnectWindowPosition, 0.1f,0.1f, 0.8f, 0.7f);


        btn.buttonCart = new TextureRegion(btn.buttons,0,0,128,128);
        btn.buttonCoin = new TextureRegion(btn.buttons,128,0,128,128);
        btn.buttonTopLevel = new TextureRegion(btn.buttons,256,0,128,128);


        //menu
        btn.buttonCloseWindow = new TextureRegion(btn.buttons, 384,0,128,128);
        btn.buttonMenu = new TextureRegion(btn.buttons, 0,128,640,128);

        btn.buttonBattle = new TextureRegion(btn.buttons,512,0,128,128);
        btn.buttonPrev = new TextureRegion(btn.buttons,640,0,128,128);
        btn.buttonNext = new TextureRegion(btn.buttons, 768,0,128,128);
        btn.buttonBuy = new TextureRegion(btn.buttons,896,0,128,128);
        btn.buttonEquip = new TextureRegion(btn.buttons, 640,128,128,128);
        btn.buttonUnequip = new TextureRegion(btn.buttons,768,128,128,128);

        btn.buttonSlimeColor = new TextureRegion(btn.buttons, 896, 128,128,128);
        btn.buttonBackground = new TextureRegion(btn.buttons, 640, 256, 128,128);
        btn.buttonLanguage = new TextureRegion(btn.buttons, 768, 256,128,128);

        int i = 0;
        flags.flags.add(i, new TextureRegion(btn.buttons, 0, 896, 128,128));
        flags.flags.add(++i, new TextureRegion(btn.buttons, 128, 896, 128,128));
        flags.flags.add(++i, new TextureRegion(btn.buttons, 256, 896, 128,128));
        flags.flags.add(++i, new TextureRegion(btn.buttons, 384, 896, 128,128));
        flags.flags.add(++i, new TextureRegion(btn.buttons, 512, 896, 128,128));
        flags.flags.add(++i, new TextureRegion(btn.buttons, 640, 896, 128,128));
        flags.flags.add(++i, new TextureRegion(btn.buttons, 768, 896, 128,128));

        //loja cart
        shop.noItemsTexture = new Texture("shop/textures/no_items.png");
        shop.holidayItemsTexture = new Texture("shop/textures/holiday_items.png");
        shop.commonItemsTexture = new Texture("shop/textures/common_items.png");

        i = 0;

        shop.itemsShopTextures.add(i, new TextureRegion(shop.noItemsTexture, 0,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.noItemsTexture, 128,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.noItemsTexture, 256,0,128,128));

        //shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 0,0,128,128));
        //shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 128,0,128,128));
        //shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 256,0,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 0,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 128,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 256,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 384,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 512,0,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 640,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 768,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 896,0,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 0,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 128,128,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 256,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 384,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 512,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 640,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 768,128,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 896,128,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 0,256,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 128,256,128,128));
        shop.itemsShopTextures.add(++i, new TextureRegion(shop.commonItemsTexture, 256,256,128,128));

        shop.itemsShopTextures.add(++i, new TextureRegion(shop.holidayItemsTexture, 0,0,128,128));
    }

    private void texturePosition (ArrayMap<String,Float> props, float x,float y, float width, float height) {

        props.put("x", Static.cam.viewportWidth * x);
        props.put("y", Static.cam.viewportHeight * y);
        props.put("width", Static.cam.viewportWidth * width);
        props.put("height", Static.cam.viewportHeight * height);
    }

    private Rectangle loadButton (ArrayMap<String,Float> props, float x,float y, float width, float height) {

        this.texturePosition(props,x,y,width,height);
       return new Rectangle(props.get("x"),props.get("y"),props.get("width"),props.get("height"));
    }

    private void loadButtons() {

        btn.buttonCloseCollision = this.loadButton(btn.buttonCloseWindowProps,0.8f,0.9f,0.16f,0.08f);
        btn.buttonLanguageCollision = this.loadButton(btn.buttonLanguageProps, 0.8f, 0.8f, 0.16f, 0.08f);
        btn.buttonBackgroundCollision = this.loadButton(btn.buttonBackgroundProps, 0.8f, 0.7f, 0.16f, 0.08f);
        btn.buttonSlimeColorCollision = this.loadButton(btn.buttonSlimeColorProps, 0.8f, 0.6f, 0.16f, 0.08f);

        btn.buttonCartCollision = this.loadButton(btn.buttonCartProps,0.80f,0.2f,0.16f,0.08f);
        btn.buttonCoinCollision = this.loadButton(btn.buttonCoinProps,0.42f,0.2f,0.16f,0.08f);
        btn.buttonTopLevelCollision = this.loadButton(btn.buttonTopLevelProps,0.050f,0.2f,0.16f,0.08f);

        btn.buttonMenuProps.add(0, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(1, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(2, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(3, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(4, new ArrayMap<String, Float>());

        btn.buttonMenuCollision.add(0, this.loadButton(btn.buttonMenuProps.get(0),0.2f,0.75f,0.6f,0.08f));
        btn.buttonMenuCollision.add(1, this.loadButton(btn.buttonMenuProps.get(1),0.2f,0.6f,0.6f,0.08f));
        btn.buttonMenuCollision.add(2, this.loadButton(btn.buttonMenuProps.get(2),0.2f,0.45f,0.6f,0.08f));
        btn.buttonMenuCollision.add(3, this.loadButton(btn.buttonMenuProps.get(3),0.2f,0.3f,0.6f,0.08f));
        btn.buttonMenuCollision.add(4, this.loadButton(btn.buttonMenuProps.get(4),0.2f,0.15f,0.6f,0.08f));

        btn.buttonLoginFaceCollision = this.loadButton(btn.buttonLoginFaceProps,0.2f,0.3f,0.6f,0.08f);
        btn.buttonPrevCollision = this.loadButton(btn.buttonPrevProps,0.050f,0.03f,0.16f,0.08f);
        btn.buttonNextCollision = this.loadButton(btn.buttonNextProps,0.80f,0.03f,0.16f,0.08f);
        btn.buttonEquipCollision = this.loadButton(btn.buttonEquipProps,0.80f,0.03f,0.16f,0.08f);
        btn.buttonUnequipCollision = this.loadButton(btn.buttonUnequipProps,0.80f,0.03f,0.16f,0.08f);
        btn.buttonBuyCollision = this.loadButton(btn.buttonBuyProps,0.80f,0.03f,0.16f,0.08f);

    }

    private PixmapPacker font(String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.borderWidth = (int)(25 * Gdx.graphics.getDensity() * 0.03);
        parameter.fontParameters.size = (int)(25 * Gdx.graphics.getDensity());
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
        //parameter.fontParameters.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        //parameter.fontParameters.color = Color.BLACK;
        parameter.fontParameters.size = (int)(20 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"topLevel.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private PixmapPacker fontTopLevelNumber (String GLYPHS, AssetManager manager, String fileName, String newFontName) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        //parameter.fontParameters.borderWidth = (int)(0 * Gdx.graphics.getDensity() * 0.03);
        //parameter.fontParameters.color = Color.BLACK;
        parameter.fontParameters.size = (int)(15 * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName+newFontName+"topLevelNumber.ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private BitmapFont getBitmapFont(FileHandle fileFnt, String pathPng) {

        FileHandle filePng = Gdx.files.local(pathPng+".png");
        BitmapFont.BitmapFontData fontData = new BitmapFont.BitmapFontData(fileFnt, false);
        Array <TextureRegion> textureRegion = new Array <TextureRegion>();

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

        return new BitmapFont(fontData, textureRegion,false);
    }

    /*private void getBitmapFont2(FileHandle fileFnt, String pathPng, String fontPath, AssetManager manager) {

        FileHandle filePng = Gdx.files.local(pathPng+".png");
        //BitmapFont.BitmapFontData fontData = new BitmapFont.BitmapFontData(fileFnt, false);
       // Array <TextureRegion> textureRegion = new Array <TextureRegion>();



        BitmapFontLoader.BitmapFontParameter bp = new BitmapFontLoader.BitmapFontParameter();
        bp.bitmapFontData = new BitmapFont.BitmapFontData();
        //bp.bitmapFontData.load(fileFnt,false);
        bp.bitmapFontData.fontFile = fileFnt;

        TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();

        if(filePng.exists()) {

            //FileHandle file = Gdx.files.local("fonts/generated/DEFAULT/font.png");
            //textureRegion.add(new TextureRegion(new Texture(filePng)));
            //ArrayList oi = new ArrayList<String>();
            //oi.add(filePng);
            String[] peniss = {pathPng+".png"};
            bp.bitmapFontData.imagePaths = peniss;
            //TextureLoader cuh = new TextureLoader(resolver);
            //cuh.
            //AssetLoaderParameters<Texture> ook = new AssetLoaderParameters<Texture>();
            //ook
            //TextureLoader oko = new TextureLoader(resolver);

            textureParameter.texture = new Texture(filePng);
            manager.load(peniss[0], Texture.class, textureParameter);

        } else /*if (Gdx.files.local("fonts/generated/DEFAULT/font_0.png").exists())*/
    /*{

            int i = 0;

            while (Gdx.files.local(pathPng+"_"+i+".png").exists()) {
                i++;
            }

            String[] penis = new String[i];

            //while (Gdx.files.local("fonts/generated/DEFAULT/font_"+i+".png").exists()) {
            for (int i2 = 0; i2 < i; i2++) {

                FileHandle file = Gdx.files.local(pathPng+"_"+i2+".png");
                penis[i2] = pathPng+"_"+i2+".png";
                //manager.load(penis[i2], Texture.class);
                textureParameter.texture = new Texture(file);
                manager.load(penis[i2], Texture.class, textureParameter);
                System.out.println("path: " + file.toString());
            }
            //bp.bitmapFontData.load(penis[0]);
            bp.bitmapFontData.imagePaths = penis;

        }

        //BitmapFontLoader bitmapFontLoader = new BitmapFontLoader(resolver);
        //System.out.println("renascenco " + bp.bitmapFontData.getImagePaths());
        //bitmapFontLoader.loadSync(manager, "fonts/font"+fontPath+".ttf", fileFnt, bp);



        manager.load("fonts/font"+fontPath+".ttf", BitmapFont.class, bp);

        //return bp;

        //kk.loadSync(manager, "fonts/font"+fontPath+".ttf", fileFnt, bp);

        //return new BitmapFont(fontData, textureRegion,false);
    }*/

    private boolean getOrGenerateFont (String FONT, String fontPath, String fontName, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers, String glyps, int fontType) {

        FileHandle fileFnt = Gdx.files.local("fonts/generated/"+fontPath+"/"+fontName+".fnt");

        if(fileFnt.exists()) {

            fontMap.put(fontName, this.getBitmapFont(fileFnt,"fonts/generated/"+fontPath+"/"+fontName));

            return true;

        } else {

            //manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
            //manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

            //System.out.println("xau" + fontPath + fontName);

            PixmapPacker pix = null;
            switch (fontType){
                case 0:
                    pix = this.font(glyps, manager, FONT, fontPath);
                    break;
                case 1:
                    //pix = this.fontError(glypsLatin, manager, FONT, fontPath);
                    //pix = this.fontMessage(glyps, manager, FONT, fontPath);
                    break;
                case 2:
                    //pix = this.fontSuccess(glypsLatin, manager, FONT, fontPath);
                    break;
                case 3:
                    //pix = this.fontTitle(glypsLatin, manager, FONT, fontPath);
                    break;
                case 4:
                    pix = this.fontTopLevel(glyps, manager, FONT, fontPath);
                    break;
                case 5:
                    pix = this.fontTopLevelNumber(glyps, manager, FONT, fontPath);
                    break;
                case 6:
                    //pix = this.fontPlayerSelecionadoLevel(glypsLatin, manager, FONT, fontPath);
                    break;
            }

            pixPackers.put(fontName, pix);
            //return false;
        }

        return false;
    }

    private void getOrGenerateAllFonts (int languageCode,String fontPath, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers, String glyps) {

        String FONT = "fonts/font";

        boolean fontLoaded, messageLoaded, topLevelLoaded, topLevelNumberLoaded;

        fontLoaded = this.getOrGenerateFont(FONT, fontPath, "font", fontMap, pixPackers, glyps, 0);
        //messageLoaded = this.getOrGenerateFont(FONT, fontPath, "message", fontMap, pixPackers, glyps, 1);
        topLevelLoaded = this.getOrGenerateFont(FONT, fontPath, "topLevel", fontMap, pixPackers, glyps, 4);
        topLevelNumberLoaded = this.getOrGenerateFont(FONT, fontPath, "topLevelNumber", fontMap, pixPackers, glyps, 5);

        if (fontLoaded && topLevelLoaded && topLevelNumberLoaded) {

            font.fontCacheBoolean.put(fontPath,true);
            //if(manager.finishLoadingAsset();)
            //putFonts(fontPath,fontMap);
            //getFonts(languageCode);

        } else {
            font.fontCacheBoolean.put(fontPath,false);
        }
    }

    public void loadFonts() {

        //if(font.loaded) {
            //return;
        //}

        //System.out.println("heart");

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        this.getOrGenerateAllFonts(0,"DEFAULT",font.fontDefault,font.pixPackersDefault,font.glypsLatin);
        this.getOrGenerateAllFonts(1,"RUSSIA",font.fontRussia,font.pixPackersRussia,font.glyphsRussia);
        this.getOrGenerateAllFonts(2,"JAPAN",font.fontJapan,font.pixPackersJapan,font.glypsJapan);
        this.getOrGenerateAllFonts(3,"KOREA",font.fontKorea,font.pixPackersKorea,font.glypsKorea);
        this.getOrGenerateAllFonts(4,"CHINA",font.fontChina,font.pixPackersChina,font.glypsChina);

        //manager.finishLoading();

        //font.loaded = true;

        //System.out.println("chuck meen");
    }

    public boolean flanderson() {

        if(font.loaded) {
            return false;
        }



        if(font.penis) {
            font.penis = false;
            window.drawReconnectWindow();
            Static.batch.draw(window.reconnectWindow,Static.cam.viewportWidth *0.5f,Static.cam.viewportHeight * 0.5f);
            System.out.println("winx");

            for (int i = 0; i < 1000000000; i++) {

            }
            Static.batch.end();
            return true;
        }
/*
        if(font.fontChina.isEmpty()){
            window.drawReconnectWindow();
            Static.batch.end();
            return;
        }*/

        System.out.println("heart");

        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        //this.getOrGenerateAllFonts(0,"DEFAULT",font.fontDefault,font.pixPackersDefault,font.glypsLatin);
        this.getOrGenerateAllFonts(1,"RUSSIA",font.fontRussia,font.pixPackersRussia,font.glyphsRussia);
        this.getOrGenerateAllFonts(2,"JAPAN",font.fontJapan,font.pixPackersJapan,font.glypsJapan);
        this.getOrGenerateAllFonts(3,"KOREA",font.fontKorea,font.pixPackersKorea,font.glypsKorea);
        this.getOrGenerateAllFonts(4,"CHINA",font.fontChina,font.pixPackersChina,font.glypsChina);

        font.loaded = true;

        return false;
        //System.out.println("chuck meen");
    }

    private void writeAllFonts(String fontPath, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers) {

        /*fontMap.put("font", manager.get("fonts/font"+fontPath+".ttf", BitmapFont.class));
        fontMap.put("message", manager.get("fonts/font"+fontPath+"message.ttf", BitmapFont.class));
        fontMap.put("topLevel", manager.get("fonts/font"+fontPath+"topLevel.ttf", BitmapFont.class));
        fontMap.put("topLevelNumber", manager.get("fonts/font"+fontPath+"topLevelNumber.ttf", BitmapFont.class));*/

        //putFonts(fontPath,fontMap);

        BitmapFontWriter.FontInfo info = new BitmapFontWriter.FontInfo();
        info.padding = new BitmapFontWriter.Padding(1, 1, 1, 1);

        BitmapFontWriter.writeFont(fontMap.get("font").getData(), new String[]{"fonts/generated/"+fontPath+"/font.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/font.fnt"), info, font.pageWidth, font.pageHeight);
        //BitmapFontWriter.writeFont(fontMap.get("message").getData(), new String[]{"fonts/generated/"+fontPath+"/message.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/message.fnt"), info, font.pageWidth, font.pageHeight);
        BitmapFontWriter.writeFont(fontMap.get("topLevel").getData(), new String[]{"fonts/generated/"+fontPath+"/topLevel.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/topLevel.fnt"), info, font.pageWidth, font.pageHeight);
        BitmapFontWriter.writeFont(fontMap.get("topLevelNumber").getData(), new String[]{"fonts/generated/"+fontPath+"/topLevelNumber.png"}, Gdx.files.local("fonts/generated/"+fontPath+"/topLevelNumber.fnt"), info, font.pageWidth, font.pageHeight);

        BitmapFontWriter.writePixmaps(pixPackers.get("font").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "font");
        //BitmapFontWriter.writePixmaps(pixPackers.get("message").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "message");
        BitmapFontWriter.writePixmaps(pixPackers.get("topLevel").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "topLevel");
        BitmapFontWriter.writePixmaps(pixPackers.get("topLevelNumber").getPages(), Gdx.files.local("fonts/generated/"+fontPath+"/"), "topLevelNumber");
    }

    private void putFonts (String fontPath, Map<String, BitmapFont> fontMap) {

        int oi = '中';
        System.out.println("janmba 中: " + oi );

        /*manager.finishLoadingAsset("fonts/generated/"+fontPath+"/font.fnt");
        manager.finishLoadingAsset("fonts/generated/"+fontPath+"/message.fnt");
        manager.finishLoadingAsset("fonts/generated/"+fontPath+"/topLevel.fnt");
        manager.finishLoadingAsset("fonts/generated/"+fontPath+"/topLevelNumber.fnt");*/


        manager.finishLoadingAsset("fonts/font"+fontPath+".ttf");
        //manager.finishLoadingAsset("fonts/font"+fontPath+"message.ttf");
        manager.finishLoadingAsset("fonts/font"+fontPath+"topLevel.ttf");
        manager.finishLoadingAsset("fonts/font"+fontPath+"topLevelNumber.ttf");

        System.out.println("fox on the run");

        fontMap.put("font", manager.get("fonts/font"+fontPath+".ttf", BitmapFont.class));
        //fontMap.put("message", manager.get("fonts/font"+fontPath+"message.ttf", BitmapFont.class));
        fontMap.put("topLevel", manager.get("fonts/font"+fontPath+"topLevel.ttf", BitmapFont.class));
        fontMap.put("topLevelNumber", manager.get("fonts/font"+fontPath+"topLevelNumber.ttf", BitmapFont.class));
    }

    public void cacheAllFonts(Map<String, BitmapFontCache> fontCache, Map<String, BitmapFont> fontMap) {

        fontCache.put("font", fontMap.get("font").newFontCache());
        //fontCache.put("message", fontMap.get("message").newFontCache());
        fontCache.put("topLevel", fontMap.get("topLevel").newFontCache());
        fontCache.put("topLevelNumber", fontMap.get("topLevelNumber").newFontCache());
    }

    public void getFonts(int languageCode){

        System.out.println();

        switch (languageCode) {

            // default latin
            case 0:

                if(font.fontDefault.isEmpty()) {

                    //if(manager.getAssetFileName("fonts/fontDEFAULT.ttf") != null) {
                        //manager.finishLoadingAsset("fonts/fontDEFAULT.ttf");
                        //manager.finishLoadingAsset("fonts/fontDEFAULTmessage.ttf");
                        //manager.finishLoadingAsset("fonts/fontDEFAULTtopLevel.ttf");
                        //manager.finishLoadingAsset("fonts/fontDEFAULTtopLevelNumber.ttf");
                    //}

                    //if (manager.getAssetFileName("fonts/generated/DEFAULT/font.fnt") != null) {
                        //manager.finishLoadingAsset("fonts/generated/DEFAULT/font.fnt");
                       // manager.finishLoadingAsset("fonts/generated/DEFAULT/message.fnt");
                        //manager.finishLoadingAsset("fonts/generated/DEFAULT/topLevel.fnt");
                       // manager.finishLoadingAsset("fonts/generated/DEFAULT/topLevelNumber.fnt");
                    //}

                    this.putFonts("DEFAULT", font.fontDefault);

                    System.out.println("english " + manager.getProgress());

                    if (!font.fontCacheBoolean.get("DEFAULT")) {
                        this.writeAllFonts("DEFAULT", font.fontDefault, font.pixPackersDefault);
                    }
                }

                this.cacheAllFonts(font.fontDefaultCache,font.fontDefault);

                break;

            //russia
            case 1:

                if(font.fontRussia.isEmpty()) {

                    //manager.finishLoadingAsset("fonts/fontRUSSIA.ttf");
                    //manager.finishLoadingAsset("fonts/fontRUSSIAmessage.ttf");
                    //manager.finishLoadingAsset("fonts/fontRUSSIAtopLevel.ttf");
                    //manager.finishLoadingAsset("fonts/fontRUSSIAtopLevelNumber.ttf");

                    this.putFonts("RUSSIA", font.fontRussia);

                    System.out.println("russian " + manager.getProgress());

                    if (!font.fontCacheBoolean.get("RUSSIA")) {
                        this.writeAllFonts("RUSSIA", font.fontRussia, font.pixPackersRussia);
                    }
                }

                this.cacheAllFonts(font.fontRussiaCache,font.fontRussia);

                break;

            //japan
            case 2:

                if (font.fontJapan.isEmpty()) {
                    /*
                    manager.finishLoadingAsset("fonts/fontJAPAN.ttf");
                    manager.finishLoadingAsset("fonts/fontJAPANmessage.ttf");
                    manager.finishLoadingAsset("fonts/fontJAPANtopLevel.ttf");
                    manager.finishLoadingAsset("fonts/fontJAPANtopLevelNumber.ttf");*/

                    this.putFonts("JAPAN", font.fontJapan);

                    System.out.println("japan " + manager.getProgress());

                    if (!font.fontCacheBoolean.get("JAPAN")) {
                        this.writeAllFonts("JAPAN", font.fontJapan, font.pixPackersJapan);
                    }
                }

                this.cacheAllFonts(font.fontJapanCache,font.fontJapan);

                break;

            //korea
            case 3:

                if (font.fontKorea.isEmpty()) {

                    /*manager.finishLoadingAsset("fonts/fontKOREA.ttf");
                    manager.finishLoadingAsset("fonts/fontKOREAmessage.ttf");
                    manager.finishLoadingAsset("fonts/fontKOREAtopLevel.ttf");
                    manager.finishLoadingAsset("fonts/fontKOREAtopLevelNumber.ttf");*/

                    this.putFonts("KOREA", font.fontKorea);

                    System.out.println("korea " + manager.getProgress());

                    if (!font.fontCacheBoolean.get("KOREA")) {
                        this.writeAllFonts("KOREA", font.fontKorea, font.pixPackersKorea);
                    }
                }

                this.cacheAllFonts(font.fontKoreaCache,font.fontKorea);

                break;
            //china
            case 4:

                if(font.fontChina.isEmpty()) {

                    /*manager.finishLoadingAsset("fonts/fontCHINA.ttf");
                    manager.finishLoadingAsset("fonts/fontCHINAmessage.ttf");
                    manager.finishLoadingAsset("fonts/fontCHINAtopLevel.ttf");
                    manager.finishLoadingAsset("fonts/fontCHINAtopLevelNumber.ttf");*/

                    this.putFonts("CHINA", font.fontChina);

                    System.out.println("china " + manager.getProgress());

                    if (!font.fontCacheBoolean.get("CHINA")) {
                        this.writeAllFonts("CHINA", font.fontChina, font.pixPackersChina);
                    }
                }

                this.cacheAllFonts(font.fontChinaCache,font.fontChina);

                break;
        }
    }


    private void loadInitializers() {

        // player top level controller
        topLevel.initializer();
        slime.initalizer();
        render.initializer();
        acc.initializer();
        // shop controller
        //shop.initializer();
        font.initializer(this);
    }

    public void loader() {

        btn.touchPoint = new Vector3();

        loadTextures();
        loadButtons();
        loadFonts();
        //getFonts();
        loadInitializers();
    }
}
