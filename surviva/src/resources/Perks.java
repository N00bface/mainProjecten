package resources;

import javax.swing.*;
import java.io.File;

/**
 * Created by Jari on 28/12/2015.
 */
public class Perks {
    public static Perks rapid ;
    public static Perks freeze;

    public Perks(){

    }
    public static int getAverageHeight() {
        Icon perk = (Icon) new File("F:\\programmeerprojecten-rescourses\\surviva\\perks\\Stamin-Up.png").getAbsoluteFile();
        return perk.getIconHeight();
    }
}
