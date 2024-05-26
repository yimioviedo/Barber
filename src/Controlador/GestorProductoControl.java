package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorProductoControl implements ActionListener { 
    Modelo.GestorProducto productosModelo;
    Vista.ConsProductoInternalFrame consultarProductoVista;
    
    // Constructor
    
    public GestorProductoControl(Vista.ConsProductoInternalFrame consultarProductoVista){
        this.consultarProductoVista = consultarProductoVista;
        productosModelo = new Modelo.GestorProducto();
        
        // Registering action listeners
        this.consultarProductoVista.btnEliminar.addActionListener(this);
        this.consultarProductoVista.btnAceptar.addActionListener(this);    
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(consultarProductoVista.btnAceptar)) {
            buscarProductos();
        } else if (e.getSource().equals(consultarProductoVista.btnEliminar)) {
            eliminarProducto();
        }
    }
    
    
    private void buscarProductos() {
        DefaultTableModel tModelo;
        String valor = consultarProductoVista.txtValor.getText();
        int parametro =0;
        
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
                      
        LinkedList<Modelo.Producto> productos = productosModelo.
                getProductobyParametro(parametro,valor);
        String registro[] = new String[4];
        
        String [] Titulos = {"Id", "ProveedorId", "NombreProducto", "Descripcion"};
        
        tModelo = new DefaultTableModel();
        tModelo.setColumnIdentifiers(Titulos);
        
        for (Modelo.Producto p : productos) {
            registro[0] = String.valueOf(p.getId());
            registro[1] = String.valueOf(p.getProveedorId());
            registro[2] = p.getNombreProducto();
            registro[3] = p.getDescripcion();
            tModelo.addRow(registro);        
        }
       consultarProductoVista.tblDatos.setModel(tModelo);
    }
    private void eliminarProducto() {
        int selectedRow = consultarProductoVista.tblDatos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(consultarProductoVista, "Por favor, seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(consultarProductoVista, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int clientId = Integer.parseInt((String) consultarProductoVista.tblDatos.getValueAt(selectedRow, 0));
        productosModelo.eliminarProducto(clientId);

        // Actualizar la tabla después de eliminar el cliente
        buscarProductos();
    }
}


    

