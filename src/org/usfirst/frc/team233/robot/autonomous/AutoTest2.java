package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class AutoTest2 extends PIDCommand{
	
	private double targetPos;
	private boolean reverse;
	
	public AutoTest2(double kp, double kd, double targetPos, boolean reverse) {
		// TODO Auto-generated constructor stub
		super(kp, 0, kd);
		setSetpoint(targetPos);
		this.targetPos = targetPos;
		this.reverse= reverse;
		requires(Robot.drivetrain);
		System.out.println("AutoTest2");
		Robot.drivetrain.reset();
	}

	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.drivetrain.getLeftDistance() >= targetPos;
	}
	
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		System.out.println("PIDInput = " + Robot.drivetrain.getDistanceTraveled());
		return Robot.drivetrain.getLeftDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		//System.out.println("Output = " + output);
		if (reverse) {
			Robot.drivetrain.drive(-output, -output);
		}
		else {
			Robot.drivetrain.drive(output, output);
		}
		
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drivetrain.drive(0.0, 0.0);
	}

}
