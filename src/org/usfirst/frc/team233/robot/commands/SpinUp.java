package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUp extends Command {
	
	public SpinUp() {
		// TODO Auto-generated constructor stub
		//requires(Robot.shooter);
		requires(Robot.flywheel);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//System.out.println("TankDrive Execute!!!");
		Robot.flywheel.startFlywheel();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

}
