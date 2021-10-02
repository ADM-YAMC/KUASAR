
package form;

import alertas.AlertInformation;
import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alex Carrera
 */
public class Registro_Usuario extends javax.swing.JDialog {

    String user;
   
    
    
    public Registro_Usuario() {
        initComponents();
         user = login.user;
        
        String foto = "";
        setLocationRelativeTo(null);
          setTitle("Registro de Usuario = "+ user);
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
     
    public Image getIconImage(){
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cargarfoto = new javax.swing.JLabel();
        nad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kuasar--Registro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 250, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 250, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 60, 20));

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 250, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rol:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Supervisor", "Tecnico" }));
        getContentPane().add(cbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 250, 30));

        txtUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("Usuario:");
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 230, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Foto del usuario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Registrar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 230, 30));

        cargarfoto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cargarfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cargarfoto.setText("FOTO");
        cargarfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cargarfoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cargarfotoMousePressed(evt);
            }
        });
        getContentPane().add(cargarfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 230, 160));

        nad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nadMousePressed(evt);
            }
        });
        getContentPane().add(nad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, 80));

        lblWallPaper.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  String nombre, email,telefono,username,pass="1234",permiso_adm;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Icon iconon;
        int permiso, validacion=0;
      
         File b =null;
        
        nombre= txtNombre.getText().trim();
        email = txtEmail.getText().trim();
        telefono = txtTelefono.getText().trim();
        username = txtUser.getText().trim();
       String value=(String)cbRol.getSelectedItem();
       permiso_adm = value;     
         iconon = cargarfoto.getIcon();
        if(nombre.isEmpty() ){
          
            Color rojo=new Color(230, 86, 86);
            txtNombre.setBackground(rojo);
               validacion++;
        }
          if(email.isEmpty() ){
             Color rojo=new Color(230, 86, 86);
            txtEmail.setBackground(rojo);
               validacion++;
        }
            if(telefono.isEmpty() ){
             Color rojo=new Color(230, 86, 86);
            txtTelefono.setBackground(rojo);
               validacion++;
        }
              if(username.isEmpty() ){
             Color rojo=new Color(230, 86, 86);
            txtUser.setBackground(rojo);
               validacion++;
        }
              
                try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "select username from usuarios where username = '"+username+"'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
             Color rojo=new Color(230, 86, 86);
              txtUser.setBackground(rojo);
                JOptionPane.showMessageDialog(null, "Lo sentimos!. El nombre de usuario ya existe en nuestra base de datos");
                cn.close();
            }else{
            cn.close();
                if (validacion == 0) {
                    try {
                         Connection cx = conexion.getConexion();
            PreparedStatement ps = cx.prepareStatement(
                "insert into usuarios values(?,?,?,?,?,?,?,?,?,?,?)");
                        String valor = "Activo";
            ps.setInt(1, 0);
            ps.setString(2,nombre );
              ps.setString(3,email );
                ps.setString(4,telefono );
                  ps.setString(5,username );
                    ps.setString(6,pass );
                     ps.setString(7, null);
                      ps.setString(8,fichero.toString() );
                        ps.setString(9,value );
                        ps.setString(10,"Activo" );
                            ps.setString(11, user);
                              System.err.println(fichero);
                            ps.executeUpdate();
                            cx.close();
                            limpiar();
                             EnviarCorreo();
                             Color verde=new Color(124, 217, 106);
                              txtUser.setBackground(verde);
                              Color verd=new Color(124, 217, 106);
                              txtNombre.setBackground(verd);
                              Color vere=new Color(124, 217, 106);
                              txtEmail.setBackground(vere);
                              Color vede=new Color(124, 217, 106);
                              txtTelefono.setBackground(vede);
                             
                              
                              new alertas.AlertSuccess(null, true).setVisible(true);
             
                              //JOptionPane.showMessageDialog(null, "En hora buena!, Se ha registrado el usuario");
                              this.dispose();
            
                    } catch (SQLException e) {
                        System.err.println("Error en el registro"+e);
                    }
                } else {
                     new alertas.AlertInformation(null,true).setVisible(true);
                   // JOptionPane.showMessageDialog(null, "Lo sentimos!. Hay campos vacios. Por llenalos para hacer el registro ");
                }
                
            }
            
        } catch (SQLException e) {
                    System.err.println("Error al validar"+e);
        }
                
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
  File fichero;
    private void cargarfotoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarfotoMousePressed
    
        int resultado;
        CargarFoto cf = new CargarFoto();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter ("JPG y PNG","jpg","png");
         cf.Jcargar.setFileFilter(filtro);
          
         resultado=cf.Jcargar.showOpenDialog(null);
         
         if(JFileChooser.APPROVE_OPTION == resultado){
           
             fichero = cf.Jcargar.getSelectedFile();
           
             
             try {
                 ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(cargarfoto.getWidth(),cargarfoto.getHeight(),Image.SCALE_DEFAULT));
               
                cargarfoto.setText(null);
                cargarfoto.setIcon(icono);
             } catch (Exception e) {
                 
                 System.err.println(e);
             }
             
             
         }
         
    }//GEN-LAST:event_cargarfotoMousePressed
     File nada;
    private void nadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nadMousePressed
        int resultado;
        CargarFoto cf = new CargarFoto();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter ("JPG y PNG","jpg","png");
         cf.Jcargar.setFileFilter(filtro);
          
         resultado=cf.Jcargar.showOpenDialog(null);
         
         if(JFileChooser.APPROVE_OPTION == resultado){
           
             nada = cf.Jcargar.getSelectedFile();
           
             
             try {
                 ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(nad.getWidth(),nad.getHeight(),Image.SCALE_DEFAULT));
               
                nad.setText(null);
                nad.setIcon(icono);
             } catch (Exception e) {
                 
                 System.err.println(e);
             }
             
             
         }
    }//GEN-LAST:event_nadMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cargarfoto;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JLabel nad;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables

public void limpiar(){
txtNombre.setText("");
txtUser.setText(null);
txtTelefono.setText(null);
txtEmail.setText(null);

}
public void EnviarCorreo(){
  Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "kuasarinc@gmail.com";
        String contrasena = "95509550";
        String destinatario = email;
        String asuntoo = "!Datos de inicio de session¡";
        String mensajee = "Hola\n\nSr. "+nombre+" su usuario para iniciar session en el sistema de la empresa es: '"+username+"'\ny su contraseña por default es: '"+pass+"'\n\n¡Aviso!\n\nAl momento de iniciar "
                + "session con usuario y cotraseña en nuestro sistema\nprocure de cambiar su contraseña de inicio para asi tener mejor seguridad\n\nGracias por comensar a ser parte de nuestra gran familia "+nombre+"\n\n"
                + "Correo enviado por: '"+user+"' ";
        
        
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
            
          //  new alertas.AlertSuccessCorreo(null, true).setVisible(true);
              
        } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.mail.MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
