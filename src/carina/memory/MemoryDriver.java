/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.memory;

import java.util.List;

/**
 *
 * @author jalheart
 */
abstract public class MemoryDriver{
    private Object config;
    public MemoryDriver(Object config) {
        this.setConfig(config);
    }
    abstract public void storeInformation(BasicMemoryUnity information);
    abstract public BasicMemoryUnity retrieveInformation(String cue);
    abstract public void forgetInformation(String cue);
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the _config
     */
    public Object getConfig() {
        return config;
    }

    /**
     * @param _config the _config to set
     */
    public void setConfig(Object _config) {
        this.config = _config;
    }
    // </editor-fold>
}