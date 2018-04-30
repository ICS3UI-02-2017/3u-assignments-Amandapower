/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author powea5594
 */
public class A6Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // input scanner
         Scanner in = new Scanner(System.in);
         
         // ask user how many marks there are 
         System.out.println("How many marks are there?");
         
         // save the number they input
         int marknumb = in.nextInt();
         
         // store the number they input into an array
         double [] marks = new double [marknumb];
         
         //ask user to type out the marks
        System.out.println("Please enter the marks");
       
        for (int i = 0; i < marks.length; i++){
            
            marks [i] = in.nextDouble();
         }
   
        double sort = 0;
        
        for ( int i = 0; i <= (marks.length -1); i++) {

            
        for ( int x = (i + 1); x < marks.length; x++) {
            
        if (marks [i] > marks [x]){
            sort = marks [i];
            
            marks [i] = marks [x];
            
            marks [x] = sort;
            
            
        }
            
        }
        
            
        }
        System.out.println("The marks in order arae " + Arrays.toString(marks));
        
         int mediano = 0;
         int mediant = 0;
         int median = 0;
         
        // find the  median if the array has an even amout of numbers
        if (marknumb % 2 == 0){
           mediano =  marknumb/2 - 1;
           mediant = mediano +1;
           median = mediant + mediano / 2;
            System.out.println("the median of the array is " + median);
           // fins the median if the array has an odd amount of numbers
        }else{
            
        }
    
}
