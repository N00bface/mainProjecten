package main;

import objects.Tuple;

import java.util.ArrayList;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class Resources {
    private static String[] substanceList;
    private static ArrayList<Tuple<String, Double>> substances;

    public static void setSubstanceList(String[] list) {
        substanceList = list;
    }

    public static String[] getSubstanceList() {
        return substanceList;
    }

    public static void setSubstances(ArrayList<Tuple<String, Double>> substances) {
        Resources.substances = substances;
    }

    public static ArrayList<Tuple<String, Double>> getSubstances() {
        return substances;
    }
}
