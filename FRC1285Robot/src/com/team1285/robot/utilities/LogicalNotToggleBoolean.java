/*
 * Boolean that only returns true when going from true to false
 * Boolean is only true once when set true
 * 
 */
package com.team1285.robot.utilities;

/**
 *
 * @author Sagar
 */
public class LogicalNotToggleBoolean {

    boolean state = false;
    boolean oldInput = false;

    public void set(boolean input) {
        if (oldInput == true && input == false) {
            state = true;
        } else {
            state = false;
        }

        oldInput = input;
    }

    public boolean get() {
        return state;
    }
}