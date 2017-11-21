package org.usfirst.frc.team2169.robot.Subsystems;

import org.usfirst.frc.team2169.robot.ActuatorMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain extends Subsystem{

	//Create Actuators
	CANTalon left1;
	CANTalon left2;
	CANTalon right1;
	CANTalon right2;
	DoubleSolenoid dogShifter;
	
	//Init Constructor
	public DriveTrain() {
		
		//Call Actuators
		left1 = new CANTalon(ActuatorMap.left1Port);
		left2 = new CANTalon(ActuatorMap.left2Port);
		right1 = new CANTalon(ActuatorMap.right1Port);
		right2 = new CANTalon(ActuatorMap.right2Port);
		dogShifter = new DoubleSolenoid(ActuatorMap.dogShifterForward, ActuatorMap.dogShifterReverse);
		
		
	}
	
	public void drive(double left, double right){
		
		left1.set(-left);
		left2.set(-left);
		right1.set(right);
		right2.set(right);
		
	}
	
	public void shift(boolean low, boolean high){
		
		if(low && dogShifter.get() == ActuatorMap.solenoidForward){
			dogShifter.set(ActuatorMap.solenoidReverse);
		}
		
		else if(high && dogShifter.get() == ActuatorMap.solenoidReverse){
			dogShifter.set(ActuatorMap.solenoidForward);
		}
		
	}
	
	public void pathFinder(){
		//TODO Pathfinder
	}
	
	
	
}
