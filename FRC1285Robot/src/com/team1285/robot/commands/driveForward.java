
package com.team1285.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;



/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class driveForward extends CommandGroup {

	public driveForward(){
		fullAuton();
	}
	
	protected void fullAuton()
	{
		//drive forward
		addSequential(new AutonForCopy(30, 30, 2));
	}
	
	
}