package tests;

import filler.core.Bridge;
import filler.physics.*;
import java.awt.*;

public class PhysicsInit extends Bridge {

    private World world;

    // w = 50; h = 50, x = 0 , y = 0

    /**
     * ----------
     * -        -
     * -        -
     * -        -
     * ----------
     */

    private Body player;

    @Override
    public void create() {

        world = new World(WIDTH,HEIGHT);

        final Scalar[] pos = new Scalar[] {
                new Scalar(0,0),
                new Scalar(50,0),
                new Scalar(50,50),
                new Scalar(0,50),
        };

        player = new Body(pos, new Scalar(25,25), Vector.fromAngle(Math.PI / 4, 2),
                new Vector(0,0.1));

        player.setCollision(Body.BOUND);

        world.add(player);
    }

    @Override
    public void update() {

        world.update();

        g.setColor(Color.black);
        g.fillRect((int)player.getPosition().getX() - 25, (int)player.getPosition().getY() - 25, 50, 50);

        g.setColor(Color.red);
        g.fillRect((int)player.getPosition().getX()-3, (int)player.getPosition().getY()-3, 6,6);
    }

    @Override
    public void close() {
        System.out.println("Thanks have a great time!");
    }

}
