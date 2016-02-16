import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;

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
        GameEnvironment.getFieldDatabase();
    }

    private void moveToLocation(String name) {

    }
}
