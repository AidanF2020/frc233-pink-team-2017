package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterWheel extends Subsystem {

	private SpeedController shooter = new Talon(RobotMap.shooterMotorPort);
	//private boolean isSpinning;
	private double motorSpeed = 1.0;
	
	
	public ShooterWheel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void spin() {
		shooter.set(motorSpeed);
	}
	
	public void stop(){
		shooter.set(0);
	}

}
