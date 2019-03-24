package tests;

import filler.core.Bridge;
import filler.io.Image;

import java.awt.image.BufferedImage;

public class LoadingTileMap extends Bridge {

    BufferedImage[][] image;

    @Override
    public void create() {

        image = Image.loadTileMap("./res/block.png", 189, 189);

    }

    @Override
    public void update() {

        //g.drawImage(image, 0, 0, 128, 128, null);
        g.drawImage(image[1][1], 0, 0, null);

    }

    @Override
    public void close() {

    }

}
