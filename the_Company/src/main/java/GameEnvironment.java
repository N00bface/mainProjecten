import java.sql.*;
import java.util.ArrayList;

/**
 * @autor Jari Van Melckebeke
 */
public class GameEnvironment {
    public static ArrayList<Place> getFieldDatabase() {
        ArrayList<Place> board = new ArrayList<Place>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/theCompanyDB", "root", "tanzania");
            Statement statement = conn.createStatement();
            ResultSet locations = statement.executeQuery("select * from locations");
            while (locations.next()){
                board.add(new Place(locations.getInt("place_x"),locations.getInt("place_y"),locations.getString("place_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return board;
    }
}
