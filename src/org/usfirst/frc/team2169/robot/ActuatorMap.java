package org.usfirst.frc.team2169.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ActuatorMap {

	//CANTalon Ports
	public static final int left1Port= 1;
	public static final int left2Port= 2;
	public static final int right1Port= 6;
	public static final int right2Port= 7;
	public static final int intakePort= 8;
	public static final int topRollerPort= 4;
	public static final int gearManipPort= 5;
	public static final int hangerPort = 9;
	
	
	//button ports
	public static final int pressurePlatePort = 6;
	public static final int sliderRightPort = 5;
	public static final int sliderLeftPort = 4;
	
	//Compressor Port
	
	public static final int compressorPort = 12;
	
	//Solenoid Ports
	public static final int pancakeForward = 2;
	public static final int pancakeBackwards = 5;
	public static final int dogShifterForward = 0;
	public static final int dogShifterReverse = 7;
	public static final int humanPlayerForward = 3;
	public static final int humanPlayerReverse = 4;
	public static final int doorForward = 1;
	public static final int doorReverse = 6;
	

	//Solenoid States
	public static final DoubleSolenoid.Value solenoidReverse = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value solenoidForward = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value solenoidOff = DoubleSolenoid.Value.kOff;
}
