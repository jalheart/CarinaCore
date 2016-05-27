/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.memory.BasicMemoryUnity;
import carina.memory.LongTermMemory;
import carina.memory.WorkingMemory;
import carina.metacore.CognitiveFunction;
import carina.metacore.ComputationalStrategy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalheart
 */
public class Categorization extends CognitiveFunction{

    @Override
    public Object processInformation(Object value) {
        return this.processInformation((Class<ComputationalStrategy>)value);
    }
    public List<Object> processInformation(Class<ComputationalStrategy> value) {
        WorkingMemory workingMemory             =WorkingMemory.getInstance();
        BasicCognitiveProcessingUnit    bcpu    =workingMemory.getBcpu();
        Object information                      =bcpu.getInput().getInformation();

        List<Category> categories   =this.getCategories();
        try {
            Constructor<?> constructor  =value.getConstructor(List.class);
            ComputationalStrategy   algorithmStrategy   =(ComputationalStrategy)constructor.newInstance(categories);
            List<Object> categorization   =(List<Object>)algorithmStrategy.run();            
            bcpu.addCategories(categorization);
            workingMemory.setBcpu(bcpu);
            workingMemory.updateMentalState("is_categorized", (categorization !=null && categorization.size()>0));
            return categorization;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {            
            Logger.getLogger(Categorization.class.getName()).log(Level.SEVERE, null, ex);
            workingMemory.updateMentalState("is_categorized",false);
            return new ArrayList<>();
        }
    }
    public List<Category>getCategories(){
        BasicMemoryUnity   mem= LongTermMemory.getInstance().retrieveInformation("categories");
        return mem==null?null:(List<Category>)mem.information;
    }
}