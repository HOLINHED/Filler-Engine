package filler.input;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("unused")
public class MouseManager implements MouseListener {

    private Input game;

    public MouseManager(JPanel container, Input game) {

        this.game = game;

        container.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        game.mouseClicked();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.mousePressed();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.mouseReleased();
    }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }
}
