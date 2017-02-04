package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	PIDController pidController;
	
	public DriveStraight() {
		// TODO Auto-generated constructor stub
		requires(Robot.drivetrain);
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//System.out.println("TankDrive Execute!!!");
		//Robot.drivetrain.drive(Robot.oi.getBaseJoystick());
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Robot.drivetrain.drive(0, 0);
	}

}
