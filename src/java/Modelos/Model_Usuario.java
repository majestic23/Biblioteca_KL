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

    public boolean modificar(Object[] parametros) {
        String sql = "UPDATE usuario SET username=?,email=?, password=? WHERE username=?";
        return this.cado.Ejecutar(sql, parametros);
    }

    public List listar(String username) {
        ResultSet rs;
        String sql = "SELECT * FROM `usuario` WHERE username='"+username+"'";
        rs = this.cado.Recuperar(sql);
        return list(rs);
    }
    public List login(String username, String password){
        ResultSet rs;
        String sql = "SELECT * FROM `usuario` WHERE username=? AND"
                + " password=?";
        Object[] os = {username,password};
        rs = this.cado.Recuperar(sql,os);
        return list(rs);
    }
    public List<Usuario> list(ResultSet rs){
        List<Usuario> lista = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs);//No olvides agregar los rs.
                lista.add(usuario);
            }
        } catch (SQLException e) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    public boolean eliminar(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE username= '" + usuario.getUsername()+"'";
        return this.cado.Ejecutar(sql);
    }
    
    public static void main(String[] args) {
        String usu="admin";
        String contraseña="admin";
        Model_Usuario mu = new Model_Usuario();
        List<Usuario>list = mu.login(usu, contraseña);
        System.out.println(list.get(0).toString());
        
    }
}
