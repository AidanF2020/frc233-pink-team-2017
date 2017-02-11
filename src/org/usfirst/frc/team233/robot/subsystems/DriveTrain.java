package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.Robot;
//import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;
import org.usfirst.frc.team233.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
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
	
	private Compressor compressor = new Compressor(RobotMap.compressorPort);
	private AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	private Solenoid shifterSolenoid = new Solenoid(RobotMap.shiftingSolenoidPort);
	
	// Link the motors to the robot
	private RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	
	boolean isInverted = false;
	
	/* Calculate the distance each pulse in the encoder equals to for simulation.
	 * Equation: (Wheel Diameter x Pi) / Number of pulses per encoder revolution */
	private final double wheelDiameter = 1.0;
	private final int pulsePerRevolution = 40;
	private final double distancePerPulse = (Math.PI * wheelDiameter) / pulsePerRevolution;
	
	// Fixed value for distancePerPulse used in real robot
	private final double distancePerPulseConstant = 0.314;
	
	// Define all the encoders that are going to be used for the drive train.
//	private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderAPort, RobotMap.leftEncoderBPort);
//	private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderAPort, RobotMap.rightEncoderBPort);
//	
	private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderAPort, RobotMap.leftEncoderBPort, true, EncodingType.k4X);
	private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderAPort, RobotMap.rightEncoderBPort, true, EncodingType.k4X);
	
	
	/** Drive train constructor.*/
	public DriveTrain() {
		super();
		//System.out.println("Drivetrain Constructor");
		drive.setSafetyEnabled(true);
		setupMotors();
		setupEncoders();
		resetEncoders();
		setupComponents();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TankDrive());
	}
	
	public void setupMotors() {
		frontLeftMotor.setInverted(isInverted);
		rearLeftMotor.setInverted(isInverted);
		
		frontRightMotor.setInverted(isInverted);
		rearRightMotor.setInverted(isInverted);
	}
	
	public void setupComponents() {
		compressor.setClosedLoopControl(true);
		gyro.calibrate();
	}
	
	/** Setup encoders before use. */
	public void setupEncoders() {
		//Setup left encoder
		if (Robot.isReal()) {
			leftEncoder.setDistancePerPulse(distancePerPulseConstant);
		} else {
			leftEncoder.setDistancePerPulse(distancePerPulse);
		}
		// These values setup here are random!!!
		// Need to determine the best values for this!
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		//leftEncoder.setSamplesToAverage(6);
		//leftEncoder.setMinRate(10);
		
		// Setup right encoder
		if (Robot.isReal()) {
			rightEncoder.setDistancePerPulse(distancePerPulseConstant);
		} else {
			rightEncoder.setDistancePerPulse(distancePerPulse);
		}
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		//rightEncoder.setMinRate(10);
		//rightEncoder.setSamplesToAverage(6);
	}
	
	/** Reset all encoders. */
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
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
		//drive(-base.getY(), -base.getAxis(AxisType.kThrottle));
		drive(-base.getAxis(AxisType.kThrottle), -base.getY());
	}
	
	/** Obtain the distance from the encoder on the 
	 * left of the drive train. */
	public double getLeftDistance() {
		double dist = leftEncoder.getDistance();
		//SmartDashboard.putNumber("Left Distance", dist);
		return dist;
	}
	
	/** Obtain the distance from the encoder on the 
	 * right of the drive train. */
	public double getRightDistance() {
		double dist = rightEncoder.getDistance();
		//SmartDashboard.putNumber("Right Distance", dist);
		return dist;
	}
	
	/** Average the distance of both encoders and return its 
	 * value. Also put this value in the SmartDashboard. */
	public double getDistanceTraveled() {
		double avgEncoders = (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
		//SmartDashboard.putNumber("Encoder Avg", avgEncoders);
		return avgEncoders;
	}
	
	public void shiftGears() {
		if (shifterSolenoid.get()) {
			shifterSolenoid.set(false);
		}
		else {
			shifterSolenoid.set(true);
		}
	}
	
	public double getGyroRotation() {
		return gyro.getAngle();
	}
	
	/** Use this method to reset encoders and any other resource
	 * for autonomous use. */
	public void reset() {
		resetEncoders();
	}
	
	/** This method should be called on any disable to reset and
	 * release any resource that is not going to be used anymore.*/
	public void disableDriveTrain() {
		resetEncoders();
		frontLeftMotor.disable();
		frontRightMotor.disable();
		rearLeftMotor.disable();
		rearRightMotor.disable();
	}
}
