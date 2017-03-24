/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author martaperal
 */
public class VerificarLogin {
    
    public static boolean comprobarLogin(String usuario,String password) throws ClassNotFoundException, SQLException{
       
      //esta variable no hace nada
       
        boolean nRegistro = false;
        String consultaSQL = "select * from profesor where nombre=? and apellido =?";
        Connection con=ConexionInstitutoWeb.ConexionInstitutoWeb();
        PreparedStatement comprobarLogin=con.prepareStatement(consultaSQL);
        
        ResultSet rs=comprobarLogin.executeQuery(consultaSQL);
       
       if(rs.next()){
          // si devuelve resultados el login es correcto 
          nRegistro=true;
          
       }
        
        return nRegistro;
        
    }   
    
}
        