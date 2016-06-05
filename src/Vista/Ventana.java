/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Coneccion;
import Modelo.Hilo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author yadir
 */
public class Ventana extends javax.swing.JFrame implements KeyListener{
   
    Coneccion coneccion;
    Random rd=new Random();
    int score, tiempos=0, velocidad=10, cambioCarrio=0, x=0, y=0, carril=0, y_villano=0, x_principal=0;
    String v="", nombreRecord="";
    Hilo hilo;
    
    public Ventana() {
        initComponents();
        coneccion=new Coneccion();
        setTitle("Esquiva Coches");
        setSize(210, 420);
        setLocationRelativeTo(null);
        addKeyListener(this);
        score=0;
        hilo=new Hilo(this);
        hilo.start();
        
    }
/*************************************************/
    //movimientos del personaje principal(carro azul)

 
    public void keyTyped(KeyEvent e) {
      
 
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        if(e.getKeyCode()==39)
        {
            principal.setLocation(144, principal.getY());
        }
         if(e.getKeyCode()==37)
        {
            principal.setLocation(36, principal.getY());
        }
        
    }


    public void keyReleased(KeyEvent e) {
    }
    
    public void moverFondo()
    {
         x=villano.getY();
         
    
        
           if(x<-100)
           {  
               carril = (int)(Math.random()*3+0);
           
                 if(carril==0)
                 {   
                 villano.setLocation(36, 375);
                 cambioCarrio++;  
                 }
              
                  if(carril==1)
                  {    
                  villano.setLocation(36 + 108, 475);
                  }
                  if(carril==2)
                  {
                    villano.setLocation(36 , 575);  
                  }
              
                velocidad+=5;
         
               
           }else{
               
                villano.setLocation(villano.getX(), villano.getY()-velocidad);
           }    
          

        
    }
    public void moverObstaculos()
    {
        villano.setLocation(villano.getX(), villano.getY()-2);
    }
    
    public String getPosicion()
    {
        return "" + fondo.getY();
    }
    public void aumentarPuntaje()
    {
       if(tiempos==5)
       {   
        score++;
        tiempos=0;
       }else{
           tiempos++;
       }
       
    }
    public void verificar_Colision()
    {
       y=villano.getX();
       y_villano=villano.getY();
       x_principal=principal.getX();
       
     if((y==36) && (x_principal==36) )
     {
         if(y_villano<(principal.getY()+ 80))
         {
             JOptionPane.showMessageDialog(null, "G A M E  O V E R\nSu puntuación fue de: " + score, "Warning", JOptionPane.WARNING_MESSAGE);
             if(coneccion.verificarPuntuacio(score))
             {
                 JOptionPane.showMessageDialog(null, "     Felicidades!!!    \n"
                         + "Has conseguido un nuevo record");
                 nombreRecord=JOptionPane.showInputDialog("Ingrese su nombre");
                 if(coneccion.establecerRecord(nombreRecord, score))
                 {
                     JOptionPane.showMessageDialog(null, "     Enhorabuena " + nombreRecord + " su record ha sido registrado");
                     System.exit(0);
                 }else
                 {
                     JOptionPane.showMessageDialog(null, "Error al registrar record");
                     System.exit(0);
                 }
                 
             }else
             {
                JOptionPane.showMessageDialog(null, "Su puntuación no ha superado el record");
                System.exit(0);  
             }
        
            
            
         }
     }
     if((y==144) && (x_principal==144))
     {
           if(y_villano<(principal.getY()+ 80))
         {
                JOptionPane.showMessageDialog(null, "G A M E  O V E R\nSu puntuación fue de: " + score, "Warning", JOptionPane.WARNING_MESSAGE);
             if(coneccion.verificarPuntuacio(score))
             {
                 JOptionPane.showMessageDialog(null, "     Felicidades!!!    \n"
                         + "Has conseguido un nuevo record");
                 nombreRecord=JOptionPane.showInputDialog("Ingrese su nombre");
                 if(coneccion.establecerRecord(nombreRecord, score))
                 {
                     JOptionPane.showMessageDialog(null, "     Enhorabuena " + nombreRecord + " su record ha sido registrado");
                     System.exit(0);
                 }else
                 {
                     JOptionPane.showMessageDialog(null, "Error al registrar record");
                     System.exit(0);
                 }
                 
             }else
             {
                JOptionPane.showMessageDialog(null, "Su puntuación no ha superado el record");
                System.exit(0);  
             }
             
             
         }
     }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JLabel();
        villano = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/car01.png"))); // NOI18N
        getContentPane().add(principal);
        principal.setBounds(36, 0, 36, 80);

        villano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/car02-n.png"))); // NOI18N
        villano.setPreferredSize(new java.awt.Dimension(32, 75));
        getContentPane().add(villano);
        villano.setBounds(36, 375, 32, 75);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carretera_1.jpg"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 210, 1610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel principal;
    private javax.swing.JLabel villano;
    // End of variables declaration//GEN-END:variables

   
}
