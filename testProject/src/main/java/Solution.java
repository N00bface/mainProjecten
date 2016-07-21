import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        run("","");
    }

    private static void run(String curr_user, String curr_passwd) {
        new HttpURLConnection(new URL(curr_user+characters[i]+":"+curr_passwd+characters[j]));
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters.length; j++) {
                run(curr_user+characters[i],curr_passwd+characters[j]);
            }
        }
    }
}