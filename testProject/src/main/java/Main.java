import java.sql.*;

/**
 * @autor Jari Van Melckebeke
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "tanzania");
        Statement statement = con.createStatement();
        statement.execute("use parameterDB");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            String query = "insert into parameters (parameter_isWinPossible,parameter_isOtherWinPossible,parameter_is3Possible,parmeter_isOther3Possible,parameter_is2OptionsPossible)" +
                                    "values (" + i + "," + j + "," + k + "," + l + "," + m + ")";
                            PreparedStatement preparedStatement = con.prepareStatement(query);
                            preparedStatement.execute();
                            System.out.println(i+" "+j+" "+k+" "+l+" "+m);
                        }
                    }
                }
            }
        }
    }
}
