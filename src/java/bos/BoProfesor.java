/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import Entidades.Alumno;
import Entidades.Profesor;
import daos.DaoProfesor;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author admin
 */
public class BoProfesor {

        public static void procesarInsertarPeticionProfesor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Profesor Profesor = new Profesor();
        //recojemos los datos del formulario
        Profesor.setNombre(request.getParameter("nombre"));
        Profesor.setApellido(request.getParameter("apellido"));
        Profesor.setListaProfesorAsignatura(request.getParameter("ListaProfesorAsignatura"));
        insertarProfesor(Profesor.getidprofesor(), Profesor.getNombre(), Profesor.getApellido(),Profesor.getListaProfesorAsignatura());
        response.sendRedirect("/InstitutoWeb/mostrarServletProfesor");

    }

     
    public static void procesarUpdateProfesor(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
     Profesor Profesor = new Profesor();
    Profesor.setidProfesor(request.getParameter("idprofesor"));
    Profesor.setNombre(request.getParameter("nombre"));
    Profesor.setApellido(request.getParameter("apellido"));
    DaoProfesor.actualizarProfesor(1, null);
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/index.htm");
    }

    private static void insertarProfesor(int idprofesor, String nombre, String apellido, String listaProfesorAsignatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

