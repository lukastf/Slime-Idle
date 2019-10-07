package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Window {

    // Textures
    public Texture reconnectWindow;
    public Texture window;
    public Texture closeWindow;

    // Sprites

    public Sprite reconnectWindowSpr;
    public Sprite windowSpr;

    private int currentPage = 1;
    private int playerTopSelecionado = 0;
    private int itemSelecionado = 0;

    public void dispose() {
        reconnectWindow.dispose();
        window.dispose();
        closeWindow.dispose();
    }
}
