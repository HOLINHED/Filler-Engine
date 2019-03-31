package tests;

import filler.core.Bridge;
import filler.sound.Audio;

public class PlaySound extends Bridge {

    @Override
    public void create() {

        Audio gunshot = new Audio("./res/gunshot.wav", Audio.LOOP);
        gunshot.play();
    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }
}
