package com.team1285.frc2015.commands;

import com.team1285.frc2015.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class TankDriveCopy extends Command{
	
	public TankDriveCopy() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveCopy);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getCopyRightBumper()){
    		if ((Robot.oi.getCopyLeftY() > 0 && Robot.oi.getCopyRightY() > 0)
        			|| (Robot.oi.getCopyLeftY() < 0 && Robot.oi.getCopyRightY() < 0))
        	{
        		Robot.driveCopy.runLeftDrive(-Robot.oi.getCopyLeftY()*0.4);
        		Robot.driveCopy.runRightDrive(Robot.oi.getCopyRightY()*0.4);
        	}
        	else 
        	{
        		Robot.driveCopy.runLeftDrive(-Robot.oi.getCopyLeftY()*0.4);
        		Robot.driveCopy.runRightDrive(Robot.oi.getCopyRightY()*0.4);
        	}
    	}
    	else{
	    	if ((Robot.oi.getCopyLeftY() > 0 && Robot.oi.getCopyRightY() > 0)
	    			|| (Robot.oi.getCopyLeftY() < 0 && Robot.oi.getCopyRightY() < 0))
	    	{
	    		Robot.driveCopy.runLeftDrive(-Robot.oi.getCopyLeftY()*0.8);
	    		Robot.driveCopy.runRightDrive(Robot.oi.getCopyRightY()*0.8);
	    	}
	    	else 
	    	{
	    		Robot.driveCopy.runLeftDrive(-Robot.oi.getCopyLeftY()*0.8);
	    		Robot.driveCopy.runRightDrive(Robot.oi.getCopyRightY()*0.8);
	    	}
    	}
    	
    	/*if (Robot.oi.getRightJoyStickPush() == true)
    	{
    		Robot.driveCopy.runLeftDrive(-Robot.oi.getCopyLeftY()*0.20);
    		Robot.driveCopy.runLeftDrive(Robot.oi.getCopyLeftY()*0.20);
    	}*/
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
