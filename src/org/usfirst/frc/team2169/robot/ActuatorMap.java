package org.usfirst.frc.team2169.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ActuatorMap {

	//CANTalon Ports
	public static final int left1Port= 1;
	public static final int left2Port= 2;
	public static final int right1Port= 3;
	public static final int right2Port= 4;
	
	
	//Solenoid Ports
	public static final int dogShifterForward = 1;
	public static final int dogShifterReverse = 2;

	//Solenoid States
	public static final DoubleSolenoid.Value driveLowGear = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value driveHighGear = DoubleSolenoid.Value.kForward;
}
