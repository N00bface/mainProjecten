import com.intellij.json.psi.JsonArray;
import com.intellij.json.psi.impl.JsonArrayImpl;
import org.json.JSONArray;
import org.json.JSONException;
import sun.plugin.javascript.JSObject;

import java.util.Scanner;

/**
 * @author Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aantalTestGevallen = sc.nextInt();
        for (int i = 0; i < aantalTestGevallen;i++) {
            System.out.println(getAnswer(sc.nextLine()));
        }
    }

    public static String getAnswer(String line) {
        int aantalMeetpunten = getMeetpunten(line);
        for (String punt: line.split(" ") ){
            if (!punt.equals(String.valueOf(aantalMeetpunten))){

            }
        }
    }

    private static int getMeetpunten(String line) {
        return Integer.parseInt(line.split(" ")[0]);
    }
}
