package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SpeedController;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brandon
 */
public class TestSpeedController implements SpeedController{
    double speed=0;
    boolean enabled=true;
    public double get() {
        return speed;
    }

    public void set(double d, byte b) {
        set(d);
    }

    public void set(double d) {
        this.speed=d;
    }

    public void disable() {
        this.enabled=false;
    }

    public void pidWrite(double d) {
        this.speed=d;
    }
    
}
