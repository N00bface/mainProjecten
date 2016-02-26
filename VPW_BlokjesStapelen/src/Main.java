import java.util.Scanner;

/**
 * Created by jari on 13/01/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestgevallen = sc.nextInt();
        for (int i = 0; i < aantalTestgevallen; i++) {
            int aantal = sc.nextInt();
            int aantalBlokjes = 0;
            for (int j = 0; j <= aantal; j++) {
                aantalBlokjes += Math.pow(j,3);
            }
            System.out.println(aantalBlokjes);
        }

    }
}
