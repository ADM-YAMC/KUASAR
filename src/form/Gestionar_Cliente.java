
package form;

import clases.conexion;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A19C38106
 */
public class Gestionar_Cliente extends javax.swing.JFrame {

    String user,foto="";
    public static int update = 0;
    DefaultTableModel model = new DefaultTableModel();

    public Gestionar_Cliente() {
        initComponents();

        user = login.user;

        setSize(630, 330);
        setResizable(false);
        setTitle("Supervisor = " + user);
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

        try {
            Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select id_cliente,nombre,mail_cliente,tel_cliente,dir_cliente,ult_modificacion from clientes");
            ResultSet rs = ps.executeQuery();
            tabla = new JTable(model);

            model.addColumn("  ");
            model.addColumn("Nombre ");
            model.addColumn(" Correo");
            model.addColumn(" Telefono");
            model.addColumn(" Direccion");
            model.addColumn(" Registro");

            sp.setViewportView(tabla);

            while (rs.next()) {
                Object[] carga = new Object[6];
                for (int i = 0; i < 6; i++) {
                    carga[i] = rs.getObject(i + 1);

                }
                model.addRow(carga);
            }
            cx.close();
        } catch (Exception e) {
            System.err.println("Error en cargar la tabla" + e);
        }
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int column = 0;
                if (fila > -1) {
                    update = (int) model.getValueAt(fila, column);
                    Informacion_Cliente ventana = new Informacion_Cliente();
                    ventana.setVisible(true);
                }
            }
        });
    }

    public Image getIconImage() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 260, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Correo", "Telefono", "Direccion", "Registro"
            }
        ));
        tabla.setName(""); // NOI18N
        sp.setViewportView(tabla);

        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 600, 150));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Cliente().setVisible(true);
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
