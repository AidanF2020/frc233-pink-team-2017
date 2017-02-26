package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ middle position
 */

public class AutoGearRoutine2 extends CommandGroup {

	public AutoGearRoutine2(){
		// back up to spring tip2
		addSequential(new PinkNavigate(-65, 0, 0.7));		
//		addSequential(new PinkNavigate(-62, 0, 0.7));		
		//ease onto spear
		addSequential(new PinkNavigate(-74, 0, 0.5));
//		addSequential(new PinkNavigate(-71, 0, 0.5));
		// go forward off of spear and hopper
		addSequential(new WaitCommand(2));
		addSequential(new PinkNavigate(-20, 0, 0.7)); // Don't go all the way to the end to turn
		addSequential(new PinkNavigate(-20, 135, 1));
		addSequential(new PinkNavigate(200, 135, 1));
		addSequential(new PinkNavigate(200, 180, 1));
		addSequential(new PinkNavigate(224, 180, 0.7));
		
	}
}
