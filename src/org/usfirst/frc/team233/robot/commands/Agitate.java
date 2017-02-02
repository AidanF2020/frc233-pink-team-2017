package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Agitate extends Command {
	
	public Agitate(){
		requires(Robot.hopper);
	}
	
	@Override
	protected void execute(){
		Robot.hopper.agitate();
	}

	/**
	 * called by the Scheduler
	 * returns false if it still needs to run execute()
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}
