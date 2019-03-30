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

        File<PlayerData> save = new File<>(player);

        File<PlayerData> load = new File<>("PLAYER");

        PlayerData loadf = load.data();

        System.out.println(loadf.getPos());
        System.out.println(loadf.created());
        System.out.println(loadf.getName());

    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }
}
