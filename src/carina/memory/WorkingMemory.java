/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.memory;

import carina.metacore.Profile;
import carina.metacore.State;
import carina.objectlevel.BasicCognitiveProcessingUnit;
import carina.objectlevel.ModelOfTheWorld;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author jalheart
 */
public class WorkingMemory extends Memory{
    private static WorkingMemory instance;
    private BasicCognitiveProcessingUnit bcpu;
    private ModelOfTheWorld model_of_the_world;
    private List<Profile>   profiles;
    private Map<String,State>     mental_state;    
    private WorkingMemory(MemoryDriver driver) {
        super(driver);
        BasicMemoryUnity memoryTmp  =this.getDriver().retrieveInformation("bcpu");
        if(memoryTmp!=null){
            this.setBcpu((BasicCognitiveProcessingUnit)memoryTmp.information);
        }
        
        memoryTmp  =this.getDriver().retrieveInformation("model_of_the_world");
        if(memoryTmp!=null){
            this.setModel_of_the_world((ModelOfTheWorld) memoryTmp.information);
        }
        
        memoryTmp  =this.getDriver().retrieveInformation("profiles");
        if(memoryTmp!=null){
            for (Profile profile : (List<Profile>) memoryTmp.information) {
                this.setProfiles(profile,true);                
            }
        }
        
        this.mental_state   =new HashMap<>();
        memoryTmp  =this.getDriver().retrieveInformation("mental_state");
        if(memoryTmp!=null){
            for (Map.Entry<String, State> entry : mental_state.entrySet()) {
                this.setMental_state(entry.getValue());
            }
        }
    }    
    public static void init(MemoryDriver driver){
        if(instance==null){
            instance   =new WorkingMemory(driver);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the bcpu
     */
    public BasicCognitiveProcessingUnit getBcpu() {
        return bcpu;
    }

    /**
     * @param bcpu the bcpu to set
     */
    public void setBcpu(BasicCognitiveProcessingUnit bcpu) {
        this.bcpu = bcpu;
        this.syncBCPU(bcpu);
    }
    /**
     * @return the model_of_the_world
     */
    public ModelOfTheWorld getModel_of_the_world() {
        return model_of_the_world;
    }
    /**
     * @param model_of_the_world the model_of_the_world to set
     */
    public void setModel_of_the_world(ModelOfTheWorld model_of_the_world) {        
        this.model_of_the_world = model_of_the_world;
        this.syncModelOfTheWorld(this.model_of_the_world);
    }
    /**
     * @return the profiles
     */
    public Profile getProfiles(int id) {        
        return this.profiles.get(id);
    }

    /**
     * @param profiles the profiles to set
     */
    public void setProfiles(Profile profiles) {
        this.setProfiles(profiles, Boolean.FALSE);
    }
    public void setProfiles(Profile profile,Boolean s) {
        this.profiles.add(profile);
        if(!s){
            this.getDriver().storeInformation(new BasicMemoryUnity("profiles", this.profiles));
        }
    }    

    /**
     * @return the mental_state
     */
    public Map<String,State> getMental_states() {
        return mental_state;
    }
    public State getMental_state(String state) {
        return mental_state.get(state);
    }
    public void updateMentalState(String name,Boolean value){
        State state =this.mental_state.get(name);
        state.setValue(value);
        this.setMental_state(state);
    }
    /**
     * @param mental_state the mental_state to set
     */
    public void setMental_state(State mental_state) {
        this.setMental_state(mental_state, Boolean.FALSE);
    }
    public void setMental_state(State mentalState,Boolean s) {
//        boolean encontrado=false;
//        for (State state: this.mental_state) {
//            if(state.getName().equals(mental_state.getName())){            
//                state.setValue(mental_state.getValue());
//                encontrado=true;
//                break;
//            }
//        }
//        if(!encontrado)
//            this.mental_state.add(mental_state);
        this.mental_state.put(mentalState.getName(), mentalState);
        if(!s){
            this.getDriver().storeInformation(new BasicMemoryUnity("mental_state", this.mental_state));
        }
    }
    /**
     * Accesor para singleton
     * @return WorkingMemory
     */
    public static WorkingMemory getInstance(){
        return instance;
    }
    // </editor-fold>
    
    public void syncBCPU(BasicCognitiveProcessingUnit value){
        this.getDriver().storeInformation(new BasicMemoryUnity("bcpu",value));
    }
    public void syncModelOfTheWorld(ModelOfTheWorld value){
        this.getDriver().storeInformation(new BasicMemoryUnity("model_of_the_world",value));
    }
}