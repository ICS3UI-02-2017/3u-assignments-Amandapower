/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author powea5594
 */
public class A2Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // create new city 
        City s = new City();
        
        // put robot in the city at 1, 5
        RobotSE vix = new RobotSE (s, 1, 5, Direction.EAST);
       
        // vix returns to 0,0 if it isn't at 0,0 
        
        // check if robot isn't facing west if not turn weast
        // when robot is facing west move until it reaches avenue 0
        while(vix.getAvenue()!=0) {
            if (!vix.isFacingWest()) {
                vix.turnLeft();
            }else{ 
                vix.move();
            }
        } 
        // check if the robot is facing north if not turn north
        // when the robot is facing north move until itreaches street 0
        while(vix.getStreet()!=0) {
            if(!vix.isFacingNorth()){
                vix.turnLeft();
            }else{ 
                vix.move();
            }
        }
        
  
                
                
                
    }
}
