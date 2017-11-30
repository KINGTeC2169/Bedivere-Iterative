package org.usfirst.frc.team2169.robot.Subsystems;
import org.usfirst.frc.team2169.robot.ActuatorMap;

import edu.wpi.first.wpilibj.Compressor;
public class Superstructure {
	public Compressor compressor;
	public Superstructure(){
		compressor = new Compressor(ActuatorMap.compressorPort);
	}

	public void startCompressor(){
		compressor.start();
		
	}
	
}

