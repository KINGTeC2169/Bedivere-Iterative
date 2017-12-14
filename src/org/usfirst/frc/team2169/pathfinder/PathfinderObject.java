package org.usfirst.frc.team2169.pathfinder;
import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team2169.pathfinder.Pathfinder;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2169.pathfinder.Trajectory;
import org.usfirst.frc.team2169.pathfinder.Waypoint;
import org.usfirst.frc.team2169.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team2169.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team2169.robot.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.interfaces.Gyro;

public class PathfinderObject {
	
	//Waypoints go here
	Waypoint[] points;
	Encoder leftEnc;
	Encoder rightEnc;
	public boolean isFinished = false;
	boolean usingEnc = false;
	
	public PathfinderObject(Waypoint[] importedPoints){
		points = importedPoints;
	}
	public PathfinderObject(Waypoint[] importedPoints, Encoder left, Encoder right){
		points = importedPoints;
		leftEnc = left;
		rightEnc = right;
		usingEnc = true;
	} 
	
	EncoderFollower leftFollower;
	EncoderFollower rightFollower;
	
	public void calculatePath(CANTalon leftTalon, CANTalon rightTalon) {
	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
			Constants.timeStep, Constants.maxVelocity, Constants.maxAcceleration, Constants.maxJerk);

	// Generate the trajectory
	Trajectory trajectory = Pathfinder.generate(points, config);

	// Create the Modifier Object
	TankModifier modifier = new TankModifier(trajectory);

	// Generate the Left and Right trajectories using the original trajectory
	// as the centre
	modifier.modify(Constants.wheelBaseWidth);
	Trajectory left  = modifier.getLeftTrajectory();
	Trajectory right = modifier.getRightTrajectory();
	
	
	//Make Encoder Followers
	leftFollower = new EncoderFollower(left);
	rightFollower = new EncoderFollower(right);
	
	leftFollower.configureEncoder(leftTalon.getEncPosition(), Constants.ticksPerRotation, Constants.wheelDiameter);
	rightFollower.configureEncoder(rightTalon.getEncPosition(), Constants.ticksPerRotation, Constants.wheelDiameter);
	
	//Configure Pathfinder PID
	leftFollower.configurePIDVA(Constants.pathfinderP, Constants.pathfinderI, Constants.pathfinderD, Constants.pathfinderVR / Constants.maxVelocity, Constants.accelerationGain);
	
	
	}
	
	public void pathfinderLooper(CANTalon leftTalon, CANTalon rightTalon, AHRS gyro) {
		double l;
		double r;
		if (usingEnc){
			l = leftFollower.calculate(leftTalon.getEncPosition());
			r = rightFollower.calculate(rightTalon.getEncPosition());
		} else {
			l = leftFollower.calculate(leftEnc.get());
			r = rightFollower.calculate(rightEnc.get());
		}
		double gyro_heading = gyro.getAngle();    // Assuming the gyro is giving a value in degrees
		double desired_heading = Pathfinder.r2d(leftFollower.getHeading());  // Should also be in degrees

		double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
		double turn = 0.8 * (-1.0/80.0) * angleDifference;

		//If left wheel trajectory isn't finished, set new power.
		if(!leftFollower.isFinished()) {
			leftTalon.set(l + turn);
		}

		//If right wheel trajectory isn't finished, set new power.
		if(!rightFollower.isFinished()) {
			rightTalon.set(r - turn);
		}
		
		//Return if trajectories are both finished
		if(leftFollower.isFinished() && rightFollower.isFinished()) {
			
			isFinished = true;
		
		}
		
		//
		else {
		
			isFinished = false;
		
		}
	}
	
	
}

