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
public class Usuario {

    private String username;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(ResultSet rs) {
        try {
            this.username = rs.getString(1);
            this.email = rs.getString(2);
            this.password = rs.getString(3);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setParametros(Object[] parametros) {
        parametros[0] = this.username;
        parametros[1] = this.email;
        parametros[2] = this.password;
    }

    public Object[] getParametros() {
        Object[] parametros = {
            this.username,
            this.email,
            this.password
        };
        return parametros;
    }

    public Object[] getModificar() {
        Object[] parametros = {
            this.password,
            this.username
        };
        return parametros;
    }

    @Override
    public String toString() {
        return "username=" + username + ", email=" + email + ", password=" + password + '}';
    }

}
