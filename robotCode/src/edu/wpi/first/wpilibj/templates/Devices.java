/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author brandon
 */
public class Devices {


    static ICompressor compressor;

    static DRobotDrive robotDrive;
    static Controllers controllers;
    public static ShootingWheel wheel;
    public static IDevice[] DEVICES;

    public static void init() {
        compressor = new ImplCompressor()
                .setCompressorRelayChannel(2,2)
                .setPressureSwitchChannel(7,2)
                .init();
                
        robotDrive = new DRobotDrive()
                .setFL(new Victor(1))
                .setFR(new Victor(2))
                .setRL(new Victor(9))
                .setRR(new Victor(10))
                .init();
        controllers = new Controllers()
                .setDriverJoystick(new ImplJoystick().setPort(1).init())
                .setRobotDrive(robotDrive)
                .init();
        wheel = new ShootingWheel()
                .setMotor(new Victor(2, 5));
        DEVICES = new IDevice[]{robotDrive, controllers, compressor};
    }
}
