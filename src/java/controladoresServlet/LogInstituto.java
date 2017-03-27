/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresServlet;

import Utilidades.VerificarLogin;
import java.io.IOException;
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

        String user_nombre = request.getParameter("login_usuario");
        String pass_apellido = request.getParameter("login_password");

        boolean verificarUsuario = VerificarLogin.comprobarLogin(user_nombre, pass_apellido);

        if (verificarUsuario == true) {
                //esta variable nos sirve para comprobar 
            //si el usuario esta logeado en otros sevlets
            
            HttpSession sesion_login = request.getSession();
            //guardo en la sesion 
            sesion_login.setAttribute("login_usuario", user_nombre);
            sesion_login.setAttribute("login_password", pass_apellido);
            sesion_login.setAttribute("ok", verificarUsuario);

            response.sendRedirect("/InstitutoWeb/indice.html");
        } else {

            response.sendRedirect("/InstitutoWeb/index.htm");
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LogInstituto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
