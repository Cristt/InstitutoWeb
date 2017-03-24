package daos;

import Utilidades.ConexionInstitutoWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoAlumno {
     public static void insertarAlumno(int idalumno, String nombre, String apellido) throws SQLException, ClassNotFoundException {

        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into alumno (idalumno,nombre,apellido) values ";
        consultaSQL += "('" + idalumno + "','" + nombre + "','" + apellido + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        conexion.close();
    }
    
    public static ResultSet verAlumno(int idalumno, String nombre, String apellido) throws ClassNotFoundException, SQLException{
    
    Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idalumno,nombre,apellido from alumno";
    ResultSet lista_alumnos=sentencia.executeQuery(consultaSQL);
    
    return lista_alumnos;

    }

    
    public static void actualizaralumno(int idalumno, String nombre) throws SQLException, ClassNotFoundException{
    
        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        String consultaSQL = "update alumno set nombre=? where idalumno=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        actualizar.setString(1, nombre);
        actualizar.setInt(2, idalumno);
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        conexion.close();
    }
    
     public static void borraralumno(int idalumno) throws SQLException, ClassNotFoundException {
        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "delete from alumno where idalumno=?";
        PreparedStatement buscar = conexion.prepareStatement(consultaSQL);
        buscar.setInt(1, idalumno);
        // el execute update solo devuelve el numero de filas afectadas
        int filasAfectadas = buscar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
    }
    
    }

