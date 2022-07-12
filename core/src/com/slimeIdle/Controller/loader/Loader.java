package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.slimeIdle.Model.Account;
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

    public TextureRegion posicaoTextureCustom (Texture texture, int cellX, int cellY, int multiCellsX, int multiCellsY) {

        int standard = 128;

        int sizeX = multiCellsX * standard;
        int sizeY = multiCellsY * standard;

        return new TextureRegion(texture, cellX * standard,cellY * standard, sizeX, sizeY);
    }

    public TextureRegion posicaoTextureStandard (Texture texture, int cellX, int cellY) {

        int standard = 128;

        return new TextureRegion(texture, cellX * standard,cellY * standard, standard, standard);
    }

    private void loadTextures(){

        SlimeTextures slimeTextures = new SlimeTextures(this, slime, shop);
        slimeTextures.loadSlimeTextures();

        texturePosition(slime.slimePosition,0.25f,0.4f,0.5f,0.3f);

        ButtonsTextures buttonsTextures = new ButtonsTextures(this, btn);
        buttonsTextures.loadBtnsTextures();
        buttonsTextures.loadBtnsCollision();

        FacesTextures facesTextures = new FacesTextures(this, slime);
        facesTextures.loadFacesTextures();

        BackgroundsTextures backgroundsTextures = new BackgroundsTextures(this, slime);
        backgroundsTextures.loadBackgroundsTextures();

        Animations animations = new Animations(slime);
        animations.loadSleepAnimation();

        WindowsTextures windowsTextures = new WindowsTextures(this,window,btn,menu);
        windowsTextures.loadWindowsTextures();

        FlagsTextures flagsTextures = new FlagsTextures(this, flags);
        flagsTextures.loadFlagsTextures();

        ItemsTextures itemsTextures = new ItemsTextures(this, shop);
        itemsTextures.loadItemsTextures();
    }

    public void texturePosition (ArrayMap<String,Float> props, float x,float y, float width, float height) {

        props.put("x", Static.cam.viewportWidth * x);
        props.put("y", Static.cam.viewportHeight * y);
        props.put("width", Static.cam.viewportWidth * width);
        props.put("height", Static.cam.viewportHeight * height);
    }

    public Rectangle loadButton (ArrayMap<String,Float> props, float x,float y, float width, float height) {

        this.texturePosition(props,x,y,width,height);
       return new Rectangle(props.get("x"),props.get("y"),props.get("width"),props.get("height"));
    }


    private void loadInitializers() {

        // player top level controller
        topLevel.initializer();
        slime.initalizer();
        render.initializer();
        acc.initializer();
        // shop controller
        //shop.initializer();
        //font.initializer(this);
    }

    public void loader() {

        btn.touchPoint = new Vector3();

        loadTextures();
        //loadButtons();

        Fonts fonts = new Fonts(manager, resolver);
        fonts.loadFonts();
        font.initializer(fonts);

        //getFonts();
        loadInitializers();
    }
}
