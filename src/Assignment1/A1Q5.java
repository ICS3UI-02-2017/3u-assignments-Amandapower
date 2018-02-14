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
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create new city "x" 
        City x = new City();
        
        // put new robot karel in city at 3.3 
        RobotSE karel = new RobotSE (x, 3, 3,Direction.EAST);
        
        // put new robot maria in city at 0.1 
        RobotSE maria = new RobotSE (x, 0, 1, Direction.WEST);
        
        // put label M on maria
       maria.setLabel("M");
       
       // put label K on karel
       karel.setLabel("K");
       
       //create a line of things
       new Thing (x, 0, 0);
       new Thing (x, 1, 0);
       new Thing (x, 1, 1);
       new Thing (x, 1, 2);
       new Thing (x, 2, 2);
       
       //create karels home
       new Wall(x, 2, 3, Direction.WEST);
       new Wall(x, 2, 3, Direction.NORTH);
       new Wall(x, 2, 3, Direction.EAST);
       new Wall(x, 3, 3, Direction.EAST);
       new Wall(x, 3, 3, Direction.SOUTH);
       
       // move maria to pick up the first item
       maria.move();
       maria.pickThing();
       maria.turnLeft();
       
       // move karel to pick up th first item
       karel.turnLeft(2);
       karel.move();
       karel.turnRight();
       karel.move();
       karel.pickThing();
       
       // move maria to pick up the second item 
       maria.move();
       maria.pickThing();
       maria.turnLeft();
       
       // move karel to pick up her second item
     karel.move();
     karel.pickThing();
     karel.turnLeft();
     
     //move maria to pick up her last thing
     maria.move();
     maria.pickThing();
     
       
        
    }
}
