package Modelo;

import java.util.LinkedList;
import java.util.List;

public class GestorCliente {

    // Lista dinámica para almacenar los clientes
    private LinkedList<Cliente> clientes;

    // Constructor para inicializar la lista de clientes
    public GestorCliente() {
        this.clientes = new LinkedList<>();
    }

    // Método para registrar un nuevo cliente
    public void RegistrarClientes(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
            System.out.println("Cliente registrado: " + cliente);
        } else {
            throw new UnsupportedOperationException("Cliente no puede ser nulo");
        }
    }


    // Método para buscar clientes por parámetro y valor específicos
    public List<Cliente> getClienteByParametro(int parametro, String valor) {
        // Lista para almacenar los clientes que cumplen con el criterio de búsqueda
        LinkedList<Cliente> resultado = new LinkedList<>();
        // Iterar sobre la lista de clientes
        for (Cliente cliente : clientes) {
            // Evaluar el parámetro de búsqueda
            switch (parametro) {
                case 1: // Buscar por ID
                    if (String.valueOf(cliente.getId()).equals(valor)) {
                        resultado.add(cliente); // Agregar cliente si el ID coincide
                    }
                    break;
                case 2: // Buscar por nombre
                    if (cliente.getNombre().equals(valor)) {
                        resultado.add(cliente); // Agregar cliente si el nombre coincide
                    }
                    break;
                case 3: // Buscar por apellido
                    if (cliente.getApellido().equals(valor)) {
                        resultado.add(cliente); // Agregar cliente si el apellido coincide
                    }
                    break;
                case 4: // Buscar por teléfono
                    if (cliente.getTelefono().equals(valor)) {
                        resultado.add(cliente); // Agregar cliente si el teléfono coincide
                    }
                    break;
                case 5: // Buscar por email
                    if (cliente.getEmail().equals(valor)) {
                        resultado.add(cliente); // Agregar cliente si el email coincide
                    }
                    break;
                default:
                    // No hacer nada si el parámetro no es válido
                    break;
            }
        }
        // Devolver la lista de clientes que cumplen con el criterio de búsqueda
        return resultado;
    }

    // Método para eliminar un cliente por su ID
    public void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

}
    


    


