package com.team1285.robot.commands;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualElevator extends Command{

	public ManualElevator(){
		requires(Robot.elevatorCopy);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if(!Robot.elevatorCopy.getTopBumper()){
			if(-Robot.oi.getPasteRightY() < -0.1)
				Robot.elevatorCopy.runElevatorMotor(-Robot.oi.getPasteRightY());
			else
				Robot.elevatorCopy.runElevatorMotor(0);
		}
		else if(!Robot.elevatorCopy.getBottomBumper()){
			if(-Robot.oi.getPasteRightY() > 0.1)
				Robot.elevatorCopy.runElevatorMotor(-Robot.oi.getPasteRightY());
			else
				Robot.elevatorCopy.runElevatorMotor(0);
		}
		else{
			Robot.elevatorCopy.runElevatorMotor(-Robot.oi.getPasteRightY());
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
