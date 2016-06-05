/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yadir
 */
public class Coneccion {
    
    Connection con;
    int verificador=0, score;
    
    public Coneccion()
    {
       RealizarConeccion();
    }
       public void  RealizarConeccion() 
    { 
        
       try{
            String clase="com.mysql.jdbc.Driver";   
            String coneccionUrl= "jdbc:mysql://localhost:3306/record";   
            String userName="root";
            String password="";
         Class.forName(clase);
         con=DriverManager.getConnection(coneccionUrl, userName, password);
         System.out.println("La conección ha sido exitosa.");
            
        }catch(SQLException e){
        
            System.out.println("SQL Exception: " + e.toString());
        }catch(ClassNotFoundException cE){
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    } 
/*****************************************************************************/

    public boolean verificarPuntuacio(int puntaje)
    {
     
        Statement st;
        ResultSet rt;
        boolean esMayor=false;
        
        try {
            
            st=con.createStatement();
            rt=st.executeQuery("SELECT * FROM `mejor_record`");
            
            
            while(rt.next())
            {
                score=rt.getInt("puntaje");
                if(score<puntaje)
                {
                    esMayor=true;
                    
                }
                
            }
            
        } catch (Exception e) {
            System.out.print("" + e.getMessage());
        }
        if(score<puntaje)
        {
            esMayor=true;
        }
        return esMayor;
    }
    
    public boolean establecerRecord(String nombre, int score)
    {
        Statement st;
        boolean eliminado, registrado;
       
        
        try {
            
           st=con.createStatement();
           eliminado=st.execute("DELETE FROM `mejor_record`");
           registrado=st.execute("INSERT INTO `mejor_record`(`nombre`, `puntaje`) VALUES ('"+nombre+"','"+score+"')");
          
           return true;
         
            
            
        } catch (Exception e) {
            System.out.print("" + e.getMessage());
            return false; 
        }
    
    }
       
       
}
