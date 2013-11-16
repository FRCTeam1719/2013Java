/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SimpleRobot;
import java.util.Date;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("INIT");
        Devices.init();
    }

    public void autonomousInit(){
        //NOP?
        Devices.controllers.disbale();
        state=0;
    }
    /**
     * This function is called periodically during autonomous
     */
    int state=0;
    public void autonomousPeriodic() {
    }
    
    public void teleopInit(){
        Devices.controllers.enable();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    private void step(){
        for(int i=0; i< Devices.DEVICES.length; i++){
            Devices.DEVICES[i].step();
        }
    }
 
    
    
    private void wait(int milli){
        long start=(new Date()).getTime();
        while ((new Date()).getTime() - start < milli){
            step();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
