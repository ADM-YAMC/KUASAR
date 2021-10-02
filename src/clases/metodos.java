
package clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class metodos  {

    static void ListaCliente_PDF(){
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Desktop/ListaClientes.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/imagenes/kuasar.jpg");//incertando imagen 
            header.scaleToFit(560, 250);//TAMAÑO DE IMAGEN
            header.setAlignment(Chunk.ALIGN_CENTER);//POSICION DE IMAGEN

            Paragraph parrafo = new Paragraph();//INSTANCIANDO LA CREACION DEL PARRAFO
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
     
    }
    
}
