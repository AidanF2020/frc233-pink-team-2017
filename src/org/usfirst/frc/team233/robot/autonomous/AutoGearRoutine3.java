package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ nearest position to boiler
 * Red Alliance side
 */
public class AutoGearRoutine3 extends CommandGroup {

	//make isBlueAlliance constructor param after finished testing
	//public boolean isBlueAlliance = true;

	public AutoGearRoutine3(boolean isBlueAlliance){
		if (!isBlueAlliance) {
			/* RED ALLIANCE AUTONOMOUS CODE */
			
			addSequential(new PinkNavigate(-84,0,1));
			addSequential(new PinkNavigate(-84,-60,1));
	        addSequential(new PinkNavigate(-126,-60,0.7));
	        //go to base line
			//addSequential(new WaitCommand(2));
			addSequential(new PinkNavigate(-90, -60, 0.7));
			addSequential(new PinkNavigate(-90, 30, 0.7));
			addSequential(new PinkNavigate(-200, 30, 0.7));
			//addSequential (new StopBase());
			//addSequential();
		}
		else {
			/* BLUE ALLIANCE AUTONOMOUS CODE */
			
			//back up until you're on peg's angle
//			addSequential(new PinkNavigate(-95, 0, 1));
//			//turn 60 degrees to back up to tip of peg
//			addSequential(new PinkNavigate(-95, -60, 0.7));
//			addSequential(new PinkNavigate(-112, -60, 0.5));
//			addSequential(new WaitCommand(1.0));
//			//go to the hopper
//			addSequential(new PinkNavigate(-80, -60, 1));
//			addSequential(new PinkNavigate(-80, -180, 0.7));
//			addSequential(new PinkNavigate(-5, -180, 0.7));
//			addSequential(new PinkNavigate(-5, -180, 0.7));
			addSequential(new WaitCommand(Robot.delayTime));
			addSequential(new PinkNavigate(-72.5,0,1));
			addSequential(new PinkNavigate(-72.5,60,1));
			addSequential(new PinkNavigate(-137.5,60,1));
			addSequential(new PinkNavigate(-140,60,0.5));
			//go to base line
			addSequential(new WaitCommand(2));
			addSequential(new PinkNavigate(-121, -60, 0.7));
			addSequential(new PinkNavigate(-121, 0, 0.7));
			addSequential(new PinkNavigate(-300, 0, 0.7));
			addSequential (new HoldPosition(-300,0,0.7));
		}
		/*
		if(!isBlueAlliance){
			addSequential(new PinkNavigate(-109,0,1));
			addSequential(new PinkNavigate(-109,-60,1));
	        addSequential(new PinkNavigate(-164,-60,1));
	        //go to base line
			addSequential(new WaitCommand(2));
			addSequential(new PinkNavigate(-121, -60, 0.7));
			addSequential(new PinkNavigate(-121, 0, 0.7));
			addSequential(new PinkNavigate(-221, 0, 0.7));
			//addSequential (new StopBase());
			//addSequential();
		} else {
			 //red alliance stuff
		}
		*/
	}
}
