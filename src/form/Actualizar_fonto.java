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
 * @author Alex Carrera
 */
public class Actualizar_fonto extends javax.swing.JFrame {

 String user;
    public Actualizar_fonto() {
        initComponents();
        
         user = login.user;
        
        String foto = "";
        setLocationRelativeTo(null);
          setTitle("Actualizar foto del Usuario = "+ user);
          lblInfo.setText("Cambiar fondo para el usuario  "+user);
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

        jPanel1 = new javax.swing.JPanel();
        lblCanbiar_foto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCanbiar_foto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblCanbiar_foto.setForeground(new java.awt.Color(255, 255, 255));
        lblCanbiar_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCanbiar_foto.setText("FOTO");
        lblCanbiar_foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblCanbiar_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCanbiar_fotoMousePressed(evt);
            }
        });
        jPanel1.add(lblCanbiar_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 230, 220));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Actualizar foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 230, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("¡Aviso!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html> Estimado usuario, la imagen<br> que vaya a elegir como fondo<br> del sistema le pedimos que sea<br> una imagen medianamente de<br> colores oscuro para que no<br> afecte la visualizacion de los<br> componente del sistema. <html>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        lblInfo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 480, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, 90));
        jPanel1.add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   File fichero;
    private void lblCanbiar_fotoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCanbiar_fotoMousePressed
      int resultado;
        CargarFoto cf = new CargarFoto();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter ("JPG y PNG","jpg","png");
         cf.Jcargar.setFileFilter(filtro);
         
         resultado=cf.Jcargar.showOpenDialog(null);
         
         if(JFileChooser.APPROVE_OPTION == resultado){
           
             fichero = cf.Jcargar.getSelectedFile();
           
             
             try {
                 ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblCanbiar_foto.getWidth(),lblCanbiar_foto.getHeight(),Image.SCALE_DEFAULT));
               
           lblCanbiar_foto.setText(null);
              lblCanbiar_foto.setIcon(icono);
             } catch (Exception e) {
                 
                 System.err.println(e);
             }
             
             
         }
    }//GEN-LAST:event_lblCanbiar_fotoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if( lblCanbiar_foto.equals("")){
             JOptionPane.showMessageDialog(null, "El campo foto no puede estar vacio. ");
        }else{
        
        try {
             Connection cx = conexion.getConexion();
                PreparedStatement ps = cx.prepareStatement(
                        "update usuarios set imagen = ? where username = '"+user+"'  ");

                ps.setString(1, fichero.toString());
              

                ps.executeUpdate();
                cx.close();
                 JOptionPane.showMessageDialog(null, "En hora buena!, Se ha actualizado su fondo ");
             JOptionPane.showMessageDialog(null, "Debes de reiniciar el sistema para ver los cambios de tu actualizacion de\nfondo.");
             dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Actualizar_fonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizar_fonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizar_fonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizar_fonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizar_fonto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCanbiar_foto;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblWallPaper;
    // End of variables declaration//GEN-END:variables
}
