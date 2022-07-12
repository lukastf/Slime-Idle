package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
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
import com.badlogic.gdx.utils.Array;
import com.slimeIdle.Model.BitmapFontWriter;
import com.slimeIdle.Model.Font;

import java.util.Map;

public class Fonts {

    AssetManager manager;
    FileHandleResolver resolver;
    Font font;

    public Fonts(AssetManager manager, FileHandleResolver resolver) {
        this.manager = manager;
        this.resolver = resolver;
    }

    private PixmapPacker generateFont(
            String GLYPHS,
            AssetManager manager,
            String fileName,
            String newFontName,
            String newFontCategory,
            int size
    ) {

        FreetypeFontLoader.FreeTypeFontLoaderParameter parameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        parameter.fontFileName = fileName+".ttf";
        parameter.fontParameters.size = (int)(size * Gdx.graphics.getDensity());
        parameter.fontParameters.characters= GLYPHS;
        parameter.fontParameters.packer = new PixmapPacker(font.pageWidth, font.pageHeight, Pixmap.Format.RGBA8888, 2, false, new PixmapPacker.SkylineStrategy());

        manager.load(fileName + newFontName + newFontCategory+".ttf", BitmapFont.class, parameter);

        return parameter.fontParameters.packer;
    }

    private BitmapFont getBitmapFont(FileHandle fileFnt, String pathPng) {

        FileHandle filePng = Gdx.files.local(pathPng+".png");
        BitmapFont.BitmapFontData fontData = new BitmapFont.BitmapFontData(fileFnt, false);
        Array<TextureRegion> textureRegion = new Array <TextureRegion>();

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

    private boolean getOrGenerateFont (String FONT, String fontPath, String fontName, Map<String, BitmapFont> fontMap, Map<String, PixmapPacker> pixPackers, String glyps, int fontType) {

        FileHandle fileFnt = Gdx.files.local("fonts/generated/"+fontPath+"/"+fontName+".fnt");

        if(fileFnt.exists()) {

            fontMap.put(fontName, this.getBitmapFont(fileFnt,"fonts/generated/"+fontPath+"/"+fontName));

            return true;

        } else {

            PixmapPacker pix = null;
            switch (fontType){
                case 0:
                    pix = this.generateFont(glyps, manager, FONT, fontPath,"",25);
                    break;
                case 1:
                    pix = this.generateFont(glyps, manager, FONT, fontPath, "topLevel", 20);
                    break;
                case 2:
                    pix = this.generateFont(glyps, manager, FONT, fontPath, "topLevelNumber", 15);
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
        topLevelLoaded = this.getOrGenerateFont(FONT, fontPath, "topLevel", fontMap, pixPackers, glyps, 1);
        topLevelNumberLoaded = this.getOrGenerateFont(FONT, fontPath, "topLevelNumber", fontMap, pixPackers, glyps, 2);

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


        manager.finishLoadingAsset("fonts/font"+fontPath+".ttf");
        //manager.finishLoadingAsset("fonts/font"+fontPath+"message.ttf");
        manager.finishLoadingAsset("fonts/font"+fontPath+"topLevel.ttf");
        manager.finishLoadingAsset("fonts/font"+fontPath+"topLevelNumber.ttf");

        //System.out.println("fox on the run");

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
}
