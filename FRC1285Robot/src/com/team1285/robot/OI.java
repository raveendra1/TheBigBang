//Author: Mahrus Kazi
package com.team1285.robot;

import com.team1285.robot.Robot;
import com.team1285.robot.commands.ActuateClaw;
import com.team1285.robot.commands.AutonPause;
import com.team1285.robot.commands.CloseActuator;
import com.team1285.robot.commands.ElevatorUpCommand;
import com.team1285.robot.commands.OpenActuator;
import com.team1285.robot.commands.RunElevator;
import com.team1285.robot.commands.SpinCIMInward;
import com.team1285.robot.commands.SpinCIMOutward;
import com.team1285.robot.commands.StackCommand;
import com.team1285.robot.commands.ToggleClaw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//http://nwctarobotics.com/javadoc/2013/edu/wpi/first/wpilibj/buttons/Button.html

public class OI{
    
    Joystick copyDrivePad;
    Joystick pasteDrivePad;
    JoystickButton joyButtonA;
    JoystickButton joyButtonY;
    JoystickButton joyButtonB;
    JoystickButton joyButtonX;
    JoystickButton joyBumper;
    JoystickButton joyTrigger;
    public OI()
    {
        copyDrivePad = new Joystick (GamepadConstants.COPY_DRIVE_USB_PORT);
        pasteDrivePad = new Joystick (GamepadConstants.PASTE_DRIVE_USB_PORT);
        joyButtonA = new JoystickButton(pasteDrivePad, GamepadConstants.A_BUTTON);
        joyButtonY = new JoystickButton(pasteDrivePad, GamepadConstants.Y_BUTTON);
        joyButtonX = new JoystickButton(pasteDrivePad, GamepadConstants.X_BUTTON);
        joyButtonB = new JoystickButton(pasteDrivePad, GamepadConstants.B_BUTTON);
        joyBumper = new JoystickButton(pasteDrivePad, GamepadConstants.LEFT_BUMPER);
        joyTrigger = new JoystickButton(pasteDrivePad, GamepadConstants.LEFT_TRIGGER);
    }
    
    public double getCopyRightY ()
    {
        double joy = copyDrivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getPasteRightY ()
    {
        double joy = pasteDrivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getCopyLeftY ()
    {
        double joy = copyDrivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getPasteLeftY ()
    {
        double joy = pasteDrivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_Y);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getCopyRightX()
    {
        double joy = copyDrivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getPasteRightX()
    {
        double joy = pasteDrivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getCopyLeftX()
    {
        double joy = copyDrivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public double getPasteLeftX()
    {
        double joy = pasteDrivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }
    
    public boolean getCopyRightTrigger()
    {
        return copyDrivePad.getRawButton(GamepadConstants.RIGHT_TRIGGER);
    }
    
    public boolean getPasteRightTrigger()
    {
        return pasteDrivePad.getRawButton(GamepadConstants.RIGHT_TRIGGER);
    }
    
    public boolean getCopyLeftTrigger()
    {
        return copyDrivePad.getRawButton(GamepadConstants.LEFT_TRIGGER);
    }
    
    public boolean getPasteLeftTrigger()
    {
        return pasteDrivePad.getRawButton(GamepadConstants.LEFT_TRIGGER);
    }
    
    public boolean getCopyLeftBumper()
    {
        return copyDrivePad.getRawButton(GamepadConstants.LEFT_BUMPER);
    }
    
    public boolean getPasteLeftBumper()
    {
        return pasteDrivePad.getRawButton(GamepadConstants.LEFT_BUMPER);
    }
    
    public boolean getCopyRightBumper()
    {
        return copyDrivePad.getRawButton(GamepadConstants.RIGHT_BUMPER);
    }
    
    public boolean getPasteRightBumper()
    {
        return pasteDrivePad.getRawButton(GamepadConstants.RIGHT_BUMPER);
    }
    
    public boolean getCopyXButton()
    {
     return copyDrivePad.getRawButton(GamepadConstants.X_BUTTON);
    }
    
    public boolean getPasteXButton()
    {
     return pasteDrivePad.getRawButton(GamepadConstants.X_BUTTON);
    }
    
    public boolean getCopyAButton()
    {
     return copyDrivePad.getRawButton(GamepadConstants.A_BUTTON);
    }
    
    public boolean getPasteAButton()
    {
     return pasteDrivePad.getRawButton(GamepadConstants.A_BUTTON);
    }
    
    public boolean getCopyYButton()
    {
     return copyDrivePad.getRawButton(GamepadConstants.Y_BUTTON);
    }
    
    public boolean getPasteYButton()
    {
     return pasteDrivePad.getRawButton(GamepadConstants.Y_BUTTON);
    }
    
    public boolean getCopyBButton()
    {
     return copyDrivePad.getRawButton(GamepadConstants.B_BUTTON);
    }
    
    public boolean getPasteBButton()
    {
     return pasteDrivePad.getRawButton(GamepadConstants.B_BUTTON);
    }
    
    public boolean getRightJoyStickPush()
    {
     return joyButtonA.get();
    }
    
    public void score(){
     joyButtonB.whenPressed(new RunElevator(10,1,"up"));
    }
    
    public void reset(){
      joyButtonX.whenPressed(new RunElevator(0,0.6,"down"));
    }
    
    public void elevatorUp(){
     joyButtonY.whenPressed(new ElevatorUpCommand(2));
    }
    
    public void elevatorDrop(){
     joyButtonA.whenPressed(new StackCommand());
    }
    
    public void closeActuator(){
    	joyButtonB.whenPressed(new CloseActuator());
    }
    
    public void openActuator(){
    	joyButtonY.whenPressed(new OpenActuator());
    }
   
    public void spinCIMOutward(){
    	joyButtonA.whenPressed(new SpinCIMOutward());
    }
    public void spinCIMInward(){
    	joyButtonX.whenPressed(new SpinCIMInward());
    }

    
   /* public void toggleClaw(){
    	//new AutonPause(0.25);
     joyBumper.whenPressed(new ActuateClaw(true));
    }
    
    public void closeClaw()
    {
    	joyTrigger.whenPressed(new ActuateClaw(false));
    }*/
}

