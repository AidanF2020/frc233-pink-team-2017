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
	ShooterAction action;
	
	public enum ShooterAction{
		STOP_FLYWHEEL,
		START_FLYWHEEL,
		SHOOT,
		CEASEFIRE,
		TEST_F_UP,
		TEST_F_DOWN,
		TEST_H_UP,
		TEST_H_DOWN,
		TEST_I_UP,
		TEST_I_DOWN,
		SKIP; // Used to make sure the subsystem actions don't run again
		
	}
	
	public Shoot(ShooterAction action) {
		// TODO Auto-generated constructor stub
		requires(Robot.flywheel);
		this.action = action;
	}
	
	@Override
	protected void execute() {
		//edited for if joystick unplugged, will return null
		if (Robot.oi.getShooterJoystick() != null){
			Robot.flywheel.adjustFlywheelSpeed(Robot.oi.getShooterJoystick().getPOV());
		}	
		
		// Obtain what action to perform 
		switch (action) {
			case START_FLYWHEEL:
				if (Robot.flywheel.getFlywheelState() == ShootingState.FLYWHEEL_STOPPED) {
					Robot.flywheel.flywheelHalfSpeed();
					Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_HALF_SPEED);
				}
				//action = ShooterAction.SKIP;
				break;
				
			case STOP_FLYWHEEL:
				if (Robot.flywheel.getFlywheelState() == ShootingState.FLYWHEEL_HALF_SPEED) {
					Robot.flywheel.stopFlywheel();
					Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_STOPPED);
				}
				break;
				
			case SHOOT:
				Robot.flywheel.startFlywheel();
				if (Robot.flywheel.getFlywheelState() != ShootingState.FLYWHEEL_UP_TO_SPEED){
					Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_SPINNING_UP);
				}
				//action = ShooterAction.SKIP;
				break;
				
			case CEASEFIRE:
				Robot.indexer.stopIndexer();
				Robot.hopper.stopAgitate();
				Robot.flywheel.setFlywheelState(ShootingState.INDEXER_STOPPED);
				break;
				
			case TEST_F_DOWN:
				Robot.flywheel.stopFlywheel();
				Robot.flywheel.setFlywheelState(ShootingState.IGNORE);
				break;
				
			case TEST_F_UP:
				Robot.flywheel.startFlywheel();
				Robot.flywheel.setFlywheelState(ShootingState.IGNORE);
				break;
				
			case TEST_H_UP:
				Robot.hopper.agitate();
				Robot.flywheel.setFlywheelState(ShootingState.IGNORE);
				break;
				
			case TEST_H_DOWN:
				Robot.hopper.stopAgitate();
				Robot.flywheel.setFlywheelState(ShootingState.IGNORE);
				break;
				
			case TEST_I_UP:
				Robot.indexer.releaseBalls();
				Robot.flywheel.setFlywheelState(ShootingState.IGNORE);
				break;
			
			case TEST_I_DOWN:
				Robot.indexer.stopIndexer();
				Robot.flywheel.setFlywheelState(ShootingState.IGNORE);
				break;
				
	
			default:
				System.out.println("ShootingAction == SKIP");
				break;
		}
		
		// Depending on the state, run the concurrent command
		switch (Robot.flywheel.getFlywheelState()) {
			case FLYWHEEL_SPINNING_UP:
				if (Robot.flywheel.motorSpeedEqualsSetSpeed()) {
					Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_UP_TO_SPEED);
				}
				break;
		
			case FLYWHEEL_UP_TO_SPEED:
				Robot.hopper.agitate();
				Robot.indexer.releaseBalls();
				//Robot.flywheel.setFlywheelState(ShootingState.SHOOTING);
				break;
			
			case INDEXER_STOPPED:
				Robot.flywheel.flywheelHalfSpeed();
				Robot.flywheel.setFlywheelState(ShootingState.FLYWHEEL_HALF_SPEED);
				break;
	
			default:
				break;
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if ((ShooterAction.START_FLYWHEEL == action) || 
			(ShooterAction.CEASEFIRE == action) ||
			(ShooterAction.STOP_FLYWHEEL == action)) {
			return true;
		}
		else {
			return false;
		}
	}

}
