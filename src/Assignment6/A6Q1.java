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
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // input new scanner
        Scanner in = new Scanner(System.in);

        //ask how many students are in the class
        System.out.println("How many students are in the class? ");
        
        //save number of students 
        int students = in.nextInt();
        
        // store number of stuednts in the array
        double [] studentnumber = new double [students];
        
        double sum = 00000000000000000.0;
        
        for (int i = 0; i < studentnumber.length; i++){
            System.out.println("Enter the marks:");
            studentnumber [i] = in.nextDouble();
            double mark = studentnumber [i];
            
            
            sum = sum + mark;
            
        }
        
        double average = sum /students ;
        
        System.out.println("The class average is " + (Math.round(average * 100.0)/ 100.0) + "%");


    }
}
