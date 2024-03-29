/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import DTOS.ClienteDTO;
import entidadesPOJO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;
import verificadores.VerificarValidar;

/**
 *
 * @author elimo
 */
public class JFrameVerificarCliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     *
     * @param frame
     */
    public JFrameVerificarCliente(JFrame frame) {
        initComponents();
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
        txtContraseña = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Estas accediendo como cliente ");

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Correo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña:");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnAtras.setText("Volver");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnAtras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                                .addComponent(btnIngresar)))
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(192, 192, 192))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnIngresar))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        
        VerificarValidar verificar = new VerificarValidar();
        
        char[] passwordChars = txtContraseña.getPassword();
        String password = new String(passwordChars);
        Cliente cliente = new Cliente(txtCorreo.getText(), password);
        
        if(verificar.verificarCorreoExistente(cliente) == true && verificar.verificarContraseña(cliente) == true){
            
                IConexionBD conexionBD = new ConexionBD();
                IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
                ClienteDTO clienteDTO;
                clienteDTO = clienteDAO.buscarPorCorreoContrasenia(txtCorreo.getText(), password);
                JOptionPane.showMessageDialog(this, "Hola " + clienteDTO.getNombres() + ", Bienvenido de nuevo!!", "HOLA", JOptionPane.INFORMATION_MESSAGE);
                JFrameSeleccionCuenta seleccionCuenta = new JFrameSeleccionCuenta(conexionBD, clienteDTO);
                seleccionCuenta.setVisible(true);
                this.dispose();
            
        }else if(verificar.verificarCorreoExistente(cliente) != true && verificar.verificarContraseña(cliente) != true){
            
            JOptionPane.showMessageDialog(this, "Correo y contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
            
        }else if(verificar.verificarContraseña(cliente) != true && verificar.verificarCorreoExistente(cliente) == true){
            
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
        
        }
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    
    
    
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
        JFrameMenu menu = new JFrameMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

//    private boolean verificarCorreoExistente() {
//    ConexionBD conexionBD = new ConexionBD();
//    String sql = "SELECT COUNT(*) AS total FROM CUENTA WHERE CORREO = ?";
//
//    try (Connection conexion = conexionBD.crearConexion();
//         PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//
//        preparedStatement.setString(1, txtCorreo.getText());
//
//        try (ResultSet result = preparedStatement.executeQuery()) {
//            if (result.next()) {
//                // Obtener el total de filas que coinciden con el usuario en la base de datos
//                int total = result.getInt("total");
//
//                // Si el total es mayor que cero, significa que el usuario existe
//                return total > 0;
//            }
//        }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        // Manejar la excepción adecuadamente
//    }

    // Si hubo un error o no se encontró el usuario, devolver false
//    return false;
//}

    
//    private boolean verificarContraseña() {
//    ConexionBD conexionBD = new ConexionBD();
//    String sql = "SELECT CONTRASENIA FROM CUENTAS WHERE CORREO = ?";
//
//    try (Connection conexion = conexionBD.crearConexion();
//         PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
//
//        preparedStatement.setString(1, txtCorreo.getText());
//
//        try (ResultSet result = preparedStatement.executeQuery()) {
//            if (result.next()) {
//                // Obtener la contraseña almacenada en la base de datos
//                String contraseñaAlmacenada = result.getString("CONTRASENIA");
//
//                // Obtener la contraseña ingresada por el usuario
//                String contraseñaIngresada = new String(txtContraseña.getPassword());
//
//                // Verificar si las contraseñas coinciden
//                return contraseñaAlmacenada.equals(contraseñaIngresada);
//            }
//        }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        // Manejar la excepción adecuadamente
//    }
//
//    // Si no se encontró el usuario o hubo un error en la base de datos, devolver false
//    return false;
//}
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
