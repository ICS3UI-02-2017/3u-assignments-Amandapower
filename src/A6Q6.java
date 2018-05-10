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
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // insert scanner
        Scanner in = new Scanner(System.in);
        
        // ask user how many students there are 
         System.out.println("How many stuents are in the class?");
         
         // save the number they input
         int students = in.nextInt();
         
         // store the number they input into an array
         double [] array = new double [students];
         
         //ask user to type out the marks
        System.out.println("Please enter the marks");
       
        for (int i = 0; i < array.length; i++){
            
            array [i] = in.nextDouble();
         }
   
        double sort = 0;
        
        for ( int i = 0; i <= (array.length -1); i++) {

            
        for ( int x = (i + 1); x < array.length; x++) {
            
        if (array [i] > array [x]){
            sort = array [i];
            
            array [i] = array [x];
            
            array [x] = sort;
            
            
        }
            
        }
        
            
        }
        
        // compute lowest mark
        System.out.println("The loewst mark is " + array [0]);
        
        // compute the highest mark
        System.out.println("The highest mark is " + array [array.length -1]);
        
        // compute the average
        double sum = 00000000000000000.0;
        
        for (int i = 0; i < array.length; i++){
      
            double mark = array [i];
            
            
            sum = sum + mark;
            
        }
        
        double average = sum /students ;
        
        System.out.println("The class average is "  + average);
    }
}
