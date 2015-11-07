/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package com.team1285.frc2015.utilities;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables2.type.StringArray;
import edu.wpi.first.wpilibj.tables.ITable;
import java.util.Vector;

/**
 * The {@link SendableChooser} class is a useful tool for presenting a selection
 * of options to the {@link SmartDashboard}.
 *
 * <p>For instance, you may wish to be able to select between multiple
 * autonomous modes. You can do this by putting every possible {@link Command}
 * you want to run as an autonomous into a {@link SendableChooser} and then put
 * it into the {@link SmartDashboard} to have a list of options appear on the
 * laptop. Once autonomous starts, simply ask the {@link SendableChooser} what
 * the selected value is.</p>
 *
 * @author Joe Grinstead
 */
public class SendableChooser implements Sendable {

    /**
     * The key for the default value
     */
    private static final String DEFAULT = "default";
    /**
     * The key for the selected option
     */
    private static final String SELECTED = "selected";
    /**
     * The key for the option array
     */
    private static final String OPTIONS = "options";
    /**
     * A table linking strings to the objects the represent
     */
    private StringArray choices = new StringArray();
    private Vector values = new Vector();
    private String defaultChoice = null;
    private int defaultValue = 1;

    /**
     * Instantiates a {@link SendableChooser}.
     */
    public SendableChooser() {
    }

    /**
     * Adds the given integer to the list of options. On the
     * {@link SmartDashboard} on the desktop, the integer will appear as the
     * given name.
     *
     * @param name the name of the option
     * @param integer the option
     */
    public void addInteger(String name, int integer) {
        //if we don't have a default, set the default automatically
        if (defaultChoice == null) {
            addDefault(name, integer);
            return;
        }
        for (int i = 0; i < choices.size(); ++i) {
            if (choices.get(i).equals(name)) {
                choices.set(i, name);
                values.setElementAt(new Integer(integer), i);
                return;
            }
        }
        //not found
        choices.add(name);
        values.addElement(new Integer(integer));
        if (table != null) {
            table.putValue(OPTIONS, choices);
        }
    }

    /**
     * Add the given integer to the list of options and marks it as the default.
     * Functionally, this is very close to
     * {@link SendableChooser#addObject(java.lang.String, java.lang.Object) addObject(...)}
     * except that it will use this as the default option if none other is
     * explicitly selected.
     *
     * @param name the name of the option
     * @param integer the option
     */
    public void addDefault(String name, int integer) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        defaultChoice = name;
        defaultValue = integer;
        if (table != null) {
            table.putString(DEFAULT, defaultChoice);
        }
        addInteger(name, integer);
    }

    /**
     * Returns the selected option. If there is none selected, it will return
     * the default. If there is none selected and no default, then it will
     * return {@code null}.
     *
     * @return the option selected
     */
    public int getSelected() {
        String selected = table.getString(SELECTED, null);
        for (int i = 0; i < values.size(); ++i) {
            if (choices.get(i).equals(selected)) {
                return ((Integer)values.elementAt(i)).intValue();
            }
        }
        return defaultValue;

    }
    

    public String getSmartDashboardType() {
        return "String Chooser";
    }
    private ITable table;

    public void initTable(ITable table) {
        this.table = table;
        if (table != null) {
            table.putValue(OPTIONS, choices);
            if (defaultChoice != null) {
                table.putString(DEFAULT, defaultChoice);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public ITable getTable() {
        return table;
    }
}
