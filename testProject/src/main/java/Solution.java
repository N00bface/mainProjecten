import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    private static final int NUM_BEKERS = 90000;
    private static char[] bekers;


    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("/home/jari/github/occ.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 1000; i++) {
                System.out.println("i = " + i);
                bw.write(run() + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static int run() {
        create();
        int guess = 0;
        while (true) {
            guess++;
//            System.out.println("~~~~~~~~~~~~~~~~~~~~BEGIN OF " + guess + "~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            /*for (int i = 0; i < NUM_BEKERS; i++) {
                System.out.print("^ ");
            }
            System.out.print("\n");
            for (int i = 0; i < NUM_BEKERS; i++) {
                System.out.print("? ");
            }
            System.out.print("\n\n\n");*/
            int getI = getGuess();
            /*for (int i = 0; i < NUM_BEKERS; i++) {
                System.out.print("^ ");
            }
            System.out.print("\n");
            for (int i = 0; i < NUM_BEKERS; i++) {
                if (i == getI)
                    System.out.print(bekers[i] + " ");
                else
                    System.out.print("? ");
            }*/
//            System.out.print("\n");
//            System.out.println("PLAYER choses cup " + getI);
            if (bekers[getI] == '!') {
//                System.out.println("PLAYER has found the cup in " + (guess + 1) + " guesses");
//                System.out.println("----------------END OF GAME----------------");
                return guess;
            } else
//                System.out.println("PLAYER was wrong");
//            System.out.println("~~~~~~~~~~~~~~~~~~~~END OF " + guess + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            shuffle();
        }
    }

    private static int getGuess() {
        return new Random().nextInt(NUM_BEKERS);
    }

    private static void create() {
        bekers = new char[NUM_BEKERS];
        shuffle();
    }

    private static void shuffle() {
        int index = new Random().nextInt(NUM_BEKERS);
        Arrays.fill(bekers, '#');
        bekers[index] = '!';
    }
}