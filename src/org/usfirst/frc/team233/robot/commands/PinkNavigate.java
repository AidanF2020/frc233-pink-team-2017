package org.usfirst.frc.team233.robot.commands;

import org.usfirst.frc.team233.robot.PinkPD;
import org.usfirst.frc.team233.robot.Range;
import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class PinkNavigate extends Command {
    static final double COUNTS_PER_INCH = 54;  // Base travel
    static final double POSITION_THRESHOLD = 30.0;   // Counts
    static final double ANGLE_THRESHOLD = 5.0;     // Degrees
    
    
    private double targetPos;
    private double targetAngle;
    private int currentAngle;
    private double linearVelocity;
    private double angularVelocity; 
    private double maxPower;

    // Tank drive two wheels to target positions in inches.
    // Returns true when both arrive at the target.
    public boolean driveToPos() {
    	double motorCmd = 0;
        double targetPosCounts = targetPos * COUNTS_PER_INCH;
        double leftMotorCmd, rightMotorCmd;
        double leftWheelPos = Robot.drivetrain.getDistanceTraveled();
        double rightWheelPos = Robot.drivetrain.getDistanceTraveled();
        double angleErrorDegrees = targetAngle - currentAngle;
        double currentPosCounts = (leftWheelPos + rightWheelPos)/2.0;
        double angleOffset;
        double linearError = targetPosCounts - currentPosCounts;
        double angularError = targetAngle - currentAngle;

        // Determine the baseline motor speed command
        motorCmd = Range.clip(motorCmd, 0.5, -0.5);

        // Determine and add the angle offset
        angleOffset = PinkPD.getMotorCmd(0.02, 0.02, angularError, angularVelocity);
        leftMotorCmd = motorCmd + angleOffset;
        rightMotorCmd = motorCmd - angleOffset;
        leftMotorCmd = Range.clip(leftMotorCmd, -1.0, 1.0);
        rightMotorCmd = Range.clip(rightMotorCmd, -1.0, 1.0);

        // Scale the motor commands back to account for the MC windup problem
        // (if the motor can't keep up with the command, error builds up)
        leftMotorCmd *= maxPower;
        rightMotorCmd *= maxPower;

        Robot.drivetrain.drive(leftMotorCmd, rightMotorCmd);
        if((Math.abs(targetPosCounts - currentPosCounts)<POSITION_THRESHOLD)&&(Math.abs(angleErrorDegrees)<ANGLE_THRESHOLD))
        {
             return true;
        } else
        {
            return false;
        }
    }

    public static void stopBase()
    {
        Robot.drivetrain.drive(0, 0);
    }

    public static boolean resetBasePosition()
    {
        boolean resetStatus = false;
        Robot.drivetrain.resetEncoders();
        
        if ((Robot.drivetrain.getLeftDistance()==0)&&(Robot.drivetrain.getRightDistance()==0))
        {
            resetStatus = true;
        }
        return resetStatus;
    }

    public static double getBasePosition()
    {
        return ((Robot.drivetrain.getLeftDistance() + Robot.drivetrain.getRightDistance())/2.0);
    }

    
    /** Constructor - Define the distance and angle for the robot to */
    public PinkNavigate(double targetPos, double targetAngle, int currentAngle,
		     		    double linearVelocity, double angularVelocity, 
		     		    double maxPower) {
    	this.targetPos = targetPos;
    	this.targetAngle = targetAngle;
    	this.currentAngle = currentAngle;
    	this.linearVelocity = linearVelocity;
    	this.angularVelocity = angularVelocity;
    	this.maxPower = maxPower;
    }
    
    
    @Override
    protected void execute() {
    	// TODO Auto-generated method stub
    	super.execute();
    	
    }
    
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return driveToPos();
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		super.end();
	}

    /**
     * Created by Andy on 11/12/2015.
     *
     * Both motors and continuous servos are covered.
     */
}
