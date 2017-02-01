package org.usfirst.frc.team233.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//============================================
	// 		DRIVE TRAIN VARIABLES
	//============================================
	// Motors
	public static int leftFrontMotorPort = 0;
	public static int leftBackMotorPort = 1;
	public static int rightFrontMotorPort = 2;
	public static int rightBackMotorPort = 3;
	
	// Encoders
	public static int leftEncoderAPort = 0;
	public static int leftEncoderBPort = 1;
	public static int rightEncoderAPort = 3;
	public static int rightEncoderBPort = 4;
	
	
	//============================================
	// 		COLLECTOR VARIABLES
	//============================================
	public static int collectorMotorPort = 6;
	public static double collectorMotorSpeed = 0.5;
	

	//============================================
	// 		ROPE CLIMBER VARIABLES
	//============================================
	// Motors
	public static int ropeClimberMotorPort = 7;
	public static double ropeClimberSpeed = 0.75;
	public static double ropeHoldSpeed = 0.25;
	
	
	//============================================
	// 		SHOOTER VARIABLES
	//============================================
	// Motors
	public static int shooterMotorPort = 4;
	public static int indexerMotorPort = 5;
	public static double shooterMotorSpeed = 1.0;
	
	// Encoder
	public static int shooterEncoderPortA = 5;
	public static int shooterEncoderPortB = 6;
	
	
	//============================================
	// 		HOPPER VARIABLES
	//============================================
	// Motors
	public static int hopperAgitatorPort = 8;
	public static int hopperBlowerPort = 9;
	public static double hopperBlowerSpeed = 1;
	public static double hopperAgitatorSpeed = 1;
	
	
	//============================================
	// 		JOYSTICK VARIABLES
	//============================================
	public static int baseJoystickPort = 0;
	public static int shooterJoystickPort = 1;
	
	
	
	
	
}