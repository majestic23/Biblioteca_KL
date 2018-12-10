/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Beans.Categoria;
import DATOS.CADO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Model_Categoria {

    CADO cado = new CADO();

    public boolean agregar(Categoria categoria) {
        String sql = "INSERT INTO categoria VALUES(?,?)";
        return this.cado.Ejecutar(sql, categoria.getParametros());
    }

    public boolean modificar(Categoria categoria) {
        String sql = "UPDATE categoria set nombre_categoria=? WHERE idcategoria=?";
        return this.cado.Ejecutar(sql, categoria.getModificar());
    }

    public List listar() {
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM categoria";
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }

    public List<Categoria> list(ResultSet rs) {
        List<Categoria> lista = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Categoria categoria = new Categoria(rs);
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean eleminiar(Categoria categoria) {
        String sql = "DELETE FROM categoria WHERE idcategoria=" + categoria.getIdcategoria();
        return this.cado.Ejecutar(sql);
    }

}
