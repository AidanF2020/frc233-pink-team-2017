package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest1 extends CommandGroup {

	public AutoTest1() {
		// TODO Auto-generated constructor stub
		addSequential(new PinkNavigate(10.0, 0, 0, 0.5, 0, 1.0));
	}

}
