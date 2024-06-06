package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.GestorProducto;
import Modelo.Producto;
import Vista.ConsProductoInternalFrame;

public class GestorProductoControl implements ActionListener {
    GestorProducto productosModelo; // Modelo para gestionar los productos
    ConsProductoInternalFrame consultarProductoVista; // Vista para consultar productos

    // Constructor que inicializa la vista y el modelo, y registra los action listeners
    public GestorProductoControl(Vista.ConsProductoInternalFrame consultarProductoVista){
        this.consultarProductoVista = consultarProductoVista;
        productosModelo = new Modelo.GestorProducto();

        // Registra los listeners de los botones en la vista
        this.consultarProductoVista.btnEliminar.addActionListener(this);
        this.consultarProductoVista.btnAceptar.addActionListener(this);
    }

    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(consultarProductoVista.btnAceptar)) {
            buscarProductos(); // Llama al método para buscar productos
        } else if (e.getSource().equals(consultarProductoVista.btnEliminar)) {
            eliminarProducto(); // Llama al método para eliminar productos
        }
    }

    // Método para buscar productos basado en un parámetro y su valor
    private void buscarProductos() {
        DefaultTableModel tModelo = new DefaultTableModel();
        String valor = consultarProductoVista.txtValor.getText();
        int parametro = 0;

        // Determina el parámetro de búsqueda seleccionado
        if (consultarProductoVista.rdb_Id.isSelected()) {
            parametro = 1;
        }
        if (consultarProductoVista.rdb_ProveedorId.isSelected()) {
            parametro = 2;
        }
        if (consultarProductoVista.rdb_NombreProducto.isSelected()) {
            parametro = 3;
        }
        if (consultarProductoVista.rdb_Descripcion.isSelected()) {
            parametro = 4;
        }
        if (consultarProductoVista.rdb_Precio.isSelected()) {
            parametro = 5;
        }
        if (consultarProductoVista.rdb_Stock.isSelected()) {
            parametro = 6;
        }

        // Obtiene la lista de productos que coinciden con el parámetro y valor de búsqueda
        LinkedList<Producto> productos = productosModelo.getProductoByParametro(parametro, valor);

        // Define los títulos de las columnas de la tabla
        String[] Titulos = {"Id", "ProveedorId", "NombreProducto", "Descripcion", "Precio", "Stock"};
        tModelo.setColumnIdentifiers(Titulos);

        // Llena el modelo de la tabla con los datos de los productos
        for (Producto p : productos) {
            String[] registro = new String[6]; // Cambiado a tamaño 6 para coincidir con las columnas
            registro[0] = String.valueOf(p.getId());
            registro[1] = String.valueOf(p.getProveedorId());
            registro[2] = p.getNombreProducto();
            registro[3] = p.getDescripcion();
            registro[4] = String.valueOf(p.getPrecio());
            registro[5] = String.valueOf(p.getStock());
            tModelo.addRow(registro);
        }

        // Establece el modelo de la tabla en la vista con los datos obtenidos
        consultarProductoVista.tblDatos.setModel(tModelo);
    }

    // Método para eliminar un producto seleccionado
    private void eliminarProducto() {
        int selectedRow = consultarProductoVista.tblDatos.getSelectedRow();
        if (selectedRow == -1) {
            // Muestra un mensaje de error si no hay ninguna fila seleccionada
            JOptionPane.showMessageDialog(consultarProductoVista, "Por favor, seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Muestra un cuadro de confirmación para asegurarse de que el usuario quiere eliminar el producto
        int confirm = JOptionPane.showConfirmDialog(consultarProductoVista, "¿Está seguro de que desea eliminar el producto seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        // Obtiene el ID del producto seleccionado
        int productId = Integer.parseInt((String) consultarProductoVista.tblDatos.getValueAt(selectedRow, 0));
        productosModelo.eliminarProducto(productId);

        // Actualizar la tabla después de eliminar el producto
        buscarProductos();
    }
}



    

