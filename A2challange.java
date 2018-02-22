/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assingment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A2challange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // create new city 
        City s = new City();

        // create robot named tina 
        RobotSE tina = new RobotSE(s, 0, 1, Direction.SOUTH);

        //create robot named karel
        RobotSE karel = new RobotSE(s, 0, 1, Direction.SOUTH);

        // create left side of siewalk 
        new Wall(s, 0, 0, Direction.EAST);
        new Wall(s, 1, 0, Direction.EAST);
        new Wall(s, 2, 0, Direction.EAST);
        new Wall(s, 3, 0, Direction.EAST);
        new Wall(s, 4, 0, Direction.EAST);
        new Wall(s, 5, 0, Direction.EAST);
        new Wall(s, 6, 0, Direction.EAST);
        new Wall(s, 7, 0, Direction.EAST);
        new Wall(s, 8, 0, Direction.EAST);
        new Wall(s, 9, 0, Direction.EAST);


        //create right side of sidewalk and end of sidewalk on south side
        new Wall(s, 0, 1, Direction.EAST);
        new Wall(s, 3, 1, Direction.EAST);
        new Wall(s, 5, 1, Direction.EAST);
        new Wall(s, 6, 1, Direction.EAST);
        new Wall(s, 9, 1, Direction.EAST);
        new Wall(s, 9, 1, Direction.SOUTH);

        // create the first driveway (most north) on right side of sidewalk
        new Wall(s, 1, 2, Direction.NORTH);
        new Wall(s, 1, 3, Direction.NORTH);
        new Wall(s, 1, 4, Direction.NORTH);
        new Wall(s, 1, 5, Direction.NORTH);
        new Wall(s, 1, 5, Direction.EAST);
        new Wall(s, 2, 5, Direction.EAST);
        new Wall(s, 2, 2, Direction.SOUTH);
        new Wall(s, 2, 3, Direction.SOUTH);
        new Wall(s, 2, 4, Direction.SOUTH);
        new Wall(s, 2, 5, Direction.SOUTH);

        // build the middle driveway on the right sdie of the sidewalk
        new Wall(s, 4, 2, Direction.NORTH);
        new Wall(s, 4, 3, Direction.NORTH);
        new Wall(s, 4, 4, Direction.NORTH);

        new Wall(s, 4, 4, Direction.EAST);

        new Wall(s, 4, 2, Direction.SOUTH);
        new Wall(s, 4, 3, Direction.SOUTH);
        new Wall(s, 4, 4, Direction.SOUTH);

        // build the last drvewya (most south) on the right side of the sidewalk
        new Wall(s, 7, 2, Direction.NORTH);
        new Wall(s, 7, 3, Direction.NORTH);
        new Wall(s, 7, 4, Direction.NORTH);
        new Wall(s, 7, 5, Direction.NORTH);
        new Wall(s, 7, 5, Direction.NORTH);
        new Wall(s, 7, 6, Direction.NORTH);


        new Wall(s, 8, 6, Direction.EAST);
        new Wall(s, 7, 6, Direction.EAST);

        new Wall(s, 8, 2, Direction.SOUTH);
        new Wall(s, 8, 3, Direction.SOUTH);
        new Wall(s, 8, 4, Direction.SOUTH);
        new Wall(s, 8, 5, Direction.SOUTH);
        new Wall(s, 8, 5, Direction.SOUTH);
        new Wall(s, 8, 6, Direction.SOUTH);

        // put snow (things) on the first driveway and sidewalk infront 
        new Thing(s, 1, 1);
        new Thing(s, 1, 2);
        new Thing(s, 1, 3);
        new Thing(s, 1, 4);
        new Thing(s, 2, 1);
        new Thing(s, 2, 3);
        new Thing(s, 2, 5);

        // put snow on second driveway and sidewalk infront
        new Thing(s, 4, 1);
        new Thing(s, 4, 2);
        new Thing(s, 4, 3);

        // put snow on third driveway and sidewalk infront 
        new Thing(s, 7, 1);
        new Thing(s, 7, 2);
        new Thing(s, 8, 2);
        new Thing(s, 8, 3);
        new Thing(s, 7, 6);
        new Thing(s, 8, 5);

        // make karel sense if there is a driveway there
        while (karel.getCity() == s) {
            while (karel.frontIsClear()) {
                karel.move();
                karel.turnLeft();
                while (karel.frontIsClear()) {
                    karel.move();
                    if (karel.canPickThing()) {
                        karel.pickThing();
                        while(!karel.frontIsClear()){
                            karel.putAllThings();
                                karel.turnRight();
                                if (karel.frontIsClear()) {
                                    karel.move();
                        }

                    
                }
               
                        }
                      
                    }

                }


            }





        }
    }
