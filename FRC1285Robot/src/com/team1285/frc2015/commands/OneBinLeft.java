package com.team1285.frc2015.commands;

import com.team1285.frc2015.commands.ActuateClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OneBinLeft extends CommandGroup{

	public OneBinLeft(){
		addSequential(new ActuateClaw(false));
		addSequential(new AutonPause(0.25));
		addSequential(new RunElevator(20,0.9,"up",2));
		addSequential(new nineTurn(20,2,2));
		//addSequential(new AutonForCopy(20,20,2));
	}
}
