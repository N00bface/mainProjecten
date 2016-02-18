import java.sql.*;

/**
 * @autor Jari Van Melckebeke
 */
public class SQLResources {
    private static int[][] parameters = getDatabase();

    private static int[][] getDatabase() {
        int[][] database = new int[101740][5];
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/3306", "root", "tanzania");
            Statement statement = connection.createStatement();
            statement.execute("use parameterDB");
            ResultSet set = statement.executeQuery("select * from parameters");
            for (int i = 0; i < database.length; i++) {
                database[i] = new int[]{set.getInt(1), set.getInt(2), set.getInt(3), set.getInt(4), set.getInt(5)};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return database;
    }

    public static int[] getParameters(int line) {
        return parameters[line];
    }
}
