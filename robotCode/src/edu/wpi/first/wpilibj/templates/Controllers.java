/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author brandon
 */
public class Controllers implements IDevice{
    IJoystick driverJoystick;
    DRobotDrive robotDrive;
    boolean enabled=false;
    
    public Controllers setDriverJoystick(IJoystick j){
        driverJoystick=j;
        return this;
    }
    public Controllers setRobotDrive(DRobotDrive drive){
        this.robotDrive=drive;
        return this;
    }
    public Controllers init(){
        return this;
    };
    public void enable(){
        this.enabled=true;
    }
    public void disbale(){
        this.enabled=false;
    }
    
    
    public void step() {
        if(enabled){
            double x = driverJoystick.getAxis(Joystick.AxisType.kX);
            double y = driverJoystick.getAxis(Joystick.AxisType.kY);
            double rotation = driverJoystick.getAxis(Joystick.AxisType.kZ);
            robotDrive.set(x, y, rotation);
        }
    }
    
}
