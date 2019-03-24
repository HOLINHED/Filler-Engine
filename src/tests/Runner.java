package tests;

import Engine.Draw.Bridge;
import Engine.Draw.Fillerengine;

public class Runner extends Fillerengine {

    public Runner(Bridge game) {
        super(400,400, game);
        setRefreshSpeed(5);
    }

    public static void main(String... args) {
        new Runner(new LoadingImages());
    }
}
