import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = sc.nextInt();
        for (int i = 0; i < aantalTestGevallen; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();
            int totaal;
            for (int j = min; j < max ; j++) {
                totaal = 0;
                for (int k = 1; k < j; k++) {
                    if (j%k == 0){
                        totaal += k;
                    }
                }
                if (totaal%j == 0){
                    System.out.println(j + " "+(totaal/j+1));
                    break;
                }
                if (j == max-1){
                    System.out.println("GEEN");
                }
            }

        }
    }
}
