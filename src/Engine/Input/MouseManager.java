package Engine.Input;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    private Input game;

    public MouseManager(JPanel window, Input game) {

        this.game = game;

        window.addMouseListener(this);
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
