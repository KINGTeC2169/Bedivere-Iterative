package org.usfirst.frc.team2169.robot.auto.tasks;

import org.usfirst.frc.team2169.util.PathfinderObject;
import jaci.pathfinder.Waypoint;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class FollowPath extends Command {

	PathfinderObject path;
	
    public FollowPath(Waypoint[] points, CANTalon left_, CANTalon right_, AHRS gyro_, Encoder _leftEnc, Encoder _rightEnc) {
    
    	path = new PathfinderObject(points, left_, right_, gyro_, _leftEnc, _rightEnc);
    	
    	DriverStation.reportWarning("Path Created", false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	path.calculatePath();
    	DriverStation.reportWarning("Path Calculated", false);
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	path.pathfinderLooper();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return path.isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Path Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
