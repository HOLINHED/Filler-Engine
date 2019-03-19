package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Container extends JPanel {

    private Bridge game;
    private Timer timer;

     Container(int width, int height, Bridge game) {

        this.game = game;

        game.WIDTH = width;
        game.HEIGHT = height;

        setPreferredSize(new Dimension(width, height));

        setFocusable(true);

        ActionListener update = event -> repaint();

        game.setKeymanager(new KeyManager(this));

        game.create();

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
