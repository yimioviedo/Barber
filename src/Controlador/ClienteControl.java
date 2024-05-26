package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteControl implements ActionListener {

    Vista.RegclienteInternalFrame clienteVista;
    Modelo.Cliente clienteModelo;
    Modelo.GestorCliente gestorClienteModelo;

    public ClienteControl(Vista.RegclienteInternalFrame clienteVista) {
        this.clienteVista = clienteVista;
        gestorClienteModelo = new Modelo.GestorCliente();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(clienteVista.btnRegistrar)) {
            int Id = Integer.parseInt(clienteVista.txtId.getText());
            String nombre = clienteVista.txtNombre.getText();
            String apellido = clienteVista.txtApellido.getText();
            String telefono = clienteVista.txtTelefono.getText();
            String email = clienteVista.txtEmail.getText();

            clienteModelo = new Modelo.Cliente(Id, nombre, apellido, telefono, email);

            gestorClienteModelo.RegistrarClientes(clienteModelo);
        }

        if (e.getSource().equals(clienteVista.btnNuevo)) {
            clienteVista.txtId.setText("");
            clienteVista.txtNombre.setText("");
            clienteVista.txtApellido.setText("");
            clienteVista.txtTelefono.setText("");
            clienteVista.txtEmail.setText("");
            clienteVista.txtId.requestFocus();

        }
    }

}
