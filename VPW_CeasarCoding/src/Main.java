import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String alfabet = " abcdefghijklmnopqrstuvwxyz".toUpperCase();
        Scanner sc = new Scanner(System.in);
        int aantalTestgevallen = Integer.parseInt(sc.nextLine());
        String out = "";
        for (int i = 0; i < aantalTestgevallen; i++) {
            int sleutel = sc.nextInt() + 1;
            String code;
            code = sc.nextLine();
            code = code.replaceFirst(" ", "");
            char letter;
            String oplossing = "";
            //System.out.println(code.length());
            char[] chars = new char[code.length()];
            for (int j = 0; j < code.length(); j++) {
                letter = code.charAt(j);
                if (Character.isAlphabetic(letter) || letter == ' ') {
                    try {
                        chars[j] = alfabet.charAt(alfabet.indexOf(letter) - sleutel + 1);
                    } catch (StringIndexOutOfBoundsException e) {
                        chars[j] = alfabet.charAt(28 - (Math.abs(alfabet.indexOf(letter) - sleutel)));

                    }
                } else {
                    chars[j] = code.charAt(j);
                }
            }
            //System.out.println(Arrays.toString(chars));
            oplossing = new String(chars);
            System.out.println(oplossing);
        }
    }
}
