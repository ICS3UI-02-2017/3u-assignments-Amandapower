/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author powea5594
 */
public class ForLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        City h = new City ();
      RobotSE joe = new RobotSE (h, 1, 1, Direction.EAST); 
    
       // counted while loop
       int numberOfMoves = 5;
       while (numberOfMoves > 0) {
        joe.move();
        numberOfMoves = numberOfMoves - 1;
    }
       joe.turnAround();
       
       //counting the other way 
       numberOfMoves = 0; 
       while (numberOfMoves < 5){
           joe.move();
           numberOfMoves = numberOfMoves + 1; 
       }
       joe.turnAround();
       //use a froloop to move
       for(int count = 0; count < 5; count ++) {
           joe.move();
       }
       int x = 10;
       x = x + 5; // adds 5
       x += 5; // adds 5
       
       x-= 10; // subtract 10 shortcut 
       x = x - 10; 
       
       x *= 2; // multipy by 2
       x = x * 2; 
       
       x /= 4;
       x = x / 4; 
       
       //modulus  or modulo 
       int remainder = 5 / 2; 
        int quotient = 5 % 2; 
        
        if (joe.frontIsClear()) {
            if (joe.canPickThing()){
                joe.move();
            }
        }
        // both must be true to perform the action 
        if (joe.frontIsClear() && joe.canPickThing()) {
            joe.move();
        }
          if (joe.frontIsClear() || joe.canPickThing()) {
            joe.move();
        }
    }
}
