package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.subsystems.Lights.LightingType;

import edu.wpi.first.wpilibj.command.Command;



/**
 *
 */
public class LightTest extends Command {
	private LightAction action;
	
	public enum LightAction {
		POLICE,
		OFF,
		RAINBOW,
		BREATHE,
		SHOOTER,
		MISSING_DOT,
		STAYING_ALIVE,
		HEARTBEAT;
	}
    public LightTest(LightAction action) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lights);
    	this.action = action;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	System.out.println("Action selected = " + action.toString());
    	switch (action) {
			case POLICE:
				Robot.lights.activateLights(LightingType.police);
				break;
			case RAINBOW:
				Robot.lights.activateLights(LightingType.rainbow);
				break;
			case MISSING_DOT:
				Robot.lights.activateLights(LightingType.missing_dot);
				break;
			case SHOOTER:
				Robot.lights.activateLights(LightingType.shooter);
				break;
			case BREATHE:
				Robot.lights.activateLights(LightingType.breathe);
				break;
			case HEARTBEAT:
				Robot.lights.activateLights(LightingType.heartbeat);
			case STAYING_ALIVE:
				Robot.lights.activateLights(LightingType.staying_alive);
				break;
			default:
				Robot.lights.activateLights(LightingType.off);
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
    	Robot.lights.activateLights(LightingType.off);
    }
}
