import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by jari on 14/01/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = sc.nextInt();
        for (int i = 0; i < aantalTestGevallen; i++) {
            String teller = sc.next();
            String noemer = sc.next();
            char[] tellers = teller.toCharArray();
            char[] noemers = noemer.toCharArray();
            Arrays.sort(tellers);
            Arrays.sort(noemers);

            for (int j = 0; j < tellers.length; j++) {
                for (int k = 0; k < noemers.length; k++) {
                    if (tellers[j] == noemers[k]) {
                        tellers[j] = noemers[k] = ' ';
                    }
                }
            }

            String out1 = "", out2 = "";
            for (char kar : tellers) {
                out1 += kar;
            }
            for (char kar2 : noemers) {
                out2 += kar2;
            }
            /*
            out1 = out1.trim();
            out2 = out2.trim();
            */
            out1 = out1.trim();
            out2 = out2.trim();
            out1 = out1.replaceAll(" ","");
            out2 = out2.replaceAll(" ","");
            if (out1.isEmpty()){
                out1 = "1";
            }
            if (out2.isEmpty()){
                out2 = "1";
            }
            System.out.println(out1 + " " + out2);
        }
    }
}
