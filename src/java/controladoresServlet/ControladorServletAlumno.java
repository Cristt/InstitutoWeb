package controladoresServlet;

import Utilidades.ConexionInstitutoWeb;
import bos.BoAlumno;
import bos.BoProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name="FormularioServletCamarero", urlPatterns={"/Restaurante/formularioServletCamarero"})
public class ControladorServletAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        HttpSession misession = (HttpSession) request.getSession();
        boolean log = (boolean) misession.getAttribute("ok");
        //si el usuario esta logeado
        if (log == true) {

            //recupera el action del formulario
            String action = request.getParameter("action");

            if (action.contains("actualizar")) {

                BoAlumno.procesarActualizarAlumno(request, response);

            } else {

                response.sendRedirect("/InstitutoWeb/indexAlumno.html");

            }
            if (action.contains("insertar")) {

                BoAlumno.procesarInsertarAlumno(request, response);

            } //si el usuario no esta loegado hace el else{}
            else {
                response.sendRedirect("/InstitutoWeb/indexAlumno.html");

            }
            if (action.contains("ver")) {

                BoAlumno.procesarVerAlumno(request, response);

            } else {

                response.sendRedirect("/InstitutoWeb/indexAlumno.html");

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ControladorServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ControladorServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
