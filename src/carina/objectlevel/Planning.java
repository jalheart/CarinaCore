/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.memory.WorkingMemory;
import carina.metacore.CognitiveFunction;
import carina.metacore.ComputationalStrategy;
import carina.metacore.Plan;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalheart
 */
public class Planning extends CognitiveFunction{
    @Override
    public Object processInformation(Object value) {
        return this.processInformation((Class<ComputationalStrategy>)value);
    }
    public Map<String,Plan> processInformation(Class<ComputationalStrategy> value) {
        BasicCognitiveProcessingUnit bcpu   =WorkingMemory.getInstance().getBcpu();
        List<Category> categories   =bcpu.getCategorys();
        try {
            Constructor<?> constructor  =value.getConstructor(List.class);
            ComputationalStrategy   algorithmStrategy   =(ComputationalStrategy)constructor.newInstance(categories);
            Map<String,Plan> plans   =(Map<String,Plan>)algorithmStrategy.run();            
            bcpu.addPlans(plans);
            WorkingMemory.getInstance().setBcpu(bcpu);
            WorkingMemory.getInstance().updateMentalState("is_planned", (plans !=null && plans.size()>0));
            return plans;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {            
            Logger.getLogger(Categorization.class.getName()).log(Level.SEVERE, null, ex);
            WorkingMemory.getInstance().updateMentalState("is_categorized",false);
            return new HashMap<>();
        }
    }
    public Object executePlans(){
        BasicCognitiveProcessingUnit bcpu   =WorkingMemory.getInstance().getBcpu();
        Map<String,Plan> plans              =bcpu.getPlans();
        List<Category> categories           =bcpu.getCategorys();
        for (Category category : categories) {
            plans.get((String)category.getCategory()).executePlan();
        }
        return null;
    }
}