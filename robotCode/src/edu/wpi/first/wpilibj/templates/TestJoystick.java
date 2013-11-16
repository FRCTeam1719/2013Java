/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import java.util.Hashtable;

/**
 *
 * @author brandon
 */
public class TestJoystick implements IJoystick{

    //We probably could implement these as arrays
    //But I don't want to make assumptions about
    //What int values the library uses as tokens
    Hashtable axisVals = new Hashtable();
    Hashtable buttonVals = new Hashtable();
    public double getAxis(Joystick.AxisType axis) {
        Double ans = (Double) axisVals.get(axis);
        if (ans==null){
            return 0;
        }
        return ans.doubleValue();
    }

    public boolean getButton(Joystick.ButtonType button) {
        Boolean ans = (Boolean) buttonVals.get(button);
        if (ans==null){
            return false;
        }
        return ans.booleanValue();
    }
    
    public void setAxis(Joystick.AxisType axis, double val){
        axisVals.put(axis, Double.valueOf(val));
    }
    public void setButton(Joystick.ButtonType button, boolean val){
        buttonVals.put(button, Boolean.valueOf(val));
    }

    public void step() {

    }
    
}
