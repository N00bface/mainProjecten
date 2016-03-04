import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestgevallen = sc.nextInt();
        for (int i = 0; i < aantalTestgevallen; i++) {
            ArrayList<String> stock = new ArrayList<String>();
            ArrayList<String> transacties = new ArrayList<>();
            int aantalStrock = sc.nextInt();
            for (int j = 0; j < aantalStrock; j++) {
                stock.add(String.valueOf(sc.nextInt()));
            }

            int aantalTransactie = sc.nextInt();
            for (int j = 0; j < aantalTransactie; j++) {
                transacties.add(String.valueOf(sc.nextInt()));
            }

            for (int j = 0; j < transacties.size(); j++) {
                if (Integer.parseInt(transacties.get(j)) < 0) {
                    //System.out.println(i + " " + j);
                    if (transacties.get(j).contains("-")) {
                        stock.remove((transacties.get(j).substring(1)));
                    } else {
                        stock.remove((transacties.get(j)));
                    }
                } else {
                    stock.add(String.valueOf(transacties.get(j)));
                }
                Arrays.sort(stock.toArray());
                System.out.println(i + 1 + " " + getOutput(stock));
            }

            Arrays.sort(stock.toArray());
            System.out.println(i + 1 + " " + getOutput(stock));
        }
    }

    private static String getOutput(ArrayList<String> stock) {
        ArrayList<Integer> stockClone = new ArrayList<>();
        for (String item : stock){
            stockClone.add(Integer.parseInt(item));
        }
        Arrays.sort(stockClone.toArray(new Integer[stockClone.size()]));
        //System.out.println(stockClone);
        String out = "";
        int streak =0;
        for (int i = 0; i < stockClone.size(); i++) {
            int streakindex = 0;
            for (int j = 0; j < stockClone.size(); j++) {
                if (!(stockClone.get(i)+j== stockClone.get(j)) && streakindex == 0){
                    out += " "+stockClone.get(i);
                }
                if (stockClone.get(i)+j== stockClone.get(j)) {
                    streakindex++;
                    streak = stockClone.get(j);
                    stockClone.remove(j);
                } else {
                    out += " " +stockClone.get(i) + "-" + streak;
                    streakindex = 0;
                    break;
                }
            }

            //if (streakindex > 0) {
                //stockClone.removeAll(stockClone.subList(i, streakindex));

        }
        return out;
    }
}
