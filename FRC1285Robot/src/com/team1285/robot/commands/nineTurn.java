
package com.team1285.robot.commands;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class nineTurn extends Command {

	private double timeOut;
	private int side;
	private double distance;
    public nineTurn(double distance, double timeOut, int side) {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.elevator);
        requires(Robot.driveCopy);
        this.timeOut = timeOut;
        this.distance = distance;
        this.side = side;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	Robot.driveCopy.resetEncoders();
	setTimeout(timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(side == 1)//right
    	{
    		Robot.driveCopy.runRightDrive(-0.6);
    		Robot.driveCopy.runLeftDrive(-0.6);
    	}
    	else if (side == 2)//left
    	{
	    	Robot.driveCopy.runRightDrive(0.6);
	    	Robot.driveCopy.runLeftDrive(0.6);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(side == 1)
    		return isTimedOut() || Math.abs(Robot.driveCopy.getRightDriveEncoder()) > distance || Robot.driveCopy.getLeftDriveEncoder() > distance;
    	else
    		return isTimedOut() || Robot.driveCopy.getRightDriveEncoder() > distance || Math.abs(Robot.driveCopy.getLeftDriveEncoder()) > distance;
    }

    // Called once after isFinished returns true
    protected void end() {
	Robot.driveCopy.runRightDrive(0);
	Robot.driveCopy.runLeftDrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

