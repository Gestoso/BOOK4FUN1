 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package book4fun;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author gesto
 */
public class ReservasHechas extends javax.swing.JFrame {
    public boolean entrado = true;
    public int creditos;
    public int totalc;
    
    public ReservasHechas() {

        Login login = new Login();
        login.setUsuario();
        Usuario usu = login.getUsuario();
        ImageIcon icono = obtenerIconoDesdeEnlace(usu.img);
        
        initComponents();
        perfilBut.setIcon(icono);

        creditos = BD.comprobarUsuario().getCreditos();
        nCreditos.setText(String.valueOf(creditos));

        panelCreditos.setVisible(false);
        panelNoTransRealizada.setVisible(false);
        panelTransRealizada.setVisible(false);
        panelNoPosible.setVisible(false);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(25); // Configurar el desplazamiento a 25 píxeles

        crearPaneles();
    }
    
    private void crearPaneles (){
    
        JLabel miLabel = new JLabel("");
        
        try {
            Statement statement = BD.makeConnection().createStatement();
            String sqlQuery = "SELECT * FROM VIVIENDA";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            Statement statement2 = BD.makeConnection().createStatement();
            String sqlQuery2 = "SELECT * FROM RESERVAS";
            ResultSet resultSet2 = statement2.executeQuery(sqlQuery2);
            int vueltas = 0;
            JPanel[] alquileres = new JPanel[1000];
            var viviendasReservadas = new ArrayList<Integer>();
            var usuarioReservadas = new ArrayList<Integer>();
            int altura = 170;
             while (resultSet2.next()) {
                viviendasReservadas.add(resultSet2.getInt("ID_VIVIENDA"));
                usuarioReservadas.add(resultSet2.getInt("ID_USUARIO"));
            }

            while (resultSet.next()) {

                int idVivienda = resultSet.getInt("ID");
                
                if(viviendasReservadas.contains(idVivienda) && usuarioReservadas.contains(BD.comprobarUsuario().getId())){
                
                     JPanel m = modeloPanel( idVivienda, resultSet.getString("NOMBRE"),
                               resultSet.getString("DIRECCION"), resultSet.getString("LOCALIZACION"),
                               resultSet.getString("TIPO"), resultSet.getInt("HABITACIONES"),
                               resultSet.getDouble("PRECIO_DIA"), resultSet.getInt("PISCINA") == 1,
                               resultSet.getInt("WIFI") == 1);
                     
                    if(vueltas % 2 == 0){

                        alquileres[0] = m;
                        AbsoluteConstraints constraints = new AbsoluteConstraints(100,altura,800, 500);
                        registro.add(alquileres[0],constraints);

                    } else {

                        alquileres[1] = m;
                        AbsoluteConstraints constraints = new AbsoluteConstraints(940,altura,800,500);
                        registro.add(alquileres[1],constraints);

                    }

                    AbsoluteConstraints constraints = new AbsoluteConstraints(940,altura + 300,800,500);
                    registro.add(miLabel,constraints);

                    if (vueltas == 1) {

                        altura += 540;
                        vueltas = 0;

                    } else {vueltas++;}
                     
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
     
    private JPanel modeloPanel(int id,String nombre, String direccion, String localizacion, String tipo, int habitaciones, double precioDia, boolean tienePiscina, boolean tieneWifi) {
        
        
        JPanel m = new JPanel();
        m.setLayout(new AbsoluteLayout());
/////////////////////////////////////////////////////////////////
        JLabel etiquetaNombre  = new JLabel("NOMBRE: ");
        Font fuente = new Font("Segoe UI Black", Font.PLAIN, 30);
        etiquetaNombre .setFont(fuente);
        AbsoluteConstraints medidas = new AbsoluteConstraints(400, 5, 300, 100);
        m.add(etiquetaNombre , medidas);
        
        JLabel valorNombre  = new JLabel(nombre);
        fuente = new Font("Segoe UI", Font.PLAIN, 25);
        valorNombre .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 5, 300, 100);
        m.add(valorNombre , medidas);
/////////////////////////////////////////////////////////////////
        JLabel etiquetaDireccion = new JLabel("Direccion:");
        fuente = new Font("Segoe UI", Font.PLAIN, 23);
        etiquetaDireccion.setForeground(Color.GRAY);
        etiquetaDireccion .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 40, 300, 100);
        m.add(etiquetaDireccion , medidas);

        JLabel valorDireccion = new JLabel(direccion);
        fuente = new Font("Segoe UI", Font.PLAIN, 20);
        valorDireccion.setForeground(Color.GRAY);
        valorDireccion .setFont(fuente);
        medidas = new AbsoluteConstraints(510, 40, 300, 100);
        m.add(valorDireccion , medidas);
///////////////////////////////////////////////////////////////////
        JLabel etiquetaLocalizacion = new JLabel("Pais:");
        fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
        etiquetaLocalizacion.setForeground(Color.BLACK);
        etiquetaLocalizacion .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 95, 300, 100);
        m.add(etiquetaLocalizacion , medidas);
        
        JLabel valorLocalizacion = new JLabel(localizacion);
        fuente = new Font("Segoe UI", Font.PLAIN, 15);
        valorLocalizacion.setForeground(Color.BLACK);
        valorLocalizacion .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 95, 300, 100);
        m.add(valorLocalizacion , medidas);
/////////////////////////////////////////////////////////////////
        JLabel etiquetaTipo = new JLabel("Tipo:");
        fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
        etiquetaTipo.setForeground(Color.BLACK);
        etiquetaTipo .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 125, 300, 100);
        m.add(etiquetaTipo , medidas);
        
        JLabel valorTipo = new JLabel(tipo);
        fuente = new Font("Segoe UI", Font.PLAIN, 15);
        valorTipo.setForeground(Color.BLACK);
        valorTipo .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 125, 300, 100);
        m.add(valorTipo , medidas);
/////////////////////////////////////////////////////////////////
        JLabel etiquetaHabitaciones = new JLabel("Habitaciones:");
        fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
        etiquetaHabitaciones.setForeground(Color.BLACK);
        etiquetaHabitaciones .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 155, 300, 100);
        m.add(etiquetaHabitaciones , medidas);
        
        JLabel valorHabitaciones = new JLabel(Integer.toString(habitaciones));
        fuente = new Font("Segoe UI", Font.PLAIN, 15);
        valorHabitaciones.setForeground(Color.BLACK);
        valorHabitaciones .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 155, 300, 100);
        m.add(valorHabitaciones , medidas);
/////////////////////////////////////////////////////////////////
        JLabel etiquetaPrecioDia = new JLabel("Creditos por dia:");
        fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
        etiquetaPrecioDia.setForeground(Color.BLACK);
        etiquetaPrecioDia .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 185, 300, 100);
        m.add(etiquetaPrecioDia , medidas);
        
        JLabel valorPrecioDia = new JLabel(Double.toString(precioDia));
        fuente = new Font("Segoe UI", Font.PLAIN, 15);
        valorPrecioDia.setForeground(Color.BLACK);
        valorPrecioDia .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 185, 300, 100);
        m.add(valorPrecioDia , medidas);
/////////////////////////////////////////////////////////////////
        JLabel etiquetaPiscina = new JLabel("Piscina:");
        fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
        etiquetaPiscina.setForeground(Color.BLACK);
        etiquetaPiscina .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 215, 300, 100);
        m.add(etiquetaPiscina , medidas);
        
        JLabel valorPiscina = new JLabel(tienePiscina ? "Sí" : "No");
        fuente = new Font("Segoe UI", Font.PLAIN, 15);
        valorPiscina.setForeground(Color.BLACK);
        valorPiscina .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 215, 300, 100);
        m.add(valorPiscina , medidas);
/////////////////////////////////////////////////////////////////
        JLabel etiquetaWifi = new JLabel("WIFI:");
        fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
        etiquetaWifi.setForeground(Color.BLACK);
        etiquetaWifi .setFont(fuente);
        medidas = new AbsoluteConstraints(400, 245, 300, 100);
        m.add(etiquetaWifi , medidas);
        
        JLabel valorWifi = new JLabel(tieneWifi ? "Sí" : "No");
        fuente = new Font("Segoe UI", Font.PLAIN, 15);
        valorWifi.setForeground(Color.BLACK);
        valorWifi .setFont(fuente);
        medidas = new AbsoluteConstraints(570, 245, 300, 100);
        m.add(valorWifi , medidas);
/////////////////////////////////////////////////////////////////
        JButton botonPersonalizado = new JButton("Alquilar");

        JDateChooser fechaEntrada = new JDateChooser();
        JDateChooser fechaSalida = new JDateChooser();
        
        totalc = 0;
        JLabel lTotalCreditos = new JLabel("Creditos totales:  " +totalc);
        boolean reservado = true;
        if(reservado == false){
            
           botonPersonalizado.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
           botonPersonalizado.setForeground(new Color(139, 195, 73));
           botonPersonalizado.setBackground(new Color(33, 40, 42));
           Color colorBorde = new Color(139, 195, 73);
           botonPersonalizado.setBorder(new LineBorder(colorBorde, 2));
           medidas = new AbsoluteConstraints(450, 360, 170, 70);
           m.add(botonPersonalizado , medidas);
           
           medidas = new AbsoluteConstraints(100, 360, 200, 20);
           m.add(fechaEntrada , medidas);
           
           medidas = new AbsoluteConstraints(100, 400, 200, 20);
           m.add(fechaSalida , medidas);
           
           fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
           lTotalCreditos.setForeground(Color.BLACK);
           lTotalCreditos .setFont(fuente);
           medidas = new AbsoluteConstraints(100, 400, 300, 100);
           m.add(lTotalCreditos , medidas);
           
        } else {
            
           JLabel etiquetaReservado  = new JLabel("Reservada por usted");
           fuente = new Font("Segoe UI Black", Font.PLAIN, 30);
           etiquetaReservado .setFont(fuente);
           medidas = new AbsoluteConstraints(40, 330, 500, 100);
           m.add(etiquetaReservado , medidas);
            
           JButton botonModificar = new JButton("Modificar");
           botonModificar.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
           botonModificar.setForeground(new Color(139, 195, 73));
           botonModificar.setBackground(new Color(33, 40, 42));
           Color colorBorde = new Color(139, 195, 73);
           botonModificar.setBorder(new LineBorder(colorBorde, 2));
           medidas = new AbsoluteConstraints(375, 340, 170, 70);
           m.add(botonModificar , medidas);
           
           JButton botonCancelarReserva = new JButton("Cancelar");
           botonCancelarReserva.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
           botonCancelarReserva.setForeground(new Color(139, 195, 73));
           botonCancelarReserva.setBackground(new Color(33, 40, 42));
           colorBorde = new Color(139, 195, 73);
           botonCancelarReserva.setBorder(new LineBorder(colorBorde, 2));
           medidas = new AbsoluteConstraints(575, 340, 170, 70);
           m.add(botonCancelarReserva , medidas);
        
           botonCancelarReserva.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int creditosTotales = 0; // Variable para almacenar el resultado

                    try (Connection conn = BD.makeConnection()) {
                        String sql = "SELECT CREDITOS_TOTALES FROM RESERVAS WHERE ID_VIVIENDA = ? AND ID_USUARIO = ?";

                        try (PreparedStatement statement = conn.prepareStatement(sql)) {
                            statement.setInt(1, id);
                            statement.setInt(2, BD.comprobarUsuario().getId());   

                            try (ResultSet resultSet = statement.executeQuery()) {
                                if (resultSet.next()) {
                                    creditosTotales = resultSet.getInt("CREDITOS_TOTALES");
                                }
                            }
                        }
                    } catch (SQLException h) { h.printStackTrace();}
                    
                    
                    try (Connection conn = BD.makeConnection()) {
                        String sql = "DELETE FROM RESERVAS WHERE ID_VIVIENDA = ? AND ID_USUARIO = ?";

                        try (PreparedStatement statement = conn.prepareStatement(sql)) {

                            statement.setInt(1, id);
                            statement.setInt(2, BD.comprobarUsuario().getId());

                            int filasAfectadas = statement.executeUpdate();

                            if (filasAfectadas > 0) {
                                System.out.println("Eliminación exitosa. Filas eliminadas: " + filasAfectadas);
                            } else {
                                System.out.println("No se eliminaron filas.");
                            }
                        }
                        
                    } catch (SQLException q) {
                        q.printStackTrace();
                    }    
                    
                    
                    try {
                            String sqlU = "UPDATE USUARIOS SET creditos = ? WHERE id = ?";

                            PreparedStatement statement = BD.makeConnection().prepareStatement(sqlU);

                            creditos += creditosTotales;

                            statement.setInt(1, creditos);
                            statement.setInt(2, BD.comprobarUsuario().getId());

                            // Ejecuta la actualización
                            int filasActualizadas = statement.executeUpdate();

                            if (filasActualizadas > 0) {nCreditos.setText(String.valueOf(creditos));} 

                        } catch (SQLException u) {u.printStackTrace();}
                    
                    
                    registro.removeAll();
                    registro.revalidate();
                    crearPaneles();
                }
            });
           botonModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date valorFechaEntrada = new Date();
                    Date valorFechaSalida = new Date();
                    try (Connection conn = BD.makeConnection()) {
                        String sql = "SELECT FECHA_ENTRADA, FECHA_SALIDA FROM RESERVAS WHERE ID_VIVIENDA = ? AND ID_USUARIO = ?";

                        try (PreparedStatement statement = conn.prepareStatement(sql)) {
                            statement.setInt(1, id);
                            statement.setInt(2, BD.comprobarUsuario().getId());

                            try (ResultSet resultSet = statement.executeQuery()) {
                                if (resultSet.next()) {

                                    valorFechaEntrada = resultSet.getDate("FECHA_ENTRADA");
                                    valorFechaSalida = resultSet.getDate("FECHA_SALIDA");

                                    System.out.println("Fecha de Entrada: " + fechaEntrada);
                                    System.out.println("Fecha de Salida: " + fechaSalida);

                                    
                                }
                            }
                        }
                    } catch (SQLException q) {
                        q.printStackTrace();
                    }
                    
                    m.remove(botonModificar);
                    m.remove(botonCancelarReserva);
                    m.remove(etiquetaReservado);
                    
                    AbsoluteConstraints medidas = new AbsoluteConstraints(100, 400, 200, 20);
                    m.add(fechaSalida , medidas);
                    medidas = new AbsoluteConstraints(100, 360, 200, 20);
                    m.add(fechaEntrada , medidas);
                    fechaEntrada.setDate(valorFechaEntrada);
                    fechaSalida.setDate(valorFechaSalida);

                    Font fuente = new Font("Segoe UI Black", Font.PLAIN, 15);
                    lTotalCreditos.setForeground(Color.BLACK);
                    lTotalCreditos .setFont(fuente);
                    medidas = new AbsoluteConstraints(100, 400, 300, 100);
                    m.add(lTotalCreditos , medidas);
                    final int creditosGastadosActuales = totalc;
                    
                     JButton botonActualizar = new JButton("Actualizar");
                     botonActualizar.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
                     botonActualizar.setForeground(new Color(139, 195, 73));
                     botonActualizar.setBackground(new Color(33, 40, 42));
                     Color colorBorde = new Color(139, 195, 73);
                     botonActualizar.setBorder(new LineBorder(colorBorde, 2));
                     medidas = new AbsoluteConstraints(375, 340, 170, 70);
                     m.add(botonActualizar , medidas);
                     
                     JButton botonCancelarActualizar = new JButton("Cancelar");
                     botonCancelarActualizar.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
                     botonCancelarActualizar.setForeground(new Color(139, 195, 73));
                     botonCancelarActualizar.setBackground(new Color(33, 40, 42));
                     colorBorde = new Color(139, 195, 73);
                     botonCancelarActualizar.setBorder(new LineBorder(colorBorde, 2));
                     medidas = new AbsoluteConstraints(575, 340, 170, 70);
                     m.add(botonCancelarActualizar , medidas);
                     
                    botonActualizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        java.sql.Date sqlFechaEntrada = new java.sql.Date(fechaEntrada.getDate().getTime());
                        java.sql.Date sqlFechaSalida = new java.sql.Date(fechaSalida.getDate().getTime());
                        Date fEntrada = fechaEntrada.getDate();
                        Date fSalida= fechaSalida.getDate();
                        Date fechaActual = new Date();
                        
                        if (fEntrada.after(fechaActual) && fSalida.after(fechaActual)) {

                            if(creditosGastadosActuales < totalc){
                                if (creditos >= totalc){
                                    try {
                                        String sqlU = "UPDATE USUARIOS SET creditos = ? WHERE id = ?";

                                        PreparedStatement statement = BD.makeConnection().prepareStatement(sqlU);

                                        creditos -= (totalc - creditosGastadosActuales);

                                        statement.setInt(1, creditos);
                                        statement.setInt(2, BD.comprobarUsuario().getId());

                                        // Ejecuta la actualización
                                        int filasActualizadas = statement.executeUpdate();

                                        if (filasActualizadas > 0) {nCreditos.setText(String.valueOf(creditos));} 

                                    } catch (SQLException u) {u.printStackTrace();}
                                    try {
                                        String sqlU = "UPDATE RESERVAS SET CREDITOS_TOTALES = ?, FECHA_ENTRADA = ?, FECHA_SALIDA = ? WHERE ID_VIVIENDA = ? AND ID_USUARIO = ?";

                                        PreparedStatement statement = BD.makeConnection().prepareStatement(sqlU);

                                        statement.setInt(1, totalc);
                                        statement.setDate(2, sqlFechaEntrada);
                                        statement.setDate(3, sqlFechaSalida);
                                        statement.setInt(4, id);
                                        statement.setInt(5, BD.comprobarUsuario().getId());

                                        int filasActualizadas = statement.executeUpdate();

                                        if (filasActualizadas > 0) {nCreditos.setText(String.valueOf(creditos));} 

                                    } catch (SQLException u) {u.printStackTrace();} 
                                    
                                    JOptionPane.showMessageDialog(m, "Las fechas y los creditos se han actualizado de manera correcta", "Alerta", JOptionPane.WARNING_MESSAGE);
                                    
                                }else {  JOptionPane.showMessageDialog(m, "No tienes suficientes creditos", "Alerta", JOptionPane.WARNING_MESSAGE); }
                            } else { 

                                try {
                                    String sqlU = "UPDATE USUARIOS SET creditos = ? WHERE id = ?";

                                    PreparedStatement statement = BD.makeConnection().prepareStatement(sqlU);

                                    creditos += (creditosGastadosActuales - totalc);

                                    statement.setInt(1, creditos);
                                    statement.setInt(2, BD.comprobarUsuario().getId());

                                    int filasActualizadas = statement.executeUpdate();

                                    if (filasActualizadas > 0) {nCreditos.setText(String.valueOf(creditos));}

                                } catch (SQLException u) {u.printStackTrace();}
                                try {
                                        String sqlU = "UPDATE RESERVAS SET CREDITOS_TOTALES = ?, FECHA_ENTRADA = ?, FECHA_SALIDA = ? WHERE ID_VIVIENDA = ? AND ID_USUARIO = ?";

                                        PreparedStatement statement = BD.makeConnection().prepareStatement(sqlU);

                                        statement.setInt(1, totalc);
                                        statement.setDate(2, sqlFechaEntrada);
                                        statement.setDate(3, sqlFechaSalida);
                                        statement.setInt(4, id);
                                        statement.setInt(5, BD.comprobarUsuario().getId());

                                        int filasActualizadas = statement.executeUpdate();

                                        if (filasActualizadas > 0) {nCreditos.setText(String.valueOf(creditos));} 

                                    } catch (SQLException u) {u.printStackTrace();}
                                    JOptionPane.showMessageDialog(m, "Las fechas y los creditos se han actualizado de manera correcta", "Alerta", JOptionPane.WARNING_MESSAGE);

                                }

                            } else {JOptionPane.showMessageDialog(m, "Las fechas son anteriores a la actual", "Alerta", JOptionPane.WARNING_MESSAGE);}
                            registro.removeAll();
                            registro.revalidate();
                            crearPaneles();
                        }
                    });
                     
                    botonCancelarActualizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                            registro.removeAll();
                            registro.revalidate();
                            crearPaneles();
                         
                        }
                    });
                    m.repaint();
                    m.revalidate();

                }
            });
        }
/////////////////////////////////////////////////////////////////
        botonPersonalizado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                Date fEntrada = fechaEntrada.getDate();
                Date fSalida = fechaSalida.getDate();
                Date fechaActual = new Date();
                boolean coincidirFechas = true;
                
                try (Connection conn = BD.makeConnection()) {
                    String sql = "SELECT FECHA_ENTRADA, FECHA_SALIDA FROM RESERVAS WHERE ID_VIVIENDA = ? AND ID_USUARIO != ?";

                    try (PreparedStatement statement = conn.prepareStatement(sql)) {
                        statement.setInt(1, id); // Asigna el valor del ID de la vivienda
                        statement.setInt(2, BD.comprobarUsuario().getId());
                        try (ResultSet resultSet = statement.executeQuery()) {
                            while (resultSet.next()) {
                                Date fechaEntradaSql = resultSet.getDate("FECHA_ENTRADA");
                                Date fechaSalidaSql = resultSet.getDate("FECHA_SALIDA");

                                if (isFechasCoinciden(fEntrada, fSalida, fechaEntradaSql, fechaSalidaSql)) {
                                    
                                        coincidirFechas = false;
                                } else {
                                    coincidirFechas = true;
                                }
                            }
                        }
                    }
                } catch (SQLException w) {
                    w.printStackTrace();
                }
                
                
                if(coincidirFechas){
                if(fEntrada != null && fSalida != null){
                    
                    if(totalc <= creditos){

                        if (fEntrada.after(fechaActual) && fSalida.after(fechaActual)) {

                            LocalDate localDateEntrada = fEntrada.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                            LocalDate localDateSalida = fSalida.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

                            long diasDeDiferencia = ChronoUnit.DAYS.between(localDateEntrada, localDateSalida) +1;
                            int precio = (int) ((diasDeDiferencia + 1) * precioDia);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////                    
                            JPanel estasSeguro = new JPanel();
                            AbsoluteConstraints constraints = new AbsoluteConstraints(0, 0, 800, 500);
                            m.add(estasSeguro, constraints);
                            estasSeguro.setBackground(new Color(255,201,14));
                            Color colorBorde = new Color(139, 195, 73);
                            estasSeguro.setBorder(new LineBorder(colorBorde, 4));
                            m.revalidate();
                            estasSeguro.setLayout(new AbsoluteLayout());

                            m.remove(botonPersonalizado);
                            m.remove(fechaSalida);
                            m.remove(fechaEntrada);

                            JLabel mensaje1  = new JLabel("Estas seguro que");
                            Font fuente = new Font("Segoe UI Black", Font.PLAIN, 30);
                            mensaje1 .setFont(fuente);
                            AbsoluteConstraints medidas = new AbsoluteConstraints(300, 0, 300, 100);
                            estasSeguro.add(mensaje1 , medidas);

                           JLabel mensaje2  = new JLabel("queires alquila en esta fechas:");
                           fuente = new Font("Segoe UI Black", Font.PLAIN, 30);
                           mensaje2 .setFont(fuente);
                           medidas = new AbsoluteConstraints(200, 35, 500, 100);
                           estasSeguro.add(mensaje2 , medidas);

                           JLabel mensaje3  = new JLabel(""+localDateEntrada.getDayOfMonth()+"/"+localDateEntrada.getMonthValue()+"/"+localDateEntrada.getYear()+"   a   "+localDateSalida.getDayOfMonth()+"/"+localDateSalida.getMonthValue()+"/"+localDateSalida.getYear());
                           fuente = new Font("Segoe UI Black", Font.PLAIN, 30);
                           mensaje3 .setFont(fuente);
                           medidas = new AbsoluteConstraints(225, 150, 500, 100);
                           estasSeguro.add(mensaje3 , medidas);

                           JLabel mensaje7  = new JLabel("Coste total:  "+totalc+" Creditos");
                           fuente = new Font("Segoe UI Black", Font.PLAIN, 30);
                           mensaje7 .setFont(fuente);
                           medidas = new AbsoluteConstraints(230, 220, 500, 100);
                           estasSeguro.add(mensaje7 , medidas);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            JButton botonAprobar = new JButton("Aprobar");
                            botonAprobar.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
                            botonAprobar.setForeground(new Color(139, 195, 73));
                            botonAprobar.setBackground(new Color(33, 40, 42));
                            colorBorde = new Color(139, 195, 73);
                            botonAprobar.setBorder(new LineBorder(colorBorde, 2));
                            medidas = new AbsoluteConstraints(450, 360, 170, 70);
                            estasSeguro.add(botonAprobar , medidas);

                            JButton botonCancelar = new JButton("Cancelar");
                            botonCancelar.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
                            botonCancelar.setForeground(new Color(139, 195, 73));
                            botonCancelar.setBackground(new Color(33, 40, 42));
                            botonCancelar.setBorder(new LineBorder(colorBorde, 2));
                            medidas = new AbsoluteConstraints(200, 360, 170, 70);
                            estasSeguro.add(botonCancelar , medidas);

                            botonCancelar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    m.remove(estasSeguro);
                                    m.revalidate();
                                    m.repaint();  // Añade esta línea para forzar la actualización de la interfaz

                                    AbsoluteConstraints medidas = new AbsoluteConstraints(450, 360, 170, 70);

                                    m.add(botonPersonalizado,medidas);
                                    medidas = new AbsoluteConstraints(100, 400, 200, 20);
                                    m.add(fechaSalida,medidas);
                                    medidas = new AbsoluteConstraints(100, 360, 200, 20);
                                    m.add(fechaEntrada,medidas);
                                }
                            });
                            botonAprobar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String sql = "INSERT INTO reservas (ID, ID_VIVIENDA, ID_USUARIO, FECHA_ENTRADA, FECHA_SALIDA, CREDITOS_TOTALES) VALUES (ID_VIVIENDA.NEXTVAL, ?, ?, ?, ?, ?)";
                                    try (Connection conn = BD.makeConnection();
                                         PreparedStatement statement = conn.prepareStatement(sql)) {

                                        java.util.Date fechaEntradaUtil = fechaEntrada.getDate();
                                        java.sql.Date fechaEntrada = new java.sql.Date(fechaEntradaUtil.getTime());
                                        java.util.Date fechaSalidaUtil = fechaSalida.getDate();
                                        java.sql.Date fechaSalida = new java.sql.Date(fechaSalidaUtil.getTime());

                                        statement.setInt(1, id);
                                        statement.setInt(2, BD.comprobarUsuario().getId());
                                        statement.setDate(3, fechaEntrada);
                                        statement.setDate(4, fechaSalida);
                                        statement.setInt(5, totalc);

                                        int filasAfectadas = statement.executeUpdate();

                                        if (filasAfectadas > 0) {
                                            System.out.println("Inserción exitosa. Filas insertadas: " + filasAfectadas);
                                        } else {
                                            System.out.println("No se insertaron filas.");
                                        }
                                    } catch (SQLException a) {
                                        a.printStackTrace();
                                    }

                                    try {
                                        String sqlU = "UPDATE USUARIOS SET creditos = ? WHERE id = ?";

                                        PreparedStatement statement = BD.makeConnection().prepareStatement(sqlU);

                                        creditos -= totalc;

                                        statement.setInt(1, creditos);
                                        statement.setInt(2, BD.comprobarUsuario().getId());

                                        // Ejecuta la actualización
                                        int filasActualizadas = statement.executeUpdate();

                                        if (filasActualizadas > 0) {
                                            System.out.println("Actualización exitosa. Filas actualizadas: " + filasActualizadas);

                                            nCreditos.setText(String.valueOf(creditos));

                                        } else {
                                            System.out.println("Ninguna fila fue actualizada.");
                                        }
                                    } catch (SQLException u) {u.printStackTrace();}

                                    m.remove(estasSeguro);
                                    m.revalidate();
                                    m.repaint();

                                    AbsoluteConstraints medidas = new AbsoluteConstraints(450, 360, 170, 70);
                                    m.add(botonPersonalizado, medidas);
                                    medidas = new AbsoluteConstraints(100, 400, 200, 20);
                                    m.add(fechaSalida, medidas);
                                    medidas = new AbsoluteConstraints(100, 360, 200, 20);
                                    m.add(fechaEntrada, medidas);
                                    
                                    JOptionPane.showMessageDialog(m, "La reserva se a hecho correctamente.", "Alerta", JOptionPane.WARNING_MESSAGE);
                                    registro.removeAll();
                                    registro.revalidate();
                                    crearPaneles();
                                }
                            });
                        } else {JOptionPane.showMessageDialog(m, "Las fechas son anteriores a la actual", "Alerta", JOptionPane.WARNING_MESSAGE);}
                    } else {JOptionPane.showMessageDialog(m, "No tienes creditos suficientes", "Alerta", JOptionPane.WARNING_MESSAGE);}
                } else {JOptionPane.showMessageDialog(m, "No has seleccionado ninguna fecha", "Alerta", JOptionPane.WARNING_MESSAGE);}
            } else {JOptionPane.showMessageDialog(m, "Fechas coinciden o se solapan con una reserva existente.", "Alerta", JOptionPane.WARNING_MESSAGE);
}
            }
            
        });
/////////////////////////////////////////////////////////////////
        fechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                if ("date".equals(evt.getPropertyName())) {

                    Date fSalida = fechaSalida.getDate();


                    Date fEntrada = fechaEntrada.getDate();
                    if (fEntrada != null && fSalida != null) {
                        LocalDate localDateEntrada = fEntrada.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        LocalDate localDateSalida = fSalida.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

                        long diasDeDiferencia = ChronoUnit.DAYS.between(localDateEntrada, localDateSalida);
                        int precio = (int) ((diasDeDiferencia) * precioDia);
                        totalc = precio;
                        lTotalCreditos.setText("Creditos totales:  " +totalc);
                       
                    }
                }
            }
        });
        fechaEntrada.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                if ("date".equals(evt.getPropertyName())) {

                    Date fSalida = fechaEntrada.getDate();


                    Date fEntrada = fechaSalida.getDate();
                    if (fEntrada != null && fSalida != null) {
                        LocalDate localDateEntrada = fEntrada.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        LocalDate localDateSalida = fSalida.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

                        long diasDeDiferencia = ChronoUnit.DAYS.between(localDateSalida, localDateEntrada);
                        int precio = (int) ((diasDeDiferencia + 1) * precioDia);

                        lTotalCreditos.setText("Creditos totales:  " +totalc);
                       
                    }
                }
            }
        });
        return m;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_General = new javax.swing.JPanel();
        panelCreditos = new javax.swing.JPanel();
        panelTransRealizada = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panelNoPosible = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        panelNoTransRealizada = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        boton100 = new javax.swing.JButton();
        inputDinero = new javax.swing.JTextField();
        txtIngresarDinero = new javax.swing.JLabel();
        boton30 = new javax.swing.JButton();
        boton50 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        transferencia = new javax.swing.JButton();
        Raya_verde1 = new javax.swing.JPanel();
        filtro = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        lista = new javax.swing.JLabel();
        favoritos = new javax.swing.JLabel();
        buscador1 = new javax.swing.JLabel();
        perfilBut = new javax.swing.JButton();
        botonCreditos = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        nCreditos1 = new javax.swing.JLabel();
        nCreditos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        registro = new javax.swing.JPanel();
        nombre_text3 = new javax.swing.JLabel();
        imagen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        modelAlquiler = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        vBaños = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        vNombre = new javax.swing.JLabel();
        vDireccion = new javax.swing.JLabel();
        vLocalizacion = new javax.swing.JLabel();
        vTipo = new javax.swing.JLabel();
        vM2 = new javax.swing.JLabel();
        vPiscina = new javax.swing.JLabel();
        vWifi = new javax.swing.JLabel();
        vHabitacion = new javax.swing.JLabel();
        vPrecio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_General.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCreditos.setBackground(new java.awt.Color(33, 40, 42));
        panelCreditos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 195, 73)));
        panelCreditos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTransRealizada.setBackground(new java.awt.Color(255, 201, 14));
        panelTransRealizada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel5.setText("realizada ");
        panelTransRealizada.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 99, -1, 131));

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel19.setText("Transeferencia ");
        panelTransRealizada.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 16, -1, 131));

        jButton2.setBackground(new java.awt.Color(33, 40, 42));
        jButton2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(139, 195, 73));
        jButton2.setText("Completar");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 195, 73), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelTransRealizada.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 236, 186, 75));

        panelCreditos.add(panelTransRealizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 360));

        panelNoPosible.setBackground(new java.awt.Color(255, 201, 14));
        panelNoPosible.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel22.setText("entre 10");
        panelNoPosible.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 153, -1, 42));

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel23.setText("Los numero tienen");
        panelNoPosible.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 22, 397, 65));

        jButton4.setBackground(new java.awt.Color(33, 40, 42));
        jButton4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(139, 195, 73));
        jButton4.setText("Cerrar");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 195, 73), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelNoPosible.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 262, 186, 75));

        jLabel24.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel24.setText("que ser divisibles ");
        panelNoPosible.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 93, -1, 42));

        panelCreditos.add(panelNoPosible, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 360));

        panelNoTransRealizada.setBackground(new java.awt.Color(255, 201, 14));
        panelNoTransRealizada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel20.setText("realizada ");
        panelNoTransRealizada.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 143, -1, 78));

        jButton3.setBackground(new java.awt.Color(33, 40, 42));
        jButton3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(139, 195, 73));
        jButton3.setText("Cerrar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 195, 73), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelNoTransRealizada.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 248, 186, 75));

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel21.setText("Transaccion no");
        panelNoTransRealizada.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 47, 339, 78));

        panelCreditos.add(panelNoTransRealizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 360));

        boton100.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        boton100.setText("100€");
        boton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton100ActionPerformed(evt);
            }
        });
        panelCreditos.add(boton100, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 56, 85, 85));

        inputDinero.setToolTipText("");
        inputDinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDineroActionPerformed(evt);
            }
        });
        panelCreditos.add(inputDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, 394, 52));

        txtIngresarDinero.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtIngresarDinero.setForeground(new java.awt.Color(139, 195, 73));
        txtIngresarDinero.setText("Ingresa el dinero que quieras cambiar:");
        panelCreditos.add(txtIngresarDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 190, 373, 34));

        boton30.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        boton30.setText("30€");
        boton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton30ActionPerformed(evt);
            }
        });
        panelCreditos.add(boton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 56, 85, 85));

        boton50.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        boton50.setText("50€");
        boton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton50ActionPerformed(evt);
            }
        });
        panelCreditos.add(boton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 56, 85, 85));

        boton10.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        boton10.setText("10€");
        boton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton10ActionPerformed(evt);
            }
        });
        panelCreditos.add(boton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 56, 85, 85));

        transferencia.setBackground(new java.awt.Color(33, 40, 42));
        transferencia.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        transferencia.setForeground(new java.awt.Color(139, 195, 73));
        transferencia.setText("Completar Transferencia");
        transferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 195, 73), 2));
        transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferenciaActionPerformed(evt);
            }
        });
        panelCreditos.add(transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 300, 175, 56));

        Panel_General.add(panelCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 450, 390));

        Raya_verde1.setBackground(new java.awt.Color(139, 195, 73));

        javax.swing.GroupLayout Raya_verde1Layout = new javax.swing.GroupLayout(Raya_verde1);
        Raya_verde1.setLayout(Raya_verde1Layout);
        Raya_verde1Layout.setHorizontalGroup(
            Raya_verde1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Raya_verde1Layout.setVerticalGroup(
            Raya_verde1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        Panel_General.add(Raya_verde1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1, -1));

        filtro.setBackground(new java.awt.Color(139, 195, 73));
        filtro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Panel_General.add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 1820, 70));

        SideBar.setBackground(new java.awt.Color(33, 40, 42));
        SideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book4fun/imagenes/lista2.PNG"))); // NOI18N
        lista.setText("jLabel2");
        lista.setMaximumSize(new java.awt.Dimension(40, 40));
        lista.setMinimumSize(new java.awt.Dimension(40, 40));
        SideBar.add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 50, 50));

        favoritos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book4fun/imagenes/historial.PNG"))); // NOI18N
        favoritos.setText("jLabel2");
        favoritos.setMaximumSize(new java.awt.Dimension(40, 40));
        favoritos.setMinimumSize(new java.awt.Dimension(40, 40));
        SideBar.add(favoritos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 50, 50));

        buscador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book4fun/imagenes/buscador.PNG"))); // NOI18N
        buscador1.setText("buscador");
        buscador1.setMaximumSize(new java.awt.Dimension(40, 40));
        buscador1.setMinimumSize(new java.awt.Dimension(40, 40));
        SideBar.add(buscador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 50, 50));

        perfilBut.setText("jButton1");
        perfilBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilButActionPerformed(evt);
            }
        });
        SideBar.add(perfilBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, -1, -1));

        botonCreditos.setBackground(new java.awt.Color(139, 195, 73));
        botonCreditos.setBorderPainted(false);
        botonCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCreditosActionPerformed(evt);
            }
        });
        SideBar.add(botonCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 60));

        jPanel6.setBackground(new java.awt.Color(139, 195, 73));

        nCreditos1.setBackground(new java.awt.Color(139, 195, 73));
        nCreditos1.setText("Creditos:");
        nCreditos1.setToolTipText("");
        nCreditos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nCreditos1.setInheritsPopupMenu(false);

        nCreditos.setBackground(new java.awt.Color(139, 195, 73));
        nCreditos.setText("n");
        nCreditos.setToolTipText("");
        nCreditos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nCreditos.setInheritsPopupMenu(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nCreditos1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(nCreditos1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SideBar.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 50));

        jButton1.setText("Crear Alquiler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        SideBar.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, -1, -1));

        Panel_General.add(SideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 1070));

        registro.setBackground(new java.awt.Color(33, 40, 42));
        registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre_text3.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        nombre_text3.setForeground(new java.awt.Color(255, 255, 255));
        nombre_text3.setText("Alquileres disponibles:");
        nombre_text3.setToolTipText("");
        registro.add(nombre_text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 420, -1));

        jScrollPane1.setViewportView(registro);

        Panel_General.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 254, 1820, 830));

        imagen.setBackground(new java.awt.Color(33, 40, 42));
        imagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book4fun/imagenes/Logo BOOK4U.png"))); // NOI18N
        imagen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 950, 220));

        Panel_General.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 2, 1930, 190));

        modelAlquiler.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Precio:");
        modelAlquiler.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 129, -1));

        vBaños.setText("j");
        modelAlquiler.add(vBaños, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 129, -1));

        jLabel4.setText("Direccion:");
        modelAlquiler.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 129, -1));

        jLabel6.setText("Localizacion:");
        modelAlquiler.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 129, -1));

        jLabel7.setText("Tipo:");
        modelAlquiler.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 129, -1));

        jLabel8.setText("M2:");
        modelAlquiler.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 129, -1));

        jLabel9.setText("Piscina:");
        modelAlquiler.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 129, -1));

        jLabel10.setText("WIFI:");
        modelAlquiler.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 129, -1));

        jLabel11.setText("Habitacion:");
        modelAlquiler.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 129, -1));

        jLabel12.setText("Baños:");
        modelAlquiler.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 129, -1));

        jLabel13.setText("Nombre:");
        modelAlquiler.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 129, -1));

        vNombre.setText("j");
        modelAlquiler.add(vNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 129, -1));

        vDireccion.setText("j");
        modelAlquiler.add(vDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 129, -1));

        vLocalizacion.setText("j");
        modelAlquiler.add(vLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 129, -1));

        vTipo.setText("j");
        modelAlquiler.add(vTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 129, -1));

        vM2.setText("j");
        modelAlquiler.add(vM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 129, -1));

        vPiscina.setText("j");
        modelAlquiler.add(vPiscina, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 129, -1));

        vWifi.setText("j");
        modelAlquiler.add(vWifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 129, -1));

        vHabitacion.setText("j");
        modelAlquiler.add(vHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 129, -1));

        vPrecio.setText("j");
        modelAlquiler.add(vPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 129, -1));

        Panel_General.add(modelAlquiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 330, 430));

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

    private void perfilButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilButActionPerformed
Perfil Frame = new Perfil(); // Crea una instancia del JFrame "Register"
    Frame.setVisible(true); // Hace visible el JFrame "Register"
    this.dispose();

    }//GEN-LAST:event_perfilButActionPerformed

    private void botonCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCreditosActionPerformed

        if(entrado == true){
            entrado = false;
            panelCreditos.setVisible(true);
        } else {
            panelCreditos.setVisible(false);
            entrado = true;
        }

    }//GEN-LAST:event_botonCreditosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        panelTransRealizada.setVisible(false);
        transferencia.setVisible(true);
        boton100.setVisible(true);
        boton30.setVisible(true);
        boton50.setVisible(true);
        boton10.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        panelNoPosible.setVisible(false);
        transferencia.setVisible(true);
        boton100.setVisible(true);
        boton30.setVisible(true);
        boton50.setVisible(true);
        boton10.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton100ActionPerformed
        inputDinero.setText("100");
    }//GEN-LAST:event_boton100ActionPerformed

    private void inputDineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDineroActionPerformed

    }//GEN-LAST:event_inputDineroActionPerformed

    private void boton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton30ActionPerformed
        inputDinero.setText("30");
    }//GEN-LAST:event_boton30ActionPerformed

    private void boton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton50ActionPerformed
        inputDinero.setText("50");
    }//GEN-LAST:event_boton50ActionPerformed

    private void boton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton10ActionPerformed
        inputDinero.setText("10");
    }//GEN-LAST:event_boton10ActionPerformed

    private void transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferenciaActionPerformed

        String textoInputDinero = inputDinero.getText();
        int valorDinero = Integer.parseInt(textoInputDinero);

        if (valorDinero % 10 == 0) {

            try {
                String sql = "UPDATE USUARIOS SET creditos = ? WHERE id = ?";

                PreparedStatement statement = BD.makeConnection().prepareStatement(sql);

                // Define el valor que deseas actualizar usando la variable
                statement.setInt(1, creditos+(valorDinero/10));
                statement.setInt(2, BD.comprobarUsuario().getId());

                // Ejecuta la actualización
                int filasActualizadas = statement.executeUpdate();

                if (filasActualizadas > 0) {

                    panelTransRealizada.setVisible(true);
                    transferencia.setVisible(false);
                    boton100.setVisible(false);
                    boton30.setVisible(false);
                    boton50.setVisible(false);
                    boton10.setVisible(false);
                    creditos += valorDinero/10;
                    nCreditos.setText(String.valueOf(creditos));

                } else {
                    System.out.println("Ninguna fila fue actualizada.");
                }
            } catch (SQLException e) {e.printStackTrace();}

        } else {

            panelNoPosible.setVisible(true);
            transferencia.setVisible(false);
            boton100.setVisible(false);
            boton30.setVisible(false);
            boton50.setVisible(false);
            boton10.setVisible(false);

        }

    }//GEN-LAST:event_transferenciaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

             CreacionAlquiler Frame = new CreacionAlquiler(); // Crea una instancia del JFrame "Register"
    Frame.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservasHechas().setVisible(true);
            }
        });
    }
    
    public static ImageIcon obtenerIconoDesdeEnlace(String img) {
        try {
            URL url = new URL(img);
            Image imagen = ImageIO.read(url);
            return new ImageIcon(imagen);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private boolean isFechasCoinciden(Date fEntrada, Date fSalida, Date reservaEntrada, Date reservaSalida) {
        // Si alguna de las fechas de entrada o salida coincide con las fechas de reserva
        if ((fEntrada.equals(reservaEntrada) || fEntrada.after(reservaEntrada)) && 
            (fEntrada.before(reservaSalida) || fEntrada.equals(reservaSalida))) {
            return true;
        } else if ((fSalida.equals(reservaEntrada) || fSalida.before(reservaSalida)) && 
                   (fSalida.after(reservaEntrada) || fSalida.equals(reservaSalida))) {
            return true;
        }
        
        // Si hay días intermedios entre las fechas de entrada y salida
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fEntrada);
        calendar.add(Calendar.DATE, 1); // Incrementa la fecha de entrada en un día

        while (calendar.getTime().before(fSalida)) {
            if (calendar.getTime().equals(reservaEntrada) || calendar.getTime().equals(reservaSalida) ||
                (calendar.getTime().after(reservaEntrada) && calendar.getTime().before(reservaSalida))) {
                return true;
            }
            calendar.add(Calendar.DATE, 1); // Avanza al siguiente día
        }

        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_General;
    private javax.swing.JPanel Raya_verde1;
    private javax.swing.JPanel SideBar;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton100;
    private javax.swing.JButton boton30;
    private javax.swing.JButton boton50;
    private javax.swing.JButton botonCreditos;
    private javax.swing.JLabel buscador1;
    private javax.swing.JLabel favoritos;
    private javax.swing.JPanel filtro;
    private javax.swing.JPanel imagen;
    private javax.swing.JTextField inputDinero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lista;
    private javax.swing.JPanel modelAlquiler;
    private javax.swing.JLabel nCreditos;
    private javax.swing.JLabel nCreditos1;
    private javax.swing.JLabel nombre_text3;
    private javax.swing.JPanel panelCreditos;
    private javax.swing.JPanel panelNoPosible;
    private javax.swing.JPanel panelNoTransRealizada;
    private javax.swing.JPanel panelTransRealizada;
    private javax.swing.JButton perfilBut;
    private javax.swing.JPanel registro;
    private javax.swing.JButton transferencia;
    private javax.swing.JLabel txtIngresarDinero;
    private javax.swing.JLabel vBaños;
    private javax.swing.JLabel vDireccion;
    private javax.swing.JLabel vHabitacion;
    private javax.swing.JLabel vLocalizacion;
    private javax.swing.JLabel vM2;
    private javax.swing.JLabel vNombre;
    private javax.swing.JLabel vPiscina;
    private javax.swing.JLabel vPrecio;
    private javax.swing.JLabel vTipo;
    private javax.swing.JLabel vWifi;
    // End of variables declaration//GEN-END:variables
}

