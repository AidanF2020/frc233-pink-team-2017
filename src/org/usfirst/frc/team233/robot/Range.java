package org.usfirst.frc.team233.robot;

public class Range {
public static double clip (double cmd, double max, double min) {
	if (cmd > max) {
		cmd = max;
	}
	else if (cmd < min){
		cmd = min;
	}
	else {}
	return cmd;
	}
}
