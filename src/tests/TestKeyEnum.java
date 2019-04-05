package tests;

import filler.core.Bridge;
import filler.physics.*;
import filler.input.Key;

import java.awt.*;

public class TestKeyEnum extends Bridge {

    private Body player;
    private World world;

    @Override
    public void create() {

        world = new World(WIDTH,HEIGHT);

        player = Body.makeBody(4,50,WIDTH/2,HEIGHT/2,Math.PI/4);
        player.setCollision(Collision.BOUND);

        world.add(player);
    }

    @Override
    public void update() {

        world.update();

        int[][] pos = player.getVerticesArray();

        Polygon shape = new Polygon(pos[0], pos[1], pos[0].length);
        g.fillPolygon(shape);

        if (key.isPressed(Key.ARROWLEFT)) {
            System.out.println(1);
            player.getVelocity().setX(-3);
            player.getVelocity().setY(0);
        }

        if (key.isPressed(Key.ARROWRIGHT)) {
            System.out.println(2);
            player.getVelocity().setX(3);
            player.getVelocity().setY(0);
        }

        if (key.isPressed(Key.ARROWUP)) {
            System.out.println(3);
            player.getVelocity().setX(0);
            player.getVelocity().setY(-3);
        }

        if (key.isPressed(Key.ARROWDOWN)) {
            System.out.println(4);
            player.getVelocity().setX(0);
            player.getVelocity().setY(3);
        }
    }

    @Override
    public void close() {
        System.out.println(":D");
    }
}
