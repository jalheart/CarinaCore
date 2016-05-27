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
public class Pattern extends RootElement{

    public Pattern() {
    }
    public Pattern(Object pattern) {
        this.setPattern(pattern);
    }
    
    private Object pattern;
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the pattern
     */
    public Object getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(Object pattern) {
        this.pattern = pattern;
    }
    // </editor-fold>
}