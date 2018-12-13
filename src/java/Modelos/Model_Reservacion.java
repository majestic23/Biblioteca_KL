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
    Model_Libro ml = new Model_Libro();

    public boolean agregar(Object[] parametros) {
        int idReservacion = new Model_Reservacion().newIdReservacion();
        if (ml.inStock((int) parametros[2])) {
            if (idReservacion != 0) {
                int nuevoStock = ml.getStock((int) parametros[2]) - 1;
                String sql = "INSERT INTO reservacion VALUES (" + idReservacion + ", ?, ?, ?, ?)";
                String sql2 = "UPDATE libro SET stock=" + nuevoStock + " WHERE idlibro=" + (int) parametros[2];
                if (cado.Ejecutar(sql, parametros) && cado.Ejecutar(sql2)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean modificar(Reservacion Reservacion) {
        String sql = "UPDATE reservacion SET fecha_fin= ? WHERE idreservacion=?";
        return this.cado.Ejecutar(sql, Reservacion.getModificar());
    }

    public int newIdReservacion() {
        ResultSet rs;
        int idReservacion = 0;
        String sql = "SELECT MAX(idreservacion) FROM reservacion";
        rs = cado.Recuperar(sql);
        try {
            rs.beforeFirst();
            while (rs.next()) {
                idReservacion = rs.getInt(1);
            }
        } catch (SQLException e) {
            idReservacion = 0;
        }
        return idReservacion + 1;
    }

    public List listar() {
        ResultSet rs;
        String sql = "SELECT * FROM reservacion ORDER BY idreservacion DESC";
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }

    public List listarU(int idCliente) {
        ResultSet rs;
        String sql = "SELECT * FROM reservacion WHERE cliente_idcliente=" + idCliente;
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
