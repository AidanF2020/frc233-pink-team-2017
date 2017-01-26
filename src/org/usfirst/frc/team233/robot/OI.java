package org.usfirst.frc.team233.robot;

import org.usfirst.frc.team233.robot.commands.SpinUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team233.robot.commands.Autonomous;
//import org.usfirst.frc.team233.robot.commands.OpenClaw;
//import org.usfirst.frc.team233.robot.commands.Pickup;
//import org.usfirst.frc.team233.robot.commands.Place;
//import org.usfirst.frc.team233.robot.commands.PrepareToPickup;
//import org.usfirst.frc.team233.robot.commands.SetElevatorSetpoint;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick base = new Joystick(RobotMap.baseJoystickPort);
	private Joystick shooter = new Joystick(RobotMap.shooterJoystickPort);
	
	public OI() {
		// TODO Auto-generated constructor stub
		// Create some buttons
		//Base Driver
		JoystickButton x = new JoystickButton(base, 1);
		JoystickButton a = new JoystickButton(base, 2);
		JoystickButton b = new JoystickButton(base, 3);
		JoystickButton y = new JoystickButton(base, 4);
		JoystickButton leftBumper = new JoystickButton(base, 5);
		JoystickButton rightBumper = new JoystickButton(base, 6);
		JoystickButton leftTrigger = new JoystickButton(base, 7);
		JoystickButton rightTrigger = new JoystickButton(base, 8);
		JoystickButton select = new JoystickButton(base, 9);
		JoystickButton start = new JoystickButton(base, 10);
		JoystickButton leftJoystickPress = new JoystickButton(base, 11);
		JoystickButton rightJoystickPress = new JoystickButton(base, 12);
		int baseDpad = base.getPOV();
		
		//Shooter
		JoystickButton shooterX = new JoystickButton(base, 1);
		JoystickButton shooterA = new JoystickButton(base, 2);
		JoystickButton shooterB = new JoystickButton(base, 3);
		JoystickButton shooterY = new JoystickButton(base, 4);
		JoystickButton shooterLeftBumper = new JoystickButton(base, 5);
		JoystickButton shooterRightBumper = new JoystickButton(base, 6);
		JoystickButton shooterLeftTrigger = new JoystickButton(base, 7);
		JoystickButton shooterRightTrigger = new JoystickButton(base, 8);
		JoystickButton shooterSelect = new JoystickButton(base, 9);
		JoystickButton shooterStart = new JoystickButton(base, 10);
		JoystickButton shooterleftJoystickPress = new JoystickButton(base, 11);
		JoystickButton shooterrightJoystickPress = new JoystickButton(base, 12);
		int shooterDpad = shooter.getPOV();
		
		
		// Connect the buttons to commands
		//d_up.whenPressed(new SetElevatorSetpoint(0.2));
		//d_down.whenPressed(new SetElevatorSetpoint(-0.2));
		//d_right.whenPressed(new CloseClaw());
		//d_left.whenPressed(new OpenClaw());

		//r1.whenPressed(new PrepareToPickup());
		//r2.whenPressed(new Pickup());
		//l1.whenPressed(new Place());
		//l2.whenPressed(new Autonomous());
		rightBumper.whileHeld(new SpinUp());
	}
	
	public Joystick getBaseJoystick() {
		return base;
	}
	public Joystick getShooterJoystick() {
		return shooter;
	}
}
