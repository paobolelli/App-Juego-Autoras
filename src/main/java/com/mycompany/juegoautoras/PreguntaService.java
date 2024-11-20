/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoautoras;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 *
 * @author paolabolelli
 */

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // para poder hacer las consultas sql 
    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    // Obtener todas las preguntas
    public List<Pregunta> obtenerTodasLasPreguntas() {
        return preguntaRepository.findAll();
    }

    // Obtener una pregunta por ID
    public Optional<Pregunta> obtenerPreguntaPorId(Integer id) {
        return preguntaRepository.findById(id);
    }

    // Guardar una nueva pregunta
    public Pregunta guardarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    // UPDATE una pregunta
    public Pregunta actualizarPregunta(Integer id, Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }
    
    // Método para verificar si el usuario existe
    public boolean usuarioExiste(Integer idUsuario) {
        return usuarioRepository.existsById(idUsuario);
    }


    // Método para obtener una pregunta aleatoria
    public Pregunta getPreguntaAleatoria() {
    Random rand = new Random();
    List<Pregunta> preguntas = obtenerTodasLasPreguntas();
    return preguntas.get(rand.nextInt(preguntas.size()));
    }
    
    // método para validar la respuesta (intentando no sufrir con el undefined
    public boolean validarRespuesta(Pregunta pregunta, int respuestaUsuario) {
    if (pregunta == null) {
        System.out.println("La pregunta es null.");
        return false;
    }

    int respuestaCorrecta = pregunta.getRespuestaCorrecta();
    System.out.println("La respuesta que envía el usuario es: " + respuestaUsuario);
    System.out.println("La respuesta correcta a la pregunta es: " + respuestaCorrecta);

    
    // Compara la respuesta del usuario con la respuesta correcta
    return respuestaCorrecta == respuestaUsuario; 
}
    
   }
/* creatividad
    método para validar la respuesta -- también ver preguntaController
    public boolean validarRespuesta(Pregunta pregunta, int respuestaUsuario) {
        System.out.println("La respuesta que envía el usuario es: " + respuestaUsuario);
        System.out.println("La respuesta correcta a la pregunta es: " + pregunta.getRespuestaCorrecta());
        // Compara la respuesta del usuario con la respuesta correcta
        return pregunta.getRespuestaCorrecta() == respuestaUsuario;
    }
*/


/* método para calcular el id_pregunta máximo
    private int getMaxIdPregunta() {
        return jdbcTemplate.queryForObject("SELECT MAX(id_pregunta) FROM preguntas", Integer.class);
    }
 */ 
/* probando para que no devuelva null si no excepciones, esta propuesta hace una lista de NoUsados en vez de 
en vez de seleccionar aleatoria% y verificar si fue usada (comentado el maxIdPregunta)
*/
 
  /* public Pregunta getPreguntaAleatoria(int idUsuario) {
    Random rand = new Random();
*/
/* Consulta para obtener una lista de id de preguntas no utilizadas en la sesión
    List<Integer> idsNoUsados = jdbcTemplate.queryForList(
        "SELECT id_pregunta FROM preguntas WHERE id_pregunta NOT IN " +
        "(SELECT id_pregunta FROM preguntas_usadas WHERE id_sesion = ?)",
        Integer.class,
        idSesion
    );
 */

/*
    // Verificar si hay preguntas disponibles
    if (idsNoUsados.isEmpty()) {
        throw new RuntimeException("No hay más preguntas disponibles para esta sesión.");
    }

    // Seleccionar un ID de pregunta aleatoria de la lista de IDs no utilizados
    Integer randomIndex = rand.nextInt(idsNoUsados.size());
    Integer idPreguntaAleatoria = idsNoUsados.get(randomIndex);

    // Obtener la pregunta correspondiente
    Optional<Pregunta> preguntaOpt = preguntaRepository.findById(idPreguntaAleatoria);

    // Si la pregunta existe, marcarla como utilizada y devolverla
    if (preguntaOpt.isPresent()) {
        Pregunta pregunta = preguntaOpt.get();

        // Guardar la pregunta como utilizada en esta sesión
        jdbcTemplate.update(
            "INSERT INTO preguntas_usadas (id_sesion, id_pregunta) VALUES (?, ?)",
            idSesion,
            idPreguntaAleatoria
        );

        return pregunta;
    }

    // Si no se encuentra la pregunta, lanzar una excepción
    throw new RuntimeException("La pregunta seleccionada no existe.");
}
    
  /*  
    public Pregunta getPreguntaAleatoria(int idSesion) {
        Random rand = new Random();
            
            // generar un id_pregunta random entre 1 y el id_pregunta máximo
            int idPreguntaAleatoria =rand.nextInt(getMaxIdPregunta()) + 1;
            
            // query para comprobar si ya fue usada en la misma sesión
            int count = jdbcTemplate.queryForObject(
                "SELECT count(1) FROM preguntas_usadas WHERE id_sesion=? AND id_pregunta = ?",
                 Integer.class,
                 idSesion,
                 idPreguntaAleatoria
    
            );
            
            // Si no ha sido usada, obtenemos esa
            if (count == 0) {
                Optional<Pregunta> preguntaOpt = preguntaRepository.findById(idPreguntaAleatoria);
                if (preguntaOpt.isPresent()) {
                    Pregunta pregunta = preguntaOpt.get();
                    
                    // Guardar la pregunta como utilizada en esta sesión
                    jdbcTemplate.update(
                        "INSERT INTO preguntas_usadas (id_sesion, id_pregunta) VALUES (?, ?)",
                        idSesion,
                        idPreguntaAleatoria
                    );
           
                    return pregunta;
                    
                }
        }
            return null;  // Retorna null si no hay pregunta disponible
            
    }

*/
    
  
        
