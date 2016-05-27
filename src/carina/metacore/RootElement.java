package carina.metacore;

import java.io.Serializable;

abstract public class RootElement implements Serializable{
    private String name;
    private Object output;
    // <editor-fold defaultstate="collapsed" desc="GETs y SETs">
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the output
     */
    public Object getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(Object output) {
        this.output = output;
    }
    // </editor-fold>
}