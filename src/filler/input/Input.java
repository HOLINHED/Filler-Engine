package filler.input;

public interface Input {

    default void mouseClicked() { }

    default void mousePressed() { }

    default void mouseReleased() { }

    default void keyPressed() { }

    default void keyReleased() { }

    default void keyTyped() { }

}