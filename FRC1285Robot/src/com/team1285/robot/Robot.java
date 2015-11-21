
package com.team1285.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.vision.*;

import com.team1285.robot.commands.RunElevator;
import com.team1285.robot.commands.ThreeTote;
import com.team1285.robot.commands.ZeroElevator;
import com.team1285.robot.commands.driveForward;
import com.team1285.robot.commands.noAuto;
import com.team1285.robot.commands.twoBin;
import com.team1285.robot.subsystems.DriveTrain;
import com.team1285.robot.subsystems.ElevatorCopy;
import com.team1285.robot.subsystems.Intake;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

 public static DriveTrain driveCopy;
 public static ElevatorCopy elevatorCopy;
 public static Intake intake;
 public static Constants constant;
 public static OI oi;
 public static USBCamera usbCamera;
 public SendableChooser autoChooser;
 
 //PID
 Preferences pref;
 public static double elevatorP = 0.075;
 public static double elevatorI = 0;
 public static double elevatorD = 0;
 public static double elevatorDownP = 0.09;
 public static double elevatorDownI = 0;
 public static double elevatorDownD = 0;
    Command autonomousCommand;

    Compressor c = new Compressor(ElectricalConstants.PCM);
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {   
     driveCopy = new DriveTrain();
     elevatorCopy = new ElevatorCopy();
     intake = new Intake();
     oi = new OI();
     autoChooser = new SendableChooser();
     autoChooser.addDefault("No Auto", new noAuto(0));
     autoChooser.addObject("Right Autozone", new ThreeTote(1));
     autoChooser.addObject("Left Autozone", new ThreeTote(2));
     autoChooser.addObject("Pick Up Can", new ThreeTote(3));
     c.setClosedLoopControl(true);
     elevatorCopy.openClawPiston();
     resetAllEncoders();
     //usbCamera = new USBCamera("copy");
     updateDashboard();
        
    }
 
    
    public void disabledPeriodic() {
  Scheduler.getInstance().run();
 }

    public void autonomousInit() {
     // instantiate the command used for the autonomous period
        autonomousCommand = (Command) autoChooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
  // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
     driveCopy.runLeftDrive(0);
     driveCopy.runRightDrive(0);
     updateDashboard();
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
     
        if(oi.getPasteRightBumper())
        {
         elevatorCopy.runSlowMotor(0.15);
        }
        else if(oi.getPasteRightTrigger())
        {
         elevatorCopy.runSlowMotor(-0.15);
        }
        else
         elevatorCopy.runSlowMotor(0);
        
        //if(!elevatorCopy.isZeroed)
        	//new ZeroElevator(2);
        //else if(elevatorCopy.isZeroed){
	        oi.elevatorUp();
	        oi.elevatorDrop();
	        //oi.toggleClaw();
	        oi.score();
	        oi.reset();
        //}
	        if(oi.getPasteLeftTrigger())
	        {
	        	elevatorCopy.openClawPiston();
	        }
	        else if (oi.getPasteLeftBumper())
	        {
	        	elevatorCopy.closeClawPiston();
	        }
        
        updateDashboard();
             
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
     * This function is called to reset encoders before use
     */
    public void resetAllEncoders() {
        elevatorCopy.resetEncoder();
        driveCopy.resetEncoders();
    }
    
    public void updateDashboard()
    {
     SmartDashboard.putNumber("Elevator Encoder", Math.round(elevatorCopy.getElevatorEncoder()));
        SmartDashboard.putNumber("Left Drive Encoder", Math.round(driveCopy.getLeftDriveEncoder()));
        SmartDashboard.putNumber("Right Drive Encoder", Math.round(driveCopy.getRightDriveEncoder()));
        SmartDashboard.putBoolean("Top Limit", !elevatorCopy.getTopBumper());
        SmartDashboard.putBoolean("Bottom Limit", !elevatorCopy.getBottomBumper());
        SmartDashboard.putData("Select Auto",autoChooser);
    }
    
}
