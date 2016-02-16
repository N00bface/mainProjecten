import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import org.jetbrains.annotations.NotNull;

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
    private int choiceForMenu = 0;
    public ResultSet set;
    public Connection conn;
    public Statement statement;

    public LoadScreen(Terminal mainTerminal) throws SQLException, InterruptedException {
        terminal = mainTerminal;
        terminal.clearScreen();
        drawScreen();
    }

    private void drawScreen() throws SQLException, InterruptedException {
        writeText("___   _         ___ ___");
        writeText("|__  /_\\   \\ / |__ |__");
        writeText("__| /   \\   V  |__ __|");
        writeText("");
        loadSaves();
    }

    private void loadSaves() throws SQLException, InterruptedException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/theCompanyDB", "root", "tanzania");
        statement = conn.createStatement();
        set = statement.executeQuery("SELECT * FROM saves");
        while (set.next()) {
            saves.add(new Save(set.getInt("save_id"), set.getString("save_name"), set.getString("save_location"), set.getInt("save_money"), set.getInt("save_miners"),
                    set.getInt("save_navy"), set.getInt("save_guards"), set.getInt("save_xp"), set.getString("save_ship")));
        }
        writeBoard();
        actionListener();
    }

    private void actionListener() throws InterruptedException, SQLException {
        Key key = null;
        while (key == null) {
            Thread.sleep(5);
            key = terminal.readInput();
        }
        switch (key.getKind()) {
            case ArrowDown:
                if (choiceForMenu < saves.size() + 1) {
                    choiceForMenu++;
                    terminal.clearScreen();
                    drawScreen();
                }
                break;
            case ArrowUp:
                if (choiceForMenu > 0) {
                    choiceForMenu--;
                    terminal.clearScreen();
                    drawScreen();
                }
                break;
            case Enter:
                Save selected = new Save();
                for (int i = 0; i < choiceForMenu; i++) {
                    selected = new Save(set.getInt("save_id"), set.getString("save_name"), set.getString("save_location"), set.getInt("save_money"), set.getInt("save_miners"),
                            set.getInt("save_navy"), set.getInt("save_guards"), set.getInt("save_xp"), set.getString("save_ship"));
                }
                new Game(terminal, selected);
        }

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
                    + "|" + save.getSave_ship() + (multiply(10 - String.valueOf(save.getSave_ship()).length())) + "|");
        }
        writeText("+--+---------------+----------+--------+----------+");
        terminal.moveCursor(50, choiceForMenu + 7);
        terminal.putCharacter('<');
    }


    @NotNull
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
