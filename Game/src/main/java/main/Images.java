package main;

import javafx.scene.image.Image;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jan Kulose - s0557320 on 21.05.17.
 */
public enum Images {
    TEX_BACKGROUND(getImage("background.png")),
    TEX_SUN(getImage("sun.png")),

    ;


    private final Image texture;

    Images(Image img) {
        this.texture = img;
    }

    private static Image getImage(String s) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(s);
        Image rImg = new Image(is);
        try {
            is.close();
        } catch (IOException e) {
            System.err.println("couldn't close inputstream");
        }
        return rImg;
    }

    public Image getTexture() {
        return texture;
    }
}
