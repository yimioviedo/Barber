package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorProductoControl implements ActionListener { 
    Modelo.GestorProducto productosModelo; // Modelo para gestionar los productos
    Vista.ConsProductoInternalFrame consultarProductoVista; // Vista para consultar productos
    
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
        DefaultTableModel tModelo;
        String valor = consultarProductoVista.txtValor.getText();
        int parametro =0;
        
        // Determina el parámetro de búsqueda seleccionado        
        if(consultarProductoVista.rdb_Id.isSelected()){
            parametro =1;        
        }
        if(consultarProductoVista.rdb_ProveedorId.isSelected()){
            parametro =2;        
        }
        if(consultarProductoVista.rdb_NombreProducto.isSelected()){
            parametro =3;        
        }
        if(consultarProductoVista.rdb_Descripcion.isSelected()){
            parametro =4;        
        }
        
        // Obtiene la lista de productos que coinciden con el parámetro y valor de búsqueda                      
        LinkedList<Modelo.Producto> productos = (LinkedList<Modelo.Producto>) 
                productosModelo.getProductobyParametro(parametro,valor);        
        String registro[] = new String[4];
        
        // Define los títulos de las columnas de la tabla        
        String [] Titulos = {"Id", "ProveedorId", "NombreProducto", "Descripcion"};
        
        tModelo = new DefaultTableModel();
        tModelo.setColumnIdentifiers(Titulos);
        
        // Llena el modelo de la tabla con los datos de los productos        
        for (Modelo.Producto p : productos) {
            registro[0] = String.valueOf(p.getId());
            registro[1] = String.valueOf(p.getProveedorId());
            registro[2] = p.getNombreProducto();
            registro[3] = p.getDescripcion();
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
            JOptionPane.showMessageDialog(consultarProductoVista, "Por favor, seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     // Muestra un cuadro de confirmación para asegurarse de que el usuario quiere eliminar el producto
        int confirm = JOptionPane.showConfirmDialog(consultarProductoVista, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
    // Obtiene el ID del producto seleccionado
        int clientId = Integer.parseInt((String) consultarProductoVista.tblDatos.getValueAt(selectedRow, 0));
        productosModelo.eliminarProducto(clientId);

        // Actualizar la tabla después de eliminar el cliente
        buscarProductos();
    }
}


    

