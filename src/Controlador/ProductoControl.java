package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoControl implements ActionListener {
    Vista.RegproductoInternalFrame productoVista;
    Modelo.Producto productoModelo;
    Modelo.GestorProducto gestorProductoModelo;

    public ProductoControl(Vista.RegproductoInternalFrame productoVista) {
        this.productoVista = productoVista;
        gestorProductoModelo = new Modelo.GestorProducto();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(productoVista.btnRegistrar)) {
            int Id = Integer.parseInt(productoVista.txtId.getText());
            int proveedorId = Integer.parseInt(productoVista.txtProveedorId.getText());
            String nombreProducto = productoVista.txtNombreProducto.getText();
            String descripcion = productoVista.txtDescripcion.getText();
            double precio = Double.parseDouble(productoVista.txtPrecio.getText());
            int stock = Integer.parseInt(productoVista.txtStock.getText());
            

            productoModelo = new Modelo.Producto(Id, proveedorId, nombreProducto, 
                    descripcion, precio, stock);
            gestorProductoModelo.RegistrarProductos(productoModelo);
            
        }

        if (e.getSource().equals(productoVista.btnNuevo)) {
            productoVista.txtId.setText("");
            productoVista.txtProveedorId.setText("");
            productoVista.txtNombreProducto.setText("");
            productoVista.txtDescripcion.setText("");
            productoVista.txtPrecio.setText("");
            productoVista.txtStock.setText("");
            productoVista.txtId.requestFocus();

        }
    }

}

    

