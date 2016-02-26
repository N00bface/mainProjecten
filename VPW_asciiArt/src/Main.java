import java.util.ArrayList;
import java.util.Scanner;

/**
 * @autor Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestgevallen = sc.nextInt();
        for (int i = 0; i < aantalTestgevallen; i++) {
            int startGetal = sc.nextInt();
            int getal = (int) Math.pow(startGetal,2);
            ArrayList<Integer> getallen = new ArrayList<>();
            getallen.add(getal);
            while (getal != startGetal && getal != 1){
                int temp =0;
                for (int j = 0; j < String.valueOf(getal).length(); j++) {
                    temp+= Math.pow(Integer.parseInt(String.valueOf(String.valueOf(getal).charAt(j))),2);
                    //System.out.println("temp = " + temp);
                }
                //System.out.println("temp = " + temp);
                getal = temp;
                if (String.valueOf(getal).length() == 1 && getal != 1){
                    break;
                }
            }
            //System.out.println("getal = " + getal);
            if (getal == 1){
                System.out.println("JA");
            }else {
                System.out.println("NEE");
            }
        }
    }
}
