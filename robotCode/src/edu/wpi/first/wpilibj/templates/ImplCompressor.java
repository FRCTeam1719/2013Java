/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;

/**
 *
 * @author Chance
 */
public class ImplCompressor implements ICompressor {

   private int pressureSwitchChannel = 0;
   private int compressorRelayChannel = 0;
   private int pressureSwitchSlot = 0;
   private int compressorRelaySlot = 0;
   Compressor impl = null;
    public ImplCompressor init() {
        impl = new Compressor( pressureSwitchSlot,pressureSwitchChannel, compressorRelaySlot,compressorRelayChannel);
        impl.start();
        return this;
    }

    public void step() {
        
    }
    
    public ImplCompressor setPressureSwitchChannel(int dio, int slot){
        pressureSwitchChannel = dio;
        pressureSwitchSlot = slot;
        return this;
    }
    public ImplCompressor setCompressorRelayChannel(int relay, int slot){
        compressorRelayChannel = relay;
        compressorRelaySlot = slot;
        return this;
    }
}
