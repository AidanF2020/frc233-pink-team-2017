package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		Robot.flywheel.adjustFlywheelSpeed(Robot.oi.getShooterJoystick().getPOV());
		//System.out.println("Flywheel speed = " + Robot.flywheel.getFlywheelMotorSpeed());
		SmartDashboard.putNumber("Flywheel Speed", Robot.flywheel.getFlywheelMotorSpeed());
		Robot.flywheel.startFlywheel();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

}
