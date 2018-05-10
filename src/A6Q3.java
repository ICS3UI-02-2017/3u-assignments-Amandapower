/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author Powea5594
 */
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // input scanner
         Scanner in = new Scanner(System.in);
         
        
        
         // save input numbers into an array
         int [] ingers = new int [2];
         for (int i = 0; i < ingers.length; i++){
            System.out.println("Enter two intergers:");
            ingers [i] = in.nextInt();
         }
         
         int a = ingers[0];
         int b = ingers[1];
         
         if ( a > b){
             System.out.println("The integers in ascending order are: " + b + ", " + a);
         }
         if ( b > a){
             System.out.println("The integers in ascending order are: " + a + "," + b);
             
         }
       
    }
}
