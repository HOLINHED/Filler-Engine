package filler.physics;

import java.util.List;
import java.util.ArrayList;

public class World {

    List<Body> bodies;

    public World() {
        bodies = new ArrayList<>();
    }

    public void update() {

        bodies.forEach(Body::update);

    }

    public void add(Body body) {
        bodies.add(body);
    }

    public static boolean testCollision(Body one, Body two) {
        return false;
    }

    public static boolean testCollisionStatic(Body one, Body two) {
        return false;
    }

    public static boolean testCollisionPoint(Body body, Scalar point) {
        return false;
    }


}
