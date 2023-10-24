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
    private static int telefono;
    private static String direccion;
    private static boolean found;

    public Controlador(int id, String dni, String nombre, String apellido, String email, int telefono, String contrasenya, String direccion, boolean found) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.found = found;
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

    public static int getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
