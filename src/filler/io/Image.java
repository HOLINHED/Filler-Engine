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

    public static BufferedImage[][] loadTileMap(String path, int width, int height) {

        BufferedImage[][] map = null;

        try {
            BufferedImage tileMap = ImageIO.read(new java.io.File(path));

            final int rows = tileMap.getWidth() / width;
            final int columns = tileMap.getHeight() / height;

            map = new BufferedImage[rows][columns];

            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < columns; x++) {
                    map[y][x] = tileMap.getSubimage(x * width, y * height, width, height);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return map;

    }

    public static BufferedImage[][] loadTileMap(String path, int size) {
        return loadTileMap(path, size, size);
    }

}
