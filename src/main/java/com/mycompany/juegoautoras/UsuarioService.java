/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author paolabolelli
 */


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }

    // Guardar un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar usuario por correo
    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreoUsuario(correo);
    }

    
     public Usuario mapCustomUserDetailsToUser(CustomUserDetailsService customUserDetails) {
        Usuario user = new Usuario();
        user.setIdUsuario(customUserDetails.getIdUsuario());
        user.setNombreUsuario(customUserDetails.getNombreUsuario());
        user.setCorreoUsuario(customUserDetails.getCorreoUsuario());
        user.setContrasenaUsuario(customUserDetails.getContrasenaUsuario());
        // Mapea otros campos necesarios
        return user;
    }
    
    
}