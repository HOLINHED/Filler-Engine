package filler.physics;

public class Scalar {

    private double x;
    private double y;

    public Scalar(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Scalar() {
        this(0,0);
    }

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
