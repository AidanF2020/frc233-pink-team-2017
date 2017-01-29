package org.usfirst.frc.team233.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Drive train variables
	public static int leftFrontMotorPort = 0;
	public static int leftBackMotorPort = 1;
	public static int rightFrontMotorPort = 2;
	public static int rightBackMotorPort = 3;
	
	// Shooter variables
	public static int shooterMotorPort = 4;
	
	// Collector variables
	public static int collectorMotorPort = 5;
	
	// Rope climber variables
	public static int ropeClimberMotorPort = 6;
	
	//Hopper variables
	public static int hopperAgitatorPort;
	public static int hopperBlowerPort;
	
	
	// Joystick variable
	public static int baseJoystickPort = 0;
	public static int shooterJoystickPort = 1;
	
	// Encoders
	public static int leftEncoderAPort = 0;
	public static int leftEncoderBPort = 1;
	public static int rightEncoderAPort = 3;
	public static int rightEncoderBPort = 4;
	
	
	
}