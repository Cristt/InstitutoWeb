package daos;

import Utilidades.ConexionInstitutoWeb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoProfesor {
     public static void insertarProfesor(int idprofesor, String nombre, String apellido) throws SQLException, ClassNotFoundException {

        Connection conexion = ConexionInstitutoWeb.conexionInstitutoWeb();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into profesor (idprofesor,nombre,apellido) values ";
        consultaSQL += "('" + idprofesor + "','" + nombre + "','" + apellido + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        conexion.close();
    }
    
    public static ResultSet verProfesor(int idprofesor, String nombre, String apellido) throws ClassNotFoundException, SQLException{
    
    Connection conexion = ConexionInstitutoWeb.conexionInstitutoWeb();
    String consultaSQL = "select idprofesor,nombre,apellido,ListaProfesorAsignatura from profesor";
    PreparedStatement mostrar = conexion.prepareStatement(consultaSQL);
    mostrar.setInt(1, idprofesor);
    mostrar.setString(2, nombre);
    mostrar.setString(2, apellido);
    ResultSet ListaProfesorAsignatura=mostrar.executeQuery(consultaSQL);
    
    return ListaProfesorAsignatura;

    }

    
    public static void actualizarProfesor(int idprofesor, String nombre, String apellido) throws SQLException, ClassNotFoundException{
    
        Connection conexion = ConexionInstitutoWeb.conexionInstitutoWeb();
        String consultaSQL = "update profesor set nombre=?,apellido=? where idprofesor=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        actualizar.setString(1, nombre);
        actualizar.setString(2, apellido);
        actualizar.setInt(3, idprofesor);
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        conexion.close();
    }
    
     public static void borrarProfesor(int idprofesor, String nombre, String apellido) throws SQLException, ClassNotFoundException {
        Connection conexion = ConexionInstitutoWeb.conexionInstitutoWeb();
        String consultaSQL = "delete  nombre=?, apellido=? from profesor where idprofesor=?";
        PreparedStatement borrar = conexion.prepareStatement(consultaSQL);
        borrar.setString(1, nombre);
        borrar.setString(2, apellido);
        borrar.setInt(3, idprofesor);
        // el execute update solo devuelve el numero de filas afectadas
        int filasAfectadas = borrar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        conexion.close();
    }
    
    }
