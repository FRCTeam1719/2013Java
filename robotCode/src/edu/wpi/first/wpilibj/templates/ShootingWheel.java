/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author aaron
 */

    

public class ShootingWheel implements IDevice{
  
    SpeedController motor = null;
    boolean spin;
    public void step(){
        if(spin){
            motor.set(1.0);
        }
        else{
            motor.set(0);
        }
    }
    public ShootingWheel setMotor(SpeedController s){
        motor = s;
        return this;
    }
    public void spinWheel(boolean x){
        spin = x;
    }
    
    
}
