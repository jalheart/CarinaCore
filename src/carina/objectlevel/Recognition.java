/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.objectlevel;

import carina.memory.BasicMemoryUnity;
import carina.memory.LongTermMemory;
import carina.memory.PerceptualMemory;
import carina.memory.WorkingMemory;
import carina.metacore.CognitiveFunction;
import carina.metacore.ComputationalStrategy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalheart
 */
public class Recognition extends CognitiveFunction{

    @Override
    public Object processInformation(Object value) {
        return this.processInformation((Class<ComputationalStrategy>) value);
    }
    public Boolean processInformation(Class<ComputationalStrategy> value) {
        WorkingMemory workingMemory             =WorkingMemory.getInstance();
        BasicCognitiveProcessingUnit    bcpu    =workingMemory.getBcpu();
        Object information                      =bcpu.getInput().getInformation();
        try {
            
            Constructor<?> constructor  =value.getConstructor(Object.class);
            ComputationalStrategy   algorithmStrategy   =(ComputationalStrategy)constructor.newInstance(((BasicMemoryUnity)information).information);
            Boolean recognition   =(Boolean)algorithmStrategy.run();
            
            Map<String,Object>  data    =new HashMap<>();
            data.put("value", information);
            data.put("recognized", recognition);
            BasicMemoryUnity mi =new BasicMemoryUnity("recognitionData", data);
            PerceptualMemory.getInstance().storeInformation(mi);
            bcpu.addPattern(recognition);
            workingMemory.setBcpu(bcpu);
            return recognition;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Categorization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}