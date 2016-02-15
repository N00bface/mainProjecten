package main;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class Gui {
    //special vars
    private GridBagConstraints constraints = new GridBagConstraints();
    private boolean switchPointBetweenMirrorAndRefraction = false;
    private boolean isTotalInternalReflectionActive = false;
    //end of special vars
    //Gui vars
    //basic
    private JFrame frame = new JFrame("Physics laws");
    private JPanel mainPanel = new JPanel();
    private JPanel inputPanel = new JPanel(new GridBagLayout());
    //variable components
    private JComboBox<String> mirrorSortComboBox = new JComboBox<>(new String[]{"flat", "hollow", "rounded"});
    private JComboBox<String> substanceComboBox1 = new JComboBox<>(SubstanceDatabase.getSubstances());
    private JComboBox<String> substanceComboBox2 = new JComboBox<>(SubstanceDatabase.getSubstances());
    private JSpinner angleSpinnerMirror = new JSpinner(new SpinnerNumberModel(0, 0, 360, 0.1));
    private JSpinner indicentRayAngleRefraction = new JSpinner(new SpinnerNumberModel(0, 0, 180, 0.1));
    private JSpinner refractedRayAngleRefraction = new JSpinner(new SpinnerNumberModel(0, 0, 180, 0.1));
    private JLabel maxAngle = new JLabel(Calculator.getMaxAngle(String.valueOf(substanceComboBox1.getSelectedItem()), String.valueOf(substanceComboBox2.getSelectedItem())));

    //end of Gui vars
    public Gui() {
        panelSetup();
        addComponents();
        setupActionListeners();
        new Draw().paintComponent(mainPanel.getGraphics());
    }

    private GridBagConstraints setGridBagPlace(int x, int y) {
        constraints.gridwidth = 1;
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.5;
        constraints.weightx = 0.5;
        constraints.gridx = x;
        constraints.gridy = y;
        return constraints;
    }

    private void addComponents() {
        frame.add(mainPanel, BorderLayout.LINE_START);
        frame.add(inputPanel, BorderLayout.LINE_END);
        inputPanel.add(new JLabel("mirror laws"), setGridBagPlace(0, 0));
        inputPanel.add(new JLabel("sort: "), setGridBagPlace(0, 1));
        inputPanel.add(mirrorSortComboBox, setGridBagPlace(1, 1));
        inputPanel.add(new JLabel("angle: "), setGridBagPlace(0, 2));
        inputPanel.add(angleSpinnerMirror, setGridBagPlace(1, 2));
        inputPanel.add(new JLabel(" "), setGridBagPlace(0, 3));
        inputPanel.add(new JLabel("laws of refraction"), setGridBagPlace(0, 4));
        inputPanel.add(new JLabel("substance 1: "), setGridBagPlace(0, 5));
        inputPanel.add(substanceComboBox1, setGridBagPlace(1, 5));
        inputPanel.add(new JLabel("substance 2: "), setGridBagPlace(0, 6));
        inputPanel.add(substanceComboBox2, setGridBagPlace(1, 6));
        inputPanel.add(new JLabel("indicent ray: "), setGridBagPlace(0, 7));
        inputPanel.add(indicentRayAngleRefraction, setGridBagPlace(1, 7));
        inputPanel.add(new JLabel("refracted ray: "), setGridBagPlace(0, 8));
        inputPanel.add(refractedRayAngleRefraction, setGridBagPlace(1, 8));
        inputPanel.add(new JLabel("total internal reflection angle: "), setGridBagPlace(0, 9));
        inputPanel.add(maxAngle, setGridBagPlace(1, 9));
    }

    private void setupActionListeners() {
        substanceComboBox1.addActionListener(e -> refractionActionListner());
        substanceComboBox2.addActionListener(e -> refractionActionListner());
        indicentRayAngleRefraction.addChangeListener(e -> refractionActionListner());
        refractedRayAngleRefraction.addChangeListener(e -> refractionActionListner());
        mirrorSortComboBox.addActionListener(e -> {
            switchPointBetweenMirrorAndRefraction = true;
            new Draw().paintComponent(mainPanel.getGraphics());
        });
        angleSpinnerMirror.addChangeListener(e -> {
            switchPointBetweenMirrorAndRefraction = true;
            new Draw().paintComponent(mainPanel.getGraphics());
        });
    }

    private void refractionActionListner() {
        new Draw().paintComponent(mainPanel.getGraphics());
        refractedRayAngleRefraction.setValue(calculateRefractionAngle());
        switchPointBetweenMirrorAndRefraction = false;
        maxAngle.setText(Calculator.getMaxAngle(String.valueOf(substanceComboBox1.getSelectedItem()), String.valueOf(substanceComboBox2.getSelectedItem())));
        isTotalInternalReflectionActive = false;
    }

    private void panelSetup() {
        frame.setSize(1920, 1080);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        inputPanel.setBorder(BorderFactory.createTitledBorder("input"));
        inputPanel.setPreferredSize(new Dimension((int) (1920 * 0.3), 1080));
        mainPanel.setPreferredSize(new Dimension((int) (1920 * 0.7) - inputPanel.getInsets().right * 2, 1080));
    }

    private double calculateRefractionAngle() {
        if (Resources.getSubstances().get(String.valueOf(substanceComboBox1.getSelectedItem())) >= Resources.getSubstances().get(String.valueOf(substanceComboBox2.getSelectedItem()))) {
            double nIndex = Resources.getSubstances().get(String.valueOf(substanceComboBox1.getSelectedItem())) / Resources.getSubstances().get(String.valueOf(substanceComboBox2.getSelectedItem()));
            //System.out.println("nIndex = " + nIndex);
            double sinI = Math.sin(Math.toRadians((Double) indicentRayAngleRefraction.getValue()));
            //System.out.println("sinI = " + sinI);
            double sinR = sinI / nIndex;
            //System.out.println("sinR = " + sinR);
            //System.out.println("Math.toDegrees(Math.asin(sinR)) = " + Math.toDegrees(Math.asin(sinR)));
            return Math.toDegrees(Math.asin(sinR));
        } else {
            double nIndex = Resources.getSubstances().get(String.valueOf(substanceComboBox2.getSelectedItem())) / Resources.getSubstances().get(String.valueOf(substanceComboBox1.getSelectedItem()));
            //System.out.println("nIndex = " + nIndex);
            //System.out.println("((Double) indicentRayAngleRefraction.getValue()) = " + indicentRayAngleRefraction.getValue());
            double sinI = Math.sin(Math.toRadians((Double) indicentRayAngleRefraction.getValue()));
            //System.out.println("sinI = " + sinI);
            double sinR = nIndex * sinI;
            //System.out.println("sinR = " + sinR);
            //System.out.println("Math.toDegrees(Math.asin(sinR)) = " + Math.toDegrees(Math.asin(sinR)));
            //System.out.println("Math.toDegrees(Math.asin(sinR)) = " + Math.toDegrees(Math.asin(sinR)));
            if (String.valueOf(Math.toDegrees(Math.asin(sinR))).equals("NaN")) {
                isTotalInternalReflectionActive = true;
            }
            return Math.toDegrees(Math.asin(sinR));
        }
    }

    class Draw extends JPanel {
        private final int HALF_MAINPANEL = (mainPanel.getWidth() / 2);

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D gr = (Graphics2D) g;
            gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gr.clearRect(0, 0, (int) (1920 * 0.7 - inputPanel.getInsets().right * 2), 1080);
            gr.translate(mainPanel.getWidth() / 2, mainPanel.getHeight() / 2);
            if (switchPointBetweenMirrorAndRefraction) { //--> mirror
                switch (mirrorSortComboBox.getSelectedIndex()) {
                    case 0:
                        gr.drawLine(0, -300, 0, 300);
                        gr.setColor(Color.RED);
                        gr.drawLine((int) getAngleToCoordinatesForMirror(), -HALF_MAINPANEL, 0, 0);
                        break;
                    case 1:
                        gr.drawArc(-300, -300, 600, 600, 90, -180);
                        gr.setColor(Color.RED);
                        gr.drawLine((int) getAngleToCoordinatesForMirror(), -HALF_MAINPANEL, calculatePointForRoundAngle().x, calculatePointForRoundAngle().y);
                        break;
                    case 2:
                        gr.drawArc(-300, -300, 600, 600, 90, 180);
                        gr.setColor(Color.RED);
                        gr.drawLine((int) getAngleToCoordinatesForMirror(), -HALF_MAINPANEL, calculatePointforConvexAngle().x, calculatePointforConvexAngle().y);
                        break;
                }
            } else {
                System.out.println("isTotalInternalReflectionActive = " + isTotalInternalReflectionActive);
                gr.setColor(new Color(173, 216, 230));
                gr.fillRect(0, -(mainPanel.getHeight() / 2), HALF_MAINPANEL, mainPanel.getHeight());
                gr.setColor(Color.RED);
                gr.drawLine((int) getAngleToCoordinatesForRefraction(), -HALF_MAINPANEL, 0, 0);
                if (!isTotalInternalReflectionActive) {
                    gr.drawLine(0, 0, calculatePointForRefraction().x, calculatePointForRefraction().y);
                } else {
                    gr.drawLine(0, 0, -HALF_MAINPANEL, getAngleToCoordinatesForTotalInternalReflection());
                }
            }
            gr.dispose();
        }

        private int getAngleToCoordinatesForTotalInternalReflection() {
            System.out.println("Angle Method");
            return (int) (HALF_MAINPANEL / Math.tan(Math.toRadians(90 - (Double) indicentRayAngleRefraction.getValue())));
        }

        private Point calculatePointForRefraction() {

            int x = HALF_MAINPANEL;
            int y = (int) (x / Math.tan(Math.toRadians(calculateRefractionAngle())));
            //System.out.println("y = " + y);
            return new Point(x, y);
        }

        private Point calculatePointforConvexAngle() {
            int x = (int) -(Math.sin(Math.toRadians(90 - (Double) angleSpinnerMirror.getValue())) * 300);
            int y = (int) -(Math.cos(Math.toRadians(90 - (Double) angleSpinnerMirror.getValue())) * 300);
            return new Point(x, y);
        }

        private Point calculatePointForRoundAngle() {
            int x = (int) (Math.sin(Math.toRadians(90 - (Double) angleSpinnerMirror.getValue())) * 300);
            int y = (int) (Math.cos(Math.toRadians(90 - (Double) angleSpinnerMirror.getValue())) * 300);
            /*System.out.println("x="+x);
            System.out.println("y="+y);*/
            return new Point(x, y);
        }


        private double getAngleToCoordinatesForMirror() {
            return -(Math.tan(Math.toRadians(90 - (Double) angleSpinnerMirror.getValue())) * HALF_MAINPANEL);
        }

        private double getAngleToCoordinatesForRefraction() {
            return -(Math.tan(Math.toRadians((Double) indicentRayAngleRefraction.getValue())) * HALF_MAINPANEL);
        }
    }
}
