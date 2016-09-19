package main;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class Calculator {
    public static String getMaxAngle(String substance1, String substance2) {
        CDatabase<String, Double> indexes = SubstanceDatabase.getIndexes();
        //System.out.println("substance2 = " + substance2);
        //System.out.println("Resources.getSubstances() = " + Resources.getSubstances().toString());
        //System.out.println("indexes = " + indexes.toString());
        double refractiveIndex = indexes.get(substance1.toLowerCase()) / indexes.get(substance2.toLowerCase());
        //n*sin ^r = sin î
        double sinI = refractiveIndex * Math.sin(Math.toRadians(90));
        //System.out.println(sinI);
        return String.valueOf(Math.toDegrees(Math.asin(sinI)));
    }
}
