/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new city
        City wr = new City();

        //put robot in city
        RobotSE karel = new RobotSE(wr, 3, 3, Direction.SOUTH);

        // create the first square 
        new Wall(wr, 1, 1, Direction.NORTH);
        new Wall(wr, 1, 1, Direction.WEST);
        new Wall(wr, 1, 2, Direction.NORTH);
        new Wall(wr, 2, 1, Direction.WEST);
        new Wall(wr, 2, 1, Direction.SOUTH);
        new Wall(wr, 2, 2, Direction.SOUTH);
        new Wall(wr, 1, 2, Direction.EAST);
        new Wall(wr, 2, 2, Direction.EAST);

        // create the second square
        new Wall(wr, 1, 4, Direction.NORTH);
        new Wall(wr, 2, 4, Direction.WEST);
        new Wall(wr, 1, 5, Direction.NORTH);
        new Wall(wr, 1, 4, Direction.WEST);
        new Wall(wr, 2, 5, Direction.SOUTH);
        new Wall(wr, 2, 4, Direction.SOUTH);
        new Wall(wr, 1, 5, Direction.EAST);
        new Wall(wr, 2, 5, Direction.EAST);

        // create third square
        new Wall(wr, 4, 5, Direction.NORTH);
        new Wall(wr, 4, 4, Direction.WEST);
        new Wall(wr, 4, 4, Direction.NORTH);
        new Wall(wr, 5, 4, Direction.WEST);
        new Wall(wr, 5, 4, Direction.SOUTH);
        new Wall(wr, 5, 5, Direction.SOUTH);
        new Wall(wr, 5, 5, Direction.EAST);
        new Wall(wr, 4, 5, Direction.EAST);

        // create fourth square
        new Wall(wr, 4, 1, Direction.NORTH);
        new Wall(wr, 4, 1, Direction.WEST);
        new Wall(wr, 4, 2, Direction.NORTH);
        new Wall(wr, 5, 1, Direction.WEST);
        new Wall(wr, 5, 1, Direction.SOUTH);
        new Wall(wr, 5, 2, Direction.SOUTH);
        new Wall(wr, 5, 2, Direction.EAST);
        new Wall(wr, 4, 2, Direction.EAST);

        //    make karel go arounf the 4 
        for (int count = 0; count < 4; count++) {

            for (int turn = 0; turn < 3; turn++) {
                karel.move(3);
                karel.turnLeft();

            }
            karel.move(3);
        }




    }
}
