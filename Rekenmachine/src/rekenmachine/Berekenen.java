/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekenmachine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jari
 */
class Berekenen {

    public static ArrayList<Character> sbewerkingen = new ArrayList<Character>();
    public static ArrayList<Character> abewerkingen = new ArrayList();
    public static ArrayList<Integer> index = new ArrayList();
    public static ArrayList factoren = new ArrayList();

    public static double Base(String str) {
        double temp = 0;
        //soorten bewerkingen vinden
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == ':') {
                if (sbewerkingen.contains(str.charAt(i)) == false) {
                    sbewerkingen.add((char) str.charAt(i));
                }
            }
        }
        //aantal bewerkingen (van dezelfde soort) vinden
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == ':') {
                abewerkingen.add(str.charAt(i));
                index.add(i);
            }
        }
        //uitwerken
        for (int i = 0; i <= str.length(); i++) {
            if (i == 0) {
                try {
                    temp = Double.parseDouble(str.substring(0, (index.get(0)) - 1));
                    index.remove(index.get(i));
                } catch (NumberFormatException x) {
                    temp = Double.parseDouble(str.substring(0, (index.get(0))));
                    index.remove(index.get(i));
                }
            } else {
                if (i == index.get(index.size()-1)) {
                    switch (abewerkingen.get(index.get(index.size()))) {
                        case '*':
                            temp = temp * Double.parseDouble(str.substring(index.get(index.size()) + 1, str.length()));
                        case ':':
                            temp = temp / Double.parseDouble(str.substring(index.get(index.size()) + 1, str.length()));
                        case '+':
                            temp = temp + Double.parseDouble(str.substring(index.get(index.size()) + 1, str.length()));
                        case '-':
                            temp = temp - Double.parseDouble(str.substring(index.get(index.size()) + 1, str.length()));
                    }
                    return temp;
                } else {
                    if (index.get(0) == i) {
                        switch (abewerkingen.get(index.get(0))) {
                            case '*':
                                temp = temp * Double.parseDouble(str.substring(index.get(0) + 1, index.get(1) - 1));
                            case ':':
                                temp = temp / Double.parseDouble(str.substring(index.get(0) + 1, index.get(1) - 1));
                            case '+':
                                temp = temp + Double.parseDouble(str.substring(index.get(0) + 1, index.get(1) - 1));
                            case '-':
                                temp = temp - Double.parseDouble(str.substring(index.get(0) + 1, index.get(1) - 1));
                        }
                    }
                }
            }
        }
        return 0;

    }
}
