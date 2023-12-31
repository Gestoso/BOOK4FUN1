/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package book4fun;

/**
 *
 * @author gesto
 */
public class Register extends javax.swing.JFrame {
    boolean campos = true;
    /**
     * Creates new form Register
     */
    public Register() {
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

        mensaje_error = new javax.swing.JPanel();
        boton_error = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        Panel_General = new javax.swing.JPanel();
        Raya_verde = new javax.swing.JPanel();
        registro = new javax.swing.JPanel();
        registro_text = new javax.swing.JLabel();
        nombre_text = new javax.swing.JLabel();
        nombre_field = new javax.swing.JTextField();
        apellido_text = new javax.swing.JLabel();
        apellido_field = new javax.swing.JTextField();
        dni_text = new javax.swing.JLabel();
        dni_field = new javax.swing.JTextField();
        domicilio_field = new javax.swing.JTextField();
        domicilio_text = new javax.swing.JLabel();
        contra_text = new javax.swing.JLabel();
        contra2_text = new javax.swing.JLabel();
        boton_fondo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        email_text = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        telefono_field = new javax.swing.JTextField();
        telefono_text = new javax.swing.JLabel();
        boton_register = new javax.swing.JButton();
        contra_field2 = new javax.swing.JPasswordField();
        contra_field = new javax.swing.JPasswordField();
        imagen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        mensaje_error.setBackground(new java.awt.Color(255, 255, 255));
        mensaje_error.setMinimumSize(new java.awt.Dimension(500, 500));
        mensaje_error.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_error.setText("OK");
        boton_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_errorActionPerformed(evt);
            }
        });
        mensaje_error.add(boton_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 140, 140, 30));

        jTextField1.setEditable(false);
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

        registro_text.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        registro_text.setForeground(new java.awt.Color(255, 255, 255));
        registro_text.setText("Registro");

        nombre_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        nombre_text.setForeground(new java.awt.Color(255, 255, 255));
        nombre_text.setText("Nombre:");

        apellido_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        apellido_text.setForeground(new java.awt.Color(255, 255, 255));
        apellido_text.setText("Apellido:");

        dni_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        dni_text.setForeground(new java.awt.Color(255, 255, 255));
        dni_text.setText("DNI:");

        domicilio_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        domicilio_text.setForeground(new java.awt.Color(255, 255, 255));
        domicilio_text.setText("Domicilio:");

        contra_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        contra_text.setForeground(new java.awt.Color(255, 255, 255));
        contra_text.setText("Contraseña:");

        contra2_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        contra2_text.setForeground(new java.awt.Color(255, 255, 255));
        contra2_text.setText("Repita su contraseña");

        boton_fondo.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(139, 195, 73));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrarse");
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
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        boton_fondoLayout.setVerticalGroup(
            boton_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        email_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        email_text.setForeground(new java.awt.Color(255, 255, 255));
        email_text.setText("Email:");

        telefono_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        telefono_text.setForeground(new java.awt.Color(255, 255, 255));
        telefono_text.setText("Telefono:");

        boton_register.setBackground(new java.awt.Color(139, 195, 73));
        boton_register.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        boton_register.setForeground(new java.awt.Color(255, 255, 255));
        boton_register.setText("<html> Ya tienes cuenta?<br>Inicia sesión <html>");
        boton_register.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        boton_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_register.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registerActionPerformed(evt);
            }
        });

        contra_field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contra_field2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registroLayout = new javax.swing.GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addGroup(registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(domicilio_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dni_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registro_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(domicilio_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dni_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra2_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_register, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(448, 448, 448))
        );
        registroLayout.setVerticalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(registro_text, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellido_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellido_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefono_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefono_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dni_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dni_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(domicilio_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(domicilio_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra2_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contra_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(boton_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(boton_register, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mensaje_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mensaje_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(dni_field.getText().length() == 9){
            Controlador.setDni(dni_field.getText());
        } else {
            String dnimal = "El campo Dni debe tener 9 carácteres.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        if(nombre_field.getText().length() >= 1){
            Controlador.setNombre(nombre_field.getText());
        } else {
            String dnimal = "El campo Nombre no puede estar vacío.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        if(apellido_field.getText().length() >= 1){
            Controlador.setApellido(apellido_field.getText());
        } else {
            String dnimal = "El campo Apellido no puede estar vacío.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        if(email_field.getText().length() >= 1){
            Controlador.setEmail(email_field.getText());
        } else {
            String dnimal = "El campo Email no puede estar vacío.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        if(telefono_field.getText().length() == 9){
            Controlador.setTelefono(telefono_field.getText());
        } else {
            String dnimal = "El campo Telefono debe tener 9 carácteres.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        if(contra_field.getText().equals(contra_field2.getText())){
            Controlador.setContrasenya(contra_field.getText());
        } else {
            String dnimal = "El campo Contraseña y Repetir Contraseña no coinciden.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        if(domicilio_field.getText().length() >= 1){
            Controlador.setDireccion(domicilio_field.getText());
        } else {
            String dnimal = "El campo Domicilio no puede estar vacío.";
            jTextField2.setText(dnimal);
                    mensaje_error.setVisible(true);
                    campos = false;
        }
        
        if (campos) {
            
            Usuario usu = BD.insertaUsuario(BD.makeConnection(), Controlador.getDNI(), Controlador.getNombre(), Controlador.getApellido(),Controlador.getEmail(), Controlador.getTelefono(),Controlador.getContrasenya(), Controlador.getDireccion(),"sgmsdgk" ,0);
            Controlador.setUsuario(nombre_field.getText());
            Controlador.setContrasenya(contra_field.getText());
            if (usu == null) {
            
            System.out.println("No se inserto el usuario");
        } else {
            Principal Frame = new Principal(); // Crea una instancia del JFrame "Register"
    Frame.setVisible(true); // Hace visible el JFrame "Register"
    this.dispose();
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registerActionPerformed
        Login Frame = new Login(); // Crea una instancia del JFrame "Register"
        Frame.setVisible(true); // Hace visible el JFrame "Register"
        this.dispose();
    }//GEN-LAST:event_boton_registerActionPerformed

    private void contra_field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contra_field2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contra_field2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void boton_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_errorActionPerformed
        mensaje_error.setVisible(false);
        campos = true;
    }//GEN-LAST:event_boton_errorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_General;
    private javax.swing.JPanel Raya_verde;
    private javax.swing.JTextField apellido_field;
    private javax.swing.JLabel apellido_text;
    private javax.swing.JButton boton_error;
    private javax.swing.JPanel boton_fondo;
    private javax.swing.JButton boton_register;
    private javax.swing.JLabel contra2_text;
    private javax.swing.JPasswordField contra_field;
    private javax.swing.JPasswordField contra_field2;
    private javax.swing.JLabel contra_text;
    private javax.swing.JTextField dni_field;
    private javax.swing.JLabel dni_text;
    private javax.swing.JTextField domicilio_field;
    private javax.swing.JLabel domicilio_text;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel email_text;
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
    private javax.swing.JTextField telefono_field;
    private javax.swing.JLabel telefono_text;
    // End of variables declaration//GEN-END:variables
}
