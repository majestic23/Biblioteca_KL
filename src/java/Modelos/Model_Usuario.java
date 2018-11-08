/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Beans.Usuario;
import DATOS.CADO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Model_Usuario {

    CADO cado = new CADO();

    public boolean agregar(Usuario usuario) {
        String sql = "INSERT INTO usuario VALUES(?,?,?)";
        return this.cado.Ejecutar(sql, usuario.getParametros());
    }

    public boolean modificar(Usuario usuario) {
        String sql = "UPDATE usuario SET password=? WHERE username=?";
        return this.cado.Ejecutar(sql, usuario.getModificar());
    }

    public List listar(Object[] parametros) {
        ResultSet rs;
        String sql = "SELECT * FROM usuario";
        if (parametros.length == 2) {
            sql = "SELECT * FROM usuario WHERE username=? AND password=?";
        } else if (parametros.length == 1) {
            sql = "SELECT * FROM usuario WHERE username=?";
        }
        List<Usuario> lista = new ArrayList<>();
        rs = this.cado.Recuperar(sql, parametros);
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                lista.add(usuario);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean eliminar(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE username= '" + usuario.getUsername()+"'";
        return this.cado.Ejecutar(sql);
    }
}
