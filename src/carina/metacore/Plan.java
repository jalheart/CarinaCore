/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

import carina.memory.WorkingMemory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jalheart
 */
public class Plan extends Element{
    private List<Task> actions;
    private int currentAction   =0;
    public Plan() {
        actions =new ArrayList<>();
    }
    /**
     * @return Boolean Indica si el plan se ejecutó satisfactoriamente
     */
    public Object executePlan(){
        Task ca;
        if(this.getActions().size()<=0)return null;
        do {
            ca =this.getActions().get(this.getCurrentAction());
            ca.run();
            this.setCurrentAction(this.getCurrentAction()+1);
        } while (this.currentAction<this.getActionsLength() && !ca._stopPlan);
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    public int getActionsLength(){
        return this.actions.size();
    }
    /**
     * @return the actions
     */
    public List<Task> getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(List<Task> actions) {
        this.actions = actions;
    }
    public void setAction(Task action) {
        this.actions.add(action);
    }
    /**
     * @return the currentAction
     */
    public int getCurrentAction() {
        return currentAction;
    }

    /**
     * @param currentAction the currentAction to set
     */
    public void setCurrentAction(int currentAction) {
        this.currentAction = currentAction;
    }
    // </editor-fold>
}