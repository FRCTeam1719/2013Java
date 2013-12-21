/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author brandon
 */
//Brandon want monad
public class AutonomousController implements IDevice{
    State commands;
    
    public AutonomousController(){
        commands= chain(new State[]{
           wheelStart,
           delay(1000),
           shoot,
           delay(1000),
           shoot,
           delay(1000),
           shoot,
           delay(1000),
           shoot,
           wheelStop,
           nop
        });
    }
    
    public void step() {
        commands.init();
        commands.step();
    }
    
    private abstract class State{
        abstract public boolean step();
        public void init(){};
    }
        
    private State delay(final long ms){
        return new State() {
            long stopTime;
            public boolean step() {
                return Utils.getTime()>stopTime;
            }
            public void init(){
                stopTime = Utils.getTime() + ms;
            }
        };
    }
    
    private State shoot = new State() {
        boolean done;
        Shooter shooter = new Shooter();
        public boolean step() {
            return done;
            //throw new Error("Not Implemented"); //To change body of generated methods, choose Tools | Templates.
        }
        public void init() {
            shooter.inject();
            done = true;
        }
    };
    private State wheelStart = new State() {
        ShootingWheel wheel = new ShootingWheel();
        boolean done;
        public boolean step() {
            return done;
        }
        public void init(){
            wheel.spinWheel(true);
            done = true;
        }
    };
    private State wheelStop = new State() {
        ShootingWheel wheel = new ShootingWheel();
        boolean done;
        public boolean step() {
            return done;
        }
        public void init(){
            wheel.spinWheel(false);
            done = true;
        }
    };
    
    private State nop = new State() {
        public boolean step() {
            return false;
        }
    };
    
    private State chain(final State[] sx){
        return new State() {
            int i=0;
            public boolean step(){
                if(sx[i].step()){
                    i++;
                    if(i>=sx.length){
                        i--;
                        sx[i]=nop;
                        return true;
                    }
                    sx[i].init();
                }
                return false;
            }
        };
    }
}
