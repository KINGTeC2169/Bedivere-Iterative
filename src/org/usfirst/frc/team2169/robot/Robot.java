package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.Subsystems.DriveTrain;
import org.usfirst.frc.team2169.robot.Subsystems.Doors;
import org.usfirst.frc.team2169.robot.Subsystems.Intakes;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	
	DriveTrain drive;
	ControlMap controls;
	Intakes intakes;
	Doors doors;

	@Override
	public void robotInit() {
		
		try{
			
			intakes = new Intakes();
			drive = new DriveTrain();
			controls = new ControlMap();
			doors = new Doors();
			
		}
		
		catch(Exception e){
			
			DriverStation.reportError(e.toString(), true);
		
		}
		
	
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopPeriodic() {
		
		try{
			intakes.humanPlayerShift(!controls.humanShift(), controls.humanShift());
			intakes.intake(controls.intake());
			
			doors.doorShift(controls.doors());
			
			
			drive.drive(controls.leftThrottle(), controls.rightThrottle());
			drive.shift(controls.lowShift(), controls.highShift());
			
		}
		catch(Exception e){
			
			DriverStation.reportError(e.toString(), true);
			
		}
	}

	@Override
	public void testPeriodic() {
	}
}

