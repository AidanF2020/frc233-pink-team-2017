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


	@Override
	protected boolean isFinished() {
		return false;
	}

}
