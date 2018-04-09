/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A2Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // create new city 
        City s = new City();
        
        // put robot in the city at 1, 2
        RobotSE vix = new RobotSE (s, 1, 2, Direction.EAST);
       
    // create centre of king javas castle
        new Wall (s, 2, 2, Direction.WEST);
        new Wall (s, 3, 2, Direction.WEST);
        new Wall (s, 2, 2, Direction.NORTH);
        new Wall (s, 2, 3, Direction.NORTH);
        new Wall (s, 2, 3, Direction.EAST);
        new Wall (s, 3, 3, Direction.EAST);
        new Wall (s, 3, 2, Direction.SOUTH);
        new Wall (s, 3, 3, Direction.SOUTH);
        
        // create the surrounding squares at each corner of the castle
        new Wall (s, 1, 1, Direction.WEST);
        new Wall (s, 4, 1, Direction.WEST);
        new Wall (s, 4, 4, Direction.WEST);
        new Wall (s, 1, 4, Direction.WEST);
        new Wall (s, 1, 1, Direction.NORTH);
        new Wall (s, 4, 1, Direction.NORTH);
        new Wall (s, 1, 4, Direction.NORTH);
        new Wall (s, 4, 4, Direction.NORTH);
        new Wall (s, 1, 1, Direction.EAST);
        new Wall (s, 1, 4, Direction.EAST);
        new Wall (s, 4, 4, Direction.EAST);
        new Wall (s, 4, 1, Direction.EAST);
        new Wall (s, 1, 1, Direction.SOUTH);
        new Wall (s, 1, 4, Direction.SOUTH);
        new Wall (s, 4, 1, Direction.SOUTH);
        new Wall (s, 4, 4, Direction.SOUTH);
        
        // make the robot patrol the castle
        while(vix.frontIsClear()){
            vix.move();
            if(!vix.frontIsClear())
                vix.turnLeft();
            vix.move();
            vix.turnRight();
            vix.move(2);
            vix.turnRight();
            vix.move(2);
            vix.turnRight();
            vix.move();
            vix.turnLeft();
            
        }
        
        
        
  
                
                
                
    }
}
