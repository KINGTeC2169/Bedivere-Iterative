package org.usfirst.frc.team2169.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class ControlMap {

	//Button Numbers
	
		//Primary Left
		
		int brakeLeft = 1;
		int shiftHighLeft = 2;
		int shiftLowLeft = 3;
	
		//Primary Right
	
		int brakeRight = 1;
		int shiftHighRight = 2;
		int shiftLowRight = 3;
		
		//secondary
		int HumanPlayer = 3;
		
	
	
	Joystick primaryLeft;
	Joystick primaryRight;
	Joystick secondary;
	
	public ControlMap(){
		
		primaryLeft = new Joystick(0);
		primaryRight = new Joystick(1);
		secondary = new Joystick(2);

	}
	
	public double leftThrottle(){
		return primaryLeft.getRawAxis(0);
	}
	
	public double rightThrottle(){
		return primaryRight.getRawAxis(0);
	}
	
	public boolean highShift(){
		
		if (primaryLeft.getRawButton(shiftHighLeft) || primaryRight.getRawButton(shiftHighRight)) return true;
		else return false;
	}
	
	public boolean lowShift(){
			
		if (primaryLeft.getRawButton(shiftLowLeft) || primaryRight.getRawButton(shiftLowRight)) return true;		
		else return false;	
	}
	
	public boolean humanShift(){
		return secondary.getRawButton(HumanPlayer);
	}
	
	
	
}
