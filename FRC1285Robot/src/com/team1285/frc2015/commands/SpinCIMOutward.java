package com.team1285.frc2015.commands;

import com.team1285.frc2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinCIMOutward extends Command {

	public SpinCIMOutward(){
		requires(Robot.intake);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.intake.spinCIMOutward();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
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
