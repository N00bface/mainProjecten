package classes;

import java.util.ArrayList;

/**
 * Created by Jari on 22/11/2015.
 */
public class LettersSelecteren {
    public String run(String[] param) {
        String[] invoer = param[0].split("/");
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 1; i < Integer.parseInt(invoer[0]) + 1; i++) {
            String in = invoer[i];
            in.trim();
            int j;
            for (j = 0; j < in.length(); j++) {
                if (!Character.isDigit(in.charAt(j))) {
                    break;
                }
            }
            int num = Integer.parseInt(in.substring(0, j));
            System.out.println(num);
            String woord = in.substring(j);
            arrayList.add(String.valueOf(woord.charAt(num)));
        }
        String output = arrayList.toString();
        output.substring(1, output.length() - 1);
        output.trim();
        while (output.contains(",")) {
            output.replace(",", " ");
        }
        return output;
    }

}
