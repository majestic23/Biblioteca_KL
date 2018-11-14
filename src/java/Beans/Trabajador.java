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
public class Trabajador {

    int idtrabajador;
    String nombre_trabajador;
    int dni_trabajador;
    String usuario_username;

    public Trabajador() {
    }

    public Trabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public Trabajador(ResultSet rs) {
        try {
            this.idtrabajador = rs.getInt(1);
            this.nombre_trabajador = rs.getString(2);
            this.dni_trabajador = rs.getInt(3);
            this.usuario_username = rs.getString(4);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Trabajador(int idtrabajador, String nombre_trabajador, int dni_trabajador, String usuario_username) {
        this.idtrabajador = idtrabajador;
        this.nombre_trabajador = nombre_trabajador;
        this.dni_trabajador = dni_trabajador;
        this.usuario_username = usuario_username;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public int getDni_trabajador() {
        return dni_trabajador;
    }

    public void setDni_trabajador(int dni_trabajador) {
        this.dni_trabajador = dni_trabajador;
    }

    public String getusuario_username() {
        return usuario_username;
    }

    public void setusuario_username(String usuario_username) {
        this.usuario_username = usuario_username;
    }

    public void setParametros(Object[] parametros) {
        parametros[0] = this.dni_trabajador;
        parametros[1] = this.nombre_trabajador;
        parametros[2] = this.dni_trabajador;
        parametros[3] = this.usuario_username;
    }

    public Object[] getParametros() {
        Object[] parametros = {
            this.idtrabajador,
            this.nombre_trabajador,
            this.dni_trabajador,
            this.usuario_username
        };
        return parametros;
    }

    public Object[] getModificar() {
        Object[] parametros = {
            this.nombre_trabajador,
            this.dni_trabajador,
            this.usuario_username,
            this.idtrabajador
        };
        return parametros;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idtrabajador=" + idtrabajador + ", nombre_trabajador=" + nombre_trabajador + ", dni_trabajador=" + dni_trabajador + ", usuario_username=" + usuario_username + '}';
    }
    
}
