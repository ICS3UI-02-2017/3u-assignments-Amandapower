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
    
    public static double areacircle (double a){
        double area = Math.PI*a*a;
        return area;
    }
    
     public static void lettergrade (double a){
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
        public static double lastDigit (double a){
     double last =a%10;
     double answer = last;
     if (a<0){
         last = a*-1;
       answer = last%10;
     }
     return answer;
        }
      
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     double test = lastDigit (-2347);
        System.out.println(test);
    }
}
