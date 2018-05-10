/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Powea5594
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // input scanner
        Scanner in = new Scanner(System.in);
        
        // ask user to enter the marks and store them in an array
        double [] marks = new double [10];
        System.out.println("Enter ten marks:");
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
         
    }
}
