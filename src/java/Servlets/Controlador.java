/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Cliente;
import Beans.Trabajador;
import Beans.Usuario;
import DATOS.CADO;
import Modelos.Model_Cliente;
import Modelos.Model_Trabajador;
import Modelos.Model_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            CADO cado = new CADO();
            RequestDispatcher rd;
            ResultSet rs;
            int opc = Integer.parseInt(request.getParameter("opc"));
            switch (opc) {

                case 1://Default para retornar -> index
                    response.sendRedirect("index.jsp");
                    break;
                case 11://Login Proceso de validar usuario
                    String usu = request.getParameter("txtuser");
                    String contraseña = request.getParameter("txtpassword");
                    if (!usu.equals("") && !contraseña.equals("")) {
                        Model_Usuario mu = new Model_Usuario();
                        List<Usuario> usuario = mu.login(usu, contraseña);
                        if (!usuario.isEmpty() && usuario.size() == 1) {
                            request.getSession().setAttribute("usuario", (Usuario) usuario.get(0));
                            request.getSession().setAttribute("SesVal", (boolean )true); //Usas un parametro para la validacion (Es abstracto)
                            response.sendRedirect("Controlador?opc=111");
                        } else {
                            response.sendRedirect("Controlador?opc=99");
                        }
                    } else {
                        response.sendRedirect("Controlador?opc=1");
                    }
                    break;
                case 111://Login Proceso de retornar valores de usuario -> redirige a Home
                    if ((boolean) request.getSession().getAttribute("SesVal")) {
                        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                        Object[] param = {u.getUsername()};
                        Model_Trabajador mt = new Model_Trabajador();
                        Model_Cliente mc = new Model_Cliente();
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
                            request.setAttribute("tipo", "Cliente");
                            request.setAttribute("cliente", c);
                            rd.forward(request, response);
                        }

                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case 9://Logout

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
