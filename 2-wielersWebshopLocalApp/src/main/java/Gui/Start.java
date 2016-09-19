package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jari Van Melckebeke
 * @since 04.08.16
 */
public class Start {
    private JFrame jFrame = new JFrame("webshop applicatie");
    private JPanel jPanel = new JPanel(new GridBagLayout());

    public Start() {
        //fetch resources
        //todo: get resources

        //build basic GUI
        setupBasic();
    }

    private void setupBasic() {
        jFrame.setVisible(true);
        jFrame.setSize(1200, 960);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
