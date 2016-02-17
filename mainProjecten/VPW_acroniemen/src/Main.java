import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int acroniemInvoer = Integer.parseInt(sc.nextLine());
        ArrayList<String> woorden = new ArrayList<>();
        ArrayList<String> acroniemen = new ArrayList<>();
        for (int i = 0; i < acroniemInvoer; i++) {
            acroniemen.add(sc.nextLine());
        }
        int woordenInvoer = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < woordenInvoer; i++) {
            woorden.add(sc.nextLine());
        }
        String woord;
        char punt;
        for (int i = 0; i < woorden.size(); i++) {

            woord = woorden.get(i);
            woord = woord.toUpperCase();

            for (int j = 0; j < woord.length(); j++) {
                woord = woord.trim();
                if (!Character.isAlphabetic(woord.charAt(j))) {
                    punt = woord.charAt(j);
                    woord = woord.replace(String.valueOf(punt), "");
                }
            }
            woorden.set(i, woord);
        }
        int aantalCombinaties = 0;
        int index = 1;
        String kans;
        String wrd;
        int volgnummer = 0;
        boolean[] boolChar;
        boolean check = true;
        for (int i = 0; i < acroniemen.size(); i++) {
            kans = acroniemen.get(i);
            kans = kans.trim();
            kans = kans.toLowerCase();
            acroniemen.set(i, kans);

        }

        for (int i = 0; i < woorden.size(); i++) {
            wrd = woorden.get(i);
            wrd = wrd.replace(" ", "");
            wrd = wrd.toLowerCase();
            woorden.set(i, wrd);
        }
        for (String word : woorden) {
            for (String acroniem : acroniemen) {
                if (acroniem.charAt(0) == word.charAt(0)) {
                    boolChar = new boolean[acroniem.length()];
                    for (int i = 0; i < word.length() && volgnummer < acroniem.length(); i++) {
                        if (acroniem.charAt(volgnummer) == word.charAt(i)) {

                            boolChar[volgnummer] = true;
                            volgnummer++;
                            i++;
                        }


                    }
                    volgnummer = 0;
                    for (boolean bool : boolChar) {
                        if (!bool) {
                            check = false;
                        }
                    }
                    if (check) {
                        aantalCombinaties++;
                    }
                }
                check = true;
            }
            System.out.println(index + " " + aantalCombinaties);
            aantalCombinaties = 0;
            index++;
        }
    }
}
