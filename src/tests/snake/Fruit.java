package tests.snake;

import java.awt.*;

import static tests.snake.Snake.SCALE;

class Fruit extends Entity {

    Fruit(Snake c, Graphics g) {
        super(c,g);
        randomLocation();
    }

    @Override
    void update() {
        if (x == c.player.x && y == c.player.y) {
            c.player.length += 5;
            c.score += 100;
            randomLocation();
        }

        g.setColor(Color.green);
    }

    private void randomLocation() {
        x = (int) Math.floor(Math.random() * c.WIDTH/SCALE);
        y = (int) Math.floor(Math.random() * c.HEIGHT/SCALE);
    }

}
