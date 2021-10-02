
package graficas;

import clases.conexion;
import form.login;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author Alex carrera
 */
public class Grafica extends javax.swing.JFrame {

  String marcahp,marcaApple,marcaLenovo,marcaMotorola,marcaDell,marcaSamsung,Acer,Toshiba, user,foto="";
    public Grafica() {
        initComponents();
        user = login.user;
        try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as HP from  equipos where marca = 'HP'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             marcahp = rs.getString(1);
            
             m1.setText("HP "+marcahp);
          
            }
        } catch (Exception e) {
        }
         try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Apple from  equipos where marca = 'Apple'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             marcaApple = rs.getString(1);
            
              m2.setText("Apple "+marcaApple);
            }
        } catch (Exception e) {
        }
          try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Lenovo from  equipos where marca = 'Lenovo'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             marcaLenovo = rs.getString(1);
            
               m3.setText("Lenovo  "+marcaLenovo);
            }
        } catch (Exception e) {
        }
           try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Motorola from  equipos where marca = 'Motorola'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             marcaMotorola = rs.getString(1);
            
               m4.setText("Motorola  "+marcaMotorola);
            }
        } catch (Exception e) {
        }
           //Nuevo---------------------------------------------------------------------------------------------------------------------------------------------------------------
            try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Dell from  equipos where marca = 'Dell'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             marcaDell = rs.getString(1);
            
              m5.setText("Dell  "+marcaDell);
            }
        } catch (Exception e) {
        }
             try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Toshiba from  equipos where marca = 'Toshiba'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             Toshiba = rs.getString(1);
            
               m6.setText("Toshiba  "+Toshiba);
            }
        } catch (Exception e) {
        }
              try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Acer from  equipos where marca = 'Acer'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             Acer = rs.getString(1);
            
               m7.setText("Acer  "+Acer);
            }
        } catch (Exception e) {
        }
               try {
              Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "SELECT COUNT(id_equipo) as Samsung from  equipos where marca = 'Samsung'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             marcaSamsung = rs.getString(1);
            
             m8.setText("Samsung  "+marcaSamsung);
            }
        } catch (Exception e) {
        }
              setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

         try {
             Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select imagen from usuarios where username = '"+user+"'");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               foto = rs.getString("imagen");
               
               }
               if(foto.isEmpty()){
                     ImageIcon wall = new ImageIcon("src/imagenes/6.jpg");
        
        Icon icono = new ImageIcon(wall.getImage().getScaledInstance(lblWallPaper.getWidth(),lblWallPaper.getHeight(),Image.SCALE_DEFAULT));
        lblWallPaper.setIcon(icono);
        this.repaint();
               }else{
         ImageIcon wall = new ImageIcon(foto);
        
        Icon icono = new ImageIcon(wall.getImage().getScaledInstance(lblWallPaper.getWidth(),lblWallPaper.getHeight(),Image.SCALE_DEFAULT));
        lblWallPaper.setIcon(icono);
        this.repaint();
               }
        } catch (Exception e) {
        }
        this.repaint();
    }
   boolean grafi = true;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        m1 = new javax.swing.JLabel();
        m2 = new javax.swing.JLabel();
        m3 = new javax.swing.JLabel();
        m4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        m5 = new javax.swing.JLabel();
        m6 = new javax.swing.JLabel();
        m7 = new javax.swing.JLabel();
        m8 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Graficas de marcas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Graficas de marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 230, -1));

        m1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 100, 20));

        m2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 110, 20));

        m3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(m3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 100, 20));

        m4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(m4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 150, 20));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        m5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m5.setForeground(new java.awt.Color(255, 255, 255));
        m5.setText("jLabel3");
        getContentPane().add(m5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 90, -1));

        m6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m6.setForeground(new java.awt.Color(255, 255, 255));
        m6.setText("jLabel4");
        getContentPane().add(m6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 100, -1));

        m7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m7.setForeground(new java.awt.Color(255, 255, 255));
        m7.setText("jLabel5");
        getContentPane().add(m7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 110, -1));

        m8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        m8.setForeground(new java.awt.Color(255, 255, 255));
        m8.setText("jLabel6");
        getContentPane().add(m8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 140, -1));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 610, 570));

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
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JLabel m1;
    private javax.swing.JLabel m2;
    private javax.swing.JLabel m3;
    private javax.swing.JLabel m4;
    private javax.swing.JLabel m5;
    private javax.swing.JLabel m6;
    private javax.swing.JLabel m7;
    private javax.swing.JLabel m8;
    // End of variables declaration//GEN-END:variables
public void paint(Graphics g){
 super.paint(g);
 if(grafi == true){
  int rojo = Integer.parseInt(marcahp);
   int azul = Integer.parseInt(marcaApple);
    int verde = Integer.parseInt(marcaLenovo);
     int morado = Integer.parseInt(marcaMotorola);
       int amarillo = Integer.parseInt(marcaDell);
         int cian = Integer.parseInt(Toshiba);
           int rosado = Integer.parseInt(Acer);
             int magenta  = Integer.parseInt(marcaSamsung);
     
     
     int total = rojo + azul + verde + morado+amarillo+cian+rosado+magenta;
     
     int grado_rojo = rojo * 360 / total;
      int grado_azul = azul * 360 / total;
       int grado_verde = verde * 360 / total;
        int grado_morado = morado * 360 / total;
          int grado_amarillo = amarillo * 360 / total;
            int grado_cian = cian * 360 / total;
              int grado_rosado = rosado * 360 / total;
            int grado_magenta = magenta * 360 / total;
        
        g.setColor(Color.RED);
        g.fillArc(30, 100, 400, 400, 0, grado_rojo);
        g.fillRect(450,240 , 20, 20);
        g.drawString("HP", 475, 255);
        
        g.setColor(Color.BLUE);
        g.fillArc(30, 100, 400, 400, grado_rojo, grado_azul);
        g.fillRect(450,270 , 20, 20);
        g.drawString("Apple", 475, 285);
        
        g.setColor(Color.GREEN);
        g.fillArc(30, 100, 400, 400,grado_rojo +  grado_azul, grado_verde);
        g.fillRect(450,300 , 20, 20);
        g.drawString("Lenovo", 475, 315);
        
        g.setColor(Color.ORANGE);
        g.fillArc(30, 100, 400, 400,grado_rojo +  grado_azul +  grado_verde, grado_morado);
        g.fillRect(450,330 , 20, 20);
        g.drawString("Motorola", 475, 345);
        
          g.setColor(Color.YELLOW);
        g.fillArc(30, 100, 400, 400,grado_rojo +  grado_azul +  grado_verde + grado_morado,grado_amarillo);
        g.fillRect(450,360 , 20, 20);
        g.drawString("Dell", 475, 375);
        
          g.setColor(Color.cyan);
        g.fillArc(30, 100, 400, 400,grado_rojo +  grado_azul +  grado_verde + grado_morado+grado_amarillo,grado_cian);
        g.fillRect(450,390 , 20, 20);
        g.drawString("Toshiba", 475, 405);
        
          g.setColor(Color.PINK);
        g.fillArc(30, 100, 400, 400,grado_rojo +  grado_azul +  grado_verde + grado_morado+grado_amarillo+grado_cian,grado_rosado);
        g.fillRect(450,420 , 20, 20);
        g.drawString("Acer", 475, 435);
        
          g.setColor(Color.MAGENTA);
        g.fillArc(30, 100, 400, 400,grado_rojo +  grado_azul +  grado_verde + grado_morado+grado_amarillo+grado_cian+grado_rosado,grado_magenta);
        g.fillRect(450,450 , 20, 20);
        g.drawString("Samsung", 475, 465);
        
        
 }
 
 
}

}
