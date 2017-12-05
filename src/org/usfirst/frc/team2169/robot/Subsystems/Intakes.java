package org.usfirst.frc.team2169.robot.Subsystems;

import org.usfirst.frc.team2169.robot.ActuatorMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Intakes extends Subsystem{
	
	CANTalon intake;
	CANTalon topRoller;
	DoubleSolenoid humanPlayer;
	DoubleSolenoid pancake;
	private boolean shiftCounted = false;
	
	//init
	public Intakes(){
		
		//define Actuators
		topRoller = new CANTalon(ActuatorMap.topRollerPort);
		intake = new CANTalon(ActuatorMap.intakePort);
		pancake = new  DoubleSolenoid(ActuatorMap.compressorPort, ActuatorMap.pancakeForward, ActuatorMap.pancakeBackwards);
		humanPlayer =  new DoubleSolenoid(ActuatorMap.compressorPort, ActuatorMap.humanPlayerForward, ActuatorMap.humanPlayerReverse);
	}
	
	
	//Method to run intake
	public void intake(double Speed){
		intake.set(Speed);
		topRoller.set(Speed);
		
	}
	
	//Method to flip solenoids
	public void humanPlayerShift(boolean shift){
		if(!shift){
			shiftCounted = false;
		}
		if(!shiftCounted && (shift && (humanPlayer.get() == ActuatorMap.solenoidReverse || humanPlayer.get() == ActuatorMap.solenoidOff))) humanPlayer.set(ActuatorMap.solenoidForward);
		else if (!shiftCounted && (shift && humanPlayer.get() == ActuatorMap.solenoidForward)) humanPlayer.set(ActuatorMap.solenoidReverse);
		
		if(!shiftCounted && shift){
			shiftCounted = true;
		}
	}	
	public void pancakes(boolean fb){
		if(fb && pancake.get() == ActuatorMap.solenoidReverse){
			pancake.set(ActuatorMap.solenoidForward);
		} else if (!fb && pancake.get() == ActuatorMap.solenoidForward){
			pancake.set(ActuatorMap.solenoidReverse);
		}
	}						
}

