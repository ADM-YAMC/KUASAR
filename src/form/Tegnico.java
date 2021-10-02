
package form;

import alertas.AlertWarningSalir;
import clases.conexion;
import static form.Administrador.foto_user;
import graficas.Grafica;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tegnico extends javax.swing.JFrame {

   String user, nombre,foto="";
    int sesion;
    
    public Tegnico() {
        initComponents();
         user = login.user;
        sesion = Administrador.sesion;
        
        
        setLocationRelativeTo(null);
         setTitle("Tecnico = "+ user);
           setExtendedState(6);
          
          
                 try {
             Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select imagen,imagen_usuario from usuarios where username = '"+user+"'");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               foto = rs.getString("imagen");
               foto_user= rs.getString("imagen_usuario");
           
               
               }
               if(foto == null || foto.isEmpty()){
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
               if(foto_user.isEmpty()){
                     ImageIcon wall = new ImageIcon("src/imagenes/success.png");
        
        Icon icono = new ImageIcon(wall.getImage().getScaledInstance(icono_usuario.getWidth(),icono_usuario.getHeight(),Image.SCALE_DEFAULT));
        icono_usuario.setIcon(icono);
               }else{
                   ImageIcon wall = new ImageIcon(foto_user);
        
        Icon icono = new ImageIcon(wall.getImage().getScaledInstance(icono_usuario.getWidth(),icono_usuario.getHeight(),Image.SCALE_DEFAULT));
        icono_usuario.setIcon(icono);
               }
        } catch (Exception e) {
        }
        this.repaint();
        
        
         try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                "select nombre_usuario from usuarios where username = '"+user+"'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre_usuario");
                lblNombre.setText(nombre+" Bienvenid@ a Kuasar Sr.                                             Tecnico ");
            } 
                       
        } catch (SQLException e) {
            System.err.println("Error de conexion desde Tecnico "+e);
        }       
    }
    
    
    
    @Override
    public Image getIconImage(){
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        icono_usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnIngreso = new javax.swing.JButton();
        btnReparado = new javax.swing.JButton();
        btnNoReparado = new javax.swing.JButton();
        btnRevicion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        jLabel6 = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        cambiar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tecnico");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 780, 40));

        icono_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icono_usuarioMousePressed(evt);
            }
        });
        getContentPane().add(icono_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kuasar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 330, 210));

        btnIngreso.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 80));

        btnReparado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnReparado.setFocusable(false);
        getContentPane().add(btnReparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 90));

        btnNoReparado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnNoReparado.setFocusable(false);
        getContentPane().add(btnNoReparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 90));

        btnRevicion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRevicion.setFocusable(false);
        getContentPane().add(btnRevicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 100, 90));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Equipos de nuevo ingreso");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Equipos reparados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Equipos no reparados");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Equipos en revicion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        rSLabelHora1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        getContentPane().add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 120, 60));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Republica Dominicana");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 14, -1, 30));

        lblWallPaper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblWallPaperMousePressed(evt);
            }
        });
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 690));

        jMenuBar1.setMinimumSize(new java.awt.Dimension(58, 41));

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apoyo-tecnico.png"))); // NOI18N
        menuUsuario.setText("Gestion de Equipos");
        menuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUsuarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuUsuario);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        jMenu2.setText("Tabla de Estatus");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grafica.png"))); // NOI18N
        jMenu3.setText("Graficas de Marcas");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/confi.png"))); // NOI18N
        jMenu5.setText("Configuracion");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu5MousePressed(evt);
            }
        });

        cambiar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cambiar.setText("Cambiar session");
        cambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cambiarMousePressed(evt);
            }
        });
        cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarActionPerformed(evt);
            }
        });
        jMenu5.add(cambiar);

        jMenuItem1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem1.setText("Cambiar Contraseña");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem3.setText("Cambiar username");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem4.setText("Cambiar fondo");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem5.setText("Cambiar foto de perfil");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem5MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        jMenu6.setText("Acerca de");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu6MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsuarioMouseClicked
     new Gestionar_Cliente().setVisible(true);
  
    }//GEN-LAST:event_menuUsuarioMouseClicked

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
 AlertWarningSalir salir = new AlertWarningSalir(this, false);
        salir.titulo.setText("¿ESTAS SEGURO DE SALIR?");
        salir.setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void cambiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarMousePressed
  new alertas.AlertWarningCambiar(this, false).setVisible(true);
    }//GEN-LAST:event_cambiarMousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
       Gestionar_Equipo ventana = new Gestionar_Equipo();
       ventana.setVisible(true);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
     new ModificarPassword().setVisible(true);
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
     new Grafica().setVisible(true);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
      new Act_username().setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        new Actualizar_fonto().setVisible(true);
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MousePressed
   
    }//GEN-LAST:event_jMenu5MousePressed

    private void jMenu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MousePressed
      new Acerca_de().setVisible(true);
    }//GEN-LAST:event_jMenu6MousePressed

    private void jMenuItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MousePressed
     new Act_foto_user().setVisible(true); 
    }//GEN-LAST:event_jMenuItem5MousePressed

    private void lblWallPaperMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWallPaperMousePressed
      
        String Reparado, ingreso, noreparado="",revicion="";
        try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "SELECT COUNT(id_equipo) as reparados FROM equipos WHERE estatus = 'Reparado'  ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               Reparado = rs.getString("reparados");
              btnReparado.setText(Reparado);
               }
        } catch (Exception e) {
        }
          try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "SELECT COUNT(id_equipo) as ingreso FROM equipos WHERE estatus = 'Nuevo ingreso' ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               ingreso = rs.getString("ingreso");
              btnIngreso.setText(ingreso);
               }
        } catch (Exception e) {
        }
           try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "SELECT COUNT(id_equipo) as nreparado FROM equipos WHERE estatus = 'No reparado' ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
              noreparado = rs.getString("nreparado");
            btnNoReparado.setText(noreparado);
               }
               if(noreparado.isEmpty()){
                  btnNoReparado.setText("0");
               }
        } catch (Exception e) {
        }
             try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "SELECT COUNT(id_equipo) as revicion FROM equipos WHERE estatus = 'En rebicio' ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
              revicion = rs.getString("revicion");
          btnRevicion.setText(revicion);
               }
               if(revicion.isEmpty()){
                    btnRevicion.setText("0");
               }
        } catch (Exception e) {
        }
             
    }//GEN-LAST:event_lblWallPaperMousePressed

    private void icono_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_usuarioMousePressed
       new Foto().setVisible(true);
    }//GEN-LAST:event_icono_usuarioMousePressed

    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambiarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tegnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JButton btnNoReparado;
    private javax.swing.JButton btnReparado;
    private javax.swing.JButton btnRevicion;
    private javax.swing.JMenuItem cambiar;
    private javax.swing.JLabel icono_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JMenu menuUsuario;
    private rojeru_san.RSLabelHora rSLabelHora1;
    // End of variables declaration//GEN-END:variables
}
