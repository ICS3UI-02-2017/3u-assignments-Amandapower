/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author powea5594
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new city
        City wr = new City ();
        
        wr.showThingCounts(true);
        
        //put robot in city
        RobotSE bob = new RobotSE (wr, 1, 1, Direction.EAST);
        
        //create a pile of 10 things at 1, 1
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        new Thing (wr, 1, 1);
        
        // make bob move the pile one avenue over
       int numberOfThings = 10; 
       while (numberOfThings > 0){
    bob.pickThing();
    bob.move();
    bob.putThing();
    bob.turnAround();
    bob.move();
    bob.turnAround();
    
           numberOfThings = numberOfThings - 1; 
       }
       bob.move();
    }
}
