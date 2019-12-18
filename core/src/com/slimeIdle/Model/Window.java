package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;

public class Window {

    // Textures
    public TextureRegion reconnectWindow;
    public TextureRegion window;

    public ArrayMap<String,Float> reconnectWindowPosition = new ArrayMap<String, Float>();
    public ArrayMap<String,Float> windowPosition = new ArrayMap<String, Float>();

    public void drawReconnectWindow() {

        Static.batch.draw(
                reconnectWindow,
                reconnectWindowPosition.get("x"),
                reconnectWindowPosition.get("y"),
                reconnectWindowPosition.get("width"),
                reconnectWindowPosition.get("height"));
    }

    public void drawWindow () {

        Static.batch.draw(
                window,
                windowPosition.get("x"),
                windowPosition.get("y"),
                windowPosition.get("width"),
                windowPosition.get("height"));
    }

    public void dispose() {
        // esta no buttons
    }
}
