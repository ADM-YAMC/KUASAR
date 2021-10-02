/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Act_foto_user extends javax.swing.JFrame {

  String user;
    public Act_foto_user() {
        initComponents();
        
          user = login.user;
        
        String foto = "";
        setLocationRelativeTo(null);
          setTitle("Actualizar foto de perfil Usuario = "+ user);
          lblInfo.setText("Cambiar foto de perfil a "+user);
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
    }

   @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCambiar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCambiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCambiar.setForeground(new java.awt.Color(255, 255, 255));
        lblCambiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCambiar.setText("FOTO");
        lblCambiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCambiarMousePressed(evt);
            }
        });
        getContentPane().add(lblCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 230, 220));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Actualizar foto de perfil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 230, 30));

        lblInfo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 310, 30));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if( lblCambiar.equals("")){
             JOptionPane.showMessageDialog(null, "El campo foto no puede estar vacio. ");
        }else{
        
        try {
             Connection cx = conexion.getConexion();
                PreparedStatement ps = cx.prepareStatement(
                        "update usuarios set imagen_usuario = ? where username = '"+user+"'  ");

                ps.setString(1, fichero.toString());
              

                ps.executeUpdate();
                cx.close();
                 JOptionPane.showMessageDialog(null, "En hora buena!, Se ha actualizado su foto de perfil ");
             JOptionPane.showMessageDialog(null, "Debes de reiniciar el sistema para ver los cambios de tu actualizacion del\nperfil de usuario.");
             dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
   File fichero;
    private void lblCambiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarMousePressed
     int resultado;
        CargarFoto cf = new CargarFoto();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter ("JPG y PNG","jpg","png");
         cf.Jcargar.setFileFilter(filtro);
         
         resultado=cf.Jcargar.showOpenDialog(null);
         
         if(JFileChooser.APPROVE_OPTION == resultado){
           
             fichero = cf.Jcargar.getSelectedFile();
           
             
             try {
                 ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblCambiar.getWidth(),lblCambiar.getHeight(),Image.SCALE_DEFAULT));
               
           lblCambiar.setText(null);
              lblCambiar.setIcon(icono);
             } catch (Exception e) {
                 
                 System.err.println(e);
             }
             
             
         }
    }//GEN-LAST:event_lblCambiarMousePressed

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
            java.util.logging.Logger.getLogger(Act_foto_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Act_foto_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Act_foto_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Act_foto_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Act_foto_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCambiar;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblWallPaper;
    // End of variables declaration//GEN-END:variables
}
