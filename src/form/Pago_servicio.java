
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
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex carrera
 */
public class Pago_servicio extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    String user,foto;
    public Pago_servicio() {
        initComponents();
        user = login.user;
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
         tabla = new JTable(model);
           model.addColumn("Id equipo");
                              model.addColumn("Tipo equipo ");
                                             model.addColumn(" Marca");
                                                            model.addColumn(" Modelo");
                                                                           model.addColumn(" IMEI");
                                                                              model.addColumn("Estado");
                                                                                          model.addColumn("Costo reparacion");
                                                                                                         model.addColumn("Tecnico");
                                                                                                         
                                                                                                              sp.setViewportView(tabla);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCorrero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        txtId_equipo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pago de servios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, -1, 29));

        txtCorrero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreroActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorrero, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 130, 260, 28));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 107, 28));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id equipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 182, 107, 26));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id equipo", "Tipo equipo", "Marca", "Modelo", "IMEI", "Estado", "Costo reparacion", "Tecnico"
            }
        ));
        sp.setViewportView(tabla);

        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 226, 790, 140));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Efectuar pago");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 120, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pagos de factura de reparacion de equipos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 500, 30));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 460, 30));
        jPanel1.add(txtId_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 260, 30));

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("Crear factura PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 140, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagos.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 80, 80));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 40, 50));
        jPanel1.add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed
 String id,correo,id_equipo;
    private void txtCorreroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreroActionPerformed
     String  id_equpo,tipo_equipo,marca,modelo,num_serie,estatus,costo_reparacion,revicion_tecnica,in;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           if(txtId_equipo.getText().isEmpty()){
       new alertas.AlertWarning1(this, true).setVisible(true);
        } else{
        
        Properties propiedad = new Properties();
        try {
               Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select id_equipo,tipo_equipo,marca,modelo,num_serie,estatus,costo_reparacion,revicion_tecnica from equipos where id_equipo = '"+txtId_equipo.getText().trim()+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            id_equpo = rs.getString(1);
            tipo_equipo = rs.getString(2);
            marca = rs.getString(3);
            modelo = rs.getString(4);
            num_serie =rs.getString(5);
            estatus = rs.getString(6);
            costo_reparacion = rs.getString(7);
            revicion_tecnica = rs.getString(8);
            }
         
        } catch (SQLException e) {
        }
        if(estatus.equals("Reparado") || estatus.equals("No reparado") || estatus.equals("Entregado")){
               in="Reporte de factura para: "+txtBuscar.getText()+"\n\n"
                + "Nombre del cliente                "+txtBuscar.getText()+"\n"
                + "Tipo de equipo                      " +tipo_equipo+"\n"
                + "Marca                                    " +marca+"\n"
                + "Modelo                                  "+modelo+"\n"
                + "Numero de serie                   "+num_serie+"\n"
                + "Estatus                                  " +estatus+"\n"
                + "Rebicion Tecnica                  " +revicion_tecnica+"\n\n"
                + "Costo de la reparacion del equipo  "+costo_reparacion+  "  Pesos\n\n";
                String notifi;
                 if("No reparado".equals(estatus)){
                  notifi   ="¡Sentimos no poder ver reparado su "+tipo_equipo+"!";
                 }else{
                  notifi ="🎉!Has pagado la reparacion de su equipo¡🥳";
                 } 
          
           
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "kuasarinc@gmail.com";
        String contrasena = "95509550";
        String destinatario = correo;
        String asuntoo = notifi;
        String mensajee = in+"Reporte de factura enviado por: "+user;
        
        
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asuntoo);
            mail.setText(mensajee);
            
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
           new alertas.AlertSuccess1(this, true).setVisible(true);
              
        } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        } else {
          new alertas.AlertInformation2(this, true).setVisible(true);
      
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
       if(txtBuscar.getText().isEmpty()){
         new alertas.AlertInformation1(this, true).setVisible(true);
        }  else{ 
        try {
               Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select id_cliente,mail_cliente from clientes where nombre = '"+txtBuscar.getText().trim()+"'");
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                 new alertas.AlertInformation3(this, true).setVisible(true);
            } else {
                id = rs.getString(1);
                correo = rs.getString(2);
            }
         
            txtCorrero.setText(correo);
        } catch (SQLException e) {
        }
        
        try {
               Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select id_equipo,tipo_equipo,marca,modelo,num_serie,estatus,costo_reparacion,revicion_tecnica from equipos where id_cliente = '"+id+"'");
            ResultSet rs = ps.executeQuery();
              int row = tabla.getRowCount();
           for (int i = row-1; i >=0; i--) {
             model.removeRow(i);
           }
         
               while(rs.next()){
                   id_equipo = rs.getString(1);
                   
               Object[] carga = new Object[8];
                   for (int i = 0; i < 8; i++) {
                       carga[i] = rs.getObject(i+1);
                    
                   }
               model.addRow(carga);
               
               }
               cx.close();
        } catch (SQLException e) {
        }
        
          
        
      }
    }//GEN-LAST:event_jLabel6MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             if(txtId_equipo.getText().isEmpty()){
         new alertas.AlertWarning1(this, true).setVisible(true);
        } else{
        
        try {
               Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select id_equipo,tipo_equipo,marca,modelo,num_serie,estatus,costo_reparacion,revicion_tecnica from equipos where id_equipo = '"+txtId_equipo.getText().trim()+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            id_equpo = rs.getString(1);
            tipo_equipo = rs.getString(2);
            marca = rs.getString(3);
            modelo = rs.getString(4);
            num_serie =rs.getString(5);
            estatus = rs.getString(6);
            costo_reparacion = rs.getString(7);
            revicion_tecnica = rs.getString(8);
            }
         
        } catch (SQLException e) {
        }  
           if(estatus.equals("Reparado") || estatus.equals("No reparado")  || estatus.equals("Entregado")){
                  Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Desktop/Factura "+txtBuscar.getText()+" .pdf"));

           com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/kuasar.jpg");//incertando imagen 
            header.scaleToFit(560, 250);//TAMAÑO DE IMAGEN
          header.setAlignment(Chunk.ALIGN_LEFT);//POSICION DE IMAGEN

            Paragraph parrafo = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
               Paragraph parra = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
                Paragraph parraf = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
                    Paragraph parr = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
            parrafo.add(" \n \n");
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);//POSICION DE PARRAFO
                parra.setAlignment(Paragraph.ALIGN_LEFT);//POSICION DE PARRAFO
                  parraf.setAlignment(Paragraph.ALIGN_CENTER);//POSICION DE PARRAFO
            parrafo.add("Factura\n\n");//AGREGANDO ELEMENTOS AL PARRAFO
           
               parra.add("Reporte de factura para: "+txtBuscar.getText()+"\n\n"
                + "Nombre del cliente:                "+txtBuscar.getText()+"\n"
                + "Tipo de equipo:                      " +tipo_equipo+"\n"
                + "Marca:                                    " +marca+"\n"
                + "Modelo:                                  "+modelo+"\n"
                + "Numero de serie:                   "+num_serie+"\n"
                + "Estatus:                                  " +estatus+"\n"
                + "Rebicion Tecnica:                  " +revicion_tecnica+"\n\n"
                + "Costo de la reparacion del equipo:  "+costo_reparacion+ "  Pesos\n\n");
                 parra.add("Factura creada por "+user);
               System.out.println(in);
                  parra.add("\n\n \n");
                parraf.add("Gracias por preferirnos. Vuelva pronto");//AGREGANDO ELEMENTOS AL PARRAFO
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE
               parra.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE
                 parraf.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE
                   parr.setFont(FontFactory.getFont("Tahoma", 48, Font.BOLD, BaseColor.BLACK));//TIPO DE FUENTE


            documento.open();
             documento.add(header);
            documento.add(parrafo);
               documento.add(parra);
                  documento.add(parraf);

            
            documento.close();
          new alertas.AlertSuccess2(this, true).setVisible(true);

        } catch (DocumentException | IOException e) {
            System.err.print("¡¡ERROR EN PDF O RUTA DE IMAGEN!! " + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR AL GENERAR PDF!!, contacte al Administrador");

        }
       
        } else {
      new alertas.AlertInformation2(this, true).setVisible(true);
           }
             }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Pago_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pago_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pago_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pago_servicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pago_servicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorrero;
    private javax.swing.JTextField txtId_equipo;
    // End of variables declaration//GEN-END:variables
}
