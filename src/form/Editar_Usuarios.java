/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex carrera
 */
public class Editar_Usuarios extends javax.swing.JDialog {

  String user,foto="";
  public static String update="";
  DefaultTableModel model = new DefaultTableModel();
  
    public Editar_Usuarios() {
        initComponents();
          user = login.user;
          
          tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setBackground(new Color(32, 136, 203));
        tabla.getTableHeader().setForeground(new Color(255,255,255));
        tabla.setRowHeight(25);
          
        
          setLocationRelativeTo(null);
          setTitle("Editar de Usuarios = "+ user);
          
           
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
        
        try {
            Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select id_usuario,nombre_usuario,username,email,telefono,rol,estatus from usuarios");
               ResultSet rs = ps.executeQuery();
               tabla = new JTable(model);
               
               model.addColumn("  ");
                              model.addColumn("Nombre ");
                                             model.addColumn(" Usuario");
                                                            model.addColumn(" Correo");
                                                                           model.addColumn(" Telefono");
                                                                                          model.addColumn(" Rol");
                                                                                                         model.addColumn(" Estado");
                                                                                                                       
               
               sp.setViewportView(tabla);
               
               while(rs.next()){
               Object[] carga = new Object[7];
                   for (int i = 0; i < 7; i++) {
                       carga[i] = rs.getObject(i+1);
                       
                   }
               model.addRow(carga);
               
               }
               cx.close();
               
        } catch (SQLException e) {
            System.err.println("Error en cargar la tabla"+e);
        }
        tabla.addMouseListener(new MouseAdapter() {
     
            public void mouseClicked(MouseEvent e){
            int fila = tabla.rowAtPoint(e.getPoint());
            int column = 2;
            if(fila>-1){
                update = (String)model.getValueAt(fila, column);
              informacion info = new informacion();
              info.setVisible(true);
              info.setLocation(255,140);
            }
        } });
    }
     
    public Image getIconImage(){
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 20, 260, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Usuario", "Correo", "Telefono", "Rol", "Estado"
            }
        ));
        tabla.setFocusable(false);
        tabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tabla.setShowVerticalLines(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabla);

        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 860, 230));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 877, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editar_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
