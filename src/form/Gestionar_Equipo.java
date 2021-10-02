
package form;

import clases.conexion;

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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A19C38106
 */
public class Gestionar_Equipo extends javax.swing.JFrame {

    String user,foto="";
    public static int Equipo_update = 0;
    DefaultTableModel model = new DefaultTableModel();

    public Gestionar_Equipo() {
        initComponents();

        user = login.user;

        setSize(630, 380);
        setResizable(false);
        setTitle("Tecnico = " + user);
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

        try {
            Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos");
            ResultSet rs = ps.executeQuery();
            tabla = new JTable(model);

            model.addColumn("  ");
            model.addColumn("Tipo ");
            model.addColumn(" Marca");
            model.addColumn(" Estatus");

            sp.setViewportView(tabla);

            while (rs.next()) {
                Object[] carga = new Object[4];
                for (int i = 0; i < 4; i++) {
                    carga[i] = rs.getObject(i + 1);

                }
                model.addRow(carga);
            }
            cx.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar la tabla equipos" + e);
        }
        ObtenerDatos();//METODO DECLARADO AL FINAL DEL PROYECTO
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
        jButton1 = new javax.swing.JButton();
        selectEstatus = new javax.swing.JComboBox<>();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 260, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Correo", "Telefono", "Direccion", "Registro"
            }
        ));
        tabla.setName(""); // NOI18N
        sp.setViewportView(tabla);

        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 600, 150));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Mostrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 160, 30));

        selectEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(selectEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 130, -1));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String seleccion = selectEstatus.getSelectedItem().toString();
        String Query = "";
        
        //LIMPIANDO TABLA 
        model.setRowCount(0);
        model.setColumnCount(0);

        try {

            Connection cn = conexion.getConexion();

            if (seleccion.equalsIgnoreCase("Todos")) {
                Query = "select id_equipo, tipo_equipo, marca, estatus from equipos";
            } else {
                Query = "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus ='" + seleccion + "'";

            }

            PreparedStatement ps = cn.prepareStatement(Query);
            ResultSet rs = ps.executeQuery();

            tabla = new JTable(model);

            model.addColumn("  ");
            model.addColumn("Tipo ");
            model.addColumn(" Marca");
            model.addColumn(" Estatus");

            while (rs.next()) {
                Object[] carga = new Object[4];
                for (int i = 0; i < 4; i++) {
                    carga[i] = rs.getObject(i + 1);

                }
                model.addRow(carga);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar la tabla de equipos" + e);
        }
        
        ObtenerDatos();//METODO DECLARADO AL FINAL DEL PROYECTO
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JComboBox<String> selectEstatus;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void ObtenerDatos() {
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int column = 0;
                if (fila > -1) {
                    Equipo_update = (int) model.getValueAt(fila, column);
              //  new Informacion_Equipo().setVisible(true);

                }
            }
        });
    }
}
