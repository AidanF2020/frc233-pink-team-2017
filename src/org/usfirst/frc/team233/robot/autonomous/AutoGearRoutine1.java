package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ farthest position from boiler
 * @author Meriel
 */

public class AutoGearRoutine1 extends CommandGroup {
	
	public boolean shortcut = false;
	
	public AutoGearRoutine1(){
		if(!shortcut){
			//back up until you're on peg's angle
			addSequential(new PinkNavigate(-95, 0, 1));
			//turn 60 degrees to back up to tip of peg
			addSequential(new PinkNavigate(-95, 60, 0.7));
			addSequential(new PinkNavigate(-112, 60, 0.5));
			addSequential(new WaitCommand(2.0));
			//go to the hopper
			addSequential(new PinkNavigate(-80, 60, 1));
			addSequential(new PinkNavigate(-80, 150, 0.7));
			addSequential(new PinkNavigate(-5, 150, 0.7));
//			addSequential(new PinkNavigate(-117.5, 135, 0.7));
//			addSequential(new PinkNavigate(-67.5, 0, 0.7));
			//addSequential (new StopBase());
		} else {
			
		}
	}
}
