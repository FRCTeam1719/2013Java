/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author brandon
 */
public class DRobotDrive implements IDevice{
    private SpeedController FL,FR,RL,RR;
    private RobotDrive impl;
    double x,y,rotation;
    
    public DRobotDrive setFL(SpeedController s){
        this.FL=s;
        return this;
    }
    public DRobotDrive setFR(SpeedController s){
        this.FR=s;
        return this;
    }
    public DRobotDrive setRL(SpeedController s){
        this.RL=s;
        return this;
    }
    public DRobotDrive setRR(SpeedController s){
        this.RR=s;
        return this;
    }
    public DRobotDrive init(){
        this.impl=new RobotDrive(FL, RL, FR, RR);
        return this;
    }
    
    public void set(double x, double y, double rotation){
        this.x=x;
        this.y=y;
        this.rotation=rotation;
    }
    
    public void step() {
        impl.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
    
}
