
package com.team1285.frc2015.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;



/**
 * @author James Taylor
 * auto class for 1285 2015
 */
public class ThreeTote extends CommandGroup {

	public ThreeTote(int side){
		
		//since claw closes at start just lift elevator up
		addSequential(new ElevatorUpCommand(1));
		if(side != 3)
		{
			if(side == 1)
			{
				//turn right 
				addSequential(new TurnRight(0,0));
			}
			else if (side == 2)
			{
				//turn Left 
				addSequential(new TurnLeft(0,0));
			}
		
			//drive forward a bit
			addSequential(new AutonForCopy(80,80,1.5));
			//addSequential(new AutonPause(2));
		}

			
	}
	

}