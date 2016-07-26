import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

/**
 * @author Jari Van Melckebeke
 * @since 25.07.16
 */
public class Gui {
    private static JFrame jFrame = new JFrame("blog bericht schrijven");
    private static JPanel jPanel = new JPanel(new GridBagLayout());

    private static GridBagConstraints constraints = new GridBagConstraints();

    private static JButton save_bttn = new JButton("save");
    private static JLabel title_label = new JLabel("titel: ");
    private static JTextField title_field = new JTextField("titel");
    private static JLabel author_label = new JLabel("auteur: ");
    private static JTextField author_field = new JTextField("auteur");
    private static JTextArea blog_message_area = new JTextArea("blog text");

    private static Parser p = new Parser();

    public static void createNew() {
        setupFrames();
        save_bttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreeMap<String, String> contents = new TreeMap<String, String>();
                contents.put("title", title_field.getText());
                contents.put("author", author_field.getText());
                contents.put("text", blog_message_area.getText());

                p.parseJson(contents);
            }
        });
    }

    private static void setupFrames() {
        constraints.weightx = 0.25;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 0, 10, 0);
        jPanel.add(save_bttn, constraints);
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        jPanel.add(title_label, constraints);
        constraints.gridx = 1;
        jPanel.add(title_field, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        jPanel.add(author_label, constraints);
        constraints.gridx++;
        jPanel.add(author_field, constraints);
        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 7;
        constraints.weighty = 0.75;
        constraints.weightx = 0.5;
        blog_message_area.setSize(1250, 500);
        jPanel.add(blog_message_area, constraints);
        jFrame.add(jPanel);
        jFrame.setSize(1600, 800);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
    }
}
