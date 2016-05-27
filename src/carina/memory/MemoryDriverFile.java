/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalheart
 */
public class MemoryDriverFile extends MemoryDriver{
    private String URL;
    public MemoryDriverFile(String type){
        super(type);
        this.URL  ="./memory/"+type+".mem";
        this.createFile();
    }
    @Override
    public void storeInformation(BasicMemoryUnity information) {
        Map<String,BasicMemoryUnity> data =this.getFileData();
        if(data==null){
            data    =new HashMap<>();
        }
        data.put(information.cue, information);
        this.saveFileData(data);
    }
    @Override
    public BasicMemoryUnity retrieveInformation(String cue) {
        Map<String,BasicMemoryUnity> data =(Map<String,BasicMemoryUnity>)this.getFileData();
        return data==null?null:(data.get(cue));
    }
    @Override
    public void forgetInformation(String cue) {
        Map<String,BasicMemoryUnity> data =this.getFileData();
        if(data==null){
            data    =new HashMap<>();
        }
        data.remove(cue);
        this.saveFileData(data);
    }
    private void createFile(){
        try {
            File f=new File(this.URL);
            if(!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }            
        } catch (Exception e) {
        }        
    }
    private void saveFileData(Map<String,BasicMemoryUnity> data){
        try {
            FileOutputStream file;
            ObjectOutputStream objectOut;                        
            file        =new FileOutputStream(URL);
            objectOut   =new ObjectOutputStream(file);
            objectOut.writeObject(data);
            objectOut.flush();
            objectOut.close();
            file.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemoryDriverFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MemoryDriverFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Map<String,BasicMemoryUnity> getFileData(){
        FileInputStream file;
        ObjectInputStream objectIn;
//        Map<String,MemoryInformation> obj  =null;
        Object obj  =null;
        try {            
            file        =new FileInputStream(this.URL);            
            if(file.available()==0)return null;
            objectIn    =new ObjectInputStream(file);
//            obj=(Map<String,MemoryInformation>)objectIn.readObject();
            obj=objectIn.readObject();
            objectIn.close();
            file.close();
        } catch (FileNotFoundException ex) {            
            System.err.println(ex);            
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);            
        }
        return (Map<String,BasicMemoryUnity>)obj;
    }
}