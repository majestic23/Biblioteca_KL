/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Usuario;
import DATOS.CADO;
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
                case 11://Login
                    String usu = request.getParameter("txtuser");
                    String contraseña = request.getParameter("txtpassword");
                    Object[] param = {usu,contraseña};
                    Model_Usuario mu = new Model_Usuario();
                    List<Usuario>  usuario = mu.listar(param);
                    if (!usuario.isEmpty() && usuario.size()==1) {
                        request.getSession().setAttribute("user", usuario.get(0));
                        request.getSession().setAttribute("password", null);//Te quedaste aca !
                    }
                    break;
                case 2:
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
