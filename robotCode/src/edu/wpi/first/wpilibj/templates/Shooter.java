/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import java.util.Date;

/**
 *
 * @author aaron
 */
public class Shooter implements IDevice {

    SpeedController motor = null;
    Relay injector = null;
    boolean isSpinning;
    long end;

    public void step() {

        if (isSpinning) {
            motor.set(1.0);
        } else {
            motor.set(0);
        }

        if (new Date().getTime() <= end) {
            injector.set(Relay.Value.kOn);
        } else {
            injector.set(Relay.Value.kOff);  
        }

    }

    public void speedOn() {
        isSpinning = true;
    }

    public void speedOff() {
        isSpinning = false;
    }

    public void inject() {
        end = (new Date()).getTime() + 1000;
    }
}
