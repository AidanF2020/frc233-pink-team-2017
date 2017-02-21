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
		addSequential(new PinkNavigate(-69,0,0.6));
		//addSequential (new StopBase());
		//addSequential();
		
	}
}
