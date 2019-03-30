package filler.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("WeakerAccess")
public class KeyManager implements KeyListener {

    private List<Integer> keys;
    private int key;
    private Input game;

    public KeyManager(JPanel container, Input game) {
        keys = new ArrayList<>();

        this.game = game;

        container.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keys.contains(e.getKeyCode())) {
            key = e.getKeyCode();
            keys.add(e.getKeyCode());
        }
        game.keyPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove((Integer)e.getKeyCode());
        game.keyReleased();
        key = e.getKeyCode();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        game.keyTyped();
    }

    public boolean isPressed(int keyCode) {
        return keys.contains(keyCode);
    }

    public boolean isPressed(char key) {
        return isPressed((int)Character.toUpperCase(key));
    }

    public int getKey() {
        return key;
    }

}
