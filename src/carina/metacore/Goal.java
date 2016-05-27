/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

/**
 *
 * @author jalheart
 */
public class Goal extends Element{
    private State currentState;
    private State targetState;
    
    public Goal() {
    }
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the currentState
     */
    public State getCurrentState() {
        return currentState;
    }
    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    /**
     * @return the targetState
     */
    public State getTargetState() {
        return targetState;
    }

    /**
     * @param targetState the targetState to set
     */
    public void setTargetState(State targetState) {
        this.targetState = targetState;
    }
    // </editor-fold>
}