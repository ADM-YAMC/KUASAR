/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Act_username extends javax.swing.JFrame {

    String user,foto="";
   
    public Act_username() {
           user = login.user;
        initComponents();
         setTitle("Cambir Username = " + user);
        setLocationRelativeTo(null);
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
        
        lblUserAnterior.setText(user);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        las = new javax.swing.JLabel();
        lblUserAnterior = new javax.swing.JTextField();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar username");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambiar Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 180, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, -1));

        txtUser.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 280, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 120, -1));

        las.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        las.setForeground(new java.awt.Color(255, 255, 255));
        las.setText("Usuario Anterior");
        getContentPane().add(las, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, -1));

        lblUserAnterior.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblUserAnterior.setFocusable(false);
        lblUserAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblUserAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(lblUserAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 280, 30));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 440, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int permiso, validacion=0;
        String username;
        
      
        username = txtUser.getText().trim();
       
      
        if(username.isEmpty() ){
          
            Color rojo=new Color(230, 86, 86);
            txtUser.setBackground(rojo);
               validacion++;
        }
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "select username from usuarios where username = '"+username+"'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
             Color rojo=new Color(230, 86, 86);
              txtUser.setBackground(rojo);
                JOptionPane.showMessageDialog(null, "Lo sentimos!. El nombre de usuario ya existe en nuestra base de datos");
                cn.close();
            }else{
            cn.close();
                if (validacion == 0) {
                    try {
                         Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                "update usuarios set  username=?"
                            + "where username = '" + user + "'");

                    ps.setString(1, username);
          
                            
                            ps.executeUpdate();
                            cx.close();
                          //  limpiar();
                              new alertas.AlertSuccess(null, true).setVisible(true);
             
                              //JOptionPane.showMessageDialog(null, "En hora buena!, Se ha registrado el usuario");
                              this.dispose();
            
                    } catch (SQLException e) {
                        System.err.println("Error en el registro"+e);
                    }
                } else {
                     new alertas.AlertInformation(null,true).setVisible(true);
                   // JOptionPane.showMessageDialog(null, "Lo sentimos!. Hay campos vacios. Por llenalos para hacer el registro ");
                }
                
            }
            
        } catch (SQLException e) {
                    System.err.println("Error al validar"+e);
        }
                

    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblUserAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblUserAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserAnteriorActionPerformed

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
            java.util.logging.Logger.getLogger(Act_username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Act_username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Act_username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Act_username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Act_username().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel las;
    private javax.swing.JTextField lblUserAnterior;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
