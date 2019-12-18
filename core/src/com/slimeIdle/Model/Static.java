package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Static {

    public static OrthographicCamera cam;
    public static SpriteBatch batch;

    public static void dispose () {
        batch.dispose();
    }
}
