package org.usfirst.frc.team233.robot;

import org.usfirst.frc.team233.robot.commands.ClimbCommand;
import org.usfirst.frc.team233.robot.commands.CollectorCommand;
import org.usfirst.frc.team233.robot.commands.ShiftGear;
import org.usfirst.frc.team233.robot.commands.Shoot;
import org.usfirst.frc.team233.robot.commands.CollectorCommand.CollectorAction;
import org.usfirst.frc.team233.robot.commands.ClimbCommand.ClimberAction;
import org.usfirst.frc.team233.robot.subsystems.ShootingState;

import edu.wpi.first.wpilibj.Joystick;
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
		
		//==========================================
		//		Link to Joystick Buttons
		//==========================================
		
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
		//int baseDpad = base.getPOV();
		
		//Shooter
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
		//int shooterDpad = shooter.getPOV();
		
		
		
		//==========================================
		//		Map Joysticks to Commands
		//==========================================
		// WARNING: Haven't tested this code yet!!!
		shooterRightTrigger.whileHeld(new Shoot(ShootingState.START_FLYWHEEL));
		shooterRightTrigger.whenReleased(new Shoot(ShootingState.STOP_FLYWHEEL));
		
		shooterRightBumper.whileHeld(new Shoot(ShootingState.SHOOT));
		shooterRightBumper.whenReleased(new Shoot(ShootingState.CEASEFIRE));
		
		rightTrigger.whileHeld(new CollectorCommand(CollectorAction.COLLECT));
		rightTrigger.whenReleased(new CollectorCommand(CollectorAction.STOP));
		
		leftTrigger.whileHeld(new CollectorCommand(CollectorAction.EJECT));
		leftTrigger.whenReleased(new CollectorCommand(CollectorAction.STOP));
		
		rightBumper.whenPressed(new ShiftGear());
		
		a.whileHeld(new ClimbCommand(ClimberAction.CLIMB));
		a.whenReleased(new ClimbCommand(ClimberAction.STOP));
		
		
	}
	
	public Joystick getBaseJoystick() {
		return base;
	}
	public Joystick getShooterJoystick() {
		return shooter;
	}
}
