
package com.team1285.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;



/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class twoBin extends CommandGroup {

	public twoBin(){
		copyAuton();
	}
	
	protected void copyAuton()
	{
		/**
		 * Copy Only
		 */
		//Grabber down
		addSequential(new AutonGrabberDownCopy(1));
				
		//Drive Back
		addSequential(new AutonBackCopy(-20,-20, 1));
				
		//pause
		addSequential(new AutonPause(1));
				
		//drive forward
		addSequential(new AutonForCopy(50, 50, 3));
				
		//Grabber up
		addSequential(new AutonGrabberUpCopy(1));
	}
	
	

}