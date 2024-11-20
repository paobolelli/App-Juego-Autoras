/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author paolabolelli
 */
    

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    private Usuario usuario;
    
    @Override
    public UserDetails loadUserByUsername(String correoUsuario) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoUsuario(correoUsuario);
        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getNombreUsuario())
                .password(usuario.getContrasenaUsuario())
                .roles("USER").build();
    }

    public UserDetails loadUserByCorreoUsuario(String correoUsuario) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoUsuario(correoUsuario);
        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getNombreUsuario())
                .password(usuario.getContrasenaUsuario())
                .roles("USER").build();
    }
    

    public boolean authenticate(String correoUsuario, String ContrasenaUsuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoUsuario(correoUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return bCryptPasswordEncoder.matches(ContrasenaUsuario, usuario.getContrasenaUsuario());
        }
        return false;
    }
    
    public String encriptarContrasenaUsuario(String contrasenaUsuario){
        return bCryptPasswordEncoder.encode(contrasenaUsuario);
    }
    
    public Optional<Usuario> findByCorreoUsuario(String CorreoUsuario) {
        return usuarioRepository.findByCorreoUsuario(CorreoUsuario);
    }
    
    public boolean checkPassword(Usuario correoUsuario, String rawPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, correoUsuario.getContrasenaUsuario());
    }
    
    public Integer getIdUsuario(){
      return  usuario.getIdUsuario();
    }
    
    
    public String getNombreUsuario(){
        return usuario.getNombreUsuario();
    }
    
    public String getCorreoUsuario(){
        return usuario.getNombreUsuario();
    }
    
    public String getContrasenaUsuario(){
        return usuario.getContrasenaUsuario();
    }
    
            
            
}