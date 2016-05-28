/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

import carina.memory.SensorMemory;

/**
 *
 * @author jalheart
 */
abstract public class Sensor extends RootElement{
    private String type;
    private final SensorMemory sensorMemory;
    public Sensor() {
        this.sensorMemory   =SensorMemory.getInstance();
    }    
    public Object perceiveInformation(Object value){
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
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
    /**
     * @return the sensorMemory
     */
    public SensorMemory getSensorMemory() {
        return sensorMemory;
    }
    // </editor-fold>
}