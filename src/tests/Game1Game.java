package tests;

import Engine.Bridge;

import java.awt.*;
import java.util.*;

public class Game1Game extends Bridge {

    int x;
    int y;
    int vx;
    int vy;
    ArrayList bullets;

    public void create() {
        bullets = new ArrayList();
    }

    public void update() {

        class Paint {

            int x;
            int y;
            int vx;
            int vy;

            public Paint(int x, int y, int vx, int vy) {
                this.x = x;
                this.y = y;
                this.vx = vx;
                this.vy = vy;
            }

            @Override
            public String toString() {
                //lol
                x += vx;
                y += vy;

                g.setColor(new Color(255, 91, 67));
                g.fillOval(x - 10,y - 10,20,20);

                return "";
            }

        }

        g.drawOval(mouseX - 10, mouseY - 10, 20,20);

        bullets.forEach(Object::toString);

        //shoot
        if(key.isPressed(' ')) {
            bullets.add(new Paint(mouseX, mouseY, 0,0));
        }

    }

    public void close() {
        System.out.println("Hello world!");
    }

}
