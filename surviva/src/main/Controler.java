package main;

import java.io.IOException;

/**
 * Created by Jari on 23/12/2015.
 */
public class Controler {
    public static void main(String[] args) throws IOException {
        Environment env = new Environment();
        env.newLevel(1);
    }

    public static void pauzeGame() {

    }

    /**
     * stop the game
     */
    public static void stopGame() {
        System.exit(0);
    }
}
