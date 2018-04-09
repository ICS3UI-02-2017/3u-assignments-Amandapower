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
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int previousNumber = 1;
        int currentNumber = 1;
        // ask them to enter the number they rolled and tell them what square they are on

        while (1 == 1) {

            System.out.println("Enter sum of dice: ");
            int sum = input.nextInt();
            // make player enter another number if their roll is not possible with two dice 
            if (sum > 12) {
                System.out.println("I don't think so...");
            } else {
// calculate the square the player is on af`ter their roll 
               
                
                previousNumber = currentNumber;
                currentNumber = previousNumber + sum;
                System.out.println("You are now on square " + currentNumber);
                // make the player return to the appropriate asquare if they land on a snake 
                if (currentNumber == 54) {
                    currentNumber = 19;
                    System.out.println("Oh No! You landed on a snake! You are now on square " + currentNumber);
                }
                if (currentNumber == 90) {
                    currentNumber = 48;
                    System.out.println("Oh No! You landed on a snake! You are now on square " + currentNumber);
                }
                if (currentNumber == 99) {
                    currentNumber = 77;
                    System.out.println("Oh No! You landed on a snake! You are now on square " + currentNumber);
                }
                // move player up if they hit a latter
                if (currentNumber == 9) {
                    currentNumber = 34;
                    System.out.println("Congradulations! You hit a ladder! You are now on square " + currentNumber);
                }
                if (currentNumber == 40) {
                    currentNumber = 64;
                    System.out.println("Congradulations! You hit a ladder! You are now on square " + currentNumber);
                }
                if (currentNumber == 67) {
                    currentNumber = 86;
                    System.out.println("Congradulations! You hit a ladder! You are now on square " + currentNumber);
                }
                  // tell player they win if their roll reaches 100
                 
                 if (currentNumber == 100) {
                    System.out.println("You are now on square " + currentNumber);
                    System.out.println("YOU WIN");
                    System.exit (0);
                }
                 
                 
// keep player on same square if they roll a number that moves them past 100
                while (currentNumber > 100) {
                     currentNumber = previousNumber;
                     System.out.println("You are now on square " + currentNumber);
                     System.out.println("Please input another number");
                    int roll = input.nextInt();
                     previousNumber = currentNumber;
                     currentNumber = previousNumber + roll;
                     
                }
                // print out what square they player is on
                System.out.println("you are now on square " + currentNumber);



            }



        }


    }
}