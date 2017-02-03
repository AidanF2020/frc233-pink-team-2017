package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {

	private SpeedController agitatorMotor = new Talon(RobotMap.agitatorMotorPort); 
	private SpeedController blowerMotor = new Talon(RobotMap.blowerMotorPort);
	
	public Hopper() {
		super();
	}
	
	public void agitate(){
		//Robot.oi.getShooterJoystick().
		//shooter.getButton(button)
		agitatorMotor.set(RobotMap.agitatorMotorSpeed);
	}
	
	public void blow(){
		blowerMotor.set(RobotMap.blowerMotorSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
