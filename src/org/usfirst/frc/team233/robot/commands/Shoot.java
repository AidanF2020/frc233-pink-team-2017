package org.usfirst.frc.team233.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
	public Shoot() {
		// TODO Auto-generated constructor stub
		addSequential(new SpinUp());
		addSequential(new BeginShooting());
	}
}
