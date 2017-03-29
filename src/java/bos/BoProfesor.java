
package bos;

import Entidades.Profesor;
import daos.DaoProfesor;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoProfesor {

        public static void procesarInsertarProfesor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Profesor Profesor = new Profesor();
        //recojemos los datos del formulario
        Profesor.setIdprofesor(Integer.parseInt(request.getParameter("idprofesor")));
        Profesor.setNombre(request.getParameter("nombre"));
        Profesor.setApellido(request.getParameter("apellido"));
        Profesor.setListaProfesorAsignatura(request.getParameter("ListaProfesorAsignatura"));
        DaoProfesor.insertarProfesor(Profesor.getIdprofesor(), Profesor.getNombre(),Profesor.getApellido());
        response.sendRedirect("/InstitutoWeb/index.htm");

    }

     
    public static void procesarActualizarProfesor(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
     Profesor Profesor = new Profesor();
    Profesor.setIdprofesor(Integer.parseInt(request.getParameter("idprofesor")));
    Profesor.setNombre(request.getParameter("nombre"));
    Profesor.setApellido(request.getParameter("apellido"));
    DaoProfesor.actualizarProfesor(Profesor.getIdprofesor(), Profesor.getNombre(),Profesor.getApellido());
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/mostrarServletProfesor");
    }
     
    public static void procesarVerProfesor(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
     Profesor Profesor = new Profesor();
    Profesor.setIdprofesor(Integer.parseInt(request.getParameter("idprofesor")));
    Profesor.setNombre(request.getParameter("nombre"));
    Profesor.setApellido(request.getParameter("apellido"));
    DaoProfesor.verProfesor(Profesor.getIdprofesor(), Profesor.getNombre(),Profesor.getApellido());
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/mostrarServletProfesor");
    }
    
    public static void procesarBorrarProfesor(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
     Profesor Profesor = new Profesor();
    Profesor.setIdprofesor(Integer.parseInt(request.getParameter("idprofesor")));
    Profesor.setNombre(request.getParameter("nombre"));
    Profesor.setApellido(request.getParameter("apellido"));
    DaoProfesor.borrarProfesor(Profesor.getIdprofesor(), Profesor.getNombre(),Profesor.getApellido());
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/mostrarServletProfesor");
    }
}

    

