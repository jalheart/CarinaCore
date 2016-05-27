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
public class Category extends RootElement{
    private Object category;
    public Category() {
        this(null);
    }
    public Category(Object category) {
        this.category = category;
    }
    
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the category
     */
    public Object getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Object category) {
        this.category = category;
    }
    // </editor-fold>
}