package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Contains flywheel and indexer 
 * @author Meriel
 *
 */
public class Shooter extends Subsystem {

	public FlyWheel flywheel;
	public Indexer indexer;
	public PIDController pid;
	
	public Shooter(){
		flywheel = new FlyWheel();
		indexer = new Indexer();
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	//public void shoot(int shooterDpadPos){
	public void shoot(){
		flywheel.flywheelMotor.set(1);
		if(Robot.shooter.flywheel.motorSpeedEqualsSetSpeed()){
			indexer.releaseBall();
		} else {
			indexer.stop();
		}
	}

	/**
	 * shooter dpad used to speed up and slow down flywheel
	 * @author Meriel
	 *
	 */
	public class FlyWheel extends Subsystem {
		public SpeedController flywheelMotor = new Talon(RobotMap.shooterMotorPort);
		//private boolean isSpinning = false;
		public double flywheelSpeed = .8;
		private int simulatedEncoderCount = 0;
		private double tolerance = 0.1;
		//private Encoder encoder = new Encoder(0, 0);
		
		/* Calculate the distance each pulse in the encoder equals to.
		 * Equation: (Wheel Diameter x Pi) / Number of pulses per encoder revolution */
		private final double gearDiameter = 1.0;
		private final int pulsePerRevolution = 40;
		private final double distancePerPulse = (Math.PI * gearDiameter) / pulsePerRevolution;
		
		public FlyWheel() {
			super();
		}

		@Override
		protected void initDefaultCommand() {
		}

		public void spin() {
			// TODO Auto-generated method stub
			// double throttle = shooterJoystick.getRawAxis(8);
			// System.out.println(throttle);
			// double limitedThrottle = limit(throttle);
			// limitedThrottle = limitedThrottle * limitedThrottle;
			// if (isSpinning){
			// shooter.set(0);
			// isSpinning = false;
			// } else {
			// if (!isSpinning)
			flywheelMotor.set(flywheelSpeed);
			simulatedEncoderCount++;
			System.out.println(simulatedEncoderCount);
			if (simulatedEncoderCount >= 31000) {
				simulatedEncoderCount = 100;
			}
			if (simulatedEncoderCount >= 100) {
				//indexer.set(.5);
			}
		}

		public void stop() {
			flywheelMotor.stopMotor();
			//indexer.set(0);
			simulatedEncoderCount = 0;
		}

		protected double limit(double num) {
			if (num > 1.0) {
				return 1.0;
			}
			if (num < -1.0) {
				return -1.0;
			}
			return num;
		}
		
		/** Reset all encoders. */
		public void resetEncoder() {
			//encoder.reset();
		}
		
		/** Setup encoders before use. */
		public void setupEncoder() {
			//encoder.setDistancePerPulse(distancePerPulse);
			//leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
			//SmartDashboard.putData("Flywheel Encoder", encoder);
		}
		
		public double getFlywheelSetSpeed(){
			return flywheelMotor.get();
		}
		
		public double getFlywheelMotorSpeed(){
			//return encoder.getRate();
			return 0;
		}
		
		public void adjustFlywheelSpeed(){
			int adjustment = Robot.oi.shooterDpad;
			if(adjustment == 0){
				flywheelSpeed += .1;
			} else if (adjustment == 4){
				flywheelSpeed -= .1;
			}
		}
		
		public boolean motorSpeedEqualsSetSpeed(){
			if (Math.abs(getFlywheelMotorSpeed() - flywheelMotor.get()) < tolerance){
				return true;
			}
			return false;
		}
	}


	/**
	 * Indexer waits for flywheel to get up to speed before releasing a ball to be shot, then continuously releases balls
	 */
	public class Indexer extends Subsystem {

		public SpeedController indexer = new Talon(5); // afraid to change
		// anything cause it
		// works right now, but
		// will probably change
		// this to port 7 to
		// accommodate the
		// RobotMap everyone
		// else is using
		public double indexerSpeed = 0.5;
		
		@Override
		protected void initDefaultCommand() {
		}
		
		//Method called only when flywheel motor is up to speed (no corresponding joystick button for indexer)
		public void releaseBall(){
			indexer.set(indexerSpeed);
			//indexer.
		}
		
		public void stop(){
			indexer.stopMotor();
		}
	}
}
