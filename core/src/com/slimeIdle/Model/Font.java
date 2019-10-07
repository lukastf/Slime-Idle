package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {

    // Fonts
    public BitmapFont font;
    public BitmapFont fontTopLevel;
    public BitmapFont fontTopLevelNumber;
    public BitmapFont fontPlayerSelecionadoLevel;
    public BitmapFont fontSuccess;
    public BitmapFont fontError;
    public BitmapFont fontTitle;
    public FreeTypeFontGenerator generator;

    public void dispose () {
        generator.dispose();
        font.dispose();
        fontTopLevel.dispose();
        fontTopLevelNumber.dispose();
        fontTopLevelNumber.dispose();
        fontPlayerSelecionadoLevel.dispose();
        fontSuccess.dispose();
        fontError.dispose();
        fontTitle.dispose();
    }
}
