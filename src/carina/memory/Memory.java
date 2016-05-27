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
abstract public class Memory{
    private MemoryDriver _driver;
    public Memory(MemoryDriver driver){
        this._driver    =driver;
    }
    /**
     * @param information type MemoryInformation
     */
    public void storeInformation(BasicMemoryUnity information){
        this.getDriver().storeInformation(information);
    }
    public BasicMemoryUnity retrieveInformation(String cue){
        return this.getDriver().retrieveInformation(cue);
    }
    public void forgetInformation(String cue){
        this.getDriver().forgetInformation(cue);
    }

    /**
     * @return the _driver
     */
    public MemoryDriver getDriver() {
        return _driver;
    }

    /**
     * @param _driver the _driver to set
     */
    public void setDriver(MemoryDriver _driver) {
        this._driver = _driver;
    }
}