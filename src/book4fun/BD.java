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
    public static Usuario usuario;
    public static Controlador comprobarUsuario(Connection conn) {
        String nombreUsuario = Controlador.getUsuario();
        String contrasenya = Controlador.getContrasenya();
        boolean found = false;

        int id = -1; // Valor predeterminado, se cambia si se encuentra el usuario
        String dni = null;
        String nombre = null;
        String apellido = null;
        String email = null;
        String telefono = null;
        String direccion = null;
        String img = null;
        int creditos = -1;

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
                telefono = rs.getString("TELEFONO");
                direccion = rs.getString("DIRECCION");
                img = rs.getString("IMG");
                creditos = rs.getInt("CREDITOS");
                found = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar el usuario: " + e);
        }

        return new Controlador(id, dni, nombre, apellido, email, telefono, contrasenya, direccion, found, img, creditos);
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
    public static Usuario insertaUsuario(Connection conn, String dni, String nombre, String apellido, String email, String telefono, String contrasenya, String direccion, int creditos) {
    String sql = "INSERT INTO USUARIOS (ID, DNI, NOMBRE, APELLIDO, EMAIL, TELEFONO, CONTRASENYA, DIRECCION, IMG, CREDITOS) VALUES (IDUSU.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String img = "https://imgur.com/sbFLV8b.png"; // URL directamente en la función
   
   
    try (PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[] { "ID" })) {
        preparedStatement.setString(1, dni);
        preparedStatement.setString(2, nombre);
        preparedStatement.setString(3, apellido);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, telefono);
        preparedStatement.setString(6, contrasenya);
        preparedStatement.setString(7, direccion);
        preparedStatement.setString(8, img);
        preparedStatement.setInt(8, creditos);

System.out.println("Pasa");
        int filasAfectadas = preparedStatement.executeUpdate();

        if (filasAfectadas > 0) {
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("ID del usuario insertado: " + id);
                // Crea una instancia de Usuario con los datos insertados y el ID generado
                Usuario usuario = new Usuario(id, dni, nombre, apellido, email, telefono, contrasenya, direccion, img, creditos);
                return usuario;
            }
        } else {
            System.out.println("No se pudo insertar el usuario.");
        }
    } catch (SQLException e) {
        System.out.println("Error al insertar el usuario: " + e);
    }
    return null;
}

   
public static Usuario comprobarUsuarioObj() {
    String sql = "SELECT ID, DNI, NOMBRE, APELLIDO, EMAIL, TELEFONO, DIRECCION, IMG, CREDITOS FROM USUARIOS WHERE NOMBRE = ? AND CONTRASENYA = ?";
   
    Connection conn = makeConnection();
    PreparedStatement st = null;
    ResultSet resultSet = null;

    try {
        st = conn.prepareStatement(sql);
        st.setString(1, Controlador.getUsuario());
        st.setString(2, Controlador.getContrasenya());
        resultSet = st.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String dni = resultSet.getString("DNI");
            String nombre = resultSet.getString("NOMBRE");
            String apellido = resultSet.getString("APELLIDO");
            String email = resultSet.getString("EMAIL");
            String telefono = resultSet.getString("TELEFONO");
            String direccion = resultSet.getString("DIRECCION");
            String img = resultSet.getString("IMG");
            int creditos = resultSet.getInt("CREDITOS");

            usuario = new Usuario(id, dni, nombre, apellido, email, telefono, Controlador.getContrasenya(), direccion, img, creditos);
            return usuario;
        }

    } catch (SQLException e) {
        System.out.println("Error al comprobar el usuario: " + e);
    } finally {
        // Asegúrate de cerrar la conexión, el PreparedStatement y el ResultSet en un bloque finally
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // Manejar la excepción
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // Manejar la excepción
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // Manejar la excepción
            }
        }
    }

    return null;
}

 public static Usuario guardarDatos(Connection conn, int id, String nombre, String apellido, String dni, String direccion, String email, String telefono, String contrasenya) {
        String sql = "UPDATE USUARIOS SET nombre = ?, apellido = ?, dni = ?, direccion = ?, email = ?, telefono = ?, contrasenya = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, dni);
            statement.setString(4, direccion);
            statement.setString(5, email);
            statement.setString(6, telefono);
            statement.setString(7, contrasenya);
            statement.setInt(8, id);

            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Datos actualizados exitosamente");
            } else {
                System.out.println("Error al actualizar los datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción de SQL aquí
        }
     return null;
 }
}
