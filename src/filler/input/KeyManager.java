package filler.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

public class KeyManager implements KeyListener {

    private List<Integer> keys;

    public KeyManager(JPanel container) {
        keys = new ArrayList<>();

        container.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keys.contains(e.getKeyCode())) {
            keys.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove((Integer)e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    public boolean isPressed(int keyCode) {
        return keys.contains(keyCode);
    }

    public boolean isPressed(char key) {
        return isPressed((int)Character.toUpperCase(key));
    }

}
