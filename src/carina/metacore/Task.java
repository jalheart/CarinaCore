/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jalheart
 */
abstract public class Task extends FuntionalElement{    
    private Goal goal;
    protected List<State> effects;
    protected List<State> preconditions;
    protected Boolean _executed     =false;
    protected Boolean _successful   =false;
    protected Boolean _stopPlan     =false;
    public Task() {}    
    abstract public Object run();
    public void buildProfile(){}
    protected void updateTaskState(Boolean executed, Boolean successful, Boolean stopPlan){
        _executed   =executed;
        _successful =successful;
        _stopPlan   =stopPlan;
    }
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the goal
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * @param goal the goal to set
     */
    public void setGoal(Goal goal) {
        this.goal = goal;
    }
    /**
     * @return the _executed
     */
    public Boolean getExecuted() {
        return _executed;
    }

    /**
     * @return the _successful
     */
    public Boolean getSuccessful() {
        return _successful;
    }
    /**
     * @return the _stopPlan
     */
    public Boolean getStopPlan() {
        return _stopPlan;
    }
    /**
     * @return the effects
     */
    public List<State> getEffects() {
        return effects;
    }

    /**
     * @param effects the effects to set
     */
    public void setEffects(List<State> effects) {
        this.effects = effects;
    }

    /**
     * @return the preconditions
     */
    public List<State> getPreconditions() {
        return preconditions;
    }

    /**
     * @param preconditions the preconditions to set
     */
    public void setPreconditions(List<State> preconditions) {
        this.preconditions = preconditions;
    }
    public void addEffect(State effect){
        if(this.effects==null)this.effects   =new ArrayList<>();
        this.effects.add(effect);
    }
    public void addPrecondition(State effect){
        if(this.preconditions==null)this.preconditions   =new ArrayList<>();
        this.preconditions.add(effect);
    }
    /**
     * Devuelve un efecto de la tarea basado en su posición dentro de la lista
     * @param pos 
     * @return State
     */
    public State getEffect(int pos){
        if(this.effects==null || this.effects.size()<=pos)return null;
        return this.effects.get(pos);
    }
    /**
     * Devuelve una precondicón de la tarea basado en su posición dentro de la lista
     * @param pos
     * @return State
     */
    public State getPrecondition(int pos){
        if(this.preconditions==null || this.preconditions.size()<=pos)return null;
        return this.preconditions.get(pos);
    }
    /**
     * Devuelve una precondición de la tarea basado en su nombre
     * @param name
     * @return State
     */
    public State getPrecondition(String name){        
        for (State stateTmp : this.preconditions) {
            if(stateTmp.getName().equals(name))return state;
        }
        return null;
    }
    /**
     * Devuelve un efecto de la tarea basado en su nombre
     * @param name
     * @return State
     */
    public State getEffect(String name){        
        for (State stateTmp : this.effects) {
            if(stateTmp.getName().equals(name))return state;
        }
        return null;
    }    
    // </editor-fold>
}