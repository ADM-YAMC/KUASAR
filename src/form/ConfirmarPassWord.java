
package form;

import clases.conexion;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex carrera
 */
public class ConfirmarPassWord extends javax.swing.JPanel {

   String user,foto;
    public ConfirmarPassWord() {
        user = login.user;
        initComponents();
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

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtConfirmar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblWallPaper = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Confirmar");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 120, 20));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Comfirme su contraseña de inicio de sesecion");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtConfirmar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        add(txtConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 110, -1));
        add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 410, 179));
    }// </editor-fold>//GEN-END:initComponents
 String confirmar;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
              Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select password from usuarios where password = '"+txtConfirmar.getText().trim()+"'");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               confirmar = rs.getString(1);
               }
        } catch (SQLException e) {
        }
        if(confirmar.equals(txtConfirmar.getText().trim())){
     
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JTextField txtConfirmar;
    // End of variables declaration//GEN-END:variables
}
