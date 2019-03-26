package tests;

import filler.core.Bridge;
import filler.physics.*;
import java.awt.*;

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

        player = new Body(pos, new Scalar(25,25), Vector.fromAngle(Math.PI / 1, 2), new Vector(0,0));

        world.add(player);
    }

    @Override
    public void update() {

        world.update();

        double x = player.getPosition().getX();
        if (x < 25 || x > WIDTH - 25) {
            System.out.println("GOT HERE!");
            player.getVelocity().invertX();
        }

        if (player.getPosition().getY() < 25 || player.getPosition().getX() > HEIGHT - 25) {
            System.out.println("GOT HERE!");
            player.getVelocity().invertY();
        }

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
