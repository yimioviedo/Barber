package Vista;

import javax.swing.table.DefaultTableModel;

public class ConsClienteInternalFrame extends javax.swing.JInternalFrame {
    
    // Controlador para manejar las acciones en el formulario
    public Controlador.GestorClienteControl gestorclienteControl;
    // Modelo de tabla para mostrar los datos de los clientes
    private DefaultTableModel tabla;
    
    // Constructor    
    public ConsClienteInternalFrame() {
        initComponents(); // Inicializa los componentes del formulario
        // Crea una instancia del controlador y le pasa la referencia de este formulario
        gestorclienteControl = new Controlador.GestorClienteControl(this);
        // Define los títulos de las columnas para la tabla
        String titulosTabla[] = {"Id", "Nombre", "Apellido", "Telefono", "Email"};
        // Inicializa el modelo de la tabla con los títulos de las columnas
        tabla = new DefaultTableModel(null,titulosTabla);
         // Asigna el modelo de la tabla al componente de la tabla en el formulario
        tblDatos.setModel(tabla);
         // Registra el controlador como el listener para los botones de aceptar y eliminar
        btnAceptar.addActionListener(gestorclienteControl);
        btnEliminar.addActionListener(gestorclienteControl);
    }
    // Método para obtener el modelo de la tabla
    public DefaultTableModel getTableModel(){
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
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        rdb_Id = new javax.swing.JRadioButton();
        rdb_Nombre = new javax.swing.JRadioButton();
        rdb_Apellido = new javax.swing.JRadioButton();
        rdb_Telefono = new javax.swing.JRadioButton();
        rdb_Email = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        jRadioButton5.setText("jRadioButton5");

        jLabel2.setText("jLabel2");

        setClosable(true);
        setTitle("Consultar - Eliminar Clientes");
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

        buttonGroup1.add(rdb_Nombre);
        rdb_Nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_Nombre.setText(" Nombre");
        rdb_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_NombreActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 30));

        buttonGroup1.add(rdb_Apellido);
        rdb_Apellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_Apellido.setText("Apellido");
        rdb_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_ApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 90, 30));

        buttonGroup1.add(rdb_Telefono);
        rdb_Telefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_Telefono.setText("Telefono");
        rdb_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_TelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 30));

        buttonGroup1.add(rdb_Email);
        rdb_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdb_Email.setText("Email");
        rdb_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_EmailActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Valor a Buscar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 250, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliiminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 150));

        btnAceptar.setBackground(new java.awt.Color(0, 255, 51));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdb_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_NombreActionPerformed

    private void rdb_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_TelefonoActionPerformed

    private void rdb_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_EmailActionPerformed

    private void rdb_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_IdActionPerformed

    private void rdb_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_ApellidoActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rdb_Apellido;
    public javax.swing.JRadioButton rdb_Email;
    public javax.swing.JRadioButton rdb_Id;
    public javax.swing.JRadioButton rdb_Nombre;
    public javax.swing.JRadioButton rdb_Telefono;
    public javax.swing.JTable tblDatos;
    public javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
