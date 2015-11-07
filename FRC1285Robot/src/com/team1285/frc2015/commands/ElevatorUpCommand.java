package com.team1285.frc2015.commands;

import com.team1285.frc2015.commands.ActuateClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ElevatorUpCommand extends CommandGroup{

	public ElevatorUpCommand(int x){
		if (x==1)
		{
			addSequential(new ActuateClaw(true));
			addSequential(new AutonPause(0.5));
			addSequential(new RunElevator(32,0.9,"up",0.5));
		}
		else
		{
			addSequential(new ActuateClaw(true));
			addSequential(new AutonPause(0.5));
			addSequential(new RunElevator(32,0.9,"up",0.5));
		}
	}
}
