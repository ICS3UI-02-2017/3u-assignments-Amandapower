/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

/**
 *
 * @author powea5594
 */
public class A7Q1 {
    
    public static double circleArea (double a){
        double area = Math.PI*a*a;
        return area;
    }
    
     public static void examGrade (double a){
        if (a<50){ 
            System.out.println("F");
        }
        if (a >=50 && a <=59){
            System.out.println("D");
        }
        if (a>= 60 && a <=69) {
            System.out.println("C");
        }
        if (a>= 70 && a <=79){
            System.out.println("B");
        }
        if (a == 80 || a> 80){
            System.out.println("A");  
        }
            
    }
      public static void factors (double a){
          for (int i = 0; i <= a; i ++) {
              
              if ( a%i == 0) {
                  System.out.println(i);
              }
          }
      }
      
      public static double compoundintrest (double p, double r, double n ){
          double a = 1+r;
          double x = p*Math.pow(a, n);
          return x;
      }
      
      public static void chaotic (int rows){
        
        for (int i = 0; i <= rows; i++){
            int randNum = (int)(Math.random()*(5 - 1 + 1))+ 1  ;
        if (randNum == 1) {
              System.out.println("*");
        }
         if (randNum == 2) {
              System.out.println("**");
        }
         if (randNum == 3) {
              System.out.println("***");
        }
         if (randNum == 4) {
              System.out.println("****");
        }
         if (randNum == 5) {
              System.out.println("*****");
        }
      }
      }
      
        public static double lastDigit (double a){
     double last =a%10;
     double answer = last;
     if (a<0){
         last = a*-1;
       answer = last%10;
     }
     return answer;
        }
        
       public static double firstDigit (double a) {
          v
       }
      
    
    
    
 public static void main(String[] args) {
        
    }
    
  
}
