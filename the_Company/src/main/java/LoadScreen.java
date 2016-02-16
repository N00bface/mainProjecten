import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @autor Jari Van Melckebeke
 */
public class LoadScreen {
    private Terminal terminal;
    private Point cursor = new Point(0, 0);
    private ArrayList<Save> saves = new ArrayList<Save>();

    public LoadScreen(Terminal mainTerminal) throws SQLException {
        terminal = mainTerminal;
        terminal.clearScreen();
        drawScreen();
    }

    private void drawScreen() throws SQLException {
        writeText("___   _         ___ ___");
        writeText("|__  /_\\   \\ / |__ |__");
        writeText("__| /   \\   V  |__ __|");
        writeText("");
        loadSaves();
    }

    private void loadSaves() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/theCompanyDB", "root", "tanzania");
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery("SELECT save_id, save_name, save_money, save_location, save_ship FROM saves");
        while (set.next()) {
            saves.add(new Save(set.getInt("save_id"), set.getString("save_name"), set.getString("save_location"), set.getInt("save_money"), set.getString("save_ship")));
        }
        writeBoard();
    }

    private void writeBoard() {
        writeText("+--+---------------+----------+--------+----------+");
        writeText("|id|name           |location  |money   |ship      |");
        writeText("+--+---------------+----------+--------+----------+");
        for (Save save : saves) {
            writeText("|" + save.getSave_id() + (multiply(2 - String.valueOf(save.getSave_id()).length()))
                    + "|" + save.getSave_name() + (multiply(15 - String.valueOf(save.getSave_name()).length()))
                    + "|" + save.getSave_location() + (multiply(10 - String.valueOf(save.getSave_location()).length()))
                    + "|" + save.getSave_money() + (multiply(8 - String.valueOf(save.getSave_money()).length()))
                    + "|" + save.getSave_ship() + (multiply(10 - String.valueOf(save.getSave_ship()).length()))+"|");
        }
        writeText("+--+---------------+----------+--------+----------+");
    }

    private String multiply(int count) {
        return new String(new char[count]).replace('\0', ' ');
    }

    private void writeText(String str) {
        for (char ch : str.toCharArray()) {
            terminal.moveCursor(cursor.x, cursor.y);
            terminal.putCharacter(ch);
            cursor.x++;
        }
        cursor.x = 0;
        cursor.y++;
        terminal.moveCursor(cursor.x, cursor.y);
    }
}
