package org.usfirst.frc.team233.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class implement the code necessary
 * to control the active gear slot mechanism.
 * 
 *  NOTE: This is currently a skeleton implementation
 *  and might be missing other necessary methods and 
 *  information. 
 */
public class GearSlot extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid gearSlot = new Solenoid(1);
	private Solenoid ejectMechanism = new Solenoid(2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * This method implements the code logic needed
     * to open the gear slot doors
     */
    public void openGearSlot() {
    	// Code for opening the gear slot
    	//gearSlot.set(true);
    }

    /**
     * This method implements the code logic needed
     * to close the gear slot doors
     */
    public void closeGearSlot() {
    	// Code for closing the gear slot
    	//gearSlot.set(false);
    }
    
    /**
     * This method implements the code logic needed
     * to eject the gear once the slot doors
     * are open.
     */
    public void ejectGear() {
    	// Code to eject gear
    }
    
    /**
     * Reset the gear slot mechanism
     */
    public void resetGearSlot() {
    	
    }
}

