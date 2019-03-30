package filler.core;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import filler.input.KeyManager;
import filler.input.MouseManager;

public class Container extends JPanel {

    private Bridge game;
    private Timer timer;
    private MouseManager input;

     Container(int width, int height, Bridge game) {

        this.game = game;

        game.WIDTH = width;
        game.HEIGHT = height;

        setPreferredSize(new Dimension(width, height));

        setFocusable(true);

        ActionListener update = event -> repaint();

        game.setKeymanager(new KeyManager(this, game));

        game.create();

        input = new MouseManager(this, game);

        timer = new Timer(5, update);
        timer.start();

    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        game.setG(g);
        game.updateMousePosition(getMousePosition());

        game.update();

        g.dispose();
    }

    void setRefreshSpeed(int speed) {
         timer.setDelay(speed);
    }

}
