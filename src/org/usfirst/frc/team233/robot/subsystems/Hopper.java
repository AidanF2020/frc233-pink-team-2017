package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;
import org.usfirst.frc.team233.robot.commands.Agitate;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {

	private double blowerSpeed = 1;
	private double agitatorSpeed = 1;
	//private SpeedController agitatorMotor = new Talon(RobotMap.hopperAgitatorPort); 
	//private SpeedController blowerMotor = new Talon(RobotMap.hopperBlowerPort);
	// channels are for port mapping
	//private Encoder encoder = new Encoder(0, 1);
	
	//private RobotDrive drive = new RobotDrive(agitatorMotor, blowerMotor);
	
	public Hopper() {
		super();
		//encoder.setDistancePerPulse(1);
	}
	
	public void agitate(){
		//agitatorMotor.set(agitatorSpeed);
		//System.out.println("Encoder distance: "+ encoder.getDistance());
	}
	
	public void blow(){
		//blowerMotor.set(blowerSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Agitate());
	}

}
