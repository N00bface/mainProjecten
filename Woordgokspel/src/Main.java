import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/**
 * @author Jari Van Melckebeke
 * @since 21.07.16
 */
public class Main {
    private static String[] woordenlijst;
    private static int round;

    public static void main(String[] args) throws IOException {
        woordenlijst = getWordList();
        round = 1;
        Player p1 = new Player("Bob");
        Player p2 = new Player("Bab");
        String woord = woordenlijst[new Random().nextInt(99)];
        while (true) {
            String w1 = woordenlijst[p1.getGuess()];
            String w2 = woordenlijst[p2.getGuess()];
            System.out.println(p1.getName() + " guesses " + w1);
            System.out.println(p2.getName() + " guesses " + w2);
            if (Objects.equals(w1, woord)) {
                System.out.println(p1.getName() + " guessed the word in " + p1.getGuess() + " guesses , it was " + woord);
                break;
            } else if (w2.equals(woord)) {
                System.out.println(p2.getName() + " guessed the word in " + p2.getGuess() + " guesses ,it was " + woord);
                break;
            }
        }
    }

    private static String[] getWordList() throws IOException {
        File file = new File("/home/jari/github/mainProjecten/Woordgokspel/src/words.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String[] arr = new String[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }
        return arr;
    }
}
