import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.util.ArrayList;

/**
 * @autor Jari Van Melckebeke
 */
public class Game {
    Terminal terminal = TerminalFacade.createTerminal();
    private Point trackCursor = new Point(0, 0);

    public Game(Terminal mainTerminal) {
        this.terminal = mainTerminal;
        createField();
    }
    public Game(Terminal terminal, Save selected) {
        this.terminal = terminal;

    }

    private void createField() {
        ArrayList places = GameEnvironment.getFieldDatabase();
    }

    private void moveToLocation(String fromName,String name) {

    }
}
