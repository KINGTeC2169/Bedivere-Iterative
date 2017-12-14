
package org.usfirst.frc.team2169.robot.auto.tasks;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team2169.pathfinder.PathfinderObject;
import org.usfirst.frc.team2169.pathfinder.Waypoint;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class FollowPath extends Command {
	boolean sepEnc;
	PathfinderObject path;
	CANTalon left;
	CANTalon right;
	AHRS gyro;
	Encoder rightEnc;
	Encoder leftEnc;
	
	
    public FollowPath(Waypoint[] points, CANTalon left_, CANTalon right_, AHRS gyro_) {
    
    	path = new PathfinderObject(points);
    	left = left_;
    	right = right_;
    	gyro = gyro_;
    	
    	DriverStation.reportWarning("Path Created", false);
    }
    public FollowPath(Waypoint[] points, CANTalon left_, CANTalon right_, AHRS gyro_, Encoder leftEncoder, Encoder rightEncoder) {
        sepEnc = true;
        
    	rightEnc = rightEncoder;
    	leftEnc = leftEncoder;
    	path = new PathfinderObject(points, leftEncoder, leftEncoder);
    	left = left_;
    	right = right_;
    	gyro = gyro_;
    	
    	DriverStation.reportWarning("Path Created", false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	path.calculatePath(left, right);
    	DriverStation.reportWarning("Path Calculated", false);
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	path.pathfinderLooper(left, right, gyro);
    	
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
