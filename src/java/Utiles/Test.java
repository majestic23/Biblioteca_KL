/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Beans.Categoria;
import Beans.Cliente;
import Beans.Libro;
import Beans.Reservacion;
import Beans.Trabajador;
import Beans.Usuario;
import Modelos.Model_Categoria;
import Modelos.Model_Cliente;
import Modelos.Model_Libro;
import Modelos.Model_Reservacion;
import Modelos.Model_Trabajador;
import Modelos.Model_Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author retr0
 */
public class Test {

    /**
     * En esta clase se hacen las pruebas de los respectivos modelos empezando
     * por el modelo de la categoria.
     */
    random r = new random();

    public void categoriaAgregar() {//Test para el Modelo_Categoria::Agregar():

        Categoria categoria1 = new Categoria(1, "Thriller");
        Categoria categoria2 = new Categoria(2, "Accion");
        Categoria categoria3 = new Categoria(3, "Drama");
        Categoria categoria4 = new Categoria(4, "Exotico");
        Model_Categoria mc = new Model_Categoria();
        System.out.println(mc.agregar(categoria2));
        System.out.println(mc.agregar(categoria3));
        System.out.println(mc.agregar(categoria4));
    }

    public void categoriaEditar() {//Test para el Modelo_Categoria::Editar():
        Categoria editado1 = new Categoria();
        int idcategoria = 4;
        String nombre_categoria = "Editado";
        editado1.setIdcategoria(idcategoria);
        editado1.setNombre_categoria(nombre_categoria);
        Model_Categoria mc = new Model_Categoria();
        System.out.println(mc.modificar(editado1));
    }

    public void categoriaListar() {//Test para el Modelo_Categoria::Listar():
        Object[] parametros = {};//Modificar dentro del array (1 parametro = 1 resultado)
        //(0 parametros = Todos los resultados)
        Model_Categoria mc = new Model_Categoria();
        List<Categoria> lista = mc.listar(parametros);
        System.out.println(lista.isEmpty());
        if (lista.size() == 1) {
            System.out.println("ok");
        } else {
            System.out.println("Tiene mas de uno");
        }
    }

    public void categoriaEliminar() {
        Categoria cat = new Categoria(4, "Editado");
        Model_Categoria mc = new Model_Categoria();
        System.out.println(mc.eleminiar(cat));
    }

    /**
     * Pruebas del Modelo_Usuario.
     */
    public void usuarioAgregar() {//Test para el Modelo_Usuario::Agregar():
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("maqc23", "manuel.alejandro.qc@gmail.com", "admin"));
        usuarios.add(new Usuario("mija22", "mijail.22@gmail.com", "123456"));
        usuarios.add(new Usuario("shei24", "itsnotmat@gmail.com", "123456"));
        usuarios.add(new Usuario("monica24", "monica7324@hotmail.com", "123456"));
        Model_Usuario mu = new Model_Usuario();
        usuarios.forEach((usuario) -> {
            System.out.println(mu.agregar(usuario));
        });
    }

    public void usuarioModificar() {//Test para el Modelo_Usuario::Modificar():
        Object[] parametros = {"monica24", "modificada"};
        Model_Usuario mu = new Model_Usuario();
        System.out.println(mu.modificar(parametros));
    }

    public void usuarioListar() {//Test para el Modelo_Usuario::Listar():
        Object[] parametros = {"admin", "admin"};
        Model_Usuario mu = new Model_Usuario();
        List<Usuario> lista = mu.login((String) parametros[0], (String) parametros[1]);
        System.out.println(lista.isEmpty());
        if (lista.size() == 1) {
            System.out.println("Existe un solo usuario en lista");
        } else {
            System.out.println("Existen varios usuarios en lista");
        }
    }

    public void usuarioEliminar() {//Test para el Modelo_Usuario::Eliminar():
        Usuario user = new Usuario("monica24", "monica7324@hotmail.com", "modificada");
        Model_Usuario mu = new Model_Usuario();
        System.out.println(mu.eliminar(user));
    }

    /**
     * Pruebas del Modelo_Trabajador.
     */
    public void trabajadorAgregar() {//Test para el Modelo_Trabajador::Agregar():
        List<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(new Trabajador(1, "Manuel", 71820912, "maqc23"));
        trabajadores.add(new Trabajador(r.getInt(), "Mijail", r.getRandomDni(), "mija22"));
        Model_Trabajador mt = new Model_Trabajador();
        trabajadores.forEach((trabajador) -> {
            System.out.println(mt.agregar(trabajador));
        });
    }

    public void trabajadorModificar() {//Test para el Modelo_Trabajador::Modificar():
        Object[] trabajador = {10028, "Mijail-Editado", 71820913, "mija22", 10028};
        Model_Trabajador mt = new Model_Trabajador();
        System.out.println(mt.modificar(trabajador));
    }

    public void trabajadorListar() {//Test para el Modelo_Trabajador::Listar():
        Object[] parametros = {1};
        Model_Trabajador mt = new Model_Trabajador();
        List<Trabajador> trabajadores = mt.listar(parametros);
        System.out.println(trabajadores.isEmpty());
        if (trabajadores.size() == 1) {
            System.out.println("Existe un solo Trabajador en lista");
        } else {
            System.out.println("Existen varios trabajadores en lista");
        }
    }

    public void trabajador_usuario() {//Test para el Modelo_Trabajador::ListarUsuario():
        Object[] param = {"admin"};
        Model_Trabajador mt = new Model_Trabajador();
        List<Trabajador> trabajador = mt.listarUsu(param);
        System.out.println(trabajador.isEmpty());
        if (trabajador.size() == 1) {
            System.out.println("Existe un solo Trabajador en lista");
        } else {
            System.out.println("Existen varios trabajadores en lista");
        }
    }

    public void trabajadorEliminar() {//Test para el Modelo_Trabajador::Eliminar():
        Trabajador trabajador = new Trabajador(10028);
        Model_Trabajador mt = new Model_Trabajador();
        System.out.println(mt.eliminar(trabajador));
    }

    /**
     * Pruebas del Modelo_Cliente.
     */
    public void clienteAgregar() {//Test para el Modelo_Cliente::Agregar():
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(r.getInt(), "Cliente2 - Mija", "mija22"));
        Model_Cliente mc = new Model_Cliente();
        clientes.forEach((cliente) -> {
            System.out.println(mc.agregar(cliente));
        });
    }

    public void clienteModificar() {//Test para el Modelo_Cliente::Modificar():
        Object[] parametros = {10094, "Cliente1-Sheillah", "shei24"};
        Model_Cliente mc = new Model_Cliente();
        System.out.println(mc.modificar(parametros));
    }

    public void clienteListar() {//Test para el Modelo_Cliente::Listar():
        Object[] parametros = {};
        Model_Cliente mc = new Model_Cliente();
        List<Cliente> clientes = mc.listar(parametros);
        System.out.println(clientes.isEmpty());
        if (clientes.size() == 1) {
            System.out.println("1 cliente en lista");
        } else {
            System.out.println("Varios clientes en lista");
        }
    }

    public void cliente_usuario() {//Test para el Modelo_Cliente::ListarUsuario():
        Object[] parametros = {"shei24"};
        Model_Cliente mc = new Model_Cliente();
        List<Cliente> clientes = mc.listarUsu(parametros);
        System.out.println(clientes.isEmpty());
        if (clientes.size() == 1) {
            System.out.println("1 cliente en lista");
        } else {
            System.out.println("Varios clientes en lista");
        }
    }

    public void clienteEliminar() {//Test para el Modelo_Cliente::Eliminar():
        Cliente cliente = new Cliente(10099);
        Model_Cliente mc = new Model_Cliente();
        System.out.println(mc.eliminar(cliente));
    }

    /**
     * Pruebas del Modelo_Libro.
     */
    public void libroAgregar() {//Test para el Modelo_Libro::Agregar():
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro(r.getInt(), "Libro1", 1));
        libros.add(new Libro(r.getInt(), "Libro2", 1));
        libros.add(new Libro(r.getInt(), "Libro3", 1));
        libros.add(new Libro(r.getInt(), "Libro4", 1));
        libros.add(new Libro(r.getInt(), "Libro5", 1));
        Model_Libro ml = new Model_Libro();
        libros.forEach((libro) -> {
            System.out.println(ml.agregar(libro));
        });
    }

    public void libroModificar() {//Test para el Modelo_Libro::Modificar():
        Libro libro = new Libro(10088, "Libro-Editado", 2);
        Model_Libro ml = new Model_Libro();
        System.out.println(ml.modificar(libro));
    }

    public void libroListar() {//Test para el Modelo_Libro::Listar():
        Object[] parametros = {10088};
        Model_Libro ml = new Model_Libro();
        List<Libro> libros = ml.listar(parametros);
        System.out.println(libros.isEmpty());
        if (libros.size() == 1) {
            System.out.println("1 cliente en lista");
        } else {
            System.out.println("Varios clientes en lista");
        }
    }

    public void libroEliminar() {//Test para el Modelo_Libro::Eliminar():
        Libro libro = new Libro(10088);
        Model_Libro ml = new Model_Libro();
        System.out.println(ml.eliminar(libro));
    }

    /**
     * Pruebas del Modelo_Reservacion
     */
    public void reservacionAgregar() {//Test para el Modelo_Reservacion::Agregar():
        List<Reservacion> reservaciones = new ArrayList<>();
        reservaciones.add(new Reservacion(r.getInt(), "2018-10-04", "2018-11-04", 10031, 10094));
        reservaciones.add(new Reservacion(r.getInt(), "2018-11-01", "", 10004, 10094));
        reservaciones.add(new Reservacion(r.getInt(), "2018-08-04", "2018-08-29", 10018, 10094));
        reservaciones.add(new Reservacion(r.getInt(), "2018-05-02", "2018-08-30", 10054, 10094));
        Model_Reservacion mr = new Model_Reservacion();
        reservaciones.forEach((reservacion) -> {
            System.out.println(mr.agregar(reservacion));
        });
    }

    public void reservacionModificar() {//Test para el Modelo_Reservacion::Modificar():
        List<Reservacion> nuevos = new ArrayList<>();
        nuevos.add(new Reservacion(10040, "2018-11-04"));
        nuevos.add(new Reservacion(10098, "2018-11-07"));
        nuevos.add(new Reservacion(10097, "2018-08-29"));
        Model_Reservacion mr = new Model_Reservacion();
        nuevos.forEach((reservacion) -> {
            System.out.println(mr.modificar(reservacion));
        });
    }

    public void reservacionListar1() {//Test para el Modelo_Reservacion::Listar():
        Object[] parametros = {10056};
        Model_Reservacion mr = new Model_Reservacion();
        List<Reservacion> lista = mr.Listar(parametros);
        System.out.println(lista.isEmpty());
        if (lista.size() == 1) {
            System.out.println("1 elemento en lista");
        } else {
            System.out.println("Varios elementos en lista");
        }
    }

    public void reservacionListar2() {//Test para el Modelo_Reservacion::Listar():
        Object[] parametros = {10054};
        Model_Reservacion mr = new Model_Reservacion();
        List<Reservacion> lista = mr.ListarporLibro(parametros);
        System.out.println(lista.isEmpty());
        if (lista.size() == 1) {
            System.out.println("1 elemento en lista");
        } else {
            System.out.println("Varios elementos en lista");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
//        test.categoriaAgregar();
//        test.categoriaEditar();
//        test.categoriaListar();
//        test.categoriaEliminar();
//        test.usuarioAgregar();
//        test.usuarioModificar();
//        test.usuarioListar();
//        test.usuarioEliminar();
//        test.trabajadorAgregar();
//        test.trabajadorModificar();
//        test.trabajadorListar();
//        test.trabajador_usuario();
//        test.trabajadorEliminar();
//        test.clienteAgregar();
//        test.clienteModificar();
//        test.clienteListar();
//        test.cliente_usuario();
//        test.clienteEliminar();
//        test.libroAgregar();
//        test.libroModificar();
//        test.libroListar();
//        test.libroEliminar();
//        test.reservacionAgregar();
//        test.reservacionModificar();
//       test.reservacionListar1();
//       test.reservacionListar2();
        Object[] parametros = {"shei24", "123456"};
        Model_Usuario mu = new Model_Usuario();
        List<Usuario> lista = mu.login((String) parametros[0], (String) parametros[1]);
        Usuario clienteee = lista.get(0);
        System.out.println(clienteee.toString());
        Object[] parametrosC = {clienteee.getUsername()};
        Model_Cliente mc = new Model_Cliente();
        List<Cliente> c = mc.listarUsu(parametrosC);
        Cliente cliente = c.get(0);
        System.out.println(cliente.toString());
    }

}
