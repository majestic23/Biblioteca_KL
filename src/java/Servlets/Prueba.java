/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Usuario;
import Modelos.Model_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
public class Prueba extends HttpServlet {

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
            
            int opc = Integer.parseInt(request.getParameter("opc"));
            switch (opc) {
                
             case 11://Login Proceso de validar usuario
                    String usu = request.getParameter("txtuser");
                    String contraseña = request.getParameter("txtpassword");
                    if (!usu.equals("") && !contraseña.equals("") && contraseña.length() <= 6) {
                        Object[] param = {usu, contraseña};
                        Model_Usuario mu = new Model_Usuario();
                        List<Usuario> usuario = mu.login(usu, contraseña);
                        if (!usuario.isEmpty() && usuario.size() == 1) {
                            request.getSession().setAttribute("usuario", (Usuario) usuario.get(0));
                            request.getSession().setAttribute("SesVal", true); //Usas un parametro para la validacion (Es abstracto)
                            response.sendRedirect("home.jsp");
                        } else {
                            response.sendRedirect("Controlador?opc=1");
                        }
                    } else {
                        response.sendRedirect("Controlador?opc=1");
                    }
                    break;
                    
                default:
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
