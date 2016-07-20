package main;

import resources.Weapon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jari on 25/12/2015.
 */
public class World {
    private boolean isActive = false;

    private JFrame jFrame = new JFrame("Surviva");
    private JPanel jPanel = new JPanel(null);
    private JPanel jPanelStats = new JPanel(new GridBagLayout());
    private JPanel jPanelPerks = new JPanel(new FlowLayout());
    private GridBagConstraints constraints = new GridBagConstraints();
    private JProgressBar healthProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
    private JProgressBar ammoProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, Weapon.handGun.getClip());
    private JProgressBar energyProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 200);

    public boolean isActive() {
        return isActive;
    }

    public World() {
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    jFrame.setVisible(false);
                    Controler.stopGame();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void clearWorld() {
        jPanel.repaint();
    }

    public void makeWorld() throws IOException {
        jFrame.setLayout(null);
        if (!jFrame.isActive()) {
            jFrame.add(jPanel);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
            jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        } else {
            jPanel.repaint();
        }
        //graphics
        BattleArena battleArena = new BattleArena();
        battleArena.paintComponent(jPanel.getGraphics());
        //jPanelStats
        jPanelStats.setBounds(1644, 0, 274, 1080);
        jFrame.add(jPanelStats);
        //placing jPanelStats
        healthProgressBar.setValue(100);
        healthProgressBar.setSize(jPanelStats.getWidth() - 25, 25);

        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        jPanelStats.add(healthProgressBar, constraints);
        healthProgressBar.setBackground(Color.BLACK);
        healthProgressBar.setForeground(Color.RED);
        healthProgressBar.setStringPainted(true);
        healthProgressBar.setString(healthProgressBar.getValue() + "%");

        ammoProgressBar.setSize(healthProgressBar.getSize());
        ammoProgressBar.setValue(Weapon.handGun.getClip());
        ammoProgressBar.setStringPainted(true);
        ammoProgressBar.setString("ammo: " + ammoProgressBar.getValue());
        ammoProgressBar.setForeground(Color.DARK_GRAY);

        energyProgressBar.setSize(healthProgressBar.getSize());
        energyProgressBar.setValue(energyProgressBar.getMaximum());
        energyProgressBar.setStringPainted(true);
        energyProgressBar.setString(String.valueOf(energyProgressBar.getValue()));
        energyProgressBar.setForeground(Color.BLUE);

        constraints.gridy = 1;
        jPanelStats.add(energyProgressBar, constraints);
        constraints.gridy = 2;
        jPanelStats.add(ammoProgressBar, constraints);

        jPanelPerks.setBorder(BorderFactory.createTitledBorder("perks"));
        jPanelPerks.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jPanelPerks.setPreferredSize(new Dimension(jPanelStats.getWidth(), 81));
        constraints.gridy = 3;
        jPanelStats.add(jPanelPerks, constraints);
        //paintAll
        battleArena.paintComponent(jPanel.getGraphics());
    }

    public class BattleArena extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            BufferedImage battleArena = null;
            try {
                battleArena = ImageIO.read((new File("F:\\programmeerprojecten\\surviva\\resources\\background.jpg")));
            } catch (IOException e) {
                System.out.println("fout");
            }
            System.out.println(battleArena.getWidth());
            jPanel.setSize(battleArena.getWidth(), battleArena.getHeight());
            graphics.drawImage(battleArena, 0, 0, this);
            graphics.dispose();
            System.out.println("disposed");
        }

        @Override
        public void repaint() {
            Graphics g = super.getGraphics();
            if (super.getGraphics() != null) {
                super.getGraphics().clearRect(0, 0, super.getWidth(), super.getHeight());
            }
            super.paintAll(g);
        }
    }
}
