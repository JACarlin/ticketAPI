/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.controller;

import org.lasalle.services.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author alexc
 */
public class ControllerCategoria {
    public  Categoria saveCategoria(Categoria c){
        String query = "INSERT INTO categoria VALUES (0,?,?,?)";
        try{
            ConnectionMysql connMysql = new ConnectionMysql();
            Connection  conn  = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, c.getCategoria());
            pstm.setString(2, c.getDepartamento());
            pstm.setInt(3, c.getResponsable());
            pstm.execute();
            System.out.println("Registro generado");
            connMysql.close();
        }catch(Exception e){
            
        }
        
        return c;
        
    }
}
