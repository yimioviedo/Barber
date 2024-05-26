package Modelo;

import java.util.LinkedList;

public class GestorProducto {
    private static LinkedList<Producto> productos;

    public GestorProducto() {
        productos = new LinkedList<>();
    }

    public void RegistrarProductos(Producto producto) {
        productos.add(producto);
    }

    public static LinkedList<Producto> getProductobyParametro(int parametro, String valor) {
        LinkedList<Producto> resultado = new LinkedList<>();
        for (Producto prod : productos) {

            switch (parametro) {

                case 1 -> {
                    if (String.valueOf(prod.getId()).equals(valor)) {
                        resultado.add(prod);
                    }
                }

                case 2 -> {
                    if (String.valueOf(prod.getProveedorId()).equals(valor)) {
                        resultado.add(prod);
                    }
                }
                case 3 -> {
                    if (prod.getNombreProducto().equals(valor)) {
                        resultado.add(prod);
                    }
                }
                case 4 -> {
                    if (prod.getDescripcion().equals(valor)) {
                        resultado.add(prod);
                    }
                }
                
            }

        }
        return resultado;

    }

    public void eliminarProducto(int id) {
        productos.removeIf(cliente -> cliente.getId() == id);

    }

}
