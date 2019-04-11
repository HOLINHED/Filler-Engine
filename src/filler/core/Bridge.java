package filler.core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import filler.input.Input;
import filler.input.KeyManager;

@SuppressWarnings("WeakerAccess")
public abstract class Bridge implements Input {

    protected Graphics g;
    protected Graphics2D g2d;
    protected KeyManager key;
    public int WIDTH;
    public int HEIGHT;
    protected int mouseX;
    protected int mouseY;
    protected int fps;

    public Bridge() {
        mouseX = 0;
        mouseY = 0;
        fps = 0;
    }

    abstract public void create();

    abstract public void update();

    abstract public void close();

    void setG(Graphics g) {
        this.g = g;
        this.g2d = (Graphics2D) g;
    }

    void setKeymanager(KeyManager key) {
        this.key = key;
    }

    void setFps(int fps) {
        this.fps = fps;
    }

    void updateMousePosition(Point pos) {
        try {
            mouseX = pos.x;
            mouseY = pos.y;
        } catch (NullPointerException ignored) { }
    }

}
