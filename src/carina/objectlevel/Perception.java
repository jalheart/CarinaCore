/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.memory.WorkingMemory;
import carina.metacore.CognitiveFunction;
import java.util.Map;

/**
 *
 * @author jalheart
 */
public class Perception extends CognitiveFunction{
    private BasicCognitiveProcessingUnit perception;
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the perception
     */
    public BasicCognitiveProcessingUnit getPerception() {
        return perception;
    }

    /**
     * @param perception the perception to set
     */
    public void setPerception(BasicCognitiveProcessingUnit perception) {
        this.perception = perception;
    }
    // </editor-fold>

    @Override
    public Object processInformation(Object value) {
        this.processInformation((Map<String,Object>)value);        
        return null;
    }
    public void processInformation(Map<String,Object> value) {
        BasicCognitiveProcessingUnit bcpu   =WorkingMemory.getInstance().getBcpu();
        bcpu.addInput(value.get("information"), (String)value.get("type_sensor"));
        this.setPerception(bcpu);
        WorkingMemory.getInstance().updateMentalState("is_perceived", Boolean.TRUE);
        WorkingMemory.getInstance().setBcpu(bcpu);
    }    
}