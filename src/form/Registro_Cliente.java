package form;

import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Registro_Cliente extends javax.swing.JFrame {

    String user,foto="";

    public Registro_Cliente() {
        initComponents();

        user = login.user;

        setTitle("Registro de Usuario = " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(675, 395);

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
    }

    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 250, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 20));

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 250, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 60, 20));

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 250, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dirreccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Registrar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 230, 30));

        txtDireccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 250, 30));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int validacion = 0;
        String nombre, email, telefono, direccion;

        nombre = txtNombre.getText().trim();
        email = txtEmail.getText().trim();
        telefono = txtTelefono.getText().trim();
        direccion = txtDireccion.getText().trim();

        if (nombre.isEmpty()) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (email.isEmpty()) {
            txtEmail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.isEmpty()) {
            txtTelefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.isEmpty()) {
            txtDireccion.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {
            try {
                Connection cx = conexion.getConexion();
                PreparedStatement ps = cx.prepareStatement(
                        "insert into clientes values (?,?,?,?,?,?)");

                ps.setInt(1, 0);
                ps.setString(2, nombre);
                ps.setString(3, email);
                ps.setString(4, telefono);
                ps.setString(5, direccion);
                ps.setString(6, user);

                ps.executeUpdate();
                cx.close();
                limpiar();

                txtNombre.setBackground(Color.green);
                txtEmail.setBackground(Color.green);
                txtTelefono.setBackground(Color.green);
                txtDireccion.setBackground(Color.green);
                
                
                 new alertas.AlertSuccess(this, true).setVisible(true);
                //JOptionPane.showMessageDialog(null, "En hora buena!, Se ha registrado el usuario");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en el registro" + e);
                 new alertas.AlertError(this, true).setVisible(true);

              //  JOptionPane.showMessageDialog(null, "¡¡ERROR AL REGISTRAR CLIENTE!!, contacte al administrador. ");

            }
        } else {
             new alertas.AlertInformation(this, true).setVisible(true);
          ///  JOptionPane.showMessageDialog(null, "Lo sentimos!. Hay campos vacios. Por favor llenalos para hacer el registro ");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
}
