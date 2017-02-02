
package org.usfirst.frc.team233.robot.commands;
import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SpinUp extends Command {
	public SpinUp() {}
	
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
		
		//Dpad position == 8 when nothing pressed
		if(Robot.oi.shooterDpad != 8){
			Robot.shooter.flywheel.adjustFlywheelSpeed();
		}
		Robot.shooter.flywheel.spin();
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