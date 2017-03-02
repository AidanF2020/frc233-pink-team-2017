package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.commands.Shoot;
import org.usfirst.frc.team233.robot.commands.Shoot.ShooterAction;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoSitAndShoot extends CommandGroup {
//n.B. FACING FRONT OF ROBOT, SHOOTER IS ON RIGHT, shoots toward front
	
	double waitTime = 7;
	double blueAngle = 90;
	double redAngle = 90;
	boolean testing = false;
	double shootingSpeed = 0.7;
	
	public AutoSitAndShoot(boolean isBlueAlliance) {
		if(!isBlueAlliance){
			/*RED ALLIANCE SIDE -- SHOOTER CLOSER TO WALL*/
			if(testing){
				//drive to boiler wall then shoot
				addSequential(new PinkNavigate(6, 0, 1));
				addSequential(new PinkNavigate(6, 135, 0.7));
				addSequential(new PinkNavigate(10, 135, 0.5));
				addParallel(new Shoot(ShooterAction.SHOOT, shootingSpeed));
				addParallel(new PinkNavigate(10, 135, 0.7, true));
				addSequential(new WaitCommand(waitTime));
				addSequential(new Shoot(ShooterAction.CEASEFIRE));
				//drive over line
				addSequential(new PinkNavigate(6, 135, 0.7));
				addSequential(new PinkNavigate(6, 0, 0.5));
				addSequential(new PinkNavigate(110, 0, 0.7));
			} else {
				//line up however we want & shoot immediately
				addParallel(new Shoot(ShooterAction.SHOOT, shootingSpeed));
				addParallel(new PinkNavigate(0, 0, 0.7, true));
				addSequential(new WaitCommand(10));
				addSequential(new Shoot(ShooterAction.CEASEFIRE));
				//drive over line
				addSequential(new PinkNavigate(-6, -5, 0.5));
				//addSequential(new PinkNavigate(0, -90, 1));
				addSequential(new PinkNavigate(100, -90, 0.7));
			}
		} else {
			/*BLUE ALLIANCE SIDE -- SHOOTER AWAY FROM WALL*/
			if(testing){
				//turn until back is up against shooter
				addSequential(new PinkNavigate(6, 0, 0.7));
				addSequential(new PinkNavigate(6, -135, 0.5));
				addSequential(new PinkNavigate(10, -135, 0.5));
				addParallel(new Shoot(ShooterAction.SHOOT, shootingSpeed));
				addParallel(new PinkNavigate(10, -135, 0.7, true));
				addSequential(new WaitCommand(waitTime));
				//drive over line
				addSequential(new Shoot(ShooterAction.CEASEFIRE));

				addSequential(new PinkNavigate(6, -135, 0.7));
				addSequential(new PinkNavigate(6, 0, 0.7));
				addSequential(new PinkNavigate(110, 0, 0.7));
			} else {
				//line up however we want & shoot immediately
				addParallel(new Shoot(ShooterAction.SHOOT, shootingSpeed));
				addParallel(new PinkNavigate(0, 0, 0.7, true));
				addSequential(new Shoot(ShooterAction.CEASEFIRE));
				addSequential(new WaitCommand(10));
				//cross line
				addSequential(new PinkNavigate(-100, -45, 0.7));
				//addSequential(new PinkNavigate());
			}
		}
	}

}
