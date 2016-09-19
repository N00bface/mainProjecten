package gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;

/**
 * Created by Jari on 22/11/2015.
 */
public class MainClass {

    private JFrame jFrame = new JFrame("IO through code");
    private JPanel jPanel = new JPanel(null);

    private JButton jButtonGetInput = new JButton("get input");
    private JButton jButtonGetCheck = new JButton("get correction");
    private JButton jButtonStart = new JButton("Start");

    private JLabel jLabelInput = new JLabel("input");
    private JLabel jLabelOutput = new JLabel("output");
    private JLabel jLabelCorrection = new JLabel("correction");


    private JTextPane jTextPaneInput = new JTextPane();
    private JTextPane jTextPaneOutput = new JTextPane();
    private JTextPane jTextPaneCheck = new JTextPane();

    private StyledDocument document = jTextPaneOutput.getStyledDocument();
    private Style style = jTextPaneOutput.addStyle("abc", null);

    private boolean jComboboxHasRun = false;
    private boolean jTextPaneCheckbool = false;

    private JLabel jLabelPercent = new JLabel("0%");
    private JScrollPane jScrollPaneInput = new JScrollPane(jTextPaneInput);
    private JScrollPane jScrollPaneOutput = new JScrollPane(jTextPaneOutput);
    private JScrollPane jScrollPaneCheck = new JScrollPane(jTextPaneCheck);


    private JComboBox jComboBoxClass = new JComboBox(getClasses());

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        new MainClass();
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public MainClass() {
        setupAllPlacing();
        addActionListners();
    }

    private void addActionListners() {
        jScrollPaneCheck.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                jScrollPaneOutput.getVerticalScrollBar().setValue(e.getValue());
            }
        });
        jScrollPaneOutput.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                jScrollPaneCheck.getVerticalScrollBar().setValue(e.getValue());
            }
        });
        jButtonStart.addActionListener(e -> {
            jTextPaneOutput.setText("");
            String[] inputs = jTextPaneInput.getText().split("\n");
            for (int i = 0; i < inputs.length; i++) {
                String[] param = inputs[i].trim().split(";");
                try {
                    Class klasse = Class.forName("classes." + jComboBoxClass.getSelectedItem().toString());
                    Object iClass = klasse.newInstance();
                    Method method = klasse.getMethod("run", String[].class);
                    Object objparam = param.clone();
                    Object ret = method.invoke(iClass, objparam);
                    jTextPaneOutput.setText(jTextPaneOutput.getText() + String.valueOf(ret) + "\n");
                    jComboboxHasRun = true;
                } catch (Exception e1) {
                    new ExceptionHandlerGUI(e1);
                    jTextPaneOutput.setText(jTextPaneOutput.getText() + "ERROR: "+e1.getLocalizedMessage() + "\n");
                }
            }
            try {
                checkCorrection();
            } catch (Exception e1) {
                ExceptionHandlerGUI handlerGUI = new ExceptionHandlerGUI(e1);

            }
        });
        jButtonGetInput.addActionListener(e -> {
            jTextPaneInput.setText("");
            JFileChooser fileChooser = new JFileChooser();
            int returnval = fileChooser.showOpenDialog(jFrame);
            if (returnval == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        jTextPaneInput.setText(jTextPaneInput.getText() + line + "\n");
                    }
                } catch (Exception e1) {
                    new ExceptionHandlerGUI(e1);

                }

            }
            try {
                checkCorrection();
            } catch (Exception e1) {
                new ExceptionHandlerGUI(e1);

            }
        });
        jButtonGetCheck.addActionListener(e -> {
            jTextPaneCheck.setText("");
            JFileChooser fileChooser = new JFileChooser();
            int returnval = fileChooser.showOpenDialog(jFrame);
            if (returnval == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        jTextPaneCheck.setText(jTextPaneCheck.getText() + line + "\n");
                    }
                } catch (Exception e1) {
                     new ExceptionHandlerGUI(e1);
                }
            }
            jTextPaneCheckbool = true;
            try {
                checkCorrection();
            } catch (Exception e1) {
                new ExceptionHandlerGUI(e1);

            }
        });

    }

    private void checkCorrection() throws BadLocationException {

        if (jTextPaneCheckbool && jComboboxHasRun) {
            String[] output = jTextPaneOutput.getText().split("\n");
            String[] check = jTextPaneCheck.getText().split("\n");
            System.out.println(output.length);
            double wrong = 0;
            double correct = 0;
            double total = output.length;
            jTextPaneOutput.setText("");
            for (int i = 0; i < output.length; i++) {
                if (output[i].equals(check[i])) {
                    StyleConstants.setBackground(style, Color.WHITE);
                    document.insertString(document.getLength(), output[i] + "\n", style);
                    correct++;
                } else {
                    StyleConstants.setBackground(style, Color.yellow);
                    document.insertString(document.getLength(), output[i] + "\n", style);
                    wrong++;
                }
            }
            if (wrong < correct) {
                jLabelPercent.setForeground(Color.green);
            } else {
                jLabelPercent.setForeground(Color.RED);
            }
            jLabelPercent.setText((correct / total) * 100 + "%");
            jTextPaneOutput.setStyledDocument(document);
        }
    }

    private void setupAllPlacing() {
        //jFrame
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(1450, 750);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        //jPanel
        jFrame.add(jPanel);
        jPanel.setBackground(Color.DARK_GRAY);
        //jScrollPaneInput
        jScrollPaneInput.setBounds(100, 50, 300, 600);
        jPanel.add(jScrollPaneInput);
        //jScrollPaneOutput
        jScrollPaneOutput.setBounds(700, 50, 300, 600);
        jPanel.add(jScrollPaneOutput);
        //jScrollPaneCheck
        jScrollPaneCheck.setBounds(1050, 50, 300, 600);
        jPanel.add(jScrollPaneCheck);
        //jButtonGetInput
        jButtonGetInput.setBounds(100, 650, 300, 25);
        jPanel.add(jButtonGetInput);
        //jButtonGetCheck
        jButtonGetCheck.setBounds(1050, 650, 300, 25);
        jPanel.add(jButtonGetCheck);
        //jButtonStart
        jButtonStart.setBounds(425, 125, 250, 25);
        jPanel.add(jButtonStart);
        //jComboBox
        jComboBoxClass.setBounds(425, 100, 250, 25);
        jPanel.add(jComboBoxClass);
        //jLabelInput
        jLabelInput.setBounds(100, 25, 300, 25);
        jLabelInput.setForeground(Color.WHITE);
        jPanel.add(jLabelInput);
        //jLabelOutput
        jLabelOutput.setBounds(700, 25, 300, 25);
        jLabelOutput.setForeground(Color.WHITE);
        jPanel.add(jLabelOutput);
        //jLabelCorrection
        jLabelCorrection.setBounds(1050, 25, 300, 25);
        jLabelCorrection.setForeground(Color.WHITE);
        jPanel.add(jLabelCorrection);
        //jLabelPercent
        jLabelPercent.setBounds(425, jFrame.getHeight() / 2, 250, 25);
        jPanel.add(jLabelPercent);

    }

    public Object[] getClasses() {
        File[] location = new File(System.getProperty("user.dir") + "\\src\\classes\\").listFiles();
        Object[] array = new Object[location.length];
        for (int i = 0; i < location.length; i++) {
            array[i] = location[i].getName().substring(0, location[i].getName().lastIndexOf("."));
        }
        return array;
    }
}
