package Modelo;

import java.util.LinkedList;

public class GestorCliente {

    private static LinkedList<Cliente> clientes;

    public GestorCliente() {
        clientes = new LinkedList<>();
    }

    public void RegistrarClientes(Cliente cliente) {
        clientes.add(cliente);
    }

    public static LinkedList<Cliente> getClientebyParametro(int parametro, String valor) {
        LinkedList<Cliente> resultado = new LinkedList<>();
        for (Cliente clie : clientes) {

            switch (parametro) {

                case 1 -> {
                    if (String.valueOf(clie.getId()).equals(valor)) {
                        resultado.add(clie);
                    }
                }

                case 2 -> {
                    if (clie.getNombre().equals(valor)) {
                        resultado.add(clie);
                    }
                }
                case 3 -> {
                    if (clie.getApellido().equals(valor)) {
                        resultado.add(clie);
                    }
                }
                case 4 -> {
                    if (clie.getTelefono().equals(valor)) {
                        resultado.add(clie);
                    }
                }
                case 5 -> {
                    if (clie.getEmail().equals(valor)) {
                        resultado.add(clie);
                    }
                }
            }

        }
        return resultado;

    }
    public void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);

    }
}



