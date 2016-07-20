package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jari on 2/12/2015.
 */
public class ExceptionHandlerGUI {
    private JFrame jFrame = new JFrame("error");
    private JPanel jPanel = new JPanel(new GridBagLayout());
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JTextArea jTextArea = new JTextArea();
    private JButton jButtonOK = new JButton("OK");

     ExceptionHandlerGUI(Exception e) {
        createNewWindow();
        String location = e.toString();
        String message = e.getCause().toString();
        jTextArea.setText(message);
         jButtonOK.addActionListener(e1 -> jFrame.setVisible(false));
    }

    private void createNewWindow() {
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setSize(400, 200);
        jFrame.setVisible(true);
        jFrame.add(jPanel);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel.add(jTextArea, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel.add(jButtonOK, gridBagConstraints);
        jTextArea.setEditable(false);jFrame.setLocationRelativeTo(null);
    }
}
