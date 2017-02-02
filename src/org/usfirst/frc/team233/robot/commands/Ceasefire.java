package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Ceasefire extends Command {

	public Ceasefire() {
		// TODO Auto-generated constructor stub
		requires(Robot.shooter);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooter.stop();
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
