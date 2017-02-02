package org.usfirst.frc.team233.robot.commands;
import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
public class EjectBalls extends Command{
	
	public EjectBalls() {
		requires(Robot.ballCollector);
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.ballCollector.eject();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}