
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
        
        //int user_id = Integer.parseInt(request.getParameter("login_id"));
        String user_nombre = request.getParameter("login_usuario");
        String user_password = request.getParameter("login_password");
        
        //llamada al metodos

        boolean verificarUsuario=VerificarLogin.comprobarLogin(user_nombre, user_password);

        if (verificarUsuario == true) {
                //esta variable nos sirve para comprobar 
            //si el usuario esta logeado en otros sevlets
            
            HttpSession sesion_login = request.getSession();
            //guardo en la sesion 
            //clave-> valor
            sesion_login.setAttribute("login_usuario", user_nombre);
            sesion_login.setAttribute("login_password", user_password);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
