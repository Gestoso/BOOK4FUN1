/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book4fun;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gesto
 */
public class Controlador {
    
    private static String con;
    private static String usuario;
    private static String contrasenya;
    private static int id;
    private static String dni;
    private static String nombre;
    private static String apellido;
    private static String email;
    private static String telefono;
    private static String direccion;
    private static boolean found;
        public String img;
    public int creditos;

    public Controlador(int id, String dni, String nombre, String apellido, String email, String telefono, String contrasenya, String direccion, boolean found, String img, int creditos) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.found = found;
        this.img = img;
        this.creditos = creditos;
    }
    
        public void setImg(String img) {
        this.img = img;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getImg() {
        return img;
    }

    public int getCreditos() {
        return creditos;
    }

    public Controlador(boolean found) {
        this.found = found;
    }

    // Getters para acceder a los atributos de la clase LoginResult
    public static int getId() {
        return id;
    }

    public static String getDNI() {
        return dni;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static String getEmail() {
        return email;
    }

    public static String getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setDni(String dni) {
        Controlador.dni = dni;
    }

    public static void setNombre(String nombre) {
        Controlador.nombre = nombre;
    }

    public static void setApellido(String apellido) {
        Controlador.apellido = apellido;
    }

    public static void setEmail(String email) {
        Controlador.email = email;
    }

    public static void setTelefono(String telefono) {
        Controlador.telefono = telefono;
    }

    public static void setDireccion(String direccion) {
        Controlador.direccion = direccion;
    }

    public static void setFound(boolean found) {
        Controlador.found = found;
    }

    public static String getContrasenya() {
        return contrasenya;
    }

    public static String getDireccion() {
        return direccion;
    }

    public boolean isFound() {
        return found;
    }

    
    public static String getCon() {
        return con;
    }

    public static void setCon(String con) {
        Controlador.con = con;
    }
    
    public static void setUsuario(String usuario) {
        Controlador.usuario = usuario;
    }
    
    public static String getUsuario(){
        return usuario;
    }
    
    public static void setContrasenya(String contrasenya){
        Controlador.contrasenya = contrasenya;
    }
    public Map<String, Object> toMap() {
    Map<String, Object> userData = new HashMap<>();
    userData.put("id", id);
    userData.put("dni", dni);
    userData.put("nombre", nombre);
    userData.put("apellido", apellido);
    userData.put("email", email);
    userData.put("telefono", telefono);
    userData.put("contrasenya", contrasenya);
    userData.put("direccion", direccion);
    userData.put("found", found);
    return userData;
}
}


