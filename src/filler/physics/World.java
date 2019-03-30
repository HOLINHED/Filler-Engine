package filler.physics;

import java.util.List;
import java.util.ArrayList;

/**
 * The World manages all bodies. it automatically updates them, and also
 * checks for collisions. The world also provides static methods for
 * checking collisions.
 */

public class World {

    private List<Body> bodies;
    private int worldWidth;
    private int worldHeight;

    public World(final int width, final int height) {

        worldWidth = width;
        worldHeight = height;

        bodies = new ArrayList<>();
    }

    public void update() {

        // Updates each body
        bodies.forEach(Body::update);

        // Collisions
        for (Body body : bodies) {

            if (body.getCollision() == Body.NONE) break;

            // TODO: Make this collision static (Constricts points to be within bounds after collision)
            if (body.getCollision() == Body.BOUND) {

                // Checks all points so check out of bounds < 0 || > WIDTH/HEIGHT
                // and reverses direction
                for (Scalar vert : body.getVertices()) {
                    boolean rev = false;

                    if (vert.getX() > worldWidth || vert.getX() < 0) {
                        body.getVelocity().invertX();
                        rev = true;
                    }

                    if (vert.getY() > worldHeight || vert.getY() < 0) {
                        body.getVelocity().invertY();
                        rev = true;
                    }
                    if (rev) break;
                }

                break;
            }

            if (body.getCollision() == Body.STATIC) {

                break;
            }

            if (body.getCollision() == Body.ELASTIC) {

                break;
            }

        }


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

    public static boolean intersects(double x1, double y1, double x2, double y2,
                                     double x3, double y3, double x4, double y4) {
        double denominator = ((x2 - x1) * (y4 - y3)) - ((y2 - y1) * (x4 - x3));
        double numerator1 = ((y1 - y3) * (x4 - x3)) - ((x1 - x3) * (y4 - y3));
        double numerator2 = ((y1 - y3) * (x2 - x1)) - ((x1 - x3) * (y2 - y1));

        if (denominator == 0) return numerator1 == 0 && numerator2 == 0;

        double r = numerator1 / denominator;
        double s = numerator2 / denominator;

        return (r >= 0 && r <= 1) && (s >= 0 && s <= 1);
    }

}
