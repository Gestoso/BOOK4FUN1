/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book4fun;

import javax.swing.ImageIcon;

/**
 *
 * @author gesto
 */
public class Usuario {
    public int id;
    public String dni;
    public String nombre;
    public String apellido;
    public String email;
    public String telefono;
    public String contrasenya;
    public String direccion;
    public String img;
    public int creditos;

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

    // Constructor
    public Usuario(int id, String dni, String nombre, String apellido, String email, String telefono, String contrasenya, String direccion, String img, int creditos) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.img = img;
        this.creditos = creditos;
    }

    public String getImgURL() {
        return img;
    }

    public ImageIcon cargarImagen() {
        ImageIcon icon = new ImageIcon(img);
        return icon;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public String getDireccion() {
        return direccion;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
