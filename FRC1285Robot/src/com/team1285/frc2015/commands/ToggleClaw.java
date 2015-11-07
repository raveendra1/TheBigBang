package com.team1285.frc2015.commands;

import com.team1285.frc2015.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleClaw extends Command{

	boolean toggle = false;
	
	public ToggleClaw(){
		requires(Robot.elevatorCopy);
	}
	
	@Override
	protected void initialize() {
		if(toggle){
			Robot.elevatorCopy.openClawPiston();
			toggle = false;
		}
		else{
			Robot.elevatorCopy.closeClawPiston();
			toggle = true;
		}
		new AutonPause(0.5);
		SmartDashboard.putBoolean("Claw", !toggle);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
