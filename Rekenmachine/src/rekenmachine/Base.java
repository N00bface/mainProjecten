/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekenmachine;

import java.util.Scanner;

/**
 *
 * @author Jari
 */
public class Base {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String in;
        System.out.println("geef uw bewerking in");
        in = input.next();
        input.close();
        
       //haakjes vervangen
        in = Haakjes.HaakjesVervangen(in);
        System.out.println(Berekenen.Base(in));
        
    
    }
}
