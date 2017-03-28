package bos;

import Entidades.Alumno;
import Entidades.Profesor;
import daos.DaoAlumno;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author admin
 */
public class BoAlumno {

        public static void procesarInsertarAlumno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Alumno Alumno = new Alumno();
        //recojemos los datos del formulario
        Alumno.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
        Alumno.setNombre(request.getParameter("nombre"));
        Alumno.setApellido(request.getParameter("apellido"));
        Alumno.setListaAlumnoProfesor(request.getParameter("String ListaAlumnoProfesor"));
        DaoAlumno.insertarAlumno(Alumno.getIdalumno(), Alumno.getNombre(),Alumno.getApellido());
        response.sendRedirect("/InstitutoWeb/index.htm");

    }

    public static void procesarActualizarAlumno(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
   Alumno Alumno = new Alumno();
   Alumno.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
   Alumno.setNombre(request.getParameter("nombre"));
   Alumno.setApellido(request.getParameter("apellido"));
   DaoAlumno.actualizaralumno(Alumno.getIdalumno(), Alumno.getNombre(),Alumno.getApellido());
   
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/mostrarServletAlumno");
    }
    public static void procesarVerAlumno(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
   Alumno Alumno = new Alumno();
   Alumno.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
   Alumno.setNombre(request.getParameter("nombre"));
   Alumno.setApellido(request.getParameter("apellido"));
   DaoAlumno.verAlumno(Alumno.getIdalumno(), Alumno.getNombre(),Alumno.getApellido());
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/mostrarServletAlumno");
    }

}
