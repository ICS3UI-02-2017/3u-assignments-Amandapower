/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Scanner;

/**
 *
 * @author Amanda
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner g = new Scanner(System.in);
        // repeat the translater
        while (true) {
            // get user to imput a word
            System.out.println("Please enter a word to translate: ");
            String OGword = g.nextLine();

            // convert the word to all lowercase
            OGword = OGword.toLowerCase();

            // make a new string of vowels
            String vowel = "aeiou";
            //create empty string to hold translated word
            String transword = "";

            //check for vowels in the word
            // check each character from the star of the word to the end of the word
            for (int i = 0; i < OGword.length(); i++) {
                String c = "" + OGword.charAt(i);
                // check to see if the string of vowels contains the character at i, if it does it's a vowel
                if (vowel.contains(c)) {
                    // if the character at i is a vowel, add ub to the translated word string and then the vowel
                    transword += "ub" + c;
// if the previous character was a vowel chack to see if the one after it is also a vowel
                    while ((i + 1) < OGword.length() && vowel.contains(c = "" + OGword.charAt(i + 1))) {
                        // if the character after the vowel is also a vowel, simply add that character to the translated word
                        transword += c;
                        // make sure the for loop knows that the next letter has been checked
                        i++;
                    }

                } else {
                    // if the character is not a vowel, simply add it to the translated word
                    transword += c;
                }
            }
            // tell the user what the translated word is 
            System.out.println(OGword + " in Ubbi Dubbi is " + transword + "\n");
        }
    }

}
