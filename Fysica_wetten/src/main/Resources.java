package main;

import objects.CDatabase;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class Resources {
    private static String[] substanceList;
    private static CDatabase<String, Double> substances;

    public static void setSubstanceList(String[] list) {
        substanceList = list;
    }

    public static String[] getSubstanceList() {
        return substanceList;
    }

    public static void setSubstances(CDatabase<String, Double> substances) {
        Resources.substances = substances;
    }

    public static CDatabase<String, Double> getSubstances() {
        return substances;
    }
}
