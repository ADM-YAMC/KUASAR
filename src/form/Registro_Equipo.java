
package form;

import clases.conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Registro_Equipo extends javax.swing.JFrame {

    int update = 0;//ID DEL CLIENTE
    String user = "", cliente = "",foto="";

    public Registro_Equipo() {
        initComponents();
        user = login.user;
        update = Gestionar_Cliente.update;

        setSize(630, 445);
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

        //CONEXION PARA EL NOMBRE DE LA VENTANA..
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre from clientes where id_cliente = '" + update + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cliente = rs.getString("nombre");
            }

        } catch (Exception e) {
            System.err.println("ERROR EN LA CARGA DEL NOMBRE DEL CLIENTE " + e);
        }

        setTitle("Registrar nuevo equipo para " + cliente);

        txtNombre.setText(cliente);//COLOCANDO EL NOMBRE DEL CLIENTE EN EL JTEXTFILE
    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/descarga.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Daños_Observaciones = new javax.swing.JTextPane();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtNumero_Serie = new javax.swing.JTextField();
        select_Tipo_Equipo = new javax.swing.JComboBox<>();
        select_Marca = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(Daños_Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 280, 130));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registro de equipo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 240, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de equipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Numero de serie:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Daño y obsevaciones");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(102, 204, 255));
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 30));

        txtModelo.setBackground(new java.awt.Color(102, 204, 255));
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtModeloKeyPressed(evt);
            }
        });
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 250, 30));

        txtNumero_Serie.setBackground(new java.awt.Color(102, 204, 255));
        txtNumero_Serie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumero_SerieKeyPressed(evt);
            }
        });
        getContentPane().add(txtNumero_Serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 250, 30));

        select_Tipo_Equipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Celular" }));
        getContentPane().add(select_Tipo_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, -1));

        select_Marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HP", "Lenovo", "Dell", "Samsung", "Acer", "Toshiba", "Apple", "Motorola" }));
        getContentPane().add(select_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, -1));

        jButton2.setText("Registrar Equipo");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 230, 30));
        getContentPane().add(lblWallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyPressed
        // TODO add your handling code here:
        user = txtNombre.getText().trim();
        if (!user.equals("")) {
            txtNombre.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtModeloKeyPressed

    private void txtNumero_SerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumero_SerieKeyPressed
        // TODO add your handling code here:
        user = txtNombre.getText().trim();
        if (!user.equals("")) {
            txtNombre.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNumero_SerieKeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:

        int validacion = 0;
        //DECLARANDO VARIABLES A UTILIZAR
        String tipo_equipo, marca, modelo, numero_serie,
                dia_ingreso, mes_ingreso, annio_ingreso,
                estatus, observaciones;

        tipo_equipo = select_Tipo_Equipo.getSelectedItem().toString();
        marca = select_Marca.getSelectedItem().toString();
        modelo = txtModelo.getText().trim();
        numero_serie = txtNumero_Serie.getText().trim();
        observaciones = Daños_Observaciones.getText();
        estatus = "Nuevo Ingreso";

        //INSTANCIANDO EL CALENDARIO
        Calendar calendario = Calendar.getInstance();

        //ASIGNANDO LOS VALORES DEL FECHA DE INGRESO A LAS VARIABLES
        dia_ingreso = Integer.toString(calendario.get(Calendar.DATE));
        mes_ingreso = Integer.toString(calendario.get(Calendar.MONTH));
        annio_ingreso = Integer.toString(calendario.get(Calendar.YEAR));

        //VALIDACION DE LOS JTEXTFIEL
        if (modelo.equals("")) {
            txtModelo.setBackground(Color.red);
            validacion++;
        }
        if (numero_serie.equals("")) {
            txtNumero_Serie.setBackground(Color.red);
            validacion++;
        }
        if (observaciones.equals("")) {
            Daños_Observaciones.setText("Sin Observaciones");
        }

        if (validacion == 0) {

            try {
                Connection cn = conexion.getConexion();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setInt(2, update);
                pst.setString(3, tipo_equipo);
                pst.setString(4, marca);
                pst.setString(5, modelo);
                pst.setString(6, numero_serie);
                pst.setString(7, dia_ingreso);
                pst.setString(8, mes_ingreso);
                pst.setString(9, annio_ingreso);
                pst.setString(10, observaciones);
                pst.setString(11, "");
                  pst.setString(12, estatus);
                pst.setString(13, login.user);//NOMBRE DEL MODIFICADOR
                pst.setString(14, "");
                pst.setString(15, "");

                pst.executeUpdate();
                cn.close();

                txtNumero_Serie.setBackground(Color.GREEN);
                txtModelo.setBackground(Color.GREEN);
                txtNumero_Serie.setText("");
                txtModelo.setText("");
                
                new alertas.AlertSuccess(this, true).setVisible(true);
             
                //JOptionPane.showMessageDialog(null, "En hora buena!, Se ha registrado el usuario");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en el registro" + e);
                 new alertas.AlertError(this, true).setVisible(true);

              //  JOptionPane.showMessageDialog(null, "¡¡ERROR AL REGISTRAR CLIENTE!!, contacte al administrador. ");

            }
        } else {
             new alertas.AlertInformation(this, true).setVisible(true);
          ///  JOptionPane.showMessageDialog(null, "Lo sentimos!. Hay campos vacios. Por favor llenalos para hacer el registro ");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Equipo().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Daños_Observaciones;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JComboBox<String> select_Marca;
    private javax.swing.JComboBox<String> select_Tipo_Equipo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero_Serie;
    // End of variables declaration//GEN-END:variables
}
