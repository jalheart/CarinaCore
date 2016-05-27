/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

import java.io.Serializable;

/**
 *
 * @author jalheart
 */
public class State extends Element{
    private Boolean _value;
    public State(String name,Boolean value) {
        this.setName(name);
        this.setValue(value);
    }    
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the value
     */
    public Boolean getValue() {
        return _value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Boolean value) {
        this._value = value;
    }
    // </editor-fold>
}