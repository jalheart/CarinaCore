/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.metacore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jalheart
 */
public class ReasoningTaskProfile extends Profile{
    private List<Field> fields;
    public ReasoningTaskProfile(Field[] pFields) {
        fields  =new ArrayList<>();
        for (Field field : fields) {            
            this.setField(field.getName(), field.getValue());
        }
    }
    public void setField(String name, Object value){
        this.fields.add(new Field(name, value));
    }
}