package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {

	private double blowerSpeed = 1;
	private double agitatorSpeed = 1;
	private SpeedController agitatorMotor = new Talon(RobotMap.hopperAgitatorPort); 
	private SpeedController blowerMotor = new Talon(RobotMap.hopperBlowerPort);
	
	//private RobotDrive drive = new RobotDrive(agitatorMotor, blowerMotor);
	
	public Hopper() {
		super();
	}
	
	//link motor to joystick via port?
	public void agitate(Joystick shooter){
		//Robot.oi.getShooterJoystick().
		//shooter.getButton(button)
		agitatorMotor.set(agitatorSpeed);
	}
	
	public void blow(){
		blowerMotor.set(blowerSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
