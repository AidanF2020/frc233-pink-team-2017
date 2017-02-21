package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ farthest position from boiler
 * @author Meriel
 *
 */
public class AutoGearRoutine2 extends CommandGroup {

	public AutoGearRoutine2(){
		// back up to spring tip
		//addSequential(new PinkNavigate(-70, 0, 0.7));
		
		
		
		addSequential(new PinkNavigate(24,0, 1));
		addSequential(new PinkNavigate(24,60, 1));
		addSequential(new PinkNavigate(24,-60, 1));
		
		
		//addSequential(new DriveStraight(-70));
		
		//ease onto spear
		//addSequential(new PinkNavigate(-4, 0, 0.3));
		// go forward off of spear
		//addSequential(new WaitCommand(2));
		//addSequential(new PinkNavigate(4, 0, 0.6));
		
	}
}
