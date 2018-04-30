/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author powea5594
 */
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // input a scanner
         Scanner in = new Scanner(System.in);
         
         // ask how many people there are
         System.out.println("How many people are there?");
         
         //save number of people 
         int people = in.nextInt();
         
         // store number of people in an array
         double [] numberpeople = new double [people];
         
         double sum = 00.00;
         
         // 
          for (int i = 0; i < numberpeople.length; i++){
            System.out.println("Enter the heights:");
            numberpeople [i] = in.nextInt();
            double height = numberpeople [i];
            
            sum = sum + height ;
    }
          
          double averageheight = sum /people ;
       
          for (int i = 0; i < numberpeople.length; i++) {
              if(numberpeople [i] >averageheight)
                  System.out.println(numberpeople [i] + " is above the average heigt");
          }
              
          }
} 
