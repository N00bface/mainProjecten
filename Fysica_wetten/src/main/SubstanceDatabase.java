package main;

import objects.Tuple;

import javax.swing.*;
import java.awt.*;
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
    private JFrame frame = new JFrame("substance table");
    private JPanel panel = new JPanel();
    private JScrollPane listScroller = new JScrollPane();
    private JList<String> list = new JList<>(Resources.getRefractionIndeces());

    public SubstanceDatabase() {

        listScroller.add(list);
        makeBasicGui();
        panel.setBackground(Color.GREEN);
    }

    private void makeBasicGui() {
        frame.setSize(1000, 900);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);
        panel.add(list);
    }


    public static String[] getSubstances() {
        ArrayList<String> arrayList = new ArrayList<>();
        List<Tuple<String, Double>> list = getIndexes();
        assert list != null;
        for (Tuple<String, Double> tuple : list) {
            //System.out.println("key = "+tuple.getKey());
            arrayList.add(tuple.getKey());
        }
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
            return tuples;
        } catch (IOException ignored) {
            return null;
        }
    }
}
