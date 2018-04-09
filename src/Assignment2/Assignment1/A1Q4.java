/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create new city "x" 
        City x = new City();
        
        // put new robot rm in city at 0.0 
        RobotSE rm = new RobotSE (x, 0, 0,Direction.SOUTH);
        
        // put new robot RP in city at 0.1 
        RobotSE rp = new RobotSE (x, 0, 1, Direction.SOUTH);
        
        // create wall between two robots and one infront of the robot at 1, 1
        new Wall (x, 0, 1, Direction.WEST);
        new Wall (x, 1, 1, Direction.WEST);
        new Wall (x, 1, 1, Direction.SOUTH);
        
        // move robot rm one space away from the meeting point
        rm.move(2);
        rm.turnLeft();
        
        // move robot rp to the meeting point
        rp.move();
        rp.turnLeft();
        rp.move();
        rp.turnRight();
        rp.move();
        rp.turnRight();
        rp.move();
        
        //move robot rm one space to meet with robot rp
        rm.move();
    
    }
}
