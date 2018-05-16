/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

/**
 *
 * @author Amanda
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create boolean array up to 1001
        boolean[] array = new boolean[1001];

        // mark everything in the boolean array as true(prime)
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }

        // set the first prime number to 2
        int p = 2;

        // go through the array and find the nonprime numbers
        for (int i = 2; i < array.length; i++) {
            //multiply the position in the array by the most recent prime number
            int answer = p * i;
            // mark the answer from the previous calculation as flase (not prime)
            array[answer] = false;
            
            if (i>2 && i != p*i){
                array [i]= true;
                p = i;
                
            }
            p= i;
            System.out.println(p);
        }



    }
}
