/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author powea5594
 */
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ask user to entre their name
        System.out.println("Please entre your name");
        
        //say hello with their name after it has been entred
        Scanner input = new Scanner (System.in);
        String name = input.nextLine();
        System.out.println("Hello " + name);
        
    }
}
