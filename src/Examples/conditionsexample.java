/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class conditionsexample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //create a city
        City u = new City();
        
        //create a robot 
        RobotSE joe = new RobotSE (u, 2, 1, Direction.EAST); 
        
        //create a wall infront 
        new Wall (u, 2, 5, Direction.EAST); 
        
        // move while front is clear
        while(joe.frontIsClear()) 
            // if front is clear, do this 
            joe.move();
        
        //when the front is not clear
        joe.turnRight();
        
    }
}
