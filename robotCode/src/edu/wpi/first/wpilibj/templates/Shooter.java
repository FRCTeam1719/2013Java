/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import java.util.Date;

/**
 *
 * @author aaron
 */
public class Shooter implements IDevice {

    
    Relay injector = null;
    
    long end;

    public void step() {

       

        if (new Date().getTime() <= end) {
            injector.set(Relay.Value.kOn);
        } else {
            injector.set(Relay.Value.kOff);  
        }

    }

    

    public void inject() {
        end = (new Date()).getTime() + 1000;
    }
}
