package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest1 extends CommandGroup {

	public AutoTest1() {
		// TODO Auto-generated constructor stub
		addSequential(new PinkNavigate(-92, 0, 0, 1)); //Drive to gear position
		addSequential(new PinkNavigate(-92,60,0,1)); //Turn to peg
		addSequential(new PinkNavigate(-34,60,0,1)); //Drive back on peg
		//wait
		addSequential(new PinkNavigate(0,60,0,1)); // Drive away from Peg
		addSequential(new PinkNavigate(0,0,0,1)); // Turn to line
		addSequential(new PinkNavigate(0,0,0,1)); // Drive to line
		//shoot
		addSequential(new PinkNavigate(-20,0,0,1)); // Drive back to bucket
	}
}
