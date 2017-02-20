package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoTest1 extends CommandGroup {

	public AutoTest1(double delay) {
		// testing ability to set a delay from SmartDashboard
//		addSequential(new WaitCommand(delay));
//		addSequential(new DriveStraight(-12));
//		addSequential (new RotateBase(90));
		addSequential(new PinkNavigate(-60,0,1));
		addSequential(new PinkNavigate(-60,90,1));
		addSequential(new PinkNavigate(-120,90,1));
		addSequential(new PinkNavigate(-120,180,1));
		addSequential(new PinkNavigate(-180,180,1));
		addSequential(new PinkNavigate(-180,270,1));
		addSequential(new PinkNavigate(-240,270,1));
		addSequential(new PinkNavigate(-240,360,1));
		addSequential(new PinkNavigate(-300,360,1));
		addSequential (new StopBase());
//		addSequential(new PinkNavigate(-12, 0, 1)); //Drive to gear position
		//addSequential(new DriveStraight(12));
		//addSequential(new WaitCommand(2.0));
		//addSequential(new WaitCommand(0.75));
		//addSequential(new DriveStraight(12));
		//addSequential(new WaitCommand(0.75));
		//addSequential(new DriveStraight(-12));
		//addSequential(new AutoTest2(0.1, 0.1, 12, false));
		//addSequential(new PrintCommand("Next Command"));
		//addSequential(new WaitCommand(10));
//		addSequential(new PinkNavigate(-92, 0, 1)); //Drive to gear position
//		addSequential(new PinkNavigate(-92,60,1)); //Turn to peg
//		addSequential(new PinkNavigate(-34,60,1)); //Drive back on peg
//		//wait
//		addSequential(new PinkNavigate(0,60,1)); // Drive away from Peg
//		addSequential(new PinkNavigate(0,0,1)); // Turn to line
//		addSequential(new PinkNavigate(0,0,1)); // Drive to line
//		//shoot
//		addSequential(new PinkNavigate(-20,0,1)); // Drive back to bucket
	}
	
	
}
