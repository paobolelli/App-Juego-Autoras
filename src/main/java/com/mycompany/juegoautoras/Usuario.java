/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;
/**
 *
 * @author paolabolelli
 */

@Entity
@Table(name = "usuarios")
public class Usuario{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario; // ID del usuario, clave primaria, ya no es autogenerado

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario; // 

    @Column(name = "correo_usuario", nullable = false, unique = true)
    private String correoUsuario; //tiene que ser único

    @Column(name = "contrasena_usuario", nullable = false)
    private String contrasenaUsuario; 


    
// Constructor vacío
    public Usuario() {
    }

    /* Constructor con parámetros
    public Usuario(String nombreUsuario, String correoUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.puntajeUsuario = 0;
        this.fechaRegistroUsuario = LocalDateTime.now(); 
        this.ultimaSesionUsuario = LocalDateTime.now(); 
    }
    */
    
        public Usuario(String correoUsuario, String contrasenaUsuario) {
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

   /* public Usuario(Integer idUsuario, String correoUsuario, String contrasenaUsuario) {
        this.idUsuario = idUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }*/

    public Usuario(Integer idUsuario, String nombreUsuario, String correoUsuario, String contrasenaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Usuario(String nombreUsuario, String correoUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

       
    // Getters y setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
        
    // Los necesito porque lo escribe el usuario
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

  
}


/* ejemplo Sergi
@Entity
public class Usuario implements Serializable {

OK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private String contraseña;

OK
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public Usuario(Long id, String nombreUsuario, String contraseña) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


*/