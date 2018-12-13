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
public class Libro {

    int idlibro;
    String nombre_libro;
    int stock;
    String descripcion;
    int categoria_idcategoria;

    public Libro() {
    }

    public Libro(int idlibro) {
        this.idlibro = idlibro;
    }

    public Libro(ResultSet rs) {
        try {
            this.idlibro = rs.getInt(1);
            this.nombre_libro = rs.getString(2);
            this.stock = rs.getInt(3);
            this.descripcion = rs.getString(4);
            this.categoria_idcategoria = rs.getInt(5);
        } catch (SQLException e) {
        }
    }

    public Libro(int idlibro, String nombre_libro, int stock, int categoria_idcategoria) {
        this.idlibro = idlibro;
        this.nombre_libro = nombre_libro;
        this.stock = stock;
        this.categoria_idcategoria = categoria_idcategoria;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public int getCategoria_idcategoria() {
        return categoria_idcategoria;
    }

    public void setCategoria_idcategoria(int categoria_idcategoria) {
        this.categoria_idcategoria = categoria_idcategoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setParametros(Object[] parametros) {
        parametros[0] = this.idlibro;
        parametros[1] = this.nombre_libro;
        parametros[2] = this.stock;
        parametros[3] = this.descripcion;
        parametros[4] = this.categoria_idcategoria;
    }

    public Object[] getParametros() {
        Object[] parametros = {
            this.idlibro,
            this.nombre_libro,
            this.stock,
            this.descripcion,
            this.categoria_idcategoria
        };
        return parametros;
    }

    public Object[] getModificar() {
        Object[] parametros = {
            this.nombre_libro,
            this.categoria_idcategoria,
            this.stock,
            this.descripcion,
            this.idlibro
        };
        return parametros;
    }
}
