/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nicova.hotel;

import com.formdev.flatlaf.FlatLightLaf;
import com.nicova.connetion.checkConnetion;
import com.nicova.controllers.GetHabitaciones;
import com.nicova.objetos.Habitacion;
import com.nicova.objetos.Usuario;
import com.nicova.views.Clientes;
import com.nicova.views.CrearEmpleado;
import com.nicova.views.Ganancias;
import com.nicova.views.Habitaciones;
import com.nicova.views.Inventario;
import com.nicova.views.Principal;
import com.nicova.views.PrincipalReserva;
import com.nicova.views.UpBooks;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jhoja
 */
public class DashBoard extends javax.swing.JFrame {
    String csvFile = "C:\\Nicova\\habitaciones.csv";
    java.util.List<Habitacion> listaHabitaciones = GetHabitaciones.leerHabitaciones(csvFile);

    public static Usuario user;
    

    public DashBoard() throws GeneralSecurityException {
        initComponents();
        InitStyles();
        SetDate();
        InitContent();

        if (checkConnetion.isConnected()) {
            inicializar();
        } else {
            JOptionPane.showMessageDialog(null, "Puede que los datos no esten actualizados, por favor conectate a internet", "No hay conexión", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setUser(Usuario user) {
        if (user.getpermisos().equals("Empleado")) {
            btnCrearEmpleado.setVisible(false);
            btnGanancias.setVisible(false);
        }
        lblUser.setText(user.getNombre() + "-" + user.getDocumento());
        this.user = user;
    }

    private void inicializar() throws GeneralSecurityException {
        verificarYCrearArchivoCSV("C:\\Nicova\\usuarios.csv", "1cefRJ-THNlI1LK7PpmIHG0k4XNHzPTip_gdRYmp-HrQ");
        verificarYCrearArchivoCSV("C:\\Nicova\\clientes.csv", "1f2tjSzo8NbGoYk-ERMuGhaOrSD7x1FaQ4XJOBuBVCt8");
        verificarYCrearArchivoCSV("C:\\Nicova\\habitaciones.csv", "1qoVpY0OlMSxq8529Zvc755A3akkBcuCCNABnYaWSJLI");

    }

    public static void verificarYCrearArchivoCSV(String rutaArchivo, String id) throws GeneralSecurityException {
        File archivoCSV = new File(rutaArchivo);

        if (archivoCSV.exists()) {
            System.out.println("Cargando datos de la nube");
            com.nicova.controllers.OfflineToOnlineCsv.deleteFile(rutaArchivo);
            GoogleSheetsToCSV.main(rutaArchivo, id);
        } else {
            try {
                if (archivoCSV.createNewFile()) {
                    GoogleSheetsToCSV.main(rutaArchivo, id);
                    System.out.println("El archivo clientes.csv ha sido creado correctamente.");
                } else {
                    System.out.println("No se pudo crear el archivo clientes.csv.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo clientes.csv: " + e.getMessage());
            }
        }
    }

    private void InitContent() {
        Principal pl = new Principal();
        pl.setSize(806, 604);
        pl.setLocation(0, 0);

        Content.removeAll();
        Content.add(pl, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    public void showContent(JPanel p) {
        // Configurar el tamaño del Content al tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Content.setSize(screenSize.width, screenSize.height);

        // Establecer el layout del Content
        Content.setLayout(new BorderLayout());

        // Establecer el JPanel en la región central
        Content.removeAll();
        Content.add(p, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        lblDate.setText(now.format(DateTimeFormatter.ofPattern("'Fecha:  ' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    
    public void initConteo(){
        int habitacionesDispo = 0;
        int habitacionesOcupa = 0;
        for (Habitacion room : listaHabitaciones) {
            if (room.isDisponible()) {
                habitacionesDispo = habitacionesDispo + 1;
            }else{
                habitacionesOcupa = habitacionesOcupa + 1;
            }
            
        }
        lblnumeroDispo.setText(String.valueOf(habitacionesDispo));
        lblNumeroOcupadas.setText(String.valueOf(habitacionesOcupa));
    }
    private void InitStyles() {
        initConteo();
        lblUser.putClientProperty("FlatLaf.styleClass", "h2");
        lblDate.putClientProperty("FlatLaf.styleClass", "h2");
        lblNicova.putClientProperty("FlatLaf.styleClass", "h00");
        lblnumeroDispo.putClientProperty("FlatLaf.styleClass", "h1");
        lblNumeroOcupadas.putClientProperty("FlatLaf.styleClass", "h1");
        lblNumeroNoPagas.putClientProperty("FlatLaf.styleClass", "h1");
        lbldisponibles.putClientProperty("FlatLaf.styleClass", "h4");
        lblOcupadas.putClientProperty("FlatLaf.styleClass", "h4");
        lblNoPagadas.putClientProperty("FlatLaf.styleClass", "h4");
        lblUsuario.putClientProperty("FlatLaf.styleClass", "h2");
        lblInfo.putClientProperty("FlatLaf.styleClass", "h4");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        lblReservas = new javax.swing.JButton();
        Principal = new javax.swing.JButton();
        lblReserva2 = new javax.swing.JButton();
        lblReserva4 = new javax.swing.JButton();
        lblNicova = new javax.swing.JLabel();
        lblCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCrearEmpleado = new javax.swing.JButton();
        btnGanancias = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbldisponibles = new javax.swing.JLabel();
        lblnumeroDispo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblOcupadas = new javax.swing.JLabel();
        lblNumeroOcupadas = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblNoPagadas = new javax.swing.JLabel();
        lblNumeroNoPagas = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setPreferredSize(new java.awt.Dimension(1180, 850));

        Menu.setBackground(new java.awt.Color(38, 50, 56));
        Menu.setPreferredSize(new java.awt.Dimension(260, 640));

        lblReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar.png"))); // NOI18N
        lblReservas.setText("Reservas");
        lblReservas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        lblReservas.setBorderPainted(false);
        lblReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReservas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReservas.setIconTextGap(15);
        lblReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblReservasActionPerformed(evt);
            }
        });

        Principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apps.png"))); // NOI18N
        Principal.setText("Principal");
        Principal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        Principal.setBorderPainted(false);
        Principal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Principal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Principal.setIconTextGap(15);
        Principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrincipalActionPerformed(evt);
            }
        });

        lblReserva2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit (3).png"))); // NOI18N
        lblReserva2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        lblReserva2.setBorderPainted(false);
        lblReserva2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReserva2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReserva2.setIconTextGap(15);
        lblReserva2.setLabel("Inventario");
        lblReserva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblReserva2ActionPerformed(evt);
            }
        });

        lblReserva4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        lblReserva4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        lblReserva4.setBorderPainted(false);
        lblReserva4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReserva4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReserva4.setIconTextGap(15);
        lblReserva4.setLabel("Habitaciones");
        lblReserva4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblReserva4ActionPerformed(evt);
            }
        });

        lblNicova.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user (1).png"))); // NOI18N
        lblCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        lblCliente.setBorderPainted(false);
        lblCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCliente.setIconTextGap(15);
        lblCliente.setLabel("Clientes");
        lblCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblClienteActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 30));

        btnCrearEmpleado.setText("Crear Empleado");
        btnCrearEmpleado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnCrearEmpleado.setBorderPainted(false);
        btnCrearEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCrearEmpleado.setIconTextGap(15);
        btnCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEmpleadoActionPerformed(evt);
            }
        });

        btnGanancias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stats.png"))); // NOI18N
        btnGanancias.setText("Ganancias");
        btnGanancias.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnGanancias.setBorderPainted(false);
        btnGanancias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGanancias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGanancias.setIconTextGap(15);
        btnGanancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGananciasActionPerformed(evt);
            }
        });

        jLabel6.setText("Cerrar Sesión");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNicova, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblReserva2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblReserva4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNicova, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblReserva2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblReserva4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(btnCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        header.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(38, 50, 56));

        lbldisponibles.setText("Habitaciones Disponibles");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbldisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbldisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        lblnumeroDispo.setText("30");
        lblnumeroDispo.setIconTextGap(15);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblnumeroDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblnumeroDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(38, 50, 56));

        lblOcupadas.setText("Habitaciones Ocupadas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOcupadas, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        lblNumeroOcupadas.setText("5");
        lblNumeroOcupadas.setIconTextGap(15);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblNumeroOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNumeroOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(38, 50, 56));

        lblNoPagadas.setText("Habitaciones No Pagadas");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblNoPagadas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNoPagadas, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        lblNumeroNoPagas.setText("2");
        lblNumeroNoPagas.setIconTextGap(15);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblNumeroNoPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNumeroNoPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(38, 50, 56));

        lblInfo.setText("Información");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        lblUser.setText("Usuario");

        lblUsuario.setText("Usuario:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1429, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReservasActionPerformed
        showContent(new PrincipalReserva());
    }//GEN-LAST:event_lblReservasActionPerformed

    private void PrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrincipalActionPerformed
        showContent(new Principal());
    }//GEN-LAST:event_PrincipalActionPerformed

    private void lblReserva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReserva2ActionPerformed
        showContent(new Inventario());
    }//GEN-LAST:event_lblReserva2ActionPerformed

    private void btnGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGananciasActionPerformed
        showContent(new Ganancias());
    }//GEN-LAST:event_btnGananciasActionPerformed

    private void lblReserva4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReserva4ActionPerformed
        showContent(new Habitaciones());
    }//GEN-LAST:event_lblReserva4ActionPerformed

    private void lblClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblClienteActionPerformed
        showContent(new UpBooks());
    }//GEN-LAST:event_lblClienteActionPerformed

    private void btnCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEmpleadoActionPerformed
        showContent(new CrearEmpleado());
    }//GEN-LAST:event_btnCrearEmpleadoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Login ventana = null;
        try {
            ventana = new Login();
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightLaf.setup();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DashBoard().setVisible(true);
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton Principal;
    private javax.swing.JPanel background;
    private javax.swing.JButton btnCrearEmpleado;
    private javax.swing.JButton btnGanancias;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton lblCliente;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNicova;
    private javax.swing.JLabel lblNoPagadas;
    private javax.swing.JLabel lblNumeroNoPagas;
    private javax.swing.JLabel lblNumeroOcupadas;
    private javax.swing.JLabel lblOcupadas;
    private javax.swing.JButton lblReserva2;
    private javax.swing.JButton lblReserva4;
    private javax.swing.JButton lblReservas;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbldisponibles;
    private javax.swing.JLabel lblnumeroDispo;
    // End of variables declaration//GEN-END:variables
}
