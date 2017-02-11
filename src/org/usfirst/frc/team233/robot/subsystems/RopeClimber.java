package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem {

	private SpeedController climberMotor = new Talon(RobotMap.ropeClimberMotorPort);
	private final boolean isInverted = false;
	
	public RopeClimber() {
		// TODO Auto-generated constructor stub
		if (Robot.isReal()) {
			climberMotor.setInverted(isInverted);
		}
	}

	/** Skeleton method for a simple rope climbing action. */
	public void startClimbingRope() {
		climberMotor.set(RobotMap.ropeClimberSpeed);
	}
	
	
	/** Logic behind this method is still undetermined.
	 * Will need to revise after they decide on how they
	 * want to manage staying at the top of the rope.  */
	public void stopClimbingRope() {
		climberMotor.stopMotor();
	}
	
	
	public void reverseClimber() {
		climberMotor.set(-0.5);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
