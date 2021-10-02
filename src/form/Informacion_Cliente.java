package form;

import java.sql.*;
import clases.conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import static form.Gestionar_Cliente.update;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class Informacion_Cliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int update = 0;
    public static int id_equipo = 0;
    String user,foto="";

    public Informacion_Cliente() {
        initComponents();

        user = login.user;
        update = Gestionar_Cliente.update;

        setSize(731, 509);
        setResizable(false);
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
            Connection cn = conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(
                    "select * from clientes where id_cliente = '" + update + "'");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                setTitle("Informacion del cliente " + rs.getString("nombre") + " - Sesion de " + user);//TITULO DE LA VENTANA
                lblTitulo.setText(" Informacion del cliente " + rs.getString("nombre"));

                txtNombre.setText(rs.getString("nombre"));
                txtEmail.setText(rs.getString("mail_cliente"));
                txtTelefono.setText(rs.getString("tel_cliente"));
                txtDireccion.setText(rs.getString("dir_cliente"));
                lblUltimaModificaion.setText(rs.getString("ult_modificacion"));
                
            }
               PreparedStatement pst = cn.prepareStatement(
                    "select rol, estatus from usuarios  where username = '" + user + "'");
              ResultSet rsr = pst.executeQuery();
               if(rsr.next()){
               
                 String rol = rsr.getString("rol");
                    String estatus = rsr.getString("estatus");

                    if (rol.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                             txtEmail.setEditable(false);
                           txtNombre.setEditable(false);
                             txtTelefono.setEditable(false);
                               txtDireccion.setEditable(false);
                               btnreporte.setVisible(false);
                               btnActualizar.setVisible(false);
                               jButton2.setVisible(false);
                             
                    } 
               }
            
            cn.close();
        } catch (Exception e) {
            System.err.println("Error de conexion desde Supervsor" + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL CARGAR!!, Contacte al administrador");

        }
        //Crear conexion para motrar tabla de los equipos
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + update + "'");
            ResultSet rs = ps.executeQuery();

            tabla = new JTable(model);

            model.addColumn("ID Equipo ");
            model.addColumn(" Tipo Equipo");
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
            
            cn.close(); 
        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla equipo" + e);
        }

        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int column = 0;
                
                if (fila > -1) {
                    id_equipo = (int) model.getValueAt(fila, column);
                    
                    Informacion_Equipo ventana = new Informacion_Equipo();
                    ventana.setVisible(true);
                    
                }
            }
        });
    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        lblUltimaModificaion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnreporte = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Correo", "Telefono", "Direccion", "Registro"
            }
        ));
        tabla.setName(""); // NOI18N
        sp.setViewportView(tabla);

        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 370, 150));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Equipos registrados del Cliente");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 680, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtNombre.setBackground(new java.awt.Color(102, 204, 255));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 250, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        txtEmail.setBackground(new java.awt.Color(102, 204, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 60, 20));

        txtTelefono.setBackground(new java.awt.Color(102, 204, 255));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 250, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ultima Modficacion :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        txtDireccion.setBackground(new java.awt.Color(102, 204, 255));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 250, 30));

        btnActualizar.setText("Actualizar Cliente");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 230, 30));

        lblUltimaModificaion.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        getContentPane().add(lblUltimaModificaion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 220, 50));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirreccion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        btnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        btnreporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnreporteMouseClicked(evt);
            }
        });
        getContentPane().add(btnreporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        jButton2.setText("Registrar Equipo");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 230, 30));

        lblWallPaper.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblWallPaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
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
                        "update clientes set nombre=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ult_modificacion=?"
                        + "where id_cliente = '" + update + "'");

                ps.setString(1, nombre);
                ps.setString(2, email);
                ps.setString(3, telefono);
                ps.setString(4, direccion);
                ps.setString(5, login.user);

                ps.executeUpdate();
                cx.close();
                limpiar();

                txtNombre.setBackground(Color.green);
                txtEmail.setBackground(Color.green);
                txtTelefono.setBackground(Color.green);
                txtDireccion.setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "En hora buena!, Se ha actualizado el Cliente ");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en la actualizacion" + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR AL ACTUALIZAR CLIENTE!!, contacte al administrador. ");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos!. Hay campos vacios. Por favor llenalos para hacer el registro ");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        user = txtNombre.getText().trim();
        if (!user.equals("")) {
            txtNombre.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:  user = txtUsuario.getText().trim();
        user = txtEmail.getText().trim();
        if (!user.equals("")) {
            txtEmail.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
        user = txtTelefono.getText().trim();
        if (!user.equals("")) {
            txtTelefono.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        user = txtDireccion.getText().trim();
        if (!user.equals("")) {
            txtDireccion.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtDireccionKeyPressed
            //CREAR PDF 
    private void btnreporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreporteMouseClicked

        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Desktop/" + txtNombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/kuasar.jpg");//incertando imagen 
            header.scaleToFit(560, 250);//TAMAÑO DE IMAGEN
            header.setAlignment(Chunk.ALIGN_LEFT);//POSICION DE IMAGEN

            Paragraph parrafo = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
             parrafo.add("\n \n");
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);//POSICION DE PARRAFO
            parrafo.add("Informacion de Cliente. \n \n");//AGREGANDO ELEMENTOS AL PARRAFO
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablacliente = new PdfPTable(5);//CREANDDO TABLA E INCERTANDO NOMBRE DE CAMPOS
            tablacliente.addCell("ID");
            tablacliente.addCell("Nombre");
            tablacliente.addCell("email");
            tablacliente.addCell("Telefono");
            tablacliente.addCell("Direccion");

            try {
                Connection cn = conexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes where id_cliente = '" + update + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        //INCERTANDO CONTENIDO A LA TABLA CLIENTE 
                        tablacliente.addCell(rs.getString(1));
                        tablacliente.addCell(rs.getString(2));
                        tablacliente.addCell(rs.getString(3));
                        tablacliente.addCell(rs.getString(4));
                        tablacliente.addCell(rs.getString(5));
                    } while (rs.next());

                    documento.add(tablacliente);//AGREGAR DATOS A LA TABLA
                }

                Paragraph parrafo2 = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipos Rsgistrados \n \n");//AGREGANDO ELEMENTOS AL PARRAFO
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE

                documento.add(parrafo2);

                PdfPTable tablaEquipo = new PdfPTable(4);
                tablaEquipo.addCell("ID_equipo");
                tablaEquipo.addCell("Tipo");
                tablaEquipo.addCell("Marca");
                tablaEquipo.addCell("Estatus");

                try {
                    Connection cn2 = conexion.getConexion();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_equipo, tipo_equipo,marca,estatus from equipos where id_cliente = '" + update + "'");

                    ResultSet rs2 = pst2.executeQuery();
                    if (rs2.next()) {
                        do {
                            //INCERTANDO CONTENIDO A LA TABLA EQUIPO
                            tablaEquipo.addCell(rs2.getString(1));
                            tablaEquipo.addCell(rs2.getString(2));
                            tablaEquipo.addCell(rs2.getString(3));
                            tablaEquipo.addCell(rs2.getString(4));

                        } while (rs2.next());

                        documento.add(tablaEquipo);//AGREGAR DATOS A LA TABLA
                    }

                } catch (SQLException e) {
                    System.err.print("¡¡ERROR AL OBTENER DATOS DEL EQUIPO! " + e);
                }

            } catch (SQLException e) {
                System.err.print("¡¡ERROR AL OBTENER DATOS DEL CLIENTE!! " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");

        } catch (DocumentException | IOException e) {
            System.err.print("¡¡ERROR EN PDF O RUTA DE IMAGEN!! " + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL GENERAR PDF!!, contacte al Administrador");

        }
    }//GEN-LAST:event_btnreporteMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here
        Registro_Equipo ventana = new Registro_Equipo();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel btnreporte;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUltimaModificaion;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabla;
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
