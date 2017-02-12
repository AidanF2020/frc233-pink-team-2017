package org.usfirst.frc.team233.robot.autonomous;


import org.usfirst.frc.team233.robot.commands.Shoot;
import org.usfirst.frc.team233.robot.subsystems.ShootingState;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitUntilCommand;

public class AutonomousShoot extends CommandGroup {
	public AutonomousShoot() {
		// TODO Auto-generated constructor stub
		addSequential(new Shoot(ShootingState.START_FLYWHEEL));
		addSequential(new Shoot(ShootingState.SHOOT));
		addSequential(new WaitUntilCommand(5));
		addSequential(new Shoot(ShootingState.CEASEFIRE));
		addSequential(new Shoot(ShootingState.STOP_FLYWHEEL));
	}
}
