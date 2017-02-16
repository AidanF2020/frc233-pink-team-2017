package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;
import org.usfirst.frc.team233.robot.subsystems.ShootingState;

import edu.wpi.first.wpilibj.command.Command;

/**
 * WARNING: Still in prototype phase!
 * 		    DO NOT use for shooting
 * 			yet!*/
public class Shoot extends Command{
	ShootingState state;
	
	public Shoot(ShootingState state) {
		// TODO Auto-generated constructor stub
		requires(Robot.flywheel);
		this.state = state;
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.flywheel.adjustFlywheelSpeed(Robot.oi.getShooterJoystick().getPOV());
		switch (state) {
			case START_FLYWHEEL:
				/* Verify the state of the right bumper button on the shooter control.
				 * If it's pressed, then skip this command, else start the flywheel at
				 * half speed. */
				if (!Robot.oi.getShooterJoystick().getRawButton(RobotMap.rightTriggerButtonNumber)) {
					Robot.flywheel.flywheelHalfSpeed();
				}
				break;
				
			case SHOOT:
				Robot.flywheel.startFlywheel();
				state = ShootingState.FLYWHEEL_SPINNING_UP;
				break;
				
			case FLYWHEEL_SPINNING_UP:
				if (Robot.flywheel.motorSpeedEqualsSetSpeed()) {
					state = ShootingState.FLYWHEEL_UP_TO_SPEED;
				}
				break;
		
			case FLYWHEEL_UP_TO_SPEED:
				Robot.hopper.agitate();
				state = ShootingState.SHOOTING;
				break;
			
			case SHOOTING:
				Robot.indexer.releaseBalls();
				break;
				
			case CEASEFIRE:
				Robot.hopper.stopAgitate();
				Robot.indexer.stopIndexer();
				break;
				
			case STOP_FLYWHEEL:
				Robot.flywheel.stopFlywheel();
				break;
	
			default:
				break;
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if ((ShootingState.START_FLYWHEEL == state) || 
			(ShootingState.CEASEFIRE == state) ||
			(ShootingState.STOP_FLYWHEEL == state)) {
			return true;
		}
		else {
			return false;
		}
	}

}
