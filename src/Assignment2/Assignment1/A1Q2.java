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
public class A1Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create new city "x" 
        City x = new City();
        
        // put robot karel in the city 
        RobotSE karel = new RobotSE (x, 1, 2, Direction.SOUTH);
       
        
        // create karels house with walls leaving an opening where the portch is
        new Wall (x, 1, 2, Direction.EAST);
        new Wall (x, 1, 2, Direction.NORTH);
        new Wall (x, 1, 1, Direction.NORTH);
        new Wall (x, 1, 1, Direction.WEST);
        new Wall (x, 2, 1, Direction.WEST);
        new Wall (x, 2, 1, Direction.SOUTH);
        new Wall (x, 1, 2, Direction.SOUTH);
        
        // place a newspaper on the porch of karels house
        new Thing(x, 2, 2); 
        
        // karel turns right
        karel.turnRight();
        
        // karel mover forwards one space
        karel.move();
        
        // karel turns left 
        karel.turnLeft();
        
        // karel moves forwards one space
        karel.move();
        
        // karel turns to the left
        karel.turnLeft();
        
        // karel moves frowards one space
        karel.move();
        
        // karel picks up the newspaper 
        karel.pickThing();
        
        // karel turns around 
        karel.turnLeft(2);
        
        // karel returns back to her bed
        karel.move();
        karel.turnRight();
        karel.move();
        karel.turnRight();
        karel.move(1);
        karel.turnRight();
        
        
    }
}
