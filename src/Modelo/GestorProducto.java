package Modelo;

import java.util.LinkedList;
import java.util.List;

public class GestorProducto {
    // Lista dinámica para almacenar los productos
    private static LinkedList<Producto> productos;

    // Constructor para inicializar la lista de productos
    public GestorProducto() {
        productos = new LinkedList<>();
    }

    // Método para registrar un nuevo producto
    public void RegistrarProductos(Producto producto) {
        productos.add(producto);
    }

    // Método para buscar productos por parámetro y valor específicos
    public static List<Producto> getProductobyParametro(int parametro, String valor) {
        // Lista para almacenar los productos que cumplen con el criterio de búsqueda
        List<Producto> resultado = new LinkedList<>();
        // Iterar sobre la lista de productos
        for (Producto prod : productos) {
            // Evaluar el parámetro de búsqueda
            switch (parametro) {
                case 1: // Buscar por ID
                    if (String.valueOf(prod.getId()).equals(valor)) {
                        resultado.add(prod); // Agregar producto si el ID coincide
                    }
                    break;
                case 2: // Buscar por ID del proveedor
                    if (String.valueOf(prod.getProveedorId()).equals(valor)) {
                        resultado.add(prod); // Agregar producto si el ID del proveedor coincide
                    }
                    break;
                case 3: // Buscar por nombre
                    if (prod.getNombreProducto().equals(valor)) {
                        resultado.add(prod); // Agregar producto si el nombre coincide
                    }
                    break;
                case 4: // Buscar por descripción
                    if (prod.getDescripcion().equals(valor)) {
                        resultado.add(prod); // Agregar producto si la descripción coincide
                    }
                    break;
                default:
                    break;
            }
        }
        // Devolver la lista de productos que cumplen con el criterio de búsqueda
        return resultado;
    }

    // Método para eliminar un producto por su ID
    public void eliminarProducto(int id) {
        // Utilizar removeIf para eliminar el producto con el ID específico
        productos.removeIf(producto -> producto.getId() == id);
    }
}
