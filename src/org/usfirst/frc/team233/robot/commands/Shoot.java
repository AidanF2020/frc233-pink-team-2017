package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	PIDController pid; 
	
	public Shoot(){
		requires(Robot.shooter);
		//pid = new PIDController(0, 0, 0, 0, null, null);
	}
	
	@Override
	protected void execute(){
		//Robot.shooter.shoot(Robot.oi.shooterDpad);
		Robot.shooter.shoot();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	
	public class SpinUp extends Command{
		@Override
		protected boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

}