package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ProductoControl implements ActionListener {
    Vista.RegproductoInternalFrame productoVista; // Referencia al formulario de producto
    Modelo.Producto productoModelo; // Modelo de producto
    Modelo.GestorProducto gestorProductoModelo; // Gestor de productos

    // Constructor que recibe la vista del producto como parámetro
    public ProductoControl(Vista.RegproductoInternalFrame productoVista) {
        this.productoVista = productoVista;
        gestorProductoModelo = new Modelo.GestorProducto(); // Inicializa el gestor de productos
    }

    // Método para manejar los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si se hace clic en el botón Registrar
        if (e.getSource().equals(productoVista.btnRegistrar)) {
            try {
                // Se obtienen los datos del formulario
                int Id = Integer.parseInt(productoVista.txtId.getText());
                int proveedorId = Integer.parseInt(productoVista.txtProveedorId.getText());
                String nombreProducto = productoVista.txtNombreProducto.getText();
                String descripcion = productoVista.txtDescripcion.getText();
                double precio = Double.parseDouble(productoVista.txtPrecio.getText());
                int stock = Integer.parseInt(productoVista.txtStock.getText());

                // Se crea un nuevo objeto Producto con los datos obtenidos
                productoModelo = new Modelo.Producto(Id, proveedorId, nombreProducto, descripcion, precio, stock);

                // Se registra el producto utilizando el gestor de productos
                boolean registrado = gestorProductoModelo.RegistrarProductos(productoModelo);

                // Mostrar mensaje de confirmación o error según el resultado del registro
                if (registrado) {
                    JOptionPane.showMessageDialog(productoVista, "Producto registrado con éxito.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(productoVista, "Error al registrar el producto.", "Registro fallido", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Mostrar mensaje de error si ocurre una excepción
                JOptionPane.showMessageDialog(productoVista, "Error al registrar el producto: " + ex.getMessage(), "Registro fallido", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

        // Si se hace clic en el botón Nuevo
        if (e.getSource().equals(productoVista.btnNuevo)) {
            // Se limpian los campos del formulario
            productoVista.txtId.setText("");
            productoVista.txtProveedorId.setText("");
            productoVista.txtNombreProducto.setText("");
            productoVista.txtDescripcion.setText("");
            productoVista.txtPrecio.setText("");
            productoVista.txtStock.setText("");
            productoVista.txtId.requestFocus(); // Se coloca el foco en el campo de ID
        }
    }
}