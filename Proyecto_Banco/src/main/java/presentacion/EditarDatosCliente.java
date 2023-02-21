/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Cliente;
import interfaces.IClienteDAO;
import java.awt.Frame;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class EditarDatosCliente extends javax.swing.JFrame {

    Frame operacionesCliente;
    Cliente cliente;
    IClienteDAO  clienteDAO;

    /**
     * Creates new form EditarDatosCliente
     */
    public EditarDatosCliente(Frame operacionesCliente,Cliente cliente,IClienteDAO clienteDAO) {
        this.operacionesCliente = operacionesCliente;
        this.cliente=cliente;
        this.clienteDAO=clienteDAO;
        initComponents();
        operacionesCliente.setEnabled(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNombre = new javax.swing.JButton();
        btnFechaNacimiento = new javax.swing.JButton();
        btnCelular = new javax.swing.JButton();
        btnPassword = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNombre.setText("Nombre");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        btnFechaNacimiento.setText("Fecha de Nacimiento");
        btnFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaNacimientoActionPerformed(evt);
            }
        });

        btnCelular.setText("Celular");
        btnCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCelularActionPerformed(evt);
            }
        });

        btnPassword.setText("Password");
        btnPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Cliente");

        btnAtras.setText("Atras");
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
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnFechaNacimiento)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNombre)
                                .addGap(138, 138, 138))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCelular)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPassword)
                        .addGap(131, 131, 131))))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAtras)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtras)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaNacimientoActionPerformed
        // TODO add your handling code here:
        EditarFechaNacimiento editarNacimiento = new EditarFechaNacimiento(this, cliente, clienteDAO);
    }//GEN-LAST:event_btnFechaNacimientoActionPerformed

    private void btnPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPasswordActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        // TODO add your handling code here:
        EditarNombreCliente editarNombre = new EditarNombreCliente(this,clienteDAO,cliente);
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCelularActionPerformed
        // TODO add your handling code here:
        EditarCelularCliente editarCelular = new EditarCelularCliente(this, cliente, clienteDAO);
    }//GEN-LAST:event_btnCelularActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        operacionesCliente.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCelular;
    private javax.swing.JButton btnFechaNacimiento;
    private javax.swing.JButton btnNombre;
    private javax.swing.JButton btnPassword;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}