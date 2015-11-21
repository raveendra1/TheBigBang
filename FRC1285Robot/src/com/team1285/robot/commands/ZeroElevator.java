package com.team1285.robot.commands;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ZeroElevator extends Command{
 
 private double timeout;
 
 public ZeroElevator(double timeout){
  this.timeout = timeout;
  requires(Robot.elevator);
 }

 @Override
 protected void initialize() {
  setTimeout(timeout);
 }

 @Override
 protected void execute() {
  Robot.elevator.runElevatorMotor(-0.25);
 }

 @Override
 protected boolean isFinished() {
  return !Robot.elevator.getBottomBumper() || isTimedOut();
 }

 @Override
 protected void end() {
  Robot.elevator.runElevatorMotor(0);
  Robot.elevator.isZeroed = true;
  Robot.elevator.resetEncoder();
 }

 @Override
 protected void interrupted() {
  Robot.elevator.runElevatorMotor(0);
  
 }

}
