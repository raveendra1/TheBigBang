package com.team1285.frc2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StackCommand extends CommandGroup{

 public StackCommand(){
  addSequential(new RunElevator(16,0.75,"down"),1);
  addSequential(new ActuateClaw(false));
  addSequential(new AutonPause(0.25));
  addSequential(new RunElevator(0,0.75,"down"));
 }
}
