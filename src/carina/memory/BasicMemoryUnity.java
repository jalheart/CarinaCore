/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.memory;

import java.io.Serializable;

/**
 *
 * @author jalheart
 */
public class BasicMemoryUnity implements Serializable{
    public String cue;
    public Object information;

    public BasicMemoryUnity(String cue, Object information) {
        this.cue    =cue;
        this.information=information;
    }
}