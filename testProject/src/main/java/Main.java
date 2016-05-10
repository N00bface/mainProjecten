import java.util.Random;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("100");
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String out = "";
            for (int j = 0; j < 100; j++) {
                out += random.nextInt(999999) + " ";
            }
            out += random.nextInt(999999);
            System.out.println(out);
        }
    }
}
