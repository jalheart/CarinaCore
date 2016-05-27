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
public class LongTermMemory extends Memory{
    private static LongTermMemory instance =null;
    private LongTermMemory(MemoryDriver driver) {
        super(driver);
    }
    public static void init(MemoryDriver driver){
        if(instance==null){
            instance   =new LongTermMemory(driver);
        }
    }
    public static LongTermMemory getInstance(){
        return instance;
    }
}