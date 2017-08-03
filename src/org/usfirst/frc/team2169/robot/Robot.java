package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.Subsystems.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	
	DriveTrain drive;
	ControlMap controls;

	@Override
	public void robotInit() {
		
		try{
			
			drive = new DriveTrain();
			controls = new ControlMap();
			
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

