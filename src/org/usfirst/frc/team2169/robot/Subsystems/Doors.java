package org.usfirst.frc.team2169.robot.Subsystems;
import org.usfirst.frc.team2169.robot.ActuatorMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.CANTalon;

public class Doors extends Subsystem{
	
	CANTalon DoorSlider;
	DoubleSolenoid Doors;
	DigitalInput leftButton;
	DigitalInput rightButton;
	DigitalInput PressurePlate;
	int shiftcount;
	boolean shiftCounted = false;
	
	public Doors() {
		rightButton = new  DigitalInput(ActuatorMap.sliderRightPort);
		leftButton = new  DigitalInput(ActuatorMap.sliderLeftPort);
		DoorSlider = new CANTalon(ActuatorMap.gearManipPort);
		Doors = new DoubleSolenoid(ActuatorMap.compressorPort, ActuatorMap.doorForward, ActuatorMap.doorReverse);
	}
	
	public void runDoorsWithoutPercaution(double speed){
		DoorSlider.set(speed);
	}
	
	public void runDoors(double speed){
		if(rightButton.get()){
			if (speed < 0 ){
				DoorSlider.set(speed);
			} else {
				DoorSlider.set(0);
			}
		} else if(leftButton.get()) {
			if (speed > 0 ){
				DoorSlider.set(speed);
			} else {
				DoorSlider.set(0);
			}
		} else DoorSlider.set(speed);
	}
	
	public void doorShift(boolean shift, boolean pressuremodeactivate){
		if(!shift){
			shiftCounted = false;
		}
		if(pressuremodeactivate){
			if(PressurePlate.get() && (Doors.get() == ActuatorMap.solenoidReverse || Doors.get() == ActuatorMap.solenoidOff)){
				Doors.set(ActuatorMap.solenoidForward);
			} else {
				if(shift && (Doors.get() == ActuatorMap.solenoidReverse || Doors.get() == ActuatorMap.solenoidOff)) Doors.set(ActuatorMap.solenoidForward);
				else if (!shift && (Doors.get() == ActuatorMap.solenoidForward || Doors.get() == ActuatorMap.solenoidOff)) Doors.set(ActuatorMap.solenoidReverse);
			}
		} else{
			if(shift && (Doors.get() == ActuatorMap.solenoidReverse || Doors.get() == ActuatorMap.solenoidOff)) Doors.set(ActuatorMap.solenoidForward);
			else if (!shift && (Doors.get() == ActuatorMap.solenoidForward || Doors.get() == ActuatorMap.solenoidOff)) Doors.set(ActuatorMap.solenoidReverse);
		}
		if(!shiftCounted && shift){
			shiftCounted = true;
		}
		
		
	}

	public void doorShift(boolean shift){
		if(!shift){
			shiftCounted = false;
		}
		if(!shiftCounted && (shift && (Doors.get() == ActuatorMap.solenoidReverse || Doors.get() == ActuatorMap.solenoidOff))) Doors.set(ActuatorMap.solenoidForward);
		else if (!shiftCounted && (shift && Doors.get() == ActuatorMap.solenoidForward)) Doors.set(ActuatorMap.solenoidReverse);
		
		if(!shiftCounted && shift){
			shiftCounted = true;
		}
	}
	

}
