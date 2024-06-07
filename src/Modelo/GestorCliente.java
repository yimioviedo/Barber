package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class GestorCliente {
    
    // Método para consultar  clientes basados en un parámetro específico
    public LinkedList<Cliente> getClienteByParametro(int parametro, String valor) {
        LinkedList<Cliente> clientes = new LinkedList<>();
        String query = "SELECT * FROM Cliente WHERE ";
        // Construcción de la consulta SQL basada en el parámetro  
        switch (parametro) {
            case 1:
                query += "id = ?";
                break;
            case 2:
                query += "nombre LIKE ?";
                valor = "%" + valor + "%";
                break;
            case 3:
                query += "apellido LIKE ?";
                valor = "%" + valor + "%";
                break;
            case 4:
                query += "telefono LIKE ?";
                valor = "%" + valor + "%";
                break;
            case 5:
                query += "email LIKE ?";
                valor = "%" + valor + "%";
                break;
            default:
                query += "1 = 1"; // No filter
        }
        // Ejecución de la consulta
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            if (parametro > 0) {
                // Asignación del valor al parámetro correspondiente según el tipo de dato
        if (parametro == 1) {
            ps.setInt(1, Integer.parseInt(valor)); // Para el parámetro ID
        } else {
            ps.setString(1, valor); // Para los demás parámetros de tipo String
        }
    }
            try (ResultSet rs = ps.executeQuery()) {
                 // Procesamiento del resultado de la consulta
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("telefono"),
                            rs.getString("email")
                    );
                    clientes.add(cliente); // Agregar el cliente a la lista
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes; // Devolver la lista de clientes
    }
    // Método para registrar un nuevo cliente en la base de datos
    public boolean RegistrarClientes(Cliente cliente) {
        String query = "INSERT INTO Cliente (id, nombre, apellido, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.executeUpdate(); // Ejecutar la inserción
        return true; // Registro exitoso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Registro fallido
        }
    }
    // Método para eliminar un cliente de la base de datos por su ID
    public void eliminarCliente(int id) {
        String query = "DELETE FROM Cliente WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    


    


