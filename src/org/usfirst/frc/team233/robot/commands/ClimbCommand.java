package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.subsystems.RopeClimber.ClimberAction;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbCommand extends Command {
	
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
				Robot.ropeClimber.startClimbingRope();
				break;
			
			case REVERSE:
				Robot.ropeClimber.reverseClimber();
				break;
	
			default:
				Robot.ropeClimber.stopClimbingRope();
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
