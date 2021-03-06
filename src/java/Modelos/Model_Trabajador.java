/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Beans.Trabajador;
import DATOS.CADO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Model_Trabajador {

    CADO cado = new CADO();

    public boolean agregar(Trabajador trabajador) {
        String sql = "INSERT INTO trabajador VALUES(?,?,?,?)";
        return this.cado.Ejecutar(sql, trabajador.getParametros());
    }

    public boolean modificar(Object[] parametros) {
        String sql = "UPDATE trabajador SET  nombre_trabajador=?, dni_trabajador=?, usuario_username=? "
                + "WHERE idTrabajador=?";
        return this.cado.Ejecutar(sql, parametros);
    }

    public List listar(Object[] paramatetros) {
        ResultSet rs;
        String sql;
        if (paramatetros.length == 1) {
            sql = "SELECT * FROM trabajador WHERE idTrabajador=?";
            rs = this.cado.Recuperar(sql, paramatetros);
        } else {
            sql = "SELECT * FROM trabajador";
            rs = this.cado.Recuperar(sql);
        }
        return list(rs);
    }
    public List listarUsu(Object[] parametros) {
        String sql = "SELECT * FROM trabajador WHERE usuario_username=?";
        ResultSet rs = cado.Recuperar(sql, parametros);
        return list(rs);
    }
    public List<Trabajador> list(ResultSet rs) {
        List<Trabajador> lista = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Trabajador trabajador = new Trabajador(rs);
                lista.add(trabajador);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    

    public boolean eliminar(Trabajador trabajador) {
        String sql = "DELETE FROM trabajador WHERE idTrabajador=" + trabajador.getIdtrabajador();
        return this.cado.Ejecutar(sql);
    }
}
