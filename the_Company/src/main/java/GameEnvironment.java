import java.sql.*;

/**
 * @autor Jari Van Melckebeke
 */
public class GameEnvironment {
    public static Board getFieldDatabase() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/theCompanyDB", "root", "tanzania");
            Statement statement = conn.createStatement();
            ResultSet locations = statement.executeQuery("select * from locations");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
