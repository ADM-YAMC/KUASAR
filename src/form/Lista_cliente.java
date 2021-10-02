/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static form.Gestionar_Cliente.update;
import java.awt.Image;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex carrera
 */
public class Lista_cliente extends javax.swing.JFrame {
  DefaultTableModel model = new DefaultTableModel();
  String foto = "", user;
    public Lista_cliente() {
        user = login.user;
        initComponents();
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
                    dispose();
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        sp.setViewportView(tabla);

        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 780, 180));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Crear reporte PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 150, -1));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 819, 401));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Desktop/ListaClientes.pdf"));

             com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/kuasar.jpg");//incertando imagen 
            header.scaleToFit(560, 250);//TAMAÑO DE IMAGEN
            header.setAlignment(Chunk.ALIGN_LEFT);//POSICION DE IMAGEN

            Paragraph parrafo = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
             parrafo.add(" \n \n");
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);//POSICION DE PARRAFO
            parrafo.add("Lista de Clientes. \n \n");//AGREGANDO ELEMENTOS AL PARRAFO
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);//CREANDDO TABLA E INCERTANDO NOMBRE DE CAMPOS
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("email");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");

            try {
                Connection cn = conexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        //INCERTANDO CONTENIDO A LA TABLA CLIENTE 
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());

                    documento.add(tabla);//AGREGAR DATOS A LA TABLA
                }

            } catch (SQLException e) {
                System.err.print("¡¡ERROR AL OBTENER LISTA DE CLIENTE!! " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");

        } catch (DocumentException | IOException e) {
            System.err.print("¡¡ERROR EN PDF O RUTA DE IMAGEN!! " + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL GENERAR PDF!!, contacte al Administrador");

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
            java.util.logging.Logger.getLogger(Lista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
