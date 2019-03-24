package tests;

import Engine.Draw.Bridge;

import java.awt.image.BufferedImage;
import Engine.IO.Image;

public class LoadingImages extends Bridge {

    BufferedImage image;

    public void create() {
        image = Image.loadImage("./res/block.png");
    }

    public void update() {
        g.drawImage(image, 100, 100, 128, 128, null);
    }

    public void close() {
        System.out.println("Thank you have a great time!");
    }

}
