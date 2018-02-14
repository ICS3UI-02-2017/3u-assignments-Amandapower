/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

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
        RobotSE joe = new RobotSE (u, 2, 1, Direction.EAST); 
        
        
    }
}
