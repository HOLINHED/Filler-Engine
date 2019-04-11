package tests.snake;

import java.awt.*;

import static tests.snake.Snake.SCALE;

abstract class Entity {

    protected int x;
    protected int y;
    protected Graphics g;
    Snake c;

    Entity(int x, int y, Snake c, Graphics g) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.c = c;
    }

    Entity(Snake c, Graphics g) {
        this(0,0,c,g);
    }

    abstract void update();

    void setG(Graphics g) {
        this.g = g;
    }

    void draw() {
        update();

        g.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
    }

}
