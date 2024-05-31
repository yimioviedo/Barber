package Vista;

import javax.swing.table.DefaultTableModel;

public class ConsProductoInternalFrame extends javax.swing.JInternalFrame {

    // Controlador para manejar las acciones en el formulario
    public Controlador.GestorProductoControl gestorproductoControl;
    // Modelo de tabla para mostrar los datos de los productos
    private DefaultTableModel tabla;

    // Constructor
    public ConsProductoInternalFrame() {
        initComponents(); // Inicializa los componentes del formulario
        // Crea una instancia del controlador y le pasa la referencia de este formulario
        gestorproductoControl = new Controlador.GestorProductoControl(this);
        // Define los títulos de las columnas para la tabla
        String titulosTabla[] = {"Id", "ProveedorId", "NombreProducto", "Descripcion"};
        // Inicializa el modelo de la tabla con los títulos de las columnas
        tabla = new DefaultTableModel(null, titulosTabla);
        // Asigna el modelo de la tabla al componente de la tabla en el formulario
        tblDatos.setModel(tabla);
        // Registra el controlador como el listener para los botones de aceptar y eliminar
        btnAceptar.addActionListener(gestorproductoControl);
        btnEliminar.addActionListener(gestorproductoControl);
    }

    // Método para obtener el modelo de la tabla
    public DefaultTableModel getTableModel() {
        return tabla;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdb_Id = new javax.swing.JRadioButton();
        rdb_ProveedorId = new javax.swing.JRadioButton();
        rdb_NombreProducto = new javax.swing.JRadioButton();
        rdb_Descripcion = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consultar - Eliminar Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rdb_Id);
        rdb_Id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_Id.setText("Id");
        rdb_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_IdActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        buttonGroup1.add(rdb_ProveedorId);
        rdb_ProveedorId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_ProveedorId.setText("ProveedorId");
        rdb_ProveedorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_ProveedorIdActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_ProveedorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        buttonGroup1.add(rdb_NombreProducto);
        rdb_NombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_NombreProducto.setText("NombreProducto");
        rdb_NombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_NombreProductoActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_NombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        buttonGroup1.add(rdb_Descripcion);
        rdb_Descripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_Descripcion.setText("Descripción");
        rdb_Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_DescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Valor a Buscar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 310, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 140));

        btnAceptar.setBackground(new java.awt.Color(51, 255, 0));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdb_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_IdActionPerformed

    private void rdb_ProveedorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_ProveedorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_ProveedorIdActionPerformed

    private void rdb_DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_DescripcionActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void rdb_NombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_NombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_NombreProductoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rdb_Descripcion;
    public javax.swing.JRadioButton rdb_Id;
    public javax.swing.JRadioButton rdb_NombreProducto;
    public javax.swing.JRadioButton rdb_ProveedorId;
    public javax.swing.JTable tblDatos;
    public javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
