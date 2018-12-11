/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Beans.Reservacion;
import DATOS.CADO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Model_Reservacion {

    CADO cado = new CADO();

    public boolean agregar(Object[] parametros) {
        String sql = "INSERT INTO reservacion VALUES (?, ?, ?, ?, ?)";
        return this.cado.Ejecutar(sql, parametros);
    }

    public boolean modificar(Reservacion Reservacion) {
        String sql = "UPDATE reservacion SET fecha_fin= ? WHERE idreservacion=?";
        return this.cado.Ejecutar(sql, Reservacion.getModificar());
    }

    public List listar() {
        ResultSet rs;
        String sql = "SELECT * FROM reservacion";
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }

    public List listarU(int idCliente) {
        ResultSet rs;
        String sql = "SELECT * FROM reservacion WHERE cliente_idcliente="+idCliente;
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }

    public List<Reservacion> list(ResultSet rs) {
        List<Reservacion> Lista = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Reservacion reservacion = new Reservacion(rs);
                Lista.add(reservacion);
            }
            return Lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public List ListarporLibro(Object[] Parametros) {
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM reservacion WHERE libro_idlibro=?";
        rs = this.cado.Recuperar(sql, Parametros);
        List<Reservacion> Lista = new ArrayList<>();

        try {
            rs.beforeFirst();
            while (rs.next()) {
                Reservacion reservacion = new Reservacion(rs);
                Lista.add(reservacion);
            }
            return Lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean eliminar(Reservacion Reservacion) {
        String sql = "DELETE FROM reservacion WHERE idReservacion=" + Reservacion.getIdreservacion();
        return this.cado.Ejecutar(sql);
    }
}
