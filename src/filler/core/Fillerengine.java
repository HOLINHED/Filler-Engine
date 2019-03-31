package filler.core;

@SuppressWarnings("FieldCanBeLocal")
public class Fillerengine implements Runnable{

    private Window window;
    private Thread thread;
    private boolean running = false;
    private double UPDATE_CAP = 1.0 / 60.0;

    public Fillerengine(int width, int height, Bridge game, String... title) {

        window = new Window(width, height, game, title);
    }

    protected void start() {

        thread = new Thread(this);

        thread.run();
    }

    @Override
    public void run() {

        running = true;

        boolean render;
        double firstTime;
        double lastTime = System.nanoTime() / 1e9;
        double passedTime;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps;

        while (running) {

            render = false;

            firstTime = System.nanoTime() / 1e9;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP) {

                unprocessedTime -= UPDATE_CAP;
                render = true;

                if (frameTime >= 1.0) {

                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    window.sendFps(fps);
                }
            }

            if (render) {
                window.update();
                frames += 1;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("unused")
    protected void setFrameRate(final int frameRate) {
        this.UPDATE_CAP = 1.0 / (double)frameRate;
    }
}
