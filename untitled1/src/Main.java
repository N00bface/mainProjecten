
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Jari Van Melckebeke
 * @since 20.07.16
 */
public class Main {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            while (true) {
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                robot.keyPress(KeyEvent.VK_COMMA);
                robot.keyPress(KeyEvent.VK_ENTER);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
