package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ farthest position from boiler
 * @author Meriel
 *
 */
public class AutoGearRoutine1 extends CommandGroup {

	public AutoGearRoutine1(){
		addSequential(new PinkNavigate(72.5,0,1));
		addSequential(new PinkNavigate(72.5,60,1));
		addSequential(new PinkNavigate(137.5,60,1));
		//addSequential (new StopBase());
		//addSequential();
		
	}
}
