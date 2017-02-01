package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterWheel extends Subsystem {

	private SpeedController shooterMotor = new Talon(RobotMap.shooterMotorPort);
	private SpeedController indexerMotor = new Talon(RobotMap.indexerMotorPort);
	private Encoder shooterEncoder = new Encoder(0,1);
	private final double shooterDistancePerPulse = 0.123;
	
	public ShooterWheel() {
		// TODO Auto-generated constructor stub
		shooterEncoder.reset();
		shooterEncoder.setDistancePerPulse(shooterDistancePerPulse);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void spin() {
		shooterMotor.set(RobotMap.shooterMotorSpeed);
	}
	
	public void stop(){
		shooterMotor.stopMotor();
	}

}
