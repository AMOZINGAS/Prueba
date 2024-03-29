/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import entidadesPOJO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import persistencia.IConexionBD;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class JFrameSeleccionCuenta extends javax.swing.JFrame {

    private IConexionBD conexionBD;
    private ClienteDTO clienteDTO;
    
    /**
     * Creates new form JFrameSeleccionCuenta
     */
    public JFrameSeleccionCuenta(IConexionBD conexionBD, ClienteDTO clienteDTO) {
        initComponents();
        
        this.conexionBD = conexionBD;
        this.clienteDTO = clienteDTO;
        imprimirTbla(clienteDTO.getId());
        
        tblCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int column = tblCuentas.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / tblCuentas.getRowHeight();

                // Verifica si se hizo clic en la columna de botones "Actualizar"
                if (column == tblCuentas.getColumn("seleccionar").getModelIndex() && row < tblCuentas.getRowCount()) {
                    // Puedes acceder a los datos de la fila haciendo algo como esto:
                    int numeroCuenta = (Integer) tblCuentas.getValueAt(row, 0);
                    int saldo = (Integer) tblCuentas.getValueAt(row, 1);
                    String fechaApertura = (String) tblCuentas.getValueAt(row, 2);
                    int idCliente = (Integer) tblCuentas.getValueAt(row, 3);
                    int estado = (Integer) tblCuentas.getValueAt(row, 4);

                    CuentaDTO cuentaDTO = new CuentaDTO(numeroCuenta, saldo, fechaApertura, idCliente, estado);
                    
                    JFrameCuenta jFrameCliente = new JFrameCuenta(cuentaDTO);
                    jFrameCliente.setVisible(true);
                    JFrameSeleccionCuenta.this.dispose();
                    
                }
            }
        });
        
    }

    /**
     *
     * @param idCliente
     */
    public void imprimirTbla(int idCliente){
        
        Logger logger = Logger.getLogger(JFrameSeleccionCuenta.class.getName());
        String sql = """
        SELECT * FROM cuentas WHERE idCliente = ? AND estado = 1;
        """;
        
        try (Connection connection = conexionBD.crearConexion();
             PreparedStatement comand = connection.prepareStatement(sql)) {

            comand.setInt(1, idCliente);
            
            // Ejecutar la consulta y obtener resultados
            try (ResultSet resultSet = comand.executeQuery()) {
                // Crear un modelo de tabla
                DefaultTableModel model = new DefaultTableModel();

                // Obtener metadatos (nombres de columnas)
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(resultSet.getMetaData().getColumnName(i));
                }

                // Agregar filas al modelo
                while (resultSet.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        if(i == 3){
                            
                            // Supongamos que estás obteniendo el valor datetime de tu ResultSet
                            // rs es tu ResultSet y 1 es el índice de la columna que contiene la fecha
                            java.sql.Timestamp timestamp = resultSet.getTimestamp(i);

                            // Convierte el timestamp a una cadena formateada usando SimpleDateFormat
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");
                            String fechaFormateada = sdf.format(timestamp);

                            // Ahora puedes usar fechaFormateada en tu tabla
                            row[i -1] = fechaFormateada;

                            
                        }else{
                            
                            row[i - 1] = resultSet.getObject(i);
                            
                        }
                    }
                    model.addRow(row);
                }

                // Establecer el modelo en el JTable
                tblCuentas.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione una cuenta para iniciar");

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCuentas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Bienvenido a Aurora Finanzas, haz ingresado como cliente...");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnCrearCuenta.setText("Crear cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearCuenta)))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(189, 189, 189))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCrearCuenta))
                .addGap(12, 12, 12))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        
        JFrameVerificarCliente jVerificarCliente = new JFrameVerificarCliente(this);
        jVerificarCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        // TODO add your handling code here:
        
        JFrameCrearCuenta jFrameCrearCuenta = new JFrameCrearCuenta(this, conexionBD, clienteDTO);
        jFrameCrearCuenta.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        JFrameSeleccinActualizar actualizar = new JFrameSeleccinActualizar(this, clienteDTO);
        actualizar.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JFrameSeleccionCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameSeleccionCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameSeleccionCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameSeleccionCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameSeleccionCuenta().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuentas;
    // End of variables declaration//GEN-END:variables
}
