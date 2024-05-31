package Modelo;

public class Cliente {
    // Atributos privados que definen las propiedades de un cliente
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    // Constructor con parámetros para inicializar los atributos del cliente
    public Cliente(int id, String nombre, String apellido, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Métodos Getters y Setters para acceder y modificar los atributos

    // Devuelve el ID del cliente
    public int getId() {
        return id;
    }

    // Establece el ID del cliente
    public void setId(int id) {
        this.id = id;
    }

    // Devuelve el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Establece el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el apellido del cliente
    public String getApellido() {
        return apellido;
    }

    // Establece el apellido del cliente
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Devuelve el teléfono del cliente
    public String getTelefono() {
        return telefono;
    }

    // Establece el teléfono del cliente
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Devuelve el email del cliente
    public String getEmail() {
        return email;
    }

    // Establece el email del cliente
    public void setEmail(String email) {
        this.email = email;
    }

    // Sobrescribe el método toString() para proporcionar una representación significativa del objeto Cliente
    @Override
    public String toString() {
        return "Cliente [ID=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido + ", Teléfono=" + telefono + ", Email=" + email + "]";
    }
}


