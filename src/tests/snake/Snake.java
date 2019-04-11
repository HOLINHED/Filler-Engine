package tests.snake;

import filler.core.Bridge;
import filler.input.Key;

import java.awt.*;

public class Snake extends Bridge {

    static final int SCALE = 25;
    int score = 0;
    Player player;
    private Fruit fruit;

    public void create() {

        player = new Player(8,8,this,g);
        fruit = new Fruit(this,g);

    }

    public void update() {
        player.setG(g);
        fruit.setG(g);

        g.setColor(new Color(21,21,21));
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(fps), 10,20);
        g.drawString(Integer.toString(score), 10, 40);

        player.draw();
        fruit.draw();

        checkMove();
    }

    private void checkMove() {
        if (key.isPressed(Key.ARROWLEFT)) {
            player.vx = -1;
            player.vy = 0;
        }
        if (key.isPressed(Key.ARROWDOWN)) {
            player.vx = 0;
            player.vy = 1;
        }
        if (key.isPressed(Key.ARROWUP)) {
            player.vx = 0;
            player.vy = -1;
        }
        if (key.isPressed(Key.ARROWRIGHT)) {
            player.vx = 1;
            player.vy = 0;
        }
    }

    public void close() { }

}
