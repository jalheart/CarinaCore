/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.memory;

/**
 *
 * @author jalheart
 */
public class PerceptualMemory extends Memory{    
    private static PerceptualMemory instance =null;    
    public PerceptualMemory(MemoryDriver driver) {
        super(driver);
    }
    public static void init(MemoryDriver driver){
        if(instance==null){
            instance   =new PerceptualMemory(driver);
        }
    }
    public static PerceptualMemory getInstance(){
        return instance;
    }
}