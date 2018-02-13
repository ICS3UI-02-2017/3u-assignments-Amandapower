/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A1Q1 {
    private static City nyc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new city nyc
            City nyc = new City();
       
       // create a two by two square of walls
            new Wall(nyc, 1, 1, Direction.NORTH);
            new Wall(nyc, 1, 2, Direction.NORTH);
            new Wall(nyc, 1, 2, Direction.EAST);
            new Wall(nyc, 2, 2, Direction.EAST);
            new Wall(nyc, 2, 1, Direction.SOUTH);
            new Wall(nyc, 2, 2, Direction.SOUTH);
            new Wall(nyc, 1, 1, Direction.WEST);
            new Wall(nyc, 2, 1, Direction.WEST);
            
            // create new robot bob
             RobotSE bob = new RobotSE(nyc, 0, 2, Direction.WEST);
             
           // travel counter clockwise around the square until it reaches it's starting position again
             bob.move(2);
             bob.turnLeft();
             bob.move(3);
             bob.turnLeft();
             bob.move(3);
             bob.turnLeft();
             bob.move(3);
             bob.turnLeft();
             bob.move();
    }
}
