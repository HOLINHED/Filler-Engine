package filler.physics;

/**
 * A scalar is a data structure to keep track both x and y components of position.
 * it also has methods to add vectors.
 */

public class Scalar {

    private double x;
    private double y;

    /**
     * @param x Initial X position.
     * @param y Initial Y Position
     */
    public Scalar(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Scalar() {
        this(0,0);
    }

    /**
     * @param toAdd The vector which components should be added to this scalar.
     */
    public void addVector(Vector toAdd) {
        x += toAdd.getX();
        y += toAdd.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
