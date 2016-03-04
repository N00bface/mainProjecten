import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestgevallen = sc.nextInt();
        for (int i = 0; i < aantalTestgevallen; i++) {
            int aantalEmmers = sc.nextInt();
            System.out.println(i + 1 + " " + getAnswer(aantalEmmers, sc));
        }

    }

    public static String getAnswer(int aantalEmmers, Scanner sc) {
        int[] emmerInhouden = new int[aantalEmmers];
        int[] emmerMaxInhouden = new int[aantalEmmers];
        int gewenst = sc.nextInt();
        for (int i = 0; i < aantalEmmers; i++) {
            emmerInhouden[i] = sc.nextInt() - 1;
            emmerMaxInhouden[i] = sc.nextInt() - 1;
        }
        int aantalInstructies = 0;
        int dichtstebij;
        while (!bevatGewensteInhoud(gewenst, emmerInhouden)) {
            //probeer inhouden op andere emmer over te gieten
            //vind emmer het dichtste bij de gewenste inhoud
            dichtstebij = getDichtstebij(emmerInhouden, gewenst);
            System.out.println(dichtstebij);
            if (gewenst < emmerInhouden[dichtstebij]) {
                int meesteCapaciteit = getMeesteCap(emmerInhouden, emmerMaxInhouden, dichtstebij);
                emmerInhouden[meesteCapaciteit] += Math.abs(gewenst - emmerInhouden[dichtstebij]);
                emmerInhouden[dichtstebij] -= Math.abs(gewenst - emmerInhouden[dichtstebij]);
            } else {
                int meesteInhoud = getMeesteInhoud(emmerInhouden, emmerMaxInhouden, dichtstebij);
                emmerInhouden[meesteInhoud] -= Math.abs(gewenst - emmerInhouden[dichtstebij]);
                emmerInhouden[dichtstebij] += Math.abs(gewenst-emmerInhouden[dichtstebij]);
            }
            System.out.println(Arrays.toString(emmerInhouden));
            aantalInstructies++;
        }
        return String.valueOf(aantalInstructies);

        //emmerinhouden ingevuld
        //overgietinstucties
    }

    private static int getMeesteInhoud(int[] emmerInhouden, int[] emmerMaxInhouden, int dichtstebij) {
        int verschil = 0, verchilindex = 0;
        for (int i = 0; i < emmerInhouden.length; i++) {
            if (emmerInhouden[i] > verschil && i != dichtstebij) {
                verschil = emmerInhouden[i];
                verchilindex = i;
            }
        }
        return verchilindex;
    }

    private static int getMeesteCap(int[] emmerInhouden, int[] emmerMaxInhouden, int dichtstebij) {
        int verschil = 0, verchilindex = 0;
        for (int i = 0; i < emmerInhouden.length; i++) {
            if (Math.abs(emmerInhouden[i] - emmerMaxInhouden[i]) > verschil && i != dichtstebij) {
                verschil = Math.abs(emmerInhouden[i] - emmerMaxInhouden[i]);
                verchilindex = i;
            }
        }
        return verchilindex;
    }

    private static int getDichtstebij(int[] emmerInhouden, int gewenst) {
        int verschil = 0;
        int verschilindex = 0;
        for (int i = 0; i < emmerInhouden.length; i++) {
            if (verschil < Math.abs(emmerInhouden[i] - gewenst)) {
                verschil = Math.abs(emmerInhouden[i] - gewenst);
                verschilindex = i;
            }
        }
        return verschilindex;
    }

    private static boolean bevatGewensteInhoud(int gewenst, int[] emmerInhouden) {
        for (int anEmmerInhouden : emmerInhouden) {
            if (anEmmerInhouden == gewenst) {
                return true;
            }
        }
        return false;
    }
}
