package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.GestorCliente;
import Modelo.Cliente;
import Vista.ConsClienteInternalFrame;

public class GestorClienteControl implements ActionListener {
    GestorCliente clientesModelo; // Modelo para gestionar los clientes
    ConsClienteInternalFrame consultarClienteVista; // Vista para consultar clientes
    
    // Constructor que inicializa la vista y el modelo, y registra los action listeners    
    public GestorClienteControl(Vista.ConsClienteInternalFrame consultarClienteVista){
        this.consultarClienteVista = consultarClienteVista;
        clientesModelo = new Modelo.GestorCliente();
        
        // Registra los listeners de los botones en la vista
        this.consultarClienteVista.btnEliminar.addActionListener(this);
        this.consultarClienteVista.btnAceptar.addActionListener(this);
    
    }    
    
    // Método que maneja los eventos de los botones

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(consultarClienteVista.btnAceptar)) {
            buscarClientes(); // Llama al método para buscar clientes
        } else if (e.getSource().equals(consultarClienteVista.btnEliminar)) {
            eliminarCliente(); // Llama al método para eliminar clientes
        }
    }    
    // Método para buscar clientes basado en un parámetro y su valor
    private void buscarClientes() {
        DefaultTableModel tModelo = new DefaultTableModel();        
        String valor = consultarClienteVista.txtValor.getText();
        int parametro =0;
        
        // Determina el parámetro de búsqueda seleccionado        
        if(consultarClienteVista.rdb_Id.isSelected()){
            parametro =1;        
        }
        if(consultarClienteVista.rdb_Nombre.isSelected()){
            parametro =2;        
        }
        if(consultarClienteVista.rdb_Apellido.isSelected()){
            parametro =3;        
        }
        if(consultarClienteVista.rdb_Telefono.isSelected()){
            parametro =4;        
        }
        if(consultarClienteVista.rdb_Email.isSelected()){
            parametro =5;        
        }
        
        // Obtiene la lista de clientes que coinciden con el parámetro y valor de búsqueda
        LinkedList<Cliente> clientes = clientesModelo.getClienteByParametro
        (parametro, valor);

        
        String registro[] = new String[5];        
        // Define los títulos de las columnas de la tabla        
        String [] Titulos = {"Id", "Nombre", "Apellido", "Telefono", "Email"};        
        tModelo.setColumnIdentifiers(Titulos);
        
        // Llena el modelo de la tabla con los datos de los clientes        
        for (Cliente c : clientes) {
            registro[0] = String.valueOf(c.getId());
            registro[1] = c.getNombre();
            registro[2] = c.getApellido();
            registro[3] = c.getTelefono();
            registro[4] = c.getEmail();
            tModelo.addRow(registro);        
        }
        // Establece el modelo de la tabla en la vista con los datos obtenidos
       consultarClienteVista.tblDatos.setModel(tModelo);
    }
    // Método para eliminar un cliente seleccionado
    private void eliminarCliente() {
        int selectedRow = consultarClienteVista.tblDatos.getSelectedRow();
        if (selectedRow == -1) {
            // Muestra un mensaje de error si no hay ninguna fila seleccionada
            JOptionPane.showMessageDialog(consultarClienteVista, "Por favor, seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Muestra un cuadro de confirmación para asegurarse de que el usuario quiere eliminar el cliente
        int confirm = JOptionPane.showConfirmDialog(consultarClienteVista, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        // Obtiene el ID del cliente seleccionado
        int clientId = Integer.parseInt((String) consultarClienteVista.tblDatos.getValueAt(selectedRow, 0));
        clientesModelo.eliminarCliente(clientId);      
         


        // Actualizar la tabla después de eliminar el cliente
        buscarClientes();
    }
}
