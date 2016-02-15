package main;

import javax.swing.*;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class MainMethod {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui();
            }
        });
    }


}
