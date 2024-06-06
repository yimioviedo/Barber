package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class GestorProducto {

    // Método para consultar productos basados en un parámetro específico
    public LinkedList<Producto> getProductoByParametro(int parametro, String valor) {
        LinkedList<Producto> productos = new LinkedList<>();
        String query = "SELECT * FROM Producto WHERE ";

        // Construcción de la consulta SQL basada en el parámetro        
        switch (parametro) {
            case 1:
                query += "id = ?";
                break;
            case 2:
                query += "proveedorId =  ?";
                break;
            case 3:
                query += "nombreProducto LIKE ?";
                valor = "%" + valor + "%";
                break;
            case 4:
                query += "descripcion LIKE ?";
                valor = "%" + valor + "%";
                break;
            case 5:
                query += "precio = ?";
                break;
            case 6:
                query += "stock = ?";
                break;
            default:
                query += "1 = 1"; // No filter
        }
        
        // Ejecución de la consulta
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            if (parametro > 0) {
                // Asignación del valor al parámetro correspondiente
                switch (parametro) {
                    case 1:
                    case 2:
                    case 6:
                        ps.setInt(1, Integer.parseInt(valor)); // Conversión a int para id, proveedorId y stock
                        break;
                    case 5:
                        ps.setDouble(1, Double.parseDouble(valor)); // Conversión a double para precio
                        break;
                    default:
                        ps.setString(1, valor); // Para otros parámetros, usar valor como String
                        break;
                }
            }
            try (ResultSet rs = ps.executeQuery()) {
                // Procesamiento del resultado de la consulta
                while (rs.next()) {
                    Producto producto = new Producto(
                            rs.getInt("id"),
                            rs.getInt("proveedorId"),
                            rs.getString("nombreProducto"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getInt("stock")
                    );
                    productos.add(producto); // Agregar el producto a la lista
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos; // Devolver la lista de productos
    }

    // Método para registrar un nuevo producto en la base de datos
    public void RegistrarProductos(Producto producto) {
        String query = "INSERT INTO Producto (id, proveedorId, nombreProducto, descripcion, precio, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, producto.getId());
            ps.setInt(2, producto.getProveedorId());
            ps.setString(3, producto.getNombreProducto());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.executeUpdate(); // Ejecutar la inserción
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un producto de la base de datos por su ID
    public void eliminarProducto(int id) {
        String query = "DELETE FROM Producto WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id); // Asignación del ID del producto a eliminar
            ps.executeUpdate(); // Ejecutar la eliminación
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
