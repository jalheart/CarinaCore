/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

import java.util.Date;

/**
 *
 * @author jalheart
 */
abstract public class FuntionalElement extends RootElement{
    public State state;
    public Date startTime;
    public Date endTime;
    private State effect;
    private State precodition;

    public FuntionalElement() {
        this.setPrecodition(new State("name", Boolean.FALSE));
        this.setEffect(new State("name", Boolean.FALSE));
    }    
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the effect
     */
    public State getEffect() {
        return effect;
    }

    /**
     * @param effect the effect to set
     */
    public void setEffect(State effect) {
        this.effect = effect;
    }

    /**
     * @return the precodition
     */
    public State getPrecodition() {
        return precodition;
    }

    /**
     * @param precodition the precodition to set
     */
    public void setPrecodition(State precodition) {
        this.precodition = precodition;
    }
    // </editor-fold>
}