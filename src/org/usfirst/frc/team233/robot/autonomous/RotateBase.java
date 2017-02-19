package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.Robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

public class RotateBase extends Command {
	private PIDController pid;
	private final double tolerance = 0.5;

	public RotateBase(double angle) {
		requires(Robot.drivetrain);
		Robot.drivetrain.reset();
		pid = new PIDController(3, 0, 0.1, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			@Override
			public double pidGet() {
				return Robot.drivetrain.getGyroRotation();
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				if (d > 0.5) {
					d = 0.5;
				}
				else if (d < -0.5) {
					d = -0.5;
				}
				// if turning left
				//if( (Robot.drivetrain.getGyroRotation() % 360 - angle) < 0){
					//drive(left, right)
					Robot.drivetrain.drive(-d, d);
				//} else {  // turning left
					//Robot.drivetrain.drive(d, -d);
				//}
			}
		});
		pid.setAbsoluteTolerance(tolerance);
		pid.setSetpoint(angle);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Get everything in a safe starting state.
		Robot.drivetrain.reset();
		pid.reset();
		pid.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return pid.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Stop PID and the wheels
		pid.disable();
		Robot.drivetrain.drive(0, 0);
	}
}
