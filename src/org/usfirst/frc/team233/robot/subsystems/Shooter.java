package org.usfirst.frc.team233.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private SpeedController shooter = new Talon(RobotMap.shooterMotorPort);
	//private boolean isSpinning;
	private double motorSpeed = 1.0;
	public Shooter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
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
			shooter.set(motorSpeed);
//			isSpinning = true;
//			
//		}
			
	
		
	}
	
	public void stop(){
		shooter.set(0);
	}

}
