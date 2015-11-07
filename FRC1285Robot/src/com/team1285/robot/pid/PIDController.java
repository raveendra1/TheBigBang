/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1285.robot.pid;

import edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author Team 1241
 * Simple PID Controller that assumes regular loop intervals 
 */
public class PIDController {
    double pGain;
    double iGain;
    double dGain;
    
    double pOut;
    double iOut;
    double dOut;
    
    double error;
    double output = 0;
    double integral = 0;
    double lastError = 0;
    double derivative = 0;
    double prevIntegral = 0;
    double deltaT = 0.05;
    
    Timer timer;
    boolean firstRun = true;
    
    public PIDController(double p, double i, double d) {   
    	integral = 0;       //initialize errorSum to 0
        lastError = 0;      //initialize lastError to 0 
        pGain = p;
        iGain = i;
        dGain = d;
        timer = new Timer();
    }
            
    public void resetIntegral() {
    	integral = 0.0;
    }
    
    public void resetDerivative() {
       lastError = 0.0;
    }
    
    public void resetPID(){
    	stopTimer();
    	resetIntegral();
    	resetDerivative();
    }
    
    public void changePIDGains(double kP, double kI, double kD) {
        pGain = kP;
        iGain = kI;
        dGain = kD;
    }
    
    public void resetTimer(){
    	timer.reset();
    }
    
    public void stopTimer(){
    	firstRun = true;
    	timer.stop();
    }
    
    public double getTimer(){
    	return timer.get();
    }
    
    public double dOut(){
    	return dOut;
    }
    
    public double pOut(){
    	return pOut;
    }
    
    public double calcPID(double setPoint, double currentValue) {
    	if(firstRun){
    		timer.start();
    		error = setPoint - currentValue;
	        pOut = pGain * error;
	        output = pOut;
    		firstRun = false;
    	}
    	
    	if(timer.get() >= deltaT){
	        error = setPoint - currentValue;
	        pOut = pGain * error;
	        
	        integral = (error * deltaT);
	        iOut = iGain * (integral + prevIntegral);
	        prevIntegral = integral;
	        
	        if(lastError != 0){
	        	derivative = (error - lastError);
	        	dOut = dGain * derivative;
	        }
	        
	        lastError = error;
	        output = pOut + iOut + dOut;
	        timer.reset();
    	}
    	
        return output;
    }
}
