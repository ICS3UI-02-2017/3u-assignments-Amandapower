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
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ask for students name
        System.out.println("Please enter your name: ");
        String name = input.nextLine();

        //ask for the marks of the first test
        System.out.println("What was the first test out of?: ");
        double test1 = input.nextDouble();
        System.out.println("What mark did you get?: ");
        double mark1 = input.nextDouble();

        // ask for the marks of the second test
        System.out.println("What was the second test out of?: ");
        double test2 = input.nextDouble();
        System.out.println("What mark did you get?: ");
        double mark2 = input.nextDouble();

        //ask for the marks of the third test
        System.out.println("What was the third test out of?: ");
        double test3 = input.nextDouble();
        System.out.println("What mark did you get?: ");
        double mark3 = input.nextDouble();

        //ask for the marks of the fourth test
        System.out.println("What was the fourth test out of?: ");
        double test4 = input.nextDouble();
        System.out.println("What mark did you get?: ");
        double mark4 = input.nextDouble();

        // ask for the marks of the fifth test
        System.out.println("What was the fifth test out of?: ");
        double test5 = input.nextDouble();
        System.out.println("What mark did you get?: ");
        double mark5 = input.nextDouble();

        // calculate the percent mark for each test
        double percent1 = mark1 / test1 * 100;
        double percent2 = mark2 / test2 * 100;
        double percent3 = mark3 / test3 * 100;
        double percent4 = mark4 / test4 * 100;
        double percent5 = mark5 / test5 * 100;

        // state the test scores 
        System.out.println("Test Scores for" + name);
        System.out.println("Test 1: " + percent1 + "%");
        System.out.println("Test 2: " + percent2 + "%");
        System.out.println("Test 3: " + percent3 + "%");
        System.out.println("Test 4: " + percent4 + "%");
        System.out.println("Test 5: " + percent5 + "%");

        // calculate average 
        double average = (percent1 + percent2 + percent3 + percent4 + percent5) / 5;
        
        // state the average
        System.out.println("Average: " + average + "%" );
    }
}