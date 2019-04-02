package filler.sound;

import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"WeakerAccess", "unused"})
public class SoundManager {

    private Map<String, Audio> sounds;

    public SoundManager(Audio background) {
        this();
        sounds.put("background", background);
        sounds.get("background").loop();
    }

    public SoundManager() {
        sounds = new HashMap<>();
    }

    public void play(String name) {

        final Audio temp = sounds.get(name);

        temp.play();
    }

    public void stop(String name) {

        final Audio temp = sounds.get(name);

        temp.stop();
    }

    public void stopAll() {
        sounds.forEach((k,v) -> v.stop());
    }

    public void add(String name, Audio sound) {
        sounds.put(name, sound);
    }

}
