package filler.physics;

/**
 * TODO: Make the body calculate it's collisions instead of outside of the world.
 *
 * A Body is a storing information about a shape that make it easier to manipulate in the world.
 * bodies have an update method, that updates position, velocity, and acceleration of the body.
 */

@SuppressWarnings({"unused", "WeakerAccess"})
public class Body {

    public static final int NONE = 0;
    public static final int BOUND = 1;
    public static final int STATIC = 2;
    public static final int ELASTIC = 3;

    private Scalar[] vertices;
    private Scalar position;
    private Vector velocity;
    private Vector acceleration;
    private double mass;
    private double angle;
    private int collision = 0;

    /**
     *
     * @param vertices An array of <code>Scalars</code> that the body will use to define
     *                 it's vertices.
     *
     * @param position A Scalar the defines the position of this body. Mostly used to define the midpoint of the shape.
     *
     * @param velocity The initial velocity that the body should be created with.
     *
     * @param acceleration The initial acceleration that the body should be made with.
     *
     * @param angle The angle at which the body should be rotated.
     *
     * @param mass The mass of this body. Mostly used for elastic collisions.
     */
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

    /**
     * Updates the position, velocity, and acceleration of this body.
     */
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

    /**
     * @return An array containing an array of each x and y position.
     */
    public int[][] getVerticesArray() {

        int[] xPos = new int[vertices.length];
        int[] yPos = new int[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            xPos[i] = (int) vertices[i].getX();
            yPos[i] = (int) vertices[i].getY();
        }

        return new int[][] {
                xPos,
                yPos,
        };

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

    public int getCollision() {
        return this.collision;
    }

    /**
     * @param type The type of collision this body should use.
     *             as static finals on top of this class.
     */
    public void setCollision(int type) {
        this.collision = type <= 3 && type >= 0 ? type : 0;
    }

    /**
     * TODO: TEST THIS METHOD!!!
     *
     * @param points How many vertices the shape should have.
     *
     * @return Body A body with the specified amount of vertices
     */
    public static Body makeBody(int points, int radius, int x, int y, double angle) {

        Scalar[] verts = new Scalar[points];

        for (double a = 0.0, i = 0; a < Math.PI * 2; a += (Math.PI * 2)/points, i++) {

            double dx = (radius * (Math.cos((angle) - a))) + x;
            double dy = (radius * (Math.sin((angle) - a))) + y;

            verts[(int)i] = new Scalar(dx,dy);

        }

        return new Body(verts, new Scalar(x,y));
    }

    public static Body makeBody(int points, int radius, int x, int y) {
        return makeBody(points, radius, x, y, -Math.PI/2);
    }

    public static Body makeBody(int points, int radius, double angle) {
        return makeBody(points, radius, 0, 0, angle);
    }

    public static Body makeBody(int points, int radius) {
        return makeBody(points, radius, 0, 0);
    }

}
