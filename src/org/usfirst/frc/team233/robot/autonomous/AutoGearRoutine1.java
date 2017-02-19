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
		addSequential(new DriveStraight(-92));
		addSequential(new RotateBase(60));
		addSequential(new DriveStraight(-12));
		addSequential(new WaitCommand(5));
		addSequential(new DriveStraight(12));
		addSequential(new RotateBase(90));
		addSequential(new DriveStraight(148));
		addSequential(new RotateBase(0));
		addSequential(new DriveStraight(-15));
		addSequential (new StopBase());
		//addSequential();
		
	}
}
