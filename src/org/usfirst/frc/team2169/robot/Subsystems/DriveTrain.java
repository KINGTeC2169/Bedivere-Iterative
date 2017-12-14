package org.usfirst.frc.team2169.robot.Subsystems;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team2169.robot.ActuatorMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain extends Subsystem{

	//Create Actuators
	public static Encoder leftEnc;
	public static Encoder rightEnc;
	public static CANTalon left1;
	CANTalon left2;
	public static CANTalon right1;
	CANTalon right2;
	DoubleSolenoid dogShifter;
	
	//Init Constructor
	public DriveTrain() {
		
		leftEnc = new Encoder(0,1,false);
		leftEnc.reset();
		rightEnc = new Encoder(2,3,true);
		rightEnc.reset();
		//Call Actuators
		left1 = new CANTalon(ActuatorMap.left1Port);
		left2 = new CANTalon(ActuatorMap.left2Port);
		
		
		right1 = new CANTalon(ActuatorMap.right1Port);
		right2 = new CANTalon(ActuatorMap.right2Port);
		
		left2.changeControlMode(CANTalon.TalonControlMode.Follower);
		left2.set(ActuatorMap.left1Port);
		
		right2.changeControlMode(CANTalon.TalonControlMode.Follower);
		right2.set(ActuatorMap.right1Port);
		
		dogShifter = new DoubleSolenoid(ActuatorMap.compressorPort, ActuatorMap.dogShifterForward, ActuatorMap.dogShifterReverse);
		
		
	}
	
	public void drive(double left, double right){
		
		left1.set(-left);
		right1.set(right);
		
	}
	
	public void shift(boolean low, boolean high){
		
		if(low && (dogShifter.get() == ActuatorMap.solenoidForward || dogShifter.get() == ActuatorMap.solenoidOff)){
			dogShifter.set(ActuatorMap.solenoidReverse);
		}
		
		
		else if(high && (dogShifter.get() == ActuatorMap.solenoidReverse || dogShifter.get() == ActuatorMap.solenoidOff)){
			dogShifter.set(ActuatorMap.solenoidForward);
		}
		
	}
	
	public void pathFinder(){
		//TODO Pathfinder
	}
	
	
	
}
