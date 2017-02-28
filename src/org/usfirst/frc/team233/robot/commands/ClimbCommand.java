package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	
	public enum ClimberAction {
 		CLIMB,
 		REVERSE,
 		STOP
 	}
	
	ClimberAction action;
	
	public ClimbCommand(ClimberAction action) {
		// TODO Auto-generated constructor stub
		requires(Robot.ropeClimber);
		this.action = action;
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		super.execute();
		switch (action) {
			case CLIMB:
				Robot.lights.activateLights(LightingType.off);
				Robot.ropeClimber.startClimbingRope();
				break;
			
			case REVERSE:
				Robot.lights.activateLights(LightingType.off);
				Robot.ropeClimber.reverseClimber();
				break;
	
			default:
				Robot.ropeClimber.stopClimbingRope();
				Robot.lights.activateLights(LightingType.rainbow);
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
