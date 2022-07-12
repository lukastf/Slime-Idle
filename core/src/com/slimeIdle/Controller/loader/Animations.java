package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slimeIdle.Model.Animate;
import com.slimeIdle.Model.Slime;

public class Animations {

    Slime slime;

    public Animations(Slime slime) {

        this.slime = slime;
    }

    public void loadSleepAnimation() {
        slime.sleep = new Texture("textures/sleep.png");
        slime.sleepAnimation = new Animation<TextureRegion>(0.3f, Animate.framesAnimation(slime.sleep, 2, 3));
    }
}
