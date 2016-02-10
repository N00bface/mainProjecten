package main;

import objects.Tuple;

import java.util.ArrayList;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class Calculator {
    public static String getMaxAngle(int substance1, int substance2) {
        ArrayList<Tuple<String, Double>> indexes = Resources.getSubstances();
        double refractiveIndex = indexes.get(substance1).getValue() / indexes.get(substance2).getValue();
        //n*sin ^r = sin î
        double sinI = refractiveIndex * Math.sin(Math.toRadians(90));
        System.out.println(sinI);
        return String.valueOf(Math.toDegrees(Math.asin(sinI)));
    }
}
