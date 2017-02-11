package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.subsystems.ShootingState;

import edu.wpi.first.wpilibj.command.Command;


/**
 * WARNING: Still in prototype phase!
 * 		    DO NOT use for shooting
 * 			yet!*/
public class Shoot extends Command{

	public Shoot() {
		// TODO Auto-generated constructor stub
		requires(Robot.flywheel);
		Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_SPINNING_UP);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		super.execute();
		switch (Robot.flywheel.getFlywheelState()) {
			case FLYWHEEL_SPINNING_UP:
				Robot.flywheel.startFlywheel();
				if (Robot.flywheel.motorSpeedEqualsSetSpeed()) {
					Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_UP_TO_SPEED);
				}
				break;
			
			case FLYWHEEL_UP_TO_SPEED:
				Robot.hopper.agitate();
				break;
			
			case SHOOT:
				Robot.indexer.releaseBalls();
				break;
	
			default:
				break;
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
