package com.team1285.robot.commands;
import com.team1285.robot.Robot;

/**
 * @author Kaveesha
 */
import edu.wpi.first.wpilibj.command.Command;

public class CloseActuator extends Command {

	public CloseActuator(){
		requires(Robot.intake);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.intake.closeActuator();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
