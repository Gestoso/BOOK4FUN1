 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package book4fun;

import java.util.Map;

/**
 *
 * @author gesto
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Login() {
        
        initComponents();
        mensaje_error.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_General = new javax.swing.JPanel();
        Raya_verde = new javax.swing.JPanel();
        registro = new javax.swing.JPanel();
        registro_text = new javax.swing.JLabel();
        nombre_text = new javax.swing.JLabel();
        nombre_field = new javax.swing.JTextField();
        contra_text = new javax.swing.JLabel();
        boton_fondo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        boton_register = new javax.swing.JButton();
        mensaje_error = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        boton_error = new javax.swing.JButton();
        contra_field = new javax.swing.JPasswordField();
        imagen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_General.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Raya_verde.setBackground(new java.awt.Color(139, 195, 73));

        javax.swing.GroupLayout Raya_verdeLayout = new javax.swing.GroupLayout(Raya_verde);
        Raya_verde.setLayout(Raya_verdeLayout);
        Raya_verdeLayout.setHorizontalGroup(
            Raya_verdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1930, Short.MAX_VALUE)
        );
        Raya_verdeLayout.setVerticalGroup(
            Raya_verdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        Panel_General.add(Raya_verde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1930, 10));

        registro.setBackground(new java.awt.Color(33, 40, 42));
        registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registro_text.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        registro_text.setForeground(new java.awt.Color(255, 255, 255));
        registro_text.setText("Iniciar Sesion");
        registro.add(registro_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 108, 1028, -1));

        nombre_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        nombre_text.setForeground(new java.awt.Color(255, 255, 255));
        nombre_text.setText("Nombre:");
        registro.add(nombre_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 162, 1028, -1));

        nombre_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_fieldActionPerformed(evt);
            }
        });
        registro.add(nombre_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 185, 1028, -1));

        contra_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        contra_text.setForeground(new java.awt.Color(255, 255, 255));
        contra_text.setText("Contraseña:");
        registro.add(contra_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 213, 1028, -1));

        boton_fondo.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(139, 195, 73));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout boton_fondoLayout = new javax.swing.GroupLayout(boton_fondo);
        boton_fondo.setLayout(boton_fondoLayout);
        boton_fondoLayout.setHorizontalGroup(
            boton_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(boton_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(boton_fondoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        boton_fondoLayout.setVerticalGroup(
            boton_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(boton_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(boton_fondoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        registro.add(boton_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, -1, 80));

        boton_register.setBackground(new java.awt.Color(139, 195, 73));
        boton_register.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        boton_register.setForeground(new java.awt.Color(255, 255, 255));
        boton_register.setText("<html> No tiene cuenta?<br>Regístrate <html>");
        boton_register.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        boton_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_register.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registerActionPerformed(evt);
            }
        });
        registro.add(boton_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 250, 78));

        mensaje_error.setBackground(new java.awt.Color(255, 255, 255));
        mensaje_error.setMinimumSize(new java.awt.Dimension(500, 500));
        mensaje_error.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(197, 0, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("ERROR");
        jTextField1.setActionCommand("<Not Set>");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        mensaje_error.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Nombre de Usuario y/o Contraseña Incorrectos");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        mensaje_error.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 80));

        boton_error.setText("OK");
        boton_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_errorActionPerformed(evt);
            }
        });
        mensaje_error.add(boton_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 140, 140, 30));

        registro.add(mensaje_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 430, 180));
        registro.add(contra_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 1028, -1));

        Panel_General.add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1930, 890));

        imagen.setBackground(new java.awt.Color(33, 40, 42));
        imagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book4fun/imagenes/Logo BOOK4U.png"))); // NOI18N
        imagen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 950, 220));

        Panel_General.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 2, 1930, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Controlador.setUsuario(nombre_field.getText());
        Controlador.setContrasenya(contra_field.getText());
        System.out.println("Nombre: " + Controlador.getUsuario() + " Contra: " + Controlador.getContrasenya());
        Usuario usu = BD.comprobarUsuario();

if (usu != null) {
    System.out.println("Cheeeeeeeeck");
    Principal Frame = new Principal(); // Crea una instancia del JFrame "Register"
    Frame.setVisible(true); // Hace visible el JFrame "Register"
    this.dispose();
} else {
    System.out.println("Inicio de sesión fallido. Verifica tus credenciales.");
    mensaje_error.setVisible(true);
}
       
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void nombre_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_fieldActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void boton_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_errorActionPerformed
        mensaje_error.setVisible(false);
        
    }//GEN-LAST:event_boton_errorActionPerformed

    private void boton_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registerActionPerformed
        Register Frame = new Register(); // Crea una instancia del JFrame "Register"
    Frame.setVisible(true); // Hace visible el JFrame "Register"
    this.dispose();
    }//GEN-LAST:event_boton_registerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_General;
    private javax.swing.JPanel Raya_verde;
    private javax.swing.JButton boton_error;
    private javax.swing.JPanel boton_fondo;
    private javax.swing.JButton boton_register;
    private javax.swing.JPasswordField contra_field;
    private javax.swing.JLabel contra_text;
    private javax.swing.JPanel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel mensaje_error;
    private javax.swing.JTextField nombre_field;
    private javax.swing.JLabel nombre_text;
    private javax.swing.JPanel registro;
    private javax.swing.JLabel registro_text;
    // End of variables declaration//GEN-END:variables
}
