package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BeginShooting extends Command {

	public BeginShooting() {
		// TODO Auto-generated constructor stub
		requires(Robot.shooter);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(Robot.shooter.isFlywheelUpToSpeed()) {
			Robot.shooter.shoot();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
