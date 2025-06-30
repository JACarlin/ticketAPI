/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.model;

/**
 *
 * @author alexc
 */
public class Categoria {
    private int idCategoria;
    private String categoria;
    private String departamento;
    private int responsable;

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public Categoria(int idCategoria, String categoria, String departamento, int responsable) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.departamento = departamento;
        this.responsable = responsable;
    }
    public Categoria(){
        
    }
}
