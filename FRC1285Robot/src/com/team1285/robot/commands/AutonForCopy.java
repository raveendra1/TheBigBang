
package com.team1285.robot.commands;

import com.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class AutonForCopy extends Command {

	double x;
	double y;
	private double timeOut;
    public AutonForCopy(double right, double left, double timeOut) {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.elevator);
        requires(Robot.driveCopy);
        this.timeOut = timeOut;
        x = right;
        y = right;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	Robot.driveCopy.resetEncoders();
	setTimeout(timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveCopy.runRightDrive(-0.6);
	Robot.driveCopy.runLeftDrive(0.6);
	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Robot.driveCopy.getRightDriveEncoder() > x
        		&& Robot.driveCopy.getLeftDriveEncoder() > y) || isTimedOut());

    }

    // Called once after isFinished returns true
    protected void end() {
	Robot.driveCopy.runRightDrive(0);
	Robot.driveCopy.runLeftDrive(0);
	Robot.driveCopy.resetEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

