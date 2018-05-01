/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author powea5594
 */
public class inputoutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //print a line of text 
        System.out.println("Hello World");
        System.out.println("Another line!");

        //shortcut type sout then press tab
        System.out.println("");
        
       // print a blank line
        System.out.println("");
        
        // print on samen line
        System.out.print("I like");
        System.out.print("cake!");
        
        // can use both println and print
        System.out.print("I like");
        System.out.println("cake!");
        
        // printing special characters
        // quotation marks use a \" at start and end of what you wnat in the quotations
        System.out.println("\"inside quotation marks\"");
        
        // for a slash use two slashes \\
        System.out.println("A slash \\");
        
        // a tab or indent \t
        System.out.println("pop\tpizza\tfries");
        
        // a new line \n put things on different lines
        System.out.println("one line\nsecond line");
        
        // make an integer storing 10
        // print the variable on the screen
        int number = 10; 
        System.out.println(number);
        
        // adding words to numbers or print words and numbers on screen
        System.out.println("number = " + number);
        System.out.println("number = " + number + " .YAY!");
        
        // used a scanner to read info
        Scanner input = new Scanner (System.in);
        
        // tell them what to do before the scanner
        System.out.println("Please enter your name");
        
        // make a variable a string to store a name
        String name = input.nextLine();
        
        // say hello after name is entred 
        System.out.println("Hello " + name);
        
        // figuring out someons age
        // ask what year they were born
        System.out.println("What year were you born?");
        
        // make a variable to store the year int
        int birthyear = input.nextInt();
        
        // calculate age
        int age = 2018 - birthyear;
        
        //your an idiot loop
        while(age < 0){
            System.out.println("try again...");
            birthyear = input.nextInt();
            age = 2018 - birthyear; 
        }
        
        // tell the user what you found out (age)
        System.out.println("you are " + age + " years old!");
        
        // use loops and conditions with the text
        if (age < 0){
            System.out.println("I don't think so...");
        }else if (age > 30){
            System.out.println("you are old");
        }
        
        
    }
}
