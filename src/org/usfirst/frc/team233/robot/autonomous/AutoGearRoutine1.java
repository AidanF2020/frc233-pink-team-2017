package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.Robot;

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
			
			addSequential(new WaitCommand(Robot.delayTime));
			addSequential(new PinkNavigate(-70, 0, 1));
			//turn 60 degrees to back up to tip of peg
			addSequential(new PinkNavigate(-70, 60, 0.7));
			addSequential(new PinkNavigate(-132, 60, 0.7));
			addSequential(new PinkNavigate(-140, 60, 0.5));
			addSequential(new WaitCommand(2));
			//go to the hopper
			addSequential(new PinkNavigate(-80, 60, 1));
			addSequential(new PinkNavigate(-80, 180, 0.7));
			addSequential(new PinkNavigate(55, 180, 1));
			addSequential(new PinkNavigate(55, 90, 1));
			addSequential(new PinkNavigate(110, 90, 1));
			
			//DERECK's CODE
//			addSequential(new PinkNavigate(-72.5,0,1));
//			addSequential(new PinkNavigate(-72.5,60,1));
//			addSequential(new PinkNavigate(-137.5,60,1));
//			addSequential(new PinkNavigate(-140,60,0.5));
//			
//			//go to the hopper
//			addSequential(new WaitCommand(2));
//			addSequential(new PinkNavigate(-117.5, 60, 0.7));
//			addSequential(new PinkNavigate(-117.5, 135, 0.7));
//			addSequential(new PinkNavigate(150, 135, 1));
//			addSequential(new PinkNavigate(150, 180, 1));
//			addSequential(new PinkNavigate(150, 180, 0.7));
//			addSequential(new PinkNavigate(150, 90, 0.7));
//			addSequential (new HoldPosition(150,90,0.7));
		} else {
			/* BLUE ALLIANCE AUTONOMOUS CODE */
			addSequential(new WaitCommand(Robot.delayTime));
			addSequential(new PinkNavigate(-70, 0, 1));
			//turn 60 degrees to back up to tip of peg
			addSequential(new PinkNavigate(-70, -60, 0.7));
			addSequential(new PinkNavigate(-132, -60, 0.7));
			addSequential(new PinkNavigate(-140, -60, 0.5));
			addSequential(new WaitCommand(2));
			//go to the hopper
			addSequential(new PinkNavigate(-80, -60, 1));
			addSequential(new PinkNavigate(-80, -180, 0.7));
			addSequential(new PinkNavigate(55, -180, 1));
			addSequential(new PinkNavigate(55, -90, 1));
			addSequential(new PinkNavigate(110, -90, 1));
			
			//DERECKS'S CODE
//			addSequential(new PinkNavigate(-72.5,0,1));
//			addSequential(new PinkNavigate(-72.5,-60,1));
//			addSequential(new PinkNavigate(-137.5,-60,1));
//			addSequential(new PinkNavigate(-140,-60,0.5));
//			
//			//go to the hopper
//			addSequential(new WaitCommand(2));
//			addSequential(new PinkNavigate(-117.5, -60, 0.7));
//			addSequential(new PinkNavigate(-117.5, 135, 0.7));
//			addSequential(new PinkNavigate(150, 135, 1));
//			addSequential(new PinkNavigate(150, 180, 1));
//			addSequential(new PinkNavigate(150, 180, 0.7));
//			addSequential(new PinkNavigate(150, 90, 0.7));
//			addSequential (new HoldPosition(150,90,0.7));
		}
	}
}
