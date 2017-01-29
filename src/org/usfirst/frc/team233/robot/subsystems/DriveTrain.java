package org.usfirst.frc.team233.robot.subsystems;

//import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;
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
	
	boolean isInverted = false;
	
	/* Calculate the distance each pulse in the encoder equals to.
	 * Equation: (Wheel Diameter x Pi) / Number of pulses per encoder revolution */
	private final double wheelDiameter = 1.0;
	private final int pulsePerRevolution = 40;
	private final double distancePerPulse = (Math.PI * wheelDiameter) / pulsePerRevolution;
	
	
	
	// Define all the encoders that are going to be used for the drive train.
	private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderAPort, RobotMap.leftEncoderBPort);
	private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderAPort, RobotMap.rightEncoderBPort);
	
	
	/** Drive train constructor.*/
	public DriveTrain() {
		super();
		drive.setSafetyEnabled(true);
		setupMotors();
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
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	
	public void setupMotors() {
		frontLeftMotor.setInverted(isInverted);
		rearLeftMotor.setInverted(isInverted);
		
		frontRightMotor.setInverted(isInverted);
		rearRightMotor.setInverted(isInverted);
	}
	
	/** Setup encoders before use. */
	public void setupEncoders() {
		leftEncoder.setDistancePerPulse(distancePerPulse);
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Left Encoder", leftEncoder);
		
		rightEncoder.setDistancePerPulse(distancePerPulse);
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Right Encoder", rightEncoder);
	}
	
	/** Obtain the distance from the encoder on the 
	 * left of the drive train. */
	public double getLeftDistance() {
		double dist = leftEncoder.getDistance();
		SmartDashboard.putNumber("Left Distance", dist);
		return dist;
	}
	
	/** Obtain the distance from the encoder on the 
	 * right of the drive train. */
	public double getRightDistance() {
		double dist = rightEncoder.getDistance();
		SmartDashboard.putNumber("Right Distance", dist);
		return dist;
	}
	
	/** This method should be called on any disable to reset and
	 * release any resource that is not going to be used anymore.*/
	public void disableDriveTrain() {
		resetEncoders();
	}
}
