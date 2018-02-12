/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 * Learning how to use the Robots
 * @author Powea5594
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // Create a City for the Robot
        City kw = new City();
        
        // put a robot in kw
        RobotSE cow = new RobotSE(kw, 2, 3, Direction.EAST); 
        
        // create a wall
        new Wall(kw, 2, 5, Direction.WEST);
        
        // create a thing
        new Thing(kw,2, 4); 
        
        // move the robot forward 1 space
        cow.move();
        
        // move the robot n number of spaces 
       // cow.move(2);
        
        // turn the robot to the left
        cow.turnLeft();
        
        // put lable cow on cow
        cow.setLabel("cow");
        // set colour of the robot to yellow
        cow.setColor(Color.yellow);
        
        // pick up the thing
        cow.pickThing();
        
        // move once again
        cow.move();
        
       // put the thing down
        cow.putThing();
        cow.move();
        
        // move cow 20 spaces 
        cow.move(5);
        
        // 
        RobotSE tc = new RobotSE(kw, -8, 4, Direction.SOUTH);
        
    }
}
