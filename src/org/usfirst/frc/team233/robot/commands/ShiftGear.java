package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftGear extends Command {

	public ShiftGear() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		super.execute();
		Robot.drivetrain.shiftGears();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
