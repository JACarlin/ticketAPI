/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.lasalle.services.model.Usuario;

/**
 *
 * @author alexc
 */
public class ControllerUsuario {

    public Usuario validarUsuario(String user, String password) {
        String query = "SELECT idUsuario FROM usuario WHERE username = ? AND password = ?";
        Usuario usuario = null;

        try {
            ConnectionMysql connMysql = new ConnectionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, user);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
            }
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Usuario> getAll() {
        List<Usuario> listUsers = new ArrayList<>();
        String query = "Select * from usuario";
        try {
            ConnectionMysql connMysql = new ConnectionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setToken(rs.getString("token"));
                u.setLastConnection(rs.getDate("lastConnection"));
                
                listUsers.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return listUsers;
    }
}
