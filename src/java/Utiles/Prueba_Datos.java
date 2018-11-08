/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Beans.*;
import DATOS.CADO;
import Modelos.Model_Categoria;
import Modelos.Model_Libro;
import Modelos.Model_Trabajador;
import Modelos.Model_Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manue
 */
public class Prueba_Datos {
    CADO cado = new CADO();
    random r = new random();
    public void volcadoDatos(){
        /**
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "manuel.alejandro.qc@gmail.com", "admin"));
        usuarios.add(new Usuario("mqc22", "mijail@gmail.com", "mija22"));
        usuarios.add(new Usuario("prueba1", "prueba1@bibliotecakl.com", "prueba1"));
        usuarios.add(new Usuario("prueba2", "prueba2@bibliotecakl.com", "prueba3"));
        usuarios.add(new Usuario("prueba3", "prueba3@bibliotecakl.com", "mija22"));
        
        Model_Usuario mu = new Model_Usuario();
        usuarios.forEach((usuario) ->{
            System.out.println(mu.agregar(usuario));
        });
        
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(r.getInt(), "Ciencia Ficcion"));
        categorias.add(new Categoria(r.getInt(), "Terror"));
        categorias.add(new Categoria(r.getInt(), "Drama"));
        categorias.add(new Categoria(r.getInt(), "Adventura"));
        categorias.add(new Categoria(r.getInt(), "Comedia"));
        categorias.add(new Categoria(r.getInt(), "Cultura"));
        categorias.add(new Categoria(r.getInt(), "Exotico"));
        categorias.add(new Categoria(r.getInt(), "Educacion"));
        
        Model_Categoria mc = new Model_Categoria();
        categorias.forEach((categoria) ->{
            System.out.println(mc.agregar(categoria));
        });
        
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro(r.getInt(), "Libro1", 10003));
        libros.add(new Libro(r.getInt(), "Libro2", 10003));
        libros.add(new Libro(r.getInt(), "Libro3", 10003));
        libros.add(new Libro(r.getInt(), "Libro4", 10019));
        libros.add(new Libro(r.getInt(), "Libro5", 10019));
        libros.add(new Libro(r.getInt(), "Libro6", 10019));
        libros.add(new Libro(r.getInt(), "Libro7", 10029));
        libros.add(new Libro(r.getInt(), "Libro8", 10029));
        libros.add(new Libro(r.getInt(), "Libro9", 10029));
        
        Model_Libro ml = new Model_Libro();
        libros.forEach((libro)->{System.out.println(ml.agregar(libro));});
               
        List<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(new Trabajador(1, "Manuel", 71820912, "admin"));
        Model_Trabajador mt = new Model_Trabajador();
        trabajadores.forEach((trabajador)->{System.out.println(mt.agregar(trabajador));});
        */
        
        
    }
    public static void main(String[] args) {
        Prueba_Datos datos = new Prueba_Datos();
        datos.volcadoDatos();
    }
    
}
