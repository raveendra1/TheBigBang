/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1285.frc2015;

/**
 *
 * @author Mahrus
 */
public class ElectricalConstants {
    
    //**************************************************************************
    //************************* COPY DRIVE MOTORS ******************************
    //**************************************************************************        

	
    public static final int RIGHT_COPY_DRIVE_FRONT                          = 8; 
    public static final int RIGHT_COPY_DRIVE_BACK                           = 9;
    
    
    public static final int LEFT_COPY_DRIVE_FRONT                           = 0;
    public static final int LEFT_COPY_DRIVE_BACK                            = 1;
    

    
    //**************************************************************************
    //************************** ELEVATOR MOTORS *******************************
    //************************************************************************** 
    
    public static final int COPY_RIGHT_ELEVATOR_MOTOR 						= 7;
    public static final int COPY_LEFT_ELEVATOR_MOTOR                        = 2;
    
    
    //**************************************************************************
    //************************** CONTAINER MOTOR *******************************
    //************************************************************************** 
    
    public static final int COPY_CONTAINER_MOTOR 						   = 3;
    
    //***************************************************************************
    //*************************** Intake Motor **********************************
    //***************************************************************************
     
    public static final int LEFT_INTAKE_MOTOR                              = 11;
    public static final int RIGHT_INTAKE_MOTOR                             = 12;
    
    //**************************************************************************
    //***************************Analog Sensors*********************************
    //**************************************************************************

    public static final int COPY_POT                                        = 0;
    
    //**************************************************************************
    //************************** DRIVE ENCODERS ********************************
    //**************************************************************************
    
    public static final int COPY_RIGHT_ENCODER_A                            = 1;
    public static final int COPY_RIGHT_ENCODER_B                            = 0;
    public static final int COPY_LEFT_ENCODER_A                             = 2;
    public static final int COPY_LEFT_ENCODER_B                             = 3;
    
    
    //**************************************************************************
    //************************ ELEVATOR ENCODERS *******************************
    //**************************************************************************
    
    public static final int COPY_ELEVATOR_ENCODER_A                        = 5;//9
    public static final int COPY_ELEVATOR_ENCODER_B                        = 6;//8
    
    //**************************************************************************
    //**************************Pnumatic Solenoids******************************
    //**************************************************************************
    
    public static final int GRABBER_SOLENOID_A 							   = 5;//4
    public static final int GRABBER_SOLENOID_B 							   = 6;//7
    public static final int CLAW_SOLENOID_A 					  		   = 1;//7
    public static final int CLAW_SOLENOID_B 					   		   = 0;//4
    
    public static final int PCM 										   = 11;
    
    //**************************************************************************
    //************************ Intake Pistons **********************************
    //**************************************************************************
    
    public static final int LEFT_INTAKE_PISTON_FORWARD                     = 13; 
    public static final int LEFT_INTAKE_PISTON_REVERSE                     = 14;
    public static final int RIGHT_INTAKE_PISTON_FORWARD                    = 15;
    public static final int RIGHT_INTAKE_PISTON_REVERSE                    = 16;

    
    //**************************************************************************
    //*************************** Digital Sensors ******************************
    //**************************************************************************
    
    public static final int COPY_TOOL_RIGHT_BUMPER                         = 9;
    public static final int COPY_TOOL_LEFT_BUMPER                          = 8;
    
    public static final int COPY_ELEVATOR_BOTTOM_BUMPER                    = 4;
    public static final int COPY_ELEVATOR_TOP_BUMPER					   = 7;//6
    
    //********************** DRIVE ENCODER CONSTANTS ***************************
    public static final int driveWheelRadius = 3;//wheel radius in inches
    public static final int pulsePerRotation = 128; //encoder pulse per rotation
    public static final double gearRatio = 1/1; //ratio between wheel and encoder
    public static final double driveEncoderPulsePerRot = pulsePerRotation*gearRatio; //pulse per rotation * gear ratio
    public static final double driveEncoderDistPerTick =(Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
    public static final boolean rightDriveTrainEncoderReverse = false; 
    public static final boolean leftDriveTrainEncoderReverse = false; 
    
    //******************** ELEVATOR ENCODER CONSTANTS ***************************
    public static final double elevatorPullyRadius = 0.69;//wheel radius in inches
    public static final int elevPulsePerRotation = 128; //encoder pulse per rotation
    public static final double elevGearRatio = 1/1; //ratio between wheel and encoder
    public static final double elevEncoderPulsePerRot = elevPulsePerRotation*elevGearRatio; //pulse per rotation * gear ratio
    public static final double elevEncoderDistPerTick =(Math.PI*2*elevatorPullyRadius)/elevPulsePerRotation;
    public static final boolean copyElevatorEncoderReverse = false; 
    public static final boolean pasteElevatorEncoderReverse = false; 

   //***************************************************************************
   //*************************** Relays ****************************************
   //***************************************************************************


}
