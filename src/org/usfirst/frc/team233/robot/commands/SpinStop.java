
package org.usfirst.frc.team233.robot.commands;
import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
public class SpinStop extends Command {
	
	public SpinStop() {
		// TODO Auto-generated constructor stub
		requires(Robot.shooter.flywheel);
	}
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//System.out.println("TankDrive Execute!!!");
		Robot.shooter.flywheel.stop();
	}
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true; // Runs until interrupted
	}
	// Called once after isFinished returns true
	@Override
	protected void end() {
		
	}
}