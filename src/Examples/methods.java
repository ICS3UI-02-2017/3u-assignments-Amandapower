/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author Powea5594
 */
public class methods {
    
    // the hello world method to say hello
    public static void helloworld (){
        System.out.println("hellow world!");
    }
    
    // say hello to user
    public static void sayhello (String name){
        System.out.println("Hello " + name);
    }
    // calculates the positive part of the quadreatic formula (positive root)
    public static double posquadform (double a, double b, double c){
        double discrim = b*b - 4*a*c;
        double root = (-b + Math.sqrt(discrim))/ (2*a);
        // send back the root
        return root;
    }
    
      public static double [] quadform (double a, double b, double c){
        // create the array to store both roots
          double [] roots = new double [2];
          double discrim = b*b - 4*a*c;
        roots [0] = (-b + Math.sqrt(discrim))/ (2*a);
        roots [1] = (-b - Math.sqrt(discrim))/ (2*a);
        // send back the root
        return roots;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // main method
        Scanner in = new Scanner (System.in);
    //return type(void) // name of the method(main) //arguments or perameters (String[] args)
        
    // retun type - are you sending back an answer? anything other than void - send back that kind of answer
        // ex send back a decimal - instead of void - double 
        // cacn be double, int, array, etc.
    // argument or perameter - anything extra it needs to run
        // ex. public double areacircle (double radius)
        // ex. public double arearect (double length, double width) 
   
        
    // call the helloworld method - tell it to run   
     helloworld ();
    
    //
        System.out.println("what is your name?");
        String user = in.nextLine();
        sayhello (user);
     sayhello ("bob");
     
     //calculate the square root of 
    double proot =  posquadform (1,-5, -50);
        System.out.println("The positive root is " + proot);

        double [] roots = quadform (1, -5, -50);
        
        System.out.println("the roots are " + roots[0]+ "and " + roots [1]);
  
     
        
        
        
        
        
        
        
        
    }
}
