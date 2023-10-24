package book4fun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author gesto
 */
public class BD {
 private static String USER = "23_24_DAM2_CLECOTEAM";
    private static String PWD = "123456";
    private static String URL = "jdbc:oracle:thin:@192.168.3.26:1521:XE";

    public static Controlador comprobarUsuario(Connection conn) {
        String nombreUsuario = Controlador.getUsuario();
        String contrasenya = Controlador.getContrasenya();
        boolean found = false;

        int id = -1; // Valor predeterminado, se cambia si se encuentra el usuario
        String dni = null;
        String nombre = null;
        String apellido = null;
        String email = null;
        int telefono = -1;
        String direccion = null;

        String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ? AND CONTRASENYA = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasenya);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                id = rs.getInt("ID");
                dni = rs.getString("DNI");
                nombre = rs.getString("NOMBRE");
                apellido = rs.getString("APELLIDO");
                email = rs.getString("EMAIL");
                telefono = rs.getInt("TELEFONO");
                direccion = rs.getString("DIRECCION");
                found = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar el usuario: " + e);
        }

        return new Controlador(id, dni, nombre, apellido, email, telefono, contrasenya, direccion, found);
    }
   

    public static Connection makeConnection() {

        System.out.println("Connecting database...");

        Connection conn = null;
try {
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn = DriverManager.getConnection(URL, USER, PWD);
    
    System.out.println("Connection established!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database! ", e);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // devolvemos el valor de la conexion
        return conn;
    }
/**
 * 
 * @param conn 
 */
        
    public static void closeConnection(Connection conn) {
        //cierra la conexión
        try {
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error closing connection!!" + e);

        }
    }
    public static void insertaUsuario(Connection conn, String dni, String nombre, String apellido, String email, int telefono, String contrasenya, String direccion) {
        
        String sql = "INSERT INTO USUARIOS (ID, DNI, NOMBRE, APELLIDO, EMAIL, TELEFONO, CONTRASENYA, DIRECCION) " + "VALUES (GENERAID.nextval, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
        preparedStatement.setString(2, dni);
        preparedStatement.setString(3, nombre);
        preparedStatement.setString(4, apellido);
        preparedStatement.setString(5, email);
        preparedStatement.setInt(6, telefono);
        preparedStatement.setString(7, contrasenya);
        preparedStatement.setString(8, direccion);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                dni = rs.getString("DNI");
                nombre = rs.getString("NOMBRE");
                apellido = rs.getString("APELLIDO");
                email = rs.getString("EMAIL");
                telefono = rs.getInt("TELEFONO");
                direccion = rs.getString("DIRECCION");
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar el usuario: " + e);
        }
}
    
public static int comprobarUsuario() {
    int id = 1;
    String sql = "Select ID from USUARIO where NOMBRE = '" + Controlador.getUsuario() + "' and CONTRASENYA = '" + Controlador.getContrasenya() + "'";
    Statement st = null;
    
    try {
        // Establece la conexión a la base de datos
        Connection conn = makeConnection(); // Reemplaza TuClaseDeConexion con la clase que utilizas para conectarte a la base de datos
        
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            id = rs.getInt("ID");
        }

        st.close();
        conn.close(); // No olvides cerrar la conexión

    } catch (SQLException e) {
        System.out.println("The Select had problems!! " + e);
    }

    return id;
}
}
