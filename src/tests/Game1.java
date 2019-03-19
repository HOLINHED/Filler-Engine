package tests;

import Engine.Bridge;
import Engine.Fillerengine;

public class Game1 extends Fillerengine {

    public Game1(Bridge game) {
        super(400,400, game);
        setRefreshSpeed(5);
    }

    public static void main(String... args) {
        new Game1(new Game1Game());
    }
}
