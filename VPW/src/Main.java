import com.sun.xml.internal.fastinfoset.sax.SystemIdResolver;
import com.sun.xml.internal.fastinfoset.util.QualifiedNameArray;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jari on 30/12/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("geef het nummer van de opgave op,\ndit geldt als volgt:\n1  acroniemen\n2  boarden\n3  plumber\n4  wedstrijden\n5  wekker");
        switch (sc.nextInt()) {
            case 1:
                acroniemen();
                break;
            case 2:
                boarden();
                break;
            case 3:
                plumber();
                break;
            case 4:
                wedstrijden();
                break;
            case 5:
                wekker();
                break;
            default:
                System.exit(0);
        }
    }

    private static void wekker() {
        System.out.println("\n\n\n");
        System.out.println("-----------------invoer-----------------");
        System.out.println("    --------voorbeeld invoer--------");
    }

    private static void wedstrijden() {
        System.out.println("\n\n\n");
        System.out.println("-----------------invoer-----------------");
        System.out.println("    --------voorbeeld invoer--------");
    }

    private static void plumber() throws IOException {
        System.out.println("\n\n\n");
        System.out.println("-----------------invoer-----------------");
        System.out.println("    --------voorbeeld invoer--------");
        File inputfile = new File("/home/jari/Documents/vpw/voorbeeld invoer/plumber.txt");
        FileReader inputFileReader = new FileReader(inputfile);
        BufferedReader inputBufferedReader = new BufferedReader(inputFileReader);
        String line = null;
        ArrayList<String> input = new ArrayList<String>();
        String[][] speelveld;
        while ((line = inputBufferedReader.readLine()) != null) {
            input.add(line);
        }
        int x, y;
        int aantaltestgevallen = Integer.parseInt(input.get(0));
        boolean possible = true;
        int aantalKeer = 1;
        input.remove(0);
        int width, heigth;
        char outChar;
        System.out.println("----proces----");
        for (int i = 0; i < aantaltestgevallen; i++) {
            width = Integer.parseInt(input.get(0).split(" ")[0]);
            heigth = Integer.parseInt(input.get(0).split(" ")[1]);
            input.remove(0);
            speelveld = new String[heigth][width];
            for (int j = 0; j < heigth; j++) {
                speelveld[j] = input.get(0).split(" ");
                input.remove(0);
            }
            x = 0;
            y = 0;
            while (possible) {
                System.out.println("loop gestart");
                try {
                    switch (speelveld[y][x]) {
                        case "NZ":
                            if (speelveld[y + 1][x].contains("N")) {
                                speelveld[y][x] = null;
                                System.out.println("y plus 1");
                                y++;
                                aantalKeer++;
                                break;
                            }
                            if (speelveld[y - 1][x].contains("Z")) {
                                speelveld[y][x] = null;
                                y--;
                                aantalKeer++;
                                break;
                            }
                            possible = false;
                            x = 0;
                            y = 0;
                            break;
                        case "OW":
                            if (speelveld[y][x - 1].contains("O")) {
                                speelveld[y][x] = null;
                                x--;
                                aantalKeer++;
                                break;
                            }
                            if (speelveld[y][x + 1].contains("W")) {
                                speelveld[y][x] = null;
                                x++;
                                aantalKeer++;
                                break;
                            }
                            possible = false;
                            x = 0;
                            y = 0;
                            break;
                        case "NW":
                            if (speelveld[y - 1][x].contains("Z")) {
                                speelveld[y][x] = null;
                                y--;
                                aantalKeer++;
                                break;
                            }
                            if (speelveld[y][x - 1].contains("O")) {
                                speelveld[y][x] = null;
                                x--;
                                aantalKeer++;
                                break;
                            }
                            possible = false;
                            x = 0;
                            y = 0;
                            break;
                        case "NO":
                            if (speelveld[y - 1][x].contains("Z")) {
                                speelveld[y][x] = null;
                                y--;
                                aantalKeer++;
                                break;
                            }
                            if (speelveld[y][x + 1].contains("W")) {
                                speelveld[y][x] = null;
                                x++;
                                aantalKeer++;
                                break;
                            }
                            possible = false;
                            x = 0;
                            y = 0;
                            break;
                        case "ZW":
                            if (speelveld[y][x - 1].contains("O")) {
                                speelveld[y][x] = null;
                                x--;
                                aantalKeer++;
                                break;
                            }
                            if (speelveld[y + 1][x].contains("N")) {
                                speelveld[y][x] = null;
                                y++;
                                aantalKeer++;
                                break;
                            }
                            possible = false;
                            x = 0;
                            y = 0;
                            break;
                        case "ZO":
                            if (speelveld[y][x + 1].contains("W")) {
                                speelveld[y][x] = null;
                                x++;
                                aantalKeer++;
                                break;
                            }
                            if (speelveld[y + 1][x].contains("N")) {
                                speelveld[y][x] = null;
                                y++;
                                aantalKeer++;
                                break;
                            }
                            possible = false;
                            x = 0;
                            y = 0;
                            break;
                        default:
                            System.out.println("default!");
                            x = 0;
                            y = 0;
                            possible = false;
                            break;
                    }
                } catch (NullPointerException | IndexOutOfBoundsException e) {
                    x = 0;
                    y = 0;
                    possible = false;
                }
                System.out.println();
                for (String[] yas : speelveld) {
                    System.out.println(Arrays.toString(yas));
                }
            }
            System.out.println(i + 1 + " " + aantalKeer);
            aantalKeer = 1;
            possible = true;
        }


    }

    private static void boarden() throws IOException {
        System.out.println("\n\n\n");
        System.out.println("-----------------invoer-----------------");
        System.out.println("    --------voorbeeld invoer--------");
        File voorbeeldInvoer = new File("/home/jari/Documents/vpw/wedstrijd invoer/boarden.txt");
        FileReader voorbeeldInputFileReader = new FileReader(voorbeeldInvoer);
        BufferedReader voorbeeldInputBufferedReader = new BufferedReader(voorbeeldInputFileReader);
        String line = null;
        ArrayList<String> voorbeeldInvoerArrayList = new ArrayList<>();
        while ((line = voorbeeldInputBufferedReader.readLine()) != null) {
            System.out.println(line);
            voorbeeldInvoerArrayList.add(line);
        }
        System.out.println("-----------------start-----------------");
        int testgevallen = Integer.parseInt(voorbeeldInvoerArrayList.get(0));
        voorbeeldInvoerArrayList.remove(0);
        System.out.println("aantal testgevallen: " + testgevallen);
        int aantalItemsinLijst;
        int wachtijd;
        for (int i = 0; i < testgevallen; i++) {
            //System.out.println("---testgeval: "+(i+1)+"---");
            wachtijd = 1;
            aantalItemsinLijst = Integer.parseInt(voorbeeldInvoerArrayList.get(0));
            voorbeeldInvoerArrayList.remove(0);
            //System.out.println("aantal items in sublijst: " + aantalItemsinLijst);
            String[] sublijst = new String[aantalItemsinLijst];
            sublijst = (voorbeeldInvoerArrayList.subList(0, aantalItemsinLijst)).toArray(sublijst);
            //String[] sublijst = (String[]) tussenlijst.toArray();
            //System.out.println("items in sublijst: " + sublijst);
            //System.out.println("items in lijst: " + voorbeeldInvoerArrayList);
            int aantalItemsinSublijst = sublijst.length;
            for (int j = 0; j < aantalItemsinSublijst; j++) {
                voorbeeldInvoerArrayList.remove(0);
            }
            //System.out.println("items in lijst-sublijst: " + voorbeeldInvoerArrayList.toString());
            for (int j = 0; j < aantalItemsinSublijst; j++) {
                try {
                    if (Integer.parseInt(sublijst[j]) < Integer.parseInt(sublijst[j + 1])) {
                        wachtijd++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            System.out.println((i + 1) + " " + wachtijd);
            wachtijd = 0;

        }
    }


    private static void acroniemen() throws IOException, StringIndexOutOfBoundsException {
        System.out.println("\n\n\n");
        System.out.println("-----------------invoer-----------------");
        System.out.println("    --------voorbeeld invoer--------");
        File inputfile = new File("/home/jari/Documents/vpw/voorbeeld invoer/acroniemen.txt");
        FileReader fileReader = new FileReader(inputfile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> inputArrayList = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            inputArrayList.add(line);
        }
        System.out.println("------verwerking----------");
        ArrayList<String> kansacroniemen = new ArrayList<String>();
        ArrayList<String> woorden = new ArrayList<String>();
        int aantalkansacroniemen;
        int aantalwoorden;
        //lees aantal kandidaatacroniemen
        aantalkansacroniemen = Integer.parseInt(inputArrayList.get(0));
        inputArrayList.remove(0);
        for (int j = 0; j < aantalkansacroniemen; j++) {
            kansacroniemen.add(inputArrayList.get(0));
            inputArrayList.remove(0);
        }
        System.out.println("items in algemene lijst na verwijdering: " + inputArrayList);
        aantalwoorden = Integer.parseInt(inputArrayList.get(0));
        inputArrayList.remove(0);
        woorden = inputArrayList;
        //elimineer interpunctie
        String woord;
        char punt;
        for (int i = 0; i < woorden.size(); i++) {
            //System.out.println("aantal keer in woorden-loop: " + (i + 1));
            woord = woorden.get(i);
            woord = woord.toUpperCase();

            for (int j = 0; j < woord.length(); j++) {
                //System.out.println("aantal keer in woord-loop: " + (j + 1));
                if (!Character.isAlphabetic(woord.charAt(j))) {
                    punt = woord.charAt(j);
                    woord = woord.replace(String.valueOf(punt), "");
                    System.out.println("bewerkt woord: " + woord);
                }
            }
            woorden.set(i, woord);
        }
        String kansacroniem;
        int aantalCombinaties = 0;
        int index = 1;
        String kans;
        String wrd;
        int volgnummer = 0;
        boolean[] boolChar;
        boolean check = true;
        for (int i = 0; i < kansacroniemen.size(); i++) {
            kans = kansacroniemen.get(i);
            kans = kans.trim();
            kans = kans.toLowerCase();
            kansacroniemen.set(i, kans);

        }

        for (int i = 0; i < woorden.size(); i++) {
            wrd = woorden.get(i);
            wrd = wrd.replace(" ", "");
            wrd = wrd.toLowerCase();
            woorden.set(i, wrd);
        }
        for (String word : woorden) {                                                                                   //itereer over elke kansacroniem
            for (String acroniem : kansacroniemen) {                                                                    //itereer over elk woord
                if (acroniem.charAt(0) == word.charAt(0)) {                                                             //als woord start met dezelfde letter -->
                    boolChar = new boolean[acroniem.length()];
                    for (int i = 0; i < word.length(); i++) {
                        //System.out.println("index " + i + " voor acroniem " + word);
                        try {
                            if (acroniem.charAt(volgnummer) == word.charAt(i)) {
                                //System.out.println("de " + acroniem.charAt(volgnummer) + " is hetzelfde bij " + acroniem + " en " + word);

                                //System.out.println("volgnummer: " + volgnummer + " voor woord: " + word);
                                boolChar[volgnummer] = true;
                                volgnummer++;
                                i++;
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            /*System.out.println("volgnummer: " + volgnummer);
                            System.out.println("i: " + i);
                            System.out.println("lengte woord: " + word.length());
                            System.out.println("lengte acroniem: " + acroniem.length());
                            System.out.println("boolChar: " + Arrays.toString(boolChar));*/
                        }

                    }
                    volgnummer = 0;
                    for (boolean bool : boolChar) {
                        if (!bool) {
                            check = false;
                            // System.out.println(word + " is geen acroniem voor " + acroniem);
                        }
                    }
                    if (check) {
                        //System.out.println(word + " is een acroniem voor " + acroniem);
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