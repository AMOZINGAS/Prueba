/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DTOS.ClienteDTO;
import DTOS.CuentaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ClienteDAO;
import persistencia.CuentaDAO;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;
import persistencia.ICuentaDAO;
import persistencia.PersistenciaException;
import verificadores.VerificarValidar;

/**
 *
 * @author elimo
 */
public class JFrameTransferencia extends javax.swing.JFrame {

    private IConexionBD conexionBD;
    private CuentaDTO cuentaDTO;
    private ICuentaDAO cuentaDAO;
    
    /**
     * Creates new form GenerarTransferencia
     *
     * @param frame
     */
    public JFrameTransferencia(JFrame frame, CuentaDTO cuentaDTO, IConexionBD conexionBD) {
        initComponents();
        
        this.conexionBD = conexionBD;
        this.cuentaDTO = cuentaDTO;
        cuentaDAO = new CuentaDAO(conexionBD);
        ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
        //Obtiene el saldo del cliente y lo pone en el txt
        txtSaldo.setText(String.valueOf(cuentaDTO.getSaldo()));
        txtNumeroCuenta.setText(String.valueOf(cuentaDTO.getNumeroCuenta()));
        if(Integer.parseInt(txtSaldo.getText()) == 0){
            
            txtAceptar.setVisible(false);
            txtMontoEnviar.setEditable(false);
            
        }
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        ClienteDTO clienteDTO = clienteDAO.buscarPorCuenta(cuentaDTO);
        txtNombre.setText(clienteDTO.getNombres());
        
        setLocationRelativeTo(frame);

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
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMontoEnviar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        txtNumeroCuentaReceptor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMontoDespuesDeTrans = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtNumeroCuenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Hola,");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText(" para realizar la transferencia.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("completa los siguientes campos  ");

        txtMontoEnviar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMontoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoEnviarActionPerformed(evt);
            }
        });
        txtMontoEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoEnviarKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Monto:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tu saldo es de:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setText("$");

        txtSaldo.setEditable(false);
        txtSaldo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtSaldo.setBorder(null);
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        txtNumeroCuentaReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCuentaReceptorActionPerformed(evt);
            }
        });
        txtNumeroCuentaReceptor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroCuentaReceptorKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Número de cuenta:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tu saldo despues de ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel9.setText("$");

        txtMontoDespuesDeTrans.setEditable(false);
        txtMontoDespuesDeTrans.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtMontoDespuesDeTrans.setBorder(null);
        txtMontoDespuesDeTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoDespuesDeTransActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("esta transferencia será:");

        txtAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAceptar.setText("Aceptar");
        txtAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Numero de cuenta: ");

        txtNumeroCuenta.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroCuentaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMontoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel8))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMontoDespuesDeTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtMontoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtNumeroCuentaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(txtMontoDespuesDeTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(txtAceptar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:;
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void txtMontoDespuesDeTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoDespuesDeTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoDespuesDeTransActionPerformed

    private void txtAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAceptarActionPerformed
            
        VerificarValidar verificar = new VerificarValidar();
        
        int validar = verificar.validarNumeroCuenta(Integer.parseInt(txtNumeroCuentaReceptor.getText()));
        
        if(validar <= 0){
            
            JOptionPane.showMessageDialog(this, "El numero de cuenta no existe", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            txtNumeroCuentaReceptor.setText("");
            
        }else if(Integer.parseInt(txtMontoEnviar.getText()) > cuentaDTO.getSaldo()){
            
            JOptionPane.showMessageDialog(this, "No puedes transferir esa cantidad", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            
        }else if (Integer.parseInt(txtMontoEnviar.getText()) < 0 ){
            
            JOptionPane.showMessageDialog(this, "No puedes transferir cantidades negativas", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            
        }else {
            try {
                // TODO add your handling code here:

                int saldoNuevo = cuentaDAO.transferenciaDinero(cuentaDTO.getNumeroCuenta(), Integer.parseInt(txtNumeroCuentaReceptor.getText()), Integer.parseInt(txtMontoEnviar.getText()));
                if(saldoNuevo == -1){
                    
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la transferencia", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    
                }else{
                    cuentaDTO.setSaldo(saldoNuevo);
                    txtSaldo.setText(String.valueOf(cuentaDTO.getSaldo()));
                    JOptionPane.showMessageDialog(this, "La transferencia se realizó correctamente \nSaldo actual: " + cuentaDTO.getSaldo(), "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
                    JFrameCuenta jFrameCliente = new JFrameCuenta(cuentaDTO);
                    jFrameCliente.setVisible(true);
                    dispose(); 
                }
            } catch (PersistenciaException ex) {

                Logger.getLogger(JFrameTransferencia.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_txtAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        JFrameCuenta jFrameCliente = new JFrameCuenta(cuentaDTO);
        jFrameCliente.setVisible(true);
        dispose();        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMontoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoEnviarActionPerformed
        // TODO add your handling code here:
        
        // Obtener el saldo actual del usuario
        



        // Mostrar el nuevo saldo en el campo de texto

    }//GEN-LAST:event_txtMontoEnviarActionPerformed

    private void txtNumeroCuentaReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCuentaReceptorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCuentaReceptorActionPerformed

    private void txtMontoEnviarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoEnviarKeyReleased
        // TODO add your handling code here:
        
        if(Integer.parseInt(txtSaldo.getText()) <= 0){
            
            
                
            
        }else if(!txtMontoEnviar.getText().matches("\\d+")){
            
            JOptionPane.showMessageDialog(this, "No puedes ingresar letras", "ERROR!!", JOptionPane.INFORMATION_MESSAGE);
            txtMontoEnviar.setText("");
            
        }else {    
         
            int saldoActual = cuentaDTO.getSaldo();

            // Convertir el monto ingresado a entero
            int montoTransaccion = Integer.parseInt(txtMontoEnviar.getText());

            // Calcular el nuevo saldo después de la transacción
            int nuevoSaldo = saldoActual - montoTransaccion;

            // Verificar si el nuevo saldo es mayor que cero
            if (nuevoSaldo > 0) {
                // Si es mayor que cero, establecer el texto del campo txtMontoDespuesDeTrans con el nuevo saldo
                txtMontoDespuesDeTrans.setText(String.valueOf(nuevoSaldo));

            }
            
        }
        
        
        
    }//GEN-LAST:event_txtMontoEnviarKeyReleased

    private void txtNumeroCuentaReceptorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCuentaReceptorKeyReleased
        // TODO add your handling code here:
        
        if(!txtNumeroCuentaReceptor.getText().matches("\\d+")){
            
            JOptionPane.showMessageDialog(this, "No puedes ingresar letras", "ERROR!!", JOptionPane.INFORMATION_MESSAGE);
            txtNumeroCuentaReceptor.setText("");
            
        }
        
    }//GEN-LAST:event_txtNumeroCuentaReceptorKeyReleased

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
//            java.util.logging.Logger.getLogger(JFrameTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        //</editor-fold>
//
//        /* Create and display the form */
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton txtAceptar;
    private javax.swing.JTextField txtMontoDespuesDeTrans;
    private javax.swing.JTextField txtMontoEnviar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtNumeroCuentaReceptor;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
