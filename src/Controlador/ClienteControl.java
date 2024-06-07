package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ClienteControl implements ActionListener {

    Vista.RegclienteInternalFrame clienteVista; // Referencia al formulario de cliente
    Modelo.Cliente clienteModelo; // Modelo de cliente
    Modelo.GestorCliente gestorClienteModelo; // Gestor de clientes

    // Constructor que recibe la vista del cliente como parámetro
    public ClienteControl(Vista.RegclienteInternalFrame clienteVista) {
        this.clienteVista = clienteVista;
        gestorClienteModelo = new Modelo.GestorCliente(); // Inicializa el gestor de clientes
    }

    // Método para manejar los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si se hace clic en el botón Registrar
        if (e.getSource().equals(clienteVista.btnRegistrar)) {
            try {
            // Se obtienen los datos del formulario
            int Id = Integer.parseInt(clienteVista.txtId.getText());
            String nombre = clienteVista.txtNombre.getText();
            String apellido = clienteVista.txtApellido.getText();
            String telefono = clienteVista.txtTelefono.getText();
            String email = clienteVista.txtEmail.getText();

            // Se crea un nuevo objeto Cliente con los datos obtenidos
            clienteModelo = new Modelo.Cliente(Id, nombre, apellido, telefono, email);

            // Se registra el cliente utilizando el gestor de clientes
            boolean registrado = gestorClienteModelo.RegistrarClientes(clienteModelo);
            
            // Mostrar mensaje de confirmación o error según el resultado del registro
                if (registrado) {
                    JOptionPane.showMessageDialog(clienteVista, "Cliente registrado con éxito.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(clienteVista, "Error al registrar el cliente.", "Registro fallido", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Mostrar mensaje de error si ocurre una excepción
                JOptionPane.showMessageDialog(clienteVista, "Error al registrar el cliente: " + ex.getMessage(), "Registro fallido", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }


        // Si se hace clic en el botón Nuevo
        if (e.getSource().equals(clienteVista.btnNuevo)) {
            // Se limpian los campos del formulario
            clienteVista.txtId.setText("");
            clienteVista.txtNombre.setText("");
            clienteVista.txtApellido.setText("");
            clienteVista.txtTelefono.setText("");
            clienteVista.txtEmail.setText("");
            clienteVista.txtId.requestFocus(); // Se coloca el foco en el campo de ID
        }
    }
}

