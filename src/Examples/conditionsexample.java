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
        RobotSE joe = new RobotSE(u, 2, 1, Direction.EAST);

        //create a wall infront 
        new Wall(u, 2, 5, Direction.EAST);

        // place a few things
        new Thing(u, 2, 2);
        new Thing(u, 2, 4);


        // move while front is clear
        while (joe.frontIsClear()) {
            // if front is clear, do this 
            joe.move();

            // is there something to pick up?
            if (joe.canPickThing()) {
                joe.pickThing();
            }
        }
        //when the front is not clear
        joe.turnRight();

        // do you have one thing in your backpack?
        if (joe.countThingsInBackpack() == 1) {
            joe.move();
        } else if (joe.countThingsInBackpack() == 2) {
            joe.move(2);
        }else{
            joe.turnAround();
            
        } 
    }
}
 

