package org.usfirst.frc.team233.robot.subsystems;
import org.usfirst.frc.team233.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
public class BallCollector extends Subsystem{
	
	// Collector Motor Definition
	private SpeedController collectorMotor = new Talon(6);
	private final double collectorSpeed = 0.5;
	private final boolean isInverted = false;
	
	public BallCollector() {	
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	/** Start collecting balls */
	public void collect() {
		// Set the correct orientation for the motors
		collectorMotor.setInverted(isInverted);
		
		// Run the collector motor at defined speed
		collectorMotor.set(collectorSpeed);
		 
	}
	
	/** Reverse collector to eject balls */
	public void eject() {
		// Reverse the orientation of the motor
		collectorMotor.setInverted(!isInverted);
		
		// Run the collector motor at defined speed
		collectorMotor.set(collectorSpeed);
	}
	
	/** Stop collecting balls*/
	public void stop() {
		// Stop the collector 
		collectorMotor.stopMotor();
	}
	
}
