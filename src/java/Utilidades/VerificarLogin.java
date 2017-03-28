
package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarLogin {
    
    public static boolean comprobarLogin(int idadministrador, String nombre,String apellido) throws ClassNotFoundException, SQLException{
       
      //esta variable no hace nada
       
        boolean nRegistro = false;
        String consultaSQL = "select * from administrador where idadministrador=? , nombre=? and password=?";
        Connection con=ConexionInstitutoWeb.conexionInstitutoWeb();
        PreparedStatement comprobarLogin=con.prepareStatement(consultaSQL);
        
        ResultSet rs=comprobarLogin.executeQuery(consultaSQL);
       
       if(rs.next()){
          // si devuelve resultados el login es correcto 
          nRegistro=true;
          
       }
        
        return nRegistro;
        
    }   
    
}
        