/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Cliente;
import Beans.Trabajador;
import Beans.Usuario;
import Modelos.Model_Cliente;
import Modelos.Model_Reservacion;
import Modelos.Model_Trabajador;
import Modelos.Model_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            Model_Usuario mu = new Model_Usuario();
            Model_Trabajador mt = new Model_Trabajador();
            Model_Cliente mc = new Model_Cliente();
            Model_Reservacion mr = new Model_Reservacion();
            int opc = Integer.parseInt(request.getParameter("opc"));
            switch (opc) {
                
                case 1://Default para retornar -> index
                    response.sendRedirect("index.jsp");
                    break;
                case 11://Login Proceso de validar usuario
                    String usu = request.getParameter("txtuser");
                    String contraseña = request.getParameter("txtpassword");
                    List<Usuario> usuario = mu.login(usu, contraseña);
                    if (!usu.equals("") && !contraseña.equals("")) {
                        if (usuario.size() == 1) {
                            request.getSession().setAttribute("usuario", (Usuario) usuario.get(0));
                            request.getSession().setAttribute("Validacion", true); //Usas un parametro para la validacion (Es abstracto)
                            response.sendRedirect("Controlador?opc=111");
                        } else {
                            response.sendRedirect("Controlador?opc=1");
                        }
                    } else {
                        response.sendRedirect("Controlador?opc=1");
                    }
                    break;
                case 111://Login Proceso de retornar valores de usuario -> redirige a Home.
                    if ((boolean) request.getSession().getAttribute("Validacion")) {
                        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                        Object[] param = {u.getUsername()};
                        List<Trabajador> ts = mt.listarUsu(param);
                        List<Cliente> cs = mc.listarUsu(param);
                        rd = request.getRequestDispatcher("home.jsp");
                        if (!ts.isEmpty() && ts.size() == 1) {
                            Trabajador t = ts.get(0);
                            request.getSession().setAttribute("tipo", "Trabajador");
                            request.getSession().setAttribute("trabajador", t);
                            rd.forward(request, response);
                        } else if (!cs.isEmpty() && cs.size() == 1) {
                            Cliente c = cs.get(0);
                            request.getSession().setAttribute("tipo", "Cliente");
                            request.getSession().setAttribute("cliente", c);
                            rd.forward(request, response);
                        }
                        
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case 3://Registrar Usuario.
                    Usuario u = (request.getSession().getAttribute("usuario") != null)
                            ? (Usuario) request.getSession().getAttribute("usuario") : null;
                    if (u == null) {
                        response.sendRedirect("Controlador?opc=1");
                    } else {
                        String nombre = request.getParameter("txtNombre");
                        String correo = request.getParameter("txtCorreo");
                        String dni = request.getParameter("txtDni");
                        boolean validar1 = mu.agregar(dni, correo);
                        if (validar1) {
                            boolean validar2 = mc.agregar(Integer.parseInt(dni), nombre, dni);
                            if (validar2) {
                                response.sendRedirect("Controlador?opc=5");
                            } else {
                                response.sendRedirect("Controlador?opc=999");
                            }
                        } else {
                            response.sendRedirect("Controlador?opc=999");
                        }                        
                    }
                    break;
                case 4://Configuracion de la Cuenta para ambos usuarios.
                    u = (request.getSession().getAttribute("usuario") != null)
                            ? (Usuario) request.getSession().getAttribute("usuario") : null;
                    if (u == null) {
                        response.sendRedirect("Controlador?opc=1");
                    } else {
                        response.sendRedirect("config.jsp");
                    }
                    break;
                case 41:
                    u = (request.getSession().getAttribute("usuario") != null)
                            ? (Usuario) request.getSession().getAttribute("usuario") : null;
                    if (u == null) {
                        response.sendRedirect("Controlador?opc=1");
                    } else {
                        Trabajador t = (request.getSession().getAttribute("trabajador") != null)
                                ? (Trabajador) request.getSession().getAttribute("trabajador") : null;
                        Cliente c = (request.getSession().getAttribute("cliente") != null)
                                ? (Cliente) request.getSession().getAttribute("cliente") : null;
                        if (t == null && c != null) {
                            rd = request.getRequestDispatcher("Controlador?opc=111");
                            Object[] paramUsuario = {
                                request.getParameter("txtUsername"),
                                request.getParameter("txtEmail"),
                                request.getParameter("txtPassword"),
                                u.getUsername()
                            };
                            Object[] paramCliente = {
                                request.getParameter("txtNombre"),
                                request.getParameter("txtUsername"),
                                c.getIdcliente()};
                            if (mu.modificar(paramUsuario) && mc.modificar(paramCliente)) {
                                rd.forward(request, response);
                            } else {
                                response.sendRedirect("Controlador?opc=99");
                            }
                        } else if (c == null && t != null) {
                            rd = request.getRequestDispatcher("home.jsp");
                            Object[] paramUsuario = {
                                request.getParameter("txtUsername"),
                                request.getParameter("txtEmail"),
                                request.getParameter("txtPassword"),
                                u.getUsername()
                            };
                            Object[] paramTrabajador = {
                                request.getParameter("txtNombre"),
                                t.getDni_trabajador(),
                                request.getParameter("txtUsername"),
                                t.getIdtrabajador()
                            };
                            if (mu.modificar(paramUsuario) && mt.modificar(paramTrabajador)) {
                                rd.forward(request, response);
                            } else {
                                response.sendRedirect("Controlador?opc=99");
                            }
                        }
                    }
                    break;
                case 5://Admin: Lista - Usuarios
                    u = (request.getSession().getAttribute("usuario") != null)
                            ? (Usuario) request.getSession().getAttribute("usuario") : null;
                    if (u == null) {
                        response.sendRedirect("Controlador?opc=1");
                    } else {
                        rd = request.getRequestDispatcher("usuarios.jsp");
                        List<Cliente> listaC = mc.lista();
                        if (!listaC.isEmpty()) {
                            request.getSession().setAttribute("ListaC", listaC.iterator());
                        } else {
                            request.getSession().setAttribute("ListaC", null);
                        }
                        rd.forward(request, response);
                    }
                    break;
                case 55://Admin: Agregar-Usuario.
                    u = (request.getSession().getAttribute("usuario") != null)
                            ? (Usuario) request.getSession().getAttribute("usuario") : null;
                    if (u == null) {
                        response.sendRedirect("Controlador?opc=1");
                    } else {
                        rd = request.getRequestDispatcher("addUser.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case 9://Logout
                    request.getSession(true);
                    request.getSession().invalidate();
                    response.sendRedirect("Controlador?opc=1");
                    break;
                default:
                    out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
                    out.println("</html>");
                    throw new AssertionError();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
