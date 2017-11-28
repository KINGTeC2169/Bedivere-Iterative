package org.usfirst.frc.team2169.robot.Subsystems;

import org.usfirst.frc.team2169.robot.ActuatorMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Intakes extends Subsystem{
	
	CANTalon intake;
	DoubleSolenoid HumanPlayer;
	
	//init
	public Intakes(){
		
		//define Actuators
		intake = new CANTalon(ActuatorMap.intakePort);
		HumanPlayer =  new DoubleSolenoid(ActuatorMap.humanPlayerForward, ActuatorMap.humanPlayerReverse);
	}
	
	
	//Method to run intake
	public void intake(double Speed){
		intake.set(Speed);
		
	}
	
	//Method to flip solenoids
	public void humanPlayerShift(boolean low, boolean high){			
		if(low && HumanPlayer.get() == ActuatorMap.solenoidForward){
			HumanPlayer.set(ActuatorMap.solenoidReverse);
		}
			
		else if(high && HumanPlayer.get() == ActuatorMap.solenoidReverse){
			HumanPlayer.set(ActuatorMap.solenoidForward);
		}
			
		
		
		
	}

}
