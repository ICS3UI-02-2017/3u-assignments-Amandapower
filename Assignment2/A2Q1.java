/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author powea5594
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // create new city 
        City s = new City();
        
        // put robot in the city at 1, 1
        RobotSE vix = new RobotSE (s, 1, 1, Direction.EAST);
        
        // place 10 things in a line infront of the robot
        new Thing (s, 1, 2);
        new Thing (s, 1, 3);
        new Thing (s, 1, 4);
        new Thing (s, 1, 5);
        new Thing (s, 1, 6);
        new Thing (s, 1, 7);
        new Thing (s, 1, 8);
        new Thing (s, 1, 9);
        new Thing (s, 1, 10);
        new Thing (s, 1, 11);
        
        // robot moves forwards and picks up 7 things then moves to the end of the row
        while(vix.countThingsInBackpack()<=6){
            vix.move();
            vix.pickThing();
            if (vix.countThingsInBackpack()>=7)
                vix.move(4);
        }
  
                
                
                
    }
}
