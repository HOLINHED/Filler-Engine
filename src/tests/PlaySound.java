package tests;

import filler.core.Bridge;
import filler.sound.Audio;

public class PlaySound extends Bridge {

    @Override
    public void create() {

        Audio gunshot = new Audio("./res/gunshot.wav", Audio.LOOP);
        gunshot.play();

        gunshot.pause();

        gunshot.resume();
    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }
}
