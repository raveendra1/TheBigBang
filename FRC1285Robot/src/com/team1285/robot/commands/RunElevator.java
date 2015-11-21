

package com.team1285.robot.commands;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class RunElevator extends Command {

	private double setpoint;
	private double speed;
	private String direction;
	private double timeOut = 0;
	boolean isTimeoutSet;
    public RunElevator(double setpoint, double speed, String direction) {
        // Use requires() here to declare subsystem dependencies
        this.setpoint = setpoint;
        this.speed = speed;
        this.direction = direction;
        isTimeoutSet = false;
        requires(Robot.elevator);
        
    }
    public RunElevator(double setpoint, double speed, String direction, double timeOut) {
        // Use requires() here to declare subsystem dependencies
        this.setpoint = setpoint;
        this.speed = speed;
        this.direction = direction;
        this.timeOut = timeOut;
        //isTimeoutSet = true;
        requires(Robot.elevator);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeOut);
    	Robot.elevator.elevPID.resetPID();
    	if (direction.equalsIgnoreCase("up"))
    	{
    		Robot.elevator.elevPID.changePIDGains(Robot.elevatorP,
    												  Robot.elevatorI,
    												  Robot.elevatorD);
    	}
    	else if(direction.equalsIgnoreCase("down"))
    	{
    		Robot.elevator.elevPID.changePIDGains(Robot.elevatorDownP,
					  								  Robot.elevatorDownI,
					  								  Robot.elevatorDownD);
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.elevatorSetpoint(setpoint, speed);
	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(direction.equalsIgnoreCase("up"))
    		return !Robot.elevator.getTopBumper() || Math.abs(Robot.oi.getPasteRightY()) > 0.1 || Robot.elevator.getElevatorEncoder() >= (setpoint-2);
    	else if (isTimedOut())
    		return true;
     	else 
    		return !Robot.elevator.getBottomBumper() || Math.abs(Robot.oi.getPasteRightY()) > 0.1;

    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.runElevatorMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

