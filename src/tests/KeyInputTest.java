package tests;

import filler.core.Bridge;

public class KeyInputTest extends Bridge {

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }

    @Override
    public void keyPressed() {
        switch(key.getKey()) {
            case 37: System.out.println("key 37 pressed!");break;
            case 38: System.out.println("key 38 pressed!");break;
            case 39: System.out.println("key 39 pressed!");break;
            case 40: System.out.println("key 40 pressed!");break;
        }
    }

    @Override
    public void keyReleased() {
        switch(key.getKey()) {
            case 37: System.out.println("key 37 released!");break;
            case 38: System.out.println("key 38 released!");break;
            case 39: System.out.println("key 39 released!");break;
            case 40: System.out.println("key 40 released!");break;
        }
    }
}
