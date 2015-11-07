package com.team1285.frc2015.subsystems;

import com.team1285.frc2015.ElectricalConstants;
import com.team1285.frc2015.Robot;
import com.team1285.frc2015.commands.ManualElevator;
import com.team1285.frc2015.pid.PIDController;
import com.team1285.frc2015.utilities.DataOutput;
import com.team1285.frc2015.utilities.MathLogic;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCopy extends Subsystem{

	//Makes an object for the elevator talon
	CANTalon elevatorLeftMotor;
	CANTalon elevatorRightMotor;
	//Make an object for the slowerDown talon
	CANTalon slowMotor;
	
	//Makes an object for the bumper switches on the elevator
	DigitalInput rightBumper; // right tote 
	DigitalInput leftBumper;  // left tote
	DigitalInput elevatorBottomBumper; // bottom limit switch 
	DigitalInput elevatorTopBumper;
	
	//PID Controller
	public PIDController elevPID;
	
	//Makes an object for the encoder on the elevator
	Encoder elevatorEncoder;
	
	public boolean isZeroed = false;
	
	public DataOutput data;
	Timer time;
	public boolean firstRun = true;
	DoubleSolenoid grabberPiston;
	DoubleSolenoid clawPiston;
	
	public ElevatorCopy(){
		elevatorEncoder = new Encoder(ElectricalConstants.COPY_ELEVATOR_ENCODER_A,
									  ElectricalConstants.COPY_ELEVATOR_ENCODER_B,
									  ElectricalConstants.copyElevatorEncoderReverse,
									  Encoder.EncodingType.k4X);
		elevatorEncoder.setDistancePerPulse(ElectricalConstants.elevEncoderDistPerTick);
		
		elevatorRightMotor = new CANTalon(ElectricalConstants.COPY_RIGHT_ELEVATOR_MOTOR);
		elevatorLeftMotor = new CANTalon(ElectricalConstants.COPY_LEFT_ELEVATOR_MOTOR);
		slowMotor = new CANTalon(ElectricalConstants.COPY_CONTAINER_MOTOR);
		
		elevPID = new PIDController(Robot.elevatorP,
									Robot.elevatorI,
									Robot.elevatorD);
		
		time = new Timer();
		data = new DataOutput("output.txt");
		
		grabberPiston = new DoubleSolenoid(ElectricalConstants.PCM,
										   ElectricalConstants.GRABBER_SOLENOID_A,
									       ElectricalConstants.GRABBER_SOLENOID_B);
		clawPiston = new DoubleSolenoid(ElectricalConstants.PCM, 
										ElectricalConstants.CLAW_SOLENOID_A,
										ElectricalConstants.CLAW_SOLENOID_B);
		
		rightBumper = new DigitalInput(ElectricalConstants.COPY_TOOL_RIGHT_BUMPER);
		leftBumper = new DigitalInput(ElectricalConstants.COPY_TOOL_LEFT_BUMPER);
		elevatorBottomBumper = new DigitalInput(ElectricalConstants.COPY_ELEVATOR_BOTTOM_BUMPER);
		elevatorTopBumper = new DigitalInput(ElectricalConstants.COPY_ELEVATOR_TOP_BUMPER);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualElevator());	
	}
	
	public void openGrabberPiston()
	{
		grabberPiston.set(DoubleSolenoid.Value.kForward);	
	}
	public void closeGrabberPiston()
	{
		grabberPiston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void openClawPiston()
	{
		clawPiston.set(DoubleSolenoid.Value.kReverse);	
	}
	public void closeClawPiston()
	{
		clawPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	//Runs the elevator motor at the set value
	public void runElevatorMotor(double value){
		
		elevatorRightMotor.set(-value);
		elevatorLeftMotor.set(value);
		
//		//Bottom Bumper Switch
//		if (getBottomBumper() == false)
//		{
//			resetEncoder();
//			if(value > 0)
//			{
//				elevatorRightMotor.set(-value);
//				elevatorLeftMotor.set(value);
//			}
//			else
//			{
//				elevatorRightMotor.set(0);
//				elevatorLeftMotor.set(0);
//			}
//		}
//		//top bumper switch
//		else if (getTopBumper() == false)
//		{
//			if(value < 0)
//			{
//				elevatorRightMotor.set(-value);
//				elevatorLeftMotor.set(value);
//			}
//			else
//			{
//				elevatorRightMotor.set(0);
//				elevatorLeftMotor.set(0);
//			}
//		}
//		else
//		{
//				elevatorRightMotor.set(-value);
//				elevatorLeftMotor.set(value);
//		}

	}
	
	//Runs the slow motor at the set value
		public void runSlowMotor(double value){
			slowMotor.set(value);
		}
		
	
	public void elevatorSetpoint(double setpoint, double speed)
	{
//		if (firstRun)
//		{
//			time.start();
//			data.writeString("Time, PID, Distance");
//			firstRun = false;
//		}
		elevPID.calcPID(setpoint, getElevatorEncoder());
		double output = elevPID.calcPID(setpoint, getElevatorEncoder());
		
//		if (elevPID.getTimer()>100)
//		{
//			elevPID.resetTimer();
//		}
//		if (elevPID.getTimer()>0.015)
//		{
//			data.writeString(time.get() + ", " + output + ", " + getElevatorEncoder());
//		}
		output = MathLogic.PWMLimit(output, speed);
		SmartDashboard.putNumber("output", output);
		runElevatorMotor(output);
	}
	
	/*
	 * Encoder Functions
	 */
	public double getElevatorEncoder(){
		return elevatorEncoder.getDistance();
	}
	
	public double getElevatorEncoderRaw()
	{
		return elevatorEncoder.getRaw();
	}
	
	public double getElevatorEncoderRate()
	{
		return elevatorEncoder.getRate();
	}
	
	public void resetEncoder(){
		elevatorEncoder.reset();
	}
	
	//Bumper switch functions
	public boolean getBottomBumper(){
		return elevatorBottomBumper.get();
	}
	
	public boolean getTopBumper()
	{
		return elevatorTopBumper.get();
	}
	
	public boolean getRightBumper(){
		return rightBumper.get();
	}
	
	public boolean getLeftBumper(){
		return leftBumper.get();
	}
}
