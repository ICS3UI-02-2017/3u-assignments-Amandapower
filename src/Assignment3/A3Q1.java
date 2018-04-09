/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a city
        City wr = new City();
        
        // put a robot in the city
        RobotSE bob = new RobotSE (wr, 0, 2, Direction.WEST);

        // create a 2 by 2 square
        new Wall(wr, 1, 1, Direction.WEST);
        new Wall(wr, 2, 1, Direction.WEST);
        new Wall(wr, 1, 1, Direction.NORTH);
        new Wall(wr, 2, 2, Direction.SOUTH);
        new Wall(wr, 2, 1, Direction.SOUTH);
        new Wall(wr, 1, 1, Direction.NORTH);
        new Wall(wr, 1, 2, Direction.NORTH);
        new Wall(wr, 2, 2, Direction.EAST);
        new Wall(wr, 1, 2, Direction.EAST);
        
        //make bobnavigate counter clockwise around the square 2 times
        int numberOfMoves = 2;
       while (numberOfMoves > 0) {
        bob.move();
        bob.move();
        bob.turnLeft();
        bob.move();
        bob.move();
        bob.move();
        bob.turnLeft();
         bob.move();
        bob.move();
        bob.move();
        bob.turnLeft();
          bob.move();
        bob.move();
        bob.move();
        bob.turnLeft();
        bob.move();
        
        numberOfMoves = numberOfMoves - 1;
       }

    }
}
