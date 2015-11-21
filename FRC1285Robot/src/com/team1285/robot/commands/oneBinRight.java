package com.team1285.robot.commands;

import com.team1285.robot.commands.ActuateClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class oneBinRight extends CommandGroup{

	public oneBinRight(){
		addSequential(new ActuateClaw(false));
		addSequential(new AutonPause(0.25));
		addSequential(new RunElevator(20,0.9,"up"));
		addSequential(new nineTurn(20,0.5,1));
		//addSequential(new AutonForCopy(20,20,2));
	}
}
