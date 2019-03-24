package filler.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {

    public static BufferedImage loadImage(String path) {

        BufferedImage image = null;

        try {
            image = ImageIO.read(new java.io.File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return image;
    }

}
