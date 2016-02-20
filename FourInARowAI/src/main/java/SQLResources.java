import java.sql.*;

/**
 * @autor Jari Van Melckebeke
 */
public class SQLResources {
    private static int[][] parameters = getDatabase();

    private static int[][] getDatabase() {
        int[][] database = new int[101740][5];
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "tanzania");
            Statement statement = connection.createStatement();
            statement.execute("use parameterDB");
            ResultSet set = statement.executeQuery("select * from parameters");
            set.next();
            for (int i = 0; i < database.length; i++) {
                database[i] = new int[]{set.getInt("parameter_isWinPossible"), set.getInt("parameter_isOtherWinPossible"), set.getInt("parameter_is3Possible"), set.getInt("parmeter_isOther3Possible"), set.getInt("parameter_is2OptionsPossible")};
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
