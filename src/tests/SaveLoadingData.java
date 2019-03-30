package tests;

import filler.core.Bridge;
import filler.io.Data;
import filler.io.File;

public class SaveLoadingData extends Bridge {

    static class PlayerData extends Data {

        private int x;
        private int y;

        public PlayerData() {
            super("PLAYER");

            x = 100;
            y = 100;
        }

        public String getPos() {
            return "X: " + x + "  Y: " + y;
        }

    }

    @Override
    public void create() {

        PlayerData player = new PlayerData();

        try {
            File.save(player);
        } catch (Exception e) { e.printStackTrace(); }

        PlayerData load = (PlayerData) File.load("PLAYER");

        System.out.println(load.getPos());
        System.out.println(load.created());
        System.out.println(load.getName());

    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }
}
