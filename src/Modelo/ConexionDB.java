package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    // Datos de conexión a la base de datos barber_shop
    private static final String URL = "jdbc:mysql://localhost:3306/barber_shop";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private Connection conexion;

    public ConexionDB() {
        try {
            // Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    

