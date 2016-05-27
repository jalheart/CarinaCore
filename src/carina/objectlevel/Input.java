/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.metacore.RootElement;

/**
 *
 * @author jalheart
 */
public class Input extends RootElement{
    private Object information;
    private String type;
    
    public Input() {
        this(null,null);
    }
    public Input(Object information, String type) {
        this.information = information;
        this.type = type;
    }
    
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the information
     */
    public Object getInformation() {
        return information;
    }

    /**
     * @param information the information to set
     */
    public void setInformation(Object information) {
        this.information = information;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    // </editor-fold>
}