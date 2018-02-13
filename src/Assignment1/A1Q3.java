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
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create new city "x" 
        City x = new City();
        
        // put robot karel in the city 
        RobotSE karel = new RobotSE (x, 3, 0, Direction.EAST);
       
        
        // create mountain 
        new Wall (x, 1, 3, Direction.EAST);
        new Wall (x, 2, 4, Direction.EAST);
        new Wall (x, 3, 4, Direction.EAST);
        new Wall (x, 1, 3, Direction.NORTH);
        new Wall (x, 2, 4, Direction.NORTH);
        new Wall (x, 1, 3, Direction.WEST);
        new Wall (x, 2, 3, Direction.WEST);
        new Wall (x, 3, 2, Direction.WEST);
        new Wall (x, 3, 2, Direction.NORTH);
        
        // place a newspaper on the porch of karels house
        new Thing(x, 3, 1); 
        
       // karel moves forwards one space
       karel.move();
       
       // karel picks up the thing
       karel.pickThing();
       
       // karel turns left 
       karel.turnLeft();
       
       // karel hikes to the top of the mountain
       karel.move();
       karel.turnRight();
       karel.move();
       karel.turnLeft(1);
       karel.move(2);
       karel.turnRight();
       karel.move();
       
       // kaarel puts down the flag
       karel.putThing();
       
       // karel climbs down the mountain
       karel.move();
       karel.turnRight();
       karel.move();
       karel.turnLeft();
       karel.move();
       karel.turnRight();
       karel.move(2);
       karel.turnLeft();
       
}
