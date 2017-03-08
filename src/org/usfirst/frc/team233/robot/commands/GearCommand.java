package org.usfirst.frc.team233.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team233.robot.Robot;;
/**
 *
 */
public class GearCommand extends Command {
	public enum GearAction {
		OPEN_SLOT,
		CLOSE_SLOT,
		EJECT_GEAR,
		RESET;
	}
	
	GearAction action;
	
    public GearCommand(GearAction action) {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.gearSlot);
    	this.action = action;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch (action) {
			case OPEN_SLOT:
				//gearSlot.openGearSlot();
				break;
			case CLOSE_SLOT:
				//gearSlot.closeGearSlot();
				break;
			case EJECT_GEAR:
				//gearSlot.ejectGear();
				break;

			default:
				//gearSlot.resetGearSlot();
				break;
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
