import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = Integer.parseInt(sc.nextLine());
        String[][] speelveld;
        int x, y;
        int rangschikking = 1;
        int aantalKeer = 1;
        for (int i = 0; i < aantalTestGevallen; i++) {
            String breeddeHoogte = sc.nextLine();
            speelveld = new String[Integer.parseInt(breeddeHoogte.split(" ")[1])][Integer.parseInt(breeddeHoogte.split(" ")[0])];
            for (int j = 0; j < speelveld.length; j++) {
                speelveld[j] = sc.nextLine().split(" ");
            }
            x = 0;
            y = 0;
            boolean[] tryCatch = {false, false};
            boolean possible = true;
            if (speelveld[y][x].contains("N")) {
                while (possible) {
                    switch (speelveld[y][x]) {
                        case "NZ":
                            try {


                                if (speelveld[y - 1][x] != null && speelveld[y - 1][x].contains("Z")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    y--;
                                    break;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[0] = true;
                            } catch (NullPointerException ignored) {
                            }
                            try {
                                if (speelveld[y + 1][x] != null && speelveld[y + 1][x].contains("N")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    y++;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[1] = true;
                            }
                            if (tryCatch[0] && tryCatch[1]) {
                                possible = false;
                            }
                            tryCatch[0] = false;
                            tryCatch[1] = false;
                            possible = false;
                            break;
                        case "OW":
                            try {

                                if (speelveld[y][x - 1] != null && speelveld[y][x - 1].contains("O")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    x--;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[0] = true;
                            }
                            try {

                                if (speelveld[y][x + 1] != null && speelveld[y][x + 1].contains("W")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    x++;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[1] = true;
                            }
                            if (tryCatch[0] && tryCatch[1]) {
                                possible = false;
                            }
                            tryCatch[0] = false;
                            tryCatch[1] = false;
                            possible = false;
                            break;
                        case "NW":
                            try {

                                if (speelveld[y - 1][x] != null && speelveld[y - 1][x].contains("Z")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    y--;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[0] = true;
                            }
                            try {
                                if (speelveld[y][x + 1] != null && speelveld[y][x - 1].contains("O")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    x--;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[1] = true;
                            }
                            if (tryCatch[0] && tryCatch[1]) {
                                possible = false;
                            }
                            tryCatch[0] = false;
                            tryCatch[1] = false;
                            possible = false;
                            break;
                        case "NO":
                            try {
                                if (speelveld[y][x + 1] != null && speelveld[y][x + 1].contains("W")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    x++;
                                    break;
                                }
                            } catch (NullPointerException ignored) {

                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[0] = true;
                            }
                            try {
                                if (speelveld[y - 1][x] != null && speelveld[y - 1][x].contains("Z")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    y--;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[1] = true;
                            }
                            if (tryCatch[0] && tryCatch[1]) {
                                possible = false;
                            }
                            tryCatch[0] = false;
                            tryCatch[1] = false;
                            possible = false;
                            break;
                        case "ZW":
                            try {
                                if (speelveld[y][x - 1] != null && speelveld[y][x + 1].contains("O")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    x--;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[0] = true;
                            }
                            try {
                                if (speelveld[y + 1][x] != null && speelveld[y + 1][x].contains("N")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    y++;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[1] = true;
                            }
                            if (tryCatch[0] && tryCatch[1]) {
                                possible = false;
                            }
                            tryCatch[0] = false;
                            tryCatch[1] = false;
                            possible = false;

                            break;
                        case "ZO":
                            try {
                                if (speelveld[y][x + 1] != null && speelveld[y][x + 1].contains("W")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    x++;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[0] = true;
                            }
                            try {
                                if (speelveld[y + 1][x] != null && speelveld[y + 1][x].contains("N")) {
                                    speelveld[y][x] = null;
                                    aantalKeer++;
                                    y++;
                                    break;
                                }
                            } catch (NullPointerException ignored) {
                            } catch (IndexOutOfBoundsException e) {
                                tryCatch[1] = true;
                            }
                            if (tryCatch[0] && tryCatch[1]) {
                                possible = false;
                            }
                            tryCatch[0] = false;
                            tryCatch[1] = false;
                            possible = false;

                            break;
                        default:
                            System.out.println("default");
                            break;
                    }
                    System.out.println("----------" + rangschikking + "------------");
                    for (String[] rij : speelveld) {
                        System.out.println();
                        for (String kolom : rij) {
                            System.out.print(kolom + " ");
                        }
                    }
                    System.out.println("\n----------" + rangschikking + "------------");
                    System.out.println("\n\n");
                }
            } else {
                aantalKeer = 0;
            }
            if (i == aantalTestGevallen - 1) {
                System.out.println(rangschikking + " " + aantalKeer);
            } else {
                System.out.println(rangschikking + " " + aantalKeer);
            }
            aantalKeer = 1;
            possible = true;
            rangschikking++;
        }
    }
}
