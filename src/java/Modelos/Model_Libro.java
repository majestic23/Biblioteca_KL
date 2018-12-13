/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Beans.Libro;
import DATOS.CADO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Model_Libro {

    CADO cado = new CADO();

    public boolean agregar(Object[] parametros) {
        String sql = "INSERT INTO libro VALUES(?,?,?,?,?)";
        return this.cado.Ejecutar(sql, parametros);
    }

    public boolean modificar(Libro libro) {
        String sql = "UPDATE libro SET nombre_libro = ?, categoria_idcategoria=?"
                + " WHERE idlibro=?";
        return this.cado.Ejecutar(sql, libro.getModificar());
    }

    public List listar() {
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM libro";
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }

    public List buscar(int idcategoria) {
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM libro WHERE categoria_idcategoria=" + idcategoria;
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }

    public boolean inStock(int idlibro) {
        ResultSet rs;
        int stock = 0;
        String sql = "SELECT stock FROM libro WHERE idlibro=" + idlibro;
        rs = this.cado.Recuperar(sql);
        try {
            rs.beforeFirst();
            while (rs.next()) {
                stock = rs.getInt(1);
            }
        } catch (SQLException e) {
            stock = 0;
        }
        return stock != 0;
    }

    public int getStock(int idlibro) {
        ResultSet rs;
        int stock = 0;
        String sql = "SELECT stock FROM libro WHERE idlibro=" + idlibro;
        rs = this.cado.Recuperar(sql);
        try {
            rs.beforeFirst();
            while (rs.next()) {
                stock = rs.getInt(1);
            }
        } catch (SQLException e) {
            stock = 0;
        }
        return stock;
    }

    public List<Libro> list(ResultSet rs) {
        List<Libro> Lista = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Libro libro = new Libro(rs);
                Lista.add(libro);
            }
            return Lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean eliminar(Libro libro) {
        String sql = "DELETE FROM libro WHERE idLibro=" + libro.getIdlibro();
        return this.cado.Ejecutar(sql);
    }
}
