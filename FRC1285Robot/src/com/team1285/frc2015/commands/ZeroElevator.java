package com.team1285.frc2015.commands;

import com.team1285.frc2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ZeroElevator extends Command{
 
 private double timeout;
 
 public ZeroElevator(double timeout){
  this.timeout = timeout;
  requires(Robot.elevatorCopy);
 }

 @Override
 protected void initialize() {
  setTimeout(timeout);
 }

 @Override
 protected void execute() {
  Robot.elevatorCopy.runElevatorMotor(-0.25);
 }

 @Override
 protected boolean isFinished() {
  return !Robot.elevatorCopy.getBottomBumper() || isTimedOut();
 }

 @Override
 protected void end() {
  Robot.elevatorCopy.runElevatorMotor(0);
  Robot.elevatorCopy.isZeroed = true;
  Robot.elevatorCopy.resetEncoder();
 }

 @Override
 protected void interrupted() {
  Robot.elevatorCopy.runElevatorMotor(0);
  
 }

}
