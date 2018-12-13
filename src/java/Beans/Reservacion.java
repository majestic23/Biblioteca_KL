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
public class Reservacion {

    int idreservacion;
    String fecha_inicio;
    String fecha_fin;
    int estado;
    int libro_idlibro;
    int cliente_idcliente;

    public Reservacion() {
    }

    public Reservacion(int idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Reservacion(int idreservacion, String fecha_fin) {
        this.idreservacion = idreservacion;
        this.fecha_fin = fecha_fin;
    }

    public Reservacion(ResultSet rs) {
        try {
            this.idreservacion = rs.getInt(1);
            this.fecha_inicio = rs.getString(2);
            this.fecha_fin = rs.getString(3);
            this.estado = rs.getInt(4);
            this.libro_idlibro = rs.getInt(5);
            this.cliente_idcliente = rs.getInt(6);
        } catch (SQLException e) {
        }
    }

    public Reservacion(int idreservacion, String fecha_inicio, String fecha_fin, int estado, int libro_idlibro, int cliente_idcliente) {
        this.idreservacion = idreservacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.libro_idlibro = libro_idlibro;
        this.cliente_idcliente = cliente_idcliente;
    }

    public int getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(int idreservacion) {
        this.idreservacion = idreservacion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getLibro_idlibro() {
        return libro_idlibro;
    }

    public void setLibro_idlibro(int libro_idlibro) {
        this.libro_idlibro = libro_idlibro;
    }

    public int getCliente_idcliente() {
        return cliente_idcliente;
    }

    public void setCliente_idcliente(int cliente_idcliente) {
        this.cliente_idcliente = cliente_idcliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setParametros(Object[] parametros) {
        parametros[0] = this.idreservacion;
        parametros[1] = this.fecha_inicio;
        parametros[2] = this.fecha_fin;
        parametros[3] = this.estado;
        parametros[4] = this.libro_idlibro;
        parametros[5] = this.cliente_idcliente;
    }

    public Object[] getParametros() {
        Object[] parametros = {
            this.idreservacion,
            this.fecha_inicio,
            this.fecha_fin,
            this.estado,
            this.libro_idlibro,
            this.cliente_idcliente
        };
        return parametros;
    }

    public Object[] getModificar() {
        Object[] parametros = {
            this.fecha_fin,
            this.idreservacion
        };
        return parametros;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "idreservacion=" + idreservacion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", estado=" + estado + ", libro_idlibro=" + libro_idlibro + ", cliente_idcliente=" + cliente_idcliente + '}';
    }
    
}
