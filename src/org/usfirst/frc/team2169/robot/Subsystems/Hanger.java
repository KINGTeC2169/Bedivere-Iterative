package org.usfirst.frc.team2169.robot.Subsystems;
import com.ctre.CANTalon;
import org.usfirst.frc.team2169.robot.ActuatorMap;


public class Hanger {
	CANTalon hanger;
	
	public Hanger(){
		hanger = new CANTalon(ActuatorMap.hangerPort);
	}
	
	public void go(double speed){
		hanger.set(speed);
	}
	
	public void go(double speed, boolean up){
		if(up){
			hanger.set(speed);
		} else {
			hanger.set(0);
		}
	}
	
	public void go(double speed, boolean up, boolean down){
		if(up && down){
			System.out.println("please dont do that");
		} else if(up){
			hanger.set(speed);
		} else if(down){
			hanger.set(-speed);
		} else {
			hanger.set(0);
		}
		
		
	}
	

}
