package tests.snake;

import java.awt.*;
import java.util.ArrayList;

class Player extends Entity {

    int vx;
    int vy;
    ArrayList<Entity> tail = new ArrayList<>();
    int length = 5;

    Player(int x, int y, Snake c, Graphics g) {
        super(x,y,c,g);
    }

    void update() {
        x += vx;
        y += vy;

        // wrap around screen
        if (x > c.WIDTH/ Snake.SCALE) {
            x = 0;
        }

        if (x < 0) {
            x = c.WIDTH/ Snake.SCALE;
        }

        if (y > c.HEIGHT/ Snake.SCALE) {
            y = 0;
        }

        if (y < 0) {
            y = c.HEIGHT/ Snake.SCALE;
        }

        for (Entity part : tail) {
            part.setG(g);
            part.draw();
            if (x == part.x && y == part.y && length > 5) {
                tail.clear();
                length = 5;
                c.score = 0;
                break;
            }
        }

        if (tail.size() < length) {
            addTail();
        } else {
            tail.remove(0);
            addTail();
        }


        g.setColor(Color.red);
    }

    private void addTail() {
        tail.add(new Entity(x,y,c,g) {
            public void update() {
                this.g.setColor(Color.red);
            }
        });
    }

}