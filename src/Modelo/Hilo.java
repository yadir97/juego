/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;
import static java.lang.Thread.sleep;

/**
 *
 * @author yadir
 */
public class Hilo extends Thread {

 Ventana ventana; 
 
    public Hilo(Ventana ventana){
    this.ventana=ventana;
        
    }
    public void run()
    {
        
        while(true)
        {
            try{
                
               
                ventana.moverFondo();
                ventana.aumentarPuntaje();
                ventana.verificar_Colision();
                sleep(140);
            }catch(Exception e)
            {
                System.out.print("Hubo un error en el hilo de ejecución: " + e.getMessage());
            }
        }
        
        
    }
    
    public void comprobarPersonaje()
    {
  
        
    }
    
    
    
    
   
    
}//FIN DE LA CLASE
