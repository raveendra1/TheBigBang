package com.team1285.robot.subsystems;

import com.team1285.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{

	private DoubleSolenoid leftPiston;
	private DoubleSolenoid rightPiston;
	
	private SpeedController leftCIM;
	private SpeedController rightCIM;
	
	public Intake(){
		leftCIM = new CANTalon(ElectricalConstants.LEFT_INTAKE_MOTOR);
		rightCIM = new CANTalon(ElectricalConstants.RIGHT_INTAKE_MOTOR);
		leftPiston = new DoubleSolenoid(ElectricalConstants.LEFT_INTAKE_PISTON_FORWARD, 
				ElectricalConstants.RIGHT_INTAKE_PISTON_FORWARD);
		rightPiston = new DoubleSolenoid(ElectricalConstants.RIGHT_INTAKE_PISTON_FORWARD, 
				ElectricalConstants.RIGHT_INTAKE_PISTON_REVERSE);
	}
	
	public void openActuator(){
		leftPiston.set(DoubleSolenoid.Value.kForward);
		rightPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void closeActuator(){
		leftPiston.set(DoubleSolenoid.Value.kReverse);
		rightPiston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void spinCIMInward(){
		leftCIM.set(1);
		rightCIM.set(-1);
	}
	
	public void spinCIMOutward(){
		leftCIM.set(-1);
		rightCIM.set(1);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
