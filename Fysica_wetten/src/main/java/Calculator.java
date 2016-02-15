package main.java;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class Calculator {
    public static String getMaxAngle(String substance1, String substance2) {
        CDatabase<String, Double> indexes = Resources.getSubstances();
        //System.out.println("substance2 = " + substance2);
        //System.out.println("Resources.getSubstances() = " + Resources.getSubstances().toString());
        double refractiveIndex = indexes.get(substance1) / indexes.get(substance2);
        //n*sin ^r = sin î
        double sinI = refractiveIndex * Math.sin(Math.toRadians(90));
        //System.out.println(sinI);
        return String.valueOf(Math.toDegrees(Math.asin(sinI)));
    }
}
