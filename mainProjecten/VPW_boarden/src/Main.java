import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by jari on 04.01.16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testgevallen = sc.nextInt();
        ArrayList<String> voorbeeldInvoerArrayList = new ArrayList<>();
        //System.out.println("aantal testgevallen: " + testgevallen);
        ArrayList<Integer> aantalItemsinLijst = new ArrayList<>();
        int wachtijd;
        for (int i = 0; i < testgevallen; i++) {
            aantalItemsinLijst.add(sc.nextInt());
            voorbeeldInvoerArrayList.add(String.valueOf(aantalItemsinLijst));
            for (int j = 0; j < aantalItemsinLijst.get(i); j++) {
                voorbeeldInvoerArrayList.add(sc.next());
            }
        }
        for (int i = 0; i < testgevallen; i++) {

            wachtijd = 1;
            //System.out.println(i+" "+aantalItemsinLijst.get(i));
            voorbeeldInvoerArrayList.remove(0);
            String[] sublijst = new String[aantalItemsinLijst.get(i)];
            sublijst = (voorbeeldInvoerArrayList.subList(0, aantalItemsinLijst.get(i))).toArray(sublijst);
            int aantalItemsinSublijst = sublijst.length;
            for (int j = 0; j < aantalItemsinSublijst; j++) {
                voorbeeldInvoerArrayList.remove(0);
            }
            for (int j = 0; j < aantalItemsinSublijst; j++) {
                try {
                    //System.out.println(Arrays.toString(sublijst));
                    if (Integer.parseInt(sublijst[j]) < Integer.parseInt(sublijst[j + 1])) {
                        wachtijd++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            System.out.println((i + 1) + " " + wachtijd);

        }
    }
}
