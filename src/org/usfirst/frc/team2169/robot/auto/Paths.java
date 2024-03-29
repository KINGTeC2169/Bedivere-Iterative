package org.usfirst.frc.team2169.robot.auto;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Pathfinder;

public class Paths {
	
	 public static Waypoint[] example = new Waypoint[] {
			    new Waypoint(-160, -40, Pathfinder.d2r(-45)),      // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
			    new Waypoint(-80, -80, Pathfinder.d2r(90)),                        // Waypoint @ x=-2, y=-2, exit angle=0 radians
			    new Waypoint(0, 0, 0)                           // Waypoint @ x=0, y=0,   exit angle=0 radians
			};

	 public static Waypoint[] example2 = new Waypoint[] {
			    new Waypoint(0, 0, 0), 
			    new Waypoint(150, 20, 0)
			};
}
