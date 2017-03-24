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

        public static void procesarInsertarPeticionAlumno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Alumno Alumno = new Alumno();
        //recojemos los datos del formulario
        Alumno.setNombre(request.getParameter("nombre"));
        Alumno.setApellido(request.getParameter("apellido"));
        Alumno.setListaAlumnoProfesor(request.getParameter("String ListaAlumnoProfesor"));
        insertarAlumno(Alumno.getidalumno(), Alumno.getNombre(), Alumno.getApellido(),Alumno.getListaAlumnoProfesor());
        response.sendRedirect("/InstitutoWeb/mostrarServletAlumno");

    }

    public static void procesarUpdateAlumno(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
    Alumno Alumno = new Alumno();
   Alumno.setidAlumno(request.getParameter("x"));
   Alumno.setNombre(request.getParameter("nombre"));
   Alumno.setApellido(request.getParameter("apellido"));
    DaoAlumno.actualizaralumno(1, null);
    //pendiente devolver a la vista  para mostrar el resultado 
    response.sendRedirect("/InstitutoWeb/index.htm");
    }
        
    private static void insertarAlumno(int idalumno, String nombre, String apellido, String listaAlumnoProfesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
