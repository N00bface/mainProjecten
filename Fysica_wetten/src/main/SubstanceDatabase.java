package main;

import objects.CDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class SubstanceDatabase {

    public static String[] getSubstances() {
        CDatabase<String, Double> cDatabase = getIndexes();
        Resources.setSubstanceList(cDatabase.getkeys());
        return cDatabase.getkeys();
    }

    public static CDatabase<String, Double> getIndexes() {
        try {
            File file = new File(System.getProperty("user.dir") + "/baseIndexes.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            CDatabase<String, Double> cDatabase = new CDatabase<>();
            while ((line = bufferedReader.readLine()) != null) {
                String key = line.split(";")[0];
                double value = Double.parseDouble(line.split(";")[1]);
                //System.out.println(cDatabases.toString());
                cDatabase.set(key, value);
            }
            Resources.setSubstances(cDatabase);
            return cDatabase;
        } catch (IOException ignored) {
            return null;
        }
    }
}
