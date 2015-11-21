//** 
package com.team1285.robot.subsystems;


import com.team1285.robot.ElectricalConstants;
import com.team1285.robot.commands.TankDriveCopy;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;


public class DriveTrain extends Subsystem{

	//Makes objects for the right drive talons
	//Talon rightFront;
	CANTalon rightBack;
	CANTalon rightFront;
	//Makes objects for the left drive talons
	CANTalon leftFront;
	CANTalon leftBack;
	
	//Makes objects for the encoders on one the drive
	Encoder rightEncoder;
	Encoder leftEncoder;
	
	
	
	public DriveTrain(){
		rightEncoder = new Encoder(ElectricalConstants.COPY_RIGHT_ENCODER_A, 
                				   ElectricalConstants.COPY_RIGHT_ENCODER_B, 
                                   ElectricalConstants.rightDriveTrainEncoderReverse, 
                                   Encoder.EncodingType.k4X);
		rightEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);
		leftEncoder = new Encoder(ElectricalConstants.COPY_LEFT_ENCODER_A, 
				   				  ElectricalConstants.COPY_LEFT_ENCODER_B, 
 				                  ElectricalConstants.leftDriveTrainEncoderReverse, 
				                  Encoder.EncodingType.k4X);
		leftEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);
		rightFront = new CANTalon(ElectricalConstants.RIGHT_COPY_DRIVE_FRONT);
		rightBack = new CANTalon(ElectricalConstants.RIGHT_COPY_DRIVE_BACK);
		
		leftFront = new CANTalon(ElectricalConstants.LEFT_COPY_DRIVE_FRONT);
		leftBack = new CANTalon(ElectricalConstants.LEFT_COPY_DRIVE_BACK);
		
		
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDriveCopy());
	}
	
	
	//DRIVE FUNCTIONS
	//Run the right drive at set value
	public void runRightDrive(double value){
		rightFront.set(value);
		rightBack.set(value);
	}
	//Run left drive at set value
	public void runLeftDrive(double value){
		leftFront.set(value);
		leftBack.set(value);
	}
	
	//ENCODER FUNCTIONS
	public double getRightDriveEncoder(){
		return rightEncoder.getDistance();
	}
	
	public double getLeftDriveEncoder(){
		return leftEncoder.getDistance();
	}
	
	public void resetEncoders(){
		rightEncoder.reset();
		leftEncoder.reset();
	}
	
	
}
