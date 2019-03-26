package filler.physics;

import java.util.List;
import java.util.ArrayList;

/**
 * The World manages all bodies. it automatically updates them, and also
 * checks for collisions. The world also provides static methods for
 * checking collisions.
 */

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

    /**
     * TODO: Implement diagonal collision
     *
     * @param one The body to check.
     *
     * @param two The body to compare the first body to.
     *
     * @return True if the bodies are intersecting, false otherwise.
     */
    public static boolean testCollision(Body one, Body two) {
        return false;
    }

    /**
     * Performs the same collision detection as the <code>testCollision</code> method,
     * but also changes positions of either body to make sure they aren't intersecting
     * anymore.
     *
     * @param one The body to check.
     *
     * @param two The body to compare the positions of the first body to.
     *
     * @return True if the bodies were intersecting, false otherwise.
     */
    public static boolean testCollisionStatic(Body one, Body two) {
        return false;
    }

    /**
     * @param body The body to serve as the reference frame.
     *
     * @param point The point to check
     *
     * @return True if the point is within the bounds of the body, false otherwise.
     */
    public static boolean testCollisionPoint(Body body, Scalar point) {
        return false;
    }

    /**
     * Checks whether or not the body is outside of the world bounds.
     *
     * @param body The body to check
     *
     * @param width Width of the world.
     *
     * @param height Height of the world
     *
     * @return True if the body is less than 0 greater than width/height.
     */
    public static boolean isOutside(Body body, int width, int height) {
        return false;
    }


}
