package org.usfirst.frc.team233.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {
//	private PWM arduino = new PWM(9);
	private SerialPort arduino = new SerialPort(9600, SerialPort.Port.kUSB1);

	public enum LightingType {
		shooting, placingGear
	};

	@Override
	protected void initDefaultCommand() {

	}
	/*public void init(){
		//arduino.setBounds(255, 50, 50, 50, 0);
	}*/

	public void activateLights(LightingType lt) {
		switch(lt){
		case shooting:
			arduino.write(new byte[]{1}, 1);
			//arduino.setRaw(10);
			break;
		case placingGear:
			arduino.write(new byte[]{2}, 1);
			//arduino.setRaw(20);
			break;
		}
	}
}