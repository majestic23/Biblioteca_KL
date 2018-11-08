/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author retr0
 */
public class Categoria {
    int idcategoria;
    String nombre_categoria;

    public Categoria() {
    }

    public Categoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Categoria(int idcategoria, String nombre_categoria) {
        this.idcategoria = idcategoria;
        this.nombre_categoria = nombre_categoria;
    }
    public Categoria(ResultSet rs){
        try {
            this.idcategoria=rs.getInt(1);
            this.nombre_categoria = rs.getString(2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    public void setParametros(Object[] parametros){
        parametros[0]= this.idcategoria;
        parametros[1]= this.nombre_categoria;
    }
    
    public Object[] getParametros(){
        Object[] parametros = {
            this.idcategoria,
            this.nombre_categoria
        };
        return parametros;
    }
    public Object[] getModificar(){
        Object[] parametros = {
            this.nombre_categoria,
            this.idcategoria
        };
        return parametros;
    }
    
    
}
