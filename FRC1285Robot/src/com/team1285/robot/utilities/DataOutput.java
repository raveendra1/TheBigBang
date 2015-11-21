package com.team1285.robot.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * https://docs.oracle.com/javase/7/docs/api/java/io/DataOutputStream.html
 * @author Team 1241
 */
public class DataOutput {

    private static int counter = 0;
    public static PrintWriter output;
    /**
     * Creates the log through the class constructor.
     * @param String filePath (the path of the file to be written to)
     */
    public DataOutput(String filePath) {
        
        try 
        {
    		output = new PrintWriter (new FileWriter("/text_files/" + filePath));
        } 
        
        catch (IOException e) 
        {
            System.out.println("Unable to create file");
        }
    }
    
    public void writeStatement(String text, String val)                                                     
    {
    		output.print(text);
            output.print(" = ");
            output.print(val);
            output.println();
    }
    
    public void writeData(double elapsedTime, double leftEnc, double rightEnc, double gyro)
    {
        if(counter == 0)
        {
        	output.print("Time");
            output.print(",");
            output.print("Encoder Distance");
            output.print(",");
            output.print("Rate");
            output.print(",");
            output.println("Angle");
            counter++;
        }
        output.print(elapsedTime);
        output.print(",");
        output.print(leftEnc);
        output.print(",");
        output.print(rightEnc);
        output.print(",");
        output.println(gyro);
    }  
    
    public void writeString(String text)
    {
        output.println(text);
    }
    
    public void close(){
    	output.close();
    }
    
}//end class DataOutput
