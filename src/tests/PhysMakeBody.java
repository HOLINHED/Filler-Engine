package tests;

import filler.core.Bridge;
import filler.physics.*;
import java.awt.*;

import static filler.physics.Body.*;

public class PhysMakeBody extends Bridge {

    private World world;

    private Body player;

    @Override
    public void create() {

        world = new World(WIDTH,HEIGHT);

        player = makeBody(4,25,25,25,-Math.PI/8);

        player.getVelocity().setMag(2,Math.PI/4);
        player.getAcceleration().setY(0.5);

        player.setCollision(BOUND);

        world.add(player);
    }

    @Override
    public void update() {

        world.update();

        g.setColor(Color.black);
        g.fillOval((int)player.getPosition().getX() - 25, (int)player.getPosition().getY() - 25, 50, 50);

        g.setColor(Color.red);
        g.fillOval((int)player.getPosition().getX()-3, (int)player.getPosition().getY()-3, 6,6);

        g.setColor(Color.black);
        g.drawString("FPS: " + fps, 10, 20);
    }

    @Override
    public void close() {
        System.out.println("Thanks have a great time!");
    }

}
