/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import clases.conexion;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.WindowConstants;

public class Informacion_Equipo extends javax.swing.JFrame {
    
    String user = "", cliente = "",correo="",foto="",tipo_equipo,estado;
    int updateCliente = 0, id_equipo = 0;
    
    public Informacion_Equipo() {
        initComponents();
        
        user = login.user;
        id_equipo = Informacion_Cliente.id_equipo;
        updateCliente = Gestionar_Cliente.update;
        
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

        //Crear conexion para el nombre de la ventana
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(
                    "select nombre,mail_cliente from clientes where id_cliente = '" + updateCliente + "'");
              
               
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                setTitle("Informacion del equipo " + rs.getString("nombre") + " - Sesion de " + user);//TITULO DE LA VENTANA
                lblTitulo.setText(" Informacion del cliente " + rs.getString("nombre"));
                      
                
                txtNombreCliente.setText(rs.getString("nombre"));
                cliente = rs.getString("nombre");
                correo =  rs.getString("mail_cliente");
                
            }
             PreparedStatement pst = cn.prepareStatement(
                    "select rol, estatus from usuarios  where username = '" + user + "'");
              ResultSet rsr = pst.executeQuery();
               if(rsr.next()){
               
                 String rol = rsr.getString("rol");
                    String estatus = rsr.getString("estatus");
                      
                    if (rol.equalsIgnoreCase("Supervisor") && estatus.equalsIgnoreCase("Activo")) {

                      Comentarios.setEditable(false);
                      txtnotir.setEnabled(false); 
                      //selectEstatus.setVisible(false);
                            lblestado.setVisible(true);
                         
                            
                            
                    } else if (rol.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                         Comentarios.setEditable(true);
                          selectEstatus.setVisible(true);
                          lblestado.setVisible(false);
                       String valor = (String)selectEstatus.getSelectedItem();
                         if(valor.equalsIgnoreCase("Reparado")){
                           txtnotir.setEnabled(true); 
                         }else{
                           // txtnotir.setEnabled(false); 
                         }
                         

                    }
               }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar nombre del cliente" + e);
        }

        //CREAR CONEXION PARA LLENAR LOS CAMPOS DE LA VENTANA
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement ps = cn.prepareStatement(
                    "select * from equipos where id_equipo = '" + id_equipo + "'");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                tipo_equipo =rs.getString("tipo_equipo");
                selectTipoEquipo.setSelectedItem(rs.getString("tipo_equipo"));
                selectMarca.setSelectedItem(rs.getString("marca"));
              
                selectEstatus.setSelectedItem(rs.getString("estatus"));
              estado =  rs.getString("estatus");
                 lblestado.setText(estado);
                 txtCosto.setText(rs.getString("costo_reparacion"));
                txtModelo.setText(rs.getString("modelo"));
                txtNumeroSerie.setText(rs.getString("num_serie"));
                txtUlt_Modificacion.setText(rs.getString("modificacion"));

                //AGREGANDO FECHA DE INGRESO
                String dia = "", mes = "", annio = "";
                dia = rs.getString("ingreso");
                mes = rs.getString("mes_ingreso");
                annio = rs.getString("annio_ingreso");
                txtFecha.setText(dia + "/" + mes + "/" + annio);
                
                Observaciones.setText(rs.getString("observaciones"));
                Comentarios.setText(rs.getString("comentarios"));
                
                lblTecnico.setText("Comentarios y actualizaciones del tecnico: " + rs.getString("revicion_tecnica"));
            }
            
        } catch (Exception e) {
            System.err.println("Error al consultar la informacion del equipo" + e);
        }
        
        setTitle("Equipo del cliente " + cliente);
        setSize(670, 530);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
            try {
                Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select estatus from equipos where id_equipo ='"+id_equipo+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            estado = rs.getString(1);
            }
        } catch (SQLException e) {
        }
        if("Entregado".equals(estado)){
          new alertas.AlertErrorEntregado(this, true).setVisible(true);
          btnCorreo.setEnabled(false);
          btnActualizar.setEnabled(false);
          btnNoReparado.setEnabled(false);
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

        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTecnico = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        selectTipoEquipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Observaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Comentarios = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnCorreo = new javax.swing.JButton();
        txtnotir = new javax.swing.JButton();
        btnNoReparado = new javax.swing.JButton();
        selectEstatus = new javax.swing.JComboBox<>();
        lblestado = new javax.swing.JLabel();
        selectMarca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUlt_Modificacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Informacion del Equipo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 590, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del cliente: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de ingreso:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estatus");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Daños reportados y observaciones");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        lblTecnico.setForeground(new java.awt.Color(255, 255, 255));
        lblTecnico.setText("Comentarios y actualizacion");
        getContentPane().add(lblTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        txtNombreCliente.setBackground(new java.awt.Color(102, 204, 255));
        txtNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtNombreCliente.setEnabled(false);
        getContentPane().add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, 30));

        txtFecha.setBackground(new java.awt.Color(102, 204, 255));
        txtFecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setEnabled(false);
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 170, 30));

        selectTipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Celular" }));
        getContentPane().add(selectTipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jScrollPane1.setWheelScrollingEnabled(false);
        jScrollPane1.setViewportView(Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 300, 90));

        jScrollPane2.setWheelScrollingEnabled(false);

        Comentarios.setEditable(false);
        jScrollPane2.setViewportView(Comentarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 300, 90));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar Equipo");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 140, 30));

        btnCorreo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCorreo.setText("Correo al cliente");
        btnCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 130, 30));

        txtnotir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtnotir.setText("Notificar reparado");
        txtnotir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnotirActionPerformed(evt);
            }
        });
        jPanel1.add(txtnotir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 160, 30));

        btnNoReparado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNoReparado.setText("Notificar no reparado");
        btnNoReparado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoReparadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNoReparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 160, 30));

        selectEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado", " " }));
        selectEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEstatusActionPerformed(evt);
            }
        });
        jPanel1.add(selectEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        lblestado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblestado.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 120, 20));

        selectMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HP", "Lenovo", "Dell", "Samsung", "Acer", "Toshiba", "Apple", "Motorola", " " }));
        jPanel1.add(selectMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtModelo.setBackground(new java.awt.Color(102, 204, 255));
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtModeloKeyPressed(evt);
            }
        });
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 250, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Numero de serie:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txtNumeroSerie.setBackground(new java.awt.Color(102, 204, 255));
        txtNumeroSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroSerieKeyPressed(evt);
            }
        });
        jPanel1.add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 30));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ultima modificacion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 20));

        txtUlt_Modificacion.setBackground(new java.awt.Color(102, 204, 255));
        txtUlt_Modificacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtUlt_Modificacion.setEnabled(false);
        txtUlt_Modificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUlt_ModificacionActionPerformed(evt);
            }
        });
        jPanel1.add(txtUlt_Modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 250, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Costo de la reparacion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 250, 30));
        jPanel1.add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 750, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyPressed
        // TODO add your handling code here:
        user = txtModelo.getText().trim();
        if (!user.equals("")) {
            txtModelo.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtModeloKeyPressed

    private void txtNumeroSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroSerieKeyPressed
        // TODO add your handling code here:
        user = txtNumeroSerie.getText().trim();
        if (!user.equals("")) {
            txtNumeroSerie.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNumeroSerieKeyPressed

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        //ACTUALIZAR EQUIPO
        int validacion = 0;
        String tipo_equipo, marca, modelo, num_serie, estatus, observaciones,comentarios,costo,estado = "";
        
        tipo_equipo = selectTipoEquipo.getSelectedItem().toString();
        marca = selectMarca.getSelectedItem().toString();
        estatus = selectEstatus.getSelectedItem().toString();
        costo= txtCosto.getText().trim();
        modelo = txtModelo.getText().trim();
        num_serie = txtNumeroSerie.getText().trim();
        observaciones = Observaciones.getText();
        comentarios = Comentarios.getText();
        
        if (modelo.equals("")) {
            txtModelo.setBackground(Color.red);
            validacion++;
        }
        if (num_serie.equals("")) {
            txtNumeroSerie.setBackground(Color.red);
            validacion++;
        }
        if (observaciones.equals("")) {
            observaciones = "Sin observaciones";
        }
        String value = (String)selectEstatus.getSelectedItem();
        try {
                Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                    "select estatus from equipos where id_equipo ='"+id_equipo+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            estado = rs.getString(1);
            }
        } catch (SQLException e) {
        }
        if("Entregado".equals(estado)){
           new alertas.AlertErrorEntregado(this, true).setVisible(true);
        }else{
        if (validacion == 0) {
            try {
                Connection cn = conexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "update equipos set tipo_equipo=?, marca=?, modelo=?,num_serie=?,costo_reparacion=?, observaciones=?, estatus=?, modificacion=?,comentarios=?,revicion_tecnica=?"
                        + "where id_equipo = '" + id_equipo + "'");
                
                pst.setString(1, tipo_equipo);
                pst.setString(2, marca);
                pst.setString(3, modelo);                
                pst.setString(4, num_serie);
                    pst.setString(5, costo);
                pst.setString(6, observaciones);
                pst.setString(7, value);                
                pst.setString(8, user);    
                   pst.setString(9, comentarios);  
                   if("Reparado".equals(value)  || "Reparado".equals(value)  || "En revision".equals(value)  || "Entregado".equals(value)){
                    pst.setString(10, user);  
                   }else{
                        pst.setString(10, " ");  
                   }
                
                pst.executeUpdate();
                cn.close();
                Limpiar();
                
                txtModelo.setBackground(Color.green);
                txtNumeroSerie.setBackground(Color.green);
                
                 new alertas.AlertSuccessActualizar(this, true).setVisible(true);
                this.dispose();
                
            } catch (SQLException e) {
                System.err.println("Error en la actualizacion del equipo" + e);
                 new alertas.AlertErrorActualizar(this, true).setVisible(true);
                
            }
        } else {
              new alertas.AlertErrorCamposBasios(this, true).setVisible(true);
        }
        
        }
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtnotirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnotirActionPerformed
     Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "kuasarinc@gmail.com";
        String contrasena = "95509550";
        String destinatario = correo;
        String asuntoo = "!Se ha repadado su equpo¡";
        String mensajee = "Hola\n\nSu "+tipo_equipo+" fue reparad@ exitosamente para mas informacion, dirijase asia nuestra oficina para el retiro de su equipo.";
        
        
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
            
            new alertas.AlertSuccessCorreo(this, true).setVisible(true);
              
        } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtnotirActionPerformed

    private void btnCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorreoActionPerformed
       new email().setVisible(true);
    }//GEN-LAST:event_btnCorreoActionPerformed

    private void selectEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEstatusActionPerformed
 String value = (String)selectEstatus.getSelectedItem();
        if("Reparado".equals(value)){
                    txtnotir.setEnabled(true); 
        } else {
                    txtnotir.setEnabled(false); 
        }
        if("No reparado".equals(value)){
              txtnotir.setVisible(false);
              btnNoReparado.setVisible(true);
              txtCosto.setEditable(false);
                txtCosto.setText(" ");
              txtCosto.setText("200");
        }else{
             txtnotir.setVisible(true);
                txtCosto.setEditable(true);
              //  txtCosto.setText(" ");
              btnNoReparado.setVisible(false);
        }
    }//GEN-LAST:event_selectEstatusActionPerformed

    private void btnNoReparadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoReparadoActionPerformed
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "kuasarinc@gmail.com";
        String contrasena = "95509550";
        String destinatario = correo;
        String asuntoo = "😥 No se ha podido reparar su equipo 😥";
        String mensajee = "Hola\n\nSu "+tipo_equipo+" no puedo ser reparados por inconvenientes graves en el hatware del equipo, dirijase asia nuestra oficina para el retiro de su equipo.";
        
        
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
            
             new alertas.AlertSuccessCorreo(this, true).setVisible(true);
              
        } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNoReparadoActionPerformed

    private void txtUlt_ModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUlt_ModificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUlt_ModificacionActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Comentarios;
    private javax.swing.JTextPane Observaciones;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCorreo;
    private javax.swing.JButton btnNoReparado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTecnico;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JLabel lblestado;
    private javax.swing.JComboBox<String> selectEstatus;
    private javax.swing.JComboBox<String> selectMarca;
    private javax.swing.JComboBox<String> selectTipoEquipo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtUlt_Modificacion;
    private javax.swing.JButton txtnotir;
    // End of variables declaration//GEN-END:variables
public void Limpiar() {
        txtModelo.setText("");
        txtNumeroSerie.setText("");
    }
    
}
