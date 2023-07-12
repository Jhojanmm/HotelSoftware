package com.nicova.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UpBooks extends javax.swing.JPanel {

    public UpBooks() {
        initComponents();
        InitStyles();
    }

    public void showContent(JPanel p) {
        bg.removeAll();
        bg.revalidate();
        bg.repaint();
        // Configurar el tamaño del Content al tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        bg.setSize(screenSize.width, screenSize.height);

        // Establecer el layout del Content
        bg.setLayout(new BorderLayout());

        // Establecer el JPanel en la región central
        
        bg.add(p, BorderLayout.CENTER);
        bg.revalidate();
        bg.repaint();
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        NameTxt.putClientProperty("JTextField.placeholderText", "Ingrese el Nombre Completo.");
        DocumentTxt.putClientProperty("JTextField.placeholderText", "Ingrese el Numero de documento.");
        EmaiTxt.putClientProperty("JTextField.placeholderText", "Ingrese el Correo Electronico");
        PhoneTxt.putClientProperty("JTextField.placeholderText", "Ingrese el Telefono.");
        OccupationTxt.putClientProperty("JTextField.placeholderText", "Ingrese la Ocupación.");
        AddressTxt.putClientProperty("JTextField.placeholderText", "Ingrese la Direccion de Domicilio.");

    }

    private String[] Save() {
        String[] data = {NameTxt.getText(), DocumentTxt.getText(), EmaiTxt.getText(), PhoneTxt.getText(), OccupationTxt.getText(), AddressTxt.getText()};

        return data;
    }

    private void Clear() {
        NameTxt.setText("");
        DocumentTxt.setText("");
        EmaiTxt.setText("");
        PhoneTxt.setText("");
        OccupationTxt.setText("");
        AddressTxt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        dateLbl = new javax.swing.JLabel();
        DocumentTxt = new javax.swing.JTextField();
        catLbl = new javax.swing.JLabel();
        EmaiTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pagsLbl = new javax.swing.JLabel();
        PhoneTxt = new javax.swing.JTextField();
        descLbl = new javax.swing.JLabel();
        OccupationTxt = new javax.swing.JTextField();
        ejemLbl = new javax.swing.JLabel();
        AddressTxt = new javax.swing.JTextField();
        Button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(40, 55, 62));
        setPreferredSize(new java.awt.Dimension(807, 604));

        bg.setBackground(new java.awt.Color(40, 55, 62));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setText("Agregar Nuevo Cliente");

        titleLbl.setText("Nombre Completo");

        NameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTxtActionPerformed(evt);
            }
        });

        dateLbl.setText("Numero de documento");

        DocumentTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentTxtActionPerformed(evt);
            }
        });

        catLbl.setText("Correo Electrónico");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        pagsLbl.setText("Telefono");

        PhoneTxt.setToolTipText("");

        descLbl.setText("Ocupación");

        OccupationTxt.setToolTipText("");

        ejemLbl.setText("Direccion de Residencia");

        AddressTxt.setToolTipText("");

        Button.setForeground(new java.awt.Color(255, 51, 102));
        Button.setText("AGREGAR CLIENTE");
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Editar Cliente");
        jButton1.setActionCommand("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmaiTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(catLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(213, 213, 213))
                            .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(161, 161, 161))
                            .addComponent(DocumentTxt))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PhoneTxt)
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(pagsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(223, 223, 223))
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(descLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(206, 206, 206))
                                            .addComponent(OccupationTxt)
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(ejemLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(208, 208, 208))
                                            .addComponent(AddressTxt))
                                        .addGap(72, 72, 72))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(pagsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(descLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(OccupationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ejemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(138, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(NameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(DocumentTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(catLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(EmaiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(bg);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed
        String[] data = Save();
        try {
            com.nicova.controllers.AddClient.main(data);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(UpBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Cliente Agregado Correctamente", "Usuario Creado", JOptionPane.INFORMATION_MESSAGE);
        Clear();
    }//GEN-LAST:event_ButtonActionPerformed

    private void NameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showContent(new EditaCliente());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DocumentTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocumentTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTxt;
    private javax.swing.JButton Button;
    private javax.swing.JTextField DocumentTxt;
    private javax.swing.JTextField EmaiTxt;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JTextField OccupationTxt;
    private javax.swing.JTextField PhoneTxt;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel catLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel descLbl;
    private javax.swing.JLabel ejemLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel pagsLbl;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
