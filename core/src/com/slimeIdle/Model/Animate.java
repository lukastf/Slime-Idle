package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animate {

    public static TextureRegion[] framesAnimation(Texture texture, int cols, int rows) {
        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth() / cols,
                texture.getHeight() / rows);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animate constructor requires a 1D array.
        TextureRegion[] frames = new TextureRegion[rows * cols];
        int index = 0;
        for (int in = 0; in < rows; in++) {
            for (int j = 0; j < cols; j++) {
                frames[index++] = tmp[in][j];
            }
        }

        return frames;
    }

}
