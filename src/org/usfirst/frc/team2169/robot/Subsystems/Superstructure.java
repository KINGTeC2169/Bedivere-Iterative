package org.usfirst.frc.team2169.robot.Subsystems;
import org.usfirst.frc.team2169.robot.ActuatorMap;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Compressor;

public class Superstructure {
	public static AHRS ahrs;
	public Compressor compressor;
	public Superstructure(){
		ahrs = new AHRS(SPI.Port.kMXP, (byte)200);
		ahrs.enableLogging(true);
		compressor = new Compressor(ActuatorMap.compressorPort);
	}

	public void startCompressor(){
		compressor.start();
		
	}
	
}

