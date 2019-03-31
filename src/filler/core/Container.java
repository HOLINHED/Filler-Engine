package filler.core;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

import filler.input.KeyManager;
import filler.input.MouseManager;

@SuppressWarnings({"FieldCanBeLocal"})
class Container extends JPanel {

    private Bridge game;

    Container(int width, int height, Bridge game) {

        this.game = game;

        game.WIDTH = width;
        game.HEIGHT = height;

        setPreferredSize(new Dimension(width, height));

        setFocusable(true);

        game.setKeymanager(new KeyManager(this, game));

        game.create();

        new MouseManager(this, game);

    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        game.setG(g);
        game.updateMousePosition(getMousePosition());

        game.update();

        g.dispose();
    }

    protected void sendFps(int fps) {
        game.setFps(fps);
    }

}
