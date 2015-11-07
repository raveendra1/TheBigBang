
package com.team1285.frc2015.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.team1285.frc2015.Robot;

/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class AutonGrabberDownCopy extends Command {

	private double timeOut;
    public AutonGrabberDownCopy(double timeOut) {
        // Use requires() here to declare subsystem dependencies
        
        requires(Robot.elevatorCopy);
        requires(Robot.driveCopy);
        this.timeOut = timeOut;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	setTimeout(timeOut);
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevatorCopy.openGrabberPiston();
	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (isTimedOut());

    }

    // Called once after isFinished returns true
    protected void end() {
	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

