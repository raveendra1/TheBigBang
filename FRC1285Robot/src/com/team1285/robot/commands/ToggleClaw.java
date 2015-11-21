package com.team1285.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleClaw extends Command{

	boolean toggle = false;
	
	public ToggleClaw(){
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		if(toggle){
			Robot.elevator.openClawPiston();
			toggle = false;
		}
		else{
			Robot.elevator.closeClawPiston();
			toggle = true;
		}
		new AutonPause(0.5);
		SmartDashboard.putBoolean("Claw", !toggle);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
