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
public class Field extends RootElement{
    private Object value;

    public Field(String name,Object value) {
        this.setName(name);
        this.value = value;
    }
    
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    // </editor-fold>
}