package com.team1285.robot.commands;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ActuateClaw extends Command{

	private boolean open = true;
	
	public ActuateClaw(boolean open){
		this.open = open;
		requires(Robot.elevatorCopy);
	}
	
	@Override
	protected void initialize() {
		if(open)
			Robot.elevatorCopy.openClawPiston();
		else
			Robot.elevatorCopy.closeClawPiston();
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
