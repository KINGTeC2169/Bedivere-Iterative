package org.usfirst.frc.team2169.robot;
import org.usfirst.frc.team2169.robot.Subsystems.Superstructure;
import org.usfirst.frc.team2169.robot.Subsystems.DriveTrain;
import org.usfirst.frc.team2169.robot.Subsystems.Doors;
import org.usfirst.frc.team2169.robot.Subsystems.Intakes;
import org.usfirst.frc.team2169.robot.Subsystems.Hanger;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.*;


/*Todo:
 * 
 * make it compile and work on robot
 * 
 * gyro
 * 
 * Auto init and package structure
 * 
 * Auto Commands
 * 
 * Pathfinder
 * 
 * SliderPID 
 * 
 * vision communication
 * 
 */
public class Robot extends IterativeRobot {

	Hanger hanger;
	DriveTrain drive;
	ControlMap controls;
	Intakes intakes;
	Doors doors;
	Superstructure superstructure;

	@Override
	public void robotInit() {
		
		
		try{
			
			hanger = new Hanger();
			superstructure = new Superstructure();
			intakes = new Intakes();
			drive = new DriveTrain();
			controls = new ControlMap();
			doors = new Doors();
			
			superstructure.startCompressor();
			intakes.pancakes(true);
			
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
			
			hanger.go(0.8, controls.hanger());
			
			doors.doorShift(controls.doors());
			doors.runDoors(controls.sliderAxis());
			
			drive.drive(controls.leftThrottle(), controls.rightThrottle());
			drive.shift(controls.lowShift(), controls.highShift());
			
			SmartDashboard.putNumber("chef", controls.leftThrottle());
			SmartDashboard.putNumber("big", controls.rightThrottle());
			
		}
		catch(Exception e){
			
			DriverStation.reportError(e.toString(), true);
			
		}
	}

	@Override
	public void testPeriodic() {
	}
}

