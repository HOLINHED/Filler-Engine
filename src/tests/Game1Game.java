package tests;

import Engine.Bridge;

import java.awt.*;

public class Game1Game extends Bridge {

    public void create() {

    }

    public void update() {

        g.drawOval(mouseX - 50, mouseY - 50, 100,100);
        if(key.isPressed('a')) {
            System.out.println("PRESSED!");
        }

    }

    public void close() {
        System.out.println("Hello world!");
    }

}
