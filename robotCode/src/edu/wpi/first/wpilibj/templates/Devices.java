/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;


/**
 *
 * @author brandon
 */
public class Devices {
    
    static DRobotDrive robotDrive;
    static Controllers controllers;
    public static IDevice[] DEVICES;
    
    public static void init(){
        robotDrive=new DRobotDrive()
            .setFL(new Jaguar(1))
            .setFR(new Jaguar(2))
            .setRL(new Jaguar(3))
            .setRR(new Jaguar(4))
            .init();
        controllers = new Controllers()
            .setDriverJoystick(new ImplJoystick().setPort(1).init())
            .setRobotDrive(robotDrive)
            .init();
        DEVICES= new IDevice[]{robotDrive,controllers};
    }
}
