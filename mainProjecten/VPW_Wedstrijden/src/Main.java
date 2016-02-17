import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final char[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = sc.nextInt();
        for (int i = 0; i < aantalTestGevallen; i++) {
            char[] teams = getTeams(sc.nextInt());
            int aantalWedstrijden = sc.nextInt();
            //System.out.println(aantalWedstrijden);
            String[] wedstrijdInputs = getWedstrijdInputs(sc, aantalWedstrijden);
            int[] algemeneScores = getAlgemeneScores(wedstrijdInputs, teams);
            System.out.println(Arrays.toString(algemeneScores));
            if (doublicates(algemeneScores.clone())) {
                //System.out.println("doubles");
                int maximumScore = getMaximumscore(algemeneScores);
                String overgebleven = getDoublicates(algemeneScores, maximumScore);
                int[] totaalScores = getTotaalScores(overgebleven, wedstrijdInputs, aantalWedstrijden);
                System.out.println(i + 1 + " " + getDoublicates(totaalScores, getMaximumscore(totaalScores)));
            } else {
                System.out.println(i + 1 + " " + getDoublicates(algemeneScores, getMaximumscore(algemeneScores)));
            }
        }

    }

    private static int[] getTotaalScores(String overgebleven, String[] wedstrijdInputs, int aantalWedstrijden) {
        int[] apartescores = new int[overgebleven.length()];
        Arrays.fill(apartescores, 0);
        for (String wedstrijdInput : wedstrijdInputs) {
            for (char team : overgebleven.toCharArray()) {
                if (wedstrijdInput.contains(String.valueOf(team))) {
                    apartescores[overgebleven.indexOf(team)] += wedstrijdInput.charAt(wedstrijdInput.indexOf(team) + 2);
                }
            }
        }
        return apartescores;
    }

    private static int getMaximumscore(int[] algemeneScores) {
        int out = 0;
        for (int score : algemeneScores) {
            if (out < score) {
                out = score;
            }
        }
        return out;
    }

    private static String getDoublicates(int[] algemeneScores, int maximum) {
        String overgebleven = "";
        for (int i = 0; i < algemeneScores.length; i++) {
            if (algemeneScores[i] == maximum) {
                overgebleven += alpha[i];
            }
        }
        return overgebleven;
    }

    private static boolean doublicates(int[] algemeneScores) {
        Arrays.sort(algemeneScores);
        return algemeneScores[algemeneScores.length-1] == algemeneScores[algemeneScores.length - 2];
    }

    private static int[] getAlgemeneScores(String[] wedstrijdInputs, char[] teams) {
        int[][] wedstrijdscores = new int[teams.length][wedstrijdInputs.length];
        int[] out = new int[teams.length];
        Arrays.fill(out, 0);
        for (int[] wedstrijdscore : wedstrijdscores) Arrays.fill(wedstrijdscore, 0);
        wedstrijdscores = getGameScores(wedstrijdInputs, wedstrijdscores);
        return getAlgScore(wedstrijdscores, out);
    }

    private static int[][] getGameScores(String[] wedstrijdInputs, int[][] wedstrijdscores) {
        for (int i = 0; i < wedstrijdInputs.length; i++) {
            char team1 = wedstrijdInputs[i].charAt(0);
            int score1 = wedstrijdInputs[i].charAt(2);
            char team2 = wedstrijdInputs[i].charAt(4);
            int score2 = wedstrijdInputs[i].charAt(6);
            if (score1 > score2) wedstrijdscores[alphabet.indexOf(team1)][i] += 3;
            else if (score1 == score2) {
                wedstrijdscores[alphabet.indexOf(team1)][i]++;
                wedstrijdscores[alphabet.indexOf(team2)][i]++;
            } else wedstrijdscores[alphabet.indexOf(team2)][i] += 3;
        }
        return wedstrijdscores;
    }

    private static int[] getAlgScore(int[][] wedstrijdscores, int[] out) {
        for (int i = 0; i < wedstrijdscores.length; i++) {
            for (int j = 0; j < wedstrijdscores[i].length; j++) {
                out[i] += wedstrijdscores[i][j];
            }
        }
        return out;
    }

    private static String[] getWedstrijdInputs(Scanner sc, int i) {
        String input = "";
        for (int j = 0; j < i; j++) {
            input += getLine(sc) + "#";
        }
        //System.out.println(input);
        return input.split("#");
    }

    private static String getLine(Scanner sc) {
        return sc.next()+" "+sc.next()+" "+sc.next()+" "+sc.next();
    }

    private static char[] getTeams(int aantalTeams) {
        return alphabet.substring(0, aantalTeams).toCharArray();
    }
}
