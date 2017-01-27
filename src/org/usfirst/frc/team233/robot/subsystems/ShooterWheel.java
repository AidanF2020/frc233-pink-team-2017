package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.Robot;
//import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;
import org.usfirst.frc.team233.robot.RobotMap.Encoders;
import org.usfirst.frc.team233.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class ShooterWheel extends Subsystem {

	private SpeedController shooter = new Talon(RobotMap.shooterMotorPort);
	private SpeedController indexer = new Talon(5);
	private static int simulatedEncoderCount = 0;
	private boolean isSpinning = false;
	private double motorSpeed = .8;
	public ShooterWheel() {
		super();
		//isSpinning = false;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		// setDefaultCommand(new TankDrive());
	}

	public void spin() {
		// TODO Auto-generated method stub
		//double throttle = shooterJoystick.getRawAxis(8);
		//System.out.println(throttle);
		//double limitedThrottle = limit(throttle);
		//limitedThrottle = limitedThrottle * limitedThrottle;
//		if (isSpinning){
//			
//			shooter.set(0);
//			isSpinning = false;
//		
//		} else {
			
		//if (!isSpinning)
			shooter.set(motorSpeed);	
			simulatedEncoderCount++;
			System.out.println(simulatedEncoderCount);
			if (simulatedEncoderCount >= 31000){
				simulatedEncoderCount = 100;
			}
			if (simulatedEncoderCount >= 100){
				indexer.set(.5);
			
			}
			
	
		
	}
	
	public void stop(){
		shooter.set(0);
		indexer.set(0);
		
		simulatedEncoderCount = 0;
	}
	protected static double limit(double num) {
		if (num > 1.0) {
			return 1.0;
		}
		if (num < -1.0) {
			return -1.0;
		}
		return num;
	}

}
