package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Gui {
    //Gui vars
    //basic
    private JFrame frame = new JFrame("Physics laws");
    private JPanel mainPanel = new JPanel(null);
    private JPanel inputPanel = new JPanel(new GridBagLayout());
    //variable components
    private JComboBox mirrorSortComboBox = new JComboBox(new String[]{"flat", "hollow", "rounded"});
    //layout variables
    private GridBagConstraints constrains = new GridBagConstraints();
    private JSpinner angleSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 179, 0.1));
    //end of Gui vars
    public Gui() {
        panelSetup();
        componentSetup();
        addComponents();
        setupActionListeners();
    }

    private void componentSetup() {
    }

    private void addComponents() {
        frame.add(mainPanel);
        frame.add(inputPanel);
        inputPanel.add(new JLabel("mirror laws"), getConstrainsPlace(0, 0));
        inputPanel.add(new JLabel("sort: "), getConstrainsPlace(0, 1));
        inputPanel.add(mirrorSortComboBox, getConstrainsPlace(1, 1));
        inputPanel.add(new JLabel("angle: "),getConstrainsPlace(0,2));
        mainPanel.add(angleSpinner);
    }

    private void setupActionListeners() {
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                setSizesAndPlacesForComponents();
            }
        });
    }

    private void panelSetup() {
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputPanel.setBorder(BorderFactory.createTitledBorder("input"));
        setSizesAndPlacesForComponents();
    }

    private void setSizesAndPlacesForComponents() {
        mainPanel.setSize((frame.getWidth() / 10) * 8 - 2, frame.getHeight());
        inputPanel.setSize(frame.getWidth() / 10 * 2, frame.getHeight());
        mainPanel.setLocation(0, 0);
        inputPanel.setLocation(mainPanel.getWidth(), 0);
    }

    private GridBagConstraints getConstrainsPlace(int x, int y) {
        constrains.gridx = x;
        constrains.gridy = y;
        return constrains;
    }
}
