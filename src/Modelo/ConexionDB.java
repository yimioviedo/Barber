package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Constantes para los datos de conexión a la base de datos barber_shop
    private static final String URL = "jdbc:mysql://localhost:3306/barber_shop/cliente/producto"; // URL de la base de datos
    private static final String USER = "root"; // Usuario de la base de datos
    private static final String PASS = ""; // Contraseña de la base de datos
    
    // Método estático para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        // Devuelve una nueva conexión a la base de datos usando los datos proporcionados
        return DriverManager.getConnection(URL, USER, PASS);
    }
}