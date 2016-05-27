/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.memory.WorkingMemory;
import carina.metacore.Strategy;
import java.util.List;

/**
 *
 * @author jalheart
 */
abstract public class ReasoningTask extends CognitiveTask{
    private List<Strategy> strategys;
    @Override
    public void buildProfile(){
        
    }    
    // <editor-fold defaultstate="collapsed" desc="SETs y GETs">
    /**
     * @return the strategys
     */
    public List<Strategy> getStrategys() {
        return strategys;
    }

    /**
     * @param strategys the strategys to set
     */
    public void setStrategys(List<Strategy> strategys) {
        this.strategys = strategys;
    }
    public void addStrategy(Strategy strategy){
        this.strategys.add(strategy);
    }
    public Strategy getStrategy(int pos){
        return pos<this.strategys.size()?this.strategys.get(pos):null;
    }
    // </editor-fold>
}