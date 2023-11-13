 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package book4fun;

import java.util.Map;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Login extends javax.swing.JFrame {

    public int id;
    
    public Login() {
        initComponents();
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
        contra_field = new javax.swing.JTextField();
        boton_fondo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
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

        registro_text.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        registro_text.setForeground(new java.awt.Color(255, 255, 255));
        registro_text.setText("Iniciar Sesion");

        nombre_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        nombre_text.setForeground(new java.awt.Color(255, 255, 255));
        nombre_text.setText("Nombre:");

        nombre_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_fieldActionPerformed(evt);
            }
        });

        contra_text.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        contra_text.setForeground(new java.awt.Color(255, 255, 255));
        contra_text.setText("Contraseña:");

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
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        boton_fondoLayout.setVerticalGroup(
            boton_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout registroLayout = new javax.swing.GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addGroup(registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registro_text, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contra_field, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(448, 448, 448))
        );
        registroLayout.setVerticalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(registro_text, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra_text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra_field, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(boton_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
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
        Controlador result = BD.comprobarUsuario(BD.makeConnection());

if (result.isFound()) {
  
     dispose();
        
        // Crea una instancia del JFrame de PaginaPrincipal
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        // Muestra el JFrame de PaginaPrincipal
        paginaPrincipal.setVisible(true);
    
} else {
    System.out.println("Inicio de sesión fallido. Verifica tus credenciales.");
}
       
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void nombre_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_fieldActionPerformed

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
    private javax.swing.JPanel boton_fondo;
    private javax.swing.JTextField contra_field;
    private javax.swing.JLabel contra_text;
    private javax.swing.JPanel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nombre_field;
    private javax.swing.JLabel nombre_text;
    private javax.swing.JPanel registro;
    private javax.swing.JLabel registro_text;
    // End of variables declaration//GEN-END:variables
}
