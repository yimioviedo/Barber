package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GestorClienteControl implements ActionListener {
    Modelo.GestorCliente clientesModelo;
    Vista.ConsClienteInternalFrame consultarClienteVista;
    
    // Constructor
    
    public GestorClienteControl(Vista.ConsClienteInternalFrame consultarClienteVista){
        this.consultarClienteVista = consultarClienteVista;
        clientesModelo = new Modelo.GestorCliente();
        
        // Registering action listeners
        this.consultarClienteVista.btnEliminar.addActionListener(this);
        this.consultarClienteVista.btnAceptar.addActionListener(this);
    
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(consultarClienteVista.btnAceptar)) {
            buscarClientes();
        } else if (e.getSource().equals(consultarClienteVista.btnEliminar)) {
            eliminarCliente();
        }
    }    
    
    private void buscarClientes() {
        DefaultTableModel tModelo;
        String valor = consultarClienteVista.txtValor.getText();
        int parametro =0;
        
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
        LinkedList<Modelo.Cliente> clientes = clientesModelo.
                getClientebyParametro(parametro,valor);
        String registro[] = new String[5];
        
        String [] Titulos = {"Id", "Nombre", "Apellido", "Telefono", "Email"};
        
        tModelo = new DefaultTableModel();
        tModelo.setColumnIdentifiers(Titulos);
        
        for (Modelo.Cliente c : clientes) {
            registro[0] = String.valueOf(c.getId());
            registro[1] = c.getNombre();
            registro[2] = c.getApellido();
            registro[3] = c.getTelefono();
            registro[4] = c.getEmail();
            tModelo.addRow(registro);        
        }
       consultarClienteVista.tblDatos.setModel(tModelo);
    }
    private void eliminarCliente() {
        int selectedRow = consultarClienteVista.tblDatos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(consultarClienteVista, "Por favor, seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(consultarClienteVista, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int clientId = Integer.parseInt((String) consultarClienteVista.tblDatos.getValueAt(selectedRow, 0));
        clientesModelo.eliminarCliente(clientId);

        // Actualizar la tabla después de eliminar el cliente
        buscarClientes();
    }
}

