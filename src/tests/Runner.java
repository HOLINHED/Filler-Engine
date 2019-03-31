package tests;

import filler.core.Bridge;
import filler.core.Fillerengine;

@SuppressWarnings("ALL")
public class Runner extends Fillerengine {

    public Runner(Bridge game) {
        super(400,400, game);
        setFrameRate(121);
        start();
    }

    public static void main(String... args) {
        //new Runner(new LoadingImages());
        //new Runner(new MakingVector());
        //new Runner(new LoadingTileMap());
        //new Runner(new KeyInputTest());
        //new Runner(new PhysicsInit());
        //new Runner(new SaveLoadingData());
        //Runner runner = new Runner(new PhysMakeBody());
        Runner runner = new Runner(new PlaySound());
    }
}
