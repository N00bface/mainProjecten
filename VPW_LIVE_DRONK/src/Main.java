import java.awt.*;
import java.util.Scanner;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point plaats = new Point(0, 0);
        int aantalTestgevallen = sc.nextInt();
        for (int i = 0; i < aantalTestgevallen; i++) {
            int aantalStappen = sc.nextInt();
            String line = sc.nextLine();
            for (int j = 0; j < aantalStappen+1; j++) {
                String richting = line.split(" ")[j];
                //System.out.println(richting);
                switch (richting) {
                    case "N":
                        plaats.y++;
                        break;
                    case "O":
                        plaats.x++;
                        break;
                    case "Z":
                        plaats.y--;
                        break;
                    case "W":
                        plaats.x--;
                        break;
                    default:
                        //System.out.println(plaats.x + " "+plaats.y);
                        //System.out.println("test");
                }

            }

            System.out.println(i + 1 + " " + plaats.x + " " + plaats.y);plaats = new Point(0,0);
        }
    }
}
