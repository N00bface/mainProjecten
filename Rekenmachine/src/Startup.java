package rekenmachine;

import java.util.ArrayList;

/**
 * @author Jari Van Melckebeke
 */
public class Startup {

    public static ArrayList bewerkingen = new ArrayList();

    public static String HaakjesVervangen(String str) {
        //nog eens op haakjes controleren in de haakjes (2*(5-(3+9))
        while (str.equals(HaakjesControle(str))) {
            str = str.replace(HaakjesControle(str), RekenUit(HaakjesControle(str)));
        }

    }

    public static String HaakjesControle(String str) {
        if (str.contains("(") && str.contains(")")) {
            return str.substring(str.indexOf("(") + 1, str.indexOf(")") - 1);
        } else {
            return str;
        }
    }

    public static double RekenUit(String str) {
        //doubles eruit halen
        for (int i = 0; i <= str.length(); i++) {                                   //  de bewerkingen in een aparte lijst zetten (geen dubbele) voor dan te kunnen gebruiken om de douibles om te zetten
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == ':') {
                if (bewerkingen.contains(str.charAt(i)) == false) {
                    bewerkingen.add(str.charAt(i));
                }
            }
        }
        char con;

    }
}
