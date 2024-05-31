package Modelo;

public class Producto {
    // Atributos privados que definen las propiedades de un producto
    private int id;
    private int proveedorId;
    private String nombreProducto;
    private String descripcion;
    private double precio;
    private int stock;
    
    // Constructor con parámetros para inicializar los atributos del producto
    public Producto(int id, int proveedorId, String nombreProducto, String descripcion, double precio, int stock) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos Getters y Setters para acceder y modificar los atributos

    // Devuelve el ID del producto
    public int getId() {
        return id;
    }

    // Establece el ID del producto
    public void setId(int id) {
        this.id = id;
    }

    // Devuelve el ID del proveedor
    public int getProveedorId() {
        return proveedorId;
    }

    // Establece el ID del proveedor
    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    // Devuelve el nombre del producto
    public String getNombreProducto() {
        return nombreProducto;
    }

    // Establece el nombre del producto
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    // Devuelve la descripción del producto
    public String getDescripcion() {
        return descripcion;
    }

    // Establece la descripción del producto
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Devuelve el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Establece el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Devuelve el stock del producto
    public int getStock() {
        return stock;
    }

    // Establece el stock del producto
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Sobrescribe el método toString() para proporcionar una representación significativa del objeto Producto
    @Override
    public String toString() {
        return "Producto [ID=" + id + ", ProveedorId=" + proveedorId + ", NombreProducto=" + nombreProducto + ", Descripcion=" + descripcion + ", Precio=" + precio + ", Stock=" + stock + "]";
    }
}
