package org.usfirst.frc.team233.robot.subsystems;

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


public class DriveTrain extends Subsystem{
	// Drive train motor definition
	private SpeedController frontLeftMotor = new Talon(RobotMap.leftFrontMotorPort);
	private SpeedController rearLeftMotor = new Talon(RobotMap.leftBackMotorPort);
	private SpeedController frontRightMotor = new Talon(RobotMap.rightFrontMotorPort);
	private SpeedController rearRightMotor = new Talon(RobotMap.rightBackMotorPort);
	
	// Link the motors to the robot
	private RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	
	/* Calculate the distance each pulse in the encoder equals to.
	 * Equation: (Wheel Diameter x Pi) / Number of pulses per encoder revolution */
	private final double wheelDiameter = 1.0;
	private final int pulsePerRevolution = 1024;
	private final double distancePerPulse = (Math.PI * wheelDiameter) / pulsePerRevolution;
	
	
	
	// Define all the encoders that are going to be used for the drive train.
	private Encoder frontLeftEncoder = new Encoder(Encoders.FrontLeft.channelA(), Encoders.FrontLeft.channelB());
	private Encoder backLeftEncoder = new Encoder(Encoders.BackLeft.channelA(), Encoders.BackLeft.channelB());
	private Encoder frontRightEncoder = new Encoder(Encoders.FrontRight.channelA(), Encoders.FrontRight.channelB());
	private Encoder backRightEncoder = new Encoder(Encoders.BackRight.channelA(), Encoders.BackRight.channelB());
	
	
	/** Drive train constructor.*/
	public DriveTrain() {
		super();
		resetEncoders();
		setupEncoders();
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TankDrive());
	}
	
	/**
	 * Tank style driving for the DriveTrain.
	 * 
	 * @param left
	 *            Speed in range [-1,1]
	 * @param right
	 *            Speed in range [-1,1]
	 */
	public void drive(double left, double right) {
		//System.out.println("Drive2");
		drive.tankDrive(left, right);
	}

	/**
	 * @param joy
	 *            The ps3 style joystick to use to drive tank style.
	 */
	public void drive(Joystick base) {
		//System.out.println("Drive1");
		drive(-base.getY(), -base.getAxis(AxisType.kThrottle));
	}

	/** Reset all encoders. */
	public void resetEncoders() {
		frontLeftEncoder.reset();
		backLeftEncoder.reset();
		
		frontRightEncoder.reset();
		backRightEncoder.reset();
	}
	
	/** Setup encoders before use. */
	public void setupEncoders() {
		frontLeftEncoder.setDistancePerPulse(distancePerPulse);
		frontLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Front Left Encoder", frontLeftEncoder);
		
		backLeftEncoder.setDistancePerPulse(distancePerPulse);
		backLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Back Left Encoder", backLeftEncoder);
		
		frontRightEncoder.setDistancePerPulse(distancePerPulse);
		frontRightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Front Right Encoder", frontRightEncoder);
		
		backRightEncoder.setDistancePerPulse(distancePerPulse);
		backRightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Back Right Encoder", backRightEncoder);
	}
	
	/** Obtain the average distance from the encoders on the 
	 * left of the drive train. */
	public double getLeftAvgDistance() {
		double dist = (frontLeftEncoder.getDistance() + backLeftEncoder.getDistance()) / 2;
		SmartDashboard.putNumber("Left Avg Distange", dist);
		return dist;
	}
	
	/** Obtain the average distance from the encoders on the 
	 * right of the drive train. */
	public double getRightAvgDistance() {
		double dist = (frontRightEncoder.getDistance() + backRightEncoder.getDistance()) / 2;
		SmartDashboard.putNumber("Right Avg Distange", dist);
		return dist;
	}
	
	/** This method should be called on any disable to reset and
	 * release any resource that is not going to be used anymore.*/
	public void disableDriveTrain() {
		resetEncoders();
	}
}
