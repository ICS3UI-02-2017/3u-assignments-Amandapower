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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner input = new Scanner (System.in);
        
        // ask about price of food
         System.out.println("How much does the food for prom cost?");
         double food = input.nextDouble();
         
         // aks about price of Dj
         System.out.println("How much does the DJ cost?");
         double dj = input.nextDouble();
         
         // ask about price for the hall
         System.out.println("How much does it cost to rent the hall?");
         double hall = input.nextDouble();

         // ask about the cost for the decorations
         System.out.println("How much does decorations cost?");
         double decoration = input.nextDouble();
         
         // ask about cost for the staff
         System.out.println("How much does it cost for staff? ");
          double staff = input.nextDouble();
          
          // ask about the cost for miscellaneous
          System.out.println("How much for miscellaneous costs?");
          double misc = input.nextDouble();
          
          // calculate the total cost
          double cost = food + dj + hall + decoration + staff + misc;
          
          // calculate the number of tickets needed
          double tickets = Math.ceil(cost / 35);
          
          //print resulats
          System.out.println("The total cost is $" + cost + ". You will need to sell " + tickets + " to break even.");
    }
}
