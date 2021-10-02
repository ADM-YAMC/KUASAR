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

import clases.conexion;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;

public class informacion extends javax.swing.JFrame {

    String user = "", update = "",foto="";
    int id;

    public informacion() {
        initComponents();
        user = login.user;
        update = Editar_Usuarios.update;
        
        
        setTitle("Informacion del Usuario " + update);
        setLocationRelativeTo(null);
        setResizable(false);

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

        lblTitulo.setText("Informacion del Usuario " + update);

        try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where username = '" + update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_usuario");

                txtNombre.setText(rs.getString("nombre_usuario"));
                txtEmail.setText(rs.getString("email"));
                txtTelefono.setText(rs.getString("telefono"));
                txtUsuario.setText(rs.getString("username"));
                lblRegistro.setText(rs.getString("registro"));

                jcomboboxNivel.setSelectedItem(rs.getString("rol"));
                jComboBoxEstatus.setSelectedItem(rs.getString("estatus"));
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cagar usuario " + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL CARGAR!!, Contacte al administrador");
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

        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcomboboxNivel = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxEstatus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Informacion del usuario");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 460, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 80, -1));

        txtNombre.setBackground(new java.awt.Color(102, 204, 255));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 230, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txtEmail.setBackground(new java.awt.Color(102, 204, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 230, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(102, 204, 255));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 230, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rol:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 30, -1));

        jcomboboxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Supervisor", "Tecnico" }));
        getContentPane().add(jcomboboxNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 230, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(102, 204, 255));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 210, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jComboBoxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(jComboBoxEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 210, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registrado por:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 294, 200, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 210, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 80, 80));

        lblWallPaper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblWallPaperKeyReleased(evt);
            }
        });
        jPanel1.add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        user = txtNombre.getText().trim();
        if (!user.equals("")) {
            txtNombre.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
        user = txtEmail.getText().trim();
        if (!user.equals("")) {
            txtEmail.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void lblWallPaperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblWallPaperKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblWallPaperKeyReleased

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:
        user = txtUsuario.getText().trim();
        if (!user.equals("")) {
            txtUsuario.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
        user = txtTelefono.getText().trim();
        if (!user.equals("")) {
            txtTelefono.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

        int permisos, estatus, validacion = 0;
        String nombre, email, telefono, username, password, permisos_string = "", estatus_string = "";
        nombre = txtNombre.getText().trim();
        email = txtEmail.getText().trim();
        telefono = txtTelefono.getText().trim();
        username = txtUsuario.getText().trim();
        permisos = jcomboboxNivel.getSelectedIndex() + 1;
        estatus = jComboBoxEstatus.getSelectedIndex() + 1;

        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (email.equals("")) {
            txtEmail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txtTelefono.setBackground(Color.red);
            validacion++;
        }
        if (username.equals("")) {
            txtUsuario.setBackground(Color.red);
            validacion++;
        }
        if (validacion == 0) {

            if (permisos == 1) {
                permisos_string = "Administrador";
            } else if (permisos == 2) {
                permisos_string = "Supervisor";
            } else if (permisos == 3) {
                permisos_string = "Tecnico";
            }
            if (estatus == 1) {
                estatus_string = "Activo";
            } else if (estatus == 2) {
                estatus_string = "Inactivo";
            }

            try {
                Connection cn = conexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select username from usuarios where username = '" + username + "' and not id_usuario = '" + id + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    txtUsuario.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "¡Nombre de usuario no disponible!");
                    cn.close();
                } else {
                    Connection cn2 = conexion.getConexion();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "update usuarios set nombre_usuario=?, email=?, telefono=?, username=?, rol=?, estatus=?"
                            + "where id_usuario = '" + id + "'");

                    pst2.setString(1, nombre);
                    pst2.setString(2, email);
                    pst2.setString(3, telefono);
                    pst2.setString(4, username);
                    pst2.setString(5, permisos_string);
                    pst2.setString(6, estatus_string);

                    pst2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "¡Modificacion exitosa!");
                    cn2.close();
                }
            } catch (SQLException e) {
                System.err.println("Eror al actualizar" + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "¡Los campos estan vacios!");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcomboboxNivel;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
