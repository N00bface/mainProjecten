package main;

import javax.swing.*;
import java.awt.*;

public class Gui {
    //Gui vars
    //basic
    private JFrame jFrameMain = new JFrame("Fysica wetten");
    private JTabbedPane jTabbedMenu = new JTabbedPane(SwingConstants.TOP);
    private JPanel jPanelMainMirror = new JPanel();
    private JPanel jPanelInputMirror = new JPanel(new GridBagLayout());
    private JPanel jPanelMirror = new JPanel(null);
    private JPanel jPanelRefraction = new JPanel(null);
    private JPanel jPanelBounce = new JPanel(null);

    //end of Gui vars
    public Gui() {
        guiBasicSetup();
    }

    private void guiBasicSetup() {
        //jFrameMain
        jFrameMain.setSize(1080, 720);
        jFrameMain.setLocationRelativeTo(null);
        jFrameMain.setVisible(true);
        jFrameMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //JPanels
        // TODO: 04.02.16 action if screen size changes
        jPanelMainMirror.setSize((jFrameMain.getWidth() / 10) * 8, jFrameMain.getHeight());
        jPanelMainMirror.setLocation(0, 0);
        jPanelInputMirror.setSize(jFrameMain.getWidth() / 10 * 2, jFrameMain.getHeight());
        jPanelInputMirror.setLocation(jPanelMainMirror.getWidth(), 0);
        JPanel jPanelMainRefraction = jPanelMainMirror;
        JPanel jPanelInputRefraction = jPanelInputMirror;
        JPanel jPanelMainBounce = jPanelMainMirror;
        JPanel jPanelInputBounce = jPanelInputMirror;
        //jPanel decoration
        jPanelInputMirror.setBorder(BorderFactory.createTitledBorder("input"));
        // TODO: 04.02.16 add components
        jTabbedMenu.addTab("mirror", jPanelMirror);
        jTabbedMenu.addTab("refraction", jPanelRefraction);
        jTabbedMenu.addTab("bounce", jPanelBounce);
        jFrameMain.add(jTabbedMenu);
        jPanelMirror.add(jPanelMainMirror);
        jPanelMirror.add(jPanelInputMirror);
        jPanelRefraction.add(jPanelMainRefraction);
        jPanelRefraction.add(jPanelInputRefraction);
        jPanelBounce.add(jPanelInputBounce);
        jPanelBounce.add(jPanelMainBounce);
        //// FIXME: 04.02.16 overlapping jPanelMain and JPanelInput

    }

    private GridBagConstraints getConstrainsPlace(int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        return constraints;
    }
}
