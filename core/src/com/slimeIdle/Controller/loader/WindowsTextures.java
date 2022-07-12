package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Window;

public class WindowsTextures {

    Loader loader;
    Window window;
    Buttons btn;
    Menu menu;


    public WindowsTextures(Loader loader, Window window, Buttons buttons, Menu menu){
        this.loader = loader;
        this.window = window;
        this.btn = buttons;
        this.menu = menu;
    }

    public void loadWindowsTextures() {

        window.windows = new Texture("textures/windows.png");

        window.reconnectWindow = loader.posicaoTextureCustom(window.windows,0,0, 4,4);
        menu.background_menu = loader.posicaoTextureCustom(window.windows,4,0, 4,4);
        window.window = loader.posicaoTextureCustom(window.windows,4,0, 4,4);
        loader.texturePosition(window.windowPosition,0.15f,0.1f,0.7f,0.3f);
        loader.texturePosition(window.reconnectWindowPosition, 0.1f,0.1f, 0.8f, 0.7f);
    }
}
