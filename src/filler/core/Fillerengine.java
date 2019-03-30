package filler.core;

import javax.swing.JFrame;
import java.awt.event.*;

public class Fillerengine extends JFrame {

    private Container container;

    public Fillerengine(int width, int height, Bridge game, String... title) {

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    protected void setRefreshSpeed(int speed) {
        container.setRefreshSpeed(speed);
    }

}
