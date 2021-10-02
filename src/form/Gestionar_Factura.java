/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author A19C38106
 */
public class Gestionar_Factura extends javax.swing.JFrame {

    public Gestionar_Factura() {
        initComponents();

        setTitle("Gestionar Factura");
        setSize(674, 466);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wall = new ImageIcon("src/imagenes/6.jpg");
        Icon icono = new ImageIcon(wall.getImage().getScaledInstance(lblWallPaper.getWidth(), lblWallPaper.getHeight(), Image.SCALE_DEFAULT));
        lblWallPaper.setIcon(icono);
        
        ImageIcon wall2 = new ImageIcon("src/imagenes/6.jpg");
        Icon icono2 = new ImageIcon(wall2.getImage().getScaledInstance(lblWallPaper2.getWidth(), lblWallPaper2.getHeight(), Image.SCALE_DEFAULT));
        lblWallPaper2.setIcon(icono2);
        
        ImageIcon buscar = new ImageIcon("src/imagenes/buscar.png");
        Icon formato = new ImageIcon(buscar.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(formato);
    }

    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        sp3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        sp4 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblWallPaper2 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        comboArea = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        imagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(660, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Correo", "Telefono", "Direccion", "Registro"
            }
        ));
        tabla.setName(""); // NOI18N
        sp.setViewportView(tabla);

        jPanel1.add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 581, 110));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Correo", "Telefono", "Direccion", "Registro"
            }
        ));
        tabla2.setName(""); // NOI18N
        sp3.setViewportView(tabla2);

        jPanel1.add(sp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 581, 110));

        tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Correo", "Telefono", "Direccion", "Registro"
            }
        ));
        tabla3.setName(""); // NOI18N
        sp4.setViewportView(tabla3);

        jPanel1.add(sp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 581, 120));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tecnicos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Equipos");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Clientes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));
        jPanel1.add(lblWallPaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 645, 470));

        jScrollPane3.setViewportView(jPanel1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 170, 660, 260));

        txtBuscador.setText("Buscar");
        getContentPane().add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 330, 29));

        comboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Tecnico", "Equipos", "Cliente" }));
        getContentPane().add(comboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 149, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Imprimir");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 130, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proceso", "Pendiente", "Finalizado" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 150, -1));

        imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenMouseClicked(evt);
            }
        });
        getContentPane().add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 25, 25));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Estado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Area");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscador");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel4.setText("Clientes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 184, -1, 0));

        lblWallPaper.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenMouseClicked
      
      

        try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "select * from usuarios where username = '"+txtBuscador+"'");
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_imagenMouseClicked

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
            java.util.logging.Logger.getLogger(Gestionar_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboArea;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JLabel lblWallPaper2;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane sp2;
    private javax.swing.JScrollPane sp3;
    private javax.swing.JScrollPane sp4;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    private javax.swing.JTable tabla3;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
