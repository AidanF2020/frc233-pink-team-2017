package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.PinkPD;
import org.usfirst.frc.team233.robot.Range;
import org.usfirst.frc.team233.robot.Robot;
import org.usfirst.frc.team233.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PinkNavigate extends Command {
    static final double COUNTS_PER_INCH = 388;  // Base travel
    static final double POSITION_THRESHOLD = 30.0;   // Counts
    static final double ANGLE_THRESHOLD = 5.0;     // Degrees
    
    
    private double targetPos;
    private double targetAngle;
    private int currentAngle;
    private double linearVelocity;
    private double angularVelocity; 
    private double maxPower;
    private double motorCmd;

    
    /** Constructor - Define the distance and angle for the robot to */
    public PinkNavigate(double targetPos, double targetAngle, double maxPower) {
    	this.targetPos = targetPos;
    	this.targetAngle = targetAngle;
    	this.maxPower = maxPower;
    	requires(Robot.drivetrain);
    	//Robot.drivetrain.resetEncoders();
    	resetBasePosition();
    }
    
    
    // Tank drive two wheels to target positions in inches.
    // Returns true when both arrive at the target.
    public boolean driveToPos() {
    	SmartDashboard.putString("PinkNavigate", "is Running");
    	double currentAngle = Robot.drivetrain.getGyroRotation();
    	double angularVelocity = Robot.drivetrain.getGyroRate();
        double targetPosCounts = targetPos * COUNTS_PER_INCH;
        double currentPosCounts = Robot.drivetrain.getDistanceTraveled();
        double linearVelocity = Robot.drivetrain.getDriveTrainRate();
        double linearError = targetPosCounts - currentPosCounts;
        double angularError = targetAngle - currentAngle;
        double motorCmd = PinkPD.getMotorCmd(0.1, 0.01, linearError, linearVelocity);
        SmartDashboard.putNumber("MotorCMD", motorCmd);
        motorCmd = Range.clip(motorCmd, 0.5, -0.5);

        // Determine and add the angle offset
        double angleOffset = PinkPD.getMotorCmd(0.02, 0.02, angularError, angularVelocity);
        SmartDashboard.putNumber("Angle Offset", angleOffset);
        double leftMotorCmd = motorCmd + angleOffset;
        double rightMotorCmd = motorCmd - angleOffset;
        leftMotorCmd = Range.clip(leftMotorCmd, -maxPower, maxPower);
        rightMotorCmd = Range.clip(rightMotorCmd, -maxPower, maxPower);
        SmartDashboard.putNumber("leftMotorCmd", leftMotorCmd);
        SmartDashboard.putNumber("rightMotorCmd", rightMotorCmd);

        // Scale the motor commands back to account for the MC windup problem
        // (if the motor can't keep up with the command, error builds up)
        //leftMotorCmd *= maxPower;
        //rightMotorCmd *= maxPower;

        Robot.drivetrain.drive(leftMotorCmd, rightMotorCmd);
        if((Math.abs(linearError) < POSITION_THRESHOLD) && (Math.abs(angularError) < ANGLE_THRESHOLD)) {
             return true;
        } else {
            return false;
        }
    }

    public static void stopBase() {
        Robot.drivetrain.drive(0, 0);
    }

    public static boolean resetBasePosition() {
        boolean resetStatus = false;
        Robot.drivetrain.resetEncoders();
        
        if ((Robot.drivetrain.getLeftDistance()==0)&&(Robot.drivetrain.getRightDistance()==0)) {
            resetStatus = true;
        }
        return resetStatus;
    }

    public static double getBasePosition() {
        return ((Robot.drivetrain.getLeftDistance() + Robot.drivetrain.getRightDistance())/2.0);
    }
    
    @Override
    protected void execute() {
    	super.execute();
    }
    
	@Override
	protected boolean isFinished() {
		return driveToPos();
	}
	
	@Override
	protected void end() {
		super.end();
		stopBase();
	}
	
	//migrated over from Range class
	public static double clip (double cmd, double max, double min) {
		if (cmd > max) {
			return max;
		}
		else if (cmd < min){
			return min;
		}
		else {
			return cmd;
		}
	}

    /**
     * Created by Andy on 11/12/2015.
     *
     * Both motors and continuous servos are covered.
     */
}
