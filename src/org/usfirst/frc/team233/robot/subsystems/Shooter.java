package org.usfirst.frc.team233.robot.subsystems;


import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {

	private Flywheel flywheel;
	private Indexer indexer;
	
	public Shooter() {
		// TODO Auto-generated constructor stub
		flywheel = new Flywheel();
		indexer = new Indexer();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void spin() {
		flywheel.startFlywheel();
	}
	
	public void stop(){
		flywheel.stopFlywheel();	
	}
	
	public void shoot() {
		indexer.releaseBalls();
	}

	public void stopIndexer() {
		indexer.stopIndexer();
	}
	
	public boolean isFlywheelUpToSpeed() {
		return flywheel.motorSpeedEqualsSetSpeed();
	}
	
	
	/**
	 * shooter dpad used to speed up and slow down flywheel
	 * @author Meriel
	 *
	 */
	public class Flywheel {
		public SpeedController flywheelMotor = new Talon(RobotMap.flywheelMotorPort);
		//private boolean isSpinning = false;
		public double flywheelSpeed = 0.8;
		private double tolerance = 0.1;
		private Encoder encoder = new Encoder(RobotMap.flywheelEncoderPortA,RobotMap.flywheelEncoderPortB);
		private final double flywheelDistancePerPulse = 0.123;
		
		/* Calculate the distance each pulse in the encoder equals to.
		 * Equation: (Wheel Diameter x Pi) / Number of pulses per encoder revolution */
		private final double gearDiameter = 3.0;
		private final int pulsePerRevolution = 40;
		private final double distancePerPulse = (Math.PI * gearDiameter) / pulsePerRevolution;
		
		public Flywheel() {
			super();
			encoder.reset();
			encoder.setDistancePerPulse(flywheelDistancePerPulse);
		}

		public void startFlywheel() {
			flywheelMotor.set(flywheelSpeed);
		}

		public void stopFlywheel() {
			flywheelMotor.stopMotor();
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
			encoder.reset();
		}
		
		/** Setup encoders before use. */
		public void setupEncoder() {
			encoder.setDistancePerPulse(distancePerPulse);
			//leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
			SmartDashboard.putData("Flywheel Encoder", encoder);
		}
		
		public double getFlywheelSetSpeed(){
			return flywheelMotor.get();
		}
		
		public double getFlywheelMotorSpeed(){
			return encoder.getRate();
		}
		
		public void adjustFlywheelSpeed(int adjustment){
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
	 * Indexer waits for flywheel to get up to speed before releasing 
	 * a ball to be shot, then continuously releases balls
	 */
	public class Indexer {
		public SpeedController indexer = new Talon(RobotMap.indexerMotorPort); 
		
		// Method called only when flywheel motor is up to speed 
		// (no corresponding joystick button for indexer)
		public void releaseBalls(){
			indexer.set(RobotMap.indexerMotorSpeed);
		}
		
		public void stopIndexer(){
			indexer.stopMotor();
		}
	}
}
