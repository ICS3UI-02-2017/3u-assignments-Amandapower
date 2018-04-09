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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner input = new Scanner (System.in);
        
        // ask user to entre a 4 numbers
        System.out.println("Please enter in 4 numbers on separate lines");
        
        // store the numbers
        double one = input.nextDouble();
        double two = input.nextDouble();
        double three = input.nextDouble();
        double four = input.nextDouble();
        
        // print out the numbers in order
        System.out.println("Your numbers were " + one + "," + two +","+ three + ",and" + four);


    }
}
