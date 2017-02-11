package org.usfirst.frc.team233.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team233.robot.subsystems.BallCollector;
import org.usfirst.frc.team233.robot.subsystems.DriveTrain;
import org.usfirst.frc.team233.robot.subsystems.Flywheel;
import org.usfirst.frc.team233.robot.subsystems.Hopper;
import org.usfirst.frc.team233.robot.subsystems.Indexer;
import org.usfirst.frc.team233.robot.subsystems.RopeClimber;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	
	// Define subsystem variables
	public static DriveTrain drivetrain;
	public static Flywheel flywheel;
	public static Indexer indexer;
	public static BallCollector ballCollector;
	public static RopeClimber ropeClimber;
	public static Hopper hopper;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new DriveTrain();
		flywheel = new Flywheel();
		indexer = new Indexer();
		ballCollector = new BallCollector();
		ropeClimber = new RopeClimber();
		oi = new OI();

		System.out.println("RoboInit");
		SmartDashboard.putData("Auto mode", chooser);
	}
	
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// Reset any resources that are not needed
		Robot.drivetrain.disableDriveTrain();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {
		//ASUME 4inch wheels
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		System.out.println("Teleop Init");
		drivetrain.resetEncoders();
		//Scheduler.getInstance().enable();
		//Scheduler.getInstance().removeAll();
		//Scheduler.getInstance().add(tankDrive);
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
		// TODO Test this change in code to verify if the motors still run
		//System.out.println("Teleop Periodic");
	}
	
	
	public void log() {
		SmartDashboard.putNumber("Left Encoder = ", drivetrain.getLeftDistance());
		SmartDashboard.putNumber("Right Encoder = ", drivetrain.getRightDistance());
		//SmartDashboard.putNumber("Flywheel Motor Speed", flywheel.getFlywheelMotorSpeed());
		//SmartDashboard.putNumber("Count Encoder Left", drivetrain.getLeftEncoderCount());
		//SmartDashboard.putNumber("Count Encoder Right", drivetrain.getRightEncoderCount());
		//SmartDashboard.putData("Gyro", drivetrain.getDriveTrainGyro());
	}
	
	@Override
	public void robotPeriodic() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
