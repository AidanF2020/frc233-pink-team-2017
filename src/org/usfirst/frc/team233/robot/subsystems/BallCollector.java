package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollector<Collect> extends Subsystem{
	
	//Collector Motor Definition
	private SpeedController collectorMotor = new Talon(RobotMap.collectorMotorPort);
	
	public BallCollector() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void collect() {
		
		//Sets Motor Power To 1 
		collectorMotor.set(1);
		 
	}
	public void eject() {
		
		//Sets Motor Power To 1 
		collectorMotor.set(-1);
	}
	
		
	public void stop() {
		
		//Sets Motor Power To 1 
		collectorMotor.set(0);
	}
	
}

