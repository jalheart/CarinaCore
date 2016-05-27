/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;
import carina.memory.BasicMemoryUnity;
import carina.memory.WorkingMemory;
import carina.metacore.Goal;
import java.io.Serializable;
/**
 *
 * @author jalheart
 */
abstract public class ModelOfTheWorld implements Serializable{
    private Goal  mission;
    private Boolean is_created      = false;
    public ModelOfTheWorld() {
    }
    abstract public void updateModelOfTheWorld();
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the mission
     */
    public Goal getMission() {
        return mission;
    }
    /**
     * @param mission the mission to set
     */
    public void setMission(Goal mission) {
        this.mission = mission;
    }
    /**
     * @return the is_created
     */
    public Boolean getStateIs_created() {
        BasicMemoryUnity isCreated =WorkingMemory.getInstance().retrieveInformation("is_created");
        return isCreated!=null?(Boolean)isCreated.information:this.is_created;        
    }
    /**
     * @param is_created the is_created to set
     */
    public void setStateIs_created(Boolean is_created) {
        this.is_created = is_created;
    }
    // </editor-fold>    
}