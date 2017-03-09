package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ middle position
 * Red Alliance SideS
 */

public class AutoGearRoutine2 extends CommandGroup {

	//make isBlueAlliance constructor param after finished testing
	//public boolean isBlueAlliance = true;

	public AutoGearRoutine2(boolean isBlueAlliance){
		if(!isBlueAlliance){
			/* RED ALLIANCE AUTONOMOUS CODE */
			addSequential(new WaitCommand(Robot.delayTime));
			// back up to spring tip2
			addSequential(new PinkNavigate(-66, 0, 0.7));		
			//ease onto spear
			addSequential(new PinkNavigate(-68, 0, 0.6));
			// go forward off of spear and hopper
			addSequential(new WaitCommand(3));
			addSequential(new PinkNavigate(-14, 0, 0.7)); // Don't go all the way to the end to turn
			addSequential(new PinkNavigate(-14, -135, 0.8));
			addSequential(new PinkNavigate(176, -135, 1));
			addSequential(new PinkNavigate(176, -180, 0.8));
			addSequential(new PinkNavigate(178, -180, 0.7));
			addSequential(new PinkNavigate(178, -90, 0.7, true));
			
			
		} else {
			/* BLUE ALLIANCE AUTONOMOUS CODE */
			addSequential(new WaitCommand(Robot.delayTime));
			// back up to spring tip2
			addSequential(new PinkNavigate(-66, 0, 0.7));		
			//ease onto spear
			addSequential(new PinkNavigate(-68, 0, 0.6));
			// go forward off of spear and hopper
			addSequential(new WaitCommand(3));
			addSequential(new PinkNavigate(-14, 0, 0.7)); // Don't go all the way to the end to turn
			addSequential(new PinkNavigate(-14, 135, 0.8));
			addSequential(new PinkNavigate(176, 135, 1));
			addSequential(new PinkNavigate(176, 180, 0.8));
			addSequential(new PinkNavigate(178, 180, 0.7));
			addSequential(new PinkNavigate(178, 90, 1, true));
			
		}
	}
}
