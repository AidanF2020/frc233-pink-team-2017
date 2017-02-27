package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.commands.CollectorCommand;
import org.usfirst.frc.team233.robot.commands.CollectorCommand.CollectorAction;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous routine starting @ farthest position from boiler
 * @author Meriel
 *
 */
public class AutoShootRoutine1 extends CommandGroup{
	
	public AutoShootRoutine1(){
		// drive to latitude of hopper
		addSequential(new DriveStraight(195.16));
		// drive to hit touchpad
		// (distance depending on where we line up)
		// turn & back up to catch falling balls
		addSequential(new DriveStraight(-3));
		addSequential(new RotateBase(90));
		addSequential(new DriveStraight(-10));
		// collect fallen balls
		addParallel(new CollectorCommand(CollectorAction.COLLECT));
		addSequential(new DriveStraight(24));
		addSequential(new RotateBase(90));
		addSequential(new DriveStraight(33));
		addParallel(new CollectorCommand(CollectorAction.STOP));
		// drive to boiler
		addSequential(new RotateBase(180));
		
	}

}
