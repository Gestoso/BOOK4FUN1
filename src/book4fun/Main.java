package book4fun;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        BD.makeConnection();
        // Crea una instancia del JFrame Login
        book4fun.Register loginFrame = new book4fun.Register(); // Utiliza el nombre completo del paquete y la clase

        // Configura el comportamiento al cerrar
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Haz visible el JFrame Login
        loginFrame.setVisible(true);
    }
}
