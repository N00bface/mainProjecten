import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jari on 08.01.16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < aantalTestGevallen; i++) {
            String invoer = sc.nextLine();
            int startUur = Integer.parseInt(invoer.split(" ")[0]);
            int startMin = Integer.parseInt(invoer.split(" ")[1]);
            invoer = sc.nextLine();
            int doelUur = Integer.parseInt(invoer.split(" ")[0]);
            int doelMin = Integer.parseInt(invoer.split(" ")[1]);

            int minuut = startMin;
            int uur = startUur;

            int aantalAf =0,aantalBij = 0, aantalUurBij = 0,aantalUurAf = 0;
            int aantal1, aantal2,uurVerschil = 0;
            //minuten optellen
            while (minuut!=doelMin){
                aantalBij++;
                minuut++;
                if (minuut == 60){
                    minuut = 0;
                    aantalUurBij++;
                }
            }
            //minuten aftellen
            minuut = startMin;
            while (minuut != doelMin){
                aantalAf++;
                minuut--;
                if (minuut == -1){
                    minuut = 59;
                    aantalUurAf++;
                }
            }
            //vergelijken
            if (aantalAf<aantalBij){
                aantal1 = aantalAf;
                uurVerschil = -aantalUurAf;
            }else {
                aantal1 = aantalBij;
                uurVerschil = aantalUurBij;
            }

            aantalBij = aantalAf = 0;

            //uren optellen
            uur = startUur;
            while (uur!=doelUur){
                aantalBij++;
                uur++;
                if (uur == 24){
                    uur = 0;
                }
            }
            //uren aftellen
            uur = startUur;
            while (uur!= doelUur){
                aantalAf++;
                uur--;
                if (uur == -1){
                    uur = 23;
                }
            }
            //vergelijken
            if (aantalAf < aantalBij){
                aantal2 = aantalAf;
            }else {
                aantal2 = aantalBij;
            }
            System.out.println(i+1+" "+(aantal1+aantal2));

        }
    }
}
