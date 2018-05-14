/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author Amanda
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a boolean array up to 1001
        boolean [] array = new boolean [1001];
        
        for(int i = 0; i < array.length; i++){
            array[i] = true;
        }
        
        //make the first prime number equal 2
        int p = 2;
        
        // make a loop to run throughthe array up until 1000
        for (int i =2; i<array.length/p; i++){
            int answer = p*i;
            array [answer]= false;            
        }
        for (int x = 0; x<array.length; x++){
            if (array[x] == false){
                System.out.print(x + ", ");
            }
        }
        
       
        
    }
    
}
