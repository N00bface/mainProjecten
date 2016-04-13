import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * @autor Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "tanzania");
        Statement statement = con.createStatement();
        statement.execute("use teresaDB");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(new File("/home/jari/Downloads/GeoLiteCity-Location.csv"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            bufferedReader.readLine();
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\"", "");
                line = line.replaceAll("\'", "\\'");
                line = line.trim();
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    if (data[i].equals("")) {
                        data[i] = "null";
                    }
                    data[i] = "\'" + data[i] + "\'";
                }
                System.out.println(Arrays.toString(data));
                if (data[1].contains("BE")) {
                    try {
                        statement.execute("insert into city (locId,city,latitude,longitude) values (" + data[0] + "," + data[3] + "," + data[5] + "," + data[6] + ");");
                    } catch (MySQLSyntaxErrorException ignored) {
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
