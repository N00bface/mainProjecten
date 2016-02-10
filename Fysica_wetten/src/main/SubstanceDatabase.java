package main;

import objects.Tuple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class SubstanceDatabase {

    public static String[] getSubstances() {
        ArrayList<String> arrayList = new ArrayList<>();
        List<Tuple<String, Double>> list = getIndexes();
        assert list != null;
        for (Tuple<String, Double> tuple : list) {
            //System.out.println("key = "+tuple.getKey());
            arrayList.add(tuple.getKey());
        }
        Resources.setSubstanceList(arrayList.toArray(new String[arrayList.size()]));
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static List<Tuple<String, Double>> getIndexes() {
        try {
            File file = new File(System.getProperty("user.dir") + "/baseIndexes.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            ArrayList<Tuple<String, Double>> tuples = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String key = line.split(";")[0];
                double value = Double.parseDouble(line.split(";")[1]);
                tuples.add(new Tuple<>(key, value));
                //System.out.println(tuples.toString());
            }
            Resources.setSubstances(tuples);
            return tuples;
        } catch (IOException ignored) {
            return null;
        }
    }
}
