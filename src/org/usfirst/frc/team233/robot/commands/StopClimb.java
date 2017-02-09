package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopClimb extends Command {

	public StopClimb() {
		// TODO Auto-generated constructor stub
		requires(Robot.ropeClimber);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		super.execute();
		Robot.ropeClimber.stopClimbingRope();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
