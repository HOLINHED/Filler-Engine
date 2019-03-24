package tests;

import filler.core.Bridge;
import filler.physics.Vector;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class MakingVector extends Bridge {

    Vector velocity;
    double x;
    double y;

    @Override
    public void create() {

        velocity = new Vector(1,0.5);
        x = WIDTH / 2;
        y = HEIGHT / 2;
    }

    @Override
    public void update() {

        x += velocity.getX();
        y += velocity.getY();

        //Rectangle2D rect = new Rectangle2D.Double(x, y, 30, 30);

        //Graphics2D g2 = (Graphics2D) g;

        //g2.fill(rect);

        g.fillRect((int)x,(int)y,50, 50);

    }

    @Override
    public void close() {
        System.out.println("Have a nice day!");
    }
}
