/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author paolabolelli
 */

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UserDetailsService userDetailsService;
     
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
     
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    
    // ajustado lo de NombreUsuario por correoUsuario
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoUsuario(usuario.getCorreoUsuario());
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.status(400).body("Ya existe un usuario registrado con ese correo electrónico");
        }
        usuario.setIdUsuario(Integer.valueOf(usuario.getIdUsuario().toString()));
        String contrasenaUsuario = usuario.getContrasenaUsuario();
        String contrasenaEncriptada = customUserDetailsService.encriptarContrasenaUsuario(contrasenaUsuario);
        usuario.setContrasenaUsuario(contrasenaEncriptada);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Registro exitoso");
    }


    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody Usuario usuario, HttpServletResponse response, HttpSession session) throws IOException {
        logger.info("Intento de login con usuario: {}", usuario.getCorreoUsuario());
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoUsuario(usuario.getCorreoUsuario());
        
        boolean isAuthenticated = customUserDetailsService.authenticate(usuario.getCorreoUsuario(), usuario.getContrasenaUsuario());
        
        if (isAuthenticated) {
            Usuario user = usuarioOpt.get();
            
            logger.info("Usuario encontrado: {}", user.getCorreoUsuario());

            // Cargar los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getCorreoUsuario());

            // Establecer el contexto de seguridad
            UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, user.getContrasenaUsuario(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);

            // Guardar el contexto de seguridad en la sesión
           // session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            response.sendRedirect("/protected/juego.html");
        } else {
            logger.error("Usuario o contraseña incorrectos para usuario: {}", usuario.getCorreoUsuario());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    // Crear nuevo usuario
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    // Obtener usuario por correo
    @GetMapping("/correo")
    public Optional<Usuario> obtenerUsuarioPorCorreo(@RequestParam String correoUsuario) {
        return usuarioService.obtenerUsuarioPorCorreo(correoUsuario);
    }

    
}


/* ejemplo Sergi
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UserDetailsService userDetailsService;
     
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
     
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.status(400).body("Usuario ya existe");
        }
        String contraseña = usuario.getContraseña();
        String contraseñaEncriptada = customUserDetailsService.encriptarContraseña(contraseña);
        usuario.setContraseña(contraseñaEncriptada);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Registro exitoso");
    }


    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody Usuario usuario, HttpServletResponse response, HttpSession session) throws IOException {
        logger.info("Intento de login con usuario: {}", usuario.getNombreUsuario());
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
        
        boolean isAuthenticated = customUserDetailsService.authenticate(usuario.getNombreUsuario(), usuario.getContraseña());
        
        if (isAuthenticated) {
            Usuario user = usuarioOpt.get();
            
            logger.info("Usuario encontrado: {}", user.getNombreUsuario());

            // Cargar los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getNombreUsuario());

            // Establecer el contexto de seguridad
            UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, user.getContraseña(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);

            // Guardar el contexto de seguridad en la sesión
           // session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            response.sendRedirect("/protected/protected.html");
        } else {
            logger.error("Usuario o contraseña incorrectos para usuario: {}", usuario.getNombreUsuario());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }
    }
   
}
*/