
package form;

import clases.Calculo_suerdo;
import clases.conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

/**
 *
 * @author Alex Carrera
 */
public class Pago_Usuarios extends javax.swing.JFrame {
  
    Calculo_suerdo cs = new Calculo_suerdo();
    String p="",user="",in="",enviar="",foto="",email;
      String nombre;
    double a=0,h=0;
    public Pago_Usuarios() {
        user = login.user;
             boolean link;
        initComponents();
        setLocationRelativeTo(null);
               try {
             Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select imagen,email,nombre_usuario from usuarios where username = '"+user+"'");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               foto = rs.getString("imagen");
               email = rs.getString("email");
               nombre = rs.getString("nombre_usuario");
               
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
       ArrayList<String> lista = new  ArrayList<String>();
        String value = (String)comboNombre.getSelectedItem();
        lista = llenar_combo();
        for (int i = 0; i < lista.size(); i++) {
            comboNombre.addItem(lista.get(i));
           // System.out.println(enviar);
        }
       
        
        
    }
  
public static ArrayList<String> llenar_combo(){
ArrayList<String> lista = new  ArrayList<String>();
        try {
             Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              lista.add(rs.getString("nombre_usuario"));
           
            }
           cn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
return lista;
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboNombre = new javax.swing.JComboBox<>();
        comboHoras = new javax.swing.JComboBox<>();
        comboAno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTotal = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        lblNeto = new javax.swing.JLabel();
        lblp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboPuesto = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Puesto: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Antiguedad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Horas Extras");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, 20));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nomina");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 100, -1));

        comboNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        comboNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNombreActionPerformed(evt);
            }
        });
        jPanel1.add(comboNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 210, -1));

        comboHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        comboHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHorasActionPerformed(evt);
            }
        });
        jPanel1.add(comboHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 190, -1));

        comboAno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        comboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });
        jPanel1.add(comboAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 190, -1));

        txtTotal.setColumns(20);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtTotal.setRows(5);
        txtTotal.setFocusable(false);
        jScrollPane1.setViewportView(txtTotal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 750, 270));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Saldo: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        lblNeto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNeto.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(lblNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 120, 50));
        jPanel1.add(lblp, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 50, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 460, 130, -1));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Crear Factura PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 460, 170, -1));

        comboPuesto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        comboPuesto.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(comboPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 210, 20));
        jPanel1.add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Imprimir(){
      
          
        p=enviar;
      
        a=Double.parseDouble(comboAno.getSelectedItem().toString());
         h=Double.parseDouble(comboHoras.getSelectedItem().toString());
    
          cs.setEmpleado(p, h, a);
          
                in ="PERCEPCIONES \t  DEDUCCIONES\n\n"+
                  "Sueldo         \t$"+cs.getSuerdo()+"                  \t  ISRT              \t$"+cs.getIsrt()+"\n"+
                   "Canasta      \t$"+cs.getCanasta()+ "               \t  Salud            \t$"+cs.getSalud()+"\n"+
                   "Apoyo          \t$"+cs.getApoyo()+"                    \t  Afore             \t$"+cs.getAfore()+"\n"+
                   "Asistencia  \t$"+cs.getAsistencia()+"            \t  sisCap          \t$"+cs.getSistema()+"\n"+
                   "Antiguedad \t$"+cs.getAntiguedad()+"          \t  Sind               \t$"+cs.getsindicato()+"\n\n"+
                   "TOTAL          \t$"+cs.getPercepciones()+"     \t  Total               \t$"+cs.getDeduciones()+"\n";
                  txtTotal.setText(in);
                  lblNeto.setText("$ "+cs.getSalarioNeto());
    }
    
    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
          Imprimir();
    }//GEN-LAST:event_comboAnoActionPerformed

    private void comboHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHorasActionPerformed
        Imprimir();
    }//GEN-LAST:event_comboHorasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "kuasarinc@gmail.com";
        String contrasena = "95509550";
        String destinatario = email;
        String asuntoo = "!Su pago del mes fue realizado¡";
        String mensajee = "Hola\n\nSu mensualidad fue depositada en su cuenta mas abajo estara el reporte de su factura\n\n Factura\n\n"+txtTotal.getText();
        
        
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
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
              
        } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
                                         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNombreActionPerformed
       try {
              Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select rol from usuarios where nombre_usuario = '"+comboNombre.getSelectedItem().toString()+"' ");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
             enviar = rs.getString("rol");
            }
         comboPuesto.setText(enviar);
        // comboPuesto=enviar;
        } catch (Exception e) {
        }
    }//GEN-LAST:event_comboNombreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Desktop/Nomina de "+nombre+"  .pdf"));

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
           
               parra.add(in);
                 parra.add("Factura creada por "+user);
               System.out.println(in);
                  parra.add("\n\n \n");
               // parraf.add("Gracias por preferirnos. Vuelva pronto");//AGREGANDO ELEMENTOS AL PARRAFO
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
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Pago_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pago_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pago_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pago_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pago_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAno;
    private javax.swing.JComboBox<String> comboHoras;
    private javax.swing.JComboBox<String> comboNombre;
    private javax.swing.JLabel comboPuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNeto;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JLabel lblp;
    private javax.swing.JTextArea txtTotal;
    // End of variables declaration//GEN-END:variables
}
