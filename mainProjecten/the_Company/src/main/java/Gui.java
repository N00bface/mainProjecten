import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


/**
 * @autor Jari Van Melckebeke
 */
public class Gui {
    private Terminal mainTerminal = TerminalFacade.createTerminal();
    private Point trackCursor = new Point(0, 0);
    private int choiceForMenu = 0;
    private Key input;

    public Gui() throws IOException, InterruptedException, SQLException {
        mainTerminal.enterPrivateMode();
        drawHomeScreen();
    }

    private void drawHomeScreen() throws InterruptedException, SQLException {
        mainTerminal.moveCursor(0, 0);
        trackCursor = new Point(0, 0);
        mainTerminal.clearScreen();
        input = null;
        writeText("|| ||  ___       __");
        writeText("||=|| |  | |\\/| |__");
        writeText("|| || |__| |  | |__");
        writeText("");
        mainTerminal.setCursorVisible(false);
        writeText("start");
        writeText("load");
        writeText("quit");
        drawCursorWhereSelect();
        while (input == null) {
            Thread.sleep(5);
            input = mainTerminal.readInput();
        }
        switch (input.getKind()) {
            case ArrowDown:
                if (choiceForMenu < 3) {
                    choiceForMenu++;
                    drawHomeScreen();
                }
                break;
            case ArrowUp:
                if (choiceForMenu > 0) {
                    choiceForMenu--;
                    drawHomeScreen();
                }
                break;
            case Enter:
                switch (choiceForMenu) {
                    case 0:
                        new Game(mainTerminal);
                        break;
                    case 1:
                        new LoadScreen(mainTerminal);
                        break;
                    case 2:
                        mainTerminal.exitPrivateMode();
                        break;
                    default:
                        System.out.println("choiceForMenu = " + choiceForMenu);
                }
        }
        System.out.println("input = " + input.getKind());
    }

    private void drawCursorWhereSelect() {
        mainTerminal.moveCursor(5, choiceForMenu + 4);
        mainTerminal.putCharacter('<');
        mainTerminal.moveCursor(trackCursor.x, trackCursor.y);
    }

    private void writeText(String str) {
        for (char ch : str.toCharArray()) {
            mainTerminal.moveCursor(trackCursor.x, trackCursor.y);
            mainTerminal.putCharacter(ch);
            trackCursor.x++;
        }
        trackCursor.x = 0;
        trackCursor.y++;
        mainTerminal.moveCursor(trackCursor.x, trackCursor.y);
    }
}
