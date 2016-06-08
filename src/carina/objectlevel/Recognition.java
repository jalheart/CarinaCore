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
import java.util.HashMap;
import java.util.List;
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
        Map<String,Input>               inputs  =bcpu.getInputs();
//        Object information                      =bcpu.getInput().getInformation();
        try {
            /*
            Constructor<?> constructor  =value.getConstructor(Object.class);
            ComputationalStrategy   algorithmStrategy   =(ComputationalStrategy)constructor.newInstance(((BasicMemoryUnity)information).information);
            Boolean recognition   =(Boolean)algorithmStrategy.run();
            */
            //TODO Aquí se debe escoger que tipo de reconocimiento se hace depeniento del tipo de sensor o del tipo de dato registrado en el input
            Boolean recognition =checkText();
            Object information;
            Map<String,Object>  data    =new HashMap<>();
            for(String key:inputs.keySet()){
                information =inputs.get(key).getInformation();
                data.put("value", information);
                data.put("recognized", recognition);
            }
            BasicMemoryUnity mi =new BasicMemoryUnity("recognitionData", data);
            PerceptualMemory.getInstance().storeInformation(mi);
            bcpu.addPattern(recognition);
            workingMemory.setBcpu(bcpu);
            return recognition;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(Categorization.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    private Boolean    checkText(){
        WorkingMemory workingMemory             =WorkingMemory.getInstance();
        BasicCognitiveProcessingUnit    bcpu    =workingMemory.getBcpu();
        Map<String,Input>               inputs  =bcpu.getInputs();
//        Object information                      =bcpu.getInput().getInformation();
        
        BasicMemoryUnity    bmu =LongTermMemory.getInstance().retrieveInformation("patterns");
        List<Pattern> patterns  =(List<Pattern>)bmu.information;
        //Se verifica que el valor ingresado corresponda con algun patron
        BasicMemoryUnity information;
        for(String key:inputs.keySet()){
            information =(BasicMemoryUnity)inputs.get(key).getInformation();
            for (Pattern pattern : patterns) {
                if(java.util.regex.Pattern.matches((String)pattern.getPattern(), (String)(information).information))
                    return true;
            }
        }
        return false;
    }
}