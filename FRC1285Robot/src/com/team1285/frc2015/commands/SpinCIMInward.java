package com.team1285.frc2015.commands;

import com.team1285.frc2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinCIMInward extends Command {

	public SpinCIMInward(){
		requires(Robot.intake);
	}
	@Override
	protected void initialize() {
		Robot.intake.spinCIMInward();
	}

	@Override
	protected void execute() {
				
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
