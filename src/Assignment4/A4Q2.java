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
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ask user to entre a measurement in inches
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the measurement in inches you wish to convert: ");
        
        // calculate the measurement in cm
      
         double number = input.nextDouble();
         double cm = number * 2.54;
         
         // print out the answer
         System.out.println( number + " inches is the same as " + cm + " cm");
    }
}
