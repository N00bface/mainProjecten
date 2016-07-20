package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.util.Vector;

/**
 * @author Jari Van Melckebeke
 */
public class MainGui {
    private JFrame mainFrame;
    private JPanel panel;
    private Graphics2D panelGraphics;
    private Vector<Shape> shapes = new Vector<Shape>();

    private int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public MainGui() {
        mainFrame = new JFrame("Extensive Calculator");
        panel = new JPanel();
        addActionListenersBtns();
        setupPanels();
        shapes.add(new Rectangle(50,50,500,500));
        panelGraphics.draw(shapes.get(0));
        mainFrame.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                    mainFrame.update(panelGraphics);
            }

            public void componentMoved(ComponentEvent e) {
                mainFrame.update(panelGraphics);
            }

            public void componentShown(ComponentEvent e) {

            }

            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    private void addActionListenersBtns() {
        // TODO: 08.05.16 add ACTIONS FOR FORMULAS
    }

    private void setupPanels() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        mainFrame.setState(Frame.MAXIMIZED_BOTH);
        mainFrame.setJMenuBar(getUpperBar());
        mainFrame.setVisible(true);

        panel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setLocation(0, 0);

        panel.addKeyListener(ActionListeners.getKeyListener());
        panel.addMouseMotionListener(ActionListeners.getMouseMotionListener());
        panel.addMouseWheelListener(ActionListeners.getMouseWheelListener());
        panel.addMouseListener(ActionListeners.getMouseListener());

        mainFrame.add(panel);
        panelGraphics = (Graphics2D) panel.getGraphics().create();
    }

    private JMenuBar getUpperBar() {
        JMenuBar upperBar = new JMenuBar();
        JMenu iOMenu = new JMenu("Files");
        JMenuItem saveCurrState = new JMenuItem("save");
        saveCurrState.addActionListener(ActionListeners.getSaveCalc());
        JMenuItem loadState = new JMenuItem("load");
        loadState.addActionListener(ActionListeners.getLoadCalc());
        JMenuItem importData = new JMenuItem("import data");
        importData.addActionListener(ActionListeners.getImportData());
        iOMenu.add(saveCurrState);
        iOMenu.add(loadState);
        iOMenu.add(importData);
        upperBar.add(iOMenu);
        return upperBar;
    }

    public void display(String keyChar) {
        Font f = panel.getFont().deriveFont(Font.BOLD, 70);
        GlyphVector v = f.createGlyphVector(panel.getFontMetrics(f).getFontRenderContext(), keyChar);
        Shape s = v.getOutline();
        panelGraphics.draw(s);
        shapes.add(s);
        panel.update(panelGraphics);
    }

    public void movePlane(int x, int y) {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        panelGraphics.translate(x,y);
        panel.update(panelGraphics);
    }

    public void zoom(int unitsToScroll) {
        panel.paint(panelGraphics);
    }
}
