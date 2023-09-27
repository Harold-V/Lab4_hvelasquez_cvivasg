/**
 * @file DBConnection.java
 * @brief Clase para administrar conexiones a bases de datos SQLite.
 */
package co.edu.unicauca.openmarket.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Carlos Mario
 */
/**
 * @class DBConnection
 * @brief Clase para administrar conexiones a bases de datos SQLite.
 */
public class DBConnection {

    /**
     * @brief Instancia única de la clase DBConnection.
     */
    private static DBConnection instancia = new DBConnection();
    /**
     * @brief Nombre de la conexión.
     */
    /**
     * @brief URL de la conexión a la base de datos.
     */
    private String nombreConexion, url;
    /**
     * @brief Conexión a la base de datos.
     */
    private Connection conexion;

    /**
     * @brief Constructor privado de la clase DBConnection. Evita que se creen
     * instancias adicionales de la clase.
     */
    private DBConnection() {
        
    }

    /**
     * @brief Establece una conexión a una base de datos SQLite.
     * @param nombreConexion El nombre de la conexión.
     */
    public void Connect(String nombreConexion) {
        this.nombreConexion = nombreConexion;
        url = "jdbc:sqlite:" + nombreConexion + ".db";
        try {
            // Realiza la conexión a la base de datos.
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Cierra la conexión a la base de datos.
     */
    public void Disconnect() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Obtiene la instancia única de la clase DBConnection.
     * @return La instancia única de la clase DBConnection.
     */
    public static DBConnection GetDBConnection() {
        if (instancia == null) {
            return instancia = new DBConnection();
        }
        return instancia;
    }

    /**
     * @brief Obtiene el nombre de la conexión actual.
     * @return El nombre de la conexión actual.
     */
    public String GetNombreConexion() {
        return nombreConexion;
    }

}
