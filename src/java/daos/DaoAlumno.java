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
        Statement insertar = conexion.createStatement();
        String consultaSQL = "insert into alumno (idalumno,nombre,apellido) values ";
        consultaSQL += "('" + idalumno + "','" + nombre + "','" + apellido + "')";
        insertar.executeUpdate(consultaSQL);
        insertar.close();
        conexion.close();
    }
    
    public static ResultSet verAlumno(int idalumno, String nombre, String apellido) throws ClassNotFoundException, SQLException{
    
    Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idalumno,nombre,apellido from alumno";
    ResultSet lista_alumnos=sentencia.executeQuery(consultaSQL);
    
    return lista_alumnos;

    }

    
    public static void actualizaralumno(int idalumno, String nombre,String apellido) throws SQLException, ClassNotFoundException{
    
        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        String consultaSQL = "update alumno set nombre=?, apellido=? where idalumno=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setInt(3, idalumno);
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        conexion.close();
    }
    
     public static void borraralumno(int idalumno, String nombre, String apellido) throws SQLException, ClassNotFoundException {
        Connection conexion = ConexionInstitutoWeb.ConexionInstitutoWeb();
        String consultaSQL = "delete nombre=?, apellido=? from alumno where idalumno=?";
        PreparedStatement borrar = conexion.prepareStatement(consultaSQL);
        borrar.setInt(1, idalumno);
        borrar.setString(2, nombre);
        borrar.setString(3, apellido);
        int filasAfectadas = borrar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
    }
    
    }

