package daos;

import Utilidades.ConexionInstitutoWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoProfesor {
     public static void insertarProfesor(int idprofesor, String nombre, String apellido) throws SQLException, ClassNotFoundException {

        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into alumno (idalumno,nombre,apellido) values ";
        consultaSQL += "('" + idprofesor + "','" + nombre + "','" + apellido + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        conexion.close();
    }
    
    public static ResultSet verProfesor(int idprofesor, String nombre, String apellido) throws ClassNotFoundException, SQLException{
    
    Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idprofesor,nombre,apellido,ListaProfesorAsignatura from profesor";
    ResultSet ListaProfesorAsignatura=sentencia.executeQuery(consultaSQL);
    
    return ListaProfesorAsignatura;

    }

    
    public static void actualizarProfesor(int idprofesor, String nombre) throws SQLException, ClassNotFoundException{
    
        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        String consultaSQL = "update profesor set nombre=? where idprofesor=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        actualizar.setString(1, nombre);
        actualizar.setInt(2, idprofesor);
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        conexion.close();
    }
    
     public static void borrarProfesor(int idprofesor) throws SQLException, ClassNotFoundException {
        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        String consultaSQL = "delete from profesor where idprofesor=?";
        PreparedStatement buscar = conexion.prepareStatement(consultaSQL);
        buscar.setInt(1, idprofesor);
        // el execute update solo devuelve el numero de filas afectadas
        int filasAfectadas = buscar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        conexion.close();
    }
    
    }
