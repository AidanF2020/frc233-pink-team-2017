package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ farthest position from boiler
 * @author Meriel
 */

public class AutoGearRoutine1 extends CommandGroup {
	
	//make isBlueAlliance constructor param after finished testing
	//public boolean isBlueAlliance = true;
	public boolean shortcut = false;
	
	public AutoGearRoutine1(boolean isBlueAlliance){
		if(!isBlueAlliance){
			/* RED ALLIANCE AUTONOMOUS CODE */
			
			addSequential(new PinkNavigate(-70, 0, 1));
			//turn 60 degrees to back up to tip of peg
			addSequential(new PinkNavigate(-70, 60, 0.7));
			addSequential(new PinkNavigate(-132, 60, 0.7));
			addSequential(new PinkNavigate(-140, 60, 0.5));
			addSequential(new WaitCommand(1));
			//go to the hopper
			addSequential(new PinkNavigate(-80, 60, 1));
//				addSequential(new PinkNavigate(-80, -157/*150*/, 1/*0.7*/));
//				addSequential(new PinkNavigate(10/*-5*/, -157/*150*/, 0.7));
			addSequential(new PinkNavigate(-80, 180, 0.7));
			addSequential(new PinkNavigate(55, 180, 1));
			addSequential(new PinkNavigate(55, 90, 1));
			addSequential(new PinkNavigate(110, 90, 1));	
		} else {
			/* BLUE ALLIANCE AUTONOMOUS CODE */
			addSequential(new PinkNavigate(-70, 0, 1));
			//turn 60 degrees to back up to tip of peg
			addSequential(new PinkNavigate(-70, -60, 0.7));
			addSequential(new PinkNavigate(-132, -60, 0.7));
			addSequential(new PinkNavigate(-140, -60, 0.5));
			addSequential(new WaitCommand(1));
			//go to the hopper
			addSequential(new PinkNavigate(-80, -60, 1));
//			addSequential(new PinkNavigate(-80, -157/*150*/, 1/*0.7*/));
//			addSequential(new PinkNavigate(10/*-5*/, -157/*150*/, 0.7));
			addSequential(new PinkNavigate(-80, -180, 0.7));
			addSequential(new PinkNavigate(55, -180, 1));
			addSequential(new PinkNavigate(55, -90, 1));
			addSequential(new PinkNavigate(110, -90, 1));
		}
	}
}
