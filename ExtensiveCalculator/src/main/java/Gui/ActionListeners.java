package Gui;

import OtherIO.MainResources;

import java.awt.event.*;

/**
 * @author Jari Van Melckebeke
 */
public class ActionListeners {
    private static boolean isMoving = false;
    private static ActionListener saveCalc = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // TODO: 08.05.16 make SAVING possible
        }
    };
    private static ActionListener loadCalc = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // TODO: 08.05.16 make LOADING possible
        }
    };
    private static ActionListener importData = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // TODO: 08.05.16 make IMPORTING DATA possible
        }
    };
    private static KeyListener keyListener = new KeyListener() {
        public void keyTyped(KeyEvent e) {
            // TODO: 10.05.16 add KEY TYPED EVENT
            if (e.isActionKey()) {
            } else {
                switch (e.getKeyChar()) {
                    default:
                        MainResources.mainGui.display(String.valueOf(e.getKeyChar()));
                }
            }
        }

        public void keyPressed(KeyEvent e) {
            // TODO: 10.05.16 add KEY PRESSED EVENT
        }

        public void keyReleased(KeyEvent e) {
            // TODO: 10.05.16 add KEY RELEASED EVENT
        }
    };
    private static MouseListener mouseListener = new MouseListener() {
        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
            isMoving = true;
        }

        public void mouseReleased(MouseEvent e) {
            if(isMoving)
                MainResources.mainGui.movePlane(e.getX(),e.getY());
            isMoving = false;
        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    };
    private static MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }
    };
    private static MouseWheelListener mouseWheelListener = new MouseWheelListener() {
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.isControlDown())
                MainResources.mainGui.zoom(e.getUnitsToScroll());
        }
    };

    public static ActionListener getSaveCalc() {
        return saveCalc;
    }

    public static ActionListener getLoadCalc() {
        return loadCalc;
    }

    public static ActionListener getImportData() {
        return importData;
    }

    public static KeyListener getKeyListener() {
        return keyListener;
    }

    public static MouseMotionListener getMouseMotionListener() {
        return mouseMotionListener;
    }

    public static MouseWheelListener getMouseWheelListener() {
        return mouseWheelListener;
    }

    public static MouseListener getMouseListener() {
        return mouseListener;
    }
}
