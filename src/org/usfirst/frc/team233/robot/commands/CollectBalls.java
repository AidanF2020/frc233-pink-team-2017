package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CollectBalls extends Command {

	public CollectBalls() {
		// TODO Auto-generated constructor stub
		requires(Robot.ballCollector);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.ballCollector.collect();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// FOR TESTING!!!!
		if (Robot.oi.getBaseJoystick().getRawButton(8)) {
			System.out.println("Right Trigger Pressed!");
		}
		else {
			System.out.println("Right Trigger RELEASED!!!");
		}
		
		return true;
	}
}
