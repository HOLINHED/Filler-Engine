package filler.physics;

public class Body {

    public static final int NONE = 0;
    public static final int STATIC = 1;
    public static final int ELASTIC = 2;

    private Scalar[] vertices;
    private Scalar position;
    private Vector velocity;
    private Vector acceleration;
    private double mass;
    private double angle;

    public Body(Scalar[] vertices, Scalar position, Vector velocity,
                Vector acceleration, double angle, double mass) {
        this.vertices = vertices;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.angle = angle;
        this.mass = mass;
    }

    public Body(Scalar[] vertices, Scalar position, Vector velocity,
                Vector acceleration, double angle) {
        this(vertices, position, velocity, acceleration, angle, 100);
    }

    public Body(Scalar[] vertices, Scalar position, Vector velocity,
                Vector acceleration) {
        this(vertices, position, velocity, acceleration,0);
    }

    public Body(Scalar[] vertices, Scalar position, Vector velocity) {
        this(vertices, position, velocity, new Vector(0,0));
    }

    public Body(Scalar[] vertices, Scalar position) {
        this(vertices, position, new Vector(0,0));
    }

    public Body(Scalar[] vertices) {
        this(vertices, new Scalar(0,0));
    }

    public void update() {

        velocity.addVector(acceleration);

        position.addVector(velocity);

        for (Scalar point : vertices) {
            point.addVector(velocity);
        }

    }

    public Scalar[] getVertices() {
        return vertices;
    }

    public Scalar getPosition() {
        return position;
    }

    public void setPosition(Scalar position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public static Body create(int points) {
        return null;
    }

}
