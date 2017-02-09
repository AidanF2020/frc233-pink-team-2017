package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.command.Command;

public class StartClimb extends Command {

	public StartClimb() {
		// TODO Auto-generated constructor stub
		requires(Robot.ropeClimber);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		super.execute();
		Robot.ropeClimber.startClimbingRope();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
