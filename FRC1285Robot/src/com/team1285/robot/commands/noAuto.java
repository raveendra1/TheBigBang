

package com.team1285.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class noAuto extends Command {

	private double timeOut;
    public noAuto(double timeOut) {
        // Use requires() here to declare subsystem dependencies
        this.timeOut = timeOut;
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeOut);
	
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
	
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

