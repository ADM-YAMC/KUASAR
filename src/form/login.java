package form;

import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";

    public login() {
        initComponents();
        setSize(360, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon wall = new ImageIcon("src/imagenes/6.jpg");

        Icon icono = new ImageIcon(wall.getImage().getScaledInstance(lblWallPaper.getWidth(), lblWallPaper.getHeight(), Image.SCALE_DEFAULT));
        lblWallPaper.setIcon(icono);
        this.repaint();
    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        lblPass = new javax.swing.JPasswordField();
        lblUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelIncorrecto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login-Kuasar");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setText("Kuasar");
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        lblPass.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        getContentPane().add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 280, 30));

        lblUser.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblUserKeyPressed(evt);
            }
        });
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 280, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabelIncorrecto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIncorrecto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelIncorrecto.setForeground(new java.awt.Color(255, 0, 0));
        jLabelIncorrecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelIncorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 300, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Acceder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 100, 30));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

 
        user = lblUser.getText().trim();
        pass = lblPass.getText().trim();

        if (!user.equals("") || !pass.equals("")) {

            try {
                Connection cn = conexion.getConexion();
                PreparedStatement pst = cn.prepareStatement("select rol, estatus from usuarios where username = '" + user + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    String rol = rs.getString("rol");
                    String estatus = rs.getString("estatus");
                    if(estatus.equalsIgnoreCase("Inactivo")){
                     new alertas.AlertErrorBloqueo(this, true).setVisible(true);
                       lblUser.setText("");
                    lblPass.setText("");
                    cn.close();
                    }
                    if (rol.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {

                        dispose();
                        new Administrador().setVisible(true);
                    } else if (rol.equalsIgnoreCase("Supervisor") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Supervisor().setVisible(true);
                    } else if (rol.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {

                        dispose();
                        new Tegnico().setVisible(true);
                    }
                } else  {
                    jLabelIncorrecto.setText("¡¡El Usuario o contraseña son incorrectos!!");

                    lblUser.setText("");
                    lblPass.setText("");

                
                }
            } catch (SQLException e) {
                System.err.print("Error en el boton acceder" + e);
                lblPass.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hola!. Debes de llenar todos las campos para acceder");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblUserKeyPressed
        // TODO add your handling code here:
        user = lblUser.getText().trim();
        if (!user.equals("")) {
            jLabelIncorrecto.setText("");

        }
    }//GEN-LAST:event_lblUserKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIncorrecto;
    private javax.swing.JPasswordField lblPass;
    private javax.swing.JTextField lblUser;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
