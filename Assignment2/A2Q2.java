/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author powea5594
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // create new city 
        City s = new City();
        
        // put robot in the city at 1, 1
        RobotSE vix = new RobotSE (s, 1, 1, Direction.EAST);
        
        // create hurdel couse fro karel to run (track part)
        new Wall(s,1,1, Direction.SOUTH);
        new Wall(s,1,2, Direction.SOUTH);
        new Wall(s,1,3, Direction.SOUTH);
        new Wall(s,1,4, Direction.SOUTH);
        new Wall(s,1,5, Direction.SOUTH);
        new Wall(s,1,6, Direction.SOUTH);
        new Wall(s,1,7, Direction.SOUTH);
        new Wall(s,1,8, Direction.SOUTH);
        new Wall(s,1,9, Direction.SOUTH);
        
        //put thing at the end of course 
        new Thing (s, 1, 9);
        
        // create hurdles fro karel to jump
        new Wall(s,1,1, Direction.EAST);
        new Wall(s,1,2, Direction.EAST);
        new Wall(s,1,4, Direction.EAST);
        new Wall(s,1,7, Direction.EAST);
        
        // make karel jump if there is a hudle in his way
    
        while (!vix.canPickThing()){
           
            
            if(vix.frontIsClear()){
                vix.move();
            }else{
                 vix.turnLeft();
            vix.move();
            vix.turnRight();
            vix.move();
            vix.turnRight();
            vix.move();
            vix.turnLeft();
            }
            
        }
      
  
                
                
                
    }
}
