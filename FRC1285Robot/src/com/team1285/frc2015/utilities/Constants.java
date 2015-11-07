/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team1285.frc2015.utilities;

/**
 *
 * @author Team 1241
 * Modified by Mahrus Kazi to work with the roboRIO
 */
import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Constants {
    public static Hashtable constants;
    private static boolean  usingFile;
    public static String filePath;

    public Constants(String file){
        usingFile = true;
        filePath = file;
        this.load();
    }
    
    public void load(){

        constants = getDefaults();
        System.out.println("loading File");

        if(usingFile){
            try {
                System.out.println("creating FileConnection");
                File file = new File("/text_files/" + filePath);
                System.out.println("created FileConnection - Class: ");
                if(file.exists()){
                    System.out.println("FileConnection exists");
                    BufferedReader r = new BufferedReader(new FileReader("/text_files/" + filePath));
                    
                    String line = null;
                    int lineNum = 0;
                    while((line = r.readLine()) != null){
                        lineNum ++;
                        if(line.length() != 0 && line.charAt(0) != '#'){
                            int numSignPos = line.indexOf("#");
                            if(numSignPos > 0){
                                line = line.substring(0, numSignPos);
                            }
                            
                            int equalsSignPos = line.indexOf("=");
                            if(equalsSignPos <= 1){
                                System.out.println("INVALID SETTING LINE: " + line + " (" + lineNum + ")");
                            }else{
                                String key = line.substring(0, equalsSignPos - 1).trim();
                                String value = line.substring(equalsSignPos + 1).trim();
                                
                                if(key.length() > 0 && value.length() > 0){
                                    System.out.println("putting to HashTable: " + key + " = " + value);
                                    constants.put(key, value);
                                }
                            }
                        }

                    }
                }else{
                    PrintWriter output = new PrintWriter (new FileWriter("/text_files/" + filePath));
                    output.close();
                    System.out.println("File has been Created");
                }
            } catch (Exception e) {
                System.out.println("failed to open fileConnection");
            }
        }
        
    }
    
    private Hashtable getDefaults(){
        System.out.println("putting defaults");
        Hashtable defaults = new Hashtable();
        
        System.out.println("defaults put");
        return defaults;
    }
    
    public String getString(String constName, String def) {
        Object val = constants.get(constName);
        //System.out.println("Reading String From Hash: " + val);
        if (val == null){
            //System.out.println("Failed to return constant: " + constName);
            return def;
        }else{
            return (String) val;
        }
    }
    
    public double getDouble (String constName) {
        try {
            double val = Double.parseDouble(getString(constName, ""));
            return val;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int getInteger(String constName) {
        try {
            int val = Integer.parseInt(getString(constName, ""));
            return val;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public long getLong(String constName) {
        try {
            long val = Long.parseLong(getString(constName,""));
            return val;
        } catch(NumberFormatException e){
            return 0;
        }
    }
    
    public boolean getBoolean (String constName) {
        try {
            boolean val = getString(constName, "").toLowerCase().equals("true");
            if(getString(constName, "").toLowerCase().equals("false")){
                return val;
            }else{
                return false;
            }
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
