package org.usfirst.frc.team233.robot.commands;

//import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUp extends Command {

	public SpinUp() {
		// TODO Auto-generated constructor stub

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// System.out.println("TankDrive Execute!!!");
		System.out.println("going to spin");
	//	try {
		//	TimeUnit.SECONDS.sleep(1);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//System.out.println("time delay isnt working");
		//}
		if(Robot.oi.shooterDpad != 8){
			Robot.shooter.flywheel.adjustFlywheelSpeed();
		}
		Robot.shooter.flywheel.spin();
		Robot.shooterWheel.spin();
		//try {
		//	TimeUnit.SECONDS.sleep(2);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//}
		
		//Robot.indexerWheel.spin();

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true; // Runs until interrupted
		
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Robot.shooterWheel.stop();

	}

}
