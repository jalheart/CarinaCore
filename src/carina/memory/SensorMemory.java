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
public class SensorMemory extends  Memory{
    private static SensorMemory instance;
    private SensorMemory(MemoryDriver driver) {
        super(driver);
    }
    public static void init(MemoryDriver driver){
        if(instance==null){
            instance   =new SensorMemory(driver);
        }
    }
    public static SensorMemory getInstance(){
        return instance;
    }
}