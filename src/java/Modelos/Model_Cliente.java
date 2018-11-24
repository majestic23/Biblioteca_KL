/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Beans.Cliente;
import DATOS.CADO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Model_Cliente {

    CADO cado = new CADO();

    public boolean agregar(Cliente cliente) {
        String sql = "INSERT INTO cliente VALUES (?,?,?)";
        return this.cado.Ejecutar(sql, cliente.getParametros());
    }

    public boolean modificar(Object[] parametros) {
        String sql = "UPDATE cliente SET nombre_cliente=?, usuario_username=? "
                + "WHERE idcliente=?";
        return this.cado.Ejecutar(sql, parametros);
    }
    
    public List lista(){
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM cliente";
        rs = this.cado.Recuperar(sql);

        return list(rs);
    }
    public List listar(Object[] Parametros) {
        ResultSet rs;
        String sql;
        sql = "SELECT * FROM cliente WHERE idcliente=?";
        rs = this.cado.Recuperar(sql, Parametros);

        return list(rs);
    }

    public List listarUsu(Object[] parametros) {
        String sql = "SELECT * FROM cliente WHERE usuario_username=?";
        ResultSet rs = cado.Recuperar(sql, parametros);
        return list(rs);
    }

    public List<Cliente> list(ResultSet rs) {
        List<Cliente> Lista = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs);
                Lista.add(cliente);
            }
            return Lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean eliminar(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE idcliente=" + cliente.getIdcliente();
        return this.cado.Ejecutar(sql);
    }
    
    public static void main(String[] args) {
        Model_Cliente mc = new Model_Cliente();
        List<Cliente> listaa = mc.lista();
        if (!listaa.isEmpty()) {
            System.out.println("Tiene valores!");
            if (listaa.size()==1) {
                System.out.println("Solo tiene 1 elemento (Cliente Sheillah)");
            }else{
                System.out.println("De donde putas habrá salido el otro elemento xd");
            }
        }else{
            System.out.println("No devuelve nada... Revisar el sql !!");
        }
    }
}
