package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.DBConnection;
import java.sql.Connection;

/**
 *
 * @author Carlos Mario
 */
public class Main {

    public static void main(String[] args) {
        DBConnection conn = DBConnection.GetDBConnection();
        try {
            conn.Connect("empleados");
            System.out.println("La base de datos en la instancia 1 es : " + conn.GetNombreConexion() + " y su referencia es: " + conn.hashCode());
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos 1: " + e.getMessage());
        } finally {
            conn.Disconnect();
        }

        DBConnection conn2 = DBConnection.GetDBConnection();
        try {
            conn2.Connect("nomina");
            System.out.println("La base de datos en la instancia 2 es : " + conn2.GetNombreConexion() + " y su referencia es: " + conn2.hashCode());
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos 2: " + e.getMessage());
        } finally {
            conn2.Disconnect();
        }
    }
}
