package org.usfirst.frc.team2169.robot.Subsystems;
import org.usfirst.frc.team2169.robot.ActuatorMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Doors extends Subsystem{
	
	DoubleSolenoid Doors;
	
	public Doors() {
		Doors = new DoubleSolenoid(ActuatorMap.doorForward, ActuatorMap.doorReverse);
	}
	
	public void doorShift(boolean shift){
		
		if(shift && Doors.get() == ActuatorMap.solenoidReverse) Doors.set(ActuatorMap.solenoidForward);
		else if (!shift && Doors.get() == ActuatorMap.solenoidForward) Doors.set(ActuatorMap.solenoidReverse);
		
	}
	

}
