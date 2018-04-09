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
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ask theem to enter the speed limit
        System.out.println("Enter the speed limit: ");
        int limit = input.nextInt();

        // ask them to enter the recorded speed of the car 
        System.out.println("Enter the recorded speed of the car: ");
        int speed = input.nextInt();
        
        // calculate how far above the speed limit they are
        int over = speed - limit;

        if (speed <= limit) {
            System.out.println("Congratulations, you are within the speed limit! ");

        }
        
        if (over >=1 && over <= 20){
            System.out.println("You are speeding and your fine is $100");
        }
         if (over >=21 && over <= 30){
            System.out.println("You are speeding and your fine is $270");
        }
          if (over >31){
            System.out.println("You are speeding and your fine is $500");
        }

    }
}