package filler.core;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Window extends JFrame {

    private Container container;

    Window(int width, int height, Bridge game, String... title) {

        super(title.length > 0 ? title[0] : "FILLER ENGINE");

        container = new Container(width, height, game);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                game.close();
                super.windowClosing(e);
            }
        });

        add(container);
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    void update() {
        container.repaint();
    }

    void sendFps(int fps) {
        container.sendFps(fps);
    }
}
