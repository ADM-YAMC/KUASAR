

package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cantidad_equipo_tecnico {

    
    
    public String CantidadNuevo(){
     
          try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "SELECT COUNT(id_equipo) as ingreso FROM equipos WHERE estatus = 'Nuevo ingreso' ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
        rs.getString("ingreso");
               }
        } catch (Exception e) {
        }
         return CantidadNuevo();
    }
    public String CantidadReparado(){
     try {
               Connection cx = conexion.getConexion();
               PreparedStatement ps = cx.prepareStatement(
                       "SELECT COUNT(id_equipo) as reparados FROM equipos WHERE estatus = 'Reparado'  ");
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
            rs.getString("reparados");
            
               }
        } catch (Exception e) {
        }
     return CantidadReparado();
    }
}
