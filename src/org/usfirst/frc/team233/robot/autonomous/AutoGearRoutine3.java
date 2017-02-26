package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ nearest position to boiler
 * Red Alliance side
 */
public class AutoGearRoutine3 extends CommandGroup {

	public AutoGearRoutine3(){
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
}
