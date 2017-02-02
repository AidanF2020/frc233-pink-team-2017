package org.usfirst.frc.team233.robot;

import edu.wpi.first.wpilibj.ControllerPower;

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
	
	public static int leftFrontMotorPort = 0;
	public static int leftBackMotorPort = 1;
	public static int rightFrontMotorPort = 2;
	public static int rightBackMotorPort = 3;
	
	public static int shooterMotorPort = 4;
	public static int collectorMotorPort = 5;
	public static int ropeClimberMotorPort = 6;
	
	//Joystick ports
	public static int baseJoystickPort = 0;
	public static int shooterJoystickPort = 1;
	
	//Drivetrain encoder ports
	public static int leftEncoderAPort = 0;
	public static int leftEncoderBPort = 1;
	public static int rightEncoderAPort = 3;
	public static int rightEncoderBPort = 4;

	//Hopper motor ports
	public static int hopperAgitatorPort;
	public static int hopperBlowerPort;
	
	public ControllerPower cp = new ControllerPower();
	//can read amps in thru power distrib board
}
	