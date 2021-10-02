package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jeremy R.
 */
public class conexion {

    public static Connection getConexion() {

        try {

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kuasar_System?useUnicode=true&useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("conectado");
            return cn;
        } catch (SQLException e) {
            System.err.println("Error en la conexion" + e);
        }
        return (null);
    }
}
