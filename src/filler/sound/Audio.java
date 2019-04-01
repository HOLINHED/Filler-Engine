package filler.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Audio {

    public static final boolean LOOP = true;
    public static final boolean NOLOOP = false;

    private Long currentFrame;
    private Clip clip;
    private String status;
    private AudioInputStream audioInputStream;
    private String filePath;

    public Audio(final String path) {

        filePath = path;

        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            assert clip != null;
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException |
                UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public Audio(final String path, boolean looping) {
        this(path);
        if (looping) clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {

        clip.start();

        status = "playing";
    }

    public void pause() {

        if (status.equals("paused")) return;

        currentFrame = clip.getMicrosecondPosition();

        clip.stop();

        status = "paused";
    }

    public void resume() {

        if (status.equals("playing")) return;

        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void jump(long c) {

        if (c > 0 && c < clip.getMicrosecondLength()) {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    public void resetAudioStream() {

        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException |
                UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
