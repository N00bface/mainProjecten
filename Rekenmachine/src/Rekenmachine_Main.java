package rekenmachine;

import java.util.Scanner;

/**
 *
 * @author Jari Van Melckebeke
 */
public class Rekenmachine_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //vars
        Scanner input = new Scanner(System.in);
        
        //input
        System.out.println("geef uw formule in ");
        String in = input.next();
        input.close();
        
        //controle haakjes
        if(in.contains("(")&&in.contains(")")){
            String sub = in.substring(in.indexOf("(")+1, in.lastIndexOf(")")-1);
            //verwijzing naar methode rekenuit.
        }
    }
    
}
