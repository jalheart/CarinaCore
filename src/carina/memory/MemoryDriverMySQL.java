/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carina.memory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalheart
 */
public class MemoryDriverMySQL extends MemoryDriver{
    private Connection _connection;
    public MemoryDriverMySQL(Object config) {
        super(config);
        conectar();
        crearTabla();
        desconectar();
    }

    @Override
    public void storeInformation(BasicMemoryUnity information) {
        Statement s;
        this.conectar();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(information);
            byte[] informationAsBytes = baos.toByteArray();            
            ByteArrayInputStream bais = new ByteArrayInputStream(informationAsBytes);
    
            PreparedStatement ps =_connection.prepareStatement("insert into "+((Map<String,String>)getConfig()).get("table")+" (cue,data) values(?,?)"
                    + " ON DUPLICATE KEY UPDATE data=?");
            
            ps.setString(1, information.cue);
            ps.setBinaryStream(2, bais,informationAsBytes.length);
            ps.setBinaryStream(3, new ByteArrayInputStream(informationAsBytes),informationAsBytes.length);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );            
        } catch (IOException ex) {
            Logger.getLogger(MemoryDriverMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
    }
    @Override
    public BasicMemoryUnity retrieveInformation(String cue) {
        Object salida   =null;
        this.conectar();
        Statement s;
        try {
            s = _connection.createStatement();
            String sql = "SELECT data FROM "+((Map<String,String>)getConfig()).get("table")+
                        " WHERE cue = '"+cue+"'";
            ResultSet rs= s.executeQuery(sql);
            while (rs.next()) {
                salida  =rs.getObject("data");
            }
            if(salida!=null){
                ByteArrayInputStream baip = new ByteArrayInputStream((byte[]) salida);
                ObjectInputStream ois = new ObjectInputStream(baip);
                salida  =ois.readObject();
            }
            s.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MemoryDriverMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desconectar();
        return (BasicMemoryUnity)salida;
    }

    @Override
    public void forgetInformation(String cue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void crearTabla(){
        Statement s;
        try {
            s = _connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " +((Map<String,String>)this.getConfig()).get("table")+
                    "(cue varchar(50) NOT NULL, " + 
                    " data BLOB     NOT NULL,"+
                    " PRIMARY KEY (cue)) ENGINE=InnoDB DEFAULT CHARSET=utf8";            
            s.executeUpdate(sql);
            s.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );            
        }        
    }
    private void conectar(){
        Map<String,String> confTmp  =(Map<String,String>)getConfig();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            _connection =DriverManager.getConnection("jdbc:mysql://"+confTmp.get("server")+"/"+confTmp.get("db"),confTmp.get("user"), confTmp.get("pass"));            
        } catch (Exception e) {
            System.err.println("Error en bd");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
//            System.exit(0);
        } 
    }
    private void desconectar(){
        try {
            _connection.close();
        } catch (SQLException ex) {
            System.out.println("Error cerrando");            
        }
    }
}