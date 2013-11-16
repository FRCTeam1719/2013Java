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
public interface IJoystick extends IDevice{
    double getAxis(Joystick.AxisType axis);
    boolean getButton(Joystick.ButtonType button);
}
