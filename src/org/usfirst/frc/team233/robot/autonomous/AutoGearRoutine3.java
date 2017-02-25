package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ nearest position to boiler
 */
public class AutoGearRoutine3 extends CommandGroup {

	public AutoGearRoutine3(){
		addSequential(new PinkNavigate(-109,0,1));
		addSequential(new PinkNavigate(-109,-60,1));
		addSequential(new PinkNavigate(-141,-60,1));
		//go to base line
		addSequential(new WaitCommand(2));
		addSequential(new PinkNavigate(-121, -60, 0.7));
		addSequential(new PinkNavigate(-121, 0, 0.7));
		addSequential(new PinkNavigate(-221, 0, 0.7));
		//addSequential (new StopBase());
		//addSequential();
		
	}
}
