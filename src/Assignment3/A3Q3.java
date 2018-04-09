/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author powea5594
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new city
        City wr = new City();

        //put robot in city
        RobotSE karel = new RobotSE(wr, 1, 1, Direction.EAST, 20);

        // make karel plant his crops in rows of 4 by 5
        int numberOfMoves = 2;
       while (numberOfMoves > 0) {
           
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.move();
         karel.putThing();
         
         karel.turnRight();
        karel.move();
         karel.turnRight();
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.move();
         karel.putThing();
         karel.turnLeft();
         karel.move();
         karel.turnLeft (); 
         
         
         
        numberOfMoves = numberOfMoves - 1;
        }
    }
}
