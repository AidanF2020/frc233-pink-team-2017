package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class BeginShooting extends Command {

	private boolean skipSpeedCheck;
	
	public BeginShooting() {
		// TODO Auto-generated constructor stub
		requires(Robot.indexer);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(Robot.flywheel.motorSpeedEqualsSetSpeed() || skipSpeedCheck) {
			skipSpeedCheck = true;
			Robot.hopper.agitate();
			Robot.indexer.releaseBalls();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		super.interrupted();
		//System.out.println("BeginShooting Interrupted!!!");
		skipSpeedCheck = false;
	}

}
