package main;

import java.sql.*;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class SubstanceDatabase {

    public static String[] getSubstances() {
        CDatabase<String, Double> cDatabase = getIndexes();
        try {
            assert cDatabase != null;
            Resources.setSubstanceList(cDatabase.getkeys());
        } catch (NullPointerException e) {
            System.out.println("no valid databasefile found");
            System.exit(0);
        }
        return cDatabase.getkeys();
    }

    public static CDatabase<String, Double> getIndexes() {
        /*try {
            File file = new File(System.getProperty("user.dir") + "/src/main/resources/baseIndexes.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            CDatabase<String, Double> cDatabase = new CDatabase<String, Double>();
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
        }*/
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String host = "jdbc:mysql://localhost:3306/indexDatabase";
        String user = "root";
        String passw = "tanzania";
        CDatabase<String, Double> database = new CDatabase<String, Double>();
        try {
            Connection connection = DriverManager.getConnection(host, user, passw);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM substances");
            while (result.next()) {
                //System.out.println(result.getString("substance_name")+" "+result.getDouble("substance_n"));
                database.set(result.getString("substance_name"), result.getDouble("substance_n"));
                //System.out.println(Arrays.toString(database.getkeys()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("database --> " + database.toString());
        Resources.setSubstances(database);
        return database;
    }

}
