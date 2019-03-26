package tests;

import filler.core.Bridge;
import filler.physics.*;

public class PhysicsInit extends Bridge {

    World world;

    // w = 50; h = 50, x = 0 , y = 0

    /**
     * ----------
     * -        -
     * -        -
     * -        -
     * ----------
     */

    Body player;

    @Override
    public void create() {

        world = new World();

        final Scalar[] pos = new Scalar[] {
                new Scalar(0,0),
                new Scalar(50,0),
                new Scalar(50,50),
                new Scalar(0,50),
        };

        player = new Body(pos, new Scalar(25,25), new Vector(0,0), new Vector(0.01,0));

        world.add(player);
    }

    @Override
    public void update() {

        world.update();

        g.fillRect((int)player.getPosition().getX() - 25, (int)player.getPosition().getY() - 25, 50, 50);

    }

    @Override
    public void close() {
        System.out.println("Thanks have a great time!");
    }

}
