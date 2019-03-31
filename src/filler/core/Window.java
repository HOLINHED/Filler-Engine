package filler.core;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Window {

    private Container container;
    private JFrame window;

    Window(int width, int height, Bridge game, String... title) {

        window = new JFrame(title.length > 0 ? title[0] : "FILLER ENGINE");

        container = new Container(width, height, game);

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                game.close();
                super.windowClosing(e);
            }
        });

        window.add(container);
        window.setResizable(false);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    void update() {
        window.repaint();
        container.repaint();
    }

    void sendFps(int fps) {
        container.sendFps(fps);
    }
}
