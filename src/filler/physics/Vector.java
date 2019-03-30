package filler.physics;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {
        setX(x);
        setY(y);
    }

    public Vector() {
        this(0,0);
    }

    public double mag() {
        return Math.sqrt((x * x) + (y * y));
    }

    public void setMag(double mag, double angle) {
        x = mag * Math.cos(angle);
        y = mag * Math.sin(angle);
    }

    public void addVector(Vector other) {
        x += other.getX();
        y += other.getY();
    }

    public void invert() {
        invertX();
        invertY();
    }

    public void invertX() {
        x *= -1;
    }

    public void invertY() {
        y *= -1;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static Vector fromAngle(double angle, double magnitude) {

        final double x = magnitude * Math.cos(angle);
        final double y = magnitude * Math.sin(angle);

        return new Vector(x,y);
    }

}
