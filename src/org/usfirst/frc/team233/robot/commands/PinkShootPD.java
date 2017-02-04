package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.RobotMap;
import org.usfirst.frc.team233.robot.Range;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PinkShootPD{

    private PinkShootPD() {
    }

    // Use a PD to determine a motor command, which has a range of -1 to 1 (-1=rev; 0=stop; 1=fwd)
    public static double getSpeedCmd( double targetSpeed, double Kp) {
    	double currentSpeed = 0.0;//Robot.shooterWheel.getRate();
    	double error = (targetSpeed - currentSpeed);
        double speedCmd;
        System.out.println("inside getSpeedCmd, currentSpeed: "+currentSpeed);
        speedCmd = ((Kp * error) + targetSpeed);

        return speedCmd;
    } 
}

