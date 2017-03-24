/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresServlet;

import Utilidades.VerificarLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInstituto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        //solicito los parametros de login.html
        String user_nombre = request.getParameter("nombre");
        String pass_apellido = request.getParameter("apellido");

        boolean verificarUsuario = VerificarLogin.comprobarLogin(user_nombre, pass_apellido);

        if (verificarUsuario == true) {
                //esta variable nos sirve para comprobar 
            //si el usuario esta logeado en otros sevlets
            
            HttpSession sesion_login = request.getSession();
            //guardo en la sesion 
            sesion_login.setAttribute("login_usuario", user_nombre);
            sesion_login.setAttribute("login_password", pass_apellido);
            sesion_login.setAttribute("ok", verificarUsuario);

            response.sendRedirect("/RestauranteGit/registroProfesores.html");
        } else {

            response.sendRedirect("/RestauranteGit/index.htm");

        }

        /*response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet LogRestaurante</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet LogRestaurante at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
         }*/
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LogInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LogInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
