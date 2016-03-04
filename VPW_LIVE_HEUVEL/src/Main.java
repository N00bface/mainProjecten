import java.util.Scanner;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = sc.nextInt();
        for (int i = 0; i < aantalTestGevallen; i++) {
            int aantalSprongen = sc.nextInt();
            int[] sprongDuren = new int[aantalSprongen];
            for (int j = 0; j < sprongDuren.length; j++) {
                sprongDuren[j] = sc.nextInt();
            }
            int score = 0;
            for (int sprongduur: sprongDuren){
                if (sprongduur > 4){
                    if (sprongduur > 8){
                        if (sprongduur > 12){
                            score += 25*4+100*4+500*4+1000*(sprongduur-12);
                        }else {
                            score += 25*4+100*4+500*(sprongduur-8);
                        }
                    }else {
                        score += 25*4+100*(sprongduur-4);
                    }
                }else {
                    score += 25*sprongduur;
                }
            }
            System.out.println(i+1 + " "+score);
        }
    }
}
