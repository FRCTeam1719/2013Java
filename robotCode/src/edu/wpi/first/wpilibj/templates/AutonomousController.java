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
           shoot,
           delay(1000),
           shoot,
           delay(1000),
           shoot,
           delay(1000),
           shoot,
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
        public boolean step() {
            throw new Error("Not Implemented"); //To change body of generated methods, choose Tools | Templates.
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
