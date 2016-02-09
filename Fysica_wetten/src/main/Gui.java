package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class Gui {
    //special vars
    private SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 360, 0.1);
    private GridBagConstraints constraints = new GridBagConstraints();
    //end of special vars
    //Gui vars
    //basic
    private JFrame frame = new JFrame("Physics laws");
    private JPanel mainPanel = new JPanel();
    private JPanel inputPanel = new JPanel(new GridBagLayout());
    //variable components
    private JComboBox<String> mirrorSortComboBox = new JComboBox<>(new String[]{"flat", "hollow", "rounded"});
    private JSpinner angleSpinnerMirror = new JSpinner(model);
    private JButton openDatabaseForSubstance1 = new JButton("select");
    private JButton openDatabaseForSubstance2 = new JButton("select");
    //end of Gui vars

    public Gui() {
        panelSetup();
        componentSetup();
        addComponents();
        setupActionListeners();
    }

    private GridBagConstraints gridBagSetup(int x, int y) {
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = x;
        constraints.gridy = y;
        return constraints;
    }

    private void componentSetup() {

    }

    private void addComponents() {
        frame.add(mainPanel, BorderLayout.LINE_START);
        frame.add(inputPanel, BorderLayout.LINE_END);
        inputPanel.add(new JLabel("mirror laws"), gridBagSetup(0, 0));
        inputPanel.add(new JLabel("sort: "), gridBagSetup(0, 1));
        inputPanel.add(mirrorSortComboBox, gridBagSetup(1, 1));
        inputPanel.add(new JLabel("angle: "), gridBagSetup(0, 2));
        inputPanel.add(angleSpinnerMirror, gridBagSetup(1, 2));
        inputPanel.add(new JLabel(""), gridBagSetup(0, 3));
        inputPanel.add(new JLabel("laws of refraction"), gridBagSetup(0, 4));
        inputPanel.add(new JLabel("substance 1: "), gridBagSetup(0, 5));
        inputPanel.add(openDatabaseForSubstance1, gridBagSetup(1, 5));
        inputPanel.add(new JLabel("substance 2: "), gridBagSetup(0, 6));
        inputPanel.add(openDatabaseForSubstance2, gridBagSetup(1, 6));
    }

    private void setupActionListeners() {
        frame.addComponentListener(new ComponentAdapter() {

        });
    }

    private void panelSetup() {
        frame.setSize(1080, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputPanel.setBorder(BorderFactory.createTitledBorder("input"));
        inputPanel.setPreferredSize(new Dimension(432, 720));
        mainPanel.setPreferredSize(new Dimension(648, 720));
    }

}
