package Engine;

import java.awt.*;

public abstract class Bridge {

    protected Graphics g;
    protected KeyManager key;
    protected int WIDTH;
    protected int HEIGHT;
    protected int mouseX;
    protected int mouseY;

    public Bridge() {
        mouseX = 0;
        mouseY = 0;
    }

    abstract public void create();

    abstract public void update();

    abstract public void close();

    void setG(Graphics g) {
        this.g = g;
    }

    void setKeymanager(KeyManager key) {
        this.key = key;
    }

    void updateMousePosition(Point pos) {
        try {
            mouseX = pos.x;
            mouseY = pos.y;
        } catch (NullPointerException e) { }
    }

}
