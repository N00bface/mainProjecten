/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekenmachine;

/**
 *
 * @author Jari
 */
public class Haakjes {

    public static String HaakjesVervangen(String str) {
        while(HaakjesTesten(str)== true) {
            str = str.replace(str.substring(str.indexOf("("), str.indexOf(")")), String.valueOf(Berekenen.Base(str.substring(str.indexOf("(") + 1, str.indexOf(")") - 1))));
        }
        return str;
    }

    public static boolean HaakjesTesten(String str) {
        if (str.contains("(") && str.contains(")")) {
            return true;
        } else {
            return false;
        }
    }
}
