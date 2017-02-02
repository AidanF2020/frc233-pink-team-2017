package org.usfirst.frc.team233.robot;

import org.usfirst.frc.team233.robot.commands.CollectBalls;
import org.usfirst.frc.team233.robot.commands.EjectBalls;

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
 * OI == "operator interface"
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick base = new Joystick(RobotMap.baseJoystickPort);
	private Joystick shooter = new Joystick(RobotMap.shooterJoystickPort);
	
	public int shooterDpad;
	
	public OI() {
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
		
		//Shooter controller
		JoystickButton shooterX = new JoystickButton(shooter, 1);
		JoystickButton shooterA = new JoystickButton(shooter, 2);
		JoystickButton shooterB = new JoystickButton(shooter, 3);
		JoystickButton shooterY = new JoystickButton(shooter, 4);
		JoystickButton shooterLeftBumper = new JoystickButton(shooter, 5);
		JoystickButton shooterRightBumper = new JoystickButton(shooter, 6);
		JoystickButton shooterLeftTrigger = new JoystickButton(shooter, 7);
		JoystickButton shooterRightTrigger = new JoystickButton(shooter, 8);
		JoystickButton shooterSelect = new JoystickButton(shooter, 9);
		JoystickButton shooterStart = new JoystickButton(shooter, 10);
		JoystickButton shooterleftJoystickPress = new JoystickButton(shooter, 11);
		JoystickButton shooterrightJoystickPress = new JoystickButton(shooter, 12);
		int shooterDpad = shooter.getPOV();
		
		// Driver button-command pairs (responsible for driving & collecting)
		//driverRightBumper			//Gearshift
		rightTrigger.whileHeld(new CollectBalls());
		leftTrigger.whileHeld(new EjectBalls());
		
		// Shooter button-command pairs (responsible for shooting & climbing)
		shooterRightBumper.whenPressed(Robot.spinup);
		shooterRightTrigger.whileHeld(Robot.shoot);
		
	}
	
	public Joystick getBaseJoystick() {
		return base;
	}
	public Joystick getShooterJoystick() {
		return shooter;
	}
}