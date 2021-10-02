
package form;

import alertas.AlertWarningSalir;
import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Alex Carrera
 */
public class Administrador extends javax.swing.JFrame {

    String user, nombre,foto="",usuarios,cliente,equipo;
    public static int sesion;
   public static String foto_user;
    public Administrador() {
        initComponents();
        user = login.user;
        sesion = 1;

        setTitle("Administrador = " + user);

        setExtendedState(6);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
                    "select nombre_usuario from usuarios where username ='" + user + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre_usuario");
                lblNombre.setText(nombre +" Bienvenid@ a Kuasar Sr.                                                  Administrador");
            }

        } catch (SQLException e) {
            System.err.println("Error de conexion desde administrador" + e);
        }
        //CONSULTAS PARA CALCULAR LA CANTIDAD DE USUARIOS, CLIENTES Y EQUIPOS
        try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select count( id_usuario) as usuarios from usuarios WHERE estatus = 'Activo' ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               usuarios = rs.getString("usuarios");
              btnUsuarios.setText(usuarios);
               }
        } catch (Exception e) {
        }
         try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select count( id_cliente) as cliente from clientes  ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               cliente = rs.getString("cliente");
              btnClientes.setText(cliente);
               }
        } catch (Exception e) {
        }
          try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select count( id_equipo) as equipos from equipos");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               equipo = rs.getString("equipos");
              btnEquipos.setText(equipo);
               }
        } catch (Exception e) {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        lblNombre = new javax.swing.JLabel();
        icono_usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnEquipos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        lblWallPaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        cambiar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setBackground(new java.awt.Color(51, 255, 255));
        setExtendedState(6);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 820, 40));

        icono_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icono_usuarioMousePressed(evt);
            }
        });
        getContentPane().add(icono_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kuasar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 330, 180));

        btnUsuarios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, 100));

        btnClientes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 130, 90));

        btnEquipos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(btnEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 130, 100));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuarios registrados");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Clientes registrados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Equipos registrados");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 355, -1, 20));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Republica Dominicana");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 14, -1, 30));

        rSLabelHora1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        getContentPane().add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

        lblWallPaper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblWallPaperMousePressed(evt);
            }
        });
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 690));

        jMenuBar1.setMinimumSize(new java.awt.Dimension(58, 41));

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        menuUsuario.setText("Registrar Usuarios");
        menuUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        menuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuUsuarioMousePressed(evt);
            }
        });
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuUsuario);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mantenimiento.png"))); // NOI18N
        jMenu2.setText("Editar usuarios ");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/movimiento.png"))); // NOI18N
        jMenu3.setText("Area supervisor");
        jMenu3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mantenimiento2.png"))); // NOI18N
        jMenu4.setText("Area tegnico");
        jMenu4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagos.png"))); // NOI18N
        jMenu1.setText("Nomina");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/confi.png"))); // NOI18N
        jMenu5.setText("Configuracion");
        jMenu5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        cambiar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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

        jMenuItem3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem3.setText("cambiar contraseña");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem4.setText("Cambiar Usuario");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem7.setText("Cambiar fondo");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem7MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem8.setText("Cambiar foto de perfil");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem8MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
        jMenu6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu6MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  Registro_Usuario rg;
    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
        new Registro_Usuario().setVisible(true);


    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void menuUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsuarioMousePressed
        rg = new Registro_Usuario();
        rg.setVisible(true);
        rg.setLocation(255, 140);


    }//GEN-LAST:event_menuUsuarioMousePressed

    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cambiarActionPerformed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed

         AlertWarningSalir salir = new AlertWarningSalir(this, false);
        salir.titulo.setText("¿ESTAS SEGURO DE SALIR?");
        salir.setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void cambiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarMousePressed

       new alertas.AlertWarningCambiar(this, false).setVisible(true);
    }//GEN-LAST:event_cambiarMousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        Editar_Usuarios eu = new Editar_Usuarios();
        eu.setVisible(true);
        eu.setLocation(255, 140);
        
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        Ventana_Supervisor ventana = new Ventana_Supervisor();
        ventana.setVisible(true);
     
       
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
     new Ventana_Tecnico().setVisible(true);
    }//GEN-LAST:event_jMenu4MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
       new ModificarPassword().setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
      new Act_username().setVisible(true);
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
      new Pago_Usuarios().setVisible(true);
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenuItem7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MousePressed
       new Actualizar_fonto().setVisible(true);
    }//GEN-LAST:event_jMenuItem7MousePressed

    private void icono_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono_usuarioMousePressed
        new Foto().setVisible(true);
    }//GEN-LAST:event_icono_usuarioMousePressed

    private void jMenuItem8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MousePressed
      new Act_foto_user().setVisible(true);
    }//GEN-LAST:event_jMenuItem8MousePressed

    private void jMenu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MousePressed
  new Acerca_de().setVisible(true);
    }//GEN-LAST:event_jMenu6MousePressed

    private void lblWallPaperMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWallPaperMousePressed
      try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select count( id_usuario) as usuarios from usuarios WHERE estatus = 'Activo' ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               usuarios = rs.getString("usuarios");
              btnUsuarios.setText(usuarios);
               }
        } catch (Exception e) {
        }
       try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select count( id_cliente) as cliente from clientes  ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               cliente = rs.getString("cliente");
              btnClientes.setText(cliente);
               }
        } catch (Exception e) {
        }
          try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "select count( id_equipo) as equipos from equipos");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
               equipo = rs.getString("equipos");
              btnEquipos.setText(equipo);
               }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblWallPaperMousePressed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        new Editar_Usuarios().setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
         new Gestionar_Cliente().setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposActionPerformed
       new Gestionar_Equipo().setVisible(true);
    }//GEN-LAST:event_btnEquiposActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEquipos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JMenuItem cambiar;
    private javax.swing.JLabel icono_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JMenu menuUsuario;
    private rojeru_san.RSLabelHora rSLabelHora1;
    // End of variables declaration//GEN-END:variables
}
