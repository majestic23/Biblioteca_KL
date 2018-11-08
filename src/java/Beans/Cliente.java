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
public class Cliente {

    int idcliente;
    String nombre_cliente;
    String usuario_username;

    public Cliente() {
    }

    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(ResultSet rs) {
        try {
            this.idcliente = rs.getInt(1);
            this.nombre_cliente = rs.getString(2);
            this.usuario_username = rs.getString(3);
        } catch (SQLException e) {
        }
    }

    public Cliente(int idcliente, String nombre_cliente, String usuario_username) {
        this.idcliente = idcliente;
        this.nombre_cliente = nombre_cliente;
        this.usuario_username = usuario_username;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getUsuario_idusuario() {
        return usuario_username;
    }

    public void setUsuario_idusuario(String usuario_username) {
        this.usuario_username = usuario_username;
    }

    public void setParametros(Object[] parametros) {
        parametros[0] = this.idcliente;
        parametros[1] = this.nombre_cliente;
        parametros[2] = this.usuario_username;
    }

    public Object[] getParametros() {
        Object[] parametros = {
            this.idcliente,
            this.nombre_cliente,
            this.usuario_username
        };
        return parametros;
    }
    
    public Object[] getModificar() {
        Object[] parametros = {
            this.nombre_cliente,
            this.usuario_username,
            this.idcliente  
        };
        return parametros;
    }
}
