package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {

	private double blowerSpeed = 1;
	private double agitatorSpeed = 1;
	private SpeedController agitatorMotor = new Talon(RobotMap.hopperAgitatorPort); 
	private SpeedController blowerMotor = new Talon(RobotMap.hopperBlowerPort);
	private Encoder encoder = new Encoder(0,1);
	private final double shooterDistancePerPulse = 0.123;
	
	public Hopper() {
		super();
		encoder.reset();
		encoder.setDistancePerPulse(shooterDistancePerPulse);
	}
	
	public void agitate(){
		//Robot.oi.getShooterJoystick().
		//shooter.getButton(button)
		agitatorMotor.set(agitatorSpeed);
		System.out.println("Agitator: " + encoder.getDistance());
	}
	
	public void blow(){
		blowerMotor.set(blowerSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
