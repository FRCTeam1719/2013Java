/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author brandon
 */
public class ImplJoystick implements IJoystick{
    int port;
    Joystick impl;
    
    
    
    public ImplJoystick setPort(int port){
        this.port=port;
        return this;
    }
    
    public ImplJoystick init(){
        this.impl = new Joystick(port);
        return this;
    }
    
    public double getAxis(Joystick.AxisType axis) {
        return impl.getAxis(axis);
    }

    public boolean getButton(Joystick.ButtonType button) {
        return impl.getButton(button);
        
    }

    public void step() {
        
    }
    
}
