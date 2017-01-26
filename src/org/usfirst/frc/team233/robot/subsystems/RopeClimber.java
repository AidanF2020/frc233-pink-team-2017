package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem {

	private SpeedController climberMotor = new Talon(RobotMap.ropeClimberMotorPort);
	private double climbingSpeed = 0.75;
	private double holdSpeed = 0.25;
	private double looseSpeed = - 0.10;
	private final boolean isInverted = false;
	
	public RopeClimber() {
		// TODO Auto-generated constructor stub
		
	}

	/** Skeleton method for a simple rope climbing action. */
	public void startClimbingRope() {
		climberMotor.setInverted(isInverted);
		climberMotor.set(climbingSpeed);
	}
	
	
	/** Logic behind this method is still undetermined.
	 * Will need to revise after they decide on how they
	 * want to manage staying at the top of the rope.  */
	public void holdPosition() {
		// Not clear what we are doing here yet.
		climberMotor.setInverted(isInverted);
		climberMotor.set(holdSpeed);
	}
	
	/** Not sure if method is really needed, but I'll
	 * leave it as a place holder for possible action. */
	public void untangleRope() {
		climberMotor.setInverted(!isInverted);
		climberMotor.set(looseSpeed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
